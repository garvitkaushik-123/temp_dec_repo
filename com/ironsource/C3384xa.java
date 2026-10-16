package com.ironsource;

import com.ironsource.AbstractC3157k3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.xa, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3384xa implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f3936a;
    private final M2 b;

    public C3384xa(C3282ra strategy, M2 currentAdUnit) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        this.f3936a = strategy;
        this.b = currentAdUnit;
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f3936a.a("Received load success while paused");
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f3936a.a("Loading a loaded ad");
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.b.a(true);
        C3282ra c3282ra = this.f3936a;
        c3282ra.a((Ba) new C3333ua(c3282ra));
    }

    @Override // com.ironsource.Ba
    public void d() {
    }

    @Override // com.ironsource.Ba
    public void e() {
        this.f3936a.a(this.b, new AbstractC3157k3.a(AbstractC3157k3.b.c.f3388a));
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f3936a.a("Received load failed while paused");
    }
}
