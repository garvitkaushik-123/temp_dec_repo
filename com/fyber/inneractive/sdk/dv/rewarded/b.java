package com.fyber.inneractive.sdk.dv.rewarded;

import com.google.android.gms.ads.FullScreenContentCallback;

/* loaded from: classes4.dex */
public final class b extends FullScreenContentCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1148a;

    public b(d dVar) {
        this.f1148a = dVar;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdDismissedFullScreenContent() {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1148a.j;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdImpression() {
        com.fyber.inneractive.sdk.dv.interstitial.a aVar = this.f1148a.j;
        if (aVar != null) {
            aVar.u();
        }
    }
}
