package io.bidmachine.ads.networks.gam;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.bidmachine.AdsFormat;
import io.bidmachine.AdsType;
import io.bidmachine.ContextProvider;
import io.bidmachine.HeaderBiddingAdRequestParams;
import io.bidmachine.HeaderBiddingAdapter;
import io.bidmachine.HeaderBiddingCollectParamsCallback;
import io.bidmachine.InitializationParams;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.NetworkConfigParams;
import io.bidmachine.NetworkInitializationCallback;
import io.bidmachine.ads.networks.gam.versions.VersionWrapper;
import io.bidmachine.core.Utils;
import io.bidmachine.unified.UnifiedAdRequestParams;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.utils.BMError;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class GAMAdapter extends HeaderBiddingAdapter {
    private static final int DEFAULT_EXPIRATION_TIME_SEC = 3600;
    private static final String GAM_NETWORK_ERROR = "GAMNetwork is null";
    private static final String NETWORK_NAME = "GAM";
    private GAMNetwork gamNetwork;

    @Override // io.bidmachine.NetworkAdapter
    protected boolean isNetworkInitializationStatusCheckSupported() {
        return true;
    }

    GAMAdapter() {
        this(BuildConfig.ADAPTER_NAME, "null", BuildConfig.ADAPTER_VERSION_NAME, 16);
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
            return new GAMBanner(this.gamNetwork);
        }
        throw new IllegalArgumentException(GAM_NETWORK_ERROR);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createInterstitial() {
        if (this.gamNetwork != null) {
            return new GAMInterstitial(this.gamNetwork);
        }
        throw new IllegalArgumentException(GAM_NETWORK_ERROR);
    }

    @Override // io.bidmachine.NetworkAdapter
    public UnifiedFullscreenAd createRewarded() {
        if (this.gamNetwork != null) {
            return new GAMRewarded(this.gamNetwork);
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
        String removeFromNetworkParams2 = networkConfigParams.removeFromNetworkParams("waterfall_configurations");
        if (TextUtils.isEmpty(removeFromNetworkParams2)) {
            callback.onFail("waterfall_configurations not provided");
            return;
        }
        Map<AdsFormat, GAMTypeConfig> gAMTypeConfigMap = toGAMTypeConfigMap(removeFromNetworkParams2);
        if (gAMTypeConfigMap == null || gAMTypeConfigMap.isEmpty()) {
            callback.onFail("waterfall_configurations is empty");
            return;
        }
        GAMNetwork gAMNetwork = new GAMNetwork(applicationContext, findVersionWrapper, getNetworkName(), gAMTypeConfigMap, networkConfigParams.removeFromNetworkParams("request_agent"), TimeUnit.SECONDS.toMillis(Utils.parseIntOrDefault(networkConfigParams.removeFromNetworkParams("expiration_time"), DEFAULT_EXPIRATION_TIME_SEC)), Boolean.parseBoolean(networkConfigParams.removeFromNetworkParams("override_callbacks")));
        this.gamNetwork = gAMNetwork;
        gAMNetwork.init(applicationContext);
        this.gamNetwork.cache();
        callback.onSuccess();
    }

    @Override // io.bidmachine.HeaderBiddingAdapter
    protected void onCollectHeaderBiddingParams(ContextProvider contextProvider, UnifiedAdRequestParams adRequestParams, NetworkAdUnit networkAdUnit, HeaderBiddingAdRequestParams hbAdRequestParams, HeaderBiddingCollectParamsCallback collectCallback) throws Throwable {
        String mediationParameter = networkAdUnit.getMediationParameter("ad_unit_id");
        if (TextUtils.isEmpty(mediationParameter)) {
            collectCallback.onCollectFail(BMError.adapterGetsParameter("ad_unit_id"));
            return;
        }
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork == null) {
            collectCallback.onCollectFail(BMError.adapter("GAM network is null"));
            return;
        }
        GAMUnitData reserveMostExpensiveGAMAd = gAMNetwork.reserveMostExpensiveGAMAd(networkAdUnit, mediationParameter);
        this.gamNetwork.cache(adRequestParams.getAdRequestParameters().getAdsFormat());
        if (reserveMostExpensiveGAMAd == null) {
            collectCallback.onCollectFail(BMError.adapter("Can't find idle ad"));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ad_unit_id", reserveMostExpensiveGAMAd.getAdUnitId());
        hashMap.put(FirebaseAnalytics.Param.SCORE, String.valueOf(reserveMostExpensiveGAMAd.getScore()));
        hashMap.put("price", String.valueOf(reserveMostExpensiveGAMAd.getPrice()));
        collectCallback.onCollectFinished(hashMap);
    }

    @Override // io.bidmachine.NetworkAdapter
    public void onLossAuction(NetworkAdUnit networkAdUnit) throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork != null) {
            gAMNetwork.unReserveGAMAd(networkAdUnit);
        }
    }

    @Override // io.bidmachine.NetworkAdapter
    public void clearAuction(NetworkAdUnit networkAdUnit) throws Throwable {
        GAMNetwork gAMNetwork = this.gamNetwork;
        if (gAMNetwork != null) {
            gAMNetwork.unReserveGAMAd(networkAdUnit);
        }
    }

    private Map<AdsFormat, GAMTypeConfig> toGAMTypeConfigMap(String json) {
        GAMTypeConfig create;
        HashMap hashMap = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(json);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && (create = GAMTypeConfigFactory.create(optJSONObject)) != null) {
                    hashMap.put(create.getAdsFormat(), create);
                }
            }
            return hashMap;
        } catch (Throwable unused) {
            return null;
        }
    }
}
