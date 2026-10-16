package com.bytedance.sdk.openadsdk.core.FC.eli;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes3.dex */
public class eli implements Application.ActivityLifecycleCallbacks {
    private static volatile eli eli;
    private final DbA DbA;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private eli(Application application) {
        this.DbA = DbA.eli(application);
    }

    public static eli eli(Application application) {
        if (eli == null) {
            synchronized (eli.class) {
                if (eli == null) {
                    eli = new eli(application);
                    application.registerActivityLifecycleCallbacks(eli);
                }
            }
        }
        return eli;
    }

    public String eli(String str, long j, int i) {
        DbA dbA = this.DbA;
        if (dbA != null) {
            return dbA.eli(str, j, i);
        }
        return "null";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        DbA dbA = this.DbA;
        if (dbA != null) {
            dbA.eli(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        DbA dbA = this.DbA;
        if (dbA != null) {
            dbA.DbA(activity);
        }
    }
}
