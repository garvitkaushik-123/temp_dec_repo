package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;

/* renamed from: com.ironsource.g6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3093g6 {
    void a();

    void a(LevelPlayAdError levelPlayAdError);

    void a(LevelPlayReward levelPlayReward);

    void onAdClicked();

    void onAdClosed();

    void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo);

    void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo);

    void onAdLoadFailed(LevelPlayAdError levelPlayAdError);

    void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo);
}
