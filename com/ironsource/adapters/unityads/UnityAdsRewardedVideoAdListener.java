package com.ironsource.adapters.unityads;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnityAdsRewardedVideoAdListener.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\u000e\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0018\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ironsource/adapters/unityads/UnityAdsRewardedVideoAdListener;", "Lcom/unity3d/ads/IUnityAdsLoadListener;", "Lcom/unity3d/ads/IUnityAdsShowListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "mAdapter", "Ljava/lang/ref/WeakReference;", "Lcom/ironsource/adapters/unityads/UnityAdsAdapter;", "mPlacementId", "", "(Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;Ljava/lang/ref/WeakReference;Ljava/lang/String;)V", "onUnityAdsAdLoaded", "", "placementId", "onUnityAdsFailedToLoad", "error", "Lcom/unity3d/ads/UnityAds$UnityAdsLoadError;", PglCryptUtils.KEY_MESSAGE, "onUnityAdsShowClick", "onUnityAdsShowComplete", "completionState", "Lcom/unity3d/ads/UnityAds$UnityAdsShowCompletionState;", "onUnityAdsShowFailure", "Lcom/unity3d/ads/UnityAds$UnityAdsShowError;", "onUnityAdsShowStart", "unityadsadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UnityAdsRewardedVideoAdListener implements IUnityAdsLoadListener, IUnityAdsShowListener {
    private final WeakReference<UnityAdsAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;
    private final String mPlacementId;

    /* compiled from: UnityAdsRewardedVideoAdListener.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowCompletionState.values().length];
            try {
                iArr[UnityAds.UnityAdsShowCompletionState.SKIPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UnityAds.UnityAdsShowCompletionState.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UnityAdsRewardedVideoAdListener(RewardedVideoSmashListener rewardedVideoSmashListener, WeakReference<UnityAdsAdapter> weakReference, String mPlacementId) {
        Intrinsics.checkNotNullParameter(mPlacementId, "mPlacementId");
        this.mListener = rewardedVideoSmashListener;
        this.mAdapter = weakReference;
        this.mPlacementId = mPlacementId;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String placementId) {
        UnityAdsAdapter unityAdsAdapter;
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (unityAdsAdapter = weakReference.get()) != null) {
            unityAdsAdapter.setRewardedVideoAdAvailability$unityadsadapter_release(this.mPlacementId, true);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String placementId, UnityAds.UnityAdsLoadError error, String message) {
        int unityAdsLoadErrorCode;
        UnityAdsAdapter unityAdsAdapter;
        UnityAdsAdapter unityAdsAdapter2;
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (unityAdsAdapter2 = weakReference.get()) != null) {
            unityAdsAdapter2.setRewardedVideoAdAvailability$unityadsadapter_release(this.mPlacementId, false);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
        if (error != null) {
            if (error == UnityAds.UnityAdsLoadError.NO_FILL) {
                unityAdsLoadErrorCode = 1058;
            } else {
                WeakReference<UnityAdsAdapter> weakReference2 = this.mAdapter;
                unityAdsLoadErrorCode = (weakReference2 == null || (unityAdsAdapter = weakReference2.get()) == null) ? 510 : unityAdsAdapter.getUnityAdsLoadErrorCode(error);
            }
            IronSourceError ironSourceError = new IronSourceError(unityAdsLoadErrorCode, message);
            IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceError);
            RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
            if (rewardedVideoSmashListener2 != null) {
                rewardedVideoSmashListener2.onRewardedVideoLoadFailed(ironSourceError);
            }
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String placementId) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdOpened();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdStarted();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String placementId, UnityAds.UnityAdsShowError error, String message) {
        IronSourceError buildShowFailedError;
        UnityAdsAdapter unityAdsAdapter;
        if (error != null) {
            WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
            buildShowFailedError = new IronSourceError((weakReference == null || (unityAdsAdapter = weakReference.get()) == null) ? 510 : unityAdsAdapter.getUnityAdsShowErrorCode(error), message);
        } else {
            buildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, message);
        }
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + buildShowFailedError);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdShowFailed(buildShowFailedError);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String placementId) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String placementId, UnityAds.UnityAdsShowCompletionState completionState) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + " completionState = " + completionState);
        int i = completionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[completionState.ordinal()];
        if (i == 1) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdClosed();
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdEnded();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener3 = this.mListener;
        if (rewardedVideoSmashListener3 != null) {
            rewardedVideoSmashListener3.onRewardedVideoAdRewarded();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener4 = this.mListener;
        if (rewardedVideoSmashListener4 != null) {
            rewardedVideoSmashListener4.onRewardedVideoAdClosed();
        }
    }
}
