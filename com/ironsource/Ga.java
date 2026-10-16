package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ga implements Ia {

    /* renamed from: a, reason: collision with root package name */
    private final Da f2883a;
    private final M2 b;

    public Ga(Da strategy, M2 adUnit) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f2883a = strategy;
        this.b = adUnit;
    }

    @Override // com.ironsource.Ia
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f2883a.a("Ad unit is already loaded");
    }

    @Override // com.ironsource.Ia
    public void b() {
        this.f2883a.a("Loading a loaded ad");
    }

    @Override // com.ironsource.Ia
    public void c() {
        this.b.a(true);
        this.f2883a.a((M2) null);
        Da da = this.f2883a;
        da.a(new Fa(da));
    }

    @Override // com.ironsource.Ia
    public void a(IronSourceError ironSourceError) {
        this.f2883a.a("Ad unit is already loaded");
    }
}
