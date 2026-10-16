package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class j implements h {
    public static final double[] n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f1488a;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.r b;
    public boolean c;
    public long d;
    public final boolean[] e = new boolean[4];
    public final i f = new i();
    public boolean g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(this.e);
        i iVar = this.f;
        iVar.f1487a = false;
        iVar.b = 0;
        iVar.c = 0;
        this.j = false;
        this.g = false;
        this.h = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f1488a = e0Var.e;
        e0Var.b();
        this.b = jVar.a(e0Var.d, 2);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    public final void a(boolean z, long j) {
        boolean z2 = j != -9223372036854775807L;
        this.j = z2;
        if (z2) {
            this.i = j;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0106  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        boolean z;
        float f;
        int i;
        float f2;
        int i2;
        long j;
        int i3 = nVar.b;
        int i4 = nVar.c;
        byte[] bArr = nVar.f1591a;
        int i5 = i4 - i3;
        this.h += i5;
        this.b.a(i5, nVar);
        int i6 = i3;
        while (true) {
            int a2 = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a(bArr, i3, i4, this.e);
            if (a2 == i4) {
                break;
            }
            int i7 = a2 + 3;
            boolean z2 = nVar.f1591a[i7] & 255;
            if (!this.c) {
                int i8 = a2 - i6;
                if (i8 > 0) {
                    i iVar = this.f;
                    if (iVar.f1487a) {
                        byte[] bArr2 = iVar.d;
                        int length = bArr2.length;
                        int i9 = iVar.b + i8;
                        if (length < i9) {
                            iVar.d = Arrays.copyOf(bArr2, i9 * 2);
                        }
                        System.arraycopy(bArr, i6, iVar.d, iVar.b, i8);
                        iVar.b += i8;
                    }
                }
                int i10 = i8 < 0 ? -i8 : 0;
                i iVar2 = this.f;
                if (iVar2.f1487a) {
                    if (iVar2.c == 0 && z2 == 181) {
                        iVar2.c = iVar2.b;
                    } else {
                        int i11 = iVar2.b - i10;
                        iVar2.b = i11;
                        iVar2.f1487a = false;
                        String str = this.f1488a;
                        byte[] copyOf = Arrays.copyOf(iVar2.d, i11);
                        int i12 = copyOf[4] & 255;
                        byte b = copyOf[5];
                        int i13 = (i12 << 4) | ((b & 255) >> 4);
                        int i14 = ((b & Ascii.SI) << 8) | (copyOf[6] & 255);
                        int i15 = (copyOf[7] & 240) >> 4;
                        if (i15 == 2) {
                            f = i14 * 4;
                            i = i13 * 3;
                        } else if (i15 == 3) {
                            f = i14 * 16;
                            i = i13 * 9;
                        } else if (i15 != 4) {
                            f2 = 1.0f;
                            com.fyber.inneractive.sdk.player.exoplayer2.o a3 = com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/mpeg2", -1, i13, i14, Collections.singletonList(copyOf), -1, f2, null, -1, null, null);
                            i2 = (copyOf[7] & Ascii.SI) - 1;
                            if (i2 >= 0) {
                                double[] dArr = n;
                                if (i2 < 8) {
                                    double d = dArr[i2];
                                    byte b2 = copyOf[iVar2.c + 9];
                                    int i16 = (b2 & 96) >> 5;
                                    if (i16 != (b2 & Ascii.US)) {
                                        d *= (i16 + 1.0d) / (r5 + 1);
                                    }
                                    j = (long) (1000000.0d / d);
                                    Pair create = Pair.create(a3, Long.valueOf(j));
                                    this.b.a((com.fyber.inneractive.sdk.player.exoplayer2.o) create.first);
                                    this.d = ((Long) create.second).longValue();
                                    this.c = true;
                                }
                            }
                            j = 0;
                            Pair create2 = Pair.create(a3, Long.valueOf(j));
                            this.b.a((com.fyber.inneractive.sdk.player.exoplayer2.o) create2.first);
                            this.d = ((Long) create2.second).longValue();
                            this.c = true;
                        } else {
                            f = i14 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                            i = i13 * 100;
                        }
                        f2 = f / i;
                        com.fyber.inneractive.sdk.player.exoplayer2.o a32 = com.fyber.inneractive.sdk.player.exoplayer2.o.a(str, "video/mpeg2", -1, i13, i14, Collections.singletonList(copyOf), -1, f2, null, -1, null, null);
                        i2 = (copyOf[7] & Ascii.SI) - 1;
                        if (i2 >= 0) {
                        }
                        j = 0;
                        Pair create22 = Pair.create(a32, Long.valueOf(j));
                        this.b.a((com.fyber.inneractive.sdk.player.exoplayer2.o) create22.first);
                        this.d = ((Long) create22.second).longValue();
                        this.c = true;
                    }
                } else if (z2 == 179) {
                    iVar2.f1487a = true;
                }
            }
            if (this.c && (z2 == 184 || z2 == 0)) {
                int i17 = i4 - a2;
                if (this.g) {
                    this.b.a(this.m, this.k ? 1 : 0, ((int) (this.h - this.l)) - i17, i17, null);
                    z = false;
                    this.k = false;
                } else {
                    z = false;
                }
                if (z2 == 184) {
                    this.g = z;
                    this.k = true;
                } else {
                    this.m = this.j ? this.i : this.m + this.d;
                    this.l = this.h - i17;
                    this.j = false;
                    this.g = true;
                }
            }
            i6 = a2;
            i3 = i7;
        }
        if (this.c) {
            return;
        }
        i iVar3 = this.f;
        if (iVar3.f1487a) {
            int i18 = i4 - i6;
            byte[] bArr3 = iVar3.d;
            int length2 = bArr3.length;
            int i19 = iVar3.b + i18;
            if (length2 < i19) {
                iVar3.d = Arrays.copyOf(bArr3, i19 * 2);
            }
            System.arraycopy(bArr, i6, iVar3.d, iVar3.b, i18);
            iVar3.b += i18;
        }
    }
}
