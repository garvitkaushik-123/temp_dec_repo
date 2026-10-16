package com.unity3d.player;

import android.app.Activity;

/* renamed from: com.unity3d.player.j0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3529j0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6562a;

    public RunnableC3529j0(UnityPlayer unityPlayer) {
        this.f6562a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean nativeIsAutorotationOn;
        UnityPlayer unityPlayer;
        Activity activity;
        int i;
        nativeIsAutorotationOn = this.f6562a.nativeIsAutorotationOn();
        if (!nativeIsAutorotationOn || (activity = (unityPlayer = this.f6562a).mActivity) == null) {
            return;
        }
        i = unityPlayer.mInitialScreenOrientation;
        activity.setRequestedOrientation(i);
    }
}
