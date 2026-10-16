package com.ironsource.mediationsdk.adapter;

import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class AbstractBannerAdapter<AdNetworkAdapter> extends AbstractAdUnitAdapter<AdNetworkAdapter> implements BannerAdapterInterface {
    public AbstractBannerAdapter(AdNetworkAdapter adnetworkadapter) {
        super(adnetworkadapter);
    }

    public void collectBannerBiddingData(JSONObject config, JSONObject jSONObject, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Map<String, Object> bannerBiddingData = getBannerBiddingData(config, jSONObject);
        if (bannerBiddingData != null) {
            biddingDataCallback.onSuccess(bannerBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyBanner(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public int getAdaptiveHeight(int i) {
        return -1;
    }

    public Map<String, Object> getBannerBiddingData(JSONObject config, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(config, "config");
        return null;
    }

    public LoadWhileShowSupportState getBannerLoadWhileShowSupportState(JSONObject jSONObject) {
        return LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public void initBannerForBidding(String str, String str2, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void initBanners(String str, String str2, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void loadBanner(JSONObject config, JSONObject jSONObject, IronSourceBannerLayout banner, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void loadBannerForBidding(JSONObject config, JSONObject jSONObject, String str, IronSourceBannerLayout banner, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(banner, "banner");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForDemandOnlyForBidding(JSONObject config, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewBound(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void onBannerViewWillBind(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
    }
}
