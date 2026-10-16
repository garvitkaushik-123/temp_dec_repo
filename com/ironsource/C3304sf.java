package com.ironsource;

import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.sf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3304sf implements LevelPlayRewardedAdListener {
    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdClicked(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3184ld.a().a(new Placement(0, adInfo.getPlacementName(), false, "", 0, null), C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdClosed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3184ld.a().b(C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3184ld a2 = C3184ld.a();
        C3406yf c3406yf = C3406yf.f3954a;
        a2.a(c3406yf.a(error), c3406yf.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3184ld.a().c(C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdLoadFailed(LevelPlayAdError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        C3184ld.a().a(C3406yf.f3954a.a(error));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3184ld.a().d(C3406yf.f3954a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdRewarded(LevelPlayReward reward, LevelPlayAdInfo adInfo) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        C3184ld.a().b(new Placement(0, adInfo.getPlacementName(), false, reward.getName(), reward.getAmount(), null), C3406yf.f3954a.a(adInfo));
    }
}
