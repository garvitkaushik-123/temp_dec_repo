package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Rf {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3293s4 f3035a;

    public Rf(InterfaceC3293s4 currentTimeProvider) {
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        this.f3035a = currentTimeProvider;
    }

    public final boolean a(long j, long j2) {
        long a2 = this.f3035a.a();
        return j2 <= 0 || j <= 0 || a2 < j || a2 - j > j2;
    }
}
