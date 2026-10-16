package com.fyber.inneractive.sdk.player.controller;

/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1361a;

    public e(f fVar) {
        this.f1361a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.player.exoplayer2.g gVar = this.f1361a.s;
        if (gVar != null) {
            gVar.a(gVar.a(), -9223372036854775807L);
            this.f1361a.s.d.f.sendEmptyMessage(5);
            com.fyber.inneractive.sdk.player.exoplayer2.g gVar2 = this.f1361a.s;
            gVar2.d.d();
            gVar2.c.removeCallbacksAndMessages(null);
            this.f1361a.s = null;
        }
    }
}
