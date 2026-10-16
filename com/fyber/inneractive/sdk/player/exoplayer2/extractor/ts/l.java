package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.r f1490a;
    public final boolean b;
    public final boolean c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.o f;
    public byte[] g;
    public int h;
    public int i;
    public long j;
    public long l;
    public long p;
    public long q;
    public boolean r;
    public final SparseArray d = new SparseArray();
    public final SparseArray e = new SparseArray();
    public k m = new k();
    public k n = new k();
    public boolean k = false;
    public boolean o = false;

    public l(com.fyber.inneractive.sdk.player.exoplayer2.extractor.r rVar, boolean z, boolean z2) {
        this.f1490a = rVar;
        this.b = z;
        this.c = z2;
        byte[] bArr = new byte[128];
        this.g = bArr;
        this.f = new com.fyber.inneractive.sdk.player.exoplayer2.util.o(bArr, 0, 0);
        k kVar = this.n;
        kVar.b = false;
        kVar.f1489a = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(byte[] bArr, int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.k) {
            int i8 = i2 - i;
            byte[] bArr2 = this.g;
            int length = bArr2.length;
            int i9 = this.h + i8;
            if (length < i9) {
                this.g = Arrays.copyOf(bArr2, i9 * 2);
            }
            System.arraycopy(bArr, i, this.g, this.h, i8);
            int i10 = this.h + i8;
            this.h = i10;
            com.fyber.inneractive.sdk.player.exoplayer2.util.o oVar = this.f;
            oVar.f1592a = this.g;
            int i11 = 0;
            oVar.c = 0;
            oVar.b = i10;
            oVar.d = 0;
            oVar.a();
            if (this.f.a(8)) {
                this.f.f();
                int b = this.f.b(2);
                this.f.d(5);
                if (this.f.b()) {
                    this.f.d();
                    if (this.f.b()) {
                        int d = this.f.d();
                        if (!this.c) {
                            this.k = false;
                            k kVar = this.n;
                            kVar.e = d;
                            kVar.b = true;
                            return;
                        }
                        if (this.f.b()) {
                            int d2 = this.f.d();
                            if (this.e.indexOfKey(d2) < 0) {
                                this.k = false;
                                return;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.util.j jVar = (com.fyber.inneractive.sdk.player.exoplayer2.util.j) this.e.get(d2);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.util.k) this.d.get(jVar.f1587a);
                            if (kVar2.e) {
                                if (!this.f.a(2)) {
                                    return;
                                } else {
                                    this.f.d(2);
                                }
                            }
                            if (this.f.a(kVar2.g)) {
                                int b2 = this.f.b(kVar2.g);
                                if (kVar2.f) {
                                    z = false;
                                    z2 = false;
                                } else {
                                    if (!this.f.a(1)) {
                                        return;
                                    }
                                    z = this.f.c();
                                    if (z) {
                                        if (this.f.a(1)) {
                                            z2 = this.f.c();
                                            z3 = true;
                                            z4 = this.i != 5;
                                            if (z4) {
                                                i3 = 0;
                                            } else if (!this.f.b()) {
                                                return;
                                            } else {
                                                i3 = this.f.d();
                                            }
                                            i4 = kVar2.h;
                                            if (i4 != 0) {
                                                if (!this.f.a(kVar2.i)) {
                                                    return;
                                                }
                                                int b3 = this.f.b(kVar2.i);
                                                if (!jVar.b || z) {
                                                    i5 = 0;
                                                    i7 = b3;
                                                    i6 = 0;
                                                } else {
                                                    if (!this.f.b()) {
                                                        return;
                                                    }
                                                    i5 = this.f.e();
                                                    i7 = b3;
                                                    i6 = 0;
                                                }
                                            } else if (i4 != 1 || kVar2.j) {
                                                i5 = 0;
                                                i6 = 0;
                                                i7 = 0;
                                            } else {
                                                if (!this.f.b()) {
                                                    return;
                                                }
                                                int e = this.f.e();
                                                if (!jVar.b || z) {
                                                    i5 = 0;
                                                    i7 = 0;
                                                    i11 = e;
                                                    i6 = 0;
                                                } else {
                                                    if (!this.f.b()) {
                                                        return;
                                                    }
                                                    i7 = 0;
                                                    i11 = e;
                                                    i6 = this.f.e();
                                                    i5 = 0;
                                                }
                                            }
                                            k kVar3 = this.n;
                                            kVar3.c = kVar2;
                                            kVar3.d = b;
                                            kVar3.e = d;
                                            kVar3.f = b2;
                                            kVar3.g = d2;
                                            kVar3.h = z;
                                            kVar3.i = z3;
                                            kVar3.j = z2;
                                            kVar3.k = z4;
                                            kVar3.l = i3;
                                            kVar3.m = i7;
                                            kVar3.n = i5;
                                            kVar3.o = i11;
                                            kVar3.p = i6;
                                            kVar3.f1489a = true;
                                            kVar3.b = true;
                                            this.k = false;
                                        }
                                        return;
                                    }
                                    z2 = false;
                                }
                                z3 = z2;
                                if (this.i != 5) {
                                }
                                if (z4) {
                                }
                                i4 = kVar2.h;
                                if (i4 != 0) {
                                }
                                k kVar32 = this.n;
                                kVar32.c = kVar2;
                                kVar32.d = b;
                                kVar32.e = d;
                                kVar32.f = b2;
                                kVar32.g = d2;
                                kVar32.h = z;
                                kVar32.i = z3;
                                kVar32.j = z2;
                                kVar32.k = z4;
                                kVar32.l = i3;
                                kVar32.m = i7;
                                kVar32.n = i5;
                                kVar32.o = i11;
                                kVar32.p = i6;
                                kVar32.f1489a = true;
                                kVar32.b = true;
                                this.k = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
