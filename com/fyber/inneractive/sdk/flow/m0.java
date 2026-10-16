package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.s1;
import com.fyber.inneractive.sdk.util.t1;

/* loaded from: classes4.dex */
public final class m0 implements s1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f1211a;

    public m0(n0 n0Var) {
        this.f1211a = n0Var;
    }

    @Override // com.fyber.inneractive.sdk.util.s1
    public final void a() {
        Runnable runnable = this.f1211a.n;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.post(runnable);
        }
        n0 n0Var = this.f1211a;
        t1 t1Var = n0Var.o;
        if (t1Var != null) {
            t1Var.e = null;
            n0Var.o = null;
        }
    }
}
