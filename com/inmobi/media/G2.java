package com.inmobi.media;

import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.CrashConfig;
import com.inmobi.commons.core.configs.RootConfig;
import com.inmobi.commons.core.configs.SignalsConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class G2 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static Config a(String configType, String str) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        switch (configType.hashCode()) {
            case -60641721:
                if (configType.equals("crashReporting")) {
                    return new CrashConfig(str);
                }
                break;
            case 96432:
                if (configType.equals(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) {
                    return new AdConfig(str);
                }
                break;
            case 3506402:
                if (configType.equals("root")) {
                    return new RootConfig(str);
                }
                break;
            case 780346297:
                if (configType.equals("telemetry")) {
                    return new TelemetryConfig(str);
                }
                break;
            case 2088265419:
                if (configType.equals("signals")) {
                    return new SignalsConfig(str);
                }
                break;
        }
        return new AdConfig(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Config a(String configType, JSONObject jsonObject, String str, long j) {
        Config config;
        Intrinsics.checkNotNullParameter(configType, "configType");
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        switch (configType.hashCode()) {
            case -60641721:
                if (configType.equals("crashReporting")) {
                    CrashConfig.Companion.getClass();
                    config = (Config) new C2825q6().a(jsonObject, CrashConfig.class);
                    break;
                }
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
            case 96432:
                if (configType.equals(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS)) {
                    AdConfig.Companion.getClass();
                    config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                    break;
                }
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
            case 3506402:
                if (configType.equals("root")) {
                    RootConfig.Companion.getClass();
                    config = (Config) new C2825q6().a(new Ec("components", RootConfig.class), (Dc) new U6(new com.inmobi.commons.core.configs.d(), RootConfig.ComponentConfig.class)).a(new Ec(RootConfig.IP_ADDRESS_TP_SUPPORT_KEY, RootConfig.class), (Dc) new U6(new Bc(), String.class)).a(jsonObject, RootConfig.class);
                    break;
                }
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
            case 780346297:
                if (configType.equals("telemetry")) {
                    TelemetryConfig.Companion.getClass();
                    config = (Config) new C2825q6().a(new Ec("priorityEvents", TelemetryConfig.class), (Dc) new U6(new Qd(), String.class)).a(jsonObject, TelemetryConfig.class);
                    break;
                }
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
            case 2088265419:
                if (configType.equals("signals")) {
                    SignalsConfig.Companion.getClass();
                    config = (Config) com.inmobi.commons.core.configs.f.a().a(jsonObject, SignalsConfig.class);
                    break;
                }
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
            default:
                AdConfig.Companion.getClass();
                config = (Config) com.inmobi.commons.core.configs.b.a().a(jsonObject, AdConfig.class);
                break;
        }
        if (config != null) {
            config.setAccountId$media_release(str);
            config.setLastUpdateTimeStamp(j);
        }
        return config;
    }
}
