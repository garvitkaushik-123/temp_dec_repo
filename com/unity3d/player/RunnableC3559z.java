package com.unity3d.player;

/* renamed from: com.unity3d.player.z, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3559z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f6586a;

    public RunnableC3559z(B b) {
        this.f6586a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6586a.c.requestFocus();
        this.f6586a.c();
    }
}
