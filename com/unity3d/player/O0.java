package com.unity3d.player;

import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public final class O0 implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForGameActivity f6484a;

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public O0(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        this.f6484a = unityPlayerForGameActivity;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        com.unity3d.player.a.C c;
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f6484a;
        c = unityPlayerForGameActivity.m_PersistentUnitySurface;
        FrameLayout frameLayout = unityPlayerForGameActivity.getFrameLayout();
        com.unity3d.player.a.B b = c.b;
        if (b == null || b.getParent() != null) {
            return;
        }
        frameLayout.addView(c.b);
        frameLayout.bringChildToFront(c.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        com.unity3d.player.a.C c;
        UnityPlayerForGameActivity unityPlayerForGameActivity = this.f6484a;
        c = unityPlayerForGameActivity.m_PersistentUnitySurface;
        SurfaceView surfaceView = unityPlayerForGameActivity.m_SurfaceView;
        if (c.f6511a != null) {
            if (c.b == null) {
                c.b = new com.unity3d.player.a.B(c, c.f6511a);
            }
            c.b.a(surfaceView);
        }
    }
}
