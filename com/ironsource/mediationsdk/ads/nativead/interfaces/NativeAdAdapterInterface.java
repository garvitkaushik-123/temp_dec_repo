package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.sdk.AdUnitAdapterInterface;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public interface NativeAdAdapterInterface extends AdUnitAdapterInterface {
    void collectNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback);

    void destroyNativeAd(JSONObject jSONObject);

    Map<String, Object> getNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2);

    void initNativeAdForBidding(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener);

    void initNativeAds(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener);

    void loadNativeAd(JSONObject jSONObject, JSONObject jSONObject2, NativeAdSmashListener nativeAdSmashListener);

    void loadNativeAdForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, NativeAdSmashListener nativeAdSmashListener);
}
