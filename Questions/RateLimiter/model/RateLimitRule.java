package Questions.RateLimiter.model;

/**
 * The limit configured for a client: "maxRequests allowed per windowSizeInMillis".
 * <p>
 * TODO: extend as the design grows —
 *  - burst capacity separate from steady rate (token bucket needs both)
 *  - per-endpoint overrides
 *  - client tier (FREE / PAID) so rules can be looked up by tier instead of per client
 */
public record RateLimitRule(int maxRequests, long windowSizeInMillis) {

}
