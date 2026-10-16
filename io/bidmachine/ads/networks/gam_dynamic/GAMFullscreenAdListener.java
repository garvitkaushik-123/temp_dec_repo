package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;

/* loaded from: classes7.dex */
class GAMFullscreenAdListener<InternalAdType extends InternalFullscreenAd> extends GAMBaseAdListener<InternalAdType, UnifiedFullscreenAdCallback> implements InternalAdLoadListener<InternalAdType>, InternalFullscreenAdPresentListener {
    private final GAMFullscreenAd gamFullscreenAd;

    GAMFullscreenAdListener(UnifiedFullscreenAdCallback callback, GAMFullscreenAd gamFullscreenAd) {
        super(callback);
        this.gamFullscreenAd = gamFullscreenAd;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadListener
    public void onAdLoaded(InternalAdType internalAd) {
        this.gamFullscreenAd.internalFullscreenAd = internalAd;
        getCallback().onAdLoaded();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener
    public void onAdComplete() {
        getCallback().onAdFinished();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAdPresentListener
    public void onAdClosed() {
        getCallback().onAdClosed();
    }
}
