package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.controller.b0;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

/* loaded from: classes4.dex */
public final class p implements s, com.fyber.inneractive.sdk.player.exoplayer2.extractor.j, com.fyber.inneractive.sdk.player.exoplayer2.upstream.x, com.fyber.inneractive.sdk.player.exoplayer2.extractor.f {
    public boolean A;
    public long C;
    public int E;
    public boolean F;
    public boolean G;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f1541a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final int c;
    public final Handler d;
    public final b0 e;
    public final t f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b g;
    public final n j;
    public r p;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.q q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public z w;
    public long x;
    public boolean[] y;
    public boolean[] z;
    public final String h = null;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0 i = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0("Loader:ExtractorMediaPeriod");
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.e k = new com.fyber.inneractive.sdk.player.exoplayer2.util.e();
    public final i l = new i(this);
    public final j m = new j(this);
    public final Handler n = new Handler();
    public long D = -9223372036854775807L;
    public final SparseArray o = new SparseArray();
    public long B = -1;

    public p(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.i[] iVarArr, int i, Handler handler, b0 b0Var, t tVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar) {
        this.f1541a = uri;
        this.b = hVar;
        this.c = i;
        this.d = handler;
        this.e = b0Var;
        this.f = tVar;
        this.g = bVar;
        this.j = new n(iVarArr, this);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, boolean z) {
        m mVar = (m) zVar;
        if (this.B == -1) {
            this.B = mVar.i;
        }
        if (z || this.v <= 0) {
            return;
        }
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i)).a(this.y[i]);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) this.p;
        lVar.getClass();
        lVar.f.obtainMessage(9, this).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final boolean b(long j) {
        boolean z = false;
        if (this.F || (this.s && this.v == 0)) {
            return false;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.e eVar = this.k;
        synchronized (eVar) {
            if (!eVar.f1584a) {
                eVar.f1584a = true;
                eVar.notifyAll();
                z = true;
            }
        }
        if (this.i.a()) {
            return z;
        }
        i();
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long c() {
        long j;
        if (this.F) {
            return Long.MIN_VALUE;
        }
        long j2 = this.D;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        int i = 0;
        if (this.A) {
            int size = this.o.size();
            j = Long.MAX_VALUE;
            while (i < size) {
                if (this.z[i]) {
                    j = Math.min(j, ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i)).d());
                }
                i++;
            }
        } else {
            int size2 = this.o.size();
            j = Long.MIN_VALUE;
            while (i < size2) {
                j = Math.max(j, ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i)).d());
                i++;
            }
        }
        return j == Long.MIN_VALUE ? this.C : j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final void d() {
        this.i.b();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.f
    public final void e() {
        this.n.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        if (this.v == 0) {
            return Long.MIN_VALUE;
        }
        return c();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long g() {
        if (!this.u) {
            return -9223372036854775807L;
        }
        this.u = false;
        return this.C;
    }

    public final int h() {
        int size = this.o.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.e eVar = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i2)).c;
            i += eVar.j + eVar.i;
        }
        return i;
    }

    public final void i() {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.q qVar;
        m mVar = new m(this, this.f1541a, this.b, this.j, this.k);
        if (this.s) {
            long j = this.D;
            if (j == -9223372036854775807L) {
                throw new IllegalStateException();
            }
            long j2 = this.x;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.F = true;
                this.D = -9223372036854775807L;
                return;
            }
            long a2 = this.q.a(j);
            long j3 = this.D;
            mVar.e.f1461a = a2;
            mVar.h = j3;
            mVar.g = true;
            this.D = -9223372036854775807L;
        }
        this.E = h();
        int i = this.c;
        if (i == -1) {
            i = (this.s && this.B == -1 && ((qVar = this.q) == null || qVar.c() == -9223372036854775807L)) ? 6 : 3;
        }
        int i2 = i;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.b0 b0Var = this.i;
        b0Var.getClass();
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.y yVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.y(b0Var, myLooper, mVar, this, i2, SystemClock.elapsedRealtime());
        if (b0Var.b != null) {
            throw new IllegalStateException();
        }
        b0Var.b = yVar;
        yVar.e = null;
        b0Var.f1553a.execute(yVar);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2) {
        m mVar = (m) zVar;
        if (this.B == -1) {
            this.B = mVar.i;
        }
        this.F = true;
        if (this.x == -9223372036854775807L) {
            int size = this.o.size();
            long j3 = Long.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                j3 = Math.max(j3, ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i)).d());
            }
            long j4 = j3 == Long.MIN_VALUE ? 0L : 10000 + j3;
            this.x = j4;
            this.f.a(new x(j4, j4, 0L, 0L, this.q.a(), false), null);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.l lVar = (com.fyber.inneractive.sdk.player.exoplayer2.l) this.p;
        lVar.getClass();
        lVar.f.obtainMessage(9, this).sendToTarget();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void b() {
        this.r = true;
        this.n.post(this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.x
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.z zVar, long j, long j2, IOException iOException) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.q qVar;
        m mVar = (m) zVar;
        if (this.B == -1) {
            this.B = mVar.i;
        }
        Handler handler = this.d;
        if (handler != null && this.e != null) {
            handler.post(new l(this, iOException));
        }
        if ((iOException instanceof a0) || (iOException instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.v)) {
            return 3;
        }
        if ((iOException instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.u) && iOException.getCause() != null && ((iOException.getCause() instanceof MalformedURLException) || (iOException.getCause() instanceof UnknownHostException))) {
            return 3;
        }
        int i = h() > this.E ? 1 : 0;
        if (this.B == -1 && ((qVar = this.q) == null || qVar.c() == -9223372036854775807L)) {
            this.C = 0L;
            this.u = this.s;
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i2)).a(!this.s || this.y[i2]);
            }
            mVar.e.f1461a = 0L;
            mVar.h = 0L;
            mVar.g = true;
        }
        this.E = h();
        return i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final void a(r rVar) {
        this.p = rVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.e eVar = this.k;
        synchronized (eVar) {
            if (!eVar.f1584a) {
                eVar.f1584a = true;
                eVar.notifyAll();
            }
        }
        i();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final z a() {
        return this.w;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, v[] vVarArr, boolean[] zArr2, long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar;
        if (this.s) {
            for (int i = 0; i < bVarArr.length; i++) {
                v vVar = vVarArr[i];
                if (vVar != null && (bVarArr[i] == null || !zArr[i])) {
                    int i2 = ((o) vVar).f1540a;
                    boolean[] zArr3 = this.y;
                    if (zArr3[i2]) {
                        this.v--;
                        zArr3[i2] = false;
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i2)).b();
                        vVarArr[i] = null;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            boolean z = false;
            for (int i3 = 0; i3 < bVarArr.length; i3++) {
                if (vVarArr[i3] == null && (bVar = bVarArr[i3]) != null) {
                    int[] iArr = bVar.c;
                    if (iArr.length == 1) {
                        if (iArr[0] == 0) {
                            z zVar = this.w;
                            y yVar = bVar.f1548a;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= zVar.f1544a) {
                                    i4 = -1;
                                    break;
                                }
                                if (zVar.b[i4] == yVar) {
                                    break;
                                }
                                i4++;
                            }
                            boolean[] zArr4 = this.y;
                            if (!zArr4[i4]) {
                                this.v++;
                                zArr4[i4] = true;
                                vVarArr[i3] = new o(this, i4);
                                zArr2[i3] = true;
                                z = true;
                            } else {
                                throw new IllegalStateException();
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
            if (!this.t) {
                int size = this.o.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (!this.y[i5]) {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i5)).b();
                    }
                }
            }
            if (this.v == 0) {
                this.u = false;
                if (this.i.a()) {
                    this.i.b.a(false);
                }
            } else if (!this.t ? j != 0 : z) {
                j = a(j);
                for (int i6 = 0; i6 < vVarArr.length; i6++) {
                    if (vVarArr[i6] != null) {
                        zArr2[i6] = true;
                    }
                }
            }
            this.t = true;
            return j;
        }
        throw new IllegalStateException();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long a(long j) {
        if (!this.q.a()) {
            j = 0;
        }
        this.C = j;
        int size = this.o.size();
        boolean z = !(this.D != -9223372036854775807L);
        for (int i = 0; z && i < size; i++) {
            if (this.y[i]) {
                z = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i)).a(false, j);
            }
        }
        if (!z) {
            this.D = j;
            this.F = false;
            if (this.i.a()) {
                this.i.b.a(false);
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.valueAt(i2)).a(this.y[i2]);
                }
            }
        }
        this.u = false;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.g a(int i, int i2) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) this.o.get(i);
        if (gVar != null) {
            return gVar;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.g(this.g);
        gVar2.n = this;
        this.o.put(i, gVar2);
        return gVar2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.j
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.q qVar) {
        this.q = qVar;
        this.n.post(this.l);
    }
}
