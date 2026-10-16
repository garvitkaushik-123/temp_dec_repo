package com.ironsource.adapters.moloco.banner;

import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MolocoBannerAdShowListener.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ironsource/adapters/moloco/banner/MolocoBannerAdShowListener;", "Lcom/moloco/sdk/publisher/BannerAdShowListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "(Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;)V", C3355vf.f, "", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "onAdHidden", C3355vf.e, "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdShowSuccess", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoBannerAdShowListener implements BannerAdShowListener {
    private final BannerSmashListener mListener;

    public MolocoBannerAdShowListener(BannerSmashListener mListener) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        this.mListener = mListener;
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdShown();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to show, errorCode = " + MolocoAdError.ErrorType.AD_SHOW_ERROR + ", errorMessage = " + molocoAdError.getDescription());
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdClicked();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
    }
}
