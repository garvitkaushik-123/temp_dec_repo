package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class d extends l {
    public com.fyber.inneractive.sdk.player.exoplayer2.util.f n;
    public c o;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.o = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        int i;
        int i2;
        int i3;
        byte[] bArr = nVar.f1591a;
        int i4 = -1;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i5 = (bArr[2] & 255) >> 4;
        switch (i5) {
            case 1:
                i4 = 192;
                return i4;
            case 2:
            case 3:
            case 4:
            case 5:
                i = i5 - 2;
                i2 = 576;
                i4 = i2 << i;
                return i4;
            case 6:
            case 7:
                nVar.e(nVar.b + 4);
                long j = nVar.f1591a[nVar.b];
                int i6 = 7;
                while (true) {
                    if (i6 >= 0) {
                        if (((1 << i6) & j) != 0) {
                            i6--;
                        } else if (i6 < 6) {
                            j &= r8 - 1;
                            i3 = 7 - i6;
                        } else if (i6 == 7) {
                            i3 = 1;
                        }
                    }
                }
                i3 = 0;
                if (i3 != 0) {
                    for (int i7 = 1; i7 < i3; i7++) {
                        if ((nVar.f1591a[nVar.b + i7] & 192) != 128) {
                            throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                        }
                        j = (j << 6) | (r8 & 63);
                    }
                    nVar.b += i3;
                    int j2 = i5 == 6 ? nVar.j() : nVar.o();
                    nVar.e(0);
                    i4 = j2 + 1;
                    return i4;
                }
                throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i = i5 - 8;
                i2 = 256;
                i4 = i2 << i;
                return i4;
            default:
                return i4;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.l
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar, long j, j jVar) {
        byte[] bArr = nVar.f1591a;
        if (this.n == null) {
            this.n = new com.fyber.inneractive.sdk.player.exoplayer2.util.f(bArr);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 9, nVar.c);
            copyOfRange[4] = Byte.MIN_VALUE;
            List singletonList = Collections.singletonList(copyOfRange);
            com.fyber.inneractive.sdk.player.exoplayer2.util.f fVar = this.n;
            int i = fVar.c;
            int i2 = fVar.f1585a;
            jVar.f1468a = com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "audio/flac", -1, i * i2, fVar.b, i2, singletonList, null, null);
        } else {
            byte b = bArr[0];
            if ((b & Byte.MAX_VALUE) == 3) {
                c cVar = new c(this);
                this.o = cVar;
                nVar.e(nVar.b + 1);
                int l = nVar.l() / 18;
                cVar.f1464a = new long[l];
                cVar.b = new long[l];
                for (int i3 = 0; i3 < l; i3++) {
                    cVar.f1464a[i3] = nVar.g();
                    cVar.b[i3] = nVar.g();
                    nVar.e(nVar.b + 2);
                }
            } else if (b == -1) {
                c cVar2 = this.o;
                if (cVar2 != null) {
                    cVar2.c = j;
                    jVar.b = cVar2;
                }
                return false;
            }
        }
        return true;
    }
}
