package com.ironsource;

import com.ironsource.AbstractC3157k3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Aa implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f2791a;
    private final M2 b;
    private final M2 c;
    private final long d;

    public Aa(C3282ra strategy, M2 currentAdUnit, M2 reloadingAdUnit, long j) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        Intrinsics.checkNotNullParameter(reloadingAdUnit, "reloadingAdUnit");
        this.f2791a = strategy;
        this.b = currentAdUnit;
        this.c = reloadingAdUnit;
        this.d = j;
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f2791a.a(adUnitCallback, this.c, this.b, (AbstractC3157k3) new AbstractC3157k3.c(this.f2791a.p().a() - this.d, AbstractC3157k3.d.C0292d.f3393a), false, Long.valueOf(this.d));
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f2791a.a("Loading an ad while reloading after timer finished");
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.b.a(true);
        this.c.a(true);
        C3282ra c3282ra = this.f2791a;
        c3282ra.a((Ba) new C3333ua(c3282ra));
    }

    @Override // com.ironsource.Ba
    public void d() {
        C3282ra c3282ra = this.f2791a;
        c3282ra.a((Ba) new C3384xa(c3282ra, this.b));
    }

    @Override // com.ironsource.Ba
    public void e() {
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f2791a.a(ironSourceError, this.b, (AbstractC3157k3) new AbstractC3157k3.c(this.f2791a.p().a() - this.d, AbstractC3157k3.d.c.f3392a), true, false, Long.valueOf(this.d));
    }
}
