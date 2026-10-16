package com.unity3d.player;

import android.view.SurfaceHolder;
import android.widget.FrameLayout;
import com.unity3d.player.a.C3499g;

/* loaded from: classes7.dex */
public final class T implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ U f6491a;

    public T(U u) {
        this.f6491a = u;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f6491a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        U u = this.f6491a;
        com.unity3d.player.a.C c = u.c;
        FrameLayout frameLayout = u.b.getFrameLayout();
        com.unity3d.player.a.B b = c.b;
        if (b == null || b.getParent() != null) {
            return;
        }
        frameLayout.addView(c.b);
        frameLayout.bringChildToFront(c.b);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.f6491a.b.updateGLDisplay(0, surfaceHolder.getSurface());
        this.f6491a.b.sendSurfaceChangedEvent();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        U u = this.f6491a;
        com.unity3d.player.a.C c = u.c;
        C3499g c3499g = u.f6493a;
        if (c.f6511a != null) {
            if (c.b == null) {
                c.b = new com.unity3d.player.a.B(c, c.f6511a);
            }
            c.b.a(c3499g);
        }
        this.f6491a.b.updateGLDisplay(0, null);
    }
}
