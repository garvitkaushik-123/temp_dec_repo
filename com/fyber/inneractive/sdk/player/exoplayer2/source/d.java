package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.b0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1530a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ IOException d;
    public final /* synthetic */ f e;

    public d(f fVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, int i, int i2, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        this.e = fVar;
        this.f1530a = obj;
        this.b = j;
        this.c = j2;
        this.d = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b0 b0Var = this.e.b;
        com.fyber.inneractive.sdk.player.exoplayer2.b.a(this.b);
        f.a(this.e, this.c);
        IAlog.a("%s AdaptiveMediaSourceEventListener onLoadError called. with exception %s", b0Var.a(), this.d);
    }
}
