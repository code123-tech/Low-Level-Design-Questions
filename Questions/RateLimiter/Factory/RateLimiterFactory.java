package Questions.RateLimiter.Factory;

import Questions.RateLimiter.enums.RateLimiterAlgorithm;
import Questions.RateLimiter.model.RateLimitRule;
import Questions.RateLimiter.strategies.FixedWindowCounterStrategy;
import Questions.RateLimiter.strategies.LeakyBucketStrategy;
import Questions.RateLimiter.strategies.RateLimiterStrategy;
import Questions.RateLimiter.strategies.SlidingWindowCounterStrategy;
import Questions.RateLimiter.strategies.SlidingWindowLogStrategy;
import Questions.RateLimiter.strategies.TokenBucketStrategy;

/**
 * Maps an algorithm enum to its strategy.
 *
 * Note: unlike SplitFactory, instances are NOT cached/shared here — each call returns a
 * fresh strategy because every instance carries one client's mutable state. Sharing one
 * instance across clients would pool their quotas together.
 */
public class RateLimiterFactory {

    public static RateLimiterStrategy getRateLimiter(RateLimiterAlgorithm algorithm, RateLimitRule rule) {

        return switch (algorithm) {
            case TOKEN_BUCKET -> new TokenBucketStrategy(rule);
            case LEAKY_BUCKET -> new LeakyBucketStrategy(rule);
            case FIXED_WINDOW_COUNTER -> new FixedWindowCounterStrategy(rule);
            case SLIDING_WINDOW_LOG -> new SlidingWindowLogStrategy(rule);
            case SLIDING_WINDOW_COUNTER -> new SlidingWindowCounterStrategy(rule);
        };

    }
}
