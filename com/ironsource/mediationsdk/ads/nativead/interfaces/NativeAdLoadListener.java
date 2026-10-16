package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public interface NativeAdLoadListener {
    void onAdLoadFailed(LevelPlayNativeAd levelPlayNativeAd, IronSourceError ironSourceError);

    void onAdLoaded(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo);
}
