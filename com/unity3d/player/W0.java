package com.unity3d.player;

/* loaded from: classes7.dex */
public final class W0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ X0 f6502a;

    public W0(X0 x0) {
        this.f6502a = x0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c1 c1Var = this.f6502a.f6504a.h;
        VideoPlayer videoPlayer = c1Var.f;
        if (videoPlayer != null) {
            c1Var.f6547a.removeViewFromPlayer(videoPlayer);
            c1Var.i = false;
            c1Var.f.destroyPlayer();
            c1Var.f = null;
            C3527i0 c3527i0 = c1Var.c;
            if (c3527i0 != null) {
                c3527i0.a();
            }
        }
        this.f6502a.f6504a.h.f6547a.onResume();
    }
}
