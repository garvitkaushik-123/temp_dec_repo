package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Re {

    /* renamed from: a, reason: collision with root package name */
    private final int f3034a;
    private final O3 b;

    public Re(int i, O3 unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.f3034a = i;
        this.b = unit;
    }

    public final int a() {
        return this.f3034a;
    }

    public final O3 b() {
        return this.b;
    }

    public String toString() {
        return "ShowCountCappingConfig(maxImpressions=" + this.f3034a + ", unit=" + this.b + ")";
    }
}
