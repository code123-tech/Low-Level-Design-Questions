package Questions.RateLimiter.threads;

import Questions.RateLimiter.controller.RateLimiterController;
import Questions.RateLimiter.enums.RateLimiterAlgorithm;
import Questions.RateLimiter.model.RateLimitRule;
import Questions.RateLimiter.model.Request;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Proves the limiter is actually thread safe. A correct limiter configured for N
 * requests per window must allow EXACTLY N when hammered by many threads at once —
 * an unsynchronized read-decide-update will let extra requests through.
 * <p>
 * Every request in a run carries the SAME timestamp, so no window ever rolls mid-run and
 * the expected answer is a hard number rather than a range. Any count above the limit is
 * a lost update, not timing noise — which is what makes this a test and not a demo.
 * </p>
 * <p>
 * To see the race the `synchronized` keyword is preventing: delete `synchronized` from
 * {@code allowRequest} in any strategy and re-run. The count climbs above the limit,
 * intermittently — two threads read the same counter, both decide there is room, and both
 * write back. It will not fail on every run, which is the point: a race that reproduces
 * only sometimes is the reason the keyword goes on before anyone can prove it is needed.
 * </p>
 */
public class ConcurrentClientSimulation {

    private static final String ENDPOINT = "/api/orders";
    private static final long SECOND = 1000L;

    private static final int MAX_REQUESTS = 5;
    private static final int CONCURRENT_REQUESTS = 50;
    private static final int THREAD_COUNT = 20;

    /** Fixed so the window never rolls: every request below lands in the same window. */
    private static final long TIMESTAMP = 0L;

    public static void main(String[] args) throws InterruptedException {

        RateLimitRule fivePerSecond = new RateLimitRule(MAX_REQUESTS, SECOND);

        System.out.printf("Part 1 — %d threads, %d concurrent requests, one client, limit %d%n",
                THREAD_COUNT, CONCURRENT_REQUESTS, MAX_REQUESTS);

        for (RateLimiterAlgorithm algorithm : RateLimiterAlgorithm.values()) {

            RateLimiterController controller = new RateLimiterController(fivePerSecond, algorithm);
            controller.registerClient("client-A", fivePerSecond, algorithm);

            int allowed = hammer(controller, "client-A", CONCURRENT_REQUESTS);

            System.out.printf("  %-23s allowed=%-3d expected=%-3d %s%n",
                    algorithm, allowed, MAX_REQUESTS, allowed == MAX_REQUESTS ? "PASS" : "FAIL");
        }

        System.out.println("\nPart 2 — two clients hammered at once, quotas must stay independent");

        RateLimiterController controller = new RateLimiterController(fivePerSecond, RateLimiterAlgorithm.FIXED_WINDOW_COUNTER);
        controller.registerClient("client-A", fivePerSecond, RateLimiterAlgorithm.FIXED_WINDOW_COUNTER);
        controller.registerClient("client-B", fivePerSecond, RateLimiterAlgorithm.TOKEN_BUCKET);

        AtomicInteger allowedForA = new AtomicInteger();
        AtomicInteger allowedForB = new AtomicInteger();

        Thread threadA = new Thread(() -> allowedForA.set(hammer(controller, "client-A", CONCURRENT_REQUESTS)));
        Thread threadB = new Thread(() -> allowedForB.set(hammer(controller, "client-B", CONCURRENT_REQUESTS)));

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.printf("  client-A allowed=%-3d expected=%-3d %s%n",
                allowedForA.get(), MAX_REQUESTS, allowedForA.get() == MAX_REQUESTS ? "PASS" : "FAIL");
        System.out.printf("  client-B allowed=%-3d expected=%-3d %s%n",
                allowedForB.get(), MAX_REQUESTS, allowedForB.get() == MAX_REQUESTS ? "PASS" : "FAIL");

        System.out.println("\nPart 3 — an unregistered client races onto the default rule");

        RateLimiterController defaulting = new RateLimiterController(fivePerSecond, RateLimiterAlgorithm.FIXED_WINDOW_COUNTER);
        int allowedForUnknown = hammer(defaulting, "client-X", CONCURRENT_REQUESTS);

        // The computeIfAbsent case: with get-then-put, several threads would each build
        // their own strategy for this brand-new id and each decide against a private
        // counter, so the count would exceed the limit even with the strategy itself
        // perfectly synchronized.
        System.out.printf("  client-X allowed=%-3d expected=%-3d %s%n",
                allowedForUnknown, MAX_REQUESTS, allowedForUnknown == MAX_REQUESTS ? "PASS" : "FAIL");
    }

    /**
     * Fires `requestCount` requests at one client from a pool of threads and returns how
     * many were allowed.
     *
     * A start gate holds every task until all of them are submitted and parked, so they are
     * released together. Without it the pool would drain the early tasks while the later
     * ones are still being queued, the calls would barely overlap, and the race this exists
     * to catch would go unobserved.
     */
    private static int hammer(RateLimiterController controller, String clientId, int requestCount) {

        AtomicInteger allowedCount = new AtomicInteger();
        CountDownLatch startGate = new CountDownLatch(1);
        CountDownLatch finished = new CountDownLatch(requestCount);

        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        try {
            for (int i = 0; i < requestCount; i++) {
                pool.execute(() -> {
                    try {
                        startGate.await();
                        if (controller.isAllowed(new Request(clientId, ENDPOINT, TIMESTAMP))) {
                            allowedCount.incrementAndGet();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        finished.countDown();
                    }
                });
            }

            startGate.countDown();
            finished.await(10, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            pool.shutdown();
        }

        return allowedCount.get();
    }
}
