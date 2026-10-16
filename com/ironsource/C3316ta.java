package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ta, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3316ta implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f3847a;
    private boolean b;

    public C3316ta(C3282ra strategy, boolean z) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f3847a = strategy;
        this.b = z;
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f3847a.a("Received load success before load");
    }

    @Override // com.ironsource.Ba
    public void b() {
        M2 a2 = this.f3847a.j().a(true);
        a2.a(this.f3847a.g());
        this.f3847a.a((Ba) new C3367wa(this.f3847a, a2, this.b));
    }

    @Override // com.ironsource.Ba
    public void c() {
        C3282ra c3282ra = this.f3847a;
        c3282ra.a((Ba) new C3333ua(c3282ra));
    }

    @Override // com.ironsource.Ba
    public void d() {
        this.b = true;
    }

    @Override // com.ironsource.Ba
    public void e() {
        this.b = false;
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f3847a.a("Received load failed before load");
    }

    public /* synthetic */ C3316ta(C3282ra c3282ra, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3282ra, (i & 2) != 0 ? false : z);
    }
}
