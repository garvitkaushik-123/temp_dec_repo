package com.unity3d.player;

/* loaded from: classes7.dex */
public final class b1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f6545a;

    public b1(c1 c1Var) {
        this.f6545a = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c1 c1Var = this.f6545a;
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
        this.f6545a.f6547a.onResume();
    }
}
