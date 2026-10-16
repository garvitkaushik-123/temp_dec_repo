package com.fyber.inneractive.sdk.dv.rewarded;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* loaded from: classes4.dex */
public final class e extends RewardedAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1150a;

    public e(g gVar) {
        this.f1150a = gVar;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f1150a.g;
        if (cVar != null) {
            cVar.i();
            InneractiveAdRequest inneractiveAdRequest = this.f1150a.f1249a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            g gVar = this.f1150a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, gVar.f1249a, (i) gVar.b, String.format("errorCode - %d", Integer.valueOf(i)));
        }
    }

    public final void onRewardedAdLoaded() {
        g gVar = this.f1150a;
        if (gVar.g != null) {
            gVar.h();
            this.f1150a.g.f();
        }
    }
}
