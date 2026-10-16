package io.adn.sdk.publisher;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.adn.sdk.internal.domain.management.SdkManager;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdnSdk.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000bH\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000bH\u0007J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\rH\u0007J\u001c\u0010 \u001a\u00020\u00052\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010#H\u0007J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\u0018\u0010*\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J$\u0010+\u001a\u00020,2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/H\u0007J\n\u00100\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0001H\u0007¨\u00064"}, d2 = {"Lio/adn/sdk/publisher/AdnSdk;", "", "<init>", "()V", MobileAdsBridgeBase.initializeMethodName, "", "context", "Landroid/content/Context;", "initializationCallback", "Lio/adn/sdk/publisher/AdnInitializationCallback;", "isInitialized", "", "getVersion", "", "setAdsMuted", "muted", "setHasUserConsent", "hasUserConsent", "setDoNotSell", "doNotSell", "setMediationType", "mediationType", "Lio/adn/sdk/publisher/AdnMediationType;", "setVerbose", "isVerbose", "setTestMode", "isTesting", "getBidToken", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "callback", "Lio/adn/sdk/publisher/AdnBidTokenCallback;", "setPublisherSignals", "jsonString", "signals", "", "getInterstitialAdInstance", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "getRewardedAdInstance", "getNativeAdInstance", "Lio/adn/sdk/publisher/AdnNativeAd;", "Lio/adn/sdk/publisher/AdnNativeAdListener;", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "logSdkDebugInfo", "setSdkParameter", C3040d4.h.W, "value", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdnSdk {
    public static final int $stable = 0;
    public static final AdnSdk INSTANCE = new AdnSdk();

    private AdnSdk() {
    }

    @JvmStatic
    public static final void initialize(Context context, AdnInitializationCallback initializationCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationCallback, "initializationCallback");
        SdkManager.INSTANCE.initialize(context, initializationCallback);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return SdkManager.INSTANCE.isInitialized();
    }

    @JvmStatic
    public static final String getVersion() {
        return SdkManager.INSTANCE.sdkVersion();
    }

    @JvmStatic
    public static final void setAdsMuted(boolean muted) {
        SdkManager.INSTANCE.setAdsMuted(muted);
    }

    @JvmStatic
    public static final void setHasUserConsent(boolean hasUserConsent) {
        SdkManager.INSTANCE.setHasUserConsent(hasUserConsent);
    }

    @JvmStatic
    public static final void setDoNotSell(boolean doNotSell) {
        SdkManager.INSTANCE.setDoNotSell(doNotSell);
    }

    @JvmStatic
    public static final void setMediationType(AdnMediationType mediationType) {
        Intrinsics.checkNotNullParameter(mediationType, "mediationType");
        SdkManager.INSTANCE.setMediationType(mediationType);
    }

    @JvmStatic
    public static final void setVerbose(boolean isVerbose) {
        SdkManager.INSTANCE.setIsVerbose(isVerbose);
    }

    @JvmStatic
    public static final void setTestMode(boolean isTesting) {
        SdkManager.INSTANCE.setTestMode(isTesting);
    }

    @JvmStatic
    public static final void getBidToken(AdnAdPlacement adPlacement, AdnBidTokenCallback callback) {
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SdkManager.INSTANCE.getBidToken(adPlacement, callback);
    }

    @JvmStatic
    public static final void setPublisherSignals(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        SdkManager.INSTANCE.setPublisherSignals(jsonString);
    }

    @JvmStatic
    public static final void setPublisherSignals(Map<String, ? extends Object> signals) {
        Intrinsics.checkNotNullParameter(signals, "signals");
        SdkManager.INSTANCE.setPublisherSignals(signals);
    }

    @JvmStatic
    public static final AdnFullscreenAd getInterstitialAdInstance(Activity activity, AdnFullscreenAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SdkManager.INSTANCE.getFullscreenAdInstance(AdnAdPlacement.INTERSTITIAL, activity, listener);
    }

    @JvmStatic
    public static final AdnFullscreenAd getRewardedAdInstance(Activity activity, AdnFullscreenAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SdkManager.INSTANCE.getFullscreenAdInstance(AdnAdPlacement.REWARDED, activity, listener);
    }

    public static /* synthetic */ AdnNativeAd getNativeAdInstance$default(Activity activity, AdnNativeAdListener adnNativeAdListener, AdnInAppBrowserLauncher adnInAppBrowserLauncher, int i, Object obj) {
        if ((i & 4) != 0) {
            adnInAppBrowserLauncher = null;
        }
        return getNativeAdInstance(activity, adnNativeAdListener, adnInAppBrowserLauncher);
    }

    @JvmStatic
    public static final AdnNativeAd getNativeAdInstance(Activity activity, AdnNativeAdListener listener, AdnInAppBrowserLauncher inAppBrowserLauncher) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return SdkManager.INSTANCE.getNativeAdInstance(activity, listener, inAppBrowserLauncher);
    }

    @JvmStatic
    public static final String logSdkDebugInfo() {
        return SdkManager.INSTANCE.logSdkDebugInfo();
    }

    @JvmStatic
    public static final void setSdkParameter(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        SdkManager.INSTANCE.setSdkParameter(key, value);
    }
}
