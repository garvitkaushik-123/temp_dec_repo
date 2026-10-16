package io.bidmachine.ads.networks.gam;

import io.bidmachine.ads.networks.gam.InternalGAMAd;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
abstract class GAMBaseAdListener<GAMAdType extends InternalGAMAd, UnifiedAdCallbackType extends UnifiedAdCallback> implements InternalGAMAdLoadListener<GAMAdType>, InternalGAMAdPresentListener {
    private final UnifiedAdCallbackType callback;

    GAMBaseAdListener(UnifiedAdCallbackType callback) {
        this.callback = callback;
    }

    UnifiedAdCallbackType getCallback() {
        return this.callback;
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAdLoadListener
    public void onAdLoadFailed(BMError bmError) {
        this.callback.onAdLoadFailed(bmError);
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAdPresentListener
    public void onAdShown() {
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAdPresentListener
    public void onAdShowFailed(BMError bmError) {
        this.callback.onAdShowFailed(bmError);
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAdPresentListener
    public void onAdClicked() {
        this.callback.onAdClicked();
    }

    @Override // io.bidmachine.ads.networks.gam.InternalGAMAdPresentListener
    public void onAdExpired() {
        this.callback.onAdExpired();
    }
}
