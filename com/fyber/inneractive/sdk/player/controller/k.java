package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1366a;
    public final /* synthetic */ q b;

    public k(f fVar, boolean z) {
        this.b = fVar;
        this.f1366a = z;
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
                ((p) it.next()).c(this.f1366a);
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
