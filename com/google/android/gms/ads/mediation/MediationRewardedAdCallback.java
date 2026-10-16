package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public interface MediationRewardedAdCallback extends MediationAdCallback {
    void onAdFailedToShow(AdError adError);

    @Deprecated
    void onAdFailedToShow(String str);

    void onUserEarnedReward();

    @Deprecated
    void onUserEarnedReward(RewardItem rewardItem);

    void onVideoComplete();

    void onVideoStart();
}
