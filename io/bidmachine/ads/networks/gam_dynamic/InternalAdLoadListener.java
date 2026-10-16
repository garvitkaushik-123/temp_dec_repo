package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ads.networks.gam_dynamic.InternalAd;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
interface InternalAdLoadListener<InternalAdType extends InternalAd> {
    void onAdLoadFailed(BMError bmError);

    void onAdLoaded(InternalAdType internalAd);
}
