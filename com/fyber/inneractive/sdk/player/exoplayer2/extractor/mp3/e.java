package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* loaded from: classes4.dex */
public final class e implements b {

    /* renamed from: a, reason: collision with root package name */
    public final long f1441a;
    public final long b;
    public final long c;
    public final long[] d;
    public final long e;
    public final int f;

    public e(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f1441a = j;
        this.b = j2;
        this.c = j3;
        this.d = jArr;
        this.e = j4;
        this.f = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return this.d != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b
    public final long b(long j) {
        if (!a()) {
            return 0L;
        }
        if (j < this.f1441a) {
            return 0L;
        }
        double d = ((j - r4) * 256.0d) / this.e;
        int a2 = z.a(this.d, (long) d, false);
        int i = a2 + 1;
        long j2 = (i * this.b) / 100;
        long j3 = i == 0 ? 0L : this.d[a2];
        return j2 + ((i == 99 ? 256L : this.d[i]) == j3 ? 0L : (long) (((d - j3) * (((r7 * (a2 + 2)) / 100) - j2)) / (r15 - j3)));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        if (!a()) {
            return this.f1441a;
        }
        float f = (j * 100.0f) / this.b;
        if (f > 0.0f) {
            if (f >= 100.0f) {
                r0 = 256.0f;
            } else {
                int i = (int) f;
                r0 = i != 0 ? this.d[i - 1] : 0.0f;
                r0 += (f - i) * ((i < 99 ? this.d[i] : 256.0f) - r0);
            }
        }
        long round = Math.round(r0 * 0.00390625d * this.e);
        long j2 = this.f1441a;
        long j3 = round + j2;
        long j4 = this.c;
        return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - this.f) + this.e) - 1);
    }
}
