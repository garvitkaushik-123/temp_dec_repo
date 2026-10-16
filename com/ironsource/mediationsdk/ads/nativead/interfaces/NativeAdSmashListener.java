package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public interface NativeAdSmashListener {
    void onNativeAdClicked();

    void onNativeAdInitFailed(IronSourceError ironSourceError);

    void onNativeAdInitSuccess();

    void onNativeAdLoadFailed(IronSourceError ironSourceError);

    void onNativeAdLoaded(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder);

    void onNativeAdShown();
}
