package com.unity3d.player;

import com.unity3d.player.a.AbstractC3495c;

/* renamed from: com.unity3d.player.b0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3513b0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6544a;
    public final /* synthetic */ UnityPlayer b;

    public RunnableC3513b0(UnityPlayer unityPlayer, int i) {
        this.b = unityPlayer;
        this.f6544a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            UnityPlayer unityPlayer = this.b;
            AbstractC3495c.a(unityPlayer.mActivity, unityPlayer.getFrameLayout(), this.f6544a);
        } catch (Exception e) {
            com.unity3d.player.a.t.Log(6, "Exception when opening Activity Indicator " + e);
        }
    }
}
