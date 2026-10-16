package com.unity3d.player;

import android.widget.FrameLayout;

/* loaded from: classes7.dex */
public final class K0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f6479a;

    public K0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6479a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        U view = this.f6479a.getView();
        if (view != null) {
            com.unity3d.player.a.C c = view.c;
            FrameLayout frameLayout = view.b.getFrameLayout();
            com.unity3d.player.a.B b = c.b;
            if (b != null && b.getParent() != null) {
                frameLayout.removeView(c.b);
            }
            view.c.b = null;
        }
    }
}
