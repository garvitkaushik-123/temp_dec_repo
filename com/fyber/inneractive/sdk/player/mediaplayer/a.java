package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.player.controller.q;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1621a;
    public final /* synthetic */ int b;
    public final /* synthetic */ p c;

    public a(p pVar, int i, int i2) {
        this.c = pVar;
        this.f1621a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.c.i != null) {
            Locale locale = Locale.ENGLISH;
            String str = "Player Error: " + this.f1621a + ", " + this.b;
            n nVar = this.c.i;
            o oVar = new o(str);
            q qVar = (q) nVar;
            qVar.a(com.fyber.inneractive.sdk.player.enums.b.Error);
            IAlog.a("%sonPlayerError called with: %s for onPlayerError", IAlog.a(qVar), oVar);
            qVar.i.post(new com.fyber.inneractive.sdk.player.controller.j(qVar, oVar));
            qVar.k();
        }
    }
}
