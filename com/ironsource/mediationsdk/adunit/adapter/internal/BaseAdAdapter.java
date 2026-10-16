package com.ironsource.mediationsdk.adunit.adapter.internal;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.c;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.UUID;

/* loaded from: classes6.dex */
public abstract class BaseAdAdapter<NetworkAdapter extends AdapterBaseInterface, Listener> {
    private final IronSource.AD_UNIT mAdUnit;
    protected final UUID mAdUnitObjectId;
    protected final NetworkSettings mNetworkSettings;

    public BaseAdAdapter(IronSource.AD_UNIT ad_unit, NetworkSettings networkSettings) {
        this(ad_unit, networkSettings, null);
    }

    public NetworkAdapter getNetworkAdapter() {
        NetworkAdapter networkadapter = (NetworkAdapter) c.b().b(this.mNetworkSettings, this.mAdUnit, this.mAdUnitObjectId);
        if (networkadapter != null) {
            return networkadapter;
        }
        return null;
    }

    protected NetworkSettings getNetworkSettings() {
        return this.mNetworkSettings;
    }

    public void releaseMemory() {
    }

    public BaseAdAdapter(IronSource.AD_UNIT ad_unit, NetworkSettings networkSettings, UUID uuid) {
        this.mAdUnit = ad_unit;
        this.mNetworkSettings = networkSettings;
        this.mAdUnitObjectId = uuid;
    }
}
