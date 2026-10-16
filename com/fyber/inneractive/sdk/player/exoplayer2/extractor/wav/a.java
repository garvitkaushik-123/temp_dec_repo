package com.fyber.inneractive.sdk.player.exoplayer2.extractor.wav;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.o;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* loaded from: classes4.dex */
public final class a implements i, q {

    /* renamed from: a, reason: collision with root package name */
    public j f1504a;
    public r b;
    public b c;
    public int d;
    public int e;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return ((this.c.h / r0.d) * 1000000) / r0.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        return d.a(bVar) != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(j jVar) {
        this.f1504a = jVar;
        this.b = jVar.a(0, 1);
        this.c = null;
        jVar.b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        this.e = 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, o oVar) {
        if (this.c == null) {
            b a2 = d.a(bVar);
            this.c = a2;
            if (a2 != null) {
                int i = a2.b;
                int i2 = a2.e * i;
                int i3 = a2.f1505a;
                this.b.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "audio/raw", i2 * i3, 32768, i3, i, a2.f, -1, -1, null, null, 0, null, null));
                this.d = this.c.d;
            } else {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unsupported or unrecognized wav header.");
            }
        }
        b bVar2 = this.c;
        if (bVar2.g == 0 || bVar2.h == 0) {
            bVar.e = 0;
            n nVar = new n(8);
            c a3 = c.a(bVar, nVar);
            while (a3.f1506a != z.a("data")) {
                Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a3.f1506a);
                long j = a3.b + 8;
                if (a3.f1506a == z.a("RIFF")) {
                    j = 12;
                }
                if (j <= 2147483647L) {
                    bVar.a((int) j);
                    a3 = c.a(bVar, nVar);
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Chunk is too large (~2GB+) to skip; id: " + a3.f1506a);
                }
            }
            bVar.a(8);
            long j2 = bVar.c;
            long j3 = a3.b;
            bVar2.g = j2;
            bVar2.h = j3;
            this.f1504a.a(this);
        }
        int a4 = this.b.a(bVar, 32768 - this.e, true);
        if (a4 != -1) {
            this.e += a4;
        }
        int i4 = this.e;
        int i5 = this.d;
        int i6 = i4 / i5;
        if (i6 > 0) {
            long j4 = ((bVar.c - i4) * 1000000) / this.c.c;
            int i7 = i6 * i5;
            int i8 = i4 - i7;
            this.e = i8;
            this.b.a(j4, 1, i7, i8, null);
        }
        return a4 == -1 ? -1 : 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        b bVar = this.c;
        long j2 = (j * bVar.c) / 1000000;
        long j3 = bVar.d;
        return Math.min((j2 / j3) * j3, bVar.h - j3) + bVar.g;
    }
}
