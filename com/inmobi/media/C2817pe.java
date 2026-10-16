package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.appset.AppSetIdInfo;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.ironsource.C3040d4;
import io.bidmachine.IABSharedPreference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.pe, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2817pe extends N9 {
    public final String A;
    public String B;
    public Map C;
    public final RootConfig y;
    public final AdConfig z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2817pe(C2897ue uidMap, A5 a5, RootConfig rootConfig, AdConfig adConfig) {
        super("POST", (String) null, uidMap, false, (InterfaceC2971z5) a5, ShareTarget.ENCODING_TYPE_URL_ENCODED, 64);
        Intrinsics.checkNotNullParameter(uidMap, "uidMap");
        Intrinsics.checkNotNullParameter(rootConfig, "rootConfig");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        this.y = rootConfig;
        this.z = adConfig;
        this.A = "pe";
        this.m = Uc.b();
        this.t = true;
        this.u = true;
        this.o = Uc.o();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0287  */
    @Override // com.inmobi.media.N9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() {
        boolean booleanValue;
        String str;
        String str2;
        String str3;
        Map map;
        JSONObject ext;
        LinkedHashMap linkedHashMap;
        String str4;
        String str5;
        SignalsConfig signalsConfig;
        Context d;
        Map emptyMap;
        Lazy lazy;
        JSONObject a2;
        Pair<String, String> i;
        Pair<String, String> k;
        Pair<String, String> c;
        Pair<String, String> f;
        Pair<String, String> t;
        Pair<String, String> d2;
        Pair<String, String> u;
        Pair<String, String> g;
        Pair<String, String> h;
        Pair<String, String> b;
        Pair<String, String> j;
        JSONObject b2;
        int i2;
        AppSetIdInfo appSetIdInfo;
        X9 x9;
        SignalsConfig.PublisherConfig publisher;
        String e;
        super.f();
        HashMap mutableMap = this.k;
        if (mutableMap == null) {
            return;
        }
        Boolean bool = AbstractC2564ab.b;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            Context d3 = Uc.d();
            if (d3 != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a3 = B6.a(d3, "user_info_store");
                Intrinsics.checkNotNullParameter("user_age_restricted", C3040d4.h.W);
                AbstractC2564ab.b = Boolean.valueOf(a3.f2249a.getBoolean("user_age_restricted", false));
            }
            Boolean bool2 = AbstractC2564ab.b;
            booleanValue = bool2 != null ? bool2.booleanValue() : false;
        }
        if (booleanValue) {
            String TAG = this.A;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
        } else if (CollectionsKt.contains(this.y.getIpAddrTPSupport(), Vc.d())) {
            Intrinsics.checkNotNull(I5.c);
            str = I5.b;
            if (str == null || str.length() == 0) {
                String TAG2 = this.A;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            }
            if (str != null) {
            }
            Ae a4 = AbstractC2980ze.a();
            str2 = a4.f2237a;
            if (str2 != null) {
            }
            mutableMap.put("is-unifid-service-used", String.valueOf(a4.b));
            mutableMap.putAll(X6.f2480a.b());
            mutableMap.putAll(Y4.a());
            mutableMap.put("d-media-volume", String.valueOf(L3.f2348a.a(Uc.d(), this.o)));
            a(mutableMap);
            str3 = this.B;
            if (str3 != null) {
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(F2.f2279a);
            mutableMap.putAll(hashMap);
            map = this.C;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (!mutableMap.containsKey(entry.getKey())) {
                        mutableMap.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            LinkedHashMap linkedHashMap2 = O2.f2380a;
            Config a5 = M2.a("signals", this.m, null);
            SignalsConfig signalsConfig2 = !(a5 instanceof SignalsConfig) ? (SignalsConfig) a5 : null;
            ext = signalsConfig2 == null ? signalsConfig2.getExt() : null;
            if (ext == null && ext.length() > 0) {
                mutableMap.put("im-ext", String.valueOf(ext));
            }
            String str6 = C2616db.f2549a;
            linkedHashMap = new LinkedHashMap();
            str4 = C2616db.f2549a;
            if (str4 == null) {
                linkedHashMap.put("u-nip", str4);
            } else {
                linkedHashMap = null;
            }
            if (linkedHashMap != null) {
                mutableMap.putAll(linkedHashMap);
            }
            if (Build.VERSION.SDK_INT >= 29 && (e = U3.e()) != null) {
            }
            mutableMap.put("cct-enabled", String.valueOf((this.z.getCctEnabled() || AbstractC2934x3.a(Uc.d()) == null) ? false : true));
            mutableMap.putAll(AbstractC2564ab.a());
            if (Uc.d() != null) {
                Context d4 = Uc.d();
                SharedPreferences sharedPreferences = d4 != null ? d4.getSharedPreferences((d4 != null ? d4.getPackageName() : null) + "_preferences", 0) : null;
                if (sharedPreferences != null && sharedPreferences.contains(IABSharedPreference.IAB_GPP_HDR_STRING)) {
                    str5 = String.valueOf(sharedPreferences.getString(IABSharedPreference.IAB_GPP_HDR_STRING, ""));
                    if (B2.a(str5)) {
                        mutableMap.put("gpp", str5);
                    }
                    mutableMap.putAll(U3.c());
                    mutableMap.putAll(AbstractC2675h2.a());
                    Config a6 = M2.a("signals", this.m, null);
                    signalsConfig = a6 instanceof SignalsConfig ? (SignalsConfig) a6 : null;
                    if (signalsConfig == null && (publisher = signalsConfig.getPublisher()) != null && publisher.getEnableAB()) {
                        Ya ya = Ya.f2496a;
                        ya.getClass();
                        JSONObject jSONObject = (JSONObject) Ya.d.getValue(ya, Ya.b[0]);
                        if (jSONObject.length() > 0) {
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                            mutableMap.put(C3040d4.h.l0, jSONObject2);
                        }
                    }
                    d = Uc.d();
                    if (d != null) {
                        InterfaceC2971z5 interfaceC2971z5 = this.e;
                        Z9 z9 = new Z9(d, interfaceC2971z5);
                        if (z9.d) {
                            x9 = new X9(MapsKt.hashMapOf(TuplesKt.to("n-h-id", z9.c)));
                        } else {
                            if (interfaceC2971z5 != null) {
                                ((A5) interfaceC2971z5).a("NovatiqDataHandler", "Novatiq disabled. skip");
                            }
                            x9 = new X9(MapsKt.emptyMap());
                        }
                        emptyMap = x9.f2482a;
                    } else {
                        emptyMap = MapsKt.emptyMap();
                    }
                    mutableMap.putAll(emptyMap);
                    lazy = C2638f0.c;
                    if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
                        String jSONArray = new JSONArray((Collection) lazy.getValue()).toString();
                        Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
                        mutableMap.put("u-r-crid", jSONArray);
                    }
                    a2 = C2904v5.c.a();
                    if (a2.length() > 0) {
                        String jSONObject3 = a2.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString(...)");
                        mutableMap.put("audioObject", jSONObject3);
                    }
                    L3 l3 = L3.f2348a;
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
                    d2 = l3.d();
                    Intrinsics.checkNotNullParameter(mutableMap, "<this>");
                    if (d2 != null) {
                        mutableMap.put(d2.getFirst(), d2.getSecond());
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
                        Context d5 = Uc.d();
                        if (d5 != null) {
                            ConcurrentHashMap concurrentHashMap2 = C6.b;
                            C6 a7 = B6.a(d5, "c_data_store");
                            Intrinsics.checkNotNullParameter("akv", C3040d4.h.W);
                            i2 = a7.f2249a.getInt("akv", 1);
                        } else {
                            i2 = 1;
                        }
                        mutableMap.put("aKV", sb.append(i2).toString());
                    }
                    b2 = Zc.f2508a.b();
                    if (b2.length() > 0) {
                        String jSONObject4 = b2.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "toString(...)");
                        mutableMap.put("sData", jSONObject4);
                        return;
                    }
                    return;
                }
            }
            str5 = "";
            if (B2.a(str5)) {
            }
            mutableMap.putAll(U3.c());
            mutableMap.putAll(AbstractC2675h2.a());
            Config a62 = M2.a("signals", this.m, null);
            if (a62 instanceof SignalsConfig) {
            }
            if (signalsConfig == null && (publisher = signalsConfig.getPublisher()) != null && publisher.getEnableAB()) {
            }
            d = Uc.d();
            if (d != null) {
            }
            mutableMap.putAll(emptyMap);
            lazy = C2638f0.c;
            if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
            }
            a2 = C2904v5.c.a();
            if (a2.length() > 0) {
            }
            L3 l32 = L3.f2348a;
            i = l32.i();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (i != null) {
            }
            k = l32.k();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (k != null) {
            }
            c = l32.c();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (c != null) {
            }
            f = l32.f();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (f != null) {
            }
            t = l32.t();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (t != null) {
            }
            d2 = l32.d();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (d2 != null) {
            }
            u = l32.u();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (u != null) {
            }
            g = l32.g();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (g != null) {
            }
            h = l32.h();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (h != null) {
            }
            b = l32.b();
            Intrinsics.checkNotNullParameter(mutableMap, "<this>");
            if (b != null) {
            }
            j = l32.j();
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
        } else {
            String TAG3 = this.A;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            Objects.toString(this.y.getIpAddrTPSupport());
            Vc.d();
        }
        str = null;
        if (str != null) {
        }
        Ae a42 = AbstractC2980ze.a();
        str2 = a42.f2237a;
        if (str2 != null) {
        }
        mutableMap.put("is-unifid-service-used", String.valueOf(a42.b));
        mutableMap.putAll(X6.f2480a.b());
        mutableMap.putAll(Y4.a());
        mutableMap.put("d-media-volume", String.valueOf(L3.f2348a.a(Uc.d(), this.o)));
        a(mutableMap);
        str3 = this.B;
        if (str3 != null) {
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(F2.f2279a);
        mutableMap.putAll(hashMap2);
        map = this.C;
        if (map != null) {
        }
        LinkedHashMap linkedHashMap22 = O2.f2380a;
        Config a52 = M2.a("signals", this.m, null);
        if (!(a52 instanceof SignalsConfig)) {
        }
        if (signalsConfig2 == null) {
        }
        if (ext == null && ext.length() > 0) {
        }
        String str62 = C2616db.f2549a;
        linkedHashMap = new LinkedHashMap();
        str4 = C2616db.f2549a;
        if (str4 == null) {
        }
        if (linkedHashMap != null) {
        }
        if (Build.VERSION.SDK_INT >= 29) {
        }
        mutableMap.put("cct-enabled", String.valueOf((this.z.getCctEnabled() || AbstractC2934x3.a(Uc.d()) == null) ? false : true));
        mutableMap.putAll(AbstractC2564ab.a());
        if (Uc.d() != null) {
        }
        str5 = "";
        if (B2.a(str5)) {
        }
        mutableMap.putAll(U3.c());
        mutableMap.putAll(AbstractC2675h2.a());
        Config a622 = M2.a("signals", this.m, null);
        if (a622 instanceof SignalsConfig) {
        }
        if (signalsConfig == null && (publisher = signalsConfig.getPublisher()) != null && publisher.getEnableAB()) {
        }
        d = Uc.d();
        if (d != null) {
        }
        mutableMap.putAll(emptyMap);
        lazy = C2638f0.c;
        if (!((CopyOnWriteArrayList) lazy.getValue()).isEmpty()) {
        }
        a2 = C2904v5.c.a();
        if (a2.length() > 0) {
        }
        L3 l322 = L3.f2348a;
        i = l322.i();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (i != null) {
        }
        k = l322.k();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (k != null) {
        }
        c = l322.c();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (c != null) {
        }
        f = l322.f();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (f != null) {
        }
        t = l322.t();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (t != null) {
        }
        d2 = l322.d();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (d2 != null) {
        }
        u = l322.u();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (u != null) {
        }
        g = l322.g();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (g != null) {
        }
        h = l322.h();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (h != null) {
        }
        b = l322.b();
        Intrinsics.checkNotNullParameter(mutableMap, "<this>");
        if (b != null) {
        }
        j = l322.j();
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
}
