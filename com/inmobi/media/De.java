package com.inmobi.media;

import android.content.ComponentName;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.window.embedding.ActivityFilter;
import androidx.window.embedding.ActivityRule;
import androidx.window.embedding.RuleController;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.iab.omid.library.inmobi.Omid;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class De {
    public static boolean b;

    /* renamed from: a, reason: collision with root package name */
    public static final De f2267a = new De();
    public static final Ce c = new Ce();

    public static final /* synthetic */ void a(De de) {
        de.getClass();
        b();
    }

    public static final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue("De", "TAG");
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            WebView webView = new WebView(context);
            webView.setWebViewClient(new wf());
            webView.clearCache(true);
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public static final void d(Context context) {
        C6 c6;
        String str;
        Context d;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(context, "$context");
        Vc vc = Vc.f2464a;
        if (vc.b(context) && F4.a(context).isEmpty()) {
            vc.a(context, false);
        }
        C2676h3 c2676h3 = C2676h3.f2585a;
        Intrinsics.checkNotNull("h3");
        LinkedList linkedList = new LinkedList(T1.a((C2608d3) Nc.d.getValue(), null, null, null, null, null, null, 63));
        C2676h3.b = linkedList;
        Object clone = linkedList.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.LinkedList<com.inmobi.signals.contextualdata.EncryptedContextualData>");
        C2676h3.c = (LinkedList) clone;
        ScheduledExecutorService scheduledExecutorService = C2638f0.f2564a;
        Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
        Intrinsics.checkNotNullParameter("starting", PglCryptUtils.KEY_MESSAGE);
        Log.i("AdQualityComponent", "starting");
        if (C2638f0.d == null) {
            C2638f0.d = new C2605d0(C2638f0.e);
        }
        C2605d0 c2605d0 = C2638f0.d;
        if (c2605d0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executor");
            c2605d0 = null;
        }
        if (c2605d0.b.get()) {
            Intrinsics.checkNotNullParameter("AdQualityComponent", "tag");
            Intrinsics.checkNotNullParameter("already started", PglCryptUtils.KEY_MESSAGE);
            Log.i("AdQualityComponent", "already started");
        } else {
            C2605d0 c2605d02 = C2638f0.d;
            if (c2605d02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("executor");
                c2605d02 = null;
            }
            c2605d02.a();
        }
        Q5.b();
        Q5.a();
        V3 v3 = U3.f2447a;
        LinkedHashMap linkedHashMap = O2.f2380a;
        AdConfig adConfig = (AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null);
        C2819q0 adReqDeprecateChecker = adConfig.getAdReqDeprecateChecker();
        U3.e = adReqDeprecateChecker != null ? adReqDeprecateChecker.a(true) : true;
        U3.e();
        if (adConfig.getRendering().getEnableImmersive()) {
            if (U3.i && (d = Uc.d()) != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d, "display_info_store");
                Intrinsics.checkNotNullParameter("safe_area", C3040d4.h.W);
                String string = a2.f2249a.getString("safe_area", null);
                if (string != null) {
                    try {
                        jSONObject = new JSONObject(string);
                    } catch (JSONException unused) {
                        Intrinsics.checkNotNullExpressionValue("U3", "TAG");
                    }
                    U3.f = jSONObject;
                    Intrinsics.checkNotNullExpressionValue("U3", "TAG");
                    Objects.toString(U3.f);
                }
                jSONObject = null;
                U3.f = jSONObject;
                Intrinsics.checkNotNullExpressionValue("U3", "TAG");
                Objects.toString(U3.f);
            }
            if (U3.i) {
                if (U3.f() != null) {
                    Intrinsics.checkNotNullExpressionValue("U3", "TAG");
                } else {
                    Context d2 = Uc.d();
                    if (d2 != null) {
                        ConcurrentHashMap concurrentHashMap2 = C6.b;
                        C6 a3 = B6.a(d2, "display_info_store");
                        Intrinsics.checkNotNullParameter("nav_bar_type", C3040d4.h.W);
                        int i = a3.f2249a.getInt("nav_bar_type", -1);
                        Integer valueOf = Integer.valueOf(i);
                        U3.g = valueOf;
                        if (i == -1) {
                            valueOf = null;
                        }
                        U3.g = valueOf;
                        Intrinsics.checkNotNullExpressionValue("U3", "TAG");
                    }
                }
            }
        }
        String str2 = C2616db.f2549a;
        try {
            Context d3 = Uc.d();
            if (d3 != null && C2616db.c.getPurchases().getInapp()) {
                Context d4 = Uc.d();
                if (d4 != null) {
                    ConcurrentHashMap concurrentHashMap3 = C6.b;
                    c6 = B6.a(d4, "purchase_store");
                } else {
                    c6 = null;
                }
                if (c6 != null) {
                    Intrinsics.checkNotNullParameter("purchase_pref", C3040d4.h.W);
                    str = c6.f2249a.getString("purchase_pref", null);
                } else {
                    str = null;
                }
                if (str != null) {
                    C2616db.f2549a = str;
                }
                if (C2616db.a(d3)) {
                    C2616db.d = 1;
                    C2894ub c2894ub = new C2894ub();
                    C2616db.b = c2894ub;
                    c2894ub.a(d3, new C2582bb());
                }
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
        b();
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Reflection.getOrCreateKotlinClass(ActivityFilter.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(ActivityRule.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(RuleController.class).getSimpleName();
            RuleController.Companion.getInstance(context).addRule(new ActivityRule.Builder(SetsKt.setOf(new ActivityFilter(new ComponentName(context, (Class<?>) InMobiAdActivity.class), (String) null))).setAlwaysExpand(true).build());
        } catch (NoClassDefFoundError unused2) {
        }
        try {
            C2868t1.f2707a.c();
            C2868t1.a();
        } catch (Exception unused3) {
            Intrinsics.checkNotNullExpressionValue("De", "TAG");
        }
        Vc.f2464a.a(context, "10.8.7");
        b = true;
    }

    public final boolean c() {
        try {
            Reflection.getOrCreateKotlinClass(CustomTabsClient.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(Omid.class).getSimpleName();
            Reflection.getOrCreateKotlinClass(OkHttpClient.class).getSimpleName();
            return false;
        } catch (NoClassDefFoundError unused) {
            return true;
        }
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        C2723k1.f2618a.a(context, c);
    }

    public final void a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Vc vc = Vc.f2464a;
            if (vc.a(context) == null || !Intrinsics.areEqual(vc.a(context), "10.8.7")) {
                ExecutorC2793o7 executorC2793o7 = (ExecutorC2793o7) AbstractC2970z4.d.getValue();
                Runnable runnable = new Runnable() { // from class: com.inmobi.media.De$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        De.b(context);
                    }
                };
                executorC2793o7.getClass();
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                executorC2793o7.f2659a.post(runnable);
                vc.a(context, F4.b(context));
                Uc uc = Uc.f2453a;
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                uc.a(applicationContext);
            }
        } catch (Exception e) {
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void c(final Context context) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        if (b) {
            return;
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        M2.a();
        Pd.c();
        C2881te.f2715a.a();
        AppSetIdInfo appSetIdInfo = AbstractC2657g1.f2574a;
        Lazy lazy = I5.f2313a;
        L3.f2348a.v();
        int i2 = AbstractC2564ab.f2520a;
        Context d = Uc.d();
        int i3 = Integer.MIN_VALUE;
        if (i2 != Integer.MIN_VALUE) {
            AbstractC2564ab.f2520a = i2;
            if (d != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6.a(B6.a(d, "user_info_store"), "user_age", i2, false, 4, (Object) null);
            }
        }
        String str = AbstractC2564ab.c;
        Context d2 = Uc.d();
        if (str != null) {
            AbstractC2564ab.c = str;
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap2 = C6.b;
                C6.a(B6.a(d2, "user_info_store"), "user_age_group", str, false, 4, (Object) null);
            }
        }
        String str2 = AbstractC2564ab.d;
        Context d3 = Uc.d();
        AbstractC2564ab.d = str2;
        if (d3 != null && str2 != null) {
            ConcurrentHashMap concurrentHashMap3 = C6.b;
            C6.a(B6.a(d3, "user_info_store"), "user_area_code", str2, false, 4, (Object) null);
        }
        String str3 = AbstractC2564ab.e;
        Context d4 = Uc.d();
        if (str3 != null) {
            AbstractC2564ab.e = str3;
            if (d4 != null) {
                ConcurrentHashMap concurrentHashMap4 = C6.b;
                C6.a(B6.a(d4, "user_info_store"), "user_post_code", str3, false, 4, (Object) null);
            }
        }
        String str4 = AbstractC2564ab.f;
        Context d5 = Uc.d();
        if (str4 != null) {
            AbstractC2564ab.f = str4;
            if (d5 != null) {
                ConcurrentHashMap concurrentHashMap5 = C6.b;
                C6.a(B6.a(d5, "user_info_store"), "user_city_code", str4, false, 4, (Object) null);
            }
        }
        String str5 = AbstractC2564ab.g;
        Context d6 = Uc.d();
        if (str5 != null) {
            AbstractC2564ab.g = str5;
            if (d6 != null) {
                ConcurrentHashMap concurrentHashMap6 = C6.b;
                C6.a(B6.a(d6, "user_info_store"), "user_state_code", str5, false, 4, (Object) null);
            }
        }
        String str6 = AbstractC2564ab.h;
        Context d7 = Uc.d();
        if (str6 != null) {
            AbstractC2564ab.h = str6;
            if (d7 != null) {
                ConcurrentHashMap concurrentHashMap7 = C6.b;
                C6.a(B6.a(d7, "user_info_store"), "user_country_code", str6, false, 4, (Object) null);
            }
        }
        int i4 = AbstractC2564ab.i;
        Context d8 = Uc.d();
        if (i4 != Integer.MIN_VALUE) {
            AbstractC2564ab.i = i4;
            if (d8 != null) {
                ConcurrentHashMap concurrentHashMap8 = C6.b;
                C6.a(B6.a(d8, "user_info_store"), "user_yob", i4, false, 4, (Object) null);
            }
        }
        String str7 = AbstractC2564ab.j;
        Context d9 = Uc.d();
        if (str7 != null) {
            AbstractC2564ab.j = str7;
            if (d9 != null) {
                ConcurrentHashMap concurrentHashMap9 = C6.b;
                C6.a(B6.a(d9, "user_info_store"), "user_gender", str7, false, 4, (Object) null);
            }
        }
        String str8 = AbstractC2564ab.k;
        Context d10 = Uc.d();
        if (str8 != null) {
            AbstractC2564ab.k = str8;
            if (d10 != null) {
                ConcurrentHashMap concurrentHashMap10 = C6.b;
                C6.a(B6.a(d10, "user_info_store"), "user_education", str8, false, 4, (Object) null);
            }
        }
        String str9 = AbstractC2564ab.l;
        Context d11 = Uc.d();
        if (str9 != null) {
            AbstractC2564ab.l = str9;
            if (d11 != null) {
                ConcurrentHashMap concurrentHashMap11 = C6.b;
                C6.a(B6.a(d11, "user_info_store"), "user_language", str9, false, 4, (Object) null);
            }
        }
        String str10 = AbstractC2564ab.m;
        Context d12 = Uc.d();
        if (str10 != null) {
            AbstractC2564ab.m = str10;
            if (d12 != null) {
                ConcurrentHashMap concurrentHashMap12 = C6.b;
                C6.a(B6.a(d12, "user_info_store"), "user_interest", str10, false, 4, (Object) null);
            }
        }
        Location location = AbstractC2564ab.n;
        Context d13 = Uc.d();
        if (location != null) {
            AbstractC2564ab.n = location;
            if (d13 != null) {
                String sb = new StringBuilder().append(location.getLatitude()).append(AbstractJsonLexerKt.COMMA).append(location.getLongitude()).append(AbstractJsonLexerKt.COMMA).append((int) location.getAccuracy()).append(AbstractJsonLexerKt.COMMA).append(location.getTime()).toString();
                ConcurrentHashMap concurrentHashMap13 = C6.b;
                C6.a(B6.a(d13, "user_info_store"), "user_location", sb, false, 4, (Object) null);
            }
        }
        if (AbstractC2564ab.f2520a == Integer.MIN_VALUE) {
            Context d14 = Uc.d();
            if (d14 == null) {
                i = Integer.MIN_VALUE;
            } else {
                ConcurrentHashMap concurrentHashMap14 = C6.b;
                C6 a2 = B6.a(d14, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age", C3040d4.h.W);
                i = a2.f2249a.getInt("user_age", Integer.MIN_VALUE);
            }
            AbstractC2564ab.f2520a = i;
        }
        String str11 = null;
        if (AbstractC2564ab.c == null) {
            Context d15 = Uc.d();
            if (d15 == null) {
                string9 = null;
            } else {
                ConcurrentHashMap concurrentHashMap15 = C6.b;
                C6 a3 = B6.a(d15, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_group", C3040d4.h.W);
                string9 = a3.f2249a.getString("user_age_group", null);
            }
            AbstractC2564ab.c = string9;
        }
        if (AbstractC2564ab.d == null) {
            Context d16 = Uc.d();
            if (d16 == null) {
                string8 = null;
            } else {
                ConcurrentHashMap concurrentHashMap16 = C6.b;
                C6 a4 = B6.a(d16, "user_info_store");
                Intrinsics.checkNotNullParameter("user_area_code", C3040d4.h.W);
                string8 = a4.f2249a.getString("user_area_code", null);
            }
            AbstractC2564ab.d = string8;
        }
        if (AbstractC2564ab.e == null) {
            Context d17 = Uc.d();
            if (d17 == null) {
                string7 = null;
            } else {
                ConcurrentHashMap concurrentHashMap17 = C6.b;
                C6 a5 = B6.a(d17, "user_info_store");
                Intrinsics.checkNotNullParameter("user_post_code", C3040d4.h.W);
                string7 = a5.f2249a.getString("user_post_code", null);
            }
            AbstractC2564ab.e = string7;
        }
        if (AbstractC2564ab.f == null) {
            Context d18 = Uc.d();
            if (d18 == null) {
                string6 = null;
            } else {
                ConcurrentHashMap concurrentHashMap18 = C6.b;
                C6 a6 = B6.a(d18, "user_info_store");
                Intrinsics.checkNotNullParameter("user_city_code", C3040d4.h.W);
                string6 = a6.f2249a.getString("user_city_code", null);
            }
            AbstractC2564ab.f = string6;
        }
        if (AbstractC2564ab.g == null) {
            Context d19 = Uc.d();
            if (d19 == null) {
                string5 = null;
            } else {
                ConcurrentHashMap concurrentHashMap19 = C6.b;
                C6 a7 = B6.a(d19, "user_info_store");
                Intrinsics.checkNotNullParameter("user_state_code", C3040d4.h.W);
                string5 = a7.f2249a.getString("user_state_code", null);
            }
            AbstractC2564ab.g = string5;
        }
        if (AbstractC2564ab.h == null) {
            Context d20 = Uc.d();
            if (d20 == null) {
                string4 = null;
            } else {
                ConcurrentHashMap concurrentHashMap20 = C6.b;
                C6 a8 = B6.a(d20, "user_info_store");
                Intrinsics.checkNotNullParameter("user_country_code", C3040d4.h.W);
                string4 = a8.f2249a.getString("user_country_code", null);
            }
            AbstractC2564ab.h = string4;
        }
        if (AbstractC2564ab.i == Integer.MIN_VALUE) {
            Context d21 = Uc.d();
            if (d21 != null) {
                ConcurrentHashMap concurrentHashMap21 = C6.b;
                C6 a9 = B6.a(d21, "user_info_store");
                Intrinsics.checkNotNullParameter("user_yob", C3040d4.h.W);
                i3 = a9.f2249a.getInt("user_yob", Integer.MIN_VALUE);
            }
            AbstractC2564ab.i = i3;
        }
        if (AbstractC2564ab.j == null) {
            Context d22 = Uc.d();
            if (d22 == null) {
                string3 = null;
            } else {
                ConcurrentHashMap concurrentHashMap22 = C6.b;
                C6 a10 = B6.a(d22, "user_info_store");
                Intrinsics.checkNotNullParameter("user_gender", C3040d4.h.W);
                string3 = a10.f2249a.getString("user_gender", null);
            }
            AbstractC2564ab.j = string3;
        }
        if (AbstractC2564ab.k == null) {
            Context d23 = Uc.d();
            if (d23 == null) {
                string2 = null;
            } else {
                ConcurrentHashMap concurrentHashMap23 = C6.b;
                C6 a11 = B6.a(d23, "user_info_store");
                Intrinsics.checkNotNullParameter("user_education", C3040d4.h.W);
                string2 = a11.f2249a.getString("user_education", null);
            }
            AbstractC2564ab.k = string2;
        }
        if (AbstractC2564ab.l == null) {
            Context d24 = Uc.d();
            if (d24 == null) {
                string = null;
            } else {
                ConcurrentHashMap concurrentHashMap24 = C6.b;
                C6 a12 = B6.a(d24, "user_info_store");
                Intrinsics.checkNotNullParameter("user_language", C3040d4.h.W);
                string = a12.f2249a.getString("user_language", null);
            }
            AbstractC2564ab.l = string;
        }
        if (AbstractC2564ab.m == null) {
            Context d25 = Uc.d();
            if (d25 != null) {
                ConcurrentHashMap concurrentHashMap25 = C6.b;
                C6 a13 = B6.a(d25, "user_info_store");
                Intrinsics.checkNotNullParameter("user_interest", C3040d4.h.W);
                str11 = a13.f2249a.getString("user_interest", null);
            }
            AbstractC2564ab.m = str11;
        }
        AbstractC2564ab.b();
        AbstractC2564ab.c();
        Uc.a(new Runnable() { // from class: com.inmobi.media.De$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                De.d(context);
            }
        });
    }

    public static void b() {
        try {
            C2881te.f2715a.a();
            AppSetIdInfo appSetIdInfo = AbstractC2657g1.f2574a;
            LinkedHashMap linkedHashMap = O2.f2380a;
            M2.a();
            C2933x2.f2748a.h();
            Pd.c();
            C2601cd.f2538a.a();
            sf sfVar = sf.f2706a;
            C2868t1.f2707a.c();
            EnumC2560a7 enumC2560a7 = Cb.f2253a;
            Cb.c.set(true);
            Cb.b();
            Uc.f().a(new int[]{2, 1, 100, 151, 150, 152}, Cb.g);
            Aa.a();
            S5.f2425a.a();
            Pd.b("SessionStarted", new HashMap(), Td.f2443a);
            ConcurrentHashMap concurrentHashMap = Jd.f2329a;
            Jd.b();
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("De", "TAG");
            Intrinsics.checkNotNullExpressionValue("De", "TAG");
            AbstractC2680h7.a((byte) 2, "De", "SDK encountered unexpected error while starting internal components");
        }
    }

    @JvmStatic
    public static final void a() {
        try {
            LinkedHashMap linkedHashMap = O2.f2380a;
            if (O2.c.getAndSet(false)) {
                Intrinsics.checkNotNullExpressionValue(O2.f(), "access$getTAG$cp(...)");
                ((I2) O2.b.getValue()).sendEmptyMessage(5);
            }
            Pd.d.set(false);
            C2871t4 c2871t4 = Pd.f;
            if (c2871t4 != null) {
                ScheduledExecutorService scheduledExecutorService = c2871t4.h;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                c2871t4.h = null;
                c2871t4.e.set(false);
                c2871t4.f.set(true);
                c2871t4.g.clear();
                c2871t4.i = null;
            }
            Pd.f = null;
            Pd.i = null;
            Uc.f().a(Pd.h);
            synchronized (C2601cd.f2538a) {
                Intrinsics.checkNotNullExpressionValue("cd", "TAG");
                X6 x6 = X6.f2480a;
                if (X6.c()) {
                    LocationManager locationManager = X6.b;
                    if (locationManager != null) {
                        locationManager.removeUpdates(x6);
                    }
                    GoogleApiClient googleApiClient = X6.d;
                    if (googleApiClient != null) {
                        googleApiClient.disconnect();
                    }
                }
                X6.d = null;
            }
            C2868t1 c2868t1 = C2868t1.f2707a;
            C2868t1.j.set(true);
            C2868t1.d();
            EnumC2560a7 enumC2560a7 = Cb.f2253a;
            Cb.c.set(false);
            Uc.f().a(Cb.g);
            Cb.b = null;
            if (Aa.c.compareAndSet(true, false)) {
                C2576b5 c2576b5 = Aa.f2234a;
                if (c2576b5 != null) {
                    O4 o4 = c2576b5.e;
                    o4.getClass();
                    Ca ca = Ca.f2252a;
                    if (o4.a(ca)) {
                        o4.d = ca;
                        o4.e();
                    }
                }
                F3 f3 = Aa.b;
                if (f3 != null) {
                    Intrinsics.checkNotNullExpressionValue("F3", "TAG");
                    W9 w9 = f3.e;
                    w9.getClass();
                    Ca ca2 = Ca.f2252a;
                    if (w9.a(ca2)) {
                        w9.d = ca2;
                        w9.b();
                    }
                }
            }
            H3 h3 = S5.c;
            if (h3 != null) {
                Iterator it = h3.c.iterator();
                while (it.hasNext()) {
                    ((G3) it.next()).b();
                }
            }
            E6 e6 = S5.d;
            C2871t4 c2871t42 = e6.b;
            if (c2871t42 != null) {
                ScheduledExecutorService scheduledExecutorService2 = c2871t42.h;
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdownNow();
                }
                c2871t42.h = null;
                c2871t42.e.set(false);
                c2871t42.f.set(true);
                c2871t42.g.clear();
                c2871t42.i = null;
            }
            e6.b = null;
            Uc.f().a(e6.d);
            ConcurrentHashMap concurrentHashMap = Jd.f2329a;
            Jd.a();
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("De", "TAG");
            Intrinsics.checkNotNullExpressionValue("De", "TAG");
            AbstractC2680h7.a((byte) 1, "De", "SDK encountered unexpected error while stopping internal components");
        }
    }
}
