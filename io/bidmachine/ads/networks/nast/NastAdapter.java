package io.bidmachine.ads.networks.nast;

import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.InitializationParams;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfigParams;
import io.bidmachine.NetworkInitializationCallback;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedNativeAd;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class NastAdapter extends HeaderBiddingAdapter {
    public static final String ADAPTER_SDK_VERSION_NAME = "1.0";
    public static final String ADAPTER_VERSION_NAME = "3.4.0.1";
    public static final String KEY = "nast";

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitializationStatusCheckSupported() {
        return false;
    }

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitialized(ContextProvider contextProvider) throws Throwable {
        return false;
    }

    public NastAdapter() {
        super(KEY, "1.0", "3.4.0.1", 1, new AdsType[]{AdsType.Native});
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedNativeAd createNativeAd() {
        return new NastNative();
    }

    @Override // io.bidmachine.NetworkAdapter
    protected void onNetworkInitialize(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfigParams networkConfigParams, NetworkInitializationCallback callback) throws Throwable {
        callback.onSuccess();
    }

    @Override // io.bidmachine.HeaderBiddingAdapter
    protected void onCollectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable {
        collectCallback.onCollectFinished(new HashMap());
    }
}
