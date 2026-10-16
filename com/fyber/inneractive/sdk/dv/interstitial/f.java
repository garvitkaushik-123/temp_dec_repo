package com.fyber.inneractive.sdk.dv.interstitial;

import com.google.android.gms.ads.AdListener;

/* loaded from: classes4.dex */
public final class f extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1145a;

    public f(g gVar) {
        this.f1145a = gVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClicked() {
        a aVar = this.f1145a.j;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        a aVar = this.f1145a.j;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        a aVar = this.f1145a.j;
        if (aVar != null) {
            aVar.u();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        a aVar = this.f1145a.j;
        if (aVar != null) {
            aVar.u();
        }
    }
}
