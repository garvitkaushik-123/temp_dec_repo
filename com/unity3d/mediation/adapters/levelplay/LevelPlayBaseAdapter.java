package com.unity3d.mediation.adapters.levelplay;

import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdaptiveInterface;

/* loaded from: classes7.dex */
public abstract class LevelPlayBaseAdapter extends BaseAdapter implements AdapterAdaptiveInterface {
    private boolean mAdapterDebug;

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdaptiveInterface
    public int getAdaptiveHeight(int i) {
        return -1;
    }

    public boolean isAdaptersDebugEnabled() {
        return this.mAdapterDebug;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.BaseAdapter, com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface
    public void setAdapterDebug(boolean z) {
        this.mAdapterDebug = z;
    }
}
