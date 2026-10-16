package io.bidmachine;

import android.os.Build;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public abstract class HeaderBiddingAdapter extends NetworkAdapter {
    protected abstract void onCollectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable;

    protected HeaderBiddingAdapter(String key, String version, String adapterVersion, int adapterMinDeviceApiVersion, AdsType[] supportedTypes) {
        super(key, version, adapterVersion, adapterMinDeviceApiVersion, supportedTypes);
    }

    public final void collectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable {
        int adapterMinDeviceApiVersion = getAdapterMinDeviceApiVersion();
        if (Build.VERSION.SDK_INT < adapterMinDeviceApiVersion) {
            collectCallback.onCollectFail(BMError.adapter("minSdkVersion is " + adapterMinDeviceApiVersion));
        } else if (!isInitialized(contextProvider)) {
            collectCallback.onCollectFail(BMError.adapterNotInitialized());
        } else {
            onCollectHeaderBiddingParams(contextProvider, adRequestParams, networkAdUnit, hbAdRequestParams, collectCallback);
        }
    }
}
