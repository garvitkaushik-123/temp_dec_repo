package com.unity3d.player;

/* loaded from: classes7.dex */
public final class Y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6505a;

    public Y(UnityPlayer unityPlayer) {
        this.f6505a = unityPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6505a.setupUnityToBePaused();
        this.f6505a.windowFocusChanged(false);
        this.f6505a.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
