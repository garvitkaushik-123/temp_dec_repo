package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.ua, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3333ua implements Ba {

    /* renamed from: a, reason: collision with root package name */
    private final C3282ra f3874a;

    public C3333ua(C3282ra strategy) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.f3874a = strategy;
    }

    @Override // com.ironsource.L0
    public void a(C3289s0 adUnitCallback) {
        Intrinsics.checkNotNullParameter(adUnitCallback, "adUnitCallback");
        this.f3874a.a("Received load success on a destroyed ad");
    }

    @Override // com.ironsource.Ba
    public void b() {
        this.f3874a.a("Loading a destroyed ad");
    }

    @Override // com.ironsource.Ba
    public void c() {
        this.f3874a.a("Destroying a destroyed ad");
    }

    @Override // com.ironsource.Ba
    public void d() {
        this.f3874a.a("Pausing auto refresh on a destroyed ad");
    }

    @Override // com.ironsource.Ba
    public void e() {
        this.f3874a.a("Resuming auto refresh on a destroyed ad");
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f3874a.a("Received load failed on a destroyed ad");
    }
}
