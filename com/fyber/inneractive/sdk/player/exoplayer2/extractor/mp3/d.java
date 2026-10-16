package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* loaded from: classes4.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f1440a;
    public final long[] b;
    public final long c;

    public d(long[] jArr, long[] jArr2, long j) {
        this.f1440a = jArr;
        this.b = jArr2;
        this.c = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b
    public final long b(long j) {
        return this.f1440a[z.a(this.b, j, true)];
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        return this.b[z.a(this.f1440a, j, true)];
    }
}
