package io.bidmachine.ads.networks.gam;

import android.app.Activity;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.RendererConfiguration;
import io.bidmachine.unified.UnifiedFullscreenAd;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.unified.UnifiedFullscreenAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
class GAMInterstitial extends UnifiedFullscreenAd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private InternalGAMInterstitialAd gamInterstitialAd;
    private final GAMNetwork gamNetwork;
    private Listener listener;

    protected GAMInterstitial(GAMNetwork gamNetwork) {
        this.gamNetwork = gamNetwork;
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, UnifiedFullscreenAdCallback callback, UnifiedFullscreenAdRequestParams requestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        if (new GAMParams(unifiedMediationParams).isValid(callback)) {
            Listener listener = new Listener(callback, this);
            this.listener = listener;
            this.gamNetwork.loadInterstitial(networkAdUnit, listener);
        }
    }

    @Override // io.bidmachine.unified.UnifiedFullscreenAd
    public void show(ContextProvider contextProvider, UnifiedFullscreenAdCallback callback, RendererConfiguration rendererConfiguration) throws Throwable {
        Activity activity = contextProvider.getActivity();
        if (activity == null) {
            callback.onAdShowFailed(BMError.internal("Activity is null"));
            return;
        }
        InternalGAMInterstitialAd internalGAMInterstitialAd = this.gamInterstitialAd;
        if (internalGAMInterstitialAd == null) {
            callback.onAdShowFailed(BMError.internal("InternalGAM interstitial object is null"));
            return;
        }
        if (internalGAMInterstitialAd.isExpired()) {
            callback.onAdShowFailed(BMError.internal("InternalGAM interstitial object is expired"));
            return;
        }
        if (!this.gamInterstitialAd.isLoaded()) {
            callback.onAdShowFailed(BMError.internal("InternalGAM interstitial object not loaded"));
            return;
        }
        Listener listener = this.listener;
        if (listener == null) {
            callback.onAdShowFailed(BMError.internal("InternalGAM interstitial listener is null"));
        } else {
            this.gamInterstitialAd.show(activity, listener);
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onShown() {
        super.onShown();
        InternalGAMInterstitialAd internalGAMInterstitialAd = this.gamInterstitialAd;
        if (internalGAMInterstitialAd != null) {
            internalGAMInterstitialAd.onAdShown();
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        this.listener = null;
        InternalGAMInterstitialAd internalGAMInterstitialAd = this.gamInterstitialAd;
        if (internalGAMInterstitialAd != null) {
            internalGAMInterstitialAd.destroy();
            this.gamInterstitialAd = null;
        }
    }

    private static final class Listener extends GAMFullscreenAdListener<InternalGAMInterstitialAd> implements InternalGAMInterstitialAdListener {
        private final GAMInterstitial gamInterstitial;

        private Listener(UnifiedFullscreenAdCallback callback, GAMInterstitial gamInterstitial) {
            super(callback);
            this.gamInterstitial = gamInterstitial;
        }

        @Override // io.bidmachine.ads.networks.gam.GAMFullscreenAdListener
        public void onAdLoaded(InternalGAMInterstitialAd gamInterstitialAd) {
            this.gamInterstitial.gamInterstitialAd = gamInterstitialAd;
            super.onAdLoaded((Listener) gamInterstitialAd);
        }
    }
}
