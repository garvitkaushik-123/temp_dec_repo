package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class u implements h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1596a;
    public long b;
    public long c;
    public com.fyber.inneractive.sdk.player.exoplayer2.s d = com.fyber.inneractive.sdk.player.exoplayer2.s.d;

    public final void a(long j) {
        this.b = j;
        if (this.f1596a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final long b() {
        long j = this.b;
        if (!this.f1596a) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        if (this.d.f1525a != 1.0f) {
            return (elapsedRealtime * r4.c) + j;
        }
        int i = com.fyber.inneractive.sdk.player.exoplayer2.b.f1396a;
        return (elapsedRealtime != -9223372036854775807L ? 1000 * elapsedRealtime : -9223372036854775807L) + j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.s a(com.fyber.inneractive.sdk.player.exoplayer2.s sVar) {
        if (this.f1596a) {
            a(b());
        }
        this.d = sVar;
        return sVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.util.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.s a() {
        return this.d;
    }
}
