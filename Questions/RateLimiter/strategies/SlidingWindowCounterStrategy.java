package Questions.RateLimiter.strategies;

import Questions.RateLimiter.model.RateLimitRule;

/**
 * Weighted blend of the previous and current fixed windows — approximates the sliding
 * window log using two counters instead of a full timestamp list.
 *
 * The idea: at any instant the true trailing window overlaps part of the previous fixed
 * window and all of the current one. Rather than remembering WHEN the previous window's
 * requests happened, assume they were spread evenly across it, and charge the client the
 * fraction of that window still in view:
 *
 *     overlap   = 1 - (elapsed in current window / window size)
 *     estimated = previousWindowCount * overlap + currentWindowCount
 *
 * At 300ms into a 1000ms window, 70% of the previous window is still inside the trailing
 * window, so 70% of its requests still count. As the current window advances the previous
 * window's contribution decays smoothly to zero, which is what removes the fixed-window
 * boundary burst — at t=1000 the earlier window is still charged at ~100%, not discarded.
 *
 * The approximation is the even-spread assumption, and it can err in both directions. A
 * client that fired its whole previous quota in that window's first millisecond is charged
 * for requests that have genuinely aged out (rejected when the log would allow); one that
 * fired at the very end is undercharged (allowed when the log would reject). Bounded error,
 * two ints of state per client instead of maxRequests timestamps — the trade this
 * algorithm exists to make.
 */
public class SlidingWindowCounterStrategy implements RateLimiterStrategy {

    private final RateLimitRule rule;

    /** Sentinel: no window seen yet. Real windows are >= 0 for any epoch timestamp. */
    private long currentWindow;
    private int previousWindowCount;
    private int currentWindowCount;

    public SlidingWindowCounterStrategy(RateLimitRule rule) {
        this.rule = rule;

        this.currentWindow = -1L;
        this.previousWindowCount = 0;
        this.currentWindowCount = 0;
    }

    /**
     * One critical section: roll, estimate and increment have to be indivisible, or two
     * threads both compute the same estimate below the limit and both get in.
     *
     * Guarded on `this`, and each client owns its own instance, so clients never contend.
     */
    @Override
    public synchronized boolean allowRequest(long requestTimestampInMillis) {

        rollWindow(requestTimestampInMillis / rule.windowSizeInMillis());

        long elapsedInCurrentWindow = requestTimestampInMillis - (currentWindow * rule.windowSizeInMillis());
        double overlap = 1.0 - ((double) elapsedInCurrentWindow / rule.windowSizeInMillis());

        double estimatedCount = (previousWindowCount * overlap) + currentWindowCount;

        if (estimatedCount < rule.maxRequests()) {
            currentWindowCount++;
            return true;
        }

        return false;
    }

    /**
     * Shifts the counters forward when time has moved into a later window.
     *
     * Three cases, and the third is the one that is easy to get wrong:
     *  - same window        -> nothing moves
     *  - the very next one  -> current becomes previous, current resets
     *  - a later one still  -> the client was idle for at least one whole window, so the
     *                          window now behind us saw zero requests. Carrying the old
     *                          count forward as `previous` would charge a client for
     *                          traffic that is minutes stale.
     *
     * `>` and not `!=`, for the same reason as FixedWindowCounterStrategy: timestamps
     * arrive as a parameter and are not guaranteed monotonic, and rolling backwards on a
     * stale one would zero the counters and hand out a fresh quota.
     */
    private void rollWindow(long window) {

        if (window <= currentWindow) {
            return;
        }

        previousWindowCount = (window == currentWindow + 1) ? currentWindowCount : 0;
        currentWindowCount = 0;
        currentWindow = window;
    }
}
