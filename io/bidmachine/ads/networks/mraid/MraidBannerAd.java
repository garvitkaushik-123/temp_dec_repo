package io.bidmachine.ads.networks.mraid;

import android.content.Context;
import io.bidmachine.ContextProvider;
import io.bidmachine.NetworkAdUnit;
import io.bidmachine.RendererConfiguration;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.core.VisibilitySource;
import io.bidmachine.iab.CacheControl;
import io.bidmachine.iab.mraid.MraidView;
import io.bidmachine.measurer.MraidOMSDKAdMeasurer;
import io.bidmachine.unified.UnifiedBannerAd;
import io.bidmachine.unified.UnifiedBannerAdCallback;
import io.bidmachine.unified.UnifiedBannerAdRequestParams;
import io.bidmachine.unified.UnifiedMediationParams;
import io.bidmachine.utils.BMError;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
class MraidBannerAd extends UnifiedBannerAd {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AtomicBoolean isPrepareToShowExecuted = new AtomicBoolean(false);
    private MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer;
    MraidView mraidView;

    MraidBannerAd() {
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void load(ContextProvider contextProvider, final UnifiedBannerAdCallback callback, UnifiedBannerAdRequestParams requestParams, UnifiedMediationParams unifiedMediationParams, NetworkAdUnit networkAdUnit) throws Throwable {
        VisibilitySource visibilitySource;
        String str;
        final MraidParams mraidParams = new MraidParams(unifiedMediationParams);
        if (mraidParams.isValid(callback)) {
            if (mraidParams.cacheControl == CacheControl.FullLoad) {
                visibilitySource = VisibilitySource.BidMachine;
            } else {
                visibilitySource = VisibilitySource.All;
            }
            callback.setVisibilitySource(visibilitySource);
            final Context applicationContext = contextProvider.getApplicationContext();
            if (mraidParams.omsdkEnabled) {
                MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = new MraidOMSDKAdMeasurer(true);
                this.mraidOMSDKAdMeasurer = mraidOMSDKAdMeasurer;
                str = mraidOMSDKAdMeasurer.prepareCreativeForMeasure(mraidParams.creativeAdm);
            } else {
                str = mraidParams.creativeAdm;
            }
            final String str2 = str;
            Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.mraid.MraidBannerAd.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MraidBannerAd.this.mraidView = new MraidView.Builder().setCacheControl(mraidParams.cacheControl).setPlaceholderTimeoutSec(mraidParams.placeholderTimeoutSec).setListener(new MraidBannerAdListener(callback)).setAdMeasurer(MraidBannerAd.this.mraidOMSDKAdMeasurer).build(applicationContext);
                        MraidBannerAd.this.mraidView.load(str2);
                    } catch (Throwable th) {
                        Logger.w(th);
                        callback.onAdLoadFailed(BMError.throwable("Exception loading MRAID banner object", th));
                    }
                }
            });
        }
    }

    @Override // io.bidmachine.unified.UnifiedViewAd
    public void prepareToShow(RendererConfiguration rendererConfiguration) throws Throwable {
        MraidView mraidView;
        super.prepareToShow(rendererConfiguration);
        if (this.isPrepareToShowExecuted.compareAndSet(false, true) && (mraidView = this.mraidView) != null) {
            mraidView.show(null);
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onShown() {
        super.onShown();
        MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = this.mraidOMSDKAdMeasurer;
        if (mraidOMSDKAdMeasurer != null) {
            mraidOMSDKAdMeasurer.trackShown();
        }
    }

    @Override // io.bidmachine.unified.UnifiedAd
    public void onDestroy() {
        MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = this.mraidOMSDKAdMeasurer;
        if (mraidOMSDKAdMeasurer != null) {
            mraidOMSDKAdMeasurer.destroy(new Runnable() { // from class: io.bidmachine.ads.networks.mraid.MraidBannerAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MraidBannerAd.this.destroyMraidView();
                    } catch (Throwable th) {
                        Logger.w(th);
                    }
                }
            });
            this.mraidOMSDKAdMeasurer = null;
        } else {
            destroyMraidView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyMraidView() {
        MraidView mraidView = this.mraidView;
        if (mraidView != null) {
            mraidView.destroy();
            this.mraidView = null;
        }
    }
}
