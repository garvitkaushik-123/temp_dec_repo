package com.ironsource;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.ib, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3132ib {
    public static final a c = new a(null);
    public static final String d = "revenue";
    public static final String e = "precision";

    /* renamed from: a, reason: collision with root package name */
    private final double f3360a;
    private final String b;

    /* renamed from: com.ironsource.ib$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final C3132ib a(JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                double d = json.getDouble("revenue");
                String precision = json.getString("precision");
                Intrinsics.checkNotNullExpressionValue(precision, "precision");
                return new C3132ib(d, precision);
            } catch (Exception e) {
                C3260q4.d().a(e);
                C3051df.a(e);
                return null;
            }
        }

        private a() {
        }
    }

    public C3132ib(double d2, String precision) {
        Intrinsics.checkNotNullParameter(precision, "precision");
        this.f3360a = d2;
        this.b = precision;
    }

    public final double a() {
        return this.f3360a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.b;
    }

    public final double d() {
        return this.f3360a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3132ib)) {
            return false;
        }
        C3132ib c3132ib = (C3132ib) obj;
        return Double.compare(this.f3360a, c3132ib.f3360a) == 0 && Intrinsics.areEqual(this.b, c3132ib.b);
    }

    public int hashCode() {
        return (Double.hashCode(this.f3360a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "LoadArmData(revenue=" + this.f3360a + ", precision=" + this.b + ")";
    }

    public final C3132ib a(double d2, String precision) {
        Intrinsics.checkNotNullParameter(precision, "precision");
        return new C3132ib(d2, precision);
    }

    public static /* synthetic */ C3132ib a(C3132ib c3132ib, double d2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d2 = c3132ib.f3360a;
        }
        if ((i & 2) != 0) {
            str = c3132ib.b;
        }
        return c3132ib.a(d2, str);
    }

    @JvmStatic
    public static final C3132ib a(JSONObject jSONObject) {
        return c.a(jSONObject);
    }
}
