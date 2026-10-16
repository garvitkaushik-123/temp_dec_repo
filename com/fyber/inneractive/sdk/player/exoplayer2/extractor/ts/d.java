package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class d implements h {
    public static final byte[] r = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1481a;
    public final String d;
    public String e;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r f;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r g;
    public boolean k;
    public boolean l;
    public long m;
    public int n;
    public long o;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r p;
    public long q;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.m b = new com.fyber.inneractive.sdk.player.exoplayer2.util.m(new byte[7]);
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(Arrays.copyOf(r, 10));
    public int h = 0;
    public int i = 0;
    public int j = 256;

    public d(boolean z, String str) {
        this.f1481a = z;
        this.d = str;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        while (true) {
            int i = nVar.c;
            int i2 = nVar.b;
            int i3 = i - i2;
            if (i3 <= 0) {
                return;
            }
            int i4 = this.h;
            if (i4 == 0) {
                byte[] bArr = nVar.f1591a;
                while (true) {
                    if (i2 >= i) {
                        nVar.e(i2);
                        break;
                    }
                    int i5 = i2 + 1;
                    byte b = bArr[i2];
                    int i6 = b & 255;
                    int i7 = this.j;
                    if (i7 != 512 || i6 < 240 || i6 == 255) {
                        int i8 = i7 | i6;
                        if (i8 == 329) {
                            this.j = 768;
                        } else if (i8 == 511) {
                            this.j = 512;
                        } else if (i8 == 836) {
                            this.j = 1024;
                        } else {
                            if (i8 == 1075) {
                                this.h = 1;
                                this.i = 3;
                                this.n = 0;
                                this.c.e(0);
                                nVar.e(i5);
                                break;
                            }
                            if (i7 != 256) {
                                this.j = 256;
                            }
                        }
                        i2 = i5;
                    } else {
                        this.k = (b & 1) == 0;
                        this.h = 2;
                        this.i = 0;
                        nVar.e(i5);
                    }
                }
            } else if (i4 == 1) {
                byte[] bArr2 = this.c.f1591a;
                int min = Math.min(i3, 10 - this.i);
                nVar.a(bArr2, this.i, min);
                int i9 = this.i + min;
                this.i = i9;
                if (i9 == 10) {
                    this.g.a(10, this.c);
                    this.c.e(6);
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar = this.g;
                    int i10 = this.c.i() + 10;
                    this.h = 3;
                    this.i = 10;
                    this.p = rVar;
                    this.q = 0L;
                    this.n = i10;
                }
            } else if (i4 == 2) {
                int i11 = this.k ? 7 : 5;
                byte[] bArr3 = this.b.f1590a;
                int min2 = Math.min(i3, i11 - this.i);
                nVar.a(bArr3, this.i, min2);
                int i12 = this.i + min2;
                this.i = i12;
                if (i12 == i11) {
                    this.b.b(0);
                    if (this.l) {
                        this.b.c(10);
                    } else {
                        int a2 = this.b.a(2) + 1;
                        if (a2 != 2) {
                            Log.w("AdtsReader", "Detected audio object type: " + a2 + ", but assuming AAC LC.");
                            a2 = 2;
                        }
                        int a3 = this.b.a(4);
                        this.b.c(1);
                        byte[] bArr4 = {(byte) (((a2 << 3) & 248) | ((a3 >> 1) & 7)), (byte) (((a3 << 7) & 128) | ((this.b.a(3) << 3) & 120))};
                        Pair a4 = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr4);
                        com.fyber.inneractive.sdk.player.exoplayer2.o a5 = com.fyber.inneractive.sdk.player.exoplayer2.o.a(this.e, "audio/mp4a-latm", -1, -1, ((Integer) a4.second).intValue(), ((Integer) a4.first).intValue(), Collections.singletonList(bArr4), null, this.d);
                        this.m = 1024000000 / a5.s;
                        this.f.a(a5);
                        this.l = true;
                    }
                    this.b.c(4);
                    int a6 = this.b.a(13);
                    int i13 = a6 - 7;
                    if (this.k) {
                        i13 = a6 - 9;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar2 = this.f;
                    long j = this.m;
                    this.h = 3;
                    this.i = 0;
                    this.p = rVar2;
                    this.q = j;
                    this.n = i13;
                }
            } else if (i4 == 3) {
                int min3 = Math.min(i3, this.n - this.i);
                this.p.a(min3, nVar);
                int i14 = this.i + min3;
                this.i = i14;
                int i15 = this.n;
                if (i14 == i15) {
                    this.p.a(this.o, 1, i15, 0, null);
                    this.o += this.q;
                    this.h = 0;
                    this.i = 0;
                    this.j = 256;
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.e = e0Var.e;
        e0Var.b();
        this.f = jVar.a(e0Var.d, 1);
        if (this.f1481a) {
            e0Var.a();
            e0Var.b();
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a2 = jVar.a(e0Var.d, 4);
            this.g = a2;
            e0Var.b();
            a2.a(com.fyber.inneractive.sdk.player.exoplayer2.o.a(e0Var.e, "application/id3", (com.fyber.inneractive.sdk.player.exoplayer2.drm.d) null));
            return;
        }
        this.g = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.h();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        this.o = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        this.h = 0;
        this.i = 0;
        this.j = 256;
    }
}
