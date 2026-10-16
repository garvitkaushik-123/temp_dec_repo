package io.bidmachine.ads.networks.gam;

import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public interface InternalLoadListener {
    void onAdLoadFailed(InternalGAMAd internalGAMAd, BMError bmError);

    void onAdLoaded(InternalGAMAd internalGAMAd);
}
