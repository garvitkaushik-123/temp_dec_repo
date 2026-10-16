package com.ironsource.mediationsdk.ads.nativead.internal;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public interface InternalNativeAdListener {
    void onNativeAdClicked(AdInfo adInfo);

    void onNativeAdImpression(AdInfo adInfo);

    void onNativeAdLoadFailed(IronSourceError ironSourceError);

    void onNativeAdLoaded(AdInfo adInfo, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder);
}
