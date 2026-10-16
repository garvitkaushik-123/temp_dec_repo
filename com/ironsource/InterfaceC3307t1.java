package com.ironsource;

import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.t1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3307t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3833a = b.f3835a;

    /* renamed from: com.ironsource.t1$a */
    public interface a extends InterfaceC3307t1 {

        /* renamed from: com.ironsource.t1$a$a, reason: collision with other inner class name */
        public static final class C0307a implements a {
            private final String b;
            private final String c;
            private final C3230o8.e d;
            private final String e;
            private final String f;
            private final C0308a g;
            private final int h;
            private final int i;

            /* renamed from: com.ironsource.t1$a$a$a, reason: collision with other inner class name */
            public static final class C0308a {

                /* renamed from: a, reason: collision with root package name */
                private final int f3834a;
                private final int b;

                public C0308a(int i, int i2) {
                    this.f3834a = i;
                    this.b = i2;
                }

                public final int a() {
                    return this.f3834a;
                }

                public final int b() {
                    return this.b;
                }

                public final int c() {
                    return this.f3834a;
                }

                public final int d() {
                    return this.b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0308a)) {
                        return false;
                    }
                    C0308a c0308a = (C0308a) obj;
                    return this.f3834a == c0308a.f3834a && this.b == c0308a.b;
                }

                public int hashCode() {
                    return (Integer.hashCode(this.f3834a) * 31) + Integer.hashCode(this.b);
                }

                public String toString() {
                    return "Coordinates(x=" + this.f3834a + ", y=" + this.b + ")";
                }

                public final C0308a a(int i, int i2) {
                    return new C0308a(i, i2);
                }

                public static /* synthetic */ C0308a a(C0308a c0308a, int i, int i2, int i3, Object obj) {
                    if ((i3 & 1) != 0) {
                        i = c0308a.f3834a;
                    }
                    if ((i3 & 2) != 0) {
                        i2 = c0308a.b;
                    }
                    return c0308a.a(i, i2);
                }
            }

            public C0307a(String successCallback, String failCallback, C3230o8.e productType, String demandSourceName, String url, C0308a coordinates, int i, int i2) {
                Intrinsics.checkNotNullParameter(successCallback, "successCallback");
                Intrinsics.checkNotNullParameter(failCallback, "failCallback");
                Intrinsics.checkNotNullParameter(productType, "productType");
                Intrinsics.checkNotNullParameter(demandSourceName, "demandSourceName");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                this.b = successCallback;
                this.c = failCallback;
                this.d = productType;
                this.e = demandSourceName;
                this.f = url;
                this.g = coordinates;
                this.h = i;
                this.i = i2;
            }

            public final C0307a a(String successCallback, String failCallback, C3230o8.e productType, String demandSourceName, String url, C0308a coordinates, int i, int i2) {
                Intrinsics.checkNotNullParameter(successCallback, "successCallback");
                Intrinsics.checkNotNullParameter(failCallback, "failCallback");
                Intrinsics.checkNotNullParameter(productType, "productType");
                Intrinsics.checkNotNullParameter(demandSourceName, "demandSourceName");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                return new C0307a(successCallback, failCallback, productType, demandSourceName, url, coordinates, i, i2);
            }

            @Override // com.ironsource.InterfaceC3307t1.a
            public String b() {
                return this.f;
            }

            @Override // com.ironsource.InterfaceC3307t1
            public String c() {
                return this.c;
            }

            @Override // com.ironsource.InterfaceC3307t1
            public C3230o8.e d() {
                return this.d;
            }

            @Override // com.ironsource.InterfaceC3307t1
            public String e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0307a)) {
                    return false;
                }
                C0307a c0307a = (C0307a) obj;
                return Intrinsics.areEqual(this.b, c0307a.b) && Intrinsics.areEqual(this.c, c0307a.c) && this.d == c0307a.d && Intrinsics.areEqual(this.e, c0307a.e) && Intrinsics.areEqual(this.f, c0307a.f) && Intrinsics.areEqual(this.g, c0307a.g) && this.h == c0307a.h && this.i == c0307a.i;
            }

            public final String f() {
                return this.b;
            }

            public final String g() {
                return this.c;
            }

            public final C3230o8.e h() {
                return this.d;
            }

            public int hashCode() {
                return (((((((((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i);
            }

            public final String i() {
                return this.e;
            }

            public final String j() {
                return this.f;
            }

            public final C0308a k() {
                return this.g;
            }

            public final int l() {
                return this.h;
            }

            public final int m() {
                return this.i;
            }

            public final int n() {
                return this.h;
            }

            public final C0308a o() {
                return this.g;
            }

            public final int p() {
                return this.i;
            }

            public String toString() {
                return "Click(successCallback=" + this.b + ", failCallback=" + this.c + ", productType=" + this.d + ", demandSourceName=" + this.e + ", url=" + this.f + ", coordinates=" + this.g + ", action=" + this.h + ", metaState=" + this.i + ")";
            }

            public static /* synthetic */ C0307a a(C0307a c0307a, String str, String str2, C3230o8.e eVar, String str3, String str4, C0308a c0308a, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = c0307a.b;
                }
                if ((i3 & 2) != 0) {
                    str2 = c0307a.c;
                }
                if ((i3 & 4) != 0) {
                    eVar = c0307a.d;
                }
                if ((i3 & 8) != 0) {
                    str3 = c0307a.e;
                }
                if ((i3 & 16) != 0) {
                    str4 = c0307a.f;
                }
                if ((i3 & 32) != 0) {
                    c0308a = c0307a.g;
                }
                if ((i3 & 64) != 0) {
                    i = c0307a.h;
                }
                if ((i3 & 128) != 0) {
                    i2 = c0307a.i;
                }
                int i4 = i;
                int i5 = i2;
                String str5 = str4;
                C0308a c0308a2 = c0308a;
                return c0307a.a(str, str2, eVar, str3, str5, c0308a2, i4, i5);
            }

            @Override // com.ironsource.InterfaceC3307t1
            public String a() {
                return this.b;
            }
        }

        /* renamed from: com.ironsource.t1$a$b */
        public static final class b implements a {
            private final String b;
            private final String c;
            private final C3230o8.e d;
            private final String e;
            private final String f;

            public b(String successCallback, String failCallback, C3230o8.e productType, String demandSourceName, String url) {
                Intrinsics.checkNotNullParameter(successCallback, "successCallback");
                Intrinsics.checkNotNullParameter(failCallback, "failCallback");
                Intrinsics.checkNotNullParameter(productType, "productType");
                Intrinsics.checkNotNullParameter(demandSourceName, "demandSourceName");
                Intrinsics.checkNotNullParameter(url, "url");
                this.b = successCallback;
                this.c = failCallback;
                this.d = productType;
                this.e = demandSourceName;
                this.f = url;
            }

            public final b a(String successCallback, String failCallback, C3230o8.e productType, String demandSourceName, String url) {
                Intrinsics.checkNotNullParameter(successCallback, "successCallback");
                Intrinsics.checkNotNullParameter(failCallback, "failCallback");
                Intrinsics.checkNotNullParameter(productType, "productType");
                Intrinsics.checkNotNullParameter(demandSourceName, "demandSourceName");
                Intrinsics.checkNotNullParameter(url, "url");
                return new b(successCallback, failCallback, productType, demandSourceName, url);
            }

            @Override // com.ironsource.InterfaceC3307t1.a
            public String b() {
                return this.f;
            }

            @Override // com.ironsource.InterfaceC3307t1
            public String c() {
                return this.c;
            }

            @Override // com.ironsource.InterfaceC3307t1
            public C3230o8.e d() {
                return this.d;
            }

            @Override // com.ironsource.InterfaceC3307t1
            public String e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c) && this.d == bVar.d && Intrinsics.areEqual(this.e, bVar.e) && Intrinsics.areEqual(this.f, bVar.f);
            }

            public final String f() {
                return this.b;
            }

            public final String g() {
                return this.c;
            }

            public final C3230o8.e h() {
                return this.d;
            }

            public int hashCode() {
                return (((((((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
            }

            public final String i() {
                return this.e;
            }

            public final String j() {
                return this.f;
            }

            public String toString() {
                return "Impression(successCallback=" + this.b + ", failCallback=" + this.c + ", productType=" + this.d + ", demandSourceName=" + this.e + ", url=" + this.f + ")";
            }

            public static /* synthetic */ b a(b bVar, String str, String str2, C3230o8.e eVar, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = bVar.b;
                }
                if ((i & 2) != 0) {
                    str2 = bVar.c;
                }
                if ((i & 4) != 0) {
                    eVar = bVar.d;
                }
                if ((i & 8) != 0) {
                    str3 = bVar.e;
                }
                if ((i & 16) != 0) {
                    str4 = bVar.f;
                }
                String str5 = str4;
                C3230o8.e eVar2 = eVar;
                return bVar.a(str, str2, eVar2, str3, str5);
            }

            @Override // com.ironsource.InterfaceC3307t1
            public String a() {
                return this.b;
            }
        }

        String b();
    }

    @JvmStatic
    static InterfaceC3307t1 a(String str) {
        return f3833a.a(str);
    }

    String a();

    String c();

    C3230o8.e d();

    String e();

    /* renamed from: com.ironsource.t1$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f3835a = new b();

        private b() {
        }

        @JvmStatic
        public final InterfaceC3307t1 a(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            String optString = jSONObject.optString("type", "none");
            if (Intrinsics.areEqual(optString, C3057e4.c)) {
                return a(jSONObject);
            }
            throw new IllegalArgumentException("unsupported message type: " + optString);
        }

        private final a a(JSONObject jSONObject) {
            String successCallback = jSONObject.getString("success");
            String failCallback = jSONObject.getString(C3040d4.f.e);
            String demandSourceName = jSONObject.getString("demandSourceName");
            String string = jSONObject.getString(C3040d4.h.m);
            Intrinsics.checkNotNullExpressionValue(string, "json.getString(ParametersKeys.PRODUCT_TYPE)");
            C3230o8.e valueOf = C3230o8.e.valueOf(string);
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            String url = jSONObject2.getString("url");
            String optString = jSONObject2.optString("type");
            if (Intrinsics.areEqual(optString, "click")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(C3057e4.f);
                int i = jSONObject3.getInt(C3057e4.g);
                int i2 = jSONObject3.getInt(C3057e4.h);
                int optInt = jSONObject2.optInt("action", 0);
                int optInt2 = jSONObject2.optInt(C3057e4.j, 0);
                Intrinsics.checkNotNullExpressionValue(successCallback, "successCallback");
                Intrinsics.checkNotNullExpressionValue(failCallback, "failCallback");
                Intrinsics.checkNotNullExpressionValue(demandSourceName, "demandSourceName");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                return new a.C0307a(successCallback, failCallback, valueOf, demandSourceName, url, new a.C0307a.C0308a(i, i2), optInt, optInt2);
            }
            if (Intrinsics.areEqual(optString, "impression")) {
                Intrinsics.checkNotNullExpressionValue(successCallback, "successCallback");
                Intrinsics.checkNotNullExpressionValue(failCallback, "failCallback");
                Intrinsics.checkNotNullExpressionValue(demandSourceName, "demandSourceName");
                Intrinsics.checkNotNullExpressionValue(url, "url");
                return new a.b(successCallback, failCallback, valueOf, demandSourceName, url);
            }
            throw new IllegalArgumentException("JSON does not contain valid type: " + jSONObject2.optString("type"));
        }
    }
}
