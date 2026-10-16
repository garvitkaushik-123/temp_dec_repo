package com.ironsource.adapters.vungle.banner;

import android.content.Context;
import android.widget.FrameLayout;
import com.ironsource.C3355vf;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.BannerAdListener;
import com.vungle.ads.BaseAd;
import com.vungle.ads.VungleBannerView;
import com.vungle.ads.VungleError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VungleBannerAdListener.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ironsource/adapters/vungle/banner/VungleBannerAdListener;", "Lcom/vungle/ads/BannerAdListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mPlacementId", "", "bannerView", "Lcom/vungle/ads/VungleBannerView;", "(Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;Ljava/lang/String;Lcom/vungle/ads/VungleBannerView;)V", C3355vf.f, "", "baseAd", "Lcom/vungle/ads/BaseAd;", "onAdEnd", "onAdFailedToLoad", "adError", "Lcom/vungle/ads/VungleError;", "onAdFailedToPlay", "onAdImpression", C3355vf.k, C3355vf.j, "onAdStart", "vungleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VungleBannerAdListener implements BannerAdListener {
    private final VungleBannerView bannerView;
    private final BannerSmashListener mListener;
    private final String mPlacementId;

    public VungleBannerAdListener(BannerSmashListener mListener, String mPlacementId, VungleBannerView bannerView) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mPlacementId, "mPlacementId");
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        this.mListener = mListener;
        this.mPlacementId = mPlacementId;
        this.bannerView = bannerView;
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        this.mListener.onBannerAdLoaded(this.bannerView, new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, this.bannerView.getAdViewSize().getWidth()), AdapterUtils.dpToPixels(applicationContext, this.bannerView.getAdViewSize().getHeight()), 17));
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(BaseAd baseAd, VungleError adError) {
        IronSourceError buildLoadFailedError;
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        Intrinsics.checkNotNullParameter(adError, "adError");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + ", errorCode = " + adError.getCode() + ", errorMessage = " + adError.getMessage());
        String str = adError.getErrorMessage() + "( " + adError.getCode() + " )";
        if (adError.getCode() == 10001) {
            buildLoadFailedError = new IronSourceError(606, str);
        } else {
            buildLoadFailedError = ErrorBuilder.buildLoadFailedError(str);
        }
        this.mListener.onBannerAdLoadFailed(buildLoadFailedError);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        this.mListener.onBannerAdShown();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToPlay(BaseAd baseAd, VungleError adError) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        Intrinsics.checkNotNullParameter(adError, "adError");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + ", errorCode = " + adError.getCode() + ", errorMessage = " + adError.getErrorMessage());
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdClicked(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        this.mListener.onBannerAdClicked();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        this.mListener.onBannerAdLeftApplication();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(BaseAd baseAd) {
        Intrinsics.checkNotNullParameter(baseAd, "baseAd");
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
    }
}
