package io.adn.sdk.internal.domain.management;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.di.DependencyInjectorKt;
import io.adn.sdk.internal.di.modules.DataSourceModuleKt;
import io.adn.sdk.internal.domain.handler.BidTokenHandler;
import io.adn.sdk.internal.domain.handler.NoOpAdHandler;
import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnBidTokenCallback;
import io.adn.sdk.publisher.AdnFullscreenAd;
import io.adn.sdk.publisher.AdnFullscreenAdListener;
import io.adn.sdk.publisher.AdnInitializationCallback;
import io.adn.sdk.publisher.AdnMediationType;
import io.adn.sdk.publisher.AdnNativeAd;
import io.adn.sdk.publisher.AdnNativeAdListener;
import io.adn.sdk.publisher.inappbrowser.AdnInAppBrowserLauncher;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkManager.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0005J\u001a\u0010\u0018\u001a\u00020\u000b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J \u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0011J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u0011J\u000e\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0011J\u000e\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lio/adn/sdk/internal/domain/management/SdkManager;", "", "<init>", "()V", "TAG", "", "externalData", "Lio/adn/sdk/internal/domain/repository/ExternalDataSource;", "sdkInitializer", "Lio/adn/sdk/internal/domain/management/SdkInitializer;", MobileAdsBridgeBase.initializeMethodName, "", "context", "Landroid/content/Context;", "initializationCallback", "Lio/adn/sdk/publisher/AdnInitializationCallback;", "isInitialized", "", "sdkVersion", "getBidToken", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "callback", "Lio/adn/sdk/publisher/AdnBidTokenCallback;", "setPublisherSignals", "jsonString", "params", "", "logSdkDebugInfo", "getFullscreenAdInstance", "Lio/adn/sdk/publisher/AdnFullscreenAd;", "adPlacement", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", "getNativeAdInstance", "Lio/adn/sdk/publisher/AdnNativeAd;", "Lio/adn/sdk/publisher/AdnNativeAdListener;", "inAppBrowserLauncher", "Lio/adn/sdk/publisher/inappbrowser/AdnInAppBrowserLauncher;", "setIsVerbose", "isVerbose", "setTestMode", "testing", "setAdsMuted", "muted", "setHasUserConsent", "hasUserConsent", "setDoNotSell", "doNotSell", "setMediationType", "mediationType", "Lio/adn/sdk/publisher/AdnMediationType;", "setSdkParameter", C3040d4.h.W, "value", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class SdkManager {
    private static final String TAG = "AdnSdkManager";
    public static final SdkManager INSTANCE = new SdkManager();
    private static final ExternalDataSource externalData = DataSourceModuleKt.externalData();
    private static final SdkInitializer sdkInitializer = new SdkInitializer();
    public static final int $stable = 8;

    private SdkManager() {
    }

    public final void initialize(Context context, AdnInitializationCallback initializationCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationCallback, "initializationCallback");
        sdkInitializer.initialize(context, initializationCallback);
    }

    public final boolean isInitialized() {
        return sdkInitializer.isInitialized();
    }

    public final String sdkVersion() {
        return "4.25.2";
    }

    public final void getBidToken(AdnAdPlacement placement, AdnBidTokenCallback callback) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new BidTokenHandler(placement, callback, sdkInitializer, null, 8, null).invoke();
    }

    public final void setPublisherSignals(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        externalData.setPublisherSignalsJson(jsonString);
    }

    public final void setPublisherSignals(Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        externalData.setPublisherSignals(params);
    }

    public final String logSdkDebugInfo() {
        return externalData.logExternalData();
    }

    public final AdnFullscreenAd getFullscreenAdInstance(AdnAdPlacement adPlacement, Activity activity, AdnFullscreenAdListener listener) {
        NoOpAdHandler noOpAdHandler;
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isInitialized()) {
            noOpAdHandler = DependencyInjectorKt.sdkComponents().createFullscreenAd(activity, adPlacement);
        } else {
            noOpAdHandler = new NoOpAdHandler();
        }
        noOpAdHandler.setListener(listener);
        return noOpAdHandler;
    }

    public final AdnNativeAd getNativeAdInstance(Activity activity, AdnNativeAdListener listener, AdnInAppBrowserLauncher inAppBrowserLauncher) {
        NoOpAdHandler noOpAdHandler;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isInitialized()) {
            noOpAdHandler = DependencyInjectorKt.sdkComponents().createNativeAd(activity);
        } else {
            noOpAdHandler = new NoOpAdHandler();
        }
        noOpAdHandler.setListener(listener);
        noOpAdHandler.setInAppBrowserLauncher(inAppBrowserLauncher);
        return noOpAdHandler;
    }

    public final void setIsVerbose(boolean isVerbose) {
        Logger.INSTANCE.setVerbose(isVerbose);
    }

    public final void setTestMode(boolean testing) {
        externalData.setTestMode(testing);
    }

    public final void setAdsMuted(boolean muted) {
        externalData.setAdsMuted(muted);
    }

    public final void setHasUserConsent(boolean hasUserConsent) {
        externalData.getPrivacyInfo().setHasUserConsent(hasUserConsent);
    }

    public final void setDoNotSell(boolean doNotSell) {
        externalData.getPrivacyInfo().setDoNotSell(doNotSell);
    }

    public final void setMediationType(AdnMediationType mediationType) {
        Intrinsics.checkNotNullParameter(mediationType, "mediationType");
        externalData.setMediationType(mediationType);
    }

    public final void setSdkParameter(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        externalData.setSdkParameter(key, value);
    }
}
