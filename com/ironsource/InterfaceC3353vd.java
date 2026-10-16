package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* renamed from: com.ironsource.vd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3353vd {
    void onAdInstanceDidBecomeVisible();

    void onRewardedAdClicked();

    void onRewardedAdDismissed();

    void onRewardedAdFailedToShow(IronSourceError ironSourceError);

    void onRewardedAdShown();

    void onUserEarnedReward();
}
