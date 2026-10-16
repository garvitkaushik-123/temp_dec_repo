package com.fyber.inneractive.sdk.dv.rewarded;

import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;

/* loaded from: classes4.dex */
public final class c implements OnUserEarnedRewardListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1149a;

    public c(d dVar) {
        this.f1149a = dVar;
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public final void onUserEarnedReward(RewardItem rewardItem) {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1149a.j;
        if (aVar != null) {
            aVar.onReward();
        }
    }
}
