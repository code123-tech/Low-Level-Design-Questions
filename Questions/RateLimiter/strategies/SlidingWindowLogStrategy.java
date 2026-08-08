package Questions.RateLimiter.strategies;

import Questions.RateLimiter.model.RateLimitRule;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Keeps a timestamp per recent request. Evict everything older than the window, then
 * count what remains. Exact — no boundary burst — but memory grows with request rate.
 *
 * This is the only algorithm here that is exactly right. The window it enforces is the
 * true trailing window ending at the current request, not a fixed slot the client shares
 * with the clock, so the fixed-window 2x boundary burst simply cannot happen: fire
 * maxRequests at t=999 and the log still holds all of them at t=1000, and the next
 * request is rejected.
 *
 * What it costs is memory that scales with the allowed rate rather than being constant:
 * O(maxRequests) longs per client, live for a full window, times every client the
 * controller has ever seen. At 10k requests/min/client that is 10k timestamps held per
 * client — which is exactly why SlidingWindowCounterStrategy exists, trading this
 * exactness for two ints.
 *
 * A Deque and not a List: eviction is always from the head and insertion always at the
 * tail, both O(1) on ArrayDeque, where ArrayList.remove(0) would shift every element.
 */
public class SlidingWindowLogStrategy implements RateLimiterStrategy {

    private final RateLimitRule rule;

    /** Ascending by timestamp, so eviction can stop at the first entry still in window. */
    private final Deque<Long> requestTimestamps = new ArrayDeque<>();

    public SlidingWindowLogStrategy(RateLimitRule rule) {
        this.rule = rule;
    }

    /**
     * One critical section: evict, count and append have to be indivisible, or two threads
     * both see size() below the limit and both append.
     *
     * Guarded on `this`, and each client owns its own instance, so clients never contend.
     */
    @Override
    public synchronized boolean allowRequest(long requestTimestampInMillis) {

        evictExpired(requestTimestampInMillis);

        if (requestTimestamps.size() < rule.maxRequests()) {
            requestTimestamps.addLast(requestTimestampInMillis);
            return true;
        }

        return false;
    }

    /**
     * Drops every timestamp that has fallen out of the trailing window.
     *
     * The deque is ascending, so the first entry that is still inside the window means
     * every entry behind it is too — the loop can stop there instead of scanning the rest.
     * That is what keeps the amortised cost O(1) per request despite the worst case being
     * O(maxRequests): each timestamp is appended once and evicted once, ever.
     *
     * The boundary is `<=`, treating the window as half-open (windowStart, timestamp]. A
     * request exactly one window old has served its full window and no longer counts.
     *
     * Note this only appends in timestamp order if callers hand over roughly ordered
     * timestamps. An out-of-order arrival breaks the ascending invariant the early stop
     * relies on — a real deployment reading System.currentTimeMillis() at the call site
     * gets that ordering for free, but a distributed limiter receiving client-supplied
     * timestamps would need a sorted structure instead.
     */
    private void evictExpired(long requestTimestampInMillis) {

        long windowStart = requestTimestampInMillis - rule.windowSizeInMillis();

        while (!requestTimestamps.isEmpty() && requestTimestamps.peekFirst() <= windowStart) {
            requestTimestamps.pollFirst();
        }
    }
}
