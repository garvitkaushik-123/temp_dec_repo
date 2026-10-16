package com.unity3d.player;

/* renamed from: com.unity3d.player.x, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3555x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogC3557y f6584a;

    public RunnableC3555x(DialogC3557y dialogC3557y) {
        this.f6584a = dialogC3557y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        D d = this.f6584a.d;
        d.a(d.b(), true);
    }
}
