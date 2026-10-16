package com.unity3d.player.a;

/* loaded from: classes7.dex */
public class x {
    public final Runnable b;

    /* renamed from: a, reason: collision with root package name */
    public w f6539a = null;
    public boolean c = true;

    public x(Runnable runnable) {
        this.b = runnable;
    }

    public void unregisterOnBackPressedCallback() {
        this.f6539a = null;
    }

    public void registerOnBackPressedCallback() {
        if (this.f6539a != null) {
            return;
        }
        this.f6539a = new w(this.b);
    }
}
