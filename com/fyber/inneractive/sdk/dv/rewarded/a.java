package com.fyber.inneractive.sdk.dv.rewarded;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* loaded from: classes4.dex */
public final class a extends RewardedAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1147a;

    public a(d dVar) {
        this.f1147a = dVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f1147a.g;
        if (cVar != null) {
            cVar.i();
            InneractiveAdRequest inneractiveAdRequest = this.f1147a.f1249a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            d dVar = this.f1147a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, dVar.f1249a, (i) dVar.b, loadAdError.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdLoaded(RewardedAd rewardedAd) {
        RewardedAd rewardedAd2 = rewardedAd;
        d dVar = this.f1147a;
        if (dVar.g != null) {
            dVar.i = rewardedAd2;
            dVar.h();
            this.f1147a.g.f();
        }
    }
}
