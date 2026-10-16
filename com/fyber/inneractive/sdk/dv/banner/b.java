package com.fyber.inneractive.sdk.dv.banner;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.util.o;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* loaded from: classes4.dex */
public final class b extends com.fyber.inneractive.sdk.dv.a {
    public boolean j;
    public boolean k;
    public final a l;

    public b(s0 s0Var, r rVar, i iVar) {
        super(s0Var, rVar, iVar);
        this.j = false;
        this.k = false;
        this.l = new a(this);
    }

    @Override // com.fyber.inneractive.sdk.dv.a
    public final void a(AdRequest adRequest, com.fyber.inneractive.sdk.dv.c cVar) {
        l0 l0Var;
        this.g = cVar;
        AdView adView = new AdView(o.f1770a);
        this.i = adView;
        AdSize adSize = AdSize.BANNER;
        s0 s0Var = this.d;
        if (s0Var != null && (l0Var = ((r0) s0Var).c) != null && l0Var.b == UnitDisplayType.MRECT) {
            adSize = AdSize.MEDIUM_RECTANGLE;
        }
        adView.setAdSize(adSize);
        ((AdView) this.i).setAdUnitId("FyberBanner");
        ((AdView) this.i).setAdListener(this.l);
        ((AdView) this.i).loadAd(adRequest);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        return this.k;
    }
}
