package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ha implements Ia {

    /* renamed from: a, reason: collision with root package name */
    private final Da f2898a;
    private final M2 b;

    public Ha(Da strategy, M2 adUnit) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f2898a = strategy;
        this.b = adUnit;
    }

    @Override // com.ironsource.Ia
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f2898a.a(adUnitCallback, this.b);
        Da da = this.f2898a;
        da.a(new Ga(da, this.b));
    }

    @Override // com.ironsource.Ia
    public void b() {
        this.f2898a.a("Loading an ad while loading");
    }

    @Override // com.ironsource.Ia
    public void c() {
        this.b.a(true);
        this.f2898a.a((M2) null);
        Da da = this.f2898a;
        da.a(new Fa(da));
    }

    @Override // com.ironsource.Ia
    public void a(IronSourceError ironSourceError) {
        this.f2898a.a(ironSourceError);
        this.b.a(false);
        this.f2898a.a((M2) null);
        Da da = this.f2898a;
        da.a(new Fa(da));
    }
}
