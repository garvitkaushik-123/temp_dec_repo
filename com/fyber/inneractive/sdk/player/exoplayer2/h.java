package com.fyber.inneractive.sdk.player.exoplayer2;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.s f1509a;
    public final Object b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.v[] c;
    public final boolean[] d;
    public final long e;
    public int f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public h k;
    public boolean l;
    public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j m;
    public final a[] n;
    public final a[] o;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i p;
    public final c q;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.u r;
    public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.j s;

    public h(a[] aVarArr, a[] aVarArr2, long j, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i iVar, c cVar, com.fyber.inneractive.sdk.player.exoplayer2.source.u uVar, Object obj, int i, boolean z, long j2) {
        this.n = aVarArr;
        this.o = aVarArr2;
        this.e = j;
        this.p = iVar;
        this.q = cVar;
        this.r = uVar;
        obj.getClass();
        this.b = obj;
        this.f = i;
        this.h = z;
        this.g = j2;
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.source.v[aVarArr.length];
        this.d = new boolean[aVarArr.length];
        this.f1509a = uVar.a(i, cVar.f1397a, j2);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        int i;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar = this.m.b;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= hVar.f1550a) {
                break;
            }
            boolean[] zArr2 = this.d;
            if (z || !this.m.a(this.s, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        long a2 = this.f1509a.a((com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[]) hVar.b.clone(), this.d, this.c, zArr, j);
        this.s = this.m;
        this.j = false;
        int i3 = 0;
        while (true) {
            com.fyber.inneractive.sdk.player.exoplayer2.source.v[] vVarArr = this.c;
            if (i3 >= vVarArr.length) {
                c cVar = this.q;
                a[] aVarArr = this.n;
                z zVar = this.m.f1551a;
                cVar.f = 0;
                for (int i4 = 0; i4 < aVarArr.length; i4++) {
                    if (hVar.b[i4] != null) {
                        int i5 = cVar.f;
                        int i6 = aVarArr[i4].f1380a;
                        int i7 = com.fyber.inneractive.sdk.player.exoplayer2.util.z.f1599a;
                        if (i6 == 0) {
                            i = 16777216;
                        } else if (i6 == 1) {
                            i = C.DEFAULT_AUDIO_BUFFER_SIZE;
                        } else if (i6 == 2) {
                            i = 13107200;
                        } else {
                            if (i6 != 3 && i6 != 4) {
                                throw new IllegalStateException();
                            }
                            i = 131072;
                        }
                        cVar.f = i5 + i;
                    }
                }
                cVar.f1397a.a(cVar.f);
                return a2;
            }
            if (vVarArr[i3] != null) {
                if (hVar.b[i3] == null) {
                    throw new IllegalStateException();
                }
                this.j = true;
            } else if (hVar.b[i3] != null) {
                throw new IllegalStateException();
            }
            i3++;
        }
    }

    public final void a() {
        try {
            this.r.a(this.f1509a);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
