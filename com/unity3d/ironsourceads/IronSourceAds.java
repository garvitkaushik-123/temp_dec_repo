package com.unity3d.ironsourceads;

import android.content.Context;
import com.ironsource.E9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.p;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class IronSourceAds {
    public static final IronSourceAds INSTANCE = new IronSourceAds();

    public enum AdFormat {
        BANNER("Banner"),
        INTERSTITIAL("Interstitial"),
        REWARDED("RewardedVideo");


        /* renamed from: a, reason: collision with root package name */
        private final String f6423a;

        AdFormat(String str) {
            this.f6423a = str;
        }

        public final String getValue() {
            return this.f6423a;
        }
    }

    private IronSourceAds() {
    }

    @JvmStatic
    public static final void enableDebugMode(boolean z) {
        IronLog.API.info("enabled: " + z);
        p.j().setAdaptersDebug(z);
    }

    @JvmStatic
    public static final String getSdkVersion() {
        IronLog.API.info("");
        return "8.11.1";
    }

    @JvmStatic
    public static final void init(Context context, InitRequest initRequest, InitListener initializationListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initRequest, "initRequest");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationListener");
        E9.f2845a.a(context, initRequest, initializationListener);
    }

    @JvmStatic
    public static final void setConsent(boolean z) {
        IronLog.API.info("consent: " + z);
        p.j().a(z);
    }

    @JvmStatic
    public static final void setMetaData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IronLog.API.info("key = " + key + ", value = " + value);
        E9.f2845a.a(key, value);
    }

    @JvmStatic
    public static final void setMetaData(String key, List<String> values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        IronLog.API.info("key = " + key + ", values = " + values);
        p.j().a(key, values);
    }
}
