package com.unity3d.player;

/* loaded from: classes7.dex */
public final class Z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f6508a;

    public Z0(c1 c1Var) {
        this.f6508a = c1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6508a.f6547a.onPause();
    }
}
