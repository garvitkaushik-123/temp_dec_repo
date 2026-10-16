package com.inmobi.media;

import com.inmobi.unification.sdk.model.Initialization.TimeoutConfigurations$MediationConfig;
import java.io.Serializable;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.ne, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2784ne implements Serializable {
    private static final int APPLOVIN_AB_DEFAULT_AUDIO_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_AB_DEFAULT_AUDIO_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_AUDIO_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_AB_DEFAULT_BANNER_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_AB_DEFAULT_BANNER_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_BANNER_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_AB_DEFAULT_INTERSTITIAL_LOAD_TIMEOUT = 29500;
    private static final int APPLOVIN_AB_DEFAULT_INTERSTITIAL_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_INTERSTITIAL_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_AB_DEFAULT_NATIVE_LOAD_TIMEOUT = 14500;
    private static final int APPLOVIN_AB_DEFAULT_NATIVE_MAX_RETRIES = 3;
    private static final int APPLOVIN_AB_DEFAULT_NATIVE_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_MUTT_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_AUDIO_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_LOAD_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_MUTT_TIMEOUT = 9500;
    private static final int APPLOVIN_NONAB_DEFAULT_BANNER_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_LOAD_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_MUTT_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_INTERSTITIAL_RETRY_INTERVAL = 1000;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_LOAD_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_MAX_RETRIES = 3;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_MUTT_TIMEOUT = 14500;
    private static final int APPLOVIN_NONAB_DEFAULT_NATIVE_RETRY_INTERVAL = 1000;
    private static final int DEFAULT_AB_AUDIO_LOAD_TIMEOUT = 14500;
    private static final int DEFAULT_AB_BANNER_LOAD_TIMEOUT = 14500;
    private static final int DEFAULT_AB_INTERSTITIAL_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_AB_NATIVE_LOAD_TIMEOUT = 14500;
    private static final String DEFAULT_KEY = "default";
    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final int DEFAULT_NONAB_AUDIO_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_AUDIO_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_BANNER_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_BANNER_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_INTERSTITIAL_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_INTERSTITIAL_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_NATIVE_LOAD_TIMEOUT = 29500;
    private static final int DEFAULT_NONAB_NATIVE_MUTT_TIMEOUT = 29500;
    private static final int DEFAULT_RETRY_INTERVAL = 1000;
    public static final int DEFAULT_TIMEOUT = 15000;
    public static final C2752le Companion = new C2752le();
    private static final String APPLOVIN_KEY = "c_applovin";
    private static final JSONObject defaultNonABBannerloadTimeout = AbstractC2720je.a(29500, 9500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABBannerMuttTimeout = AbstractC2720je.a(29500, 9500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABBannerMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABBannerRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABIntloadTimeout = AbstractC2720je.a(29500, 14500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABIntMuttTimeout = AbstractC2720je.a(29500, 14500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABIntMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABIntRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABNativeloadTimeout = AbstractC2720je.a(29500, 14500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABNativeMuttTimeout = AbstractC2720je.a(29500, 14500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABNativeMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABNativeRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABAudioloadTimeout = AbstractC2720je.a(29500, 9500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABAudioMuttTimeout = AbstractC2720je.a(29500, 9500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABAudioMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultNonABAudioRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABBannerloadTimeout = AbstractC2720je.a(14500, 9500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABBannerMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABBannerRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABIntloadTimeout = AbstractC2720je.a(29500, 29500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABIntMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABIntRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABNativeloadTimeout = AbstractC2720je.a(14500, 14500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABNativeMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABNativeRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABAudioloadTimeout = AbstractC2720je.a(14500, 9500, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABAudioMaxRetries = AbstractC2720je.a(3, 3, "default", APPLOVIN_KEY);
    private static final JSONObject defaultABAudioRetryInterval = AbstractC2720je.a(1000, 1000, "default", APPLOVIN_KEY);
    private static final JSONObject defaultPreloadBannerPreloadTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadBannerMuttTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadBannerLoadTimeout = AbstractC2704ie.a("default", 14500);
    private static final JSONObject defaultPreloadBannerMaxRetries = AbstractC2704ie.a("default", 3);
    private static final JSONObject defaultPreloadBannerRetryInterval = AbstractC2704ie.a("default", 1000);
    private static final JSONObject defaultPreloadIntPreloadTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadIntMuttTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadIntloadTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadIntMaxRetries = AbstractC2704ie.a("default", 3);
    private static final JSONObject defaultPreloadIntRetryInterval = AbstractC2704ie.a("default", 1000);
    private static final JSONObject defaultPreloadNativePreloadTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadNativeMuttTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadNativeloadTimeout = AbstractC2704ie.a("default", 14500);
    private static final JSONObject defaultPreloadNativeMaxRetries = AbstractC2704ie.a("default", 3);
    private static final JSONObject defaultPreloadNativeRetryInterval = AbstractC2704ie.a("default", 1000);
    private static final JSONObject defaultPreloadAudioPreloadTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadAudioMuttTimeout = AbstractC2704ie.a("default", 29500);
    private static final JSONObject defaultPreloadAudioloadTimeout = AbstractC2704ie.a("default", 14500);
    private static final JSONObject defaultPreloadAudioMaxRetries = AbstractC2704ie.a("default", 3);
    private static final JSONObject defaultPreloadAudioRetryInterval = AbstractC2704ie.a("default", 1000);
    private static final Function2<JSONObject, Integer, Boolean> validator = C2736ke.f2625a;
    private int step4s = 15000;
    private TimeoutConfigurations$MediationConfig mediationConfig = new TimeoutConfigurations$MediationConfig();

    public final TimeoutConfigurations$MediationConfig X() {
        return this.mediationConfig;
    }

    public final int Y() {
        return this.step4s;
    }

    public final boolean Z() {
        return Y() >= 0 && this.mediationConfig.isValid();
    }

    public final void a0() {
        int i = this.step4s;
        if (i <= 0) {
            i = 15000;
        }
        this.step4s = i;
    }
}
