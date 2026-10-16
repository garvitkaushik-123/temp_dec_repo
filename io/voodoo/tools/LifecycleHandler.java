package io.voodoo.tools;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes8.dex */
public class LifecycleHandler implements Application.ActivityLifecycleCallbacks {
    private static long pauseTimestamp;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getLocalClassName().toLowerCase().contains("UnityPlayerActivity".toLowerCase()) || activity.getLocalClassName().toLowerCase().contains("MessagingUnityPlayerActivity".toLowerCase())) {
            LoadingTimeTracker.activityStartTime = System.currentTimeMillis();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (pauseTimestamp > 0) {
            LoadingTimeTracker.totalPauseTime += System.currentTimeMillis() - pauseTimestamp;
            pauseTimestamp = 0L;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        pauseTimestamp = System.currentTimeMillis();
    }
}
