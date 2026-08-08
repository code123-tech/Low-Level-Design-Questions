package Questions.RateLimiter;

import Questions.RateLimiter.controller.RateLimiterController;
import Questions.RateLimiter.enums.RateLimiterAlgorithm;
import Questions.RateLimiter.model.RateLimitRule;
import Questions.RateLimiter.model.Request;

/**
 * Driver that exercises the design. Reads as a script: register clients, fire
 * requests, print each allow/reject decision.
 * <p>
 * Time here is simulated, not real. Every Request carries its own timestamp, so a
 * window is rolled forward by adding to a long instead of calling Thread.sleep() —
 * the demo stays deterministic and finishes instantly. That is the payoff of taking
 * the timestamp as a parameter rather than reading the clock inside the strategy.
 * </p>
 */
public class Main {

    private static final String ENDPOINT = "/api/orders";
    private static final long SECOND = 1000L;

    public static void main(String[] args) {

        // One immutable rule, shared by every client: 5 requests per second.
        // Sharing is safe precisely because RateLimitRule holds no mutable state.
        RateLimitRule fivePerSecond = new RateLimitRule(5, SECOND);

        // The rule and algorithm applied to any client that was never registered.
        RateLimiterController controller = new RateLimiterController(fivePerSecond, RateLimiterAlgorithm.FIXED_WINDOW_COUNTER);

        controller.registerClient("client-A", fivePerSecond, RateLimiterAlgorithm.FIXED_WINDOW_COUNTER);
        controller.registerClient("client-B", fivePerSecond, RateLimiterAlgorithm.FIXED_WINDOW_COUNTER);
        controller.registerClient("client-C", fivePerSecond, RateLimiterAlgorithm.TOKEN_BUCKET);

        long start = 0L;

        System.out.println("Scenario 1 — burst of 8 against a limit of 5 (expect 5 allowed, 3 rejected)");
        fire(controller, "client-A", 8, start);

        System.out.println("\nScenario 2 — client-A again, still inside the same window (expect all rejected)");
        fire(controller, "client-A", 2, start + 200);

        System.out.println("\nScenario 3 — client-B is untouched by client-A's exhausted quota (expect all allowed)");
        fire(controller, "client-B", 3, start);

        System.out.println("\nScenario 4 — client-A after the window rolls over (expect all allowed)");
        fire(controller, "client-A", 3, start + SECOND);

        System.out.println("\nScenario 5 — same driver code, TOKEN_BUCKET instead of FIXED_WINDOW_COUNTER");
        fire(controller, "client-C", 5, start);           // drains the bucket
        fire(controller, "client-C", 1, start + 200);     // refilled 1 token by now -> allowed,
                                                           // where client-A was rejected at t=200

        System.out.println("\nScenario 6 — client-X was never registered, so the default rule applies");
        fire(controller, "client-X", 6, start);
    }

    private static void fire(RateLimiterController controller, String clientId, int count, long timestamp) {

        for (int i = 1; i <= count; i++) {
            Request request = new Request(clientId, ENDPOINT, timestamp);
            boolean allowed = controller.isAllowed(request);
            System.out.printf("  %s  t=%-5d request %d -> %s%n", clientId, timestamp, i, allowed ? "ALLOWED" : "REJECTED");
        }
    }
}
