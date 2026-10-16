package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.b0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1526a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ f d;

    public a(f fVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, int i, int i2, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i3, Object obj, long j, long j2, long j3) {
        this.d = fVar;
        this.f1526a = obj;
        this.b = j;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var = this.d.b;
        com.fyber.inneractive.sdk.player.exoplayer2.b.a(this.b);
        f.a(this.d, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadStarted called.", b0Var.a());
    }
}
