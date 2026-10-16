package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1367a;
    public final /* synthetic */ q b;

    public l(q qVar, int i) {
        this.b = qVar;
        this.f1367a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Iterator it = this.b.c.iterator();
            while (it.hasNext()) {
                ((o) it.next()).a(this.f1367a);
            }
        } catch (Exception e) {
            if (IAlog.f1749a <= 3) {
                q qVar = this.b;
                qVar.getClass();
                IAlog.a("%sonPlayerProgress callback threw an exception!", e, IAlog.a(qVar));
            }
        }
    }
}
