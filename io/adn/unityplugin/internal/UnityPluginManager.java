package io.adn.unityplugin.internal;

import android.app.Activity;
import android.util.Log;
import com.ironsource.C3040d4;
import com.unity3d.player.UnityPlayer;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnAdRequest;
import io.adn.sdk.publisher.AdnFullscreenAd;
import io.adn.sdk.publisher.AdnSdk;
import io.adn.unityplugin.internal.listeners.FullscreenAdListener;
import io.adn.unityplugin.internal.listeners.InitializationCallback;
import io.adn.unityplugin.publisher.AdnUnityCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UnityPluginManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\fJ\u0006\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\fJ\b\u0010#\u001a\u00020\fH\u0002J\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\fJ\b\u0010'\u001a\u00020\fH\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0015\u0010*\u001a\n ,*\u0004\u0018\u00010+0+H\u0002¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u0017H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lio/adn/unityplugin/internal/UnityPluginManager;", "", "<init>", "()V", "unityCallback", "Lio/adn/unityplugin/publisher/AdnUnityCallback;", "interstitialAd", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "rewardedAd", "logsEnabled", "", MobileAdsBridgeBase.initializeMethodName, "", "callback", "isInitialized", "setHasUserConsent", "hasUserConsent", "setDoNotSell", "doNotSell", "setVerboseLogging", "enabled", "setPublisherSignals", "json", "", "setPublisherSignal", C3040d4.h.W, "value", "setSdkParameter", "convertStringValue", "logSdkDebugInfo", "setTestMode", "isTesting", C3040d4.g.E, "isInterstitialReady", C3040d4.g.H, C3040d4.g.T, "loadRewardedAd", "isRewardedAdReady", "showRewardedAd", "destroyRewardedAd", "destroyFullscreenAd", "fullscreenAd", "currentActivity", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "()Landroid/app/Activity;", "logUninitializedAccessError", "callingMethod", "adn-unityplugin_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class UnityPluginManager {
    private AdnFullscreenAd interstitialAd;
    private boolean logsEnabled;
    private AdnFullscreenAd rewardedAd;
    private AdnUnityCallback unityCallback;

    public final void initialize(AdnUnityCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.unityCallback = callback;
        Activity currentActivity = currentActivity();
        Intrinsics.checkNotNullExpressionValue(currentActivity, "currentActivity(...)");
        AdnSdk.initialize(currentActivity, new InitializationCallback(callback));
    }

    public final boolean isInitialized() {
        return AdnSdk.isInitialized();
    }

    public final void setHasUserConsent(boolean hasUserConsent) {
        AdnSdk.setHasUserConsent(hasUserConsent);
    }

    public final void setDoNotSell(boolean doNotSell) {
        AdnSdk.setDoNotSell(doNotSell);
    }

    public final void setVerboseLogging(boolean enabled) {
        this.logsEnabled = enabled;
        AdnSdk.setVerbose(enabled);
    }

    public final void setPublisherSignals(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        AdnSdk.setPublisherSignals(json);
    }

    public final void setPublisherSignal(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        AdnSdk.setPublisherSignals((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to(key, convertStringValue(value))));
    }

    public final void setSdkParameter(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        AdnSdk.setSdkParameter(key, convertStringValue(value));
    }

    private final Object convertStringValue(String value) {
        if (Intrinsics.areEqual(value, "true")) {
            return true;
        }
        if (Intrinsics.areEqual(value, "false")) {
            return false;
        }
        return StringsKt.toIntOrNull(value) != null ? Integer.valueOf(Integer.parseInt(value)) : StringsKt.toFloatOrNull(value) != null ? Float.valueOf(Float.parseFloat(value)) : value;
    }

    public final String logSdkDebugInfo() {
        return AdnSdk.logSdkDebugInfo();
    }

    public final void setTestMode(boolean isTesting) {
        AdnSdk.setTestMode(isTesting);
    }

    public final void loadInterstitial() {
        if (!isInitialized()) {
            logUninitializedAccessError(C3040d4.g.E);
            return;
        }
        AdnFullscreenAd adnFullscreenAd = this.interstitialAd;
        if (adnFullscreenAd == null) {
            Activity currentActivity = currentActivity();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "currentActivity(...)");
            adnFullscreenAd = AdnSdk.getInterstitialAdInstance(currentActivity, new FullscreenAdListener(AdnAdPlacement.INTERSTITIAL, this.unityCallback, new UnityPluginManager$loadInterstitial$1(this)));
        }
        this.interstitialAd = adnFullscreenAd;
        if (adnFullscreenAd != null) {
            adnFullscreenAd.load(new AdnAdRequest.AdBidFetchRequest(AdnAdPlacement.INTERSTITIAL, null, 2, null));
        }
    }

    public final boolean isInterstitialReady() {
        AdnFullscreenAd adnFullscreenAd = this.interstitialAd;
        if (adnFullscreenAd != null) {
            return adnFullscreenAd.isReady();
        }
        return false;
    }

    public final void showInterstitial() {
        AdnFullscreenAd adnFullscreenAd = this.interstitialAd;
        if (adnFullscreenAd != null) {
            adnFullscreenAd.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyInterstitial() {
        AdnFullscreenAd adnFullscreenAd = this.interstitialAd;
        if (adnFullscreenAd != null) {
            destroyFullscreenAd(adnFullscreenAd);
        }
        this.interstitialAd = null;
    }

    public final void loadRewardedAd() {
        if (!isInitialized()) {
            logUninitializedAccessError("loadRewardedAd");
            return;
        }
        AdnFullscreenAd adnFullscreenAd = this.rewardedAd;
        if (adnFullscreenAd == null) {
            Activity currentActivity = currentActivity();
            Intrinsics.checkNotNullExpressionValue(currentActivity, "currentActivity(...)");
            adnFullscreenAd = AdnSdk.getInterstitialAdInstance(currentActivity, new FullscreenAdListener(AdnAdPlacement.REWARDED, this.unityCallback, new UnityPluginManager$loadRewardedAd$1(this)));
        }
        this.rewardedAd = adnFullscreenAd;
        if (adnFullscreenAd != null) {
            adnFullscreenAd.load(new AdnAdRequest.AdBidFetchRequest(AdnAdPlacement.REWARDED, null, 2, null));
        }
    }

    public final boolean isRewardedAdReady() {
        AdnFullscreenAd adnFullscreenAd = this.rewardedAd;
        if (adnFullscreenAd != null) {
            return adnFullscreenAd.isReady();
        }
        return false;
    }

    public final void showRewardedAd() {
        AdnFullscreenAd adnFullscreenAd = this.rewardedAd;
        if (adnFullscreenAd != null) {
            adnFullscreenAd.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyRewardedAd() {
        AdnFullscreenAd adnFullscreenAd = this.rewardedAd;
        if (adnFullscreenAd != null) {
            destroyFullscreenAd(adnFullscreenAd);
        }
        this.rewardedAd = null;
    }

    private final void destroyFullscreenAd(AdnFullscreenAd fullscreenAd) {
        fullscreenAd.setListener(null);
        fullscreenAd.destroy();
    }

    private final Activity currentActivity() {
        return UnityPlayer.currentActivity;
    }

    private final void logUninitializedAccessError(String callingMethod) {
        Log.e("AdnSdk", "[AdnUnityPlugin] ERROR: Failed to execute " + callingMethod + "() - please ensure the Adn Unity Plugin has been initialized");
    }
}
