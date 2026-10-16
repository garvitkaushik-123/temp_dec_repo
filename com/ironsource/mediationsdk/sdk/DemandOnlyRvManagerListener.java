package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.demandOnly.l;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes6.dex */
public interface DemandOnlyRvManagerListener {
    void onRewardedVideoAdClicked(l lVar);

    void onRewardedVideoAdClosed(l lVar);

    void onRewardedVideoAdLoadFailed(IronSourceError ironSourceError, l lVar, long j);

    void onRewardedVideoAdOpened(l lVar);

    void onRewardedVideoAdRewarded(l lVar);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, l lVar);

    void onRewardedVideoAdVisible(l lVar);

    void onRewardedVideoLoadSuccess(l lVar, long j);
}
