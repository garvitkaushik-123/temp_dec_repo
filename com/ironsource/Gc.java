package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Gc {

    /* renamed from: a, reason: collision with root package name */
    private final long f2885a;
    private final O3 b;

    public Gc(long j, O3 unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.f2885a = j;
        this.b = unit;
    }

    public final long a() {
        return this.f2885a;
    }

    public final O3 b() {
        return this.b;
    }

    public String toString() {
        return "PacingCappingConfig(timeInterval=" + this.f2885a + " unit=" + this.b + ")";
    }

    public /* synthetic */ Gc(long j, O3 o3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? O3.Second : o3);
    }
}
