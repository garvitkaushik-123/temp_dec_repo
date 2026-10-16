package com.ironsource.adapters.moloco.rewardedvideo;

import com.ironsource.C3355vf;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MolocoRewardedVideoAdShowListener.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ironsource/adapters/moloco/rewardedvideo/MolocoRewardedVideoAdShowListener;", "Lcom/moloco/sdk/publisher/RewardedInterstitialAdShowListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/moloco/rewardedvideo/MolocoRewardedVideoAdapter;", "(Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;Ljava/lang/ref/WeakReference;)V", "hasEarnedReward", "", C3355vf.f, "", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "onAdHidden", C3355vf.e, "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdShowSuccess", "onRewardedVideoCompleted", "onRewardedVideoStarted", "onUserRewarded", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoRewardedVideoAdShowListener implements RewardedInterstitialAdShowListener {
    private boolean hasEarnedReward;
    private final WeakReference<MolocoRewardedVideoAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;

    public MolocoRewardedVideoAdShowListener(RewardedVideoSmashListener mListener, WeakReference<MolocoRewardedVideoAdapter> mAdapter) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        this.mListener = mListener;
        this.mAdapter = mAdapter;
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdOpened();
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoStarted(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdStarted();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdShowFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to show, errorCode = " + MolocoAdError.ErrorType.AD_SHOW_ERROR + ", errorMessage = " + molocoAdError.getDescription());
        this.mListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, molocoAdError.getDescription()));
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdClicked();
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onUserRewarded(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.hasEarnedReward = true;
    }

    @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
    public void onRewardedVideoCompleted(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdEnded();
    }

    @Override // com.moloco.sdk.publisher.AdShowListener
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        if (this.hasEarnedReward) {
            this.mListener.onRewardedVideoAdRewarded();
            this.hasEarnedReward = false;
        }
        this.mListener.onRewardedVideoAdClosed();
        MolocoRewardedVideoAdapter molocoRewardedVideoAdapter = this.mAdapter.get();
        if (molocoRewardedVideoAdapter != null) {
            molocoRewardedVideoAdapter.destroyRewardedVideoAd$molocoadapter_release();
        }
    }
}
