package com.fyber.inneractive.sdk.player.exoplayer2.source.chunk;

import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.h;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.k;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;

/* loaded from: classes4.dex */
public abstract class a implements z {

    /* renamed from: a, reason: collision with root package name */
    public final k f1529a;
    public final int b;
    public final o c;
    public final int d;
    public final Object e;
    public final long f;
    public final long g;
    public final h h;

    public a(int i, int i2, long j, long j2, o oVar, h hVar, k kVar, Object obj) {
        hVar.getClass();
        this.h = hVar;
        this.f1529a = kVar;
        this.b = i;
        this.c = oVar;
        this.d = i2;
        this.e = obj;
        this.f = j;
        this.g = j2;
    }

    public abstract long c();
}
