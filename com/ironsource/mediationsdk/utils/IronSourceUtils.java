package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.ironsource.B1;
import com.ironsource.C3025c9;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.G9;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.K6;
import com.ironsource.La;
import com.ironsource.Lc;
import com.ironsource.Z3;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.d;
import com.ironsource.mediationsdk.p;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.unity3d.mediation.LevelPlay;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes6.dex */
public class IronSourceUtils {
    private static final String DEFAULT_APP_EVENTS_FORMATTER_TYPE = "default_app_events_formatter_type";
    private static final String DEFAULT_APP_EVENTS_URL = "default_app_events_url";
    private static final String DEFAULT_APP_NON_CONNECTIVITY_EVENTS = "default_app_non_connectivity_events";
    private static final String DEFAULT_APP_OPT_IN_EVENTS = "default_app_opt_in_events";
    private static final String DEFAULT_APP_OPT_OUT_EVENTS = "default_app_opt_out_events";
    private static final String DEFAULT_APP_TRIGGER_EVENTS = "default_app_trigger_events";
    private static final String DEFAULT_IS_EVENTS_FORMATTER_TYPE = "default_is_events_formatter_type";
    private static final String DEFAULT_IS_EVENTS_URL = "default_is_events_url";
    private static final String DEFAULT_IS_NON_CONNECTIVITY_EVENTS = "default_is_non_connectivity_events";
    private static final String DEFAULT_IS_OPT_IN_EVENTS = "default_is_opt_in_events";
    private static final String DEFAULT_IS_OPT_OUT_EVENTS = "default_is_opt_out_events";
    private static final String DEFAULT_IS_TRIGGER_EVENTS = "default_is_trigger_events";
    private static final String DEFAULT_PXL_EVENTS_URL = "default_pxl_events_url";
    private static final String DEFAULT_PXL_TRIGGER_EVENTS = "default_pxl_trigger_events";
    private static final String DEFAULT_RV_EVENTS_FORMATTER_TYPE = "default_rv_events_formatter_type";
    private static final String DEFAULT_RV_EVENTS_URL = "default_rv_events_url";
    private static final String DEFAULT_RV_NON_CONNECTIVITY_EVENTS = "default_rv_non_connectivity_events";
    private static final String DEFAULT_RV_OPT_IN_EVENTS = "default_rv_opt_in_events";
    private static final String DEFAULT_RV_OPT_OUT_EVENTS = "default_rv_opt_out_events";
    private static final String DEFAULT_RV_TRIGGER_EVENTS = "default_rv_trigger_events";
    private static final String FIRST_SESSION_TIMESTAMP = "firstSessionTimestamp";
    private static final String GENERAL_PROPERTIES = "general_properties";
    private static final String LAST_RESPONSE = "last_response";
    private static final String PROVIDER_PRIORITY = "providerPriority";
    private static final String SDK_VERSION = "8.11.1";
    private static final String SHARED_PREFERENCES_NAME = "Mediation_Shared_Preferences";
    private static int serr = 1;
    private static AtomicBoolean mDidCreateSessionID = new AtomicBoolean(false);
    private static String mSessionId = null;
    private static Boolean mFirstSession = null;
    private static IronSourceUtils instance = new IronSourceUtils();

    public static void createAndStartWorker(Runnable runnable, String str) {
        Thread thread = new Thread(runnable, str);
        thread.setUncaughtExceptionHandler(new d());
        thread.start();
    }

    public static JSONObject deepMergeJSONObjects(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject2.get(next);
            if (!(obj instanceof JSONObject) || jSONObject3.optJSONObject(next) == null) {
                jSONObject3.put(next, obj);
            } else {
                jSONObject3.put(next, deepMergeJSONObjects(jSONObject3.getJSONObject(next), (JSONObject) obj));
            }
        }
        return jSONObject3;
    }

    public static boolean doesClassExist(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Map<LevelPlay.AdFormat, Map<String, JSONObject>> getAdUnitIds() {
        HashMap hashMap = new HashMap();
        try {
            La a2 = C3334ub.U().e().a();
            if (a2 != null) {
                for (LevelPlay.AdFormat adFormat : LevelPlay.AdFormat.values()) {
                    HashMap hashMap2 = new HashMap();
                    hashMap.put(adFormat, hashMap2);
                    for (String str : a2.a(adFormat)) {
                        if (!str.equals(B1.e)) {
                            hashMap2.put(str, new JSONObject());
                        }
                    }
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error("failed to get ad unit ids - exception = " + e);
        }
        return hashMap;
    }

    public static String getBase64Auth(String str, String str2) {
        return "Basic " + Base64.encodeToString((str + ":" + str2).getBytes(), 10);
    }

    public static boolean getBooleanFromSharedPrefs(Context context, String str, boolean z) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getBoolean(str, z);
    }

    public static int getCurrentTimestamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static synchronized String getDefaultEventsFormatterType(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                str2 = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(getDefaultFormatterTypeByEventType(str), str2);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultEventsFormatterType(eventType: " + str + ", defaultFormatterType:" + str2 + ")", e);
            }
        }
        return str2;
    }

    public static synchronized String getDefaultEventsURL(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                str2 = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(getDefaultEventsUrlByEventType(str), str2);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultEventsURL(eventType: " + str + ", defaultEventsURL:" + str2 + ")", e);
            }
        }
        return str2;
    }

    private static String getDefaultEventsUrlByEventType(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? DEFAULT_IS_EVENTS_URL : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? DEFAULT_RV_EVENTS_URL : IronSourceConstants.PIXEL_EVENT_TYPE.equals(str) ? DEFAULT_PXL_EVENTS_URL : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? DEFAULT_APP_EVENTS_URL : "";
    }

    private static String getDefaultFormatterTypeByEventType(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? DEFAULT_IS_EVENTS_FORMATTER_TYPE : (IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) || IronSourceConstants.PIXEL_EVENT_TYPE.equals(str)) ? DEFAULT_RV_EVENTS_FORMATTER_TYPE : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? DEFAULT_APP_EVENTS_FORMATTER_TYPE : "";
    }

    public static synchronized int[] getDefaultNonConnectivityEvents(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(getDefaultNonConnectivityEventsByEventType(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i = 0; i < size; i++) {
                        iArr[i] = ((Integer) arrayList.get(i)).intValue();
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultNonConnectivityEvents(eventType: " + str + ")", e);
            }
        }
        return iArr;
    }

    private static String getDefaultNonConnectivityEventsByEventType(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? DEFAULT_IS_NON_CONNECTIVITY_EVENTS : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? DEFAULT_RV_NON_CONNECTIVITY_EVENTS : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? DEFAULT_APP_NON_CONNECTIVITY_EVENTS : "";
    }

    public static synchronized int[] getDefaultOptInEvents(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(getDefaultOptInEventsByEventType(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i = 0; i < size; i++) {
                        iArr[i] = ((Integer) arrayList.get(i)).intValue();
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultOptInEvents(eventType: " + str + ")", e);
            }
        }
        return iArr;
    }

    private static String getDefaultOptInEventsByEventType(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? DEFAULT_IS_OPT_IN_EVENTS : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? DEFAULT_RV_OPT_IN_EVENTS : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? DEFAULT_APP_OPT_IN_EVENTS : "";
    }

    public static synchronized int[] getDefaultOptOutEvents(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(getDefaultOptOutEventsByEventType(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i = 0; i < size; i++) {
                        iArr[i] = ((Integer) arrayList.get(i)).intValue();
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultOptOutEvents(eventType: " + str + ")", e);
            }
        }
        return iArr;
    }

    private static String getDefaultOptOutEventsByEventType(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? DEFAULT_IS_OPT_OUT_EVENTS : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? DEFAULT_RV_OPT_OUT_EVENTS : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? DEFAULT_APP_OPT_OUT_EVENTS : "";
    }

    public static synchronized int[] getDefaultTriggerEvents(Context context, String str) {
        int[] iArr;
        synchronized (IronSourceUtils.class) {
            iArr = null;
            try {
                String string = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(getDefaultTriggerEventsByEventType(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i = 0; i < size; i++) {
                        iArr[i] = ((Integer) arrayList.get(i)).intValue();
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultTriggerEvents(eventType: " + str + ")", e);
            }
        }
        return iArr;
    }

    private static String getDefaultTriggerEventsByEventType(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? DEFAULT_IS_TRIGGER_EVENTS : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? DEFAULT_RV_TRIGGER_EVENTS : IronSourceConstants.PIXEL_EVENT_TYPE.equals(str) ? DEFAULT_PXL_TRIGGER_EVENTS : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? DEFAULT_APP_TRIGGER_EVENTS : "";
    }

    public static String getDeviceType(Context context) {
        return C3334ub.U().i().a(context) ? "Tablet" : "Phone";
    }

    public static boolean getFirstSession(Context context) {
        if (mFirstSession == null) {
            mFirstSession = Boolean.valueOf(!C3025c9.a(context));
        }
        return mFirstSession.booleanValue();
    }

    public static IronSourceUtils getInstance() {
        return instance;
    }

    public static int getIntFromSharedPrefs(Context context, String str, int i) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getInt(str, i);
    }

    public static G9 getIronSourceAdvId(Context context) {
        String str;
        InterfaceC3381x7 i = C3334ub.U().i();
        if (context == null) {
            return null;
        }
        String advertiserId = p.j().getAdvertiserId(context);
        if (TextUtils.isEmpty(advertiserId)) {
            advertiserId = i.M(context);
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 0);
            str = IronSourceConstants.TYPE_UUID;
        } else {
            str = IronSourceConstants.TYPE_GAID;
        }
        return new G9(advertiserId, str);
    }

    public static JSONObject getJsonForMetaData(String str, List<String> list, List<String> list2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i < list.size() && i2 < list2.size(); i2++) {
                String str2 = list.get(i);
                String str3 = list2.get(i2);
                if (!TextUtils.isEmpty(str3) && !str2.equals(str3)) {
                    str2 = str2 + ";" + str3;
                }
                arrayList.add(str2);
                i++;
            }
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, str + ";" + TextUtils.join(",", arrayList));
            return jSONObject;
        } catch (JSONException e) {
            C3260q4.d().a(e);
            return jSONObject;
        }
    }

    public static JSONObject getJsonForUserId(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            if (z) {
                jSONObject.put(IronSourceConstants.EVENTS_EXT1, "dynamic");
                return jSONObject;
            }
        } catch (JSONException e) {
            C3260q4.d().a(e);
        }
        return jSONObject;
    }

    public static String getLastResponse(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(LAST_RESPONSE, "");
    }

    public static long getLongFromSharedPrefs(Context context, String str, long j) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getLong(str, j);
    }

    public static String getMD5(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance(SameMD5.TAG).digest(str.getBytes())).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            if (str == null) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:null)", th);
                return "";
            }
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getMD5(input:" + str + ")", th);
            return "";
        }
    }

    public static JSONObject getMediationAdditionalData(boolean z) {
        return getMediationAdditionalData(z, false, 1);
    }

    public static String getMediationUserId() {
        return K6.a().a("userId");
    }

    @Deprecated
    public static String getSDKVersion() {
        return "8.11.1";
    }

    public static String getSHA256(String str) {
        try {
            return String.format("%064x", new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e) {
            C3260q4.d().a(e);
            if (str == null) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:null)", e);
                return "";
            }
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:" + str + ")", e);
            return "";
        }
    }

    public static int getSerr() {
        return serr;
    }

    public static synchronized String getSessionId() {
        String str;
        synchronized (IronSourceUtils.class) {
            if (mDidCreateSessionID.compareAndSet(false, true)) {
                mSessionId = UUID.randomUUID().toString();
            }
            str = mSessionId;
        }
        return str;
    }

    public static String getStringFromSharedPrefs(Context context, String str, String str2) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).getString(str, str2);
    }

    public static long getTimestamp() {
        return System.currentTimeMillis();
    }

    public static String getTransId(long j, String str) {
        return getSHA256(String.format("%s%s%s", Long.valueOf(j), p.j().k(), str));
    }

    public static String getUserIdForNetworks() {
        String a2 = K6.a().a("userId");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return a2;
    }

    public static boolean isEncryptedResponse() {
        return serr == 1;
    }

    public static boolean isGooglePlayInstalled(Context context) {
        return Lc.d(context);
    }

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.NATIVE.error("failed to check if network is connected - exception = " + e);
            return false;
        }
    }

    public static JSONObject mergeJsons(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        if (jSONObject == null && jSONObject2 == null) {
            return new JSONObject();
        }
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
        }
        return jSONObject;
    }

    public static List<Pair<String, String>> parseJsonToPairList(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject != JSONObject.NULL) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject.get(next).toString().isEmpty()) {
                        arrayList.add(new Pair(next, jSONObject.get(next).toString()));
                    }
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return arrayList;
    }

    public static Map<String, String> parseJsonToStringMap(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            if (jSONObject != JSONObject.NULL) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!jSONObject.get(next).toString().isEmpty()) {
                        hashMap.put(next, jSONObject.get(next).toString());
                    }
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return hashMap;
    }

    public static void saveBooleanToSharedPrefs(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public static synchronized void saveDefaultEventsFormatterType(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
                edit.putString(getDefaultFormatterTypeByEventType(str), str2);
                edit.apply();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultEventsFormatterType(eventType: " + str + ", formatterType:" + str2 + ")", e);
            }
        }
    }

    public static synchronized void saveDefaultEventsURL(Context context, String str, String str2) {
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
                edit.putString(getDefaultEventsUrlByEventType(str), str2);
                edit.apply();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultEventsURL(eventType: " + str + ", eventsUrl:" + str2 + ")", e);
            }
        }
    }

    public static synchronized void saveDefaultNonConnectivityEvents(Context context, String str, int[] iArr) {
        String str2;
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : iArr) {
                        sb.append(i).append(",");
                    }
                    str2 = sb.toString();
                } else {
                    str2 = null;
                }
                edit.putString(getDefaultNonConnectivityEventsByEventType(str), str2);
                edit.apply();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultNonConnectivityEvents(eventType: " + str + ", nonConnectivityEvents:" + iArr + ")", e);
            }
        }
    }

    public static synchronized void saveDefaultOptInEvents(Context context, String str, int[] iArr) {
        String str2;
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : iArr) {
                        sb.append(i).append(",");
                    }
                    str2 = sb.toString();
                } else {
                    str2 = null;
                }
                edit.putString(getDefaultOptInEventsByEventType(str), str2);
                edit.apply();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptInEvents(eventType: " + str + ", optInEvents:" + iArr + ")", e);
            }
        }
    }

    public static synchronized void saveDefaultOptOutEvents(Context context, String str, int[] iArr) {
        String str2;
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : iArr) {
                        sb.append(i).append(",");
                    }
                    str2 = sb.toString();
                } else {
                    str2 = null;
                }
                edit.putString(getDefaultOptOutEventsByEventType(str), str2);
                edit.apply();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptOutEvents(eventType: " + str + ", optOutEvents:" + iArr + ")", e);
            }
        }
    }

    public static synchronized void saveDefaultTriggerEvents(Context context, String str, int[] iArr) {
        String str2;
        synchronized (IronSourceUtils.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : iArr) {
                        sb.append(i).append(",");
                    }
                    str2 = sb.toString();
                } else {
                    str2 = null;
                }
                edit.putString(getDefaultTriggerEventsByEventType(str), str2);
                edit.apply();
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultTriggerEvents(eventType: " + str + ", triggerEvents:" + iArr + ")", e);
            }
        }
    }

    public static void saveIntToSharedPrefs(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static synchronized void saveLastResponse(Context context, String str) {
        synchronized (IronSourceUtils.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
            edit.putString(LAST_RESPONSE, str);
            edit.apply();
        }
    }

    public static void saveLongToSharedPrefs(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public static void saveStringToSharedPrefs(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static synchronized void sendAutomationLog(String str) {
        synchronized (IronSourceUtils.class) {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "automation_log:" + Long.toString(System.currentTimeMillis()) + " text: " + str, 0);
        }
    }

    private static void setSerr(int i) {
        serr = i;
    }

    public static JSONObject getMediationAdditionalData(boolean z, boolean z2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            if (z) {
                jSONObject.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            }
            if (z2 && i != -1) {
                jSONObject.put(IronSourceConstants.EVENTS_PROGRAMMATIC, i);
                return jSONObject;
            }
        } catch (JSONException e) {
            C3260q4.d().a(e);
        }
        return jSONObject;
    }

    public static String getCurrentMethodName() {
        try {
            return new Throwable().getStackTrace()[1].getMethodName();
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    public static String getConnectionType(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1)) {
                return Z3.b;
            }
            return networkCapabilities.hasTransport(0) ? Z3.g : "none";
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.NATIVE.error("failed to connection type - exception = " + e);
            return "none";
        }
    }
}
