package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.k2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3156k2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3384a;
    private final JSONObject b;
    private final C3207n2 c;
    private final int d;
    private final String e;

    public C3156k2(String auctionId, JSONObject jSONObject, C3207n2 c3207n2, int i, String auctionFallback) {
        Intrinsics.checkNotNullParameter(auctionId, "auctionId");
        Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
        this.f3384a = auctionId;
        this.b = jSONObject;
        this.c = c3207n2;
        this.d = i;
        this.e = auctionFallback;
    }

    public final String a() {
        return this.f3384a;
    }

    public final JSONObject b() {
        return this.b;
    }

    public final C3207n2 c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3156k2)) {
            return false;
        }
        C3156k2 c3156k2 = (C3156k2) obj;
        return Intrinsics.areEqual(this.f3384a, c3156k2.f3384a) && Intrinsics.areEqual(this.b, c3156k2.b) && Intrinsics.areEqual(this.c, c3156k2.c) && this.d == c3156k2.d && Intrinsics.areEqual(this.e, c3156k2.e);
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f3384a;
    }

    public final JSONObject h() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = this.f3384a.hashCode() * 31;
        JSONObject jSONObject = this.b;
        int hashCode2 = (hashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        C3207n2 c3207n2 = this.c;
        return ((((hashCode2 + (c3207n2 != null ? c3207n2.hashCode() : 0)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode();
    }

    public final int i() {
        return this.d;
    }

    public final C3207n2 j() {
        return this.c;
    }

    public String toString() {
        return "AuctionResponseData(auctionId=" + this.f3384a + ", auctionResponseGenericParam=" + this.b + ", genericNotifications=" + this.c + ", auctionTrial=" + this.d + ", auctionFallback=" + this.e + ")";
    }

    public final C3156k2 a(String auctionId, JSONObject jSONObject, C3207n2 c3207n2, int i, String auctionFallback) {
        Intrinsics.checkNotNullParameter(auctionId, "auctionId");
        Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
        return new C3156k2(auctionId, jSONObject, c3207n2, i, auctionFallback);
    }

    public static /* synthetic */ C3156k2 a(C3156k2 c3156k2, String str, JSONObject jSONObject, C3207n2 c3207n2, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c3156k2.f3384a;
        }
        if ((i2 & 2) != 0) {
            jSONObject = c3156k2.b;
        }
        if ((i2 & 4) != 0) {
            c3207n2 = c3156k2.c;
        }
        if ((i2 & 8) != 0) {
            i = c3156k2.d;
        }
        if ((i2 & 16) != 0) {
            str2 = c3156k2.e;
        }
        String str3 = str2;
        C3207n2 c3207n22 = c3207n2;
        return c3156k2.a(str, jSONObject, c3207n22, i, str3);
    }
}
