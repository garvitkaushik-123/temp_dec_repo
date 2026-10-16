package com.fyber.inneractive.sdk.dv.banner;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.dv.handler.e;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.a0;
import com.fyber.inneractive.sdk.flow.x;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* loaded from: classes4.dex */
public final class a extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1136a;

    public a(b bVar) {
        this.f1136a = bVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        InneractiveAdRequest inneractiveAdRequest = this.f1136a.f1249a;
        String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
        com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
        b bVar = this.f1136a;
        e.a(spotId, aVar, bVar.f1249a, (i) bVar.b, loadAdError.getMessage());
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        b bVar = this.f1136a;
        c cVar = bVar.h;
        if (cVar != null) {
            cVar.u();
        } else {
            bVar.j = true;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        b bVar = this.f1136a;
        com.fyber.inneractive.sdk.dv.c cVar = bVar.g;
        if (cVar != null) {
            bVar.k = true;
            cVar.f();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        i iVar;
        l0 l0Var;
        c cVar = this.f1136a.h;
        if (cVar != null) {
            cVar.a(cVar.w(), Float.NaN, Float.NaN);
            x xVar = cVar.b;
            if (xVar == null || (iVar = (i) ((b) xVar).b) == null) {
                return;
            }
            a0.a(iVar);
            s0 s0Var = ((b) cVar.b).d;
            if (s0Var == null || (l0Var = ((r0) s0Var).c) == null) {
                return;
            }
            a0.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, l0Var.b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY);
        }
    }
}
