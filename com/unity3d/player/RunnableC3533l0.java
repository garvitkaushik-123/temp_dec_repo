package com.unity3d.player;

import android.view.WindowManager;

/* renamed from: com.unity3d.player.l0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3533l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f6566a;
    public final /* synthetic */ UnityPlayer b;

    public RunnableC3533l0(UnityPlayer unityPlayer, float f) {
        this.b = unityPlayer;
        this.f6566a = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.b.m_Window.getAttributes();
        attributes.screenBrightness = this.f6566a;
        this.b.m_Window.setAttributes(attributes);
    }
}
