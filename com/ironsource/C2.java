package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class C2 implements I {

    /* renamed from: a, reason: collision with root package name */
    private final Yf f2808a;

    public C2(Yf viewBinder) {
        Intrinsics.checkNotNullParameter(viewBinder, "viewBinder");
        this.f2808a = viewBinder;
    }

    @Override // com.ironsource.I
    public void a(C3393y2 bannerAdInstance) {
        Intrinsics.checkNotNullParameter(bannerAdInstance, "bannerAdInstance");
        bannerAdInstance.a(this.f2808a);
    }
}
