package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.util.o;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;

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
        RewardedAd rewardedAd = new RewardedAd(o.f1770a, "FyberRewarded");
        this.i = rewardedAd;
        rewardedAd.loadAd(adRequest, this.k);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        Object obj = this.i;
        if (obj != null) {
            return ((RewardedAd) obj).isLoaded();
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.a
    public final void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity) {
        this.j = aVar;
        ((RewardedAd) this.i).show(activity, this.l);
    }
}
