package com.ironsource.mediationsdk.adunit.adapter.listener;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;

/* loaded from: classes6.dex */
public interface NativeAdListener extends AdapterAdListener {
    void onAdLoadSuccess(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder);
}
