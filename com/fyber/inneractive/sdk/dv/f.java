package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* loaded from: classes4.dex */
public final class f implements com.fyber.inneractive.sdk.factories.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1137a;

    public f(g gVar) {
        this.f1137a = gVar;
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        this.f1137a.getClass();
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof a);
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final com.fyber.inneractive.sdk.interfaces.d a() {
        return new com.fyber.inneractive.sdk.dv.banner.c();
    }
}
