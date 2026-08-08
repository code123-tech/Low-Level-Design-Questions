package Questions.RateLimiter.strategies;

import Questions.RateLimiter.model.RateLimitRule;

/**
 * Leaky bucket as a METER (counter-based), not as a queue.
 *
 * Water level rises by 1 per accepted request and drains at a constant
 * maxRequests/windowSize. A request that would overflow the rim is rejected. The level is
 * just a number — no request is ever actually held anywhere.
 *
 * Why the meter and not the shaper: the queue-based leaky bucket does not reject excess
 * requests, it DELAYS them, so "accepted" means "queued, will run in 340ms". A
 * `boolean allowRequest(long)` has nowhere to put that delay, so this interface can only
 * express the meter. Implementing the shaper means changing the abstraction — see the
 * "soft limiting" item in the README's scope-of-improvement.
 *
 * Expect this to behave EXACTLY like TokenBucketStrategy. That is not a bug. Substitute
 * level = capacity - tokens and the two are the same algorithm with the signs flipped:
 *
 *     tokens starts at capacity        <->  level starts at 0
 *     allow if tokens >= 1             <->  allow if level + 1 <= capacity
 *     tokens -= 1                      <->  level += 1
 *     tokens = min(cap, tokens + e*r)  <->  level = max(0, level - e*r)
 *
 * The genuine behavioural difference between the two algorithms lives entirely in the
 * queueing of the shaper variant, not in this accounting.
 */
public class LeakyBucketStrategy implements RateLimiterStrategy {

    private final RateLimitRule rule;

    /** Precomputed so the hot path does no division. */
    private final double leakUnitsPerMilli;

    private double currentWaterLevel;
    private long lastLeakTimestamp;

    public LeakyBucketStrategy(RateLimitRule rule) {
        this.rule = rule;
        this.leakUnitsPerMilli = (double) rule.maxRequests() / rule.windowSizeInMillis();

        this.currentWaterLevel = 0.0;
        this.lastLeakTimestamp = 0;
    }

    /**
     * One critical section: leak, test and add have to be indivisible, or two threads both
     * see room for the last unit and both get in.
     *
     * Guarded on `this`, and each client owns its own instance, so clients never contend.
     */
    @Override
    public synchronized boolean allowRequest(long requestTimestampInMillis) {

        leak(requestTimestampInMillis);

        if(currentWaterLevel + 1.0 <= rule.maxRequests()) {
            currentWaterLevel += 1.0;
            return true;
        }

        return false;
    }

    /**
     * Drains the volume that has leaked out since the last update, floored at zero so an
     * idle client cannot bank unlimited credit.
     *
     * Only advances when time actually moved forward: timestamps arrive as a parameter and
     * are not guaranteed monotonic, so a stale one would otherwise ADD water, and letting
     * lastLeakTimestamp walk backwards would over-drain on the next in-order request.
     *
     * Level is a double because a partial window leaks a fraction of a unit; truncating to
     * an int would discard that remainder on every call and systematically under-drain,
     * holding the client below its configured rate.
     */
    private void leak(long requestTimestampInMillis) {

        if(requestTimestampInMillis <= lastLeakTimestamp) {
            return;
        }

        double leaked = (requestTimestampInMillis - lastLeakTimestamp) * leakUnitsPerMilli;
        currentWaterLevel = Math.max(0.0, currentWaterLevel - leaked);
        lastLeakTimestamp = requestTimestampInMillis;
    }
}
