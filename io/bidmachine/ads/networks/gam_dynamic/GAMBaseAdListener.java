package io.bidmachine.ads.networks.gam_dynamic;

import io.bidmachine.ads.networks.gam_dynamic.InternalAd;
import io.bidmachine.unified.UnifiedAdCallback;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
abstract class GAMBaseAdListener<InternalAdType extends InternalAd, UnifiedAdCallbackType extends UnifiedAdCallback> implements InternalAdLoadListener<InternalAdType>, InternalAdPresentListener {
    private final UnifiedAdCallbackType callback;

    GAMBaseAdListener(UnifiedAdCallbackType callback) {
        this.callback = callback;
    }

    UnifiedAdCallbackType getCallback() {
        return this.callback;
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdLoadListener
    public void onAdLoadFailed(BMError bmError) {
        this.callback.onAdLoadFailed(bmError);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdPresentListener
    public void onAdShown() {
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdPresentListener
    public void onAdShowFailed(BMError bmError) {
        this.callback.onAdShowFailed(bmError);
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdPresentListener
    public void onAdClicked() {
        this.callback.onAdClicked();
    }

    @Override // io.bidmachine.ads.networks.gam_dynamic.InternalAdPresentListener
    public void onAdExpired() {
        this.callback.onAdExpired();
    }
}
