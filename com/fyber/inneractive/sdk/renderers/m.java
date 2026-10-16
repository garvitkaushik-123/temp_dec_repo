package com.fyber.inneractive.sdk.renderers;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f1720a;

    public m(o oVar) {
        this.f1720a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.f1720a;
        if (oVar.t != null) {
            oVar.getClass();
            IAlog.a("%sIdle state reached!", IAlog.a(oVar));
            com.fyber.inneractive.sdk.player.controller.s sVar = this.f1720a.m;
            if (sVar != null) {
                sVar.h(true);
            }
            this.f1720a.t = null;
        }
    }
}
