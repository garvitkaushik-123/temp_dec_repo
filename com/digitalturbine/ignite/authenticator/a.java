package com.digitalturbine.ignite.authenticator;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IgniteManager f985a;

    public a(IgniteManager igniteManager) {
        this.f985a = igniteManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f985a.f984a.b();
    }
}
