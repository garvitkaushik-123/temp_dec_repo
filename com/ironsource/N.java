package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.sdk.controller.f;
import java.util.Date;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class N {
    public static final a f = new a(null);
    public static final String g = "0";
    public static final String h = "0";
    public static final String i = "0";
    public static final String j = "0";

    /* renamed from: a, reason: collision with root package name */
    private final B9 f2956a;
    private S7 b;
    private String c;
    private EnumC3188m0 d;
    private double e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public N(B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        this.f2956a = adInstance;
        this.b = S7.UnknownProvider;
        this.c = "0";
        this.d = EnumC3188m0.LOAD_REQUEST;
        this.e = new Date().getTime() / 1000.0d;
    }

    public final B9 a() {
        return this.f2956a;
    }

    public final IronSource.AD_UNIT b() {
        return this.f2956a.i() ? IronSource.AD_UNIT.BANNER : this.f2956a.n() ? IronSource.AD_UNIT.REWARDED_VIDEO : IronSource.AD_UNIT.INTERSTITIAL;
    }

    public final String c() {
        String e = this.f2956a.e();
        Intrinsics.checkNotNullExpressionValue(e, "adInstance.id");
        return e;
    }

    public final B9 d() {
        return this.f2956a;
    }

    public final S7 e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n = (N) obj;
        return Intrinsics.areEqual(c(), n.c()) && Intrinsics.areEqual(g(), n.g()) && b() == n.b() && Intrinsics.areEqual(i(), n.i()) && this.b == n.b && Intrinsics.areEqual(this.c, n.c) && this.d == n.d;
    }

    public final EnumC3188m0 f() {
        return this.d;
    }

    public final String g() {
        String c = this.f2956a.c();
        return c == null ? "0" : c;
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        return Objects.hash(c(), g(), b(), i(), this.b, this.c, this.d, Double.valueOf(this.e));
    }

    public final String i() {
        String g2 = this.f2956a.g();
        Intrinsics.checkNotNullExpressionValue(g2, "adInstance.name");
        return g2;
    }

    public final double j() {
        return this.e;
    }

    public String toString() {
        String jSONObject = new JSONObject().put(f.b.c, c()).put("advertiserBundleId", this.c).put("adProvider", this.b.ordinal()).put("adStatus", this.d.ordinal()).put("lastStatusUpdateTimeStamp", (long) this.e).put("adUnitId", g()).put("adFormat", b().toString()).put("instanceId", i()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject()\n        .pu…ceId)\n        .toString()");
        return jSONObject;
    }

    public final N a(B9 adInstance) {
        Intrinsics.checkNotNullParameter(adInstance, "adInstance");
        return new N(adInstance);
    }

    public static /* synthetic */ N a(N n, B9 b9, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            b9 = n.f2956a;
        }
        return n.a(b9);
    }

    public final void a(S7 s7) {
        Intrinsics.checkNotNullParameter(s7, "<set-?>");
        this.b = s7;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    public final void a(EnumC3188m0 enumC3188m0) {
        Intrinsics.checkNotNullParameter(enumC3188m0, "<set-?>");
        this.d = enumC3188m0;
    }

    public final void a(double d) {
        this.e = d;
    }
}
