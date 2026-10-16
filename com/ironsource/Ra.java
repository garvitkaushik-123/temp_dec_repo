package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ra {

    public static final class a implements Oa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInterstitialAdListener f3029a;

        a(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
            this.f3029a = levelPlayInterstitialAdListener;
        }

        @Override // com.ironsource.Oa
        public void onAdClicked(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdClicked() adInfo: " + adInfo);
            this.f3029a.onAdClicked(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdClosed(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdClosed() adInfo: " + adInfo);
            this.f3029a.onAdClosed(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdDisplayFailed() adInfo: " + adInfo + " error: " + error);
            this.f3029a.onAdDisplayFailed(error, adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdDisplayed(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdDisplayed() adInfo: " + adInfo);
            this.f3029a.onAdDisplayed(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdInfoChanged() adInfo: " + adInfo);
            this.f3029a.onAdInfoChanged(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdLoadFailed(LevelPlayAdError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdLoaded() error: " + error);
            this.f3029a.onAdLoadFailed(error);
        }

        @Override // com.ironsource.Oa
        public void onAdLoaded(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdLoaded() adInfo: " + adInfo);
            this.f3029a.onAdLoaded(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Oa b(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        return new a(levelPlayInterstitialAdListener);
    }
}
