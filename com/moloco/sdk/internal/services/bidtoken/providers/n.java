package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.H;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class n {
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final H f5651a;
    public final String b;
    public final String c;

    public n() {
        this(null, null, null, 7, null);
    }

    public final H a() {
        return this.f5651a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f5651a == nVar.f5651a && Intrinsics.areEqual(this.b, nVar.b) && Intrinsics.areEqual(this.c, nVar.c);
    }

    public final H f() {
        return this.f5651a;
    }

    public int hashCode() {
        H h = this.f5651a;
        int hashCode = (h == null ? 0 : h.hashCode()) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeviceSignalInfo(orientation=" + this.f5651a + ", locale=" + this.b + ", keyboardLocale=" + this.c + ')';
    }

    public n(H h, String str, String str2) {
        this.f5651a = h;
        this.b = str;
        this.c = str2;
    }

    public final n a(H h, String str, String str2) {
        return new n(h, str, str2);
    }

    public static /* synthetic */ n a(n nVar, H h, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            h = nVar.f5651a;
        }
        if ((i & 2) != 0) {
            str = nVar.b;
        }
        if ((i & 4) != 0) {
            str2 = nVar.c;
        }
        return nVar.a(h, str, str2);
    }

    public /* synthetic */ n(H h, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : h, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
