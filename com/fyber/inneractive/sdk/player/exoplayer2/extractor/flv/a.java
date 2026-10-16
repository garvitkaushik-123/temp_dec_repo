package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class a extends e {
    public static final int[] e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public a(r rVar) {
        super(rVar);
    }

    public final boolean a(n nVar) {
        if (this.b) {
            nVar.e(nVar.b + 1);
        } else {
            int j = nVar.j();
            int i = (j >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.f1410a.a(o.a(null, "audio/mpeg", -1, -1, 1, e[(j >> 2) & 3], null, null, null));
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.f1410a.a(o.a(null, i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", -1, -1, 1, 8000, (j & 1) == 1 ? 2 : 3, -1, -1, null, null, 0, null, null));
                this.c = true;
            } else if (i != 10) {
                throw new d("Audio format not supported: " + this.d);
            }
            this.b = true;
        }
        return true;
    }

    public final void a(n nVar, long j) {
        if (this.d == 2) {
            int i = nVar.c - nVar.b;
            this.f1410a.a(i, nVar);
            this.f1410a.a(j, 1, i, 0, null);
            return;
        }
        int j2 = nVar.j();
        if (j2 == 0 && !this.c) {
            int i2 = nVar.c - nVar.b;
            byte[] bArr = new byte[i2];
            nVar.a(bArr, 0, i2);
            Pair a2 = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr);
            this.f1410a.a(o.a(null, "audio/mp4a-latm", -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(bArr), null, null));
            this.c = true;
            return;
        }
        if (this.d != 10 || j2 == 1) {
            int i3 = nVar.c - nVar.b;
            this.f1410a.a(i3, nVar);
            this.f1410a.a(j, 1, i3, 0, null);
        }
    }
}
