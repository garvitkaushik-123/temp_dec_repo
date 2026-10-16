package com.fyber.inneractive.sdk.player.mediaplayer;

import android.view.SurfaceHolder;

/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceHolder f1625a;
    public final /* synthetic */ p b;

    public e(p pVar, SurfaceHolder surfaceHolder) {
        this.b = pVar;
        this.f1625a = surfaceHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.b, this.f1625a);
    }
}
