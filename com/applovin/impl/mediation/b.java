package com.applovin.impl.mediation;

import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.impl.q2;
import com.applovin.impl.sdk.k;
import com.applovin.impl.z2;
import com.applovin.sdk.AppLovinSdkUtils;

/* loaded from: classes2.dex */
public class b implements a.InterfaceC0096a, c.a {

    /* renamed from: a, reason: collision with root package name */
    private final k f574a;
    private final a b;
    private final c c;

    public b(k kVar) {
        this.f574a = kVar;
        this.b = new a(kVar);
        this.c = new c(kVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(z2 z2Var) {
        h A;
        if (z2Var == null || (A = z2Var.A()) == null || !z2Var.w().compareAndSet(false, true)) {
            return;
        }
        q2.e(A.c(), z2Var);
    }

    public void a() {
        this.c.a();
        this.b.a();
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0096a
    public void b(final z2 z2Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.this.c(z2Var);
            }
        }, z2Var.g0());
    }

    public void e(z2 z2Var) {
        long h0 = z2Var.h0();
        if (h0 >= 0) {
            this.c.a(z2Var, h0);
        }
        if (z2Var.r0() || z2Var.s0()) {
            this.b.a(z2Var, this);
        }
    }

    @Override // com.applovin.impl.mediation.c.a
    public void a(z2 z2Var) {
        c(z2Var);
    }
}
