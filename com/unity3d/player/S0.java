package com.unity3d.player;

import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public final class S0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForGameActivity f6490a;

    public S0(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        this.f6490a = unityPlayerForGameActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.C c;
        com.unity3d.player.a.C c2;
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f6490a;
        c = unityPlayerForGameActivity.m_PersistentUnitySurface;
        FrameLayout frameLayout = unityPlayerForGameActivity.getFrameLayout();
        com.unity3d.player.a.B b = c.b;
        if (b != null && b.getParent() != null) {
            frameLayout.removeView(c.b);
        }
        c2 = this.f6490a.m_PersistentUnitySurface;
        c2.b = null;
    }
}
