package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.player.controller.z;

/* loaded from: classes4.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public z f1725a;
    public com.fyber.inneractive.sdk.player.ui.i b;
    public final com.fyber.inneractive.sdk.player.n c;

    public v(com.fyber.inneractive.sdk.player.t tVar) {
        this.c = (com.fyber.inneractive.sdk.player.n) tVar.f;
    }

    public abstract com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, r0 r0Var);

    public abstract com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar);

    public final String a() {
        r0 r0Var;
        com.fyber.inneractive.sdk.player.n nVar = this.c;
        com.fyber.inneractive.sdk.response.e eVar = (nVar == null || (r0Var = nVar.b) == null) ? null : r0Var.b;
        if (eVar != null) {
            return eVar.F;
        }
        return null;
    }

    public abstract void a(com.fyber.inneractive.sdk.player.e eVar);

    public abstract void b();
}
