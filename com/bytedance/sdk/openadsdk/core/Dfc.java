package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* loaded from: classes3.dex */
public class Dfc {
    private boolean DbA;
    private final com.bytedance.sdk.openadsdk.utils.eli eli = new com.bytedance.sdk.openadsdk.utils.eli();

    public static Dfc eli() {
        return eli.eli;
    }

    private static class eli {
        private static final Dfc eli = new Dfc();
    }

    public void DbA() {
        try {
            Context eli2 = dV.eli();
            if (eli2 instanceof Application) {
                ((Application) eli2).registerActivityLifecycleCallbacks(this.eli);
                this.DbA = true;
            } else {
                if (eli2 == null || eli2.getApplicationContext() == null) {
                    return;
                }
                ((Application) eli2.getApplicationContext()).registerActivityLifecycleCallbacks(this.eli);
                this.DbA = true;
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th);
        }
    }

    public boolean Os() {
        return this.DbA;
    }

    public boolean aGH() {
        return this.eli.eli();
    }

    public boolean eli(boolean z) {
        return this.eli.eli(z);
    }

    public com.bytedance.sdk.openadsdk.utils.eli ui() {
        return this.eli;
    }
}
