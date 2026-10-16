package com.fyber.inneractive.sdk.player.mediaplayer;

import android.view.Surface;

/* loaded from: classes4.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Surface f1626a;
    public final /* synthetic */ p b;

    public f(p pVar, Surface surface) {
        this.b = pVar;
        this.f1626a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.b, this.f1626a);
    }
}
