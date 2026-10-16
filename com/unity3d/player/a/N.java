package com.unity3d.player.a;

/* loaded from: classes7.dex */
public final class N implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f6520a;

    public N(P p) {
        this.f6520a = p;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6520a.f6522a.getView().requestPointerCapture();
    }
}
