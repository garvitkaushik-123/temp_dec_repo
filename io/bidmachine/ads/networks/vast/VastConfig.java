package io.bidmachine.ads.networks.vast;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;

/* loaded from: classes7.dex */
public class VastConfig extends NetworkConfig {
    public VastConfig() {
        super(VastAdapter.KEY, null);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new VastAdapter();
    }
}
