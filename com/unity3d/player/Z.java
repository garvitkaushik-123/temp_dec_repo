package com.unity3d.player;

/* loaded from: classes7.dex */
public final class Z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f6507a;
    public final /* synthetic */ UnityPlayer b;

    public Z(UnityPlayer unityPlayer, boolean z) {
        this.b = unityPlayer;
        this.f6507a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer = this.b;
        d1.a(unityPlayer.mActivity, unityPlayer.getFrameLayout(), this.f6507a, DisplayCutoutSupport.getDisplayCutoutSupport(this.b.mActivity));
        this.b.dispatchFrameLayoutPadding();
    }
}
