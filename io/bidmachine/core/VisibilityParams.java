package io.bidmachine.core;

import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class VisibilityParams {
    public static final boolean DEF_IGNORE_OVERLAP = false;
    public static final boolean DEF_IGNORE_WINDOW_FOCUS = false;
    public static final float DEF_PIXEL_THRESHOLD = 1.0f;
    public static final long DEF_TIME_THRESHOLD_SEC = 1;
    private long timeThresholdMs = TimeUnit.SECONDS.toMillis(1);
    private float pixelThreshold = 1.0f;
    private boolean ignoreWindowFocus = false;
    private boolean ignoreOverlap = false;

    public long getTimeThresholdMs() {
        return this.timeThresholdMs;
    }

    public void setTimeThresholdSec(long timeThresholdSec) {
        setTimeThresholdMs(TimeUnit.SECONDS.toMillis(timeThresholdSec));
    }

    public void setTimeThresholdMs(long timeThresholdMs) {
        this.timeThresholdMs = timeThresholdMs;
    }

    public float getPixelThreshold() {
        return this.pixelThreshold;
    }

    public void setPixelThreshold(float pixelThreshold) {
        this.pixelThreshold = pixelThreshold;
    }

    public boolean isIgnoreWindowFocus() {
        return this.ignoreWindowFocus;
    }

    public void setIgnoreWindowFocus(boolean ignoreWindowFocus) {
        this.ignoreWindowFocus = ignoreWindowFocus;
    }

    public boolean isIgnoreOverlap() {
        return this.ignoreOverlap;
    }

    public void setIgnoreOverlap(boolean ignoreOverlap) {
        this.ignoreOverlap = ignoreOverlap;
    }
}
