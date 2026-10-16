package io.bidmachine.ads.networks.gam_dynamic;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Struct;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.ExtraParamsManager;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.InitializationParams;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfigParams;
import io.bidmachine.NetworkInitializationCallback;
import io.bidmachine.ads.networks.gam_dynamic.versions.VersionWrapper;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.utils.BMError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class GAMAdapter extends HeaderBiddingAdapter {
    private static final String GAM_NETWORK_ERROR = "GAMNetwork is null";
    private static final String NETWORK_NAME = "GAMDynamic";
    GAMNetwork gamNetwork;

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitializationStatusCheckSupported() {
        return true;
    }

    GAMAdapter(String key) {
        this(key, "null", BuildConfig.ADAPTER_VERSION_NAME, 16);
    }

    protected GAMAdapter(String key, String version, String adapterVersion, int adapterMinDeviceApiVersion) {
        this(key, version, adapterVersion, adapterMinDeviceApiVersion, new AdsType[]{AdsType.Banner, AdsType.Interstitial, AdsType.Rewarded});
    }

    protected GAMAdapter(String key, String version, String adapterVersion, int adapterMinDeviceApiVersion, AdsType[] supportedTypes) {
        super(key, version, adapterVersion, adapterMinDeviceApiVersion, supportedTypes);
    }

    @Override // io.bidmachine.NetworkAdapter
    public String getNetworkSdkVersion() throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork != null) {
            return gAMNetwork.getVersion();
        }
        return null;
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedBannerAd createBanner() {
        if (this.gamNetwork != null) {
            return new GAMBannerAd(this.gamNetwork);
        }
        throw new IllegalArgumentException(GAM_NETWORK_ERROR);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createInterstitial() {
        if (this.gamNetwork != null) {
            return new GAMInterstitialAd(this.gamNetwork);
        }
        throw new IllegalArgumentException(GAM_NETWORK_ERROR);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createRewarded() {
        if (this.gamNetwork != null) {
            return new GAMRewardedAd(this.gamNetwork);
        }
        throw new IllegalArgumentException(GAM_NETWORK_ERROR);
    }

    public String getNetworkName() {
        return NETWORK_NAME;
    }

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitialized(ContextProvider contextProvider) throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        return gAMNetwork != null && gAMNetwork.isInitialized();
    }

    @Override // io.bidmachine.NetworkAdapter
    protected void onNetworkInitialize(ContextProvider contextProvider, InitializationParams initializationParams, NetworkConfigParams networkConfigParams, NetworkInitializationCallback callback) throws Throwable {
        String removeFromNetworkParams = networkConfigParams.removeFromNetworkParams("supported_versions_range");
        if (TextUtils.isEmpty(removeFromNetworkParams)) {
            callback.onFail("supported_versions_range not provided");
            return;
        }
        VersionWrapper findVersionWrapper = VersionManager.findVersionWrapper(removeFromNetworkParams);
        if (findVersionWrapper == null) {
            callback.onFail("Unsupported GAM version (VersionWrapper not found)");
            return;
        }
        Context applicationContext = contextProvider.getApplicationContext();
        if (!findVersionWrapper.isGAMPresent(applicationContext)) {
            callback.onFail("GAM is absent or used unsupported version");
            return;
        }
        String removeFromNetworkParams2 = networkConfigParams.removeFromNetworkParams("context");
        if (TextUtils.isEmpty(removeFromNetworkParams2)) {
            callback.onFail("context not provided");
            return;
        }
        Waterfall.Context parseWaterfallContext = parseWaterfallContext(removeFromNetworkParams2);
        if (parseWaterfallContext == null) {
            callback.onFail("context can't transform to model");
            return;
        }
        GAMNetworkImpl gAMNetworkImpl = new GAMNetworkImpl(applicationContext, new GAMNetworkParams(getKey(), getNetworkName()), parseWaterfallContext, findVersionWrapper);
        this.gamNetwork = gAMNetworkImpl;
        gAMNetworkImpl.init(applicationContext);
        this.gamNetwork.cache();
        callback.onSuccess();
    }

    @Override // io.bidmachine.HeaderBiddingAdapter
    protected void onCollectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork == null) {
            collectCallback.onCollectFail(BMError.adapter("GAM network is null"));
            return;
        }
        InternalAdData reserveMostExpensiveAd = gAMNetwork.reserveMostExpensiveAd(networkAdUnit, networkAdUnit.getAdsFormat());
        if (reserveMostExpensiveAd == null) {
            collectCallback.onCollectFail(BMError.adapter("Can't find idle ad"));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ad_unit_id", reserveMostExpensiveAd.getAdUnitId());
        hashMap.put("price", String.valueOf(reserveMostExpensiveAd.getPrice()));
        for (Map.Entry<String, Object> entry : reserveMostExpensiveAd.getCustomParamsMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null) {
                hashMap.put(key, String.valueOf(value));
            }
        }
        collectCallback.onCollectFinished(hashMap);
    }

    @Override // io.bidmachine.NetworkAdapter
    public void onLossAuction(NetworkAdUnit networkAdUnit) throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork != null) {
            gAMNetwork.unReserveAd(networkAdUnit);
        }
    }

    @Override // io.bidmachine.NetworkAdapter
    public void clearAuction(NetworkAdUnit networkAdUnit) throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork != null) {
            gAMNetwork.unReserveAd(networkAdUnit);
        }
    }

    Waterfall.Context parseWaterfallContext(String context) {
        try {
            return Waterfall.Context.parseFrom(Base64.decode(context, 0));
        } catch (Throwable unused) {
            return null;
        }
    }

    static class GAMNetworkParams extends NetworkParamsImpl {
        public GAMNetworkParams(String networkKey, String networkName) {
            super(networkKey, networkName);
        }

        @Override // io.bidmachine.ads.networks.gam_dynamic.NetworkParams
        public Struct getExt(Context context) {
            return ExtraParamsManager.get().getPrivateStruct(context);
        }
    }
}
