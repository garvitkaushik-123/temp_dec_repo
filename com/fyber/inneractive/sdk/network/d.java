package com.fyber.inneractive.sdk.network;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes4.dex */
public final class d implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1315a;

    public d(f fVar) {
        this.f1315a = fVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        f fVar = this.f1315a;
        com.fyber.inneractive.sdk.util.b1 b1Var = fVar.d;
        if (b1Var != null) {
            b1Var.post(new c(fVar, 20150330, 3500L));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.fyber.inneractive.sdk.util.b1 b1Var = this.f1315a.d;
        if (b1Var != null) {
            b1Var.removeMessages(20150330);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
