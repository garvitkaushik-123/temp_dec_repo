package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class AbstractInterstitialAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements InterstitialAdapterInterface {
    public AbstractInterstitialAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectInterstitialBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> interstitialBiddingData = getInterstitialBiddingData(config, jSONObject);
        if (interstitialBiddingData != null) {
            biddingDataCallback.onSuccess(interstitialBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void disposeInterstitialAd(JSONObject jSONObject) {
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject config, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(config, "config");
        return null;
    }

    public void initInterstitial(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public boolean isInterstitialReady(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return false;
    }

    public void loadInterstitial(JSONObject config, JSONObject jSONObject, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void loadInterstitialForBidding(JSONObject config, JSONObject jSONObject, String str, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
