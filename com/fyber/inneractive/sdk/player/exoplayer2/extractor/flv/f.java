package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;

/* loaded from: classes4.dex */
public final class f extends e {
    public final n b;
    public final n c;
    public int d;
    public boolean e;
    public int f;

    public f(r rVar) {
        super(rVar);
        this.b = new n(l.f1589a);
        this.c = new n(4);
    }

    public final boolean a(n nVar) {
        int j = nVar.j();
        int i = (j >> 4) & 15;
        int i2 = j & 15;
        if (i2 != 7) {
            throw new d(m.a("Video format not supported: ", i2));
        }
        this.f = i;
        return i != 5;
    }

    public final void a(n nVar, long j) {
        int j2 = nVar.j();
        long l = (nVar.l() * 1000) + j;
        if (j2 == 0 && !this.e) {
            byte[] bArr = new byte[nVar.c - nVar.b];
            n nVar2 = new n(bArr);
            nVar.a(bArr, 0, nVar.c - nVar.b);
            com.fyber.inneractive.sdk.player.exoplayer2.video.a a2 = com.fyber.inneractive.sdk.player.exoplayer2.video.a.a(nVar2);
            this.d = a2.b;
            this.f1410a.a(o.a(null, "video/avc", -1, a2.c, a2.d, a2.f1601a, -1, a2.e, null, -1, null, null));
            this.e = true;
            return;
        }
        if (j2 == 1 && this.e) {
            byte[] bArr2 = this.c.f1591a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i = 4 - this.d;
            int i2 = 0;
            while (nVar.c - nVar.b > 0) {
                nVar.a(this.c.f1591a, i, this.d);
                this.c.e(0);
                int m = this.c.m();
                this.b.e(0);
                this.f1410a.a(4, this.b);
                this.f1410a.a(m, nVar);
                i2 = i2 + 4 + m;
            }
            this.f1410a.a(l, this.f == 1 ? 1 : 0, i2, 0, null);
        }
    }
}
