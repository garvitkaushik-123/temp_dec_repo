package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final g f1466a = new g();
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n b = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(0, new byte[65025]);
    public int c = -1;
    public int d;
    public boolean e;

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        int i;
        int i2;
        int i3;
        if (this.e) {
            this.e = false;
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.b;
            nVar.b = 0;
            nVar.c = 0;
        }
        while (true) {
            if (this.e) {
                return true;
            }
            if (this.c < 0) {
                if (!this.f1466a.a(bVar, true)) {
                    return false;
                }
                g gVar = this.f1466a;
                int i4 = gVar.d;
                if ((gVar.f1467a & 1) == 1 && this.b.c == 0) {
                    this.d = 0;
                    int i5 = 0;
                    do {
                        int i6 = this.d;
                        g gVar2 = this.f1466a;
                        if (i6 >= gVar2.c) {
                            break;
                        }
                        int[] iArr = gVar2.f;
                        this.d = i6 + 1;
                        i3 = iArr[i6];
                        i5 += i3;
                    } while (i3 == 255);
                    i4 += i5;
                    i2 = this.d;
                } else {
                    i2 = 0;
                }
                bVar.a(i4);
                this.c = i2;
            }
            int i7 = this.c;
            this.d = 0;
            int i8 = 0;
            do {
                int i9 = this.d;
                int i10 = i7 + i9;
                g gVar3 = this.f1466a;
                if (i10 >= gVar3.c) {
                    break;
                }
                int[] iArr2 = gVar3.f;
                this.d = i9 + 1;
                i = iArr2[i10];
                i8 += i;
            } while (i == 255);
            int i11 = this.c + this.d;
            if (i8 > 0) {
                int a2 = this.b.a();
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.b;
                int i12 = nVar2.c + i8;
                if (a2 < i12) {
                    nVar2.f1591a = Arrays.copyOf(nVar2.f1591a, i12);
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.b;
                bVar.b(nVar3.f1591a, nVar3.c, i8, false);
                com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = this.b;
                nVar4.d(nVar4.c + i8);
                this.e = this.f1466a.f[i11 + (-1)] != 255;
            }
            if (i11 == this.f1466a.c) {
                i11 = -1;
            }
            this.c = i11;
        }
    }

    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.b;
        byte[] bArr = nVar.f1591a;
        if (bArr.length == 65025) {
            return;
        }
        nVar.f1591a = Arrays.copyOf(bArr, Math.max(65025, nVar.c));
    }
}
