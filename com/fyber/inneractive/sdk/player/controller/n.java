package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1369a;

    public n(q qVar) {
        this.f1369a = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Iterator it = this.f1369a.b.iterator();
            while (it.hasNext()) {
                ((p) it.next()).d();
            }
        } catch (Exception e) {
            if (IAlog.f1749a <= 3) {
                q qVar = this.f1369a;
                qVar.getClass();
                IAlog.a("%sonDrawnToSurface callback threw an exception!", e, IAlog.a(qVar));
            }
        }
    }
}
