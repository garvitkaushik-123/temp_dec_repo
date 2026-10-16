package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ea implements Ia {

    /* renamed from: a, reason: collision with root package name */
    private final Da f2847a;

    public Ea(Da strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f2847a = strategy;
    }

    @Override // com.ironsource.Ia
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f2847a.a("Received load success before load called");
    }

    @Override // com.ironsource.Ia
    public void b() {
        M2 a2 = this.f2847a.i().a(true);
        this.f2847a.a(a2);
        Da da = this.f2847a;
        da.a(new Ha(da, a2));
        a2.a(this.f2847a.g());
    }

    @Override // com.ironsource.Ia
    public void c() {
        M2 k = this.f2847a.k();
        if (k != null) {
            k.a(false);
        }
        this.f2847a.a((M2) null);
        Da da = this.f2847a;
        da.a(new Fa(da));
    }

    @Override // com.ironsource.Ia
    public void a(IronSourceError ironSourceError) {
        this.f2847a.a("Received load failed before load called");
    }
}
