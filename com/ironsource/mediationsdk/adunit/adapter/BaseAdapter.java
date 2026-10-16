package com.ironsource.mediationsdk.adunit.adapter;

import com.ironsource.mediationsdk.AdapterNetworkData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class BaseAdapter implements AdapterBaseInterface, AdapterMetaDataInterface, AdapterConsentInterface, AdapterDebugInterface, AdapterSettingsInterface, AdapterNetworkDataInterface {
    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface
    @Deprecated
    public LoadWhileShowSupportState getBannerLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface
    @Deprecated
    public LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return LoadWhileShowSupportState.NONE;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return true;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface
    public void setAdapterDebug(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface
    public void setConsent(boolean z) {
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface
    @Deprecated
    public void setMetaData(String str, List<String> list) {
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNetworkDataInterface
    public void setNetworkData(AdapterNetworkData adapterNetworkData) {
    }
}
