package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.kb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3165kb {

    /* renamed from: a, reason: collision with root package name */
    private final EnumC3096g9 f3408a;
    private final String b;
    private final long c;
    private final boolean d;
    private final boolean e;

    public C3165kb(EnumC3096g9 instanceType, String adSourceNameForEvents, long j, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(instanceType, "instanceType");
        Intrinsics.checkNotNullParameter(adSourceNameForEvents, "adSourceNameForEvents");
        this.f3408a = instanceType;
        this.b = adSourceNameForEvents;
        this.c = j;
        this.d = z;
        this.e = z2;
    }

    public final EnumC3096g9 a() {
        return this.f3408a;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3165kb)) {
            return false;
        }
        C3165kb c3165kb = (C3165kb) obj;
        return this.f3408a == c3165kb.f3408a && Intrinsics.areEqual(this.b, c3165kb.b) && this.c == c3165kb.c && this.d == c3165kb.d && this.e == c3165kb.e;
    }

    public final String f() {
        return this.b;
    }

    public final EnumC3096g9 g() {
        return this.f3408a;
    }

    public final long h() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.f3408a.hashCode() * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.e;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean i() {
        return this.e;
    }

    public final boolean j() {
        return this.d;
    }

    public String toString() {
        return "LoadTaskConfig(instanceType=" + this.f3408a + ", adSourceNameForEvents=" + this.b + ", loadTimeoutInMills=" + this.c + ", isOneFlow=" + this.d + ", isMultipleAdObjects=" + this.e + ")";
    }

    public final C3165kb a(EnumC3096g9 instanceType, String adSourceNameForEvents, long j, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(instanceType, "instanceType");
        Intrinsics.checkNotNullParameter(adSourceNameForEvents, "adSourceNameForEvents");
        return new C3165kb(instanceType, adSourceNameForEvents, j, z, z2);
    }

    public static /* synthetic */ C3165kb a(C3165kb c3165kb, EnumC3096g9 enumC3096g9, String str, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC3096g9 = c3165kb.f3408a;
        }
        if ((i & 2) != 0) {
            str = c3165kb.b;
        }
        if ((i & 4) != 0) {
            j = c3165kb.c;
        }
        if ((i & 8) != 0) {
            z = c3165kb.d;
        }
        if ((i & 16) != 0) {
            z2 = c3165kb.e;
        }
        long j2 = j;
        return c3165kb.a(enumC3096g9, str, j2, z, z2);
    }

    public /* synthetic */ C3165kb(EnumC3096g9 enumC3096g9, String str, long j, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC3096g9, str, j, z, (i & 16) != 0 ? true : z2);
    }
}
