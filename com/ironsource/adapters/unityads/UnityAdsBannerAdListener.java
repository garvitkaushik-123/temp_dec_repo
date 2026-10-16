package com.ironsource.adapters.unityads;

import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnityAdsBannerAdListener.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ironsource/adapters/unityads/UnityAdsBannerAdListener;", "Lcom/unity3d/services/banners/BannerView$IListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/unityads/UnityAdsAdapter;", "mPlacementId", "", "(Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "onBannerClick", "", "bannerView", "Lcom/unity3d/services/banners/BannerView;", "onBannerFailedToLoad", "bannerErrorInfo", "Lcom/unity3d/services/banners/BannerErrorInfo;", "onBannerLeftApplication", "onBannerLoaded", "onBannerShown", "bannerAdView", "unityadsadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UnityAdsBannerAdListener implements BannerView.IListener {
    private final WeakReference<UnityAdsAdapter> mAdapter;
    private final BannerSmashListener mListener;
    private final String mPlacementId;

    public UnityAdsBannerAdListener(BannerSmashListener bannerSmashListener, WeakReference<UnityAdsAdapter> weakReference, String mPlacementId) {
        Intrinsics.checkNotNullParameter(mPlacementId, "mPlacementId");
        this.mListener = bannerSmashListener;
        this.mAdapter = weakReference;
        this.mPlacementId = mPlacementId;
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLoaded(BannerView bannerView) {
        BannerSmashListener bannerSmashListener;
        FrameLayout.LayoutParams layoutParams;
        UnityAdsAdapter unityAdsAdapter;
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        if (bannerView == null || (bannerSmashListener = this.mListener) == null) {
            return;
        }
        BannerView bannerView2 = bannerView;
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || (unityAdsAdapter = weakReference.get()) == null) {
            layoutParams = null;
        } else {
            UnityBannerSize size = bannerView.getSize();
            Intrinsics.checkNotNullExpressionValue(size, "bannerView.size");
            layoutParams = unityAdsAdapter.createLayoutParams(size);
        }
        bannerSmashListener.onBannerAdLoaded(bannerView2, layoutParams);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        IronSourceError buildLoadFailedError;
        UnityAdsAdapter unityAdsAdapter;
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        String str = ((weakReference == null || (unityAdsAdapter = weakReference.get()) == null) ? null : unityAdsAdapter.getProviderName()) + " banner, onAdLoadFailed placementId " + this.mPlacementId + " with error: " + (bannerErrorInfo != null ? bannerErrorInfo.errorMessage : null);
        if ((bannerErrorInfo != null ? bannerErrorInfo.errorCode : null) == BannerErrorCode.NO_FILL) {
            buildLoadFailedError = new IronSourceError(606, str);
        } else {
            buildLoadFailedError = ErrorBuilder.buildLoadFailedError(str);
        }
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + buildLoadFailedError);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoadFailed(buildLoadFailedError);
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerShown(BannerView bannerAdView) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerClick(BannerView bannerView) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLeftApplication(BannerView bannerView) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }
}
