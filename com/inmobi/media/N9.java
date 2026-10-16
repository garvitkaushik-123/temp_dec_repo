package com.inmobi.media;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class N9 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2373a;
    public final String b;
    public final C2897ue c;
    public boolean d;
    public final InterfaceC2971z5 e;
    public final String f;
    public final boolean g;
    public final String h;
    public final HashMap i;
    public final HashMap j;
    public final HashMap k;
    public JSONObject l;
    public String m;
    public P9 n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public C2879tc w;
    public boolean x;

    public N9(String requestType, String str, C2897ue c2897ue, boolean z, InterfaceC2971z5 interfaceC2971z5, String requestContentType, boolean z2) {
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        Intrinsics.checkNotNullParameter(requestContentType, "requestContentType");
        this.f2373a = requestType;
        this.b = str;
        this.c = c2897ue;
        this.d = z;
        this.e = interfaceC2971z5;
        this.f = requestContentType;
        this.g = z2;
        this.h = "N9";
        this.i = new HashMap();
        this.m = Uc.b();
        this.p = 60000;
        this.q = 60000;
        this.r = true;
        this.t = true;
        this.u = true;
        this.v = true;
        this.x = true;
        if (Intrinsics.areEqual("GET", requestType)) {
            this.j = new HashMap();
        } else if (Intrinsics.areEqual("POST", requestType)) {
            this.k = new HashMap();
            this.l = new JSONObject();
        }
    }

    public final void a(Function1 onResponse) {
        Intrinsics.checkNotNullParameter(onResponse, "onResponse");
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "TAG", "executeAsync: ").append(this.b).toString());
        }
        e();
        if (!this.d) {
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).c(TAG, "Dropping REQUEST FOR GDPR");
            }
            P9 p9 = new P9();
            p9.d = new I9(EnumC2790o4.j, "Network Request dropped as current request is not GDPR compliant.");
            onResponse.invoke(p9);
            return;
        }
        C2895uc request = a();
        M9 responseListener = new M9(this, onResponse);
        Intrinsics.checkNotNullParameter(responseListener, "responseListener");
        request.l = responseListener;
        Set set = AbstractC2927wc.f2744a;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(request, "request");
        AbstractC2927wc.f2744a.add(request);
        AbstractC2927wc.a(request, 0L);
    }

    public final P9 b() {
        C2962yc a2;
        I9 i9;
        InterfaceC2971z5 interfaceC2971z5 = this.e;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).c(str, H6.a(str, "TAG", "Executing network request to URL: ").append(this.b).toString());
        }
        e();
        if (!this.d) {
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).c(TAG, "Dropping REQUEST FOR GDPR");
            }
            P9 p9 = new P9();
            p9.d = new I9(EnumC2790o4.j, "Network Request dropped as current request is not GDPR compliant.");
            return p9;
        }
        if (this.n != null) {
            InterfaceC2971z5 interfaceC2971z53 = this.e;
            if (interfaceC2971z53 != null) {
                String str2 = this.h;
                StringBuilder a3 = H6.a(str2, "TAG", "response has been failed before execute - ");
                P9 p92 = this.n;
                ((A5) interfaceC2971z53).c(str2, a3.append(p92 != null ? p92.d : null).toString());
            }
            P9 p93 = this.n;
            Intrinsics.checkNotNull(p93);
            return p93;
        }
        C2895uc request = a();
        InterfaceC2971z5 interfaceC2971z54 = this.e;
        if (interfaceC2971z54 != null) {
            String str3 = this.h;
            ((A5) interfaceC2971z54).c(str3, H6.a(str3, "TAG", "Making network request to: ").append(request.f2723a).toString());
        }
        Intrinsics.checkNotNullParameter(request, "request");
        do {
            a2 = H9.a(request, (Function2) null);
            i9 = a2.f2765a;
        } while ((i9 != null ? i9.f2315a : null) == EnumC2790o4.m);
        P9 response = D4.a(a2);
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(this, "request");
        return response;
    }

    public final String d() {
        String str = this.b;
        HashMap hashMap = this.j;
        if (hashMap != null) {
            boolean z = T9.f2439a;
            T9.a(hashMap);
            String a2 = T9.a(C3040d4.i.c, (Map) this.j);
            InterfaceC2971z5 interfaceC2971z5 = this.e;
            if (interfaceC2971z5 != null) {
                String str2 = this.h;
                ((A5) interfaceC2971z5).c(str2, I6.a(str2, "TAG", "Get params: ", a2));
            }
            int length = a2.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = Intrinsics.compare((int) a2.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            if (a2.subSequence(i, length + 1).toString().length() > 0) {
                if (str != null && !StringsKt.contains$default((CharSequence) str, (CharSequence) "?", false, 2, (Object) null)) {
                    str = str.concat("?");
                }
                if (str != null && !StringsKt.endsWith$default(str, C3040d4.i.c, false, 2, (Object) null) && !StringsKt.endsWith$default(str, "?", false, 2, (Object) null)) {
                    str = str.concat(C3040d4.i.c);
                }
                str = str + a2;
            }
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final void e() {
        f();
        this.i.put("User-Agent", Uc.k());
        if (Intrinsics.areEqual("POST", this.f2373a)) {
            this.i.put("Content-Type", this.f);
            if (this.g) {
                this.i.put(HttpHeaders.CONTENT_ENCODING, "gzip");
            } else {
                this.i.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(c().length()));
            }
        }
    }

    public void f() {
        HashMap hashMap;
        JSONObject c;
        HashMap hashMap2;
        G4 g4 = G4.f2291a;
        g4.j();
        this.d = g4.a(this.d);
        if (Intrinsics.areEqual("GET", this.f2373a)) {
            HashMap hashMap3 = this.j;
            if (this.t) {
                if (hashMap3 != null) {
                    hashMap3.putAll(C2623e1.e);
                }
                if (hashMap3 != null) {
                    hashMap3.putAll(L3.f2348a.a(this.o));
                }
                if (hashMap3 != null) {
                    hashMap3.putAll(Y4.a());
                }
            }
            HashMap hashMap4 = this.j;
            if (this.u) {
                a(hashMap4);
            }
        } else if (Intrinsics.areEqual("POST", this.f2373a)) {
            HashMap hashMap5 = this.k;
            if (this.t) {
                if (hashMap5 != null) {
                    hashMap5.putAll(C2623e1.e);
                }
                if (hashMap5 != null) {
                    hashMap5.putAll(L3.f2348a.a(this.o));
                }
                if (hashMap5 != null) {
                    hashMap5.putAll(Y4.a());
                }
            }
            HashMap hashMap6 = this.k;
            if (this.u) {
                a(hashMap6);
            }
        }
        if (this.v && (c = G4.c()) != null) {
            if (Intrinsics.areEqual("GET", this.f2373a)) {
                HashMap hashMap7 = this.j;
                if (hashMap7 != null) {
                    String jSONObject = c.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
                }
            } else if (Intrinsics.areEqual("POST", this.f2373a) && (hashMap2 = this.k) != null) {
                String jSONObject2 = c.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            }
        }
        if (this.x) {
            if (Intrinsics.areEqual("GET", this.f2373a)) {
                HashMap hashMap8 = this.j;
                if (hashMap8 != null) {
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual("POST", this.f2373a) || (hashMap = this.k) == null) {
                return;
            }
        }
    }

    public final String c() {
        String str = this.f;
        if (Intrinsics.areEqual(str, com.ironsource.D5.L)) {
            return String.valueOf(this.l);
        }
        if (!Intrinsics.areEqual(str, ShareTarget.ENCODING_TYPE_URL_ENCODED)) {
            return "";
        }
        boolean z = T9.f2439a;
        T9.a(this.k);
        return T9.a(C3040d4.i.c, (Map) this.k);
    }

    public /* synthetic */ N9(String str, String str2, C2897ue c2897ue, boolean z, InterfaceC2971z5 interfaceC2971z5, String str3, int i) {
        this(str, str2, c2897ue, (i & 8) != 0 ? false : z, interfaceC2971z5, (i & 32) != 0 ? ShareTarget.ENCODING_TYPE_URL_ENCODED : str3, false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public N9(String url, InterfaceC2971z5 interfaceC2971z5) {
        this("GET", url, (C2897ue) null, false, interfaceC2971z5, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter("GET", "requestType");
        Intrinsics.checkNotNullParameter(url, "url");
        this.v = false;
    }

    public final C2895uc a() {
        EnumC2846rc method;
        String type = this.f2373a;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, "GET")) {
            method = EnumC2846rc.f2696a;
        } else {
            method = Intrinsics.areEqual(type, "POST") ? EnumC2846rc.b : EnumC2846rc.f2696a;
        }
        String url = this.b;
        Intrinsics.checkNotNull(url);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        C2831qc c2831qc = new C2831qc(url, method);
        boolean z = T9.f2439a;
        T9.a(this.i);
        HashMap header = this.i;
        Intrinsics.checkNotNullParameter(header, "header");
        c2831qc.c = header;
        c2831qc.h = Integer.valueOf(this.p);
        c2831qc.i = Integer.valueOf(this.q);
        c2831qc.f = Boolean.valueOf(this.r);
        c2831qc.j = Boolean.valueOf(this.s);
        C2879tc retryPolicy = this.w;
        if (retryPolicy != null) {
            Intrinsics.checkNotNullParameter(retryPolicy, "retryPolicy");
            c2831qc.g = retryPolicy;
        }
        int ordinal = method.ordinal();
        if (ordinal == 0) {
            HashMap queryParams = this.j;
            if (queryParams != null) {
                InterfaceC2971z5 interfaceC2971z5 = this.e;
                if (interfaceC2971z5 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).c(TAG, "getParams " + queryParams);
                }
                Intrinsics.checkNotNullParameter(queryParams, "queryParams");
                c2831qc.d = queryParams;
            }
        } else if (ordinal == 1) {
            String postBody = c();
            InterfaceC2971z5 interfaceC2971z52 = this.e;
            if (interfaceC2971z52 != null) {
                String str = this.h;
                ((A5) interfaceC2971z52).c(str, I6.a(str, "TAG", "httpPostBody ", postBody));
            }
            Intrinsics.checkNotNullParameter(postBody, "postBody");
            c2831qc.e = postBody;
        }
        return new C2895uc(c2831qc);
    }

    public final void a(HashMap hashMap) {
        V0 b;
        String a2;
        C2897ue c2897ue = this.c;
        if (c2897ue == null || hashMap == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        try {
            if (c2897ue.f2725a.a() && (b = C2881te.f2715a.b()) != null && (a2 = b.a()) != null) {
                Intrinsics.checkNotNull(a2);
                hashMap3.put("GPID", a2);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("ue", "getSimpleName(...)");
        }
        String jSONObject = new JSONObject(hashMap3).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        hashMap2.put("u-id-map", jSONObject);
        hashMap.putAll(hashMap2);
    }
}
