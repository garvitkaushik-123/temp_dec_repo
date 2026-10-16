package com.unity3d.player.a;

/* loaded from: classes7.dex */
public final class O implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f6521a;

    public O(P p) {
        this.f6521a = p;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6521a.f6522a.getView().releasePointerCapture();
    }
}
