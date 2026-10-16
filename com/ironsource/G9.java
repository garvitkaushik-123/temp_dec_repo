package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class G9 {

    /* renamed from: a, reason: collision with root package name */
    private final String f2882a;
    private final String b;

    public G9(String advId, String advIdType) {
        Intrinsics.checkNotNullParameter(advId, "advId");
        Intrinsics.checkNotNullParameter(advIdType, "advIdType");
        this.f2882a = advId;
        this.b = advIdType;
    }

    public final String a() {
        return this.f2882a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.f2882a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G9)) {
            return false;
        }
        G9 g9 = (G9) obj;
        return Intrinsics.areEqual(this.f2882a, g9.f2882a) && Intrinsics.areEqual(this.b, g9.b);
    }

    public int hashCode() {
        return (this.f2882a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "IronSourceAdvId(advId=" + this.f2882a + ", advIdType=" + this.b + ")";
    }

    public final G9 a(String advId, String advIdType) {
        Intrinsics.checkNotNullParameter(advId, "advId");
        Intrinsics.checkNotNullParameter(advIdType, "advIdType");
        return new G9(advId, advIdType);
    }

    public static /* synthetic */ G9 a(G9 g9, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = g9.f2882a;
        }
        if ((i & 2) != 0) {
            str2 = g9.b;
        }
        return g9.a(str, str2);
    }
}
