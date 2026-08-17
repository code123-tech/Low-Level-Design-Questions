package Questions.RateLimiter.controller;

import Questions.RateLimiter.Factory.RateLimiterFactory;
import Questions.RateLimiter.enums.RateLimiterAlgorithm;
import Questions.RateLimiter.model.RateLimitRule;
import Questions.RateLimiter.model.Request;
import Questions.RateLimiter.strategies.RateLimiterStrategy;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Orchestration: owns per-client strategy state, and answers the one question callers
 * care about — allow this request or not?
 *
 * The rule is NOT stored here. Each strategy is constructed with its own rule and keeps
 * it, so this class holds exactly one map and there is a single source of truth for a
 * client's limit.
 *
 * Thread safety: state lives in a ConcurrentHashMap and each strategy guards its own
 * fields, so there is no single global lock on the hot path.
 */
public class RateLimiterController {

    private final Map<String, RateLimiterStrategy> limitersByClient = new ConcurrentHashMap<>();

    /** Applied to any client that was never explicitly registered. */
    private final RateLimitRule defaultRule;
    private final RateLimiterAlgorithm defaultAlgorithm;

    public RateLimiterController(RateLimitRule defaultRule, RateLimiterAlgorithm defaultAlgorithm) {
        this.defaultRule = Objects.requireNonNull(defaultRule, "defaultRule must not be null");
        this.defaultAlgorithm = Objects.requireNonNull(defaultAlgorithm, "defaultAlgorithm must not be null");
    }

    public void registerClient(String clientId, RateLimitRule rule, RateLimiterAlgorithm algorithm) {
        limitersByClient.put(clientId, RateLimiterFactory.getRateLimiter(algorithm, rule));
    }

    /**
     * computeIfAbsent rather than get-then-put, because the naive version is a
     * correctness bug and not merely wasteful: two threads racing on a new clientId both
     * see null, both build a strategy, and each then decides using its OWN fresh bucket.
     * The client silently gets double quota for that instant. computeIfAbsent applies the
     * mapping function at most once per key and hands every caller the same instance.
     *
     * Note allowRequest is called OUTSIDE the mapping function. ConcurrentHashMap holds a
     * bin lock while that function runs, so it must stay short — construction only. Making
     * the allow/reject decision in there would serialize every client that hashes to the
     * same bin, turning the map into the bottleneck the per-client design exists to avoid.
     */
    public boolean isAllowed(Request request) {

        RateLimiterStrategy limiter = limitersByClient.computeIfAbsent(request.getClientId(),
                clientId -> RateLimiterFactory.getRateLimiter(defaultAlgorithm, defaultRule));

        return limiter.allowRequest(request.getTimestampInMillis());
    }

    // TODO: eviction is now load-bearing, not a nice-to-have. Every unseen clientId
    //  creates a permanent map entry, so a caller rotating client ids grows this map
    //  without bound — memory exhaustion via the default-rule path. Bound it with an
    //  idle TTL or a max-size cache before this goes anywhere near untrusted input.

    // TODO: add remainingQuota(clientId) and windowResetTime(clientId) once the
    //  strategies expose their internal counters — needed for Retry-After headers.
}
