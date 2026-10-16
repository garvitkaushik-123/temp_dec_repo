package com.fyber.inneractive.sdk.config;

import android.content.Context;

/* loaded from: classes4.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f1133a;

    public z(a0 a0Var) {
        this.f1133a = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1133a.f1069a.K = new com.fyber.inneractive.sdk.measurement.e();
        a0 a0Var = this.f1133a;
        com.fyber.inneractive.sdk.measurement.e eVar = a0Var.f1069a.K;
        Context context = a0Var.b;
        if (eVar.f1268a) {
            return;
        }
        eVar.f1268a = true;
        com.fyber.inneractive.sdk.util.r.b.post(new com.fyber.inneractive.sdk.measurement.d(eVar, context));
    }
}
