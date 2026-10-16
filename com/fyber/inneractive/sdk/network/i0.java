package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f1323a;
    public final /* synthetic */ k0 b;

    public i0(k0 k0Var, s0 s0Var) {
        this.b = k0Var;
        this.f1323a = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.e("retryNetworkRequest pre-execute - %s", this.f1323a.getClass().getName());
        this.b.b(this.f1323a);
    }
}
