package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public interface InternalLoadListener {
    void onAdLoadFailed(InternalAd internalAd, BMError bmError);

    void onAdLoaded(InternalAd internalAd, InternalAdLoadData internalAdLoadData);
}
