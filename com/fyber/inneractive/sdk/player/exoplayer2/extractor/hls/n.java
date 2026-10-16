package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.q;
import com.fyber.inneractive.sdk.player.exoplayer2.source.w;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public final class n implements x, w, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j, com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {

    /* renamed from: a, reason: collision with root package name */
    public final int f1420a;
    public final i b;
    public final f c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.o e;
    public final int f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f h;
    public boolean n;
    public boolean o;
    public int p;
    public com.fyber.inneractive.sdk.player.exoplayer2.o q;
    public int r;
    public boolean s;
    public z t;
    public int u;
    public boolean[] v;
    public long w;
    public long x;
    public boolean y;
    public final b0 g = new b0("Loader:HlsSampleStreamWrapper");
    public final d i = new d();
    public final SparseArray j = new SparseArray();
    public final LinkedList k = new LinkedList();
    public final m l = new m(this);
    public final Handler m = new Handler();

    public n(int i, i iVar, f fVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar, long j, com.fyber.inneractive.sdk.player.exoplayer2.o oVar, int i2, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2) {
        this.f1420a = i;
        this.b = iVar;
        this.c = fVar;
        this.d = bVar;
        this.e = oVar;
        this.f = i2;
        this.h = fVar2;
        this.w = j;
        this.x = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void a(q qVar) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a1, code lost:
    
        if ((r15.e + r1) > r9) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0142  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(long j) {
        int i;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar;
        h hVar;
        int i2;
        int i3;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar2;
        int i4;
        boolean z;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        long j2;
        long j3;
        boolean z2;
        int i5;
        boolean z3;
        if (this.y || this.g.a()) {
            return false;
        }
        f fVar = this.c;
        h hVar2 = this.k.isEmpty() ? null : (h) this.k.getLast();
        long j4 = this.x;
        if (j4 == -9223372036854775807L) {
            j4 = j;
        }
        d dVar = this.i;
        int a2 = hVar2 == null ? -1 : fVar.f.a(hVar2.c);
        fVar.k = null;
        if (hVar2 != null) {
            Math.max(0L, hVar2.f - j4);
        }
        fVar.p.d();
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar.p;
        int i6 = bVar.c[bVar.a()];
        boolean z4 = a2 != i6;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar3 = fVar.d[i6];
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h hVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) fVar.e.d.get(aVar3);
        if (hVar3.d == null) {
            aVar = aVar3;
        } else {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            h hVar4 = hVar2;
            boolean z5 = z4;
            long max = Math.max(30000L, com.fyber.inneractive.sdk.player.exoplayer2.b.a(hVar3.d.o));
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d dVar2 = hVar3.d;
            if (dVar2.j || (i5 = dVar2.b) == 2 || i5 == 1) {
                i = 2;
                aVar = aVar3;
            } else {
                i = 2;
                aVar = aVar3;
            }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d a3 = fVar.e.a(aVar);
            if (hVar4 == null || z5) {
                hVar = hVar4;
                if (hVar != null) {
                    j4 = hVar.f;
                }
                if (a3.j || j4 <= a3.d + a3.o) {
                    List list = a3.m;
                    Long valueOf = Long.valueOf(j4 - a3.d);
                    boolean z6 = !fVar.e.m || hVar == null;
                    int i7 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f1599a;
                    int binarySearch = Collections.binarySearch(list, valueOf);
                    if (binarySearch < 0) {
                        i2 = -(binarySearch + i);
                    } else {
                        while (true) {
                            int i8 = binarySearch - 1;
                            if (i8 < 0 || ((Comparable) list.get(i8)).compareTo(valueOf) != 0) {
                                break;
                            }
                            binarySearch = i8;
                        }
                        i2 = binarySearch;
                    }
                    if (z6) {
                        i2 = Math.max(0, i2);
                    }
                    int i9 = a3.g;
                    i3 = i2 + i9;
                    if (i3 < i9 && hVar != null) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar4 = fVar.d[a2];
                        a3 = fVar.e.a(aVar4);
                        i3 = hVar.i + 1;
                        aVar2 = aVar4;
                        i4 = a3.g;
                        if (i3 >= i4) {
                            fVar.j = new com.fyber.inneractive.sdk.player.exoplayer2.source.g();
                            j3 = -9223372036854775807L;
                            z2 = true;
                            d dVar3 = this.i;
                            z3 = dVar3.b;
                            com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar5 = dVar3.f1414a;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar6 = dVar3.c;
                            dVar3.f1414a = null;
                            dVar3.b = false;
                            dVar3.c = null;
                            if (!z3) {
                                this.y = z2;
                                return z2;
                            }
                            if (aVar5 == null) {
                                if (aVar6 == null) {
                                    return false;
                                }
                                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) this.b.f1416a.d.get(aVar6)).b();
                                return false;
                            }
                            if (aVar5 instanceof h) {
                                this.x = j3;
                                h hVar5 = (h) aVar5;
                                hVar5.D = this;
                                int i10 = hVar5.j;
                                boolean z7 = hVar5.t;
                                this.r = i10;
                                for (int i11 = 0; i11 < this.j.size(); i11++) {
                                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i11)).c.r = i10;
                                }
                                if (z7) {
                                    for (int i12 = 0; i12 < this.j.size(); i12++) {
                                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i12)).m = z2;
                                    }
                                }
                                this.k.add(hVar5);
                            }
                            b0 b0Var = this.g;
                            int i13 = this.f;
                            b0Var.getClass();
                            Looper myLooper = Looper.myLooper();
                            if (myLooper == null) {
                                throw new IllegalStateException();
                            }
                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                            y yVar = new y(b0Var, myLooper, aVar5, this, i13, elapsedRealtime2);
                            if (b0Var.b != null) {
                                throw new IllegalStateException();
                            }
                            b0Var.b = yVar;
                            yVar.e = null;
                            b0Var.f1553a.execute(yVar);
                            com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2 = this.h;
                            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2 = aVar5.f1529a;
                            int i14 = aVar5.b;
                            int i15 = this.f1420a;
                            com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar5.c;
                            int i16 = aVar5.d;
                            Object obj = aVar5.e;
                            long j5 = aVar5.f;
                            long j6 = aVar5.g;
                            if (fVar2.b != null) {
                                fVar2.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.a(fVar2, kVar2, i14, i15, oVar, i16, obj, j5, j6, elapsedRealtime2));
                            }
                            return z2;
                        }
                        int i17 = i3 - i4;
                        if (i17 < a3.m.size()) {
                            z = true;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c cVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c) a3.m.get(i17);
                            if (cVar.e) {
                                Uri a4 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(a3.f1425a, cVar.f);
                                if (!a4.equals(fVar.l)) {
                                    dVar.f1414a = new c(fVar.b, new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(a4, 0L, 0L, -1L, null, 1), fVar.d[a2].b, fVar.p.c(), fVar.p.b(), fVar.i, cVar.g);
                                } else if (!com.fyber.inneractive.sdk.player.exoplayer2.util.z.a(cVar.g, fVar.n)) {
                                    fVar.a(a4, cVar.g, fVar.m);
                                }
                            } else {
                                fVar.l = null;
                                fVar.m = null;
                                fVar.n = null;
                                fVar.o = null;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.c cVar2 = a3.l;
                            if (cVar2 != null) {
                                Uri a5 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(a3.f1425a, cVar2.f1424a);
                                long j7 = cVar2.h;
                                kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(a5, j7, j7, cVar2.i, null, 0);
                            } else {
                                kVar = null;
                            }
                            long j8 = a3.d + cVar.d;
                            int i18 = a3.f + cVar.c;
                            o oVar2 = fVar.c;
                            v vVar = (v) oVar2.f1421a.get(i18);
                            if (vVar == null) {
                                j2 = j8;
                                vVar = new v(Long.MAX_VALUE);
                                oVar2.f1421a.put(i18, vVar);
                            } else {
                                j2 = j8;
                            }
                            v vVar2 = vVar;
                            Uri a6 = com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(a3.f1425a, cVar.f1424a);
                            long j9 = cVar.h;
                            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(a6, j9, j9, cVar.i, null, 0);
                            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar6 = fVar.f1415a;
                            List list2 = fVar.g;
                            int c = fVar.p.c();
                            Object b = fVar.p.b();
                            long j10 = j2 + cVar.b;
                            boolean z8 = fVar.h;
                            byte[] bArr = fVar.m;
                            byte[] bArr2 = fVar.o;
                            j3 = -9223372036854775807L;
                            z2 = true;
                            dVar.f1414a = new h(hVar6, kVar3, kVar, aVar2, list2, c, b, j2, j10, i3, i18, z8, vVar2, hVar, bArr, bArr2);
                            d dVar32 = this.i;
                            z3 = dVar32.b;
                            com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar52 = dVar32.f1414a;
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar62 = dVar32.c;
                            dVar32.f1414a = null;
                            dVar32.b = false;
                            dVar32.c = null;
                            if (!z3) {
                            }
                        } else if (a3.j) {
                            z = true;
                            dVar.b = true;
                        } else {
                            z = true;
                            dVar.c = aVar2;
                            fVar.k = aVar2;
                        }
                        z2 = z;
                        j3 = -9223372036854775807L;
                        d dVar322 = this.i;
                        z3 = dVar322.b;
                        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar522 = dVar322.f1414a;
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar622 = dVar322.c;
                        dVar322.f1414a = null;
                        dVar322.b = false;
                        dVar322.c = null;
                        if (!z3) {
                        }
                    }
                } else {
                    i3 = a3.g + a3.m.size();
                }
            } else {
                hVar = hVar4;
                i3 = hVar.i + 1;
            }
            aVar2 = aVar;
            a2 = i6;
            i4 = a3.g;
            if (i3 >= i4) {
            }
        }
        dVar.c = aVar;
        fVar.k = aVar;
        j3 = -9223372036854775807L;
        z2 = true;
        d dVar3222 = this.i;
        z3 = dVar3222.b;
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar5222 = dVar3222.f1414a;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar6222 = dVar3222.c;
        dVar3222.f1414a = null;
        dVar3222.b = false;
        dVar3222.c = null;
        if (!z3) {
        }
    }

    public final void c(long j) {
        this.w = j;
        this.x = j;
        this.y = false;
        this.k.clear();
        if (this.g.a()) {
            this.g.b.a(false);
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i)).a(this.v[i]);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public final void e() {
        this.m.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        long j = this.x;
        if (j != -9223372036854775807L) {
            return j;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return ((h) this.k.getLast()).g;
    }

    public final void h() {
        if (this.s || this.o || !this.n) {
            return;
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            if (((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i)).e() == null) {
                return;
            }
        }
        int size2 = this.j.size();
        int i2 = 0;
        char c = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size2) {
                break;
            }
            String str = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i2)).e().f;
            char c2 = "video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 3 : "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 2 : "text".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(str)) ? (char) 1 : (char) 0;
            if (c2 > c) {
                i3 = i2;
                c = c2;
            } else if (c2 == c && i3 != -1) {
                i3 = -1;
            }
            i2++;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.y yVar = this.c.f;
        int i4 = yVar.f1543a;
        this.u = -1;
        this.v = new boolean[size2];
        com.fyber.inneractive.sdk.player.exoplayer2.source.y[] yVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.source.y[size2];
        for (int i5 = 0; i5 < size2; i5++) {
            com.fyber.inneractive.sdk.player.exoplayer2.o e = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i5)).e();
            if (i5 == i3) {
                com.fyber.inneractive.sdk.player.exoplayer2.o[] oVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.o[i4];
                for (int i6 = 0; i6 < i4; i6++) {
                    oVarArr[i6] = a(yVar.b[i6], e);
                }
                yVarArr[i5] = new com.fyber.inneractive.sdk.player.exoplayer2.source.y(oVarArr);
                this.u = i5;
            } else {
                yVarArr[i5] = new com.fyber.inneractive.sdk.player.exoplayer2.source.y(a((c == 3 && "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(e.f))) ? this.e : null, e));
            }
        }
        this.t = new z(yVarArr);
        this.o = true;
        i iVar = this.b;
        int i7 = iVar.k - 1;
        iVar.k = i7;
        if (i7 > 0) {
            return;
        }
        int i8 = 0;
        for (n nVar : iVar.n) {
            i8 += nVar.t.f1544a;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.y[] yVarArr2 = new com.fyber.inneractive.sdk.player.exoplayer2.source.y[i8];
        int i9 = 0;
        for (n nVar2 : iVar.n) {
            int i10 = nVar2.t.f1544a;
            int i11 = 0;
            while (i11 < i10) {
                yVarArr2[i9] = nVar2.t.b[i11];
                i11++;
                i9++;
            }
        }
        iVar.m = new z(yVarArr2);
        ((com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j).f.obtainMessage(8, iVar).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f1529a;
        int i = aVar.b;
        int i2 = this.f1420a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long c = aVar.c();
        if (fVar.b != null) {
            fVar.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, c));
        }
        if (z) {
            return;
        }
        int size = this.j.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.valueAt(i4)).a(this.v[i4]);
        }
        i iVar = this.b;
        iVar.getClass();
        if (iVar.m == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
        lVar.getClass();
        lVar.f.obtainMessage(9, iVar).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        f fVar = this.c;
        fVar.getClass();
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            fVar.i = cVar.i;
            fVar.a(cVar.f1529a.f1570a, cVar.l, cVar.m);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar2 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f1529a;
        int i = aVar.b;
        int i2 = this.f1420a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
        int i3 = aVar.d;
        Object obj = aVar.e;
        long j3 = aVar.f;
        long j4 = aVar.g;
        long c = aVar.c();
        if (fVar2.b != null) {
            fVar2.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar2, kVar, i, i2, oVar, i3, obj, j3, j4, j, j2, c));
        }
        if (!this.o) {
            b(this.w);
            return;
        }
        i iVar = this.b;
        iVar.getClass();
        if (iVar.m == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
        lVar.getClass();
        lVar.f.obtainMessage(9, iVar).sendToTarget();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, IOException iOException) {
        boolean z;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar;
        boolean z2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.v vVar;
        int i;
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) zVar;
        boolean z3 = aVar instanceof h;
        boolean z4 = !z3 || aVar.c() == 0;
        f fVar2 = this.c;
        if (z4) {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar2.p;
            int a2 = fVar2.f.a(aVar.c);
            int i2 = 0;
            while (true) {
                if (i2 >= bVar.b) {
                    i2 = -1;
                    break;
                }
                if (bVar.c[i2] == a2) {
                    break;
                }
                i2++;
            }
            if ((iOException instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.v) && ((i = (vVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.v) iOException).f1578a) == 404 || i == 410)) {
                z2 = bVar.a(i2);
                int i3 = vVar.f1578a;
                if (z2) {
                    Log.w("ChunkedTrackBlacklist", l.a("Blacklisted: duration=60000, responseCode=", i3, ", format=").append(bVar.d[i2]).toString());
                } else {
                    Log.w("ChunkedTrackBlacklist", l.a("Blacklisting failed (cannot blacklist last enabled track): responseCode=", i3, ", format=").append(bVar.d[i2]).toString());
                }
            } else {
                z2 = false;
            }
            if (z2) {
                if (z3) {
                    if (((h) this.k.removeLast()) == aVar) {
                        if (this.k.isEmpty()) {
                            this.x = this.w;
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
                z = true;
                fVar = this.h;
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = aVar.f1529a;
                int i4 = aVar.b;
                int i5 = this.f1420a;
                com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.c;
                int i6 = aVar.d;
                Object obj = aVar.e;
                long j3 = aVar.f;
                long j4 = aVar.g;
                long c = aVar.c();
                if (fVar.b != null) {
                    fVar.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, i4, i5, oVar, i6, obj, j3, j4, j, j2, c, iOException, z));
                }
                if (z) {
                    return 0;
                }
                if (!this.o) {
                    b(this.w);
                    return 2;
                }
                i iVar = this.b;
                iVar.getClass();
                if (iVar.m == null) {
                    return 2;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) iVar.j;
                lVar.getClass();
                lVar.f.obtainMessage(9, iVar).sendToTarget();
                return 2;
            }
        } else {
            fVar2.getClass();
        }
        z = false;
        fVar = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2 = aVar.f1529a;
        int i42 = aVar.b;
        int i52 = this.f1420a;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = aVar.c;
        int i62 = aVar.d;
        Object obj2 = aVar.e;
        long j32 = aVar.f;
        long j42 = aVar.g;
        long c2 = aVar.c();
        if (fVar.b != null) {
        }
        if (z) {
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a(int i, int i2) {
        if (this.j.indexOfKey(i) >= 0) {
            return (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.j.get(i);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.g(this.d);
        gVar.n = this;
        gVar.c.r = this.r;
        this.j.put(i, gVar);
        return gVar;
    }

    public static com.fyber.inneractive.sdk.player.exoplayer2.o a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar, com.fyber.inneractive.sdk.player.exoplayer2.o oVar2) {
        String a2;
        if (oVar == null) {
            return oVar2;
        }
        int c = com.fyber.inneractive.sdk.player.exoplayer2.util.i.c(oVar2.f);
        if (c == 1) {
            a2 = a(oVar.c, 1);
        } else {
            a2 = c == 2 ? a(oVar.c, 2) : null;
        }
        return new com.fyber.inneractive.sdk.player.exoplayer2.o(oVar.f1523a, oVar2.e, oVar2.f, a2, oVar.b, oVar2.g, oVar.j, oVar.k, oVar2.l, oVar2.m, oVar2.n, oVar2.p, oVar2.o, oVar2.q, oVar2.r, oVar2.s, oVar2.t, oVar2.u, oVar2.v, oVar.x, oVar.y, oVar2.z, oVar2.w, oVar2.h, oVar2.i, oVar2.d);
    }

    public static String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i == com.fyber.inneractive.sdk.player.exoplayer2.util.i.c(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void b() {
        this.n = true;
        this.m.post(this.l);
    }
}
