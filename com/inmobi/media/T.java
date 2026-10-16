package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.appset.AppSetIdInfo;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.ironsource.C3040d4;
import io.bidmachine.IABSharedPreference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class T extends N9 {
    public String A;
    public String B;
    public String C;
    public Map D;
    public final Z y;
    public final X9 z;

    public static JSONObject a(String adType) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        if (Intrinsics.areEqual(adType, "banner")) {
            return C2904v5.c.a();
        }
        if (!Intrinsics.areEqual("audio", adType)) {
            return new JSONObject();
        }
        C2839r5 c2839r5 = C2839r5.c;
        JSONObject jSONObject = new JSONObject();
        long j = c2839r5.f2421a / 1000;
        if (j != 0) {
            jSONObject.put("a-lastAudioPlayedTs", String.valueOf(j));
        }
        int i = c2839r5.b;
        if (i > 0) {
            jSONObject.put("a-audioFreq", String.valueOf(i));
        }
        Context d = Uc.d();
        if (d != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            C6 a2 = B6.a(d, "audio_pref_file");
            Intrinsics.checkNotNullParameter("user_mute_count", C3040d4.h.W);
            int i2 = a2.f2249a.getInt("user_mute_count", -1);
            if (i2 > 0) {
                jSONObject.put("a-umc", String.valueOf(i2));
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0239  */
    @Override // com.inmobi.media.N9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        boolean z;
        Lazy lazy;
        String str;
        String str2;
        Pair<String, String> i;
        Pair<String, String> k;
        Pair<String, String> c;
        Pair<String, String> f;
        Pair<String, String> t;
        Pair<String, String> d;
        Pair<String, String> u;
        Pair<String, String> g;
        Pair<String, String> h;
        Pair<String, String> b;
        Pair<String, String> j;
        JSONObject b2;
        AppSetIdInfo appSetIdInfo;
        String e;
        SignalsConfig.PublisherConfig publisher;
        Map map;
        super.f();
        HashMap mutableMap = this.k;
        if (mutableMap == null) {
            return;
        }
        Ae a2 = AbstractC2980ze.a();
        String str3 = a2.f2237a;
        if (str3 != null) {
        }
        mutableMap.put("is-unifid-service-used", String.valueOf(a2.b));
        mutableMap.put("format", this.A);
        String str4 = this.B;
        if (str4 != null) {
        }
        mutableMap.putAll(X6.f2480a.b());
        HashMap hashMap = new HashMap();
        String str5 = "DENIED";
        if (X6.c() && X6.e()) {
            str5 = "AUTHORISED";
        }
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
        String lowerCase = str5.toLowerCase(ENGLISH);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        hashMap.put("loc-consent-status", lowerCase);
        mutableMap.putAll(hashMap);
        mutableMap.putAll(AbstractC2675h2.a());
        mutableMap.putAll(AbstractC2675h2.b());
        mutableMap.putAll(AbstractC2675h2.c());
        X9 x9 = this.z;
        if (x9 != null && (map = x9.f2482a) != null) {
            mutableMap.putAll(map);
        }
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a3 = M2.a("signals", this.m, null);
        SignalsConfig signalsConfig = a3 instanceof SignalsConfig ? (SignalsConfig) a3 : null;
        int i2 = 1;
        if (signalsConfig != null && (publisher = signalsConfig.getPublisher()) != null && publisher.getEnableMCO()) {
            Ya ya = Ya.f2496a;
            ya.getClass();
            JSONObject jSONObject = (JSONObject) Ya.d.getValue(ya, Ya.b[0]);
            if (jSONObject.length() > 0) {
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                mutableMap.put(C3040d4.h.l0, jSONObject2);
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(F2.f2279a);
        mutableMap.putAll(hashMap2);
        String str6 = this.C;
        if (str6 != null) {
        }
        mutableMap.put("m10n_context", Intrinsics.areEqual("others", this.y.j()) ? "M10N_CONTEXT_OTHER" : "M10N_CONTEXT_ACTIVITY");
        Map<String, String> f2 = this.y.f();
        if (f2 != null) {
            for (Map.Entry<String, String> entry : f2.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (!mutableMap.containsKey(key)) {
                    mutableMap.put(key, value);
                }
            }
        }
        Map map2 = this.D;
        if (map2 != null) {
            mutableMap.putAll(map2);
        }
        if (this.y.g() != Long.MIN_VALUE) {
            mutableMap.put("im-plid", String.valueOf(this.y.g()));
        }
        mutableMap.put("int-origin", this.y.h());
        LinkedHashMap linkedHashMap2 = O2.f2380a;
        Config a4 = M2.a("signals", this.m, null);
        SignalsConfig signalsConfig2 = a4 instanceof SignalsConfig ? (SignalsConfig) a4 : null;
        JSONObject ext = signalsConfig2 != null ? signalsConfig2.getExt() : null;
        if (ext != null && ext.length() > 0) {
            String jSONObject3 = ext.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
            mutableMap.put("im-ext", jSONObject3);
        }
        String str7 = C2616db.f2549a;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        String str8 = C2616db.f2549a;
        if (str8 != null) {
            linkedHashMap3.put("u-nip", str8);
        } else {
            linkedHashMap3 = null;
        }
        if (linkedHashMap3 != null) {
            mutableMap.putAll(linkedHashMap3);
        }
        L3 l3 = L3.f2348a;
        if (l3.y() && (e = U3.e()) != null) {
            mutableMap.put("d-device-gesture-margins", e);
        }
        if (AbstractC2934x3.a(Uc.d()) != null) {
            Config a5 = M2.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, this.m, null);
            AdConfig adConfig = a5 instanceof AdConfig ? (AdConfig) a5 : null;
            if (adConfig != null && adConfig.getCctEnabled()) {
                z = true;
                mutableMap.put("cct-enabled", String.valueOf(z));
                lazy = C2638f0.c;
                if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
                    String jSONArray = new JSONArray((Collection) lazy.getValue()).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
                    mutableMap.put("u-r-crid", jSONArray);
                }
                str = this.B;
                if (str != null && a(str).length() > 0) {
                    String jSONObject4 = a(str).toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "toString(...)");
                    mutableMap.put("audioObject", jSONObject4);
                }
                mutableMap.putAll(AbstractC2564ab.a());
                if (Uc.d() != null) {
                    Context d2 = Uc.d();
                    SharedPreferences sharedPreferences = d2 != null ? d2.getSharedPreferences((d2 != null ? d2.getPackageName() : null) + "_preferences", 0) : null;
                    if (sharedPreferences != null && sharedPreferences.contains(IABSharedPreference.IAB_GPP_HDR_STRING)) {
                        str2 = String.valueOf(sharedPreferences.getString(IABSharedPreference.IAB_GPP_HDR_STRING, ""));
                        if (B2.a(str2)) {
                            mutableMap.put("gpp", str2);
                        }
                        i = l3.i();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (i != null) {
                            mutableMap.put(i.getFirst(), i.getSecond());
                        }
                        k = l3.k();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (k != null) {
                            mutableMap.put(k.getFirst(), k.getSecond());
                        }
                        c = l3.c();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (c != null) {
                            mutableMap.put(c.getFirst(), c.getSecond());
                        }
                        f = l3.f();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (f != null) {
                            mutableMap.put(f.getFirst(), f.getSecond());
                        }
                        t = l3.t();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (t != null) {
                            mutableMap.put(t.getFirst(), t.getSecond());
                        }
                        d = l3.d();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (d != null) {
                            mutableMap.put(d.getFirst(), d.getSecond());
                        }
                        u = l3.u();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (u != null) {
                            mutableMap.put(u.getFirst(), u.getSecond());
                        }
                        g = l3.g();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (g != null) {
                            mutableMap.put(g.getFirst(), g.getSecond());
                        }
                        h = l3.h();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (h != null) {
                            mutableMap.put(h.getFirst(), h.getSecond());
                        }
                        b = l3.b();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (b != null) {
                            mutableMap.put(b.getFirst(), b.getSecond());
                        }
                        j = l3.j();
                        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                        if (j != null) {
                            mutableMap.put(j.getFirst(), j.getSecond());
                        }
                        AppSetIdInfo appSetIdInfo2 = AbstractC2657g1.f2574a;
                        Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
                        if (AbstractC2657g1.a() && (appSetIdInfo = AbstractC2657g1.f2574a) != null) {
                            String id = appSetIdInfo.getId();
                            Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                            mutableMap.put("d-app-set-id", id);
                        }
                        C2676h3 c2676h3 = C2676h3.f2585a;
                        if (C2676h3.d()) {
                            mutableMap.put("ik", C2676h3.g);
                            mutableMap.put("c_data", C2676h3.c());
                            StringBuilder sb = new StringBuilder("");
                            Context d3 = Uc.d();
                            if (d3 != null) {
                                ConcurrentHashMap concurrentHashMap = C6.b;
                                C6 a6 = B6.a(d3, "c_data_store");
                                Intrinsics.checkNotNullParameter("akv", C3040d4.h.W);
                                i2 = a6.f2249a.getInt("akv", 1);
                            }
                            mutableMap.put("aKV", sb.append(i2).toString());
                        }
                        b2 = Zc.f2508a.b();
                        if (b2.length() > 0) {
                            String jSONObject5 = b2.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject5, "toString(...)");
                            mutableMap.put("sData", jSONObject5);
                            return;
                        }
                        return;
                    }
                }
                str2 = "";
                if (B2.a(str2)) {
                }
                i = l3.i();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (i != null) {
                }
                k = l3.k();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (k != null) {
                }
                c = l3.c();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (c != null) {
                }
                f = l3.f();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (f != null) {
                }
                t = l3.t();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (t != null) {
                }
                d = l3.d();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (d != null) {
                }
                u = l3.u();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (u != null) {
                }
                g = l3.g();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (g != null) {
                }
                h = l3.h();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (h != null) {
                }
                b = l3.b();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (b != null) {
                }
                j = l3.j();
                Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                if (j != null) {
                }
                AppSetIdInfo appSetIdInfo22 = AbstractC2657g1.f2574a;
                Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
                if (AbstractC2657g1.a()) {
                    String id2 = appSetIdInfo.getId();
                    Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                    mutableMap.put("d-app-set-id", id2);
                }
                C2676h3 c2676h32 = C2676h3.f2585a;
                if (C2676h3.d()) {
                }
                b2 = Zc.f2508a.b();
                if (b2.length() > 0) {
                }
            }
        }
        z = false;
        mutableMap.put("cct-enabled", String.valueOf(z));
        lazy = C2638f0.c;
        if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
        }
        str = this.B;
        if (str != null) {
            String jSONObject42 = a(str).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject42, "toString(...)");
            mutableMap.put("audioObject", jSONObject42);
        }
        mutableMap.putAll(AbstractC2564ab.a());
        if (Uc.d() != null) {
        }
        str2 = "";
        if (B2.a(str2)) {
        }
        i = l3.i();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (i != null) {
        }
        k = l3.k();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (k != null) {
        }
        c = l3.c();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (c != null) {
        }
        f = l3.f();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (f != null) {
        }
        t = l3.t();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (t != null) {
        }
        d = l3.d();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (d != null) {
        }
        u = l3.u();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (u != null) {
        }
        g = l3.g();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (g != null) {
        }
        h = l3.h();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (h != null) {
        }
        b = l3.b();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (b != null) {
        }
        j = l3.j();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (j != null) {
        }
        AppSetIdInfo appSetIdInfo222 = AbstractC2657g1.f2574a;
        Intrinsics.checkNotNullParameter(mutableMap, "mutableMap");
        if (AbstractC2657g1.a()) {
        }
        C2676h3 c2676h322 = C2676h3.f2585a;
        if (C2676h3.d()) {
        }
        b2 = Zc.f2508a.b();
        if (b2.length() > 0) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T(String str, C2897ue c2897ue, String str2, Z adPlacement, X9 x9, InterfaceC2971z5 interfaceC2971z5, boolean z) {
        super("POST", str, c2897ue, false, interfaceC2971z5, ShareTarget.ENCODING_TYPE_URL_ENCODED, z);
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.y = adPlacement;
        this.z = x9;
        this.A = "json";
        this.m = Uc.b();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.putAll(U3.c());
            String str3 = C2623e1.b;
            if (str3 != null) {
            }
            hashMap.put("client-request-id", adPlacement.d());
            if (str2 != null) {
                hashMap.put("u-appcache", str2);
            }
            hashMap.put("sdk-flavor", "row");
        }
    }
}
