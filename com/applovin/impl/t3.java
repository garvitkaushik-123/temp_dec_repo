package com.applovin.impl;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.BuildConfig;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.BidMachine;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class t3 {

    /* renamed from: a, reason: collision with root package name */
    private static final TreeMap f738a;
    private static final Map b;
    private static final List c;
    private static JSONArray d;
    private static final Map e = new HashMap();
    private static final Object f = new Object();
    private static final Map g = Collections.synchronizedMap(new HashMap(1));

    static {
        TreeMap treeMap = new TreeMap();
        f738a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdjoeAdsMediationAdapter", "adjoe Ads");
        treeMap.put("com.applovin.mediation.adapters.AmazonAdMarketplaceMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", BidMachine.NAME);
        treeMap.put("com.applovin.mediation.adapters.BigoAdsMediationAdapter", "Bigo Ads");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.CSJMediationAdapter", "CSJ");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "MobileFuse");
        treeMap.put("com.applovin.mediation.adapters.MolocoMediationAdapter", "Moloco");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.PangleMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.PubMaticMediationAdapter", "PubMatic");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", BuildConfig.OMSDK_PARTNER_NAME);
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        treeMap.put("com.applovin.mediation.adapters.LinkedInDSPAdapter", "LinkedIn");
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonPublisherServicesMediationAdapter", "Amazon Publisher Services");
        treeMap.put("com.applovin.mediation.adapters.CriteoMediationAdapter", "Criteo");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.YahooMediationAdapter", "Yahoo");
        treeMap.put("com.applovin.mediation.ALYsoNetworkMediationAdapter", "YSO Network");
        treeMap.put("com.applovin.mediation.adapters.YsoNetworkMediationAdapter", "YSO Network");
        c = new ArrayList(treeMap.keySet());
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("com.applovin.mediation.adapters.BidMachineMediationAdapter", "3.0.1.1");
        hashMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "6.5.0.8.1");
        hashMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "9.7.0.3");
        hashMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "6.17.0.1");
        hashMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "23.3.0.1");
        hashMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "23.3.0.1");
        hashMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "6.4.2.1");
        hashMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "10.7.7.1");
        hashMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "8.3.6.1");
        hashMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "8.3.0.0.2");
        hashMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "2024.8.27.1");
        hashMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "16.8.51.1");
        hashMap.put("com.applovin.mediation.adapters.MobileFuseMediationAdapter", "1.7.6.1");
        hashMap.put("com.applovin.mediation.adapters.MolocoMediationAdapter", "3.1.0.1");
        hashMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "5.22.1.1");
        hashMap.put("com.applovin.mediation.adapters.PubMaticMediationAdapter", "3.9.0.2");
        hashMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "22.7.0.1");
        hashMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "4.12.2.1");
        hashMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "3.0.4.1");
        hashMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "7.4.1.1");
        hashMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "7.4.0.1");
    }

    public static List a(com.applovin.impl.sdk.k kVar) {
        HashSet hashSet;
        ArrayList arrayList = new ArrayList(kVar.c(o3.d7));
        if (!((Boolean) kVar.a(o3.e7)).booleanValue()) {
            return arrayList;
        }
        synchronized (f) {
            hashSet = new HashSet(e.keySet());
        }
        arrayList.retainAll(hashSet);
        return arrayList;
    }

    public static JSONArray b(com.applovin.impl.sdk.k kVar) {
        synchronized (f) {
            if (d != null) {
                d(kVar);
                return d;
            }
            d = new JSONArray();
            for (String str : c) {
                MaxAdapter a2 = a(str, kVar);
                if (a2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", f738a.get(str));
                        jSONObject.put("class", str);
                        jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, a(a2));
                        jSONObject.put("version", a2.getAdapterVersion());
                        jSONObject.put("is_supported", a(a2, str));
                    } catch (Throwable unused) {
                    }
                    d.put(jSONObject);
                    e.put(str, new MaxMediatedNetworkInfoImpl(jSONObject));
                }
            }
            return d;
        }
    }

    private static void c(JSONObject jSONObject, String str, com.applovin.impl.sdk.k kVar) {
        synchronized (f) {
            if (StringUtils.isValidString(JsonUtils.getString(jSONObject, BidTokenRepositoryKt.SDK_VERSION, ""))) {
                return;
            }
            MaxAdapter a2 = a(str, kVar);
            if (a2 == null) {
                return;
            }
            String a3 = a(a2);
            if (TextUtils.isEmpty(a3)) {
                return;
            }
            JsonUtils.putString(jSONObject, BidTokenRepositoryKt.SDK_VERSION, a3);
            e.put(str, new MaxMediatedNetworkInfoImpl(jSONObject));
        }
    }

    private static void d(com.applovin.impl.sdk.k kVar) {
        synchronized (f) {
            for (int i = 0; i < d.length(); i++) {
                JSONObject jSONObject = JsonUtils.getJSONObject(d, i, (JSONObject) null);
                String string = JsonUtils.getString(jSONObject, "class", "");
                b(jSONObject, string, kVar);
                c(jSONObject, string, kVar);
            }
        }
    }

    public static void e(com.applovin.impl.sdk.k kVar) {
        JSONArray b2 = b(kVar);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b2.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(b2, i, (JSONObject) null);
            if (!JsonUtils.getBoolean(jSONObject, "is_supported", Boolean.TRUE).booleanValue()) {
                arrayList.add(JsonUtils.getString(jSONObject, "name", "unknown") + " (" + JsonUtils.getString(jSONObject, "version", "unknown") + ")");
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        String join = StringUtils.join(", ", arrayList);
        String str = "Please update to the latest adapter versions. Incompatible adapter(s) found: " + join;
        if (k7.c(kVar)) {
            throw new IllegalArgumentException(str);
        }
        com.applovin.impl.sdk.o.h("MediationUtils", str);
        HashMap hashMap = new HashMap();
        CollectionUtils.putStringIfValid("details", join, hashMap);
        kVar.E().d(c2.E0, hashMap);
    }

    public static String a(MaxAdapter maxAdapter) {
        try {
            return StringUtils.emptyIfNull(maxAdapter.getSdkVersion());
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("MediationUtils", "Failed to retrieve SDK version for adapter: " + maxAdapter, th);
            return "";
        }
    }

    public static Map c(com.applovin.impl.sdk.k kVar) {
        HashMap hashMap = new HashMap(4);
        String emptyIfNull = StringUtils.emptyIfNull(kVar.x0().e());
        if (!((Boolean) kVar.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        hashMap.put("{PLACEMENT}", "");
        hashMap.put("{CUSTOM_DATA}", "");
        hashMap.put("{CREATIVE_ID}", "");
        return hashMap;
    }

    public static MaxMediatedNetworkInfo a(String str) {
        MaxMediatedNetworkInfo maxMediatedNetworkInfo;
        synchronized (f) {
            maxMediatedNetworkInfo = (MaxMediatedNetworkInfo) e.get(str);
        }
        if (maxMediatedNetworkInfo != null) {
            return maxMediatedNetworkInfo;
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "class", str);
        return new MaxMediatedNetworkInfoImpl(jSONObject);
    }

    public static boolean a(MaxAdapter maxAdapter, String str) {
        String str2 = (String) b.get(str);
        return TextUtils.isEmpty(str2) || k7.a(maxAdapter.getAdapterVersion(), str2) >= 0;
    }

    public static MaxAdapter a(String str, com.applovin.impl.sdk.k kVar) {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            }
            return null;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("AppLovinSdk", "Failed to load: " + str, th);
            }
        }
        if (MaxAdapter.class.isAssignableFrom(cls)) {
            return (MaxAdapter) cls.getConstructor(AppLovinSdk.class).newInstance(kVar.z0());
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().b("AppLovinSdk", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
        }
        return null;
    }

    private static void b(JSONObject jSONObject, String str, com.applovin.impl.sdk.k kVar) {
        synchronized (f) {
            Integer a2 = kVar.S().a(str);
            if (a2 == null) {
                return;
            }
            JsonUtils.putInt(jSONObject, "initialization_status", a2.intValue());
            e.put(str, new MaxMediatedNetworkInfoImpl(jSONObject));
        }
    }

    public static boolean b(Object obj) {
        return (obj instanceof v2) && "APPLOVIN".equals(((v2) obj).k());
    }

    public static AppLovinSdkUtils.Size b(int i, MaxAdFormat maxAdFormat, Context context) {
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.AdSize");
            Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", Context.class, Integer.TYPE);
            Method method2 = cls.getMethod("getWidth", null);
            Method method3 = cls.getMethod("getHeight", null);
            Object invoke = method.invoke(null, context, Integer.valueOf(i));
            AppLovinSdkUtils.Size size = new AppLovinSdkUtils.Size(((Integer) method2.invoke(invoke, null)).intValue(), ((Integer) method3.invoke(invoke, null)).intValue());
            g.put(Integer.valueOf(i), size);
            return size;
        } catch (Throwable unused) {
            return maxAdFormat.getSize();
        }
    }

    public static boolean a(Object obj) {
        return (obj instanceof com.applovin.impl.sdk.ad.b) && StringUtils.isValidString(((com.applovin.impl.sdk.ad.b) obj).getMediationServeId());
    }

    public static AppLovinSdkUtils.Size a(int i, MaxAdFormat maxAdFormat, Context context) {
        if (i < 0) {
            i = AppLovinSdkUtils.pxToDp(context, o0.a(context).x);
        }
        Map map = g;
        if (map.containsKey(Integer.valueOf(i))) {
            return (AppLovinSdkUtils.Size) map.get(Integer.valueOf(i));
        }
        if (Boolean.TRUE.equals((Boolean) y4.a(x4.I, Boolean.FALSE, context))) {
            return a(i, context);
        }
        return b(i, maxAdFormat, context);
    }

    public static AppLovinSdkUtils.Size a(int i, Context context) {
        int round;
        if (i >= 600) {
            round = Math.round(i / 8.088889f);
        } else if (i > 450) {
            round = Math.round(i / 7.8f);
        } else {
            round = Math.round(i / 6.4f);
        }
        AppLovinSdkUtils.Size size = new AppLovinSdkUtils.Size(i, Math.max(50, Math.min(round, Math.min(90, Math.round(AppLovinSdkUtils.pxToDp(context, o0.b(context).y) * 0.15f)))));
        g.put(Integer.valueOf(i), size);
        return size;
    }

    public static boolean a(JSONObject jSONObject, String str, com.applovin.impl.sdk.k kVar) {
        if (!JsonUtils.containsJSONObjectContainingInt(jSONObject.optJSONArray("no_fill_reason"), IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES, "code")) {
            return false;
        }
        kVar.E().a(c2.E0, "invalid_or_disabled_ad_unit_id", CollectionUtils.hashMap("ad_unit_id", str), "invalid_or_disabled_ad_unit_id" + str);
        return true;
    }

    public static Map a(v2 v2Var, com.applovin.impl.sdk.k kVar) {
        HashMap hashMap = new HashMap(4);
        String emptyIfNull = StringUtils.emptyIfNull(kVar.x0().e());
        if (!((Boolean) kVar.a(v4.E3)).booleanValue()) {
            emptyIfNull = "";
        }
        hashMap.put("{CUID}", emptyIfNull);
        hashMap.put("{PLACEMENT}", StringUtils.emptyIfNull(v2Var.getPlacement()));
        hashMap.put("{CUSTOM_DATA}", StringUtils.emptyIfNull(v2Var.e()));
        hashMap.put("{CREATIVE_ID}", StringUtils.emptyIfNull(v2Var.getCreativeId()));
        return hashMap;
    }
}
