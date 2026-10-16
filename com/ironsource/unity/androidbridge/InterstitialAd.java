package com.ironsource.unity.androidbridge;

import android.app.Activity;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAd;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes6.dex */
public class InterstitialAd {
    Activity mActivity = UnityPlayer.currentActivity;
    LevelPlayInterstitialAd mInterstitialAd;

    public InterstitialAd(String str, IUnityInterstitialAdListener iUnityInterstitialAdListener) {
        this.mInterstitialAd = new LevelPlayInterstitialAd(str);
        setupInterstitialListener(iUnityInterstitialAdListener);
    }

    public InterstitialAd(String str, LevelPlayInterstitialAd.Config config, IUnityInterstitialAdListener iUnityInterstitialAdListener) {
        this.mInterstitialAd = new LevelPlayInterstitialAd(str, config);
        setupInterstitialListener(iUnityInterstitialAdListener);
    }

    private void setupInterstitialListener(final IUnityInterstitialAdListener iUnityInterstitialAdListener) {
        this.mInterstitialAd.setListener(new LevelPlayInterstitialAdListener() { // from class: com.ironsource.unity.androidbridge.InterstitialAd.1
            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdLoaded(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdLoadFailed(LevelPlayAdError levelPlayAdError) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdLoadFailed(LevelPlayUtils.adErrorToString(levelPlayAdError));
                }
            }

            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdDisplayed(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdClosed(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdClosed(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdClicked(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdClicked(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdDisplayFailed(LevelPlayAdError levelPlayAdError, LevelPlayAdInfo levelPlayAdInfo) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdDisplayFailed(LevelPlayUtils.adErrorToString(levelPlayAdError), LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }

            @Override // com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener
            public void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
                IUnityInterstitialAdListener iUnityInterstitialAdListener2 = iUnityInterstitialAdListener;
                if (iUnityInterstitialAdListener2 != null) {
                    iUnityInterstitialAdListener2.onAdInfoChanged(LevelPlayUtils.adInfoToString(levelPlayAdInfo));
                }
            }
        });
    }

    public void loadAd() {
        this.mInterstitialAd.loadAd();
    }

    public void showAd(String str) {
        this.mInterstitialAd.showAd(this.mActivity, str);
    }

    public boolean isAdReady() {
        return this.mInterstitialAd.isAdReady();
    }

    public static boolean isPlacementCapped(String str) {
        return LevelPlayInterstitialAd.isPlacementCapped(str);
    }

    public String getAdId() {
        return this.mInterstitialAd.getAdId();
    }

    public static class ConfigBuilder {
        private final LevelPlayInterstitialAd.Config.Builder builder = new LevelPlayInterstitialAd.Config.Builder();

        public void setBidFloor(double d) {
            this.builder.setBidFloor(d);
        }

        public LevelPlayInterstitialAd.Config build() {
            return this.builder.build();
        }
    }
}
