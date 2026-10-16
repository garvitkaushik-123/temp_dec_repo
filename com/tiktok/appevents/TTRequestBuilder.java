package com.tiktok.appevents;

import android.os.SystemClock;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.mbridge.msdk.MBridgeConstans;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.appevents.TTIdentifierFactory;
import com.tiktok.util.SystemInfoUtil;
import com.tiktok.util.TTUtil;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class TTRequestBuilder {
    private static final String TAG = "com.tiktok.appevents.TTRequestBuilder";
    private static JSONObject basePayloadCache;
    private static JSONObject contextForApiCache;
    private static JSONObject healthBasePayloadCache;

    TTRequestBuilder() {
    }

    public static JSONObject getBasePayload() {
        TTUtil.checkThread(TAG);
        JSONObject jSONObject = basePayloadCache;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (TikTokBusinessSdk.onlyAppIdProvided()) {
                jSONObject2.put(MBridgeConstans.APP_ID, TikTokBusinessSdk.getAppId());
            } else {
                jSONObject2.put("tiktok_app_id", TikTokBusinessSdk.getFirstTTAppIds());
            }
            if (TikTokBusinessSdk.isInSdkDebugMode().booleanValue()) {
                jSONObject2.put("test_event_code", String.valueOf(TikTokBusinessSdk.getTTAppId()));
            }
            jSONObject2.put("event_source", "APP_EVENTS_SDK");
            basePayloadCache = jSONObject2;
            return jSONObject2;
        } catch (Exception e) {
            TTCrashHandler.handleCrash(TAG, e, 2);
            JSONObject jSONObject3 = new JSONObject();
            basePayloadCache = jSONObject3;
            return jSONObject3;
        }
    }

    private static JSONObject getImmutableContextForApi(TTAppEvent event) throws JSONException {
        TTIdentifierFactory.AdIdInfo adIdInfo;
        JSONObject jSONObject = contextForApiCache;
        if (jSONObject != null) {
            freshOsVersion(jSONObject, event);
            return contextForApiCache;
        }
        long currentTimeMillis = System.currentTimeMillis();
        TTIdentifierFactory.AdIdInfo adIdInfo2 = null;
        try {
            TikTokBusinessSdk.getAppEventLogger().monitorMetric("did_start", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)), null);
            adIdInfo = TikTokBusinessSdk.isGaidCollectionEnabled() ? TTIdentifierFactory.getGoogleAdIdInfo(TikTokBusinessSdk.getApplicationContext()) : null;
        } catch (Exception unused) {
        }
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            TikTokBusinessSdk.getAppEventLogger().monitorMetric("did_end", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis2)).put("latency", currentTimeMillis2 - currentTimeMillis).put("success", (adIdInfo.getAdId() == null || adIdInfo.getAdId() == "") ? false : true), null);
        } catch (Exception unused2) {
            adIdInfo2 = adIdInfo;
            adIdInfo = adIdInfo2;
            JSONObject contextBuilder = contextBuilder(adIdInfo);
            contextForApiCache = contextBuilder;
            freshOsVersion(contextBuilder, event);
            return contextForApiCache;
        }
        JSONObject contextBuilder2 = contextBuilder(adIdInfo);
        contextForApiCache = contextBuilder2;
        freshOsVersion(contextBuilder2, event);
        return contextForApiCache;
    }

    private static void freshOsVersion(JSONObject contextForApiCache2, TTAppEvent event) {
        try {
            JSONObject jSONObject = contextForApiCache2.getJSONObject(C3040d4.h.G);
            if (event != null && jSONObject != null) {
                jSONObject.put("os_version", SystemInfoUtil.getAndroidVersion());
                jSONObject.remove("version");
            } else {
                jSONObject.put("version", SystemInfoUtil.getAndroidVersion());
                jSONObject.remove("os_version");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static JSONObject getContextForApi(TTAppEvent event) throws JSONException {
        JSONObject jSONObject = new JSONObject(getImmutableContextForApi(event).toString());
        jSONObject.put(AnalyticsConstants.SOURCE_USER_TYPE, event.getUserInfo().toJsonObject());
        return jSONObject;
    }

    private static Locale getCurrentLocale() {
        return TikTokBusinessSdk.getApplicationContext().getResources().getConfiguration().getLocales().get(0);
    }

    static String getBcp47Language() {
        return getCurrentLocale().toLanguageTag();
    }

    private static JSONObject contextBuilder(TTIdentifierFactory.AdIdInfo adIdInfo) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (TikTokBusinessSdk.bothIdsProvided()) {
            jSONObject.put("id", TikTokBusinessSdk.getAppId());
        }
        jSONObject.put("name", SystemInfoUtil.getAppName());
        jSONObject.put("namespace", SystemInfoUtil.getPackageName());
        jSONObject.put("version", SystemInfoUtil.getAppVersionName());
        jSONObject.put("build", SystemInfoUtil.getAppVersionCode() + "");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(N6.H, C3040d4.d);
        if (adIdInfo != null) {
            jSONObject2.put("gaid", adIdInfo.getAdId());
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("name", "tiktok/" + TTRequest.LIBRARY_NAME);
        jSONObject3.put("version", SystemInfoUtil.getSDKVersion());
        JSONObject jSONObject4 = new JSONObject();
        jSONObject.put("tiktok_app_id", TikTokBusinessSdk.getTTAppId());
        jSONObject4.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject);
        jSONObject4.put("library", jSONObject3);
        jSONObject4.put(C3040d4.h.G, jSONObject2);
        jSONObject4.put("locale", getBcp47Language());
        jSONObject4.put("ip", SystemInfoUtil.getLocalIpAddress());
        String userAgent = SystemInfoUtil.getUserAgent();
        if (userAgent != null) {
            jSONObject4.put("user_agent", userAgent);
        }
        return jSONObject4;
    }

    private static JSONObject enrichDeviceBase(JSONObject d) throws JSONException {
        JSONObject jSONObject = new JSONObject(d.toString());
        jSONObject.put("id", TTUtil.getOrGenAnoId(TikTokBusinessSdk.getApplicationContext(), false));
        jSONObject.put("user_agent", SystemInfoUtil.getUserAgent());
        jSONObject.put("ip", SystemInfoUtil.getLocalIpAddress());
        jSONObject.put("network", SystemInfoUtil.getNetworkClass(TikTokBusinessSdk.getApplicationContext()));
        jSONObject.put("session", TikTokBusinessSdk.getSessionID());
        jSONObject.put("locale", getBcp47Language());
        jSONObject.put("ts", System.currentTimeMillis() - SystemClock.elapsedRealtime());
        return jSONObject;
    }

    public static JSONObject getHealthMonitorBase() throws JSONException {
        JSONObject jSONObject = healthBasePayloadCache;
        if (jSONObject != null) {
            jSONObject.put(C3040d4.h.G, enrichDeviceBase(jSONObject.getJSONObject(C3040d4.h.G)));
            return healthBasePayloadCache;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject(getImmutableContextForApi(null).getJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP).toString());
        jSONObject3.put("app_namespace", SystemInfoUtil.getPackageName());
        jSONObject2.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject3);
        jSONObject2.put("library", getImmutableContextForApi(null).get("library"));
        jSONObject2.put(C3040d4.h.G, enrichDeviceBase(getImmutableContextForApi(null).getJSONObject(C3040d4.h.G)));
        jSONObject2.put("log_extra", (Object) null);
        healthBasePayloadCache = jSONObject2;
        return jSONObject2;
    }
}
