package com.unity3d.player;

/* loaded from: classes7.dex */
public final class a1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f6542a;

    public a1(c1 c1Var) {
        this.f6542a = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c1 c1Var = this.f6542a;
        VideoPlayer videoPlayer = c1Var.f;
        if (videoPlayer != null) {
            c1Var.f6547a.addViewToPlayer(videoPlayer, true);
            c1 c1Var2 = this.f6542a;
            c1Var2.i = true;
            c1Var2.f.requestFocus();
        }
    }
}
