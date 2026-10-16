package com.ironsource;

import com.ironsource.AbstractC3157k3;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.wa, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3367wa implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f3923a;
    private final M2 b;
    private boolean c;

    public C3367wa(C3282ra strategy, M2 currentAdUnit, boolean z) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(currentAdUnit, "currentAdUnit");
        this.f3923a = strategy;
        this.b = currentAdUnit;
        this.c = z;
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f3923a.a(adUnitCallback, this.b, (M2) null, new AbstractC3157k3.a(AbstractC3157k3.b.C0291b.f3387a), this.c, (Long) null);
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f3923a.a("Loading an ad while loading");
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.b.a(true);
        C3282ra c3282ra = this.f3923a;
        c3282ra.a((Ba) new C3333ua(c3282ra));
    }

    @Override // com.ironsource.Ba
    public void d() {
        this.c = true;
    }

    @Override // com.ironsource.Ba
    public void e() {
        this.c = false;
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f3923a.a(ironSourceError, this.b, (AbstractC3157k3) new AbstractC3157k3.a(AbstractC3157k3.b.a.f3386a), false, this.c, (Long) null);
    }
}
