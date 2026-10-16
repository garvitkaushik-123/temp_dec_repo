package com.fyber.inneractive.sdk.player.ui;

/* loaded from: classes4.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f1645a;

    public k(l lVar) {
        this.f1645a = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f1645a;
        int i = lVar.j;
        if (i != 0) {
            int i2 = (lVar.i / i) + lVar.E;
            lVar.E = i2;
            lVar.a(i2);
        }
        l lVar2 = this.f1645a;
        if (lVar2.E < lVar2.F) {
            lVar2.postDelayed(lVar2.D, lVar2.k);
            return;
        }
        lVar2.D = null;
        lVar2.E = 0;
        lVar2.F = 0;
    }
}
