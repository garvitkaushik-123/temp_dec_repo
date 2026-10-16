package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Exception f1365a;
    public final /* synthetic */ q b;

    public j(q qVar, com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
        this.b = qVar;
        this.f1365a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar = this.b;
        if (qVar.g) {
            return;
        }
        try {
            Iterator it = qVar.b.iterator();
            while (it.hasNext()) {
                ((p) it.next()).a((com.fyber.inneractive.sdk.player.mediaplayer.o) this.f1365a);
            }
        } catch (Exception e) {
            if (IAlog.f1749a <= 3) {
                q qVar2 = this.b;
                qVar2.getClass();
                IAlog.a("%sonPlayerError callback threw an exception!", e, IAlog.a(qVar2));
            }
        }
    }
}
