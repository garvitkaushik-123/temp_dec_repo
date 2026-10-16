package com.fyber.inneractive.sdk.renderers;

/* loaded from: classes4.dex */
public final class l implements com.fyber.inneractive.sdk.player.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1719a;

    public l(o oVar) {
        this.f1719a = oVar;
    }

    @Override // com.fyber.inneractive.sdk.player.e
    public final void a() {
        com.fyber.inneractive.sdk.player.controller.s sVar = this.f1719a.m;
        if (sVar != null) {
            sVar.b(false);
            this.f1719a.m.u();
        }
    }
}
