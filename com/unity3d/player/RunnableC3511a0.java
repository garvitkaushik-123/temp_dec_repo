package com.unity3d.player;

/* renamed from: com.unity3d.player.a0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3511a0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6541a;

    public RunnableC3511a0(UnityPlayer unityPlayer) {
        this.f6541a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer = this.f6541a;
        d1.a(unityPlayer.mActivity, unityPlayer.getFrameLayout());
        this.f6541a.dispatchFrameLayoutPadding();
    }
}
