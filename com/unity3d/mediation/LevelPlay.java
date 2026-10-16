package com.unity3d.mediation;

import android.content.Context;
import com.ironsource.C3027cb;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p;
import com.unity3d.mediation.impression.LevelPlayImpressionDataListener;
import com.unity3d.mediation.segment.LevelPlaySegment;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class LevelPlay {
    public static final LevelPlay INSTANCE = new LevelPlay();

    public enum AdFormat {
        BANNER("banner"),
        INTERSTITIAL("interstitial"),
        REWARDED("rewarded"),
        NATIVE_AD("nativeAd");


        /* renamed from: a, reason: collision with root package name */
        private final String f6440a;

        AdFormat(String str) {
            this.f6440a = str;
        }

        public final String getValue() {
            return this.f6440a;
        }
    }

    private LevelPlay() {
    }

    @JvmStatic
    public static final void addImpressionDataListener(LevelPlayImpressionDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.API.info("adding listener: " + listener.getClass().getSimpleName());
        C3027cb.f3228a.a(listener);
    }

    @JvmStatic
    public static final String getSdkVersion() {
        IronLog.API.info("");
        return "8.11.1";
    }

    @JvmStatic
    public static final void init(Context context, LevelPlayInitRequest initRequest, LevelPlayInitListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        C3027cb.f3228a.a(context, initRequest, listener);
    }

    @JvmStatic
    public static final void launchTestSuite(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IronLog.API.info("");
        p.j().b(context);
    }

    @JvmStatic
    public static final void removeImpressionDataListener(LevelPlayImpressionDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.API.info("removing listener: " + listener.getClass().getSimpleName());
        C3027cb.f3228a.b(listener);
    }

    @JvmStatic
    public static final void setAdaptersDebug(boolean z) {
        IronLog.API.info("enabled: " + z);
        p.j().setAdaptersDebug(z);
    }

    @JvmStatic
    public static final void setConsent(boolean z) {
        IronLog.API.info("consent: " + z);
        p.j().a(z);
    }

    @JvmStatic
    public static final boolean setDynamicUserId(String dynamicUserId) {
        Intrinsics.checkNotNullParameter(dynamicUserId, "dynamicUserId");
        IronLog.API.info("dynamicUserId: " + dynamicUserId);
        return p.j().setDynamicUserId(dynamicUserId);
    }

    @JvmStatic
    public static final void setMetaData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IronLog.API.info("key = " + key + ", value = " + value);
        C3027cb.f3228a.a(key, value);
    }

    @JvmStatic
    public static final void setNetworkData(String networkKey, JSONObject networkData) {
        Intrinsics.checkNotNullParameter(networkKey, "networkKey");
        Intrinsics.checkNotNullParameter(networkData, "networkData");
        IronLog.API.info("networkKey = " + networkKey + ", networkData = " + networkData);
        p.j().b(networkKey, networkData);
    }

    @JvmStatic
    public static final void setSegment(LevelPlaySegment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        IronLog.API.info("");
        C3027cb.f3228a.b(segment);
    }

    @JvmStatic
    public static final void validateIntegration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IronLog.API.info("");
        IntegrationHelper.validateIntegration(context);
    }

    @JvmStatic
    public static final void setMetaData(String key, List<String> values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        IronLog.API.info("key = " + key + ", values = " + values);
        p.j().a(key, values);
    }
}
