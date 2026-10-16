package io.bidmachine.ads.networks.gam;

import android.app.Activity;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam.InternalGAMAd;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public abstract class InternalGAMFullscreenAd extends InternalGAMAd {
    protected abstract void showAd(Activity activity, final InternalGAMFullscreenAdPresentListener showListener) throws Throwable;

    public InternalGAMFullscreenAd(GAMLoader gamLoader, AdsFormat adsFormat, GAMUnitData gamUnitData) {
        super(gamLoader, adsFormat, gamUnitData);
    }

    public final void show(final Activity activity, final InternalGAMFullscreenAdPresentListener showListener) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam.InternalGAMFullscreenAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InternalGAMFullscreenAd.this.m9658x5f55a489(activity, showListener);
            }
        });
    }

    /* renamed from: lambda$show$0$io-bidmachine-ads-networks-gam-InternalGAMFullscreenAd, reason: not valid java name */
    /* synthetic */ void m9658x5f55a489(Activity activity, InternalGAMFullscreenAdPresentListener internalGAMFullscreenAdPresentListener) {
        try {
            setStatus(InternalGAMAd.Status.Showing);
            showAd(activity, internalGAMFullscreenAdPresentListener);
        } catch (Throwable th) {
            Logger.w(th);
            internalGAMFullscreenAdPresentListener.onAdShowFailed(BMError.throwable("Exception showing InternalGAM object", th));
        }
    }
}
