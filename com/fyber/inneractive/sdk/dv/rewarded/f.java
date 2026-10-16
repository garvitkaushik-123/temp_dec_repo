package com.fyber.inneractive.sdk.dv.rewarded;

import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* loaded from: classes4.dex */
public final class f extends RewardedAdCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1151a;

    public f(g gVar) {
        this.f1151a = gVar;
    }

    public final void onRewardedAdClosed() {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1151a.j;
        if (aVar != null) {
            aVar.g();
        }
    }

    public final void onRewardedAdFailedToShow(int i) {
    }

    public final void onRewardedAdOpened() {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1151a.j;
        if (aVar != null) {
            aVar.u();
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1151a.j;
        if (aVar != null) {
            aVar.onReward();
        }
    }
}
