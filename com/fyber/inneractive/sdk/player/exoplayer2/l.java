package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.audio.MediaCodecAudioRenderer;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class l implements Handler.Callback, com.fyber.inneractive.sdk.player.exoplayer2.source.r, com.fyber.inneractive.sdk.player.exoplayer2.source.t {
    public h A;
    public h B;
    public x C;

    /* renamed from: a, reason: collision with root package name */
    public final a[] f1513a;
    public final a[] b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i c;
    public final c d;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.u e;
    public final Handler f;
    public final HandlerThread g;
    public final Handler h;
    public final w i;
    public final v j;
    public i k;
    public s l;
    public a m;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.h n;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.u o;
    public a[] p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u = 1;
    public long v;
    public int w;
    public j x;
    public long y;
    public h z;

    public l(a[] aVarArr, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.d dVar, c cVar, boolean z, f fVar, i iVar, g gVar) {
        this.f1513a = aVarArr;
        this.c = dVar;
        this.d = cVar;
        this.r = z;
        this.h = fVar;
        this.k = iVar;
        this.b = new a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            a aVar = aVarArr[i];
            aVar.getClass();
            this.b[i] = aVar;
        }
        this.e = new com.fyber.inneractive.sdk.player.exoplayer2.util.u();
        this.p = new a[0];
        this.i = new w();
        this.j = new v();
        this.l = s.d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    public static void a(a aVar) {
        int i = aVar.c;
        if (i == 2) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            aVar.c = 1;
            aVar.j();
        }
    }

    public final void b(boolean z) {
        if (this.t != z) {
            this.t = z;
            this.h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void c(boolean z) {
        this.s = false;
        this.r = z;
        if (!z) {
            g();
            h();
            a(false);
            return;
        }
        int i = this.u;
        if (i != 3) {
            if (i == 2) {
                this.f.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.s = false;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (!uVar.f1596a) {
            uVar.c = SystemClock.elapsedRealtime();
            uVar.f1596a = true;
        }
        for (a aVar : this.p) {
            if (aVar.c != 1) {
                throw new IllegalStateException();
            }
            aVar.c = 2;
            aVar.i();
        }
        this.f.sendEmptyMessage(2);
    }

    public final synchronized void d() {
        if (this.q) {
            return;
        }
        this.f.sendEmptyMessage(6);
        while (!this.q) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.g.quit();
    }

    public final void e() {
        a(true);
        this.d.a(true);
        a(1);
        synchronized (this) {
            this.q = true;
            notifyAll();
        }
    }

    public final void f() {
        h hVar = this.B;
        if (hVar == null) {
            return;
        }
        boolean z = true;
        while (hVar != null && hVar.i) {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j a2 = hVar.p.a(hVar.o, hVar.f1509a.a());
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar.s;
            if (jVar != null) {
                for (int i = 0; i < a2.b.f1550a; i++) {
                    if (a2.a(jVar, i)) {
                    }
                }
                if (hVar == this.A) {
                    z = false;
                }
                hVar = hVar.k;
            }
            hVar.m = a2;
            if (z) {
                h hVar2 = this.A;
                h hVar3 = this.B;
                boolean z2 = hVar2 != hVar3;
                for (h hVar4 = hVar3.k; hVar4 != null; hVar4 = hVar4.k) {
                    hVar4.a();
                }
                h hVar5 = this.B;
                hVar5.k = null;
                this.z = hVar5;
                this.A = hVar5;
                boolean[] zArr = new boolean[this.f1513a.length];
                long a3 = hVar5.a(this.k.c, z2, zArr);
                if (a3 != this.k.c) {
                    this.k.c = a3;
                    a(a3);
                }
                boolean[] zArr2 = new boolean[this.f1513a.length];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    a[] aVarArr = this.f1513a;
                    if (i2 >= aVarArr.length) {
                        break;
                    }
                    a aVar = aVarArr[i2];
                    boolean z3 = aVar.c != 0;
                    zArr2[i2] = z3;
                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = this.B.c[i2];
                    if (vVar != null) {
                        i3++;
                    }
                    if (z3) {
                        if (vVar != aVar.d) {
                            if (aVar == this.m) {
                                if (vVar == null) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                                    com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar6 = this.n;
                                    uVar.getClass();
                                    uVar.a(hVar6.b());
                                    uVar.d = hVar6.a();
                                }
                                this.n = null;
                                this.m = null;
                            }
                            a(aVar);
                            aVar.c();
                        } else if (zArr[i2]) {
                            long j = this.y;
                            aVar.g = false;
                            aVar.f = false;
                            aVar.a(false, j);
                        }
                    }
                    i2++;
                }
                this.h.obtainMessage(3, hVar.m).sendToTarget();
                a(zArr2, i3);
            } else {
                this.z = hVar;
                for (h hVar7 = hVar.k; hVar7 != null; hVar7 = hVar7.k) {
                    hVar7.a();
                }
                h hVar8 = this.z;
                hVar8.k = null;
                if (hVar8.i) {
                    long j2 = hVar8.g;
                    long max = Math.max(j2, Math.abs(this.y - (hVar8.e - j2)));
                    h hVar9 = this.z;
                    hVar9.a(max, false, new boolean[hVar9.n.length]);
                }
            }
            b();
            h();
            this.f.sendEmptyMessage(2);
            return;
        }
    }

    public final void g() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (uVar.f1596a) {
            uVar.a(uVar.b());
            uVar.f1596a = false;
        }
        for (a aVar : this.p) {
            a(aVar);
        }
    }

    public final void h() {
        h hVar = this.B;
        if (hVar == null) {
            return;
        }
        long g = hVar.f1509a.g();
        if (g != -9223372036854775807L) {
            a(g);
        } else {
            a aVar = this.m;
            if (aVar == null || aVar.e()) {
                this.y = this.e.b();
            } else {
                long b = this.n.b();
                this.y = b;
                this.e.a(b);
            }
            h hVar2 = this.B;
            g = Math.abs(this.y - (hVar2.e - hVar2.g));
        }
        this.k.c = g;
        this.v = SystemClock.elapsedRealtime() * 1000;
        long c = this.p.length == 0 ? Long.MIN_VALUE : this.B.f1509a.c();
        i iVar = this.k;
        if (c == Long.MIN_VALUE) {
            long j = this.C.a(this.B.f, this.j, false).d;
        }
        iVar.getClass();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.u) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    c(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    b((j) message.obj);
                    return true;
                case 4:
                    a((s) message.obj);
                    return true;
                case 5:
                    a(true);
                    this.d.a(true);
                    a(1);
                    return true;
                case 6:
                    e();
                    return true;
                case 7:
                    a((Pair) message.obj);
                    return true;
                case 8:
                    a((com.fyber.inneractive.sdk.player.exoplayer2.source.s) message.obj);
                    return true;
                case 9:
                    com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.s) message.obj;
                    h hVar = this.z;
                    if (hVar != null && hVar.f1509a == sVar) {
                        b();
                    }
                    return true;
                case 10:
                    f();
                    return true;
                case 11:
                    a((e[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (d e) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e);
            this.h.obtainMessage(8, e).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        } catch (IOException e2) {
            Log.e("ExoPlayerImplInternal", "Source error.", e2);
            this.h.obtainMessage(8, new d(e2)).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        } catch (RuntimeException e3) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e3);
            this.h.obtainMessage(8, new d(e3)).sendToTarget();
            a(true);
            this.d.a(true);
            a(1);
            return true;
        }
    }

    public final void b(j jVar) {
        if (this.C == null) {
            this.w++;
            this.x = jVar;
            return;
        }
        Pair a2 = a(jVar);
        if (a2 == null) {
            i iVar = new i(0, 0L);
            this.k = iVar;
            this.h.obtainMessage(4, 1, 0, iVar).sendToTarget();
            this.k = new i(0, -9223372036854775807L);
            a(4);
            a(false);
            return;
        }
        int i = jVar.c == -9223372036854775807L ? 1 : 0;
        int intValue = ((Integer) a2.first).intValue();
        long longValue = ((Long) a2.second).longValue();
        try {
            i iVar2 = this.k;
            if (intValue == iVar2.f1510a && longValue / 1000 == iVar2.c / 1000) {
                return;
            }
            long a3 = a(intValue, longValue);
            int i2 = i | (longValue == a3 ? 0 : 1);
            i iVar3 = new i(intValue, a3);
            this.k = iVar3;
            this.h.obtainMessage(4, i2, 0, iVar3).sendToTarget();
        } finally {
            i iVar4 = new i(intValue, longValue);
            this.k = iVar4;
            this.h.obtainMessage(4, i, 0, iVar4).sendToTarget();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.t
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.x xVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g gVar) {
        this.f.obtainMessage(7, Pair.create(xVar, gVar)).sendToTarget();
    }

    public final void a(int i) {
        if (this.u != i) {
            this.u = i;
            this.h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar, boolean z) {
        this.h.sendEmptyMessage(0);
        a(true);
        this.d.a(false);
        if (z) {
            this.k = new i(0, -9223372036854775807L);
        }
        this.o = uVar;
        uVar.a(this);
        a(2);
        this.f.sendEmptyMessage(2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x03ac, code lost:
    
        if (r5 < r1) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03c6, code lost:
    
        if (r1.i == false) goto L239;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x018a A[LOOP:3: B:155:0x018a->B:159:0x019a, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        h hVar;
        int i;
        long j;
        boolean z;
        h hVar2;
        h hVar3;
        long j2;
        long j3;
        long j4;
        h hVar4;
        h hVar5;
        int i2;
        int i3;
        long c;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = 0;
        long j6 = -9223372036854775807L;
        if (this.C == null) {
            this.o.a();
            j = Long.MIN_VALUE;
        } else {
            h hVar6 = this.z;
            if (hVar6 == null) {
                i = this.k.f1510a;
            } else {
                int i4 = hVar6.f;
                if (!hVar6.h && hVar6.i && ((!hVar6.j || hVar6.f1509a.c() == Long.MIN_VALUE) && this.C.a(i4, this.j, false).d != -9223372036854775807L && ((hVar = this.B) == null || i4 - hVar.f != 100))) {
                    i = this.z.f + 1;
                }
                j = Long.MIN_VALUE;
                z = true;
                hVar2 = this.z;
                if (hVar2 == null && (!hVar2.i || (hVar2.j && hVar2.f1509a.c() != j))) {
                    h hVar7 = this.z;
                    if (hVar7 != null && hVar7.l) {
                        b();
                    }
                } else {
                    b(false);
                }
                if (this.B != null) {
                    while (true) {
                        h hVar8 = this.B;
                        hVar3 = this.A;
                        if (hVar8 == hVar3 || this.y < hVar8.k.e) {
                            break;
                        }
                        hVar8.a();
                        a(this.B.k);
                        h hVar9 = this.B;
                        this.k = new i(hVar9.f, hVar9.g);
                        h();
                        this.h.obtainMessage(5, this.k).sendToTarget();
                    }
                    if (hVar3.h) {
                        int i5 = 0;
                        while (true) {
                            a[] aVarArr = this.f1513a;
                            if (i5 >= aVarArr.length) {
                                break;
                            }
                            a aVar = aVarArr[i5];
                            com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = this.A.c[i5];
                            if (vVar != null && aVar.d == vVar && aVar.f) {
                                aVar.g = z;
                            }
                            i5++;
                        }
                    } else {
                        int i6 = 0;
                        while (true) {
                            a[] aVarArr2 = this.f1513a;
                            if (i6 < aVarArr2.length) {
                                a aVar2 = aVarArr2[i6];
                                com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar2 = this.A.c[i6];
                                if (aVar2.d != vVar2 || (vVar2 != null && !aVar2.f)) {
                                    break;
                                } else {
                                    i6++;
                                }
                            } else {
                                h hVar10 = this.A;
                                h hVar11 = hVar10.k;
                                if (hVar11 != null && hVar11.i) {
                                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar10.m;
                                    this.A = hVar11;
                                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar2 = hVar11.m;
                                    Object[] objArr = hVar11.f1509a.g() != -9223372036854775807L ? z ? 1 : 0 : false;
                                    int i7 = 0;
                                    while (true) {
                                        a[] aVarArr3 = this.f1513a;
                                        if (i7 >= aVarArr3.length) {
                                            break;
                                        }
                                        a aVar3 = aVarArr3[i7];
                                        if (jVar.b.b[i7] != null) {
                                            if (objArr != false) {
                                                aVar3.g = z;
                                            } else if (!aVar3.g) {
                                                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = jVar2.b.b[i7];
                                                t tVar = jVar.d[i7];
                                                j2 = j5;
                                                t tVar2 = jVar2.d[i7];
                                                if (bVar != null && tVar2.equals(tVar)) {
                                                    int length = bVar.c.length;
                                                    o[] oVarArr = new o[length];
                                                    int i8 = 0;
                                                    while (i8 < length) {
                                                        oVarArr[i8] = bVar.d[i8];
                                                        i8++;
                                                        j6 = j6;
                                                    }
                                                    j3 = j6;
                                                    h hVar12 = this.A;
                                                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar3 = hVar12.c[i7];
                                                    long j7 = hVar12.e - hVar12.g;
                                                    if (!aVar3.g) {
                                                        aVar3.d = vVar3;
                                                        aVar3.f = false;
                                                        aVar3.e = j7;
                                                        aVar3.a(oVarArr);
                                                    } else {
                                                        throw new IllegalStateException();
                                                    }
                                                } else {
                                                    j3 = j6;
                                                    aVar3.g = z;
                                                }
                                                i7++;
                                                j5 = j2;
                                                j6 = j3;
                                                z = true;
                                            }
                                        }
                                        j2 = j5;
                                        j3 = j6;
                                        i7++;
                                        j5 = j2;
                                        j6 = j3;
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i >= this.C.a()) {
                this.o.a();
                j = Long.MIN_VALUE;
                z = true;
                hVar2 = this.z;
                if (hVar2 == null) {
                }
                b(false);
                if (this.B != null) {
                }
            } else {
                if (this.z == null) {
                    j4 = this.k.c;
                    j = Long.MIN_VALUE;
                } else {
                    int i9 = this.C.a(i, this.j, false).c;
                    if (i != this.C.a(i9, this.i, 0L).c) {
                        j = Long.MIN_VALUE;
                        j4 = 0;
                    } else {
                        h hVar13 = this.z;
                        j = Long.MIN_VALUE;
                        z = true;
                        Pair a2 = a(this.C, i9, -9223372036854775807L, Math.max(0L, ((hVar13.e - hVar13.g) + this.C.a(hVar13.f, this.j, false).d) - this.y));
                        if (a2 != null) {
                            int intValue = ((Integer) a2.first).intValue();
                            long longValue = ((Long) a2.second).longValue();
                            i = intValue;
                            j4 = longValue;
                            h hVar14 = this.z;
                            long j8 = hVar14 != null ? j4 + 60000000 : (hVar14.e - hVar14.g) + this.C.a(hVar14.f, this.j, false).d;
                            this.C.a(i, this.j, z);
                            h hVar15 = new h(this.f1513a, this.b, j8, this.c, this.d, this.o, this.j.b, i, (i == this.C.a() - (z ? 1 : 0) || this.C.a(this.j.c, this.i, 0L).b) ? false : z ? 1 : 0, j4);
                            hVar4 = this.z;
                            if (hVar4 != null) {
                                hVar4.k = hVar15;
                            }
                            this.z = hVar15;
                            hVar15.f1509a.a(this);
                            b(z);
                        }
                        hVar2 = this.z;
                        if (hVar2 == null) {
                        }
                        b(false);
                        if (this.B != null) {
                        }
                    }
                }
                z = true;
                h hVar142 = this.z;
                long j82 = hVar142 != null ? j4 + 60000000 : (hVar142.e - hVar142.g) + this.C.a(hVar142.f, this.j, false).d;
                this.C.a(i, this.j, z);
                h hVar152 = new h(this.f1513a, this.b, j82, this.c, this.d, this.o, this.j.b, i, (i == this.C.a() - (z ? 1 : 0) || this.C.a(this.j.c, this.i, 0L).b) ? false : z ? 1 : 0, j4);
                hVar4 = this.z;
                if (hVar4 != null) {
                }
                this.z = hVar152;
                hVar152.f1509a.a(this);
                b(z);
                hVar2 = this.z;
                if (hVar2 == null) {
                }
                b(false);
                if (this.B != null) {
                }
            }
        }
        long j9 = j5;
        long j10 = j6;
        if (this.B == null) {
            c();
            a(elapsedRealtime, 10L);
            return;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.w.a("doSomeWork");
        h();
        com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar = this.B.f1509a;
        long j11 = this.k.c;
        sVar.getClass();
        boolean z2 = true;
        boolean z3 = true;
        for (a aVar4 : this.p) {
            aVar4.a(this.y, this.v);
            z3 = z3 && aVar4.e();
            boolean z4 = aVar4.f() || aVar4.e();
            if (!z4) {
                aVar4.d.a();
            }
            z2 = z2 && z4;
        }
        if (!z2) {
            c();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar16 = this.n;
        if (hVar16 != null) {
            s a3 = hVar16.a();
            if (!a3.equals(this.l)) {
                this.l = a3;
                com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar17 = this.n;
                uVar.getClass();
                uVar.a(hVar17.b());
                uVar.d = hVar17.a();
                this.h.obtainMessage(7, a3).sendToTarget();
            }
        }
        long j12 = this.C.a(this.B.f, this.j, false).d;
        if (z3 && ((j12 == j10 || j12 <= this.k.c) && this.B.h)) {
            a(4);
            g();
        } else {
            int i10 = this.u;
            if (i10 == 2) {
                if (this.p.length <= 0) {
                    if (j12 != j10) {
                        if (this.k.c >= j12) {
                            h hVar18 = this.B.k;
                            if (hVar18 != null) {
                            }
                        }
                    }
                    a(3);
                    if (this.r) {
                    }
                } else if (z2) {
                    boolean z5 = this.s;
                    h hVar19 = this.z;
                    if (!hVar19.i) {
                        c = hVar19.g;
                    } else {
                        c = hVar19.f1509a.c();
                    }
                    if (c == j) {
                        h hVar20 = this.z;
                        if (!hVar20.h) {
                            c = this.C.a(hVar20.f, this.j, false).d;
                        }
                        a(3);
                        if (this.r) {
                            this.s = false;
                            com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar2 = this.e;
                            if (uVar2.f1596a) {
                                i3 = 1;
                            } else {
                                uVar2.c = SystemClock.elapsedRealtime();
                                i3 = 1;
                                uVar2.f1596a = true;
                            }
                            for (a aVar5 : this.p) {
                                if (aVar5.c == i3) {
                                    aVar5.c = 2;
                                    aVar5.i();
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        }
                    }
                    c cVar = this.d;
                    h hVar21 = this.z;
                    long abs = c - Math.abs(this.y - (hVar21.e - hVar21.g));
                    long j13 = z5 ? cVar.e : cVar.d;
                    if (j13 > j9) {
                    }
                    a(3);
                    if (this.r) {
                    }
                }
                if (this.u == i2) {
                    for (a aVar6 : this.p) {
                        aVar6.d.a();
                    }
                }
                if ((!this.r && this.u == 3) || this.u == 2) {
                    a(elapsedRealtime, 10L);
                } else if (this.p.length == 0) {
                    a(elapsedRealtime, 1000L);
                } else {
                    this.f.removeMessages(2);
                }
                com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
            }
            if (i10 == 3) {
                if (!(this.p.length > 0 ? z2 : j12 == j10 || this.k.c < j12 || ((hVar5 = this.B.k) != null && hVar5.i))) {
                    this.s = this.r;
                    i2 = 2;
                    a(2);
                    g();
                    if (this.u == i2) {
                    }
                    if (!this.r) {
                    }
                    if (this.p.length == 0) {
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                }
            }
            i2 = 2;
            if (this.u == i2) {
            }
            if (!this.r) {
            }
            if (this.p.length == 0) {
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
        }
        i2 = 2;
        if (this.u == i2) {
        }
        if (!this.r) {
        }
        if (this.p.length == 0) {
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
    }

    public final void c() {
        h hVar = this.z;
        if (hVar == null || hVar.i) {
            return;
        }
        h hVar2 = this.A;
        if (hVar2 == null || hVar2.k == hVar) {
            for (a aVar : this.p) {
                if (!aVar.f) {
                    return;
                }
            }
            this.z.f1509a.d();
        }
    }

    public final void b() {
        int i;
        h hVar = this.z;
        long f = !hVar.i ? 0L : hVar.f1509a.f();
        if (f == Long.MIN_VALUE) {
            b(false);
            return;
        }
        h hVar2 = this.z;
        long abs = Math.abs(this.y - (hVar2.e - hVar2.g));
        long j = f - abs;
        c cVar = this.d;
        char c = j > cVar.c ? (char) 0 : j < cVar.b ? (char) 2 : (char) 1;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.l lVar = cVar.f1397a;
        synchronized (lVar) {
            i = lVar.c * 65536;
        }
        boolean z = c == 2 || (c == 1 && cVar.g && !(i >= cVar.f));
        cVar.g = z;
        b(z);
        if (z) {
            h hVar3 = this.z;
            hVar3.l = false;
            hVar3.f1509a.b(abs);
            return;
        }
        this.z.l = true;
    }

    public final void a(long j, long j2) {
        this.f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    public final long a(int i, long j) {
        h hVar;
        g();
        this.s = false;
        a(2);
        h hVar2 = this.B;
        if (hVar2 == null) {
            h hVar3 = this.z;
            if (hVar3 != null) {
                hVar3.a();
            }
            hVar = null;
        } else {
            hVar = null;
            while (hVar2 != null) {
                if (hVar2.f == i && hVar2.i) {
                    hVar = hVar2;
                } else {
                    hVar2.a();
                }
                hVar2 = hVar2.k;
            }
        }
        h hVar4 = this.B;
        if (hVar4 != hVar || hVar4 != this.A) {
            for (a aVar : this.p) {
                aVar.c();
            }
            this.p = new a[0];
            this.n = null;
            this.m = null;
            this.B = null;
        }
        if (hVar != null) {
            hVar.k = null;
            this.z = hVar;
            this.A = hVar;
            a(hVar);
            h hVar5 = this.B;
            if (hVar5.j) {
                j = hVar5.f1509a.a(j);
            }
            a(j);
            b();
        } else {
            this.z = null;
            this.A = null;
            this.B = null;
            a(j);
        }
        this.f.sendEmptyMessage(2);
        return j;
    }

    public final void a(long j) {
        h hVar = this.B;
        long j2 = hVar == null ? j + 60000000 : j + (hVar.e - hVar.g);
        this.y = j2;
        this.e.a(j2);
        for (a aVar : this.p) {
            long j3 = this.y;
            aVar.g = false;
            aVar.f = false;
            aVar.a(false, j3);
        }
    }

    public final void a(s sVar) {
        s a2;
        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar = this.n;
        if (hVar != null) {
            a2 = hVar.a(sVar);
        } else {
            a2 = this.e.a(sVar);
        }
        this.l = a2;
        this.h.obtainMessage(7, a2).sendToTarget();
    }

    public final void a(boolean z) {
        this.f.removeMessages(2);
        this.s = false;
        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
        if (uVar.f1596a) {
            uVar.a(uVar.b());
            uVar.f1596a = false;
        }
        this.n = null;
        this.m = null;
        this.y = 60000000L;
        for (a aVar : this.p) {
            try {
                a(aVar);
                aVar.c();
            } catch (d | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.p = new a[0];
        h hVar = this.B;
        if (hVar == null) {
            hVar = this.z;
        }
        while (hVar != null) {
            hVar.a();
            hVar = hVar.k;
        }
        this.z = null;
        this.A = null;
        this.B = null;
        b(false);
        if (z) {
            com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar2 = this.o;
            if (uVar2 != null) {
                uVar2.b();
                this.o = null;
            }
            this.C = null;
        }
    }

    public final void a(e[] eVarArr) {
        try {
            for (e eVar : eVarArr) {
                eVar.f1403a.a(eVar.b, eVar.c);
            }
            if (this.o != null) {
                this.f.sendEmptyMessage(2);
            }
            synchronized (this) {
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                notifyAll();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Pair pair) {
        boolean z;
        int i;
        ?? r9;
        h hVar;
        x xVar = this.C;
        x xVar2 = (x) pair.first;
        this.C = xVar2;
        Object obj = pair.second;
        if (xVar == null) {
            if (this.w > 0) {
                Pair a2 = a(this.x);
                int i2 = this.w;
                this.w = 0;
                this.x = null;
                if (a2 == null) {
                    i iVar = new i(0, 0L);
                    this.k = iVar;
                    this.h.obtainMessage(6, new k(this.C, obj, iVar, i2)).sendToTarget();
                    this.k = new i(0, -9223372036854775807L);
                    a(4);
                    a(false);
                    return;
                }
                this.k = new i(((Integer) a2.first).intValue(), ((Long) a2.second).longValue());
                r9 = 0;
                i = i2;
                hVar = this.B;
                if (hVar == null) {
                    hVar = this.z;
                }
                if (hVar == null) {
                    this.h.obtainMessage(6, new k(this.C, obj, this.k, i)).sendToTarget();
                    return;
                }
                int a3 = this.C.a(hVar.b);
                if (a3 == -1) {
                    int i3 = hVar.f;
                    x xVar3 = this.C;
                    int i4 = -1;
                    while (i4 == -1 && i3 < xVar.a() - 1) {
                        i3++;
                        i4 = xVar3.a(xVar.a(i3, this.j, true).b);
                    }
                    if (i4 == -1) {
                        i iVar2 = new i(r9, 0L);
                        this.k = iVar2;
                        this.h.obtainMessage(6, new k(this.C, obj, iVar2, i)).sendToTarget();
                        this.k = new i(r9, -9223372036854775807L);
                        a(4);
                        a((boolean) r9);
                        return;
                    }
                    int i5 = this.C.a(i4, this.j, (boolean) r9).c;
                    h hVar2 = hVar;
                    Pair a4 = a(this.C, 0, -9223372036854775807L, 0L);
                    int intValue = ((Integer) a4.first).intValue();
                    long longValue = ((Long) a4.second).longValue();
                    this.C.a(intValue, this.j, true);
                    Object obj2 = this.j.b;
                    hVar2.f = -1;
                    while (true) {
                        hVar2 = hVar2.k;
                        if (hVar2 != null) {
                            hVar2.f = hVar2.b.equals(obj2) ? intValue : -1;
                        } else {
                            i iVar3 = new i(intValue, a(intValue, longValue));
                            this.k = iVar3;
                            this.h.obtainMessage(6, new k(this.C, obj, iVar3, i)).sendToTarget();
                            return;
                        }
                    }
                } else {
                    h hVar3 = hVar;
                    this.C.a(a3, this.j, (boolean) r9);
                    boolean z2 = (a3 != this.C.a() - 1 || this.C.a(this.j.c, this.i, 0L).b) ? r9 : true;
                    hVar3.f = a3;
                    hVar3.h = z2;
                    boolean z3 = hVar3 == this.A ? true : r9;
                    i iVar4 = this.k;
                    if (a3 != iVar4.f1510a) {
                        i iVar5 = new i(a3, iVar4.b);
                        iVar5.c = iVar4.c;
                        this.k = iVar5;
                    }
                    int i6 = a3;
                    boolean z4 = z3;
                    h hVar4 = hVar3;
                    while (true) {
                        h hVar5 = hVar4.k;
                        if (hVar5 == null) {
                            break;
                        }
                        i6++;
                        this.C.a(i6, this.j, true);
                        boolean z5 = (i6 != this.C.a() - 1 || this.C.a(this.j.c, this.i, 0L).b) ? r9 : true;
                        if (hVar5.b.equals(this.j.b)) {
                            hVar5.f = i6;
                            hVar5.h = z5;
                            hVar4 = hVar5;
                            z4 |= hVar5 == this.A ? true : r9;
                        } else if (!z4) {
                            int i7 = this.B.f;
                            this.k = new i(i7, a(i7, this.k.c));
                        } else {
                            this.z = hVar4;
                            hVar4.k = null;
                            while (hVar5 != null) {
                                hVar5.a();
                                hVar5 = hVar5.k;
                            }
                        }
                    }
                    this.h.obtainMessage(6, new k(this.C, obj, this.k, i)).sendToTarget();
                    return;
                }
            } else if (this.k.b == -9223372036854775807L) {
                if (xVar2.c()) {
                    i iVar6 = new i(0, 0L);
                    this.k = iVar6;
                    this.h.obtainMessage(6, new k(this.C, obj, iVar6, 0)).sendToTarget();
                    this.k = new i(0, -9223372036854775807L);
                    a(4);
                    a(false);
                    return;
                }
                z = false;
                Pair a5 = a(this.C, 0, -9223372036854775807L, 0L);
                this.k = new i(((Integer) a5.first).intValue(), ((Long) a5.second).longValue());
                i = z ? 1 : 0;
                r9 = z;
                hVar = this.B;
                if (hVar == null) {
                }
                if (hVar == null) {
                }
            }
        }
        z = false;
        i = z ? 1 : 0;
        r9 = z;
        hVar = this.B;
        if (hVar == null) {
        }
        if (hVar == null) {
        }
    }

    public final Pair a(j jVar) {
        x xVar = jVar.f1511a;
        if (xVar.c()) {
            xVar = this.C;
        }
        x xVar2 = xVar;
        try {
            Pair a2 = a(xVar2, jVar.b, jVar.c, 0L);
            x xVar3 = this.C;
            if (xVar3 == xVar2) {
                return a2;
            }
            int a3 = xVar3.a(xVar2.a(((Integer) a2.first).intValue(), this.j, true).b);
            if (a3 != -1) {
                return Pair.create(Integer.valueOf(a3), (Long) a2.second);
            }
            int intValue = ((Integer) a2.first).intValue();
            x xVar4 = this.C;
            int i = -1;
            while (i == -1 && intValue < xVar2.a() - 1) {
                intValue++;
                i = xVar4.a(xVar2.a(intValue, this.j, true).b);
            }
            if (i == -1) {
                return null;
            }
            int i2 = this.C.a(i, this.j, false).c;
            return a(this.C, 0, -9223372036854775807L, 0L);
        } catch (IndexOutOfBoundsException unused) {
            throw new q();
        }
    }

    public final Pair a(x xVar, int i, long j, long j2) {
        int b = xVar.b();
        if (i >= 0 && i < b) {
            xVar.a(i, this.i, j2);
            if (j == -9223372036854775807L) {
                j = this.i.e;
                if (j == -9223372036854775807L) {
                    return null;
                }
            }
            w wVar = this.i;
            int i2 = wVar.c;
            long j3 = wVar.g + j;
            long j4 = xVar.a(i2, this.j, false).d;
            while (j4 != -9223372036854775807L && j3 >= j4 && i2 < this.i.d) {
                j3 -= j4;
                i2++;
                j4 = xVar.a(i2, this.j, false).d;
            }
            return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.s sVar2;
        h hVar = this.z;
        if (hVar == null || (sVar2 = hVar.f1509a) != sVar) {
            return;
        }
        hVar.i = true;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j a2 = hVar.p.a(hVar.o, sVar2.a());
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = hVar.s;
        if (jVar != null) {
            for (int i = 0; i < a2.b.f1550a; i++) {
                if (a2.a(jVar, i)) {
                }
            }
            hVar.g = hVar.a(hVar.g, false, new boolean[hVar.n.length]);
            if (this.B == null) {
                h hVar2 = this.z;
                this.A = hVar2;
                a(hVar2.g);
                a(this.A);
            }
            b();
        }
        hVar.m = a2;
        hVar.g = hVar.a(hVar.g, false, new boolean[hVar.n.length]);
        if (this.B == null) {
        }
        b();
    }

    public final void a(h hVar) {
        if (this.B == hVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f1513a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.f1513a;
            if (i < aVarArr.length) {
                a aVar = aVarArr[i];
                boolean z = aVar.c != 0;
                zArr[i] = z;
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = hVar.m.b.b[i];
                if (bVar != null) {
                    i2++;
                }
                if (z && (bVar == null || (aVar.g && aVar.d == this.B.c[i]))) {
                    if (aVar == this.m) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.u uVar = this.e;
                        com.fyber.inneractive.sdk.player.exoplayer2.util.h hVar2 = this.n;
                        uVar.getClass();
                        uVar.a(hVar2.b());
                        uVar.d = hVar2.a();
                        this.n = null;
                        this.m = null;
                    }
                    a(aVar);
                    aVar.c();
                }
                i++;
            } else {
                this.B = hVar;
                this.h.obtainMessage(3, hVar.m).sendToTarget();
                a(zArr, i2);
                return;
            }
        }
    }

    public final void a(boolean[] zArr, int i) {
        int i2;
        this.p = new a[i];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            a[] aVarArr = this.f1513a;
            if (i3 >= aVarArr.length) {
                return;
            }
            a aVar = aVarArr[i3];
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j jVar = this.B.m;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = jVar.b.b[i3];
            if (bVar != null) {
                int i5 = i4 + 1;
                this.p[i4] = aVar;
                if (aVar.c == 0) {
                    t tVar = jVar.d[i3];
                    boolean z = this.r && this.u == 3;
                    boolean z2 = !zArr[i3] && z;
                    int length = bVar.c.length;
                    o[] oVarArr = new o[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        oVarArr[i6] = bVar.d[i6];
                    }
                    h hVar = this.B;
                    com.fyber.inneractive.sdk.player.exoplayer2.source.v vVar = hVar.c[i3];
                    long j = this.y;
                    i2 = i3;
                    long j2 = hVar.e - hVar.g;
                    if (aVar.c == 0) {
                        aVar.b = tVar;
                        aVar.c = 1;
                        aVar.h();
                        if (!aVar.g) {
                            aVar.d = vVar;
                            aVar.f = false;
                            aVar.e = j2;
                            aVar.a(oVarArr);
                            aVar.a(z2, j);
                            com.fyber.inneractive.sdk.player.exoplayer2.util.h d = aVar.d();
                            if (d != null) {
                                if (this.n == null) {
                                    this.n = d;
                                    this.m = aVar;
                                    ((MediaCodecAudioRenderer) d).Q.a(this.l);
                                } else {
                                    throw new d(new IllegalStateException("Multiple renderer media clocks enabled."));
                                }
                            }
                            if (z) {
                                if (aVar.c == 1) {
                                    aVar.c = 2;
                                    aVar.i();
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                        } else {
                            throw new IllegalStateException();
                        }
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    i2 = i3;
                }
                i4 = i5;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
    }
}
