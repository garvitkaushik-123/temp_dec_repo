package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Gb implements I {

    /* renamed from: a, reason: collision with root package name */
    private final C3402yb f2884a;

    public Gb(C3402yb nativeAdBinder) {
        Intrinsics.checkNotNullParameter(nativeAdBinder, "nativeAdBinder");
        this.f2884a = nativeAdBinder;
    }

    @Override // com.ironsource.I
    public void a(Fb nativeAdInstance) {
        Intrinsics.checkNotNullParameter(nativeAdInstance, "nativeAdInstance");
        nativeAdInstance.a(this.f2884a);
    }
}
