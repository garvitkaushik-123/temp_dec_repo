package com.ironsource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import com.ironsource.C3040d4;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class B8 {

    /* renamed from: a, reason: collision with root package name */
    private final String f2801a;
    private final String b;
    private final String c;
    private final String d;
    private final Drawable e;
    private final WebView f;
    private final View g;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final a f2803a;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private final String f2804a;
            private final String b;
            private final String c;
            private final String d;
            private final Result<Drawable> e;
            private final Result<WebView> f;
            private final View g;

            /* JADX WARN: Multi-variable type inference failed */
            public a(String str, String str2, String str3, String str4, Result<? extends Drawable> result, Result<? extends WebView> result2, View privacyIcon) {
                Intrinsics.checkNotNullParameter(privacyIcon, "privacyIcon");
                this.f2804a = str;
                this.b = str2;
                this.c = str3;
                this.d = str4;
                this.e = result;
                this.f = result2;
                this.g = privacyIcon;
            }

            public final String a() {
                return this.f2804a;
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

            public final Result<Drawable> e() {
                return this.e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return Intrinsics.areEqual(this.f2804a, aVar.f2804a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g);
            }

            public final Result<WebView> f() {
                return this.f;
            }

            public final View g() {
                return this.g;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final B8 h() {
                Drawable drawable;
                String str = this.f2804a;
                String str2 = this.b;
                String str3 = this.c;
                String str4 = this.d;
                Result<Drawable> result = this.e;
                if (result != null) {
                    Object value = result.getValue();
                    if (Result.m10247isFailureimpl(value)) {
                        value = null;
                    }
                    drawable = (Drawable) value;
                } else {
                    drawable = null;
                }
                Result<WebView> result2 = this.f;
                if (result2 != null) {
                    Object value2 = result2.getValue();
                    r6 = Result.m10247isFailureimpl(value2) ? null : value2;
                }
                return new B8(str, str2, str3, str4, drawable, r6, this.g);
            }

            public int hashCode() {
                String str = this.f2804a;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Result<Drawable> result = this.e;
                int m10246hashCodeimpl = (hashCode4 + (result == null ? 0 : Result.m10246hashCodeimpl(result.getValue()))) * 31;
                Result<WebView> result2 = this.f;
                return ((m10246hashCodeimpl + (result2 != null ? Result.m10246hashCodeimpl(result2.getValue()) : 0)) * 31) + this.g.hashCode();
            }

            public final String i() {
                return this.b;
            }

            public final String j() {
                return this.c;
            }

            public final String k() {
                return this.d;
            }

            public final Result<Drawable> l() {
                return this.e;
            }

            public final Result<WebView> m() {
                return this.f;
            }

            public final View n() {
                return this.g;
            }

            public final String o() {
                return this.f2804a;
            }

            public String toString() {
                return "Data(title=" + this.f2804a + ", advertiser=" + this.b + ", body=" + this.c + ", cta=" + this.d + ", icon=" + this.e + ", media=" + this.f + ", privacyIcon=" + this.g + ")";
            }

            public final a a(String str, String str2, String str3, String str4, Result<? extends Drawable> result, Result<? extends WebView> result2, View privacyIcon) {
                Intrinsics.checkNotNullParameter(privacyIcon, "privacyIcon");
                return new a(str, str2, str3, str4, result, result2, privacyIcon);
            }

            public static /* synthetic */ a a(a aVar, String str, String str2, String str3, String str4, Result result, Result result2, View view, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = aVar.f2804a;
                }
                if ((i & 2) != 0) {
                    str2 = aVar.b;
                }
                if ((i & 4) != 0) {
                    str3 = aVar.c;
                }
                if ((i & 8) != 0) {
                    str4 = aVar.d;
                }
                if ((i & 16) != 0) {
                    result = aVar.e;
                }
                if ((i & 32) != 0) {
                    result2 = aVar.f;
                }
                if ((i & 64) != 0) {
                    view = aVar.g;
                }
                Result result3 = result2;
                View view2 = view;
                Result result4 = result;
                String str5 = str3;
                return aVar.a(str, str2, str5, str4, result4, result3, view2);
            }
        }

        public b(a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f2803a = data;
        }

        public final a a() {
            return this.f2803a;
        }

        public final JSONObject b() {
            JSONObject jSONObject = new JSONObject();
            if (this.f2803a.o() != null) {
                a(jSONObject, "title");
            }
            if (this.f2803a.i() != null) {
                a(jSONObject, C3040d4.h.F0);
            }
            if (this.f2803a.j() != null) {
                a(jSONObject, "body");
            }
            if (this.f2803a.k() != null) {
                a(jSONObject, "cta");
            }
            Result<Drawable> l = this.f2803a.l();
            if (l != null) {
                a(jSONObject, "icon", l.getValue());
            }
            Result<WebView> m = this.f2803a.m();
            if (m != null) {
                a(jSONObject, "media", m.getValue());
            }
            return jSONObject;
        }

        private static final void a(JSONObject jSONObject, String str) {
            jSONObject.put(str, new JSONObject().put("success", true));
        }

        private static final <T> void a(JSONObject jSONObject, String str, Object obj) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", Result.m10248isSuccessimpl(obj));
            Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(obj);
            if (m10244exceptionOrNullimpl != null) {
                String message = m10244exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "unknown reason";
                }
                jSONObject2.put("reason", message);
            }
            Unit unit = Unit.INSTANCE;
            jSONObject.put(str, jSONObject2);
        }
    }

    public B8(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View privacyIcon) {
        Intrinsics.checkNotNullParameter(privacyIcon, "privacyIcon");
        this.f2801a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = drawable;
        this.f = webView;
        this.g = privacyIcon;
    }

    public final String a() {
        return this.f2801a;
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

    public final Drawable e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B8)) {
            return false;
        }
        B8 b8 = (B8) obj;
        return Intrinsics.areEqual(this.f2801a, b8.f2801a) && Intrinsics.areEqual(this.b, b8.b) && Intrinsics.areEqual(this.c, b8.c) && Intrinsics.areEqual(this.d, b8.d) && Intrinsics.areEqual(this.e, b8.e) && Intrinsics.areEqual(this.f, b8.f) && Intrinsics.areEqual(this.g, b8.g);
    }

    public final WebView f() {
        return this.f;
    }

    public final View g() {
        return this.g;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        String str = this.f2801a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Drawable drawable = this.e;
        int hashCode5 = (hashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        WebView webView = this.f;
        return ((hashCode5 + (webView != null ? webView.hashCode() : 0)) * 31) + this.g.hashCode();
    }

    public final String i() {
        return this.c;
    }

    public final String j() {
        return this.d;
    }

    public final Drawable k() {
        return this.e;
    }

    public final WebView l() {
        return this.f;
    }

    public final View m() {
        return this.g;
    }

    public final String n() {
        return this.f2801a;
    }

    public String toString() {
        return "ISNNativeAdData(title=" + this.f2801a + ", advertiser=" + this.b + ", body=" + this.c + ", cta=" + this.d + ", icon=" + this.e + ", mediaView=" + this.f + ", privacyIcon=" + this.g + ")";
    }

    public final B8 a(String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View privacyIcon) {
        Intrinsics.checkNotNullParameter(privacyIcon, "privacyIcon");
        return new B8(str, str2, str3, str4, drawable, webView, privacyIcon);
    }

    public static /* synthetic */ B8 a(B8 b8, String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            str = b8.f2801a;
        }
        if ((i & 2) != 0) {
            str2 = b8.b;
        }
        if ((i & 4) != 0) {
            str3 = b8.c;
        }
        if ((i & 8) != 0) {
            str4 = b8.d;
        }
        if ((i & 16) != 0) {
            drawable = b8.e;
        }
        if ((i & 32) != 0) {
            webView = b8.f;
        }
        if ((i & 64) != 0) {
            view = b8.g;
        }
        WebView webView2 = webView;
        View view2 = view;
        Drawable drawable2 = drawable;
        String str5 = str3;
        return b8.a(str, str2, str5, str4, drawable2, webView2, view2);
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final S8 f2802a;
        private final InterfaceC2983a1 b;

        public a(S8 imageLoader, InterfaceC2983a1 adViewManagement) {
            Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
            Intrinsics.checkNotNullParameter(adViewManagement, "adViewManagement");
            this.f2802a = imageLoader;
            this.b = adViewManagement;
        }

        private final Result<Drawable> b(String str) {
            if (str == null) {
                return null;
            }
            return Result.m10240boximpl(this.f2802a.a(str));
        }

        public final b a(Context activityContext, JSONObject json) {
            String str;
            String str2;
            String str3;
            String str4;
            String b;
            String b2;
            String b3;
            String b4;
            Intrinsics.checkNotNullParameter(activityContext, "activityContext");
            Intrinsics.checkNotNullParameter(json, "json");
            JSONObject optJSONObject = json.optJSONObject("title");
            if (optJSONObject != null) {
                b4 = C8.b(optJSONObject, "text");
                str = b4;
            } else {
                str = null;
            }
            JSONObject optJSONObject2 = json.optJSONObject(C3040d4.h.F0);
            if (optJSONObject2 != null) {
                b3 = C8.b(optJSONObject2, "text");
                str2 = b3;
            } else {
                str2 = null;
            }
            JSONObject optJSONObject3 = json.optJSONObject("body");
            if (optJSONObject3 != null) {
                b2 = C8.b(optJSONObject3, "text");
                str3 = b2;
            } else {
                str3 = null;
            }
            JSONObject optJSONObject4 = json.optJSONObject("cta");
            if (optJSONObject4 != null) {
                b = C8.b(optJSONObject4, "text");
                str4 = b;
            } else {
                str4 = null;
            }
            JSONObject optJSONObject5 = json.optJSONObject("icon");
            String b5 = optJSONObject5 != null ? C8.b(optJSONObject5, "url") : null;
            JSONObject optJSONObject6 = json.optJSONObject("media");
            String b6 = optJSONObject6 != null ? C8.b(optJSONObject6, "adViewId") : null;
            JSONObject optJSONObject7 = json.optJSONObject(C3040d4.h.J0);
            return new b(new b.a(str, str2, str3, str4, b(b5), a(b6), C3032cd.f3232a.a(activityContext, optJSONObject7 != null ? C8.b(optJSONObject7, "url") : null, this.f2802a)));
        }

        private final Result<WebView> a(String str) {
            if (str == null) {
                return null;
            }
            F8 a2 = this.b.a(str);
            WebView presentingView = a2 != null ? a2.getPresentingView() : null;
            if (presentingView == null) {
                Result.Companion companion = Result.INSTANCE;
                return Result.m10240boximpl(Result.m10241constructorimpl(ResultKt.createFailure(new Exception("missing adview for id: '" + str + "'"))));
            }
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10240boximpl(Result.m10241constructorimpl(presentingView));
        }
    }
}
