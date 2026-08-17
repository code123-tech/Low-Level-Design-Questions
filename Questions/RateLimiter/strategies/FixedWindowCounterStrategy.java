package Questions.RateLimiter.strategies;

import Questions.RateLimiter.model.RateLimitRule;

/**
 * One counter per fixed clock window. Simplest to implement, but allows up to 2x the
 * limit across a window boundary (all requests at the end of one window plus all at
 * the start of the next).
 *
 * The window is derived from the timestamp rather than tracked with a timer:
 * `timestamp / windowSizeInMillis` buckets all of wall-clock time into consecutive slots
 * of the configured size, so window 0 is [0, 1000), window 1 is [1000, 2000), and so on.
 * That single division is the whole algorithm — no scheduled reset, no background thread.
 *
 * Windows are aligned to the epoch, NOT to the client's first request. Two clients that
 * start 900ms apart still roll over at the same instant. That alignment is what makes the
 * boundary burst deterministic and worth reasoning about: fire maxRequests at t=999 and
 * maxRequests again at t=1000 and 2x the limit gets through in 2ms, all of it legal by
 * this algorithm's own accounting. Sliding window log and sliding window counter exist to
 * close exactly that hole.
 */
public class FixedWindowCounterStrategy implements RateLimiterStrategy {

    private final RateLimitRule rule;

    /** Sentinel: no window seen yet. Real windows are >= 0 for any epoch timestamp. */
    private long currentWindow;
    private int requestCountInWindow;

    public FixedWindowCounterStrategy(RateLimitRule rule) {
        this.rule = rule;

        this.currentWindow = -1L;
        this.requestCountInWindow = 0;
    }

    /**
     * One critical section: roll, test and increment have to be indivisible, or two threads
     * both read the same count below the limit and both get in.
     *
     * Guarded on `this`, and each client owns its own instance, so clients never contend.
     */
    @Override
    public synchronized boolean allowRequest(long requestTimestampInMillis) {

        rollWindow(requestTimestampInMillis / rule.windowSizeInMillis());

        if (requestCountInWindow < rule.maxRequests()) {
            requestCountInWindow++;
            return true;
        }

        return false;
    }

    /**
     * Resets the counter when time has moved into a later window.
     *
     * Deliberately `>` and not `!=`. Timestamps arrive as a parameter and are not
     * guaranteed monotonic, and under `!=` a single stale timestamp from an earlier window
     * would zero the counter and hand the client a fresh quota — a replayed timestamp
     * becomes a quota bypass. Under `>` a late request simply counts against the window
     * that is currently open, which costs the client nothing it was owed.
     */
    private void rollWindow(long window) {

        if (window <= currentWindow) {
            return;
        }

        currentWindow = window;
        requestCountInWindow = 0;
    }
}
