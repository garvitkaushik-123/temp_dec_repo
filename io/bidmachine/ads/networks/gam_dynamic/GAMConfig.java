package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;
import java.util.Map;

/* loaded from: classes7.dex */
public class GAMConfig extends NetworkConfig {
    static final String KEY_AD_UNIT_ID = "ad_unit_id";
    static final String KEY_CONTEXT = "context";
    static final String KEY_PRICE = "price";
    static final String KEY_SUPPORTED_VERSIONS_RANGE = "supported_versions_range";

    public GAMConfig(Map<String, String> networkConfig) {
        super(BuildConfig.ADAPTER_NAME, networkConfig);
    }

    public GAMConfig(String networkKey, Map<String, String> networkParams) {
        super(networkKey, networkParams);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new GAMAdapter(getNetworkKey());
    }
}
