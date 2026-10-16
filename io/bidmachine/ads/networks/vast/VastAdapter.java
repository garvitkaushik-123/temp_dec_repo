package io.bidmachine.ads.networks.vast;

import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.InitializationParams;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfigParams;
import io.bidmachine.NetworkInitializationCallback;
import io.bidmachine.iab.utils.Logger;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VideoType;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedFullscreenAd;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class VastAdapter extends HeaderBiddingAdapter {
    public static final String ADAPTER_SDK_VERSION_NAME = "3.4.0";
    public static final String ADAPTER_VERSION_NAME = "3.4.0.1";
    public static final String KEY = "vast";

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitializationStatusCheckSupported() {
        return false;
    }

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitialized(ContextProvider contextProvider) throws Throwable {
        return false;
    }

    public VastAdapter() {
        super(KEY, "3.4.0", "3.4.0.1", 1, new AdsType[]{AdsType.Interstitial, AdsType.Rewarded});
    }

    @Override // io.bidmachine.NetworkAdapter
    public void setLogging(boolean enabled) throws Throwable {
        Logger.LogLevel logLevel;
        if (enabled) {
            logLevel = Logger.LogLevel.debug;
        } else {
            logLevel = Logger.LogLevel.none;
        }
        VastLog.setLoggingLevel(logLevel);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createInterstitial() {
        return new VastFullScreenAd(VideoType.NonRewarded);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createRewarded() {
        return new VastFullScreenAd(VideoType.Rewarded);
    }

    @Override // io.bidmachine.NetworkAdapter
    protected void onNetworkInitialize(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfigParams networkConfigParams, NetworkInitializationCallback callback) throws Throwable {
        OMSDKSettings.initialize(contextProvider.getContext());
        callback.onSuccess();
    }

    @Override // io.bidmachine.HeaderBiddingAdapter
    protected void onCollectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable {
        collectCallback.onCollectFinished(new HashMap());
    }
}
