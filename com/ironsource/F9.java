package com.ironsource;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import com.ironsource.L8;
import com.ironsource.O;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class F9 implements Od, InterfaceC3378x4, InterfaceC3361w4, InterfaceC3327u4, InterfaceC3344v4, K9, InterfaceC3369wc {
    private static final String m = "IronSourceAdsPublisherAgent";
    private static F9 n;

    /* renamed from: a, reason: collision with root package name */
    private com.ironsource.sdk.controller.e f2864a;
    private String b;
    private String c;
    private W4 d;
    private Xb e;
    private C3091g4 g;
    private boolean f = false;
    private FeaturesManager h = FeaturesManager.getInstance();
    private L8.a i = C3334ub.O().j();
    private O.a j = C3334ub.O().E();
    private O k = C3334ub.U().G();
    private InterfaceC3196m8 l = C3334ub.U().t();

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2865a;
        final /* synthetic */ String b;
        final /* synthetic */ V4 c;

        a(String str, String str2, V4 v4) {
            this.f2865a = str;
            this.b = str2;
            this.c = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            F9 f9 = F9.this;
            f9.f2864a.a(this.f2865a, this.b, this.c, (InterfaceC3378x4) f9);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f2866a;

        b(JSONObject jSONObject) {
            this.f2866a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            F9 f9 = F9.this;
            f9.f2864a.a(this.f2866a, (InterfaceC3378x4) f9);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2867a;
        final /* synthetic */ String b;
        final /* synthetic */ V4 c;

        c(String str, String str2, V4 v4) {
            this.f2867a = str;
            this.b = str2;
            this.c = v4;
        }

        @Override // java.lang.Runnable
        public void run() {
            F9 f9 = F9.this;
            f9.f2864a.a(this.f2867a, this.b, this.c, (InterfaceC3361w4) f9);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f2868a;

        d(String str) {
            this.f2868a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            F9 f9 = F9.this;
            f9.f2864a.a(this.f2868a, f9);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f2869a;

        e(JSONObject jSONObject) {
            this.f2869a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            F9 f9 = F9.this;
            f9.f2864a.a(this.f2869a, (InterfaceC3361w4) f9);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ B9 f2870a;
        final /* synthetic */ Map b;

        f(B9 b9, Map map) {
            this.f2870a = b9;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3230o8.e eVar = this.f2870a.i() ? C3230o8.e.Banner : C3230o8.e.Interstitial;
            V4 a2 = F9.this.d.a(eVar, this.f2870a);
            C3264q8 c3264q8 = new C3264q8();
            c3264q8.a(D5.x, Boolean.valueOf(this.f2870a.j())).a(D5.G, Boolean.valueOf(this.f2870a.m())).a(D5.v, this.f2870a.g()).a(D5.w, L9.a(this.f2870a)).a(D5.I, Long.valueOf(L.f2933a.b(this.f2870a.e())));
            C3348v8.a(Md.h, c3264q8.a());
            if (eVar == C3230o8.e.Banner) {
                F9 f9 = F9.this;
                f9.f2864a.a(f9.b, f9.c, a2, (InterfaceC3344v4) f9);
                F9 f92 = F9.this;
                f92.f2864a.a(a2, this.b, (InterfaceC3344v4) f92);
                return;
            }
            F9 f93 = F9.this;
            f93.f2864a.a(f93.b, f93.c, a2, (InterfaceC3361w4) f93);
            F9 f94 = F9.this;
            f94.f2864a.b(a2, this.b, f94);
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ V4 f2871a;
        final /* synthetic */ Map b;

        g(V4 v4, Map map) {
            this.f2871a = v4;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            F9 f9 = F9.this;
            f9.f2864a.a(this.f2871a, this.b, (InterfaceC3361w4) f9);
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ B9 f2872a;

        h(B9 b9) {
            this.f2872a = b9;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3230o8.e eVar = this.f2872a.i() ? C3230o8.e.Banner : C3230o8.e.Interstitial;
            V4 a2 = F9.this.d.a(eVar, this.f2872a);
            C3264q8 c3264q8 = new C3264q8();
            c3264q8.a(D5.x, Boolean.valueOf(this.f2872a.j())).a(D5.v, this.f2872a.g()).a(D5.w, L9.a(this.f2872a)).a("isMultipleAdObjects", Boolean.valueOf(this.f2872a.l()));
            C3348v8.a(Md.m, c3264q8.a());
            if (eVar == C3230o8.e.Banner) {
                F9.this.f2864a.a(a2);
            } else {
                a2.a(false);
                F9.this.f2864a.b(a2);
            }
        }
    }

    private F9(Context context, int i) {
        c(context);
    }

    public static K9 a(Context context, String str, String str2) {
        return a(str, str2, context);
    }

    public static synchronized F9 b(Context context) throws Exception {
        F9 a2;
        synchronized (F9.class) {
            a2 = a(context, 0);
        }
        return a2;
    }

    private void c(Context context) {
        try {
            SDKUtils.getNetworkConfiguration();
            R9.a(context);
            IronSourceStorageUtils.initializeCacheDirectory(context, new Ze(SDKUtils.getNetworkConfiguration().optJSONObject(C3040d4.a.k)));
            R9.e().d(SDKUtils.getSDKVersion());
            this.d = new W4();
            C3091g4 c3091g4 = new C3091g4();
            this.g = c3091g4;
            if (context instanceof Activity) {
                c3091g4.a((Activity) context);
            }
            int debugMode = this.h.getDebugMode();
            this.e = new Xb();
            this.f2864a = new com.ironsource.sdk.controller.e(context, this.g, this.d, R7.f3025a, debugMode, this.h.getDataManagerConfig(), this.b, this.c, this.e);
            Logger.enableLogging(debugMode);
            Logger.i(m, "C'tor");
            a(context);
            this.e.d();
            this.e.e();
            this.e.a(context);
            this.e.b();
            this.e.a();
            this.e.b(context);
            this.e.c();
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    @Override // com.ironsource.InterfaceC3361w4
    public void d(String str, String str2) {
        V4 d2 = d(C3230o8.e.Interstitial, str);
        if (d2 != null) {
            B9 c2 = d2.c();
            this.j.a(EnumC3188m0.SHOW_FAIL, c2.e());
            if (c(c2)) {
                this.i.a(new Ie(this.k.a(c2.e())));
            }
            InterfaceC3318tc b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialShowFailed(str2);
            }
        }
    }

    @Override // com.ironsource.InterfaceC3361w4
    public void onInterstitialAdRewarded(String str, int i) {
        V4 d2 = d(C3230o8.e.Interstitial, str);
        InterfaceC3318tc b2 = b(d2);
        if (d2 == null || b2 == null) {
            return;
        }
        b2.onInterstitialAdRewarded(str, i);
    }

    @Override // com.ironsource.Od, com.ironsource.K9
    public void onPause(Activity activity) {
        if (this.f) {
            return;
        }
        b(activity);
    }

    @Override // com.ironsource.Od, com.ironsource.K9
    public void onResume(Activity activity) {
        if (this.f) {
            return;
        }
        c(activity);
    }

    public static synchronized K9 a(String str, String str2, Context context) {
        F9 f9;
        synchronized (F9.class) {
            if (n == null) {
                C3348v8.a(Md.f2953a);
                n = new F9(str, str2, context);
            }
            f9 = n;
        }
        return f9;
    }

    private InterfaceC3318tc b(V4 v4) {
        if (v4 == null) {
            return null;
        }
        return (InterfaceC3318tc) v4.i();
    }

    @Override // com.ironsource.Od
    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("demandSourceName");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f2864a.a(new d(optString));
    }

    @Override // com.ironsource.InterfaceC3327u4
    public void b(C3230o8.e eVar, String str) {
        InterfaceC3318tc b2;
        V4 d2 = d(eVar, str);
        if (d2 != null) {
            if (eVar == C3230o8.e.RewardedVideo) {
                InterfaceC3403yc c2 = c(d2);
                if (c2 != null) {
                    c2.d();
                    return;
                }
                return;
            }
            if (eVar != C3230o8.e.Interstitial || (b2 = b(d2)) == null) {
                return;
            }
            b2.onInterstitialClose();
        }
    }

    public static synchronized F9 a(Context context, int i) throws Exception {
        F9 f9;
        synchronized (F9.class) {
            Logger.i(m, "getInstance()");
            if (n == null) {
                n = new F9(context, i);
            }
            f9 = n;
        }
        return f9;
    }

    private V4 d(C3230o8.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.d.a(eVar, str);
    }

    @Override // com.ironsource.K9
    public com.ironsource.sdk.controller.e a() {
        return this.f2864a;
    }

    private InterfaceC3284rc a(V4 v4) {
        if (v4 == null) {
            return null;
        }
        return (InterfaceC3284rc) v4.i();
    }

    @Override // com.ironsource.Od
    public void a(String str, String str2, String str3, Map<String, String> map, InterfaceC3403yc interfaceC3403yc) {
        this.b = str;
        this.c = str2;
        this.f2864a.a(new a(str, str2, this.d.a(C3230o8.e.RewardedVideo, str3, map, interfaceC3403yc)));
    }

    F9(String str, String str2, Context context) {
        this.b = str;
        this.c = str2;
        c(context);
    }

    @Override // com.ironsource.InterfaceC3378x4
    public void b(String str, String str2) {
        InterfaceC3403yc c2;
        V4 d2 = d(C3230o8.e.RewardedVideo, str);
        if (d2 == null || (c2 = c(d2)) == null) {
            return;
        }
        c2.a(str2);
    }

    @Override // com.ironsource.InterfaceC3361w4
    public void b(String str) {
        V4 d2 = d(C3230o8.e.Interstitial, str);
        if (d2 != null) {
            B9 c2 = d2.c();
            this.j.a(EnumC3188m0.SHOW_SUCCESS, c2.e());
            if (c(c2)) {
                this.i.a(new Je(this.k.a(c2.e())));
            }
            InterfaceC3318tc b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialShowSuccess();
            }
        }
    }

    @Override // com.ironsource.Od
    public void a(JSONObject jSONObject) {
        this.f2864a.a(new b(jSONObject));
    }

    @Override // com.ironsource.Od
    public void a(String str, String str2, String str3, Map<String, String> map, InterfaceC3318tc interfaceC3318tc) {
        this.b = str;
        this.c = str2;
        this.f2864a.a(new c(str, str2, this.d.a(C3230o8.e.Interstitial, str3, map, interfaceC3318tc)));
    }

    @Override // com.ironsource.Od
    public boolean a(String str) {
        return this.f2864a.a(str);
    }

    @Override // com.ironsource.Od, com.ironsource.K9
    public void a(Activity activity) {
        try {
            Logger.i(m, "release()");
            Z4.g();
            this.g.b();
            this.f2864a.a((Context) activity);
            this.f2864a.a();
            this.f2864a = null;
        } catch (Exception e2) {
            C3260q4.d().a(e2);
        }
        n = null;
    }

    @Override // com.ironsource.M9
    public void b(Activity activity, B9 b9, Map<String, String> map) {
        if (C3334ub.U().g().d()) {
            this.g.a(activity);
        }
        a(b9, map);
    }

    private void b(B9 b9, Map<String, String> map) {
        Logger.d(m, "loadOnNewInstance " + b9.e());
        this.f2864a.a(new f(b9, map));
    }

    @Override // com.ironsource.M9
    public void b(B9 b9) {
        Logger.d(m, "destroyInstance " + b9.e());
        if (c(b9)) {
            this.j.a(EnumC3188m0.DESTROYED, b9.e());
            this.i.a(new Fe(this.k.a(b9.e())));
        }
        this.f2864a.a(new h(b9));
    }

    @Override // com.ironsource.InterfaceC3327u4
    public void a(C3230o8.e eVar, String str, Y0 y0) {
        InterfaceC3284rc a2;
        V4 d2 = d(eVar, str);
        if (d2 != null) {
            d2.b(2);
            if (eVar == C3230o8.e.RewardedVideo) {
                InterfaceC3403yc c2 = c(d2);
                if (c2 != null) {
                    c2.a(y0);
                    return;
                }
                return;
            }
            if (eVar == C3230o8.e.Interstitial) {
                InterfaceC3318tc b2 = b(d2);
                if (b2 != null) {
                    b2.onInterstitialInitSuccess();
                    return;
                }
                return;
            }
            if (eVar != C3230o8.e.Banner || (a2 = a(d2)) == null) {
                return;
            }
            a2.onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.InterfaceC3369wc
    public void b(Activity activity) {
        try {
            this.f2864a.e();
            this.f2864a.a((Context) activity);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    private InterfaceC3403yc c(V4 v4) {
        if (v4 == null) {
            return null;
        }
        return (InterfaceC3403yc) v4.i();
    }

    @Override // com.ironsource.Od
    public void c(JSONObject jSONObject) {
        this.f2864a.a(new e(jSONObject));
    }

    @Override // com.ironsource.InterfaceC3378x4
    public void c(String str) {
        InterfaceC3403yc c2;
        V4 d2 = d(C3230o8.e.RewardedVideo, str);
        if (d2 == null || (c2 = c(d2)) == null) {
            return;
        }
        c2.c();
    }

    @Override // com.ironsource.InterfaceC3327u4
    public void c(C3230o8.e eVar, String str) {
        InterfaceC3403yc c2;
        V4 d2 = d(eVar, str);
        if (d2 != null) {
            if (eVar == C3230o8.e.Interstitial) {
                InterfaceC3318tc b2 = b(d2);
                if (b2 != null) {
                    b2.onInterstitialOpen();
                    return;
                }
                return;
            }
            if (eVar != C3230o8.e.RewardedVideo || (c2 = c(d2)) == null) {
                return;
            }
            c2.b();
        }
    }

    @Override // com.ironsource.InterfaceC3327u4
    public void a(C3230o8.e eVar, String str, String str2) {
        InterfaceC3284rc a2;
        V4 d2 = d(eVar, str);
        C3264q8 a3 = new C3264q8().a(D5.v, str).a(D5.w, eVar).a(D5.A, str2);
        if (d2 != null) {
            L l = L.f2933a;
            a3.a(D5.I, Long.valueOf(l.b(d2.h())));
            a3.a(D5.x, Boolean.valueOf(C3365w8.a(d2)));
            l.a(d2.h());
            d2.b(3);
            if (eVar == C3230o8.e.RewardedVideo) {
                InterfaceC3403yc c2 = c(d2);
                if (c2 != null) {
                    c2.b(str2);
                }
            } else if (eVar == C3230o8.e.Interstitial) {
                InterfaceC3318tc b2 = b(d2);
                if (b2 != null) {
                    b2.onInterstitialInitFailed(str2);
                }
            } else if (eVar == C3230o8.e.Banner && (a2 = a(d2)) != null) {
                a2.onBannerLoadFail(str2);
            }
        }
        C3348v8.a(Md.i, a3.a());
    }

    @Override // com.ironsource.InterfaceC3344v4
    public void c(String str, String str2) {
        InterfaceC3284rc a2;
        V4 d2 = d(C3230o8.e.Banner, str);
        if (d2 == null || (a2 = a(d2)) == null) {
            return;
        }
        a2.onBannerLoadFail(str2);
    }

    private void c(B9 b9, Map<String, String> map) {
        try {
            map = a(map);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            C3264q8 a2 = new C3264q8().a(D5.A, e2.getMessage()).a(D5.x, Boolean.valueOf(b9.j())).a(D5.G, Boolean.valueOf(b9.m())).a(D5.v, b9.g()).a(D5.w, L9.a(b9)).a(D5.I, Long.valueOf(L.f2933a.b(b9.e())));
            L.f2933a.a(b9.e());
            C3348v8.a(Md.k, a2.a());
            IronLog.INTERNAL.error(e2.toString());
            Logger.d(m, "loadInAppBiddingAd failed decoding  ADM " + e2.getMessage());
        }
        b(b9, map);
    }

    @Override // com.ironsource.InterfaceC3378x4
    public void a(String str, int i) {
        InterfaceC3403yc c2;
        V4 d2 = d(C3230o8.e.RewardedVideo, str);
        if (d2 == null || (c2 = c(d2)) == null) {
            return;
        }
        c2.a(i);
    }

    @Override // com.ironsource.InterfaceC3369wc
    public void c(Activity activity) {
        this.g.a(activity);
        this.f2864a.g();
        this.f2864a.b(activity);
    }

    @Override // com.ironsource.InterfaceC3327u4
    public void a(C3230o8.e eVar, String str) {
        InterfaceC3284rc a2;
        V4 d2 = d(eVar, str);
        if (d2 != null) {
            if (eVar == C3230o8.e.RewardedVideo) {
                InterfaceC3403yc c2 = c(d2);
                if (c2 != null) {
                    c2.a();
                    return;
                }
                return;
            }
            if (eVar == C3230o8.e.Interstitial) {
                InterfaceC3318tc b2 = b(d2);
                if (b2 != null) {
                    b2.onInterstitialClick();
                    return;
                }
                return;
            }
            if (eVar != C3230o8.e.Banner || (a2 = a(d2)) == null) {
                return;
            }
            a2.onBannerClick();
        }
    }

    public boolean c(B9 b9) {
        return b9.l() && !b9.i() && a(b9);
    }

    @Override // com.ironsource.InterfaceC3327u4
    public void a(C3230o8.e eVar, String str, String str2, JSONObject jSONObject) {
        InterfaceC3284rc a2;
        V4 d2 = d(eVar, str);
        if (d2 == null || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            Logger.i(m, "Received Event Notification: " + str2 + " for demand source: " + d2.f());
            if (eVar == C3230o8.e.Interstitial) {
                InterfaceC3318tc b2 = b(d2);
                if (b2 != null) {
                    jSONObject.put("demandSourceName", str);
                    b2.onInterstitialEventNotificationReceived(str2, jSONObject);
                    return;
                }
                return;
            }
            if (eVar == C3230o8.e.RewardedVideo) {
                InterfaceC3403yc c2 = c(d2);
                if (c2 != null) {
                    jSONObject.put("demandSourceName", str);
                    c2.a(str2, jSONObject);
                    return;
                }
                return;
            }
            if (eVar != C3230o8.e.Banner || (a2 = a(d2)) == null) {
                return;
            }
            jSONObject.put("demandSourceName", str);
            if (str2.equalsIgnoreCase("impressions")) {
                a2.onBannerShowSuccess();
            }
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
    }

    @Override // com.ironsource.InterfaceC3361w4
    public void a(String str, JSONObject jSONObject) {
        C3230o8.e eVar = C3230o8.e.Interstitial;
        V4 d2 = d(eVar, str);
        C3264q8 a2 = new C3264q8().a(D5.v, str);
        if (d2 != null) {
            B9 c2 = d2.c();
            this.j.a(jSONObject, EnumC3188m0.LOAD_SUCCESS, c2.e());
            if (c(c2)) {
                this.i.a(new He(this.k.a(c2.e())));
            }
            C3264q8 a3 = a2.a(D5.w, C3365w8.a(d2, eVar)).a(D5.x, Boolean.valueOf(C3365w8.a(d2)));
            L l = L.f2933a;
            a3.a(D5.I, Long.valueOf(l.b(d2.h())));
            l.a(d2.h());
            InterfaceC3318tc b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialLoadSuccess(d2.c());
            }
        }
        C3348v8.a(Md.l, a2.a());
    }

    @Override // com.ironsource.InterfaceC3361w4
    public void a(String str, String str2) {
        Object obj;
        C3230o8.e eVar = C3230o8.e.Interstitial;
        V4 d2 = d(eVar, str);
        C3264q8 c3264q8 = new C3264q8();
        c3264q8.a(D5.A, str2).a(D5.v, str);
        if (d2 != null) {
            C3264q8 a2 = c3264q8.a(D5.w, C3365w8.a(d2, eVar));
            if (d2.e() == 2) {
                obj = D5.E;
            } else {
                obj = D5.F;
            }
            C3264q8 a3 = a2.a(D5.y, obj).a(D5.x, Boolean.valueOf(C3365w8.a(d2)));
            L l = L.f2933a;
            a3.a(D5.I, Long.valueOf(l.b(d2.h())));
            l.a(d2.h());
            InterfaceC3318tc b2 = b(d2);
            if (b2 != null) {
                b2.onInterstitialLoadFailed(str2);
            }
        }
        C3348v8.a(Md.g, c3264q8.a());
    }

    @Override // com.ironsource.Od
    public void a(String str, String str2, int i) {
        C3230o8.e productType;
        V4 a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (productType = SDKUtils.getProductType(str)) == null || (a2 = this.d.a(productType, str2)) == null) {
            return;
        }
        a2.c(i);
    }

    @Override // com.ironsource.InterfaceC3344v4
    public void a(String str, C3078f8 c3078f8) {
        InterfaceC3284rc a2;
        V4 d2 = d(C3230o8.e.Banner, str);
        if (d2 == null || (a2 = a(d2)) == null) {
            return;
        }
        a2.onBannerLoadSuccess(d2.c(), c3078f8);
    }

    @Override // com.ironsource.M9
    public void a(B9 b9, Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        map.put(C3040d4.h.y0, String.valueOf(currentTimeMillis));
        L.f2933a.a(b9.e(), currentTimeMillis);
        C3264q8 c3264q8 = new C3264q8();
        c3264q8.a(D5.x, Boolean.valueOf(b9.j())).a(D5.G, Boolean.valueOf(b9.m())).a(D5.v, b9.g()).a(D5.w, L9.a(b9)).a(D5.I, Long.valueOf(currentTimeMillis));
        C3348v8.a(Md.f, c3264q8.a());
        Logger.d(m, "loadAd " + b9.e());
        N n2 = new N(b9);
        this.j.a(n2);
        this.j.a(new JSONObject(map), EnumC3188m0.LOAD_REQUEST, n2.c());
        if (c(b9)) {
            this.i.a(new Ge(n2));
        }
        if (b9.k()) {
            c(b9, map);
        } else {
            b(b9, map);
        }
    }

    private Map<String, String> a(Map<String, String> map) {
        map.put("adm", SDKUtils.decodeString(map.get("adm")));
        return map;
    }

    @Override // com.ironsource.M9
    public void a(Activity activity, B9 b9, Map<String, String> map) {
        this.g.a(activity);
        Logger.i(m, "showAd " + b9.e());
        V4 a2 = this.d.a(C3230o8.e.Interstitial, b9.e());
        if (a2 == null) {
            return;
        }
        this.f2864a.a(new g(a2, map));
    }

    @Override // com.ironsource.M9
    public boolean a(B9 b9) {
        Logger.d(m, "isAdAvailable " + b9.e());
        V4 a2 = this.d.a(C3230o8.e.Interstitial, b9.e());
        if (a2 == null) {
            return false;
        }
        return a2.d();
    }

    public void a(Context context) {
        this.f = false;
        Boolean c2 = this.l.c(C3040d4.a.g);
        if (c2 == null) {
            c2 = Boolean.FALSE;
        }
        boolean booleanValue = c2.booleanValue();
        this.f = booleanValue;
        if (booleanValue) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new C3120i(this));
            } catch (Throwable th) {
                C3260q4.d().a(th);
                C3264q8 c3264q8 = new C3264q8();
                c3264q8.a(D5.y, th.getMessage());
                C3348v8.a(Md.u, c3264q8.a());
            }
        }
    }
}
