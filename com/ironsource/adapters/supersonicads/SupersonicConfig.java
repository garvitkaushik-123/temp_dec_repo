package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import com.ironsource.A5;
import com.ironsource.C3167kd;
import com.ironsource.C3260q4;
import com.ironsource.C3413z5;
import com.ironsource.Id;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: classes6.dex */
public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    NetworkSettings mProviderSettings = new NetworkSettings(C3167kd.c().b("Mediation"));

    private SupersonicConfig() {
    }

    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            try {
                Set<String> keySet = map.keySet();
                if (keySet != null) {
                    for (String str : keySet) {
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = map.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                hashMap.put("custom_" + str, str2);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", e);
            }
        }
        return hashMap;
    }

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    public boolean getClientSideCallbacks() {
        NetworkSettings networkSettings = this.mProviderSettings;
        if (networkSettings == null || networkSettings.getRewardedVideoSettings() == null || !this.mProviderSettings.getRewardedVideoSettings().has("useClientSideCallbacks")) {
            return false;
        }
        return this.mProviderSettings.getRewardedVideoSettings().optBoolean("useClientSideCallbacks", false);
    }

    @Deprecated
    public void setClientSideCallbacks(boolean z) {
        C3413z5 c3413z5 = new C3413z5(A5.SET_CLIENT_SIDE_CALLBACKS, IronSourceUtils.getMediationAdditionalData(false));
        c3413z5.a(IronSourceConstants.EVENTS_EXT1, Boolean.valueOf(z));
        Id.i().a(c3413z5);
        this.mProviderSettings.setRewardedVideoSettings("useClientSideCallbacks", String.valueOf(z));
    }

    public void setCustomControllerUrl(String str) {
        this.mProviderSettings.setRewardedVideoSettings("controllerUrl", str);
        this.mProviderSettings.setInterstitialSettings("controllerUrl", str);
        this.mProviderSettings.setBannerSettings("controllerUrl", str);
        this.mProviderSettings.setNativeAdSettings("controllerUrl", str);
    }

    public void setDebugMode(int i) {
        this.mProviderSettings.setRewardedVideoSettings("debugMode", Integer.valueOf(i));
        this.mProviderSettings.setInterstitialSettings("debugMode", Integer.valueOf(i));
        this.mProviderSettings.setBannerSettings("debugMode", Integer.valueOf(i));
        this.mProviderSettings.setNativeAdSettings("debugMode", Integer.valueOf(i));
    }
}
