package io.adn.unityplugin.publisher;

import com.ironsource.C3040d4;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.adn.unityplugin.internal.UnityPluginManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnUnityPlugin.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0007J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u000bH\u0007J\b\u0010\u001c\u001a\u00020\u0007H\u0007J\b\u0010\u001d\u001a\u00020\u000bH\u0007J\b\u0010\u001e\u001a\u00020\u0007H\u0007J\b\u0010\u001f\u001a\u00020\u0007H\u0007J\b\u0010 \u001a\u00020\u000bH\u0007J\b\u0010!\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lio/adn/unityplugin/publisher/AdnUnityPlugin;", "", "<init>", "()V", "sdk", "Lio/adn/unityplugin/internal/UnityPluginManager;", MobileAdsBridgeBase.initializeMethodName, "", "callback", "Lio/adn/unityplugin/publisher/AdnUnityCallback;", "isInitialized", "", "setHasUserConsent", "hasUserConsent", "setDoNotSell", "doNotSell", "setVerboseLogging", "enabled", "setPublisherSignals", "json", "", "setPublisherSignal", C3040d4.h.W, "value", "setSdkParameter", "logSdkDebugInfo", "setTestMode", "isTesting", C3040d4.g.E, "isInterstitialReady", C3040d4.g.H, "loadRewardedAd", "isRewardedAdReady", "showRewardedAd", "adn-unityplugin_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnUnityPlugin {
    public static final AdnUnityPlugin INSTANCE = new AdnUnityPlugin();
    private static final UnityPluginManager sdk = new UnityPluginManager();

    private AdnUnityPlugin() {
    }

    @JvmStatic
    public static final void initialize(AdnUnityCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        sdk.initialize(callback);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return sdk.isInitialized();
    }

    @JvmStatic
    public static final void setHasUserConsent(boolean hasUserConsent) {
        sdk.setHasUserConsent(hasUserConsent);
    }

    @JvmStatic
    public static final void setDoNotSell(boolean doNotSell) {
        sdk.setDoNotSell(doNotSell);
    }

    @JvmStatic
    public static final void setVerboseLogging(boolean enabled) {
        sdk.setVerboseLogging(enabled);
    }

    @JvmStatic
    public static final void setPublisherSignals(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        sdk.setPublisherSignals(json);
    }

    @JvmStatic
    public static final void setPublisherSignal(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        sdk.setPublisherSignal(key, value);
    }

    @JvmStatic
    public static final void setSdkParameter(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        sdk.setSdkParameter(key, value);
    }

    @JvmStatic
    public static final String logSdkDebugInfo() {
        return sdk.logSdkDebugInfo();
    }

    @JvmStatic
    public static final void setTestMode(boolean isTesting) {
        sdk.setTestMode(isTesting);
    }

    @JvmStatic
    public static final void loadInterstitial() {
        sdk.loadInterstitial();
    }

    @JvmStatic
    public static final boolean isInterstitialReady() {
        return sdk.isInterstitialReady();
    }

    @JvmStatic
    public static final void showInterstitial() {
        sdk.showInterstitial();
    }

    @JvmStatic
    public static final void loadRewardedAd() {
        sdk.loadRewardedAd();
    }

    @JvmStatic
    public static final boolean isRewardedAdReady() {
        return sdk.isRewardedAdReady();
    }

    @JvmStatic
    public static final void showRewardedAd() {
        sdk.showRewardedAd();
    }
}
