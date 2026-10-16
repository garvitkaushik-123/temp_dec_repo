package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.os.Looper;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.t;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.d0;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.v;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.z;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class h implements x, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final a f1428a;
    public final b0 b = new b0("HlsPlaylistTracker:MediaPlaylist");
    public final d0 c;
    public d d;
    public long e;
    public long f;
    public long g;
    public long h;
    public boolean i;
    public IOException j;
    public final /* synthetic */ k k;

    public h(k kVar, a aVar, long j) {
        this.k = kVar;
        this.f1428a = aVar;
        this.g = j;
        this.c = new d0(kVar.f1429a.f1413a.a(), com.fyber.inneractive.sdk.player.exoplayer2.util.x.a(kVar.j.f1425a, aVar.f1423a), kVar.b);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2, boolean z) {
        d0 d0Var = (d0) zVar;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d0Var.f1565a;
        long j3 = d0Var.f;
        if (fVar.b != null) {
            fVar.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.c(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
        }
    }

    public final void b() {
        this.h = 0L;
        if (this.i || this.b.a()) {
            return;
        }
        b0 b0Var = this.b;
        d0 d0Var = this.c;
        int i = this.k.c;
        b0Var.getClass();
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException();
        }
        y yVar = new y(b0Var, myLooper, d0Var, this, i, SystemClock.elapsedRealtime());
        if (b0Var.b != null) {
            throw new IllegalStateException();
        }
        b0Var.b = yVar;
        yVar.e = null;
        b0Var.f1553a.execute(yVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.i = false;
        b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(z zVar, long j, long j2) {
        d0 d0Var = (d0) zVar;
        e eVar = d0Var.d;
        if (eVar instanceof d) {
            a((d) eVar);
            com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d0Var.f1565a;
            long j3 = d0Var.f;
            if (fVar.b != null) {
                fVar.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3));
                return;
            }
            return;
        }
        this.j = new r("Loaded playlist has unexpected type.");
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final int a(z zVar, long j, long j2, IOException iOException) {
        int i;
        IOException iOException2 = iOException;
        d0 d0Var = (d0) zVar;
        boolean z = iOException2 instanceof r;
        com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar = this.k.i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = d0Var.f1565a;
        long j3 = d0Var.f;
        if (fVar.b != null) {
            iOException2 = iOException;
            fVar.f1532a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.d(fVar, kVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z));
        }
        if (z) {
            return 3;
        }
        if ((iOException2 instanceof v) && ((i = ((v) iOException2).f1578a) == 404 || i == 410)) {
            a();
            k kVar2 = this.k;
            if (kVar2.k != this.f1428a) {
                return 2;
            }
            List list = kVar2.j.b;
            int size = list.size();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) kVar2.d.get(list.get(i2));
                if (elapsedRealtime > hVar.h) {
                    kVar2.k = hVar.f1428a;
                    hVar.b();
                    return 2;
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(d dVar) {
        long j;
        long j2;
        long j3;
        int i;
        d dVar2;
        long j4;
        int i2;
        com.fyber.inneractive.sdk.player.exoplayer2.source.x xVar;
        long j5;
        int size;
        int size2;
        d dVar3 = this.d;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.e = elapsedRealtime;
        k kVar = this.k;
        kVar.getClass();
        if (dVar3 != null) {
            int i3 = dVar.g;
            int i4 = dVar3.g;
            if (i3 <= i4 && (i3 < i4 || ((size = dVar.m.size()) <= (size2 = dVar3.m.size()) && (size != size2 || !dVar.j || dVar3.j)))) {
                dVar2 = (!dVar.j || dVar3.j) ? dVar3 : new d(dVar3.b, dVar3.f1425a, dVar3.c, dVar3.d, dVar3.e, dVar3.f, dVar3.g, dVar3.h, dVar3.i, true, dVar3.k, dVar3.l, dVar3.m, dVar3.n);
                this.d = dVar2;
                if (dVar2 == dVar3) {
                    this.j = null;
                    this.f = elapsedRealtime;
                    k kVar2 = this.k;
                    a aVar = this.f1428a;
                    if (aVar == kVar2.k) {
                        if (kVar2.l == null) {
                            kVar2.m = !dVar2.j;
                        }
                        kVar2.l = dVar2;
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j jVar = kVar2.f;
                        jVar.getClass();
                        long j6 = dVar2.c;
                        if (jVar.d.m) {
                            long j7 = dVar2.j ? dVar2.d + dVar2.o : -9223372036854775807L;
                            List list = dVar2.m;
                            if (j6 != -9223372036854775807L) {
                                i2 = 0;
                            } else if (!list.isEmpty()) {
                                i2 = 0;
                                j6 = ((c) list.get(Math.max(0, list.size() - 3))).d;
                            } else {
                                i2 = 0;
                                j5 = 0;
                                xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j7, dVar2.o, dVar2.d, j5, true, !dVar2.j);
                            }
                            j5 = j6;
                            xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j7, dVar2.o, dVar2.d, j5, true, !dVar2.j);
                        } else {
                            i2 = 0;
                            long j8 = j6 == -9223372036854775807L ? 0L : j6;
                            long j9 = dVar2.d;
                            long j10 = dVar2.o;
                            xVar = new com.fyber.inneractive.sdk.player.exoplayer2.source.x(j9 + j10, j10, j9, j8, true, false);
                        }
                        t tVar = jVar.e;
                        b bVar = jVar.d.j;
                        tVar.a(xVar, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g());
                    } else {
                        i2 = 0;
                    }
                    int size3 = kVar2.g.size();
                    for (int i5 = i2; i5 < size3; i5++) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i iVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i) kVar2.g.get(i5);
                        if (iVar.m != null) {
                            l lVar = (l) iVar.j;
                            lVar.getClass();
                            lVar.f.obtainMessage(9, iVar).sendToTarget();
                        } else {
                            n[] nVarArr = iVar.n;
                            int length = nVarArr.length;
                            for (int i6 = i2; i6 < length; i6++) {
                                n nVar = nVarArr[i6];
                                if (!nVar.o) {
                                    nVar.b(nVar.w);
                                }
                            }
                        }
                    }
                    if (aVar == kVar2.k && !dVar2.j) {
                        j4 = this.d.i;
                    }
                    j4 = -9223372036854775807L;
                } else {
                    if (!dVar2.j) {
                        if (elapsedRealtime - this.f > com.fyber.inneractive.sdk.player.exoplayer2.b.a(dVar2.i) * 3.5d) {
                            String str = this.f1428a.f1423a;
                            this.j = new j();
                            a();
                        } else if (dVar.m.size() + dVar.g < this.d.g) {
                            String str2 = this.f1428a.f1423a;
                            this.j = new i();
                        }
                        j4 = this.d.i / 2;
                    }
                    j4 = -9223372036854775807L;
                }
                if (j4 == -9223372036854775807L) {
                    this.i = this.k.e.postDelayed(this, com.fyber.inneractive.sdk.player.exoplayer2.b.a(j4));
                    return;
                }
                return;
            }
        } else {
            dVar.getClass();
        }
        if (dVar.k) {
            j = dVar.d;
        } else {
            d dVar4 = kVar.l;
            j = dVar4 != null ? dVar4.d : 0L;
            if (dVar3 != null) {
                int size4 = dVar3.m.size();
                int i7 = dVar.g - dVar3.g;
                List list2 = dVar3.m;
                c cVar = i7 < list2.size() ? (c) list2.get(i7) : null;
                if (cVar != null) {
                    j2 = dVar3.d;
                    j3 = cVar.d;
                } else if (size4 == dVar.g - dVar3.g) {
                    j2 = dVar3.d;
                    j3 = dVar3.o;
                }
                j = j2 + j3;
            }
        }
        long j11 = j;
        if (dVar.e) {
            i = dVar.f;
        } else {
            d dVar5 = kVar.l;
            i = dVar5 != null ? dVar5.f : 0;
            if (dVar3 != null) {
                int i8 = dVar.g - dVar3.g;
                List list3 = dVar3.m;
                c cVar2 = i8 < list3.size() ? (c) list3.get(i8) : null;
                if (cVar2 != null) {
                    i = (dVar3.f + cVar2.c) - ((c) dVar.m.get(0)).c;
                }
            }
        }
        dVar2 = new d(dVar.b, dVar.f1425a, dVar.c, j11, true, i, dVar.g, dVar.h, dVar.i, dVar.j, dVar.k, dVar.l, dVar.m, dVar.n);
        this.d = dVar2;
        if (dVar2 == dVar3) {
        }
        if (j4 == -9223372036854775807L) {
        }
    }

    public final void a() {
        this.h = SystemClock.elapsedRealtime() + 60000;
        k kVar = this.k;
        a aVar = this.f1428a;
        int size = kVar.g.size();
        for (int i = 0; i < size; i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i iVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.i) kVar.g.get(i);
            for (n nVar : iVar.n) {
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f fVar = nVar.c;
                int a2 = fVar.f.a(aVar.b);
                if (a2 != -1) {
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = fVar.p;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= bVar.b) {
                            i2 = -1;
                            break;
                        } else if (bVar.c[i2] == a2) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1) {
                        fVar.p.a(i2);
                    }
                }
            }
            if (iVar.m != null) {
                l lVar = (l) iVar.j;
                lVar.getClass();
                lVar.f.obtainMessage(9, iVar).sendToTarget();
            } else {
                for (n nVar2 : iVar.n) {
                    if (!nVar2.o) {
                        nVar2.b(nVar2.w);
                    }
                }
            }
        }
    }
}
