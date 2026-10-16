package com.ironsource.adapters.moloco.rewardedvideo;

import com.ironsource.C3355vf;
import com.ironsource.adapters.moloco.MolocoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MolocoRewardedVideoAdLoadListener.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ironsource/adapters/moloco/rewardedvideo/MolocoRewardedVideoAdLoadListener;", "Lcom/moloco/sdk/publisher/AdLoad$Listener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/moloco/rewardedvideo/MolocoRewardedVideoAdapter;", "(Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;Ljava/lang/ref/WeakReference;)V", C3355vf.b, "", "molocoAdError", "Lcom/moloco/sdk/publisher/MolocoAdError;", "onAdLoadSuccess", "molocoAd", "Lcom/moloco/sdk/publisher/MolocoAd;", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoRewardedVideoAdLoadListener implements AdLoad.Listener {
    private final WeakReference<MolocoRewardedVideoAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;

    public MolocoRewardedVideoAdLoadListener(RewardedVideoSmashListener mListener, WeakReference<MolocoRewardedVideoAdapter> mAdapter) {
        Intrinsics.checkNotNullParameter(mListener, "mListener");
        Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
        this.mListener = mListener;
        this.mAdapter = mAdapter;
    }

    @Override // com.moloco.sdk.publisher.AdLoad.Listener
    public void onAdLoadSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAvailabilityChanged(true);
    }

    @Override // com.moloco.sdk.publisher.AdLoad.Listener
    public void onAdLoadFailed(MolocoAdError molocoAdError) {
        Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + MolocoAdError.ErrorType.AD_LOAD_FAILED.getErrorCode() + ", errorMessage = " + molocoAdError.getDescription());
        this.mListener.onRewardedVideoAvailabilityChanged(false);
        this.mListener.onRewardedVideoLoadFailed(MolocoAdapter.INSTANCE.getLoadErrorAndCheckNoFill(molocoAdError, 1058));
        MolocoRewardedVideoAdapter molocoRewardedVideoAdapter = this.mAdapter.get();
        if (molocoRewardedVideoAdapter != null) {
            molocoRewardedVideoAdapter.destroyRewardedVideoAd$molocoadapter_release();
        }
    }
}
