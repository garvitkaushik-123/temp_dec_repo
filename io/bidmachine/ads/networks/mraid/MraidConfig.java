package io.bidmachine.ads.networks.mraid;

import io.bidmachine.NetworkAdapter;
import io.bidmachine.NetworkConfig;

/* loaded from: classes7.dex */
public class MraidConfig extends NetworkConfig {
    public MraidConfig() {
        super("mraid", null);
    }

    @Override // io.bidmachine.NetworkConfig
    protected NetworkAdapter createNetworkAdapter() {
        return new MraidAdapter();
    }
}
