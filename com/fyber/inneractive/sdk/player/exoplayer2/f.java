package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.fyber.inneractive.sdk.player.controller.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1507a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, Looper looper) {
        super(looper);
        this.f1507a = gVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        g gVar = this.f1507a;
        gVar.getClass();
        switch (message.what) {
            case 0:
                gVar.l--;
                return;
            case 1:
                gVar.j = message.arg1;
                Iterator it = gVar.e.iterator();
                while (it.hasNext()) {
                    ((b0) it.next()).a(gVar.j, gVar.i);
                }
                return;
            case 2:
                Iterator it2 = gVar.e.iterator();
                while (it2.hasNext()) {
                    ((b0) it2.next()).getClass();
                }
                return;
            case 3:
                if (gVar.l == 0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j) message.obj;
                    gVar.h = true;
                    z zVar = jVar.f1551a;
                    gVar.o = jVar.b;
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i iVar = gVar.f1508a;
                    Object obj = jVar.c;
                    ((com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g) iVar).getClass();
                    Iterator it3 = gVar.e.iterator();
                    while (it3.hasNext()) {
                        ((b0) it3.next()).getClass();
                    }
                    return;
                }
                return;
            case 4:
                int i = gVar.k - 1;
                gVar.k = i;
                if (i == 0) {
                    gVar.q = (i) message.obj;
                    if (message.arg1 != 0) {
                        Iterator it4 = gVar.e.iterator();
                        while (it4.hasNext()) {
                            ((b0) it4.next()).getClass();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (gVar.k == 0) {
                    gVar.q = (i) message.obj;
                    Iterator it5 = gVar.e.iterator();
                    while (it5.hasNext()) {
                        ((b0) it5.next()).getClass();
                    }
                    return;
                }
                return;
            case 6:
                k kVar = (k) message.obj;
                gVar.k -= kVar.d;
                if (gVar.l == 0) {
                    gVar.m = kVar.f1512a;
                    gVar.n = kVar.b;
                    gVar.q = kVar.c;
                    Iterator it6 = gVar.e.iterator();
                    while (it6.hasNext()) {
                        ((b0) it6.next()).getClass();
                    }
                    return;
                }
                return;
            case 7:
                s sVar = (s) message.obj;
                if (gVar.p.equals(sVar)) {
                    return;
                }
                gVar.p = sVar;
                Iterator it7 = gVar.e.iterator();
                while (it7.hasNext()) {
                    ((b0) it7.next()).getClass();
                }
                return;
            case 8:
                d dVar = (d) message.obj;
                Iterator it8 = gVar.e.iterator();
                while (it8.hasNext()) {
                    b0 b0Var = (b0) it8.next();
                    com.fyber.inneractive.sdk.player.controller.f fVar = (com.fyber.inneractive.sdk.player.controller.f) b0Var.f1356a.get();
                    if (fVar != null && (dVar.getCause() instanceof com.fyber.inneractive.sdk.player.exoplayer2.audio.n) && (b0Var.b || (fVar.D && fVar.A))) {
                        fVar.v = true;
                        g gVar2 = fVar.s;
                        if (gVar2 != null) {
                            gVar2.d.d();
                            gVar2.c.removeCallbacksAndMessages(null);
                            fVar.s = null;
                        }
                        fVar.a(false);
                        fVar.a(fVar.C);
                        fVar.i.post(new com.fyber.inneractive.sdk.player.controller.k(fVar, false));
                    } else if (fVar == null || !fVar.A || b0Var.b || !com.fyber.inneractive.sdk.player.cache.m.f.c || !com.fyber.inneractive.sdk.util.s.a() || fVar.E >= fVar.p) {
                        com.fyber.inneractive.sdk.player.mediaplayer.o oVar = new com.fyber.inneractive.sdk.player.mediaplayer.o(dVar, dVar.getCause() == null ? "empty" : dVar.getCause().getMessage());
                        IAlog.a("%sonPlayerError called with %s for sendErrorState", b0Var.a(), oVar);
                        com.fyber.inneractive.sdk.player.controller.f fVar2 = (com.fyber.inneractive.sdk.player.controller.f) com.fyber.inneractive.sdk.util.t.a(b0Var.f1356a);
                        if (fVar2 != null) {
                            fVar2.a(com.fyber.inneractive.sdk.player.enums.b.Error);
                            IAlog.a("%sonPlayerError called with: %s for onPlayerError", IAlog.a(fVar2), oVar);
                            fVar2.i.post(new com.fyber.inneractive.sdk.player.controller.j(fVar2, oVar));
                            fVar2.k();
                        }
                    } else {
                        g gVar3 = fVar.s;
                        if (gVar3 != null) {
                            gVar3.d.d();
                            gVar3.c.removeCallbacksAndMessages(null);
                            fVar.s = null;
                        }
                        fVar.a(true);
                        fVar.a(fVar.C);
                        fVar.E++;
                        fVar.i.post(new com.fyber.inneractive.sdk.player.controller.k(fVar, true));
                    }
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
