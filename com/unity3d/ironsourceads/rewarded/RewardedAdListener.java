package com.unity3d.ironsourceads.rewarded;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* loaded from: classes7.dex */
public interface RewardedAdListener {
    void onRewardedAdClicked(RewardedAd rewardedAd);

    void onRewardedAdDismissed(RewardedAd rewardedAd);

    void onRewardedAdFailedToShow(RewardedAd rewardedAd, IronSourceError ironSourceError);

    void onRewardedAdShown(RewardedAd rewardedAd);

    void onUserEarnedReward(RewardedAd rewardedAd);
}
