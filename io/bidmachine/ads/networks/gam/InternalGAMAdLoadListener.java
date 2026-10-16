package io.bidmachine.ads.networks.gam;

import io.bidmachine.ads.networks.gam.InternalGAMAd;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
interface InternalGAMAdLoadListener<GAMAdType extends InternalGAMAd> {
    void onAdLoadFailed(BMError bmError);

    void onAdLoaded(GAMAdType internalGAMAd);
}
