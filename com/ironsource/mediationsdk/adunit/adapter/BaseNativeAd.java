package com.ironsource.mediationsdk.adunit.adapter;

import com.ironsource.V9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.BaseAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.NativeAdProperties;
import com.ironsource.mediationsdk.model.NetworkSettings;

/* loaded from: classes6.dex */
public abstract class BaseNativeAd<NetworkAdapter extends BaseAdapter> extends BaseAdAdapter<NetworkAdapter, NativeAdListener> implements AdapterNativeAdInterface<NativeAdListener> {
    public BaseNativeAd(NetworkSettings networkSettings) {
        super(IronSource.AD_UNIT.NATIVE_AD, networkSettings);
    }

    public NativeAdProperties getNativeAdProperties(AdData adData) {
        return new NativeAdProperties(V9.a(adData.getConfiguration()));
    }
}
