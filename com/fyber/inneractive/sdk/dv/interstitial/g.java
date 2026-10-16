package com.fyber.inneractive.sdk.dv.interstitial;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.util.o;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/* loaded from: classes4.dex */
public final class g extends com.fyber.inneractive.sdk.a {
    public final e k;
    public final f l;

    public g(s0 s0Var, r rVar, i iVar) {
        super(s0Var, rVar, iVar);
        this.k = new e(this);
        this.l = new f(this);
    }

    @Override // com.fyber.inneractive.sdk.dv.a
    public final void a(AdRequest adRequest, com.fyber.inneractive.sdk.dv.c cVar) {
        this.g = cVar;
        InterstitialAd interstitialAd = new InterstitialAd(o.f1770a);
        this.i = interstitialAd;
        interstitialAd.setAdListener(this.k);
        ((InterstitialAd) this.i).setAdUnitId("FyberInterstitial");
        ((InterstitialAd) this.i).loadAd(adRequest);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        Object obj = this.i;
        return obj != null && ((InterstitialAd) obj).isLoaded();
    }

    @Override // com.fyber.inneractive.sdk.a
    public final void a(a aVar, Activity activity) {
        this.j = aVar;
        Object obj = this.i;
        if (obj != null) {
            ((InterstitialAd) obj).setAdListener(this.l);
            ((InterstitialAd) this.i).show();
        }
    }
}
