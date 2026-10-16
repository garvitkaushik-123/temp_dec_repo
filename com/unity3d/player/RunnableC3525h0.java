package com.unity3d.player;

/* renamed from: com.unity3d.player.h0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3525h0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6558a;

    public RunnableC3525h0(String str) {
        this.f6558a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer.nativeSetLaunchURL(this.f6558a);
    }
}
