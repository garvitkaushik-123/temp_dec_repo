package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.s0;

/* loaded from: classes4.dex */
public final class e extends v {
    public e(com.fyber.inneractive.sdk.player.t tVar) {
        super(tVar);
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        if (this.b == null) {
            this.b = new com.fyber.inneractive.sdk.player.ui.i(context, new com.fyber.inneractive.sdk.player.ui.f(), this.c, rVar, a());
        }
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void b() {
        this.c.getClass();
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, r0 r0Var) {
        if (this.f1725a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            this.f1725a = new com.fyber.inneractive.sdk.player.controller.g(this.c, this.b, inneractiveAdSpot.getAdContent().d, r0Var.c, selectedUnitController instanceof s0 ? ((s0) selectedUnitController).isOverlayOutside() : false, IAConfigManager.O.k || r0Var.f, a());
        }
        return this.f1725a;
    }

    @Override // com.fyber.inneractive.sdk.renderers.v
    public final void a(com.fyber.inneractive.sdk.player.e eVar) {
        this.c.getClass();
        eVar.a();
    }
}
