package com.ironsource.adapters.fyber;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

/* loaded from: classes6.dex */
public class FyberRewardedVideoAdListener implements InneractiveAdSpot.RequestListener, InneractiveFullScreenAdRewardedListener, InneractiveFullscreenAdEventsListener, VideoContentListener {
    private RewardedVideoSmashListener mListener;
    private String mSpotId;

    @Override // com.fyber.inneractive.sdk.external.VideoContentListener
    public void onProgress(int i, int i2) {
    }

    FyberRewardedVideoAdListener(RewardedVideoSmashListener rewardedVideoSmashListener, String str) {
        this.mListener = rewardedVideoSmashListener;
        this.mSpotId = str;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
    public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        IronSourceError buildLoadFailedError;
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        if (inneractiveErrorCode != null) {
            IronLog.ADAPTER_CALLBACK.verbose("inneractiveErrorCode = " + inneractiveErrorCode);
            if (inneractiveErrorCode == InneractiveErrorCode.NO_FILL) {
                buildLoadFailedError = new IronSourceError(1058, inneractiveErrorCode.toString());
            } else {
                buildLoadFailedError = ErrorBuilder.buildLoadFailedError(inneractiveErrorCode.toString());
            }
            this.mListener.onRewardedVideoLoadFailed(buildLoadFailedError);
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdOpened();
            this.mListener.onRewardedVideoAdStarted();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
        String message;
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (adDisplayError == null) {
            message = "Rewarded Video show failed (adDisplayError is null)";
        } else {
            message = adDisplayError.getMessage();
            IronLog.ADAPTER_CALLBACK.verbose("error = " + message);
        }
        this.mListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, message));
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener
    public void onAdRewarded(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdRewarded();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener
    public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot) {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.VideoContentListener
    public void onCompleted() {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdEnded();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.VideoContentListener
    public void onPlayerError() {
        IronLog.ADAPTER_CALLBACK.verbose("spotId = " + this.mSpotId);
    }
}
