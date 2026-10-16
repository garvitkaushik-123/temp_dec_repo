package com.ironsource.adapters.moloco.interstitial;

import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.moloco.sdk.publisher.InterstitialAdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MolocoInterstitialAdShowListener.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ironsource/adapters/moloco/interstitial/MolocoInterstitialAdShowListener;", "Lcom/moloco/sdk/publisher/InterstitialAdShowListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/moloco/interstitial/MolocoInterstitialAdapter;", "(Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;Ljava/lang/ref/WeakReference;)V", C3355vf.f, "", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "onAdHidden", C3355vf.e, "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdShowSuccess", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoInterstitialAdShowListener implements InterstitialAdShowListener {
    private final WeakReference<MolocoInterstitialAdapter> mAdapter;
    private final InterstitialSmashListener mListener;

    public MolocoInterstitialAdShowListener(InterstitialSmashListener mListener, WeakReference<MolocoInterstitialAdapter> mAdapter) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        this.mListener = mListener;
        this.mAdapter = mAdapter;
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to show, errorCode = " + MolocoAdError.ErrorType.AD_SHOW_ERROR + ", errorMessage = " + molocoAdError.getDescription());
        this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", molocoAdError.getDescription()));
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdClicked();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdClosed();
        MolocoInterstitialAdapter molocoInterstitialAdapter = this.mAdapter.get();
        if (molocoInterstitialAdapter != null) {
            molocoInterstitialAdapter.destroyInterstitialAd$molocoadapter_release();
        }
    }
}
