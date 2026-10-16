package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class AbstractNativeAdAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements NativeAdAdapterInterface {
    public AbstractNativeAdAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectNativeAdBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> nativeAdBiddingData = getNativeAdBiddingData(config, jSONObject);
        if (nativeAdBiddingData != null) {
            biddingDataCallback.onSuccess(nativeAdBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyNativeAd(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public Map<String, Object> getNativeAdBiddingData(JSONObject config, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(config, "config");
        return null;
    }

    public final NativeAdProperties getNativeAdProperties(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new NativeAdProperties(config);
    }

    public void initNativeAdForBidding(String str, String str2, JSONObject config, NativeAdSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void initNativeAds(String str, String str2, JSONObject config, NativeAdSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void loadNativeAd(JSONObject config, JSONObject jSONObject, NativeAdSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void loadNativeAdForBidding(JSONObject config, JSONObject jSONObject, String str, NativeAdSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
