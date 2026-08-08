package Questions.RateLimiter.strategies;

import Questions.RateLimiter.model.RateLimitRule;

/**
 * Bucket holds up to `maxRequests` tokens and refills at maxRequests/windowSize.
 * A request consumes one token; no token means reject. Allows bursts up to capacity.
 *
 * Capacity controls how large a burst is tolerated; the refill rate controls the
 * sustained long-run average. Two independent knobs — which is what this algorithm
 * offers over a window counter, where one number has to do both jobs.
 *
 * There is no background thread topping the bucket up. The refill is computed on
 * arrival from the elapsed time, which is mathematically identical to continuous
 * dripping and costs O(1) with no timers.
 */
public class TokenBucketStrategy implements RateLimiterStrategy {

    private final RateLimitRule rule;

    /** Precomputed so the hot path does no division. */
    private final double refillTokensPerMilli;

    private double availableTokens;
    private long lastRefillTimestamp;

    public TokenBucketStrategy(RateLimitRule rule) {
        this.rule = rule;
        this.refillTokensPerMilli = (double) rule.maxRequests() / rule.windowSizeInMillis();

        // Start full: a brand-new client should be able to burst immediately rather than
        // have its very first request rejected.
        this.availableTokens = rule.maxRequests();
        this.lastRefillTimestamp = 0L;
    }

    /**
     * Whole method is one critical section: refill, test and consume have to be indivisible.
     * Two threads interleaving between the test and the decrement would both see the last
     * token and both be allowed.
     *
     * Guarded on `this`, and each client owns its own instance, so two different clients
     * never contend — the lock is per client, not global.
     */
    @Override
    public synchronized boolean allowRequest(long requestTimestampInMillis) {

        refill(requestTimestampInMillis);

        if (availableTokens >= 1.0) {
            availableTokens -= 1.0;
            return true;
        }

        return false;
    }

    /**
     * Credits the tokens earned since the last refill, capped at capacity so an idle
     * client cannot bank unlimited credit.
     *
     * Only advances when time actually moved forward. Timestamps arrive as a parameter,
     * so nothing guarantees they are monotonic: subtracting a later `lastRefillTimestamp`
     * would credit negative tokens, and letting the field walk backwards would make the
     * next in-order request over-refill.
     *
     * Tokens are a double on purpose. A partial window earns a fraction of a token
     * (150ms at 5/1000ms earns 0.75), and truncating that to an int would discard the
     * remainder on every call — systematically under-refilling below the configured rate.
     * Keeping the fraction is also what makes it safe to advance lastRefillTimestamp here
     * even when the request ends up rejected.
     */
    private void refill(long requestTimestampInMillis) {

        if (requestTimestampInMillis <= lastRefillTimestamp) {
            return;
        }

        double tokensToAdd = (requestTimestampInMillis - lastRefillTimestamp) * refillTokensPerMilli;

        availableTokens = Math.min(rule.maxRequests(), availableTokens + tokensToAdd);
        lastRefillTimestamp = requestTimestampInMillis;
    }
}
