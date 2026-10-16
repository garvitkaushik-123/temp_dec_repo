package io.bidmachine.ads.networks.gam;

import io.bidmachine.ads.networks.gam.InternalGAMFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;

/* loaded from: classes7.dex */
class GAMFullscreenAdListener<GAMAdType extends InternalGAMFullscreenAd> extends GAMBaseAdListener<GAMAdType, UnifiedFullscreenAdCallback> implements InternalGAMAdLoadListener<GAMAdType>, InternalGAMFullscreenAdPresentListener {
    GAMFullscreenAdListener(UnifiedFullscreenAdCallback callback) {
        super(callback);
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAdLoadListener
    public void onAdLoaded(GAMAdType internalGAMAd) {
        getCallback().onAdLoaded();
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMFullscreenAdPresentListener
    public void onAdComplete() {
        getCallback().onAdFinished();
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMFullscreenAdPresentListener
    public void onAdClosed() {
        getCallback().onAdClosed();
    }
}
