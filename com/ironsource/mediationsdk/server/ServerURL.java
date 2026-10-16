package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.C1;
import com.ironsource.C2986a4;
import com.ironsource.C3137j0;
import com.ironsource.C3193m5;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.N6;
import com.ironsource.Z3;
import com.ironsource.Z9;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
/* loaded from: classes6.dex */
public class ServerURL {
    private static final String AMPERSAND = "&";
    private static final String ANDROID = "android";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION = "appVer";
    private static final String AUID = "auid";
    private static String BASE_URL_PREFIX = "https://i-sdk.mediation.unity3d.com/sdk/v";
    private static final String BASE_URL_SUFFIX = "?request=";
    private static final String BROWSER_USER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CONNECTION_TYPE = "connType";
    private static final String COPPA = "coppa";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "devMake";
    private static final String DEVICE_MODEL = "devModel";
    private static final String EQUAL = "=";
    private static final String FIRST_SESSION = "fs";
    private static final String GAID = "advId";
    private static final String GOOGLE_FAMILY_SUPPORT = "dff";
    private static final String IMPRESSION = "impression";
    private static final String ISO_COUNTRY_CODE = "icc";
    private static final String IS_DEMAND_ONLY = "isDemandOnly";
    private static final String MEDIATION_TYPE = "mt";
    private static final String MOBILE_CARRIER = "mCar";
    private static final String MOBILE_COUNTRY_CODE = "mcc";
    private static final String MOBILE_NETWORK_CODE = "mnc";
    private static final String OS_VERSION = "osVer";
    private static final String PLACEMENT = "placementId";
    private static final String PLATFORM_KEY = "platform";
    private static final String PLUGIN_FW_VERSION = "plugin_fw_v";
    private static final String PLUGIN_TYPE = "pluginType";
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String RAW_CONNECTION_TYPE = "rawConnType";
    private static final String REWARDED_VIDEO_MANUAL_MODE = "rvManual";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String SERR = "serr";
    private static final String TEST_SUITE = "ts";
    private static final String TIME_ZONE_ID = "tz";
    private static final String TIME_ZONE_OFFSET = "tzOff";

    public static String buildInitURL(Context context, String str, String str2, String str3, String str4, boolean z, List<Pair<String, String>> list, boolean z2) throws UnsupportedEncodingException {
        String str5;
        List<String> list2;
        InterfaceC3381x7 i = C3334ub.U().i();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("platform", "android"));
        arrayList.add(new Pair("applicationKey", str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new Pair("applicationUserId", str2));
        }
        arrayList.add(new Pair("sdkVersion", LevelPlay.getSdkVersion()));
        if (z) {
            arrayList.add(new Pair(REWARDED_VIDEO_MANUAL_MODE, "1"));
        }
        if (!IronSourceUtils.isEncryptedResponse()) {
            arrayList.add(new Pair(SERR, "0"));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            arrayList.add(new Pair(PLUGIN_TYPE, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            arrayList.add(new Pair(PLUGIN_VERSION, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            arrayList.add(new Pair(PLUGIN_FW_VERSION, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new Pair(GAID, str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(new Pair("mt", str4));
        }
        String b = C1.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(new Pair(APPLICATION_VERSION, b));
        }
        arrayList.add(new Pair(OS_VERSION, Build.VERSION.SDK_INT + ""));
        arrayList.add(new Pair(DEVICE_MAKE, Build.MANUFACTURER));
        arrayList.add(new Pair(DEVICE_MODEL, Build.MODEL));
        arrayList.add(new Pair("fs", (IronSourceUtils.getFirstSession(context) ? 1 : 0) + ""));
        ConcurrentHashMap<String, List<String>> c = Z9.b().c();
        if (c.containsKey(a.b)) {
            arrayList.add(new Pair(COPPA, c.get(a.b).get(0)));
        }
        if (c.containsKey(a.f)) {
            String str6 = c.get(a.f).get(0);
            if (!TextUtils.isEmpty(str6) && str6.equalsIgnoreCase(a.j)) {
                arrayList.add(new Pair("ts", "1"));
            }
        }
        if (c.containsKey(a.d)) {
            String str7 = c.get(a.d).get(0);
            if (!TextUtils.isEmpty(str7) && str7.equalsIgnoreCase("true")) {
                arrayList.add(new Pair(GOOGLE_FAMILY_SUPPORT, "1"));
            }
        }
        if (c.containsKey(a.e) && (list2 = c.get(a.e)) != null) {
            arrayList.add(new Pair(a.e, list2.get(0)));
        }
        String connectionType = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty(connectionType)) {
            arrayList.add(new Pair(CONNECTION_TYPE, connectionType));
        }
        String d = C2986a4.d(context);
        if (!TextUtils.isEmpty(d)) {
            arrayList.add(new Pair(RAW_CONNECTION_TYPE, d));
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        String s = i.s();
        if (s.length() != 0) {
            arrayList.add(new Pair(BROWSER_USER_AGENT, s));
        }
        try {
            str5 = i.c(context) + "-" + i.A(context);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            str5 = null;
        }
        if (str5 != null && str5.length() != 0) {
            arrayList.add(new Pair(DEVICE_LANG, str5));
        }
        arrayList.add(new Pair("bundleId", context.getPackageName()));
        arrayList.add(new Pair("mcc", "" + Z3.b(context)));
        arrayList.add(new Pair("mnc", "" + Z3.c(context)));
        String G = i.G(context);
        if (!TextUtils.isEmpty(G)) {
            arrayList.add(new Pair("icc", G));
        }
        String u = i.u(context);
        if (!TextUtils.isEmpty(u)) {
            arrayList.add(new Pair(MOBILE_CARRIER, u));
        }
        String d2 = i.d();
        if (!TextUtils.isEmpty(d2)) {
            arrayList.add(new Pair("tz", d2));
        }
        arrayList.add(new Pair(TIME_ZONE_OFFSET, "" + i.m()));
        String d3 = i.d(context);
        if (!TextUtils.isEmpty(d3)) {
            arrayList.add(new Pair("auid", d3));
        }
        if (z2) {
            arrayList.add(new Pair("isDemandOnly", "1"));
        }
        arrayList.add(new Pair(N6.i0, String.valueOf(C3137j0.a())));
        return getBaseUrl(LevelPlay.getSdkVersion()) + URLEncoder.encode(IronSourceAES.encode(C3193m5.b().c(), createURLParams(arrayList)), "UTF-8");
    }

    private static String getBaseUrl(String str) {
        return BASE_URL_PREFIX + str + BASE_URL_SUFFIX;
    }

    public static String getRequestURL(String str, boolean z, int i) throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("impression", Boolean.toString(z)));
        arrayList.add(new Pair("placementId", Integer.toString(i)));
        return str + "&" + createURLParams(arrayList);
    }

    private static void setBaseUrlPrefix(String str) {
        BASE_URL_PREFIX = str;
    }

    private static String createURLParams(List<Pair<String, String>> list) throws UnsupportedEncodingException {
        String str = "";
        for (Pair<String, String> pair : list) {
            if (str.length() > 0) {
                str = str + "&";
            }
            str = str + ((String) pair.first) + "=" + URLEncoder.encode((String) pair.second, "UTF-8");
        }
        return str;
    }
}
