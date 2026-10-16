package com.ironsource.adapters.bidmachine.rewardedvideo;

import com.ironsource.C3355vf;
import com.ironsource.adapters.bidmachine.BidMachineAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.bidmachine.rewarded.RewardedAd;
import io.bidmachine.rewarded.RewardedListener;
import io.bidmachine.utils.BMError;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BidMachineRewardedVideoAdListener.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ironsource/adapters/bidmachine/rewardedvideo/BidMachineRewardedVideoAdListener;", "Lio/bidmachine/rewarded/RewardedListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/bidmachine/rewardedvideo/BidMachineRewardedVideoAdapter;", "(Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;Ljava/lang/ref/WeakReference;)V", C3355vf.f, "", "ad", "Lio/bidmachine/rewarded/RewardedAd;", C3355vf.g, "finished", "", "onAdExpired", "onAdImpression", C3355vf.b, "error", "Lio/bidmachine/utils/BMError;", C3355vf.j, C3355vf.i, C3355vf.e, "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineRewardedVideoAdListener implements RewardedListener {
    private final WeakReference<BidMachineRewardedVideoAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;

    public BidMachineRewardedVideoAdListener(RewardedVideoSmashListener mListener, WeakReference<BidMachineRewardedVideoAdapter> mAdapter) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        this.mListener = mListener;
        this.mAdapter = mAdapter;
    }

    @Override // io.bidmachine.AdListener
    public void onAdLoaded(RewardedAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        BidMachineRewardedVideoAdapter bidMachineRewardedVideoAdapter = this.mAdapter.get();
        if (bidMachineRewardedVideoAdapter != null) {
            bidMachineRewardedVideoAdapter.setRewardedVideoAd$bidmachineadapter_release(ad);
        }
        BidMachineRewardedVideoAdapter bidMachineRewardedVideoAdapter2 = this.mAdapter.get();
        if (bidMachineRewardedVideoAdapter2 != null) {
            bidMachineRewardedVideoAdapter2.setRewardedVideoAdAvailability$bidmachineadapter_release(true);
        }
        this.mListener.onRewardedVideoAvailabilityChanged(true);
    }

    @Override // io.bidmachine.AdListener
    public void onAdLoadFailed(RewardedAd ad, BMError error) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
        BidMachineRewardedVideoAdapter bidMachineRewardedVideoAdapter = this.mAdapter.get();
        if (bidMachineRewardedVideoAdapter != null) {
            bidMachineRewardedVideoAdapter.setRewardedVideoAdAvailability$bidmachineadapter_release(false);
        }
        this.mListener.onRewardedVideoLoadFailed(BidMachineAdapter.INSTANCE.getLoadErrorAndCheckNoFill(error, 1058));
        BidMachineRewardedVideoAdapter bidMachineRewardedVideoAdapter2 = this.mAdapter.get();
        if (bidMachineRewardedVideoAdapter2 != null) {
            bidMachineRewardedVideoAdapter2.destroyRewardedVideoAd$bidmachineadapter_release();
        }
    }

    @Override // io.bidmachine.AdListener
    public void onAdImpression(RewardedAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdOpened();
        this.mListener.onRewardedVideoAdStarted();
    }

    @Override // io.bidmachine.AdListener
    public void onAdShowFailed(RewardedAd ad, BMError error) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to show, errorCode = " + error.getCode() + " , errorMessage = " + error.getMessage());
        IronSourceError buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, error.getMessage());
        Intrinsics.checkNotNullExpressionValue(buildShowFailedError, "buildShowFailedError(\n  …  error.message\n        )");
        this.mListener.onRewardedVideoAdShowFailed(buildShowFailedError);
    }

    @Override // io.bidmachine.AdListener
    public void onAdClicked(RewardedAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdClicked();
    }

    @Override // io.bidmachine.AdRewardedListener
    public void onAdRewarded(RewardedAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdRewarded();
    }

    @Override // io.bidmachine.AdFullScreenListener
    public void onAdClosed(RewardedAd ad, boolean finished) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdEnded();
        this.mListener.onRewardedVideoAdClosed();
        BidMachineRewardedVideoAdapter bidMachineRewardedVideoAdapter = this.mAdapter.get();
        if (bidMachineRewardedVideoAdapter != null) {
            bidMachineRewardedVideoAdapter.destroyRewardedVideoAd$bidmachineadapter_release();
        }
    }

    @Override // io.bidmachine.AdListener
    public void onAdExpired(RewardedAd ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoLoadFailed(new IronSourceError(IronSourceError.ERROR_RV_EXPIRED_ADS, "ads are expired"));
    }
}
