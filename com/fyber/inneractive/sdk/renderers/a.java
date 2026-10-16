package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.s0;

/* loaded from: classes4.dex */
public final class a extends v {
    public a(com.fyber.inneractive.sdk.player.t tVar) {
        super(tVar);
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void a(com.fyber.inneractive.sdk.player.e eVar) {
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void b() {
        this.c.getClass();
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        com.fyber.inneractive.sdk.player.ui.i iVar = this.b;
        return iVar == null ? new com.fyber.inneractive.sdk.player.ui.i(context, new com.fyber.inneractive.sdk.player.ui.h(), this.c, rVar, a()) : iVar;
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, r0 r0Var) {
        if (this.f1725a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            this.f1725a = new com.fyber.inneractive.sdk.player.controller.s(this.c, (com.fyber.inneractive.sdk.player.ui.i) ((com.fyber.inneractive.sdk.player.ui.o) this.b), com.fyber.inneractive.sdk.config.a.a(inneractiveAdSpot.getAdContent().c().o), r0Var.c, selectedUnitController instanceof s0 ? ((s0) selectedUnitController).isOverlayOutside() : false, a());
        }
        return this.f1725a;
    }
}
