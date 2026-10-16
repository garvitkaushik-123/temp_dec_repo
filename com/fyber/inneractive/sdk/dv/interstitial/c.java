package com.fyber.inneractive.sdk.dv.interstitial;

import com.google.android.gms.ads.FullScreenContentCallback;

/* loaded from: classes4.dex */
public final class c extends FullScreenContentCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1143a;

    public c(d dVar) {
        this.f1143a = dVar;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdDismissedFullScreenContent() {
        a aVar = this.f1143a.j;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdShowedFullScreenContent() {
        a aVar = this.f1143a.j;
        if (aVar != null) {
            aVar.u();
        }
    }
}
