package com.unity3d.player;

/* loaded from: classes7.dex */
public final class T0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoPlayer f6492a;

    public T0(VideoPlayer videoPlayer) {
        this.f6492a = videoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6492a.destroyPlayer();
        this.f6492a.changeState(3);
    }
}
