package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3459i {
    public static final int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5848a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public C3459i(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f5848a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public final String a() {
        return this.f5848a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3459i)) {
            return false;
        }
        C3459i c3459i = (C3459i) obj;
        return Intrinsics.areEqual(this.f5848a, c3459i.f5848a) && Intrinsics.areEqual(this.b, c3459i.b) && Intrinsics.areEqual(this.c, c3459i.c) && Intrinsics.areEqual(this.d, c3459i.d) && Intrinsics.areEqual(this.e, c3459i.e) && Intrinsics.areEqual(this.f, c3459i.f) && Intrinsics.areEqual(this.g, c3459i.g);
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.f5848a;
    }

    public int hashCode() {
        String str = this.f5848a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.g;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final String i() {
        return this.b;
    }

    public final String j() {
        return this.c;
    }

    public final String k() {
        return this.e;
    }

    public final String l() {
        return this.d;
    }

    public final String m() {
        return this.f;
    }

    public final String n() {
        return this.g;
    }

    public String toString() {
        return "DEC(appIconUri=" + this.f5848a + ", appName=" + this.b + ", ctaText=" + this.c + ", ctaUrl=" + this.d + ", ctaTrackingUrl=" + this.e + ", impressionTrackingUrl=" + this.f + ", skipToDECTrackingUrl=" + this.g + ')';
    }

    public final C3459i a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return new C3459i(str, str2, str3, str4, str5, str6, str7);
    }

    public static /* synthetic */ C3459i a(C3459i c3459i, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3459i.f5848a;
        }
        if ((i & 2) != 0) {
            str2 = c3459i.b;
        }
        if ((i & 4) != 0) {
            str3 = c3459i.c;
        }
        if ((i & 8) != 0) {
            str4 = c3459i.d;
        }
        if ((i & 16) != 0) {
            str5 = c3459i.e;
        }
        if ((i & 32) != 0) {
            str6 = c3459i.f;
        }
        if ((i & 64) != 0) {
            str7 = c3459i.g;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return c3459i.a(str, str2, str11, str4, str10, str8, str9);
    }
}
