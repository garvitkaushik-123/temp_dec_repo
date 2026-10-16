package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Bc {

    /* renamed from: a, reason: collision with root package name */
    private final String f2806a;
    private final String b;

    public Bc(String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.f2806a = url;
        this.b = str;
    }

    public final String a() {
        return this.f2806a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.f2806a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Bc)) {
            return false;
        }
        Bc bc = (Bc) obj;
        return Intrinsics.areEqual(this.f2806a, bc.f2806a) && Intrinsics.areEqual(this.b, bc.b);
    }

    public int hashCode() {
        int hashCode = this.f2806a.hashCode() * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "OpenUrl(url=" + this.f2806a + ", packageName=" + this.b + ")";
    }

    public /* synthetic */ Bc(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }

    public final Bc a(String url, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new Bc(url, str);
    }

    public static /* synthetic */ Bc a(Bc bc, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bc.f2806a;
        }
        if ((i & 2) != 0) {
            str2 = bc.b;
        }
        return bc.a(str, str2);
    }
}
