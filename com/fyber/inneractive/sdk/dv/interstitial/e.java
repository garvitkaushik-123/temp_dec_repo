package com.fyber.inneractive.sdk.dv.interstitial;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.AdListener;

/* loaded from: classes4.dex */
public final class e extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1144a;

    public e(g gVar) {
        this.f1144a = gVar;
    }

    public final void onAdFailedToLoad(int i) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f1144a.g;
        if (cVar != null) {
            cVar.i();
            InneractiveAdRequest inneractiveAdRequest = this.f1144a.f1249a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            g gVar = this.f1144a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, gVar.f1249a, (i) gVar.b, String.format("errorCode - %d", Integer.valueOf(i)));
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        g gVar = this.f1144a;
        if (gVar.g != null) {
            gVar.h();
            this.f1144a.g.f();
        }
    }
}
