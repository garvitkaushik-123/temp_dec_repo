package io.bidmachine;

import java.util.Map;
import java.util.UUID;

/* loaded from: classes7.dex */
public class NetworkAdUnit {
    private final AdsFormat adsFormat;
    private final String id = UUID.randomUUID().toString();
    private final Map<String, String> mediationConfig;
    private final NetworkAdapter networkAdapter;

    public NetworkAdUnit(NetworkAdapter networkAdapter, AdsFormat adsFormat, Map<String, String> mediationConfig) {
        this.networkAdapter = networkAdapter;
        this.adsFormat = adsFormat;
        this.mediationConfig = mediationConfig;
    }

    public String getId() {
        return this.id;
    }

    public NetworkAdapter getNetworkAdapter() {
        return this.networkAdapter;
    }

    public AdsFormat getAdsFormat() {
        return this.adsFormat;
    }

    public Map<String, String> getMediationConfig() {
        return this.mediationConfig;
    }

    public String getNetworkKey() {
        return this.networkAdapter.getKey();
    }

    public String getMediationParameter(String key) {
        return this.mediationConfig.get(key);
    }

    void onWinAuction() throws Throwable {
        getNetworkAdapter().onWinAuction(this);
    }

    void onLossAuction() throws Throwable {
        getNetworkAdapter().onLossAuction(this);
    }

    void clearAuction() throws Throwable {
        getNetworkAdapter().clearAuction(this);
    }
}
