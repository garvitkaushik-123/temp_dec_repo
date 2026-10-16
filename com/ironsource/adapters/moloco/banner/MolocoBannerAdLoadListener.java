package com.ironsource.adapters.moloco.banner;

import android.widget.FrameLayout;
import com.ironsource.C3355vf;
import com.ironsource.adapters.moloco.MolocoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MolocoBannerAdLoadListener.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ironsource/adapters/moloco/banner/MolocoBannerAdLoadListener;", "Lcom/moloco/sdk/publisher/AdLoad$Listener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "mBannerAdView", "Lcom/moloco/sdk/publisher/Banner;", "(Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;Landroid/widget/FrameLayout$LayoutParams;Lcom/moloco/sdk/publisher/Banner;)V", C3355vf.b, "", "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdLoadSuccess", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoBannerAdLoadListener implements AdLoad.Listener {
    private final Banner mBannerAdView;
    private final FrameLayout.LayoutParams mLayoutParams;
    private final BannerSmashListener mListener;

    public MolocoBannerAdLoadListener(BannerSmashListener mListener, FrameLayout.LayoutParams mLayoutParams, Banner banner) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mLayoutParams, "mLayoutParams");
        this.mListener = mListener;
        this.mLayoutParams = mLayoutParams;
        this.mBannerAdView = banner;
    }

    @Override // com.moloco.sdk.publisher.AdLoad.Listener
    public void onAdLoadSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdLoaded(this.mBannerAdView, this.mLayoutParams);
    }

    @Override // com.moloco.sdk.publisher.AdLoad.Listener
    public void onAdLoadFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + MolocoAdError.ErrorType.AD_LOAD_FAILED.getErrorCode() + ", errorMessage = " + molocoAdError.getDescription());
        this.mListener.onBannerAdLoadFailed(MolocoAdapter.INSTANCE.getLoadErrorAndCheckNoFill(molocoAdError, 606));
    }
}
