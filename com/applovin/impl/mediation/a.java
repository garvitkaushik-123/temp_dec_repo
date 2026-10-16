package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.k7;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;
import com.applovin.impl.z2;

/* loaded from: classes2.dex */
public class a extends com.applovin.impl.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.c f563a;
    private final o b;
    private final String c;
    private InterfaceC0096a d;
    private z2 e;
    private String f;

    /* renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    public interface InterfaceC0096a {
        void b(z2 z2Var);
    }

    a(k kVar) {
        this.b = kVar.O();
        this.f563a = kVar.e();
        this.c = k7.a(k.o(), "AdActivityObserver", kVar);
    }

    public void a(z2 z2Var, InterfaceC0096a interfaceC0096a) {
        if (o.a()) {
            this.b.a("AdActivityObserver", "Starting for ad " + z2Var.getAdUnitId() + "...");
        }
        a();
        this.d = interfaceC0096a;
        this.e = z2Var;
        this.f563a.a(this);
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (!activity.getClass().getName().equals(this.c) || !this.e.s0()) {
            if (this.f == null) {
                this.f = activity.getClass().getName();
                if (o.a()) {
                    this.b.a("AdActivityObserver", "Started tracking ad Activity: " + this.f);
                    return;
                }
                return;
            }
            return;
        }
        if (o.a()) {
            this.b.a("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
        }
        if (this.d != null) {
            if (o.a()) {
                this.b.a("AdActivityObserver", "Invoking callback...");
            }
            this.d.b(this.e);
        }
        a();
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity.getClass().getName().equals(this.f)) {
            if (o.a()) {
                this.b.a("AdActivityObserver", "Ad Activity destroyed: " + this.f);
            }
            if (this.d != null) {
                if (o.a()) {
                    this.b.a("AdActivityObserver", "Invoking callback...");
                }
                this.d.b(this.e);
            }
            a();
        }
    }

    public void a() {
        if (o.a()) {
            this.b.a("AdActivityObserver", "Cancelling...");
        }
        this.f563a.b(this);
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
