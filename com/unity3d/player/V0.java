package com.unity3d.player;

/* loaded from: classes7.dex */
public final class V0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final VideoPlayer f6500a;
    public boolean b = false;

    public V0(VideoPlayer videoPlayer) {
        this.f6500a = videoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.b) {
            return;
        }
        z = VideoPlayer.LOG;
        if (z) {
            VideoPlayer.Log("Stopping the video player due to timeout.");
        }
        this.f6500a.cancelOnPrepare();
    }
}
