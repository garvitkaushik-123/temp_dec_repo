package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Fa implements Ia {

    /* renamed from: a, reason: collision with root package name */
    private final Da f2873a;

    public Fa(Da strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f2873a = strategy;
    }

    @Override // com.ironsource.Ia
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f2873a.a("Received load success on a destroyed ad");
    }

    @Override // com.ironsource.Ia
    public void b() {
        this.f2873a.a("Loading a destroyed ad");
    }

    @Override // com.ironsource.Ia
    public void c() {
        this.f2873a.a("Destroying a destroyed ad");
    }

    @Override // com.ironsource.Ia
    public void a(IronSourceError ironSourceError) {
        this.f2873a.a("Received load failed on a destroyed ad");
    }
}
