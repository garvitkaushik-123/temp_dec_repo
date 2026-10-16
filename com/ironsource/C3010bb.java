package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.bb, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3010bb {

    /* renamed from: com.ironsource.bb$a */
    public static final class a implements Oa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayRewardedAdListener f3203a;

        a(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
            this.f3203a = levelPlayRewardedAdListener;
        }

        @Override // com.ironsource.Oa
        public void onAdClicked(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdClicked() adInfo: " + adInfo);
            this.f3203a.onAdClicked(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdClosed(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdClosed() adInfo: " + adInfo);
            this.f3203a.onAdClosed(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdDisplayFailed() adInfo: " + adInfo + " error: " + error);
            this.f3203a.onAdDisplayFailed(error, adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdDisplayed(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdDisplayed() adInfo: " + adInfo);
            this.f3203a.onAdDisplayed(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdInfoChanged() adInfo: " + adInfo);
            this.f3203a.onAdInfoChanged(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdLoadFailed(LevelPlayAdError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdLoadFailed() error: " + error);
            this.f3203a.onAdLoadFailed(error);
        }

        @Override // com.ironsource.Oa
        public void onAdLoaded(LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdLoaded() adInfo: " + adInfo);
            this.f3203a.onAdLoaded(adInfo);
        }

        @Override // com.ironsource.Oa
        public void onAdRewarded(LevelPlayReward reward, LevelPlayAdInfo adInfo) {
            Intrinsics.checkNotNullParameter(reward, "reward");
            Intrinsics.checkNotNullParameter(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdRewarded() reward: " + reward + " adInfo: " + adInfo);
            this.f3203a.onAdRewarded(reward, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Oa b(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
        return new a(levelPlayRewardedAdListener);
    }
}
