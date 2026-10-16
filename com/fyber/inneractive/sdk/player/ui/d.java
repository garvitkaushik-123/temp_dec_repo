package com.fyber.inneractive.sdk.player.ui;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1641a;
    public final /* synthetic */ e b;

    public d(e eVar, boolean z) {
        this.b = eVar;
        this.f1641a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1641a == this.b.hasWindowFocus()) {
            this.b.d();
        }
    }
}
