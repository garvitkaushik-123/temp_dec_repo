package io.bidmachine.ads.networks.gam_dynamic;

/* loaded from: classes7.dex */
public abstract class NetworkParamsImpl implements NetworkParams {
    private final String networkKey;
    private final String networkName;

    public NetworkParamsImpl(String networkKey, String networkName) {
        this.networkKey = networkKey;
        this.networkName = networkName;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.NetworkParams
    public String getNetworkKey() {
        return this.networkKey;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.NetworkParams
    public String getNetworkName() {
        return this.networkName;
    }
}
