package io.bidmachine.ads.networks.adaptiverendering;

import android.content.Context;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.InitializationParams;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfigParams;
import io.bidmachine.NetworkInitializationCallback;
import io.bidmachine.iab.mraid.MraidNativeFeature;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedFullscreenAd;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdaptiveRenderingAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0014J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J(\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\tH\u0016¨\u0006!"}, d2 = {"Lio/bidmachine/ads/networks/adaptiverendering/AdaptiveRenderingAdapter;", "Lio/bidmachine/HeaderBiddingAdapter;", "()V", "createBanner", "Lio/bidmachine/unified/UnifiedBannerAd;", "createInterstitial", "Lio/bidmachine/unified/UnifiedFullscreenAd;", "createRewarded", "isNetworkInitializationStatusCheckSupported", "", "isNetworkInitialized", "contextProvider", "Lio/bidmachine/ContextProvider;", "onCollectHeaderBiddingParams", "", "adRequestParams", "Lio/bidmachine/unified/UnifiedAdRequestParams;", "networkAdUnit", "Lio/bidmachine/NetworkAdUnit;", "hbAdRequestParams", "Lio/bidmachine/HeaderBiddingAdRequestParams;", "collectCallback", "Lio/bidmachine/HeaderBiddingCollectParamsCallback;", "onNetworkInitialize", "initializationParams", "Lio/bidmachine/InitializationParams;", "networkConfigParams", "Lio/bidmachine/NetworkConfigParams;", "callback", "Lio/bidmachine/NetworkInitializationCallback;", "setLogging", "enabled", "Companion", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class AdaptiveRenderingAdapter extends HeaderBiddingAdapter {
    public static final String ADAPTER_SDK_VERSION_NAME = "3.4.0";
    public static final String ADAPTER_VERSION_NAME = "3.4.0.1";
    public static final String KEY = "adaptive_rendering";

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitializationStatusCheckSupported() {
        return false;
    }

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitialized(ContextProvider contextProvider) throws Throwable {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        return false;
    }

    public AdaptiveRenderingAdapter() {
        super(KEY, "3.4.0", "3.4.0.1", 1, new AdsType[]{AdsType.Banner, AdsType.Interstitial, AdsType.Rewarded});
    }

    @Override // io.bidmachine.NetworkAdapter
    public void setLogging(boolean enabled) throws Throwable {
        Rendering.setLoggingEnabled(enabled);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedBannerAd createBanner() {
        return new AdaptiveRenderingBannerAd();
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createInterstitial() {
        return new AdaptiveRenderingFullscreenAd();
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createRewarded() {
        return new AdaptiveRenderingFullscreenAd();
    }

    @Override // io.bidmachine.NetworkAdapter
    protected void onNetworkInitialize(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfigParams networkConfigParams, NetworkInitializationCallback callback) throws Throwable {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(initializationParams, "initializationParams");
        Intrinsics.checkNotNullParameter(networkConfigParams, "networkConfigParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Context applicationContext = contextProvider.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "contextProvider.getApplicationContext()");
        OMSDKSettings.initialize(applicationContext);
        Rendering.initialize(applicationContext);
        callback.onSuccess();
    }

    @Override // io.bidmachine.HeaderBiddingAdapter
    protected void onCollectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        Intrinsics.checkNotNullParameter(adRequestParams, "adRequestParams");
        Intrinsics.checkNotNullParameter(networkAdUnit, "networkAdUnit");
        Intrinsics.checkNotNullParameter(hbAdRequestParams, "hbAdRequestParams");
        Intrinsics.checkNotNullParameter(collectCallback, "collectCallback");
        HashMap hashMap = new HashMap();
        String[] supportedFeatures = MraidNativeFeature.getSupportedFeatures(contextProvider.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(supportedFeatures, "getSupportedFeatures(con….getApplicationContext())");
        hashMap.put(AdaptiveRenderingConfig.NATIVE_FEATURES_KEY, ArraysKt.joinToString$default(supportedFeatures, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        collectCallback.onCollectFinished(hashMap);
    }
}
