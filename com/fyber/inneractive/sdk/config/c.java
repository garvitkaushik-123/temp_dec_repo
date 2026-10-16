package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes4.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1072a;

    public c(e eVar) {
        this.f1072a = eVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f1072a.e.hasMessages(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) || this.f1072a.f1080a.get()) {
            return;
        }
        this.f1072a.e.sendEmptyMessageDelayed(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 3000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.fyber.inneractive.sdk.cache.session.g gVar;
        this.f1072a.e.removeMessages(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        e eVar = this.f1072a;
        if (eVar.f1080a.compareAndSet(true, false)) {
            if (eVar.b) {
                IAlog.a("onActivityResumed: restartSession", new Object[0]);
                eVar.b = false;
                x0 x0Var = eVar.d;
                if (x0Var != null) {
                    com.fyber.inneractive.sdk.cache.session.e eVar2 = x0Var.f1132a;
                    if (eVar2 != null) {
                        com.fyber.inneractive.sdk.cache.session.i iVar = eVar2.f1050a;
                        for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
                            if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE && (gVar = (com.fyber.inneractive.sdk.cache.session.g) iVar.f1054a.get(cVar)) != null && gVar.f1053a != 0) {
                                eVar2.a(cVar, gVar);
                            }
                        }
                        com.fyber.inneractive.sdk.util.r.f1777a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar2, com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION, com.fyber.inneractive.sdk.cache.session.enums.c.NONE));
                    }
                    eVar.d.c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                    eVar.d.b.clear();
                }
            }
            t1 t1Var = eVar.c;
            if (t1Var != null) {
                t1Var.d = false;
                t1Var.f = 0L;
                r1 r1Var = t1Var.c;
                if (r1Var != null) {
                    r1Var.removeMessages(1932593528);
                }
            }
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
