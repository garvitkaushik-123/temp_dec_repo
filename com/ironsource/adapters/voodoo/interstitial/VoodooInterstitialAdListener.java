package com.ironsource.adapters.voodoo.interstitial;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3355vf;
import com.ironsource.N6;
import com.ironsource.adapters.voodoo.VoodooAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import io.adn.sdk.publisher.AdnAdError;
import io.adn.sdk.publisher.AdnAdInfo;
import io.adn.sdk.publisher.AdnFullscreenAdListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoodooInterstitialAdListener.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ironsource/adapters/voodoo/interstitial/VoodooInterstitialAdListener;", "Lio/adn/sdk/publisher/AdnFullscreenAdListener;", N6.F1, "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/voodoo/interstitial/VoodooInterstitialAdapter;", "placementId", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/lang/String;Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;)V", C3355vf.j, "", "adInfo", "Lio/adn/sdk/publisher/AdnAdInfo;", C3355vf.b, "error", "Lio/adn/sdk/publisher/AdnAdError;", "onAdShown", C3355vf.e, "onAdImpression", C3355vf.f, C3355vf.g, "adn-ironsource-adapter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoodooInterstitialAdListener implements AdnFullscreenAdListener {
    private final WeakReference<VoodooInterstitialAdapter> adapter;
    private final InterstitialSmashListener listener;
    private final String placementId;

    public VoodooInterstitialAdListener(WeakReference<VoodooInterstitialAdapter> adapter, String placementId, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.adapter = adapter;
        this.placementId = placementId;
        this.listener = listener;
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdRewarded(AdnAdInfo adnAdInfo) {
        AdnFullscreenAdListener.DefaultImpls.onAdRewarded(this, adnAdInfo);
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdLoaded(AdnAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        IronLog.ADAPTER_CALLBACK.verbose("Ad loaded placementId = " + this.placementId);
        VoodooInterstitialAdapter voodooInterstitialAdapter = this.adapter.get();
        if (voodooInterstitialAdapter != null) {
            voodooInterstitialAdapter.setInterstitialAdAvailability$adn_ironsource_adapter_release(this.placementId, true);
        }
        this.listener.onInterstitialAdReady();
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdLoadFailed(AdnAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load placementId = " + this.placementId + ", errorCode = " + error.getErrorCode() + " , errorMessage = " + error.getErrorMessage());
        VoodooInterstitialAdapter voodooInterstitialAdapter = this.adapter.get();
        if (voodooInterstitialAdapter != null) {
            voodooInterstitialAdapter.setInterstitialAdAvailability$adn_ironsource_adapter_release(this.placementId, false);
        }
        this.listener.onInterstitialAdLoadFailed(VoodooAdapter.INSTANCE.getLoadAdError(error));
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdShown(AdnAdInfo adInfo) {
        IronLog.ADAPTER_CALLBACK.verbose("Ad shown placementId = " + this.placementId);
        this.listener.onInterstitialAdShowSucceeded();
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdShowFailed(AdnAdInfo adInfo, AdnAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.placementId + ", errorCode = " + error.getErrorCode() + " , errorMessage = " + error.getErrorMessage());
        IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", error.getErrorMessage());
        Intrinsics.checkNotNullExpressionValue(buildShowFailedError, "buildShowFailedError(...)");
        this.listener.onInterstitialAdShowFailed(buildShowFailedError);
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdImpression(AdnAdInfo adInfo) {
        IronLog.ADAPTER_CALLBACK.verbose("Ad impression placementId = " + this.placementId);
        this.listener.onInterstitialAdOpened();
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdClicked(AdnAdInfo adInfo) {
        IronLog.ADAPTER_CALLBACK.verbose("Ad clicked placementId = " + this.placementId);
        this.listener.onInterstitialAdClicked();
    }

    @Override // io.adn.sdk.publisher.AdnFullscreenAdListener
    public void onAdClosed(AdnAdInfo adInfo) {
        IronLog.ADAPTER_CALLBACK.verbose("Ad closed placementId = " + this.placementId);
        this.listener.onInterstitialAdClosed();
    }
}
