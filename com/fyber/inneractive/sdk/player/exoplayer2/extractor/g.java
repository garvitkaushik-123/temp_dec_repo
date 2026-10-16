package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class g implements r {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b f1411a;
    public final int b;
    public final e c;
    public final LinkedBlockingDeque d;
    public final d e;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n f;
    public final AtomicInteger g;
    public long h;
    public com.fyber.inneractive.sdk.player.exoplayer2.o i;
    public long j;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.a k;
    public int l;
    public boolean m;
    public f n;

    public g(com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar) {
        this.f1411a = bVar;
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) bVar).getClass();
        this.b = 65536;
        this.c = new e();
        this.d = new LinkedBlockingDeque();
        this.e = new d();
        this.f = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(32);
        this.g = new AtomicInteger();
        this.l = 65536;
    }

    public final void a(boolean z) {
        int andSet = this.g.getAndSet(z ? 0 : 2);
        a();
        e eVar = this.c;
        eVar.m = Long.MIN_VALUE;
        eVar.n = Long.MIN_VALUE;
        if (andSet == 2) {
            this.i = null;
        }
    }

    public final void b() {
        if (this.g.getAndSet(2) == 0) {
            a();
        }
    }

    public final void c() {
        if (this.g.compareAndSet(1, 0)) {
            return;
        }
        a();
    }

    public final long d() {
        long max;
        e eVar = this.c;
        synchronized (eVar) {
            max = Math.max(eVar.m, eVar.n);
        }
        return max;
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.o e() {
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar;
        e eVar = this.c;
        synchronized (eVar) {
            oVar = eVar.p ? null : eVar.q;
        }
        return oVar;
    }

    public final void f() {
        long j;
        e eVar = this.c;
        synchronized (eVar) {
            int i = eVar.i;
            if (i == 0) {
                j = -1;
            } else {
                int i2 = eVar.k + i;
                int i3 = eVar.f1408a;
                int i4 = (i2 - 1) % i3;
                eVar.k = i2 % i3;
                eVar.j += i;
                eVar.i = 0;
                j = eVar.c[i4] + eVar.d[i4];
            }
        }
        if (j != -1) {
            a(j);
        }
    }

    public final boolean a(boolean z, long j) {
        long j2;
        e eVar = this.c;
        synchronized (eVar) {
            if (eVar.i != 0) {
                long[] jArr = eVar.f;
                int i = eVar.k;
                if (j >= jArr[i]) {
                    if (j <= eVar.n || z) {
                        int i2 = -1;
                        int i3 = 0;
                        while (i != eVar.l && eVar.f[i] <= j) {
                            if ((eVar.e[i] & 1) != 0) {
                                i2 = i3;
                            }
                            i = (i + 1) % eVar.f1408a;
                            i3++;
                        }
                        if (i2 != -1) {
                            int i4 = (eVar.k + i2) % eVar.f1408a;
                            eVar.k = i4;
                            eVar.j += i2;
                            eVar.i -= i2;
                            j2 = eVar.c[i4];
                        }
                    }
                    j2 = -1;
                }
            }
            j2 = -1;
        }
        if (j2 == -1) {
            return false;
        }
        a(j2);
        return true;
    }

    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.p pVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.c cVar, boolean z, boolean z2, long j) {
        int i;
        char c;
        long j2;
        int i2;
        e eVar = this.c;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = this.i;
        d dVar = this.e;
        synchronized (eVar) {
            if (eVar.i == 0) {
                if (z2) {
                    cVar.f1400a = 4;
                    c = 65532;
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = eVar.q;
                    if (oVar2 != null && (z || oVar2 != oVar)) {
                        pVar.f1524a = oVar2;
                        c = 65531;
                    }
                }
                i = 1;
            } else {
                if (!z) {
                    com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = eVar.h;
                    int i3 = eVar.k;
                    if (oVarArr[i3] == oVar) {
                        if (cVar.c != null || cVar.e != 0) {
                            long j3 = eVar.f[i3];
                            cVar.d = j3;
                            cVar.f1400a = eVar.e[i3];
                            dVar.f1407a = eVar.d[i3];
                            i = 1;
                            dVar.b = eVar.c[i3];
                            dVar.d = eVar.g[i3];
                            eVar.m = Math.max(eVar.m, j3);
                            int i4 = eVar.i - 1;
                            eVar.i = i4;
                            int i5 = eVar.k + 1;
                            eVar.k = i5;
                            eVar.j++;
                            if (i5 == eVar.f1408a) {
                                eVar.k = 0;
                            }
                            if (i4 > 0) {
                                j2 = eVar.c[eVar.k];
                            } else {
                                j2 = dVar.b + dVar.f1407a;
                            }
                            dVar.c = j2;
                            c = 65532;
                        }
                    }
                }
                i = 1;
                pVar.f1524a = eVar.h[eVar.k];
                c = 65531;
            }
            c = 65533;
            i = 1;
        }
        if (c == 65531) {
            this.i = pVar.f1524a;
            return -5;
        }
        if (c != 65532) {
            if (c == 65533) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!cVar.b(4)) {
            if (cVar.d < j) {
                cVar.f1400a = Integer.MIN_VALUE | cVar.f1400a;
            }
            if (cVar.b(1073741824)) {
                d dVar2 = this.e;
                long j4 = dVar2.b;
                int i6 = i;
                this.f.c(i6);
                a(j4, this.f.f1591a, i6);
                long j5 = j4 + 1;
                byte b = this.f.f1591a[0];
                int i7 = (b & 128) != 0 ? i6 : 0;
                int i8 = b & Byte.MAX_VALUE;
                com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar = cVar.b;
                if (bVar.f1399a == null) {
                    bVar.f1399a = new byte[16];
                }
                a(j5, bVar.f1399a, i8);
                long j6 = j5 + i8;
                if (i7 != 0) {
                    this.f.c(2);
                    a(j6, this.f.f1591a, 2);
                    j6 += 2;
                    i2 = this.f.o();
                } else {
                    i2 = i6;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar2 = cVar.b;
                int[] iArr = bVar2.b;
                if (iArr == null || iArr.length < i2) {
                    iArr = new int[i2];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = bVar2.c;
                if (iArr3 == null || iArr3.length < i2) {
                    iArr3 = new int[i2];
                }
                int[] iArr4 = iArr3;
                if (i7 != 0) {
                    int i9 = i2 * 6;
                    this.f.c(i9);
                    a(j6, this.f.f1591a, i9);
                    j6 += i9;
                    this.f.e(0);
                    for (int i10 = 0; i10 < i2; i10++) {
                        iArr2[i10] = this.f.o();
                        iArr4[i10] = this.f.m();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = dVar2.f1407a - ((int) (j6 - dVar2.b));
                }
                com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar3 = cVar.b;
                bVar3.a(i2, iArr2, iArr4, dVar2.d, bVar3.f1399a);
                long j7 = dVar2.b;
                int i11 = (int) (j6 - j7);
                dVar2.b = j7 + i11;
                dVar2.f1407a -= i11;
            }
            int i12 = this.e.f1407a;
            ByteBuffer byteBuffer = cVar.c;
            if (byteBuffer == null) {
                cVar.c = cVar.a(i12);
            } else {
                int capacity = byteBuffer.capacity();
                int position = cVar.c.position();
                int i13 = i12 + position;
                if (capacity < i13) {
                    ByteBuffer a2 = cVar.a(i13);
                    if (position > 0) {
                        cVar.c.position(0);
                        cVar.c.limit(position);
                        a2.put(cVar.c);
                    }
                    cVar.c = a2;
                }
            }
            d dVar3 = this.e;
            long j8 = dVar3.b;
            ByteBuffer byteBuffer2 = cVar.c;
            int i14 = dVar3.f1407a;
            while (i14 > 0) {
                a(j8);
                int i15 = (int) (j8 - this.h);
                int min = Math.min(i14, this.b - i15);
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.a) this.d.peek();
                byteBuffer2.put(aVar.f1552a, aVar.b + i15, min);
                j8 += min;
                i14 -= min;
            }
            a(this.e.c);
        }
        return -4;
    }

    public final void a(long j, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            a(j);
            int i3 = (int) (j - this.h);
            int min = Math.min(i - i2, this.b - i3);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.a) this.d.peek();
            System.arraycopy(aVar.f1552a, aVar.b + i3, bArr, i2, min);
            j += min;
            i2 += min;
        }
    }

    public final void a(long j) {
        int i = ((int) (j - this.h)) / this.b;
        for (int i2 = 0; i2 < i; i2++) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar = this.f1411a;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.a) this.d.remove();
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) bVar;
            synchronized (lVar) {
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[] aVarArr = lVar.f1571a;
                aVarArr[0] = aVar;
                lVar.a(aVarArr);
            }
            this.h += this.b;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
        boolean z;
        if (oVar == null) {
            oVar = null;
        }
        e eVar = this.c;
        synchronized (eVar) {
            z = true;
            if (oVar == null) {
                eVar.p = true;
            } else {
                eVar.p = false;
                com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = eVar.q;
                int i = z.f1599a;
                if (!oVar.equals(oVar2)) {
                    eVar.q = oVar;
                }
            }
            z = false;
        }
        f fVar = this.n;
        if (fVar == null || !z) {
            return;
        }
        fVar.e();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final int a(b bVar, int i, boolean z) {
        b bVar2;
        int i2 = 0;
        if (!this.g.compareAndSet(0, 1)) {
            int min = Math.min(bVar.f, i);
            bVar.b(min);
            if (min == 0) {
                min = bVar.a(b.g, 0, Math.min(i, 4096), 0, true);
            }
            if (min != -1) {
                bVar.c += min;
            }
            if (min != -1) {
                return min;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int a2 = a(i);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = this.k;
            byte[] bArr = aVar.f1552a;
            int i3 = aVar.b + this.l;
            int i4 = bVar.f;
            if (i4 != 0) {
                int min2 = Math.min(i4, a2);
                System.arraycopy(bVar.d, 0, bArr, i3, min2);
                bVar.b(min2);
                i2 = min2;
            }
            if (i2 == 0) {
                bVar2 = bVar;
                i2 = bVar.a(bArr, i3, a2, 0, true);
            } else {
                bVar2 = bVar;
            }
            if (i2 != -1) {
                bVar2.c += i2;
            }
            if (i2 == -1) {
                if (z) {
                    return -1;
                }
                throw new EOFException();
            }
            this.l += i2;
            this.j += i2;
            return i2;
        } finally {
            c();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        if (!this.g.compareAndSet(0, 1)) {
            nVar.e(nVar.b + i);
            return;
        }
        while (i > 0) {
            int a2 = a(i);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = this.k;
            nVar.a(aVar.f1552a, aVar.b + this.l, a2);
            this.l += a2;
            this.j += a2;
            i -= a2;
        }
        c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(long j, int i, int i2, int i3, byte[] bArr) {
        if (!this.g.compareAndSet(0, 1)) {
            e eVar = this.c;
            synchronized (eVar) {
                eVar.n = Math.max(eVar.n, j);
            }
            return;
        }
        try {
            if (this.m) {
                if ((i & 1) != 0 && this.c.a(j)) {
                    this.m = false;
                }
                return;
            }
            this.c.a(j, i, (this.j - i2) - i3, i2, bArr);
        } finally {
            c();
        }
    }

    public final void a() {
        e eVar = this.c;
        eVar.j = 0;
        eVar.k = 0;
        eVar.l = 0;
        eVar.i = 0;
        eVar.o = true;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar = this.f1411a;
        LinkedBlockingDeque linkedBlockingDeque = this.d;
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) bVar).a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[]) linkedBlockingDeque.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[linkedBlockingDeque.size()]));
        this.d.clear();
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) this.f1411a).a();
        this.h = 0L;
        this.j = 0L;
        this.k = null;
        this.l = this.b;
    }

    public final int a(int i) {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar;
        if (this.l == this.b) {
            this.l = 0;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.l) this.f1411a;
            synchronized (lVar) {
                lVar.c++;
                int i2 = lVar.d;
                if (i2 > 0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[] aVarArr = lVar.e;
                    int i3 = i2 - 1;
                    lVar.d = i3;
                    aVar = aVarArr[i3];
                    aVarArr[i3] = null;
                } else {
                    aVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.a(0, new byte[65536]);
                }
            }
            this.k = aVar;
            this.d.add(aVar);
        }
        return Math.min(i, this.b - this.l);
    }
}
