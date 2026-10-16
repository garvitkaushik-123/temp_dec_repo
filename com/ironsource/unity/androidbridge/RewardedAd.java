package com.ironsource.unity.androidbridge;

import android.app.Activity;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAd;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes6.dex */
public class RewardedAd {
    Activity mActivity = UnityPlayer.currentActivity;
    LevelPlayRewardedAd mRewardedAd;

    public RewardedAd(String str, IUnityRewardedAdListener iUnityRewardedAdListener) {
        this.mRewardedAd = new LevelPlayRewardedAd(str);
        setupRewardedListener(iUnityRewardedAdListener);
    }

    public RewardedAd(String str, LevelPlayRewardedAd.Config config, IUnityRewardedAdListener iUnityRewardedAdListener) {
        this.mRewardedAd = new LevelPlayRewardedAd(str, config);
        setupRewardedListener(iUnityRewardedAdListener);
    }

    private void setupRewardedListener(final IUnityRewardedAdListener iUnityRewardedAdListener) {
        this.mRewardedAd.setListener(new LevelPlayRewardedAdListener() { // from class: com.ironsource.unity.androidbridge.RewardedAd.1
            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdLoaded(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdLoadFailed(LevelPlayUtils.adErrorToString(levelPlayAdError));
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdDisplayed(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdRewarded(LevelPlayReward levelPlayReward, LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdRewarded(LevelPlayUtils.adInfoToString(levelPlayAdInfo), levelPlayReward.getName(), levelPlayReward.getAmount());
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdDisplayFailed(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdDisplayFailed(LevelPlayUtils.adErrorToString(levelPlayAdError), LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdClosed(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdClosed(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdInfoChanged(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
            public void onAdClicked(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityRewardedAdListener iUnityRewardedAdListener2 = iUnityRewardedAdListener;
                if (iUnityRewardedAdListener2 != null) {
                    iUnityRewardedAdListener2.onAdClicked(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }
        });
    }

    public void loadAd() {
        this.mRewardedAd.loadAd();
    }

    public void showAd(String str) {
        this.mRewardedAd.showAd(this.mActivity, str);
    }

    public boolean isAdReady() {
        return this.mRewardedAd.isAdReady();
    }

    public static boolean isPlacementCapped(String str) {
        return LevelPlayRewardedAd.isPlacementCapped(str);
    }

    public String getAdId() {
        return this.mRewardedAd.getAdId();
    }

    public static class ConfigBuilder {
        private final LevelPlayRewardedAd.Config.Builder builder = new LevelPlayRewardedAd.Config.Builder();

        public void setBidFloor(double d) {
            this.builder.setBidFloor(d);
        }

        public LevelPlayRewardedAd.Config build() {
            return this.builder.build();
        }
    }
}
