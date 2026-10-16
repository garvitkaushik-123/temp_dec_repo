package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.s1;
import com.fyber.inneractive.sdk.util.t1;

/* loaded from: classes4.dex */
public final class l0 implements s1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f1210a;

    public l0(n0 n0Var) {
        this.f1210a = n0Var;
    }

    @Override // com.fyber.inneractive.sdk.util.s1
    public final void a() {
        com.fyber.inneractive.sdk.util.r.b.post(this.f1210a.l);
        n0 n0Var = this.f1210a;
        t1 t1Var = n0Var.m;
        if (t1Var != null) {
            t1Var.e = null;
            n0Var.m = null;
        }
        n0Var.q = false;
    }
}
