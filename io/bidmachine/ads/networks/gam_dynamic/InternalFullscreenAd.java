package io.bidmachine.ads.networks.gam_dynamic;

import android.app.Activity;
import io.bidmachine.AdsFormat;
import io.bidmachine.ads.networks.gam_dynamic.InternalAd;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.protobuf.Waterfall;
import io.bidmachine.utils.BMError;

/* loaded from: classes7.dex */
public abstract class InternalFullscreenAd extends InternalAd {
    protected abstract void showAd(Activity activity, final InternalFullscreenAdPresentListener showListener) throws Throwable;

    public InternalFullscreenAd(NetworkParams networkParams, TaskExecutor taskExecutor, AdsFormat adsFormat, Waterfall.Configuration.AdUnit adUnit, InternalAdListener internalAdListener) {
        super(networkParams, taskExecutor, adsFormat, adUnit, internalAdListener);
    }

    public final void show(final Activity activity, final InternalFullscreenAdPresentListener showListener) {
        Utils.onUiThread(new Runnable() { // from class: io.bidmachine.ads.networks.gam_dynamic.InternalFullscreenAd$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InternalFullscreenAd.this.m9671x61fb8266(activity, showListener);
            }
        });
    }

    /* renamed from: lambda$show$0$io-bidmachine-ads-networks-gam_dynamic-InternalFullscreenAd, reason: not valid java name */
    /* synthetic */ void m9671x61fb8266(Activity activity, InternalFullscreenAdPresentListener internalFullscreenAdPresentListener) {
        try {
            setStatus(InternalAd.Status.Showing);
            showAd(activity, internalFullscreenAdPresentListener);
        } catch (Throwable th) {
            Logger.w(th);
            internalFullscreenAdPresentListener.onAdShowFailed(BMError.throwable("Exception showing InternalAd object", th));
        }
    }
}
