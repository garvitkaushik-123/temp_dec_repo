package com.unity3d.player;

import android.widget.FrameLayout;

/* renamed from: com.unity3d.player.f0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3521f0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6554a;

    public RunnableC3521f0(UnityPlayer unityPlayer) {
        this.f6554a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.K k;
        FrameLayout frameLayout = this.f6554a.getFrameLayout();
        k = this.f6554a.m_SplashScreen;
        frameLayout.removeView(k);
        this.f6554a.m_SplashScreen = null;
    }
}
