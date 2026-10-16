package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.ignite.m;
import com.fyber.inneractive.sdk.player.ui.o;
import com.fyber.inneractive.sdk.player.ui.s;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class f implements com.fyber.inneractive.sdk.web.remoteui.a {

    /* renamed from: a, reason: collision with root package name */
    public s f1652a;
    public boolean h;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean i = false;
    public boolean j = false;
    public m k = m.NONE;
    public String l = "";

    public f(o oVar) {
        this.f1652a = null;
        this.h = false;
        this.f1652a = oVar;
        this.h = oVar.H;
    }

    @Override // com.fyber.inneractive.sdk.web.remoteui.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, boolean z, HashMap hashMap) {
        s sVar = this.f1652a;
        if (sVar == null) {
            IAlog.a("%s: showFallback: fallback won't be displayed because it is null", "RemoteUiFallbackHandler");
            return;
        }
        sVar.g(this.b);
        this.f1652a.d(this.i);
        this.f1652a.f(this.f);
        this.f1652a.a(this.e, this.k);
        this.f1652a.c(this.h);
        this.f1652a.a(this.j, this.l);
        this.f1652a.b(this.g);
        this.f1652a.e(this.c);
        this.f1652a.a(this.d);
    }
}
