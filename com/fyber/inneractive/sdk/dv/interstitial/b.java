package com.fyber.inneractive.sdk.dv.interstitial;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

/* loaded from: classes4.dex */
public final class b extends InterstitialAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1142a;

    public b(d dVar) {
        this.f1142a = dVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f1142a.g;
        if (cVar != null) {
            cVar.i();
            InneractiveAdRequest inneractiveAdRequest = this.f1142a.f1249a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            d dVar = this.f1142a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, dVar.f1249a, (i) dVar.b, loadAdError.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdLoaded(InterstitialAd interstitialAd) {
        InterstitialAd interstitialAd2 = interstitialAd;
        d dVar = this.f1142a;
        if (dVar.g != null) {
            dVar.i = interstitialAd2;
            dVar.h();
            this.f1142a.g.f();
        }
    }
}
