package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.t4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3310t4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3843a;
    private final String b;
    private final String c;
    private final String d;

    public C3310t4() {
        this(null, null, null, null, 15, null);
    }

    public final String a() {
        return this.f3843a;
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
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3310t4)) {
            return false;
        }
        C3310t4 c3310t4 = (C3310t4) obj;
        return Intrinsics.areEqual(this.f3843a, c3310t4.f3843a) && Intrinsics.areEqual(this.b, c3310t4.b) && Intrinsics.areEqual(this.c, c3310t4.c) && Intrinsics.areEqual(this.d, c3310t4.d);
    }

    public final String f() {
        return this.c;
    }

    public final String g() {
        return this.f3843a;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        return (((((this.f3843a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "CustomAdapterSettings(customNetworkAdapterName=" + this.f3843a + ", customRewardedVideoAdapterName=" + this.b + ", customInterstitialAdapterName=" + this.c + ", customBannerAdapterName=" + this.d + ")";
    }

    public C3310t4(String customNetworkAdapterName, String customRewardedVideoAdapterName, String customInterstitialAdapterName, String customBannerAdapterName) {
        Intrinsics.checkNotNullParameter(customNetworkAdapterName, "customNetworkAdapterName");
        Intrinsics.checkNotNullParameter(customRewardedVideoAdapterName, "customRewardedVideoAdapterName");
        Intrinsics.checkNotNullParameter(customInterstitialAdapterName, "customInterstitialAdapterName");
        Intrinsics.checkNotNullParameter(customBannerAdapterName, "customBannerAdapterName");
        this.f3843a = customNetworkAdapterName;
        this.b = customRewardedVideoAdapterName;
        this.c = customInterstitialAdapterName;
        this.d = customBannerAdapterName;
    }

    public final C3310t4 a(String customNetworkAdapterName, String customRewardedVideoAdapterName, String customInterstitialAdapterName, String customBannerAdapterName) {
        Intrinsics.checkNotNullParameter(customNetworkAdapterName, "customNetworkAdapterName");
        Intrinsics.checkNotNullParameter(customRewardedVideoAdapterName, "customRewardedVideoAdapterName");
        Intrinsics.checkNotNullParameter(customInterstitialAdapterName, "customInterstitialAdapterName");
        Intrinsics.checkNotNullParameter(customBannerAdapterName, "customBannerAdapterName");
        return new C3310t4(customNetworkAdapterName, customRewardedVideoAdapterName, customInterstitialAdapterName, customBannerAdapterName);
    }

    public static /* synthetic */ C3310t4 a(C3310t4 c3310t4, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3310t4.f3843a;
        }
        if ((i & 2) != 0) {
            str2 = c3310t4.b;
        }
        if ((i & 4) != 0) {
            str3 = c3310t4.c;
        }
        if ((i & 8) != 0) {
            str4 = c3310t4.d;
        }
        return c3310t4.a(str, str2, str3, str4);
    }

    public /* synthetic */ C3310t4(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
