package io.voodoo.tools;

/* loaded from: classes8.dex */
public class LoadingTimeTracker {
    public static long activityStartTime = -1;
    public static long startTime;
    public static long totalPauseTime;

    public static long getStartTimestamp() {
        return startTime;
    }

    public static long getActivityStartTimestamp() {
        return activityStartTime;
    }

    public static long getTotalNativePauseTime() {
        return totalPauseTime;
    }
}
