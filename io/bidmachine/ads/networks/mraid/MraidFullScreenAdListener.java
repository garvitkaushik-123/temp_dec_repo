package io.bidmachine.ads.networks.mraid;

import android.content.Context;
import io.bidmachine.Executable;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.mraid.MraidInterstitial;
import io.bidmachine.iab.mraid.MraidInterstitialListener;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.measurer.MraidOMSDKAdMeasurer;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.UrlHandler;
import io.bidmachine.rendering.view.PrivacySheetDialog;
import io.bidmachine.unified.UnifiedFullscreenAdCallback;
import io.bidmachine.util.SafeExecutable;
import io.bidmachine.utils.IabUtils;

/* loaded from: classes7.dex */
class MraidFullScreenAdListener implements MraidInterstitialListener {
    private final Context applicationContext;
    private final UnifiedFullscreenAdCallback callback;
    private final MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer;

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onPlayVideo(MraidInterstitial mraidInterstitial, String s) {
    }

    MraidFullScreenAdListener(Context applicationContext, UnifiedFullscreenAdCallback callback, MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer) {
        this.applicationContext = applicationContext;
        this.callback = callback;
        this.mraidOMSDKAdMeasurer = mraidOMSDKAdMeasurer;
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onLoaded(MraidInterstitial mraidInterstitial) {
        this.callback.onAdLoaded();
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onLoadFailed(MraidInterstitial mraidInterstitial, IabError iabError) {
        this.callback.onAdLoadFailed(IabUtils.mapError(iabError));
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onShown(MraidInterstitial mraidInterstitial) {
        this.callback.onAdShown();
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onShowFailed(MraidInterstitial mraidInterstitial, IabError iabError) {
        this.callback.onAdShowFailed(IabUtils.mapError(iabError));
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onExpired(MraidInterstitial mraidInterstitial, IabError iabError) {
        this.callback.onAdExpired();
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onOpenUrl(MraidInterstitial mraidInterstitial, String url, final IabClickCallback iabClickCallback) {
        this.callback.onAdClicked();
        UrlHandler.openUrl(this.applicationContext, url, new SafeExecutable() { // from class: io.bidmachine.ads.networks.mraid.MraidFullScreenAdListener$$ExternalSyntheticLambda0
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                IabClickCallback.this.clickHandled();
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onOpenPrivacySheet(MraidInterstitial mraidInterstitial, final PrivacySheetParams privacySheetParams) {
        Context peekContext = mraidInterstitial.peekContext();
        if (peekContext == null) {
            peekContext = this.applicationContext;
        }
        Utils.ifNotNull(Utils.findDialogContext(peekContext), new Executable() { // from class: io.bidmachine.ads.networks.mraid.MraidFullScreenAdListener$$ExternalSyntheticLambda2
            @Override // io.bidmachine.Executable
            public final void execute(Object obj) {
                PrivacySheetDialog.show((Context) obj, PrivacySheetParams.this);
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onCalendarEvent(MraidInterstitial mraidInterstitial, String url, final IabClickCallback iabClickCallback) {
        this.callback.onAdClicked();
        UrlHandler.openCalendar(this.applicationContext, url, new SafeExecutable() { // from class: io.bidmachine.ads.networks.mraid.MraidFullScreenAdListener$$ExternalSyntheticLambda3
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                IabClickCallback.this.clickHandled();
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onStorePicture(MraidInterstitial mraidInterstitial, String url, final IabClickCallback iabClickCallback) {
        this.callback.onAdClicked();
        UrlHandler.storePicture(this.applicationContext, url, new SafeExecutable() { // from class: io.bidmachine.ads.networks.mraid.MraidFullScreenAdListener$$ExternalSyntheticLambda1
            @Override // io.bidmachine.util.SafeExecutable
            public final void onExecute(Object obj) {
                IabClickCallback.this.clickHandled();
            }
        });
    }

    @Override // io.bidmachine.iab.mraid.MraidInterstitialListener
    public void onClose(MraidInterstitial mraidInterstitial) {
        if (mraidInterstitial.isShown()) {
            MraidOMSDKAdMeasurer mraidOMSDKAdMeasurer = this.mraidOMSDKAdMeasurer;
            if (mraidOMSDKAdMeasurer != null) {
                mraidOMSDKAdMeasurer.destroy();
            }
            this.callback.onAdFinished();
        }
        this.callback.onAdClosed();
    }
}
