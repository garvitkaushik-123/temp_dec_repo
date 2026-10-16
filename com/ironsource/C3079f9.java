package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.f9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3079f9 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3297a;
    private final int b;
    private final String c;

    public C3079f9() {
        this(null, 0, null, 7, null);
    }

    public final String a() {
        return this.f3297a;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.f3297a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3079f9)) {
            return false;
        }
        C3079f9 c3079f9 = (C3079f9) obj;
        return Intrinsics.areEqual(this.f3297a, c3079f9.f3297a) && this.b == c3079f9.b && Intrinsics.areEqual(this.c, c3079f9.c);
    }

    public final int f() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = ((this.f3297a.hashCode() * 31) + Integer.hashCode(this.b)) * 31;
        String str = this.c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InstanceInformation(instanceId=" + this.f3297a + ", instanceType=" + this.b + ", dynamicDemandSourceId=" + this.c + ")";
    }

    public C3079f9(String instanceId, int i, String str) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        this.f3297a = instanceId;
        this.b = i;
        this.c = str;
    }

    public final C3079f9 a(String instanceId, int i, String str) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        return new C3079f9(instanceId, i, str);
    }

    public static /* synthetic */ C3079f9 a(C3079f9 c3079f9, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c3079f9.f3297a;
        }
        if ((i2 & 2) != 0) {
            i = c3079f9.b;
        }
        if ((i2 & 4) != 0) {
            str2 = c3079f9.c;
        }
        return c3079f9.a(str, i, str2);
    }

    public /* synthetic */ C3079f9(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str2);
    }
}
