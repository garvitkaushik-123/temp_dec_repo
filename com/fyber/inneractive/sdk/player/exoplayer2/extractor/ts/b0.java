package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class b0 implements com.fyber.inneractive.sdk.player.exoplayer2.extractor.i {
    public static final long l = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("AC-3");
    public static final long m = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("EAC3");
    public static final long n = com.fyber.inneractive.sdk.player.exoplayer2.util.z.a("HEVC");

    /* renamed from: a, reason: collision with root package name */
    public final int f1478a;
    public final List b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n c;
    public final SparseIntArray d;
    public final e e;
    public final SparseArray f;
    public final SparseBooleanArray g;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.j h;
    public int i;
    public boolean j;
    public f0 k;

    public b0(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.v vVar, e eVar) {
        this.e = eVar;
        this.f1478a = i;
        if (i == 1 || i == 2) {
            this.b = Collections.singletonList(vVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(vVar);
        }
        this.c = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(940);
        this.g = new SparseBooleanArray();
        this.f = new SparseArray();
        this.d = new SparseIntArray();
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        r1 = r1 + 1;
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        byte[] bArr = this.c.f1591a;
        bVar.a(bArr, 0, 940, false);
        int i = 0;
        while (i < 188) {
            for (int i2 = 0; i2 != 5; i2++) {
                if (bArr[(i2 * 188) + i] != 71) {
                    break;
                }
            }
            bVar.a(i);
            return true;
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.j jVar) {
        this.h = jVar;
        jVar.a(new com.fyber.inneractive.sdk.player.exoplayer2.extractor.p(-9223372036854775807L));
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    public final void a(long j, long j2) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.util.v) this.b.get(i)).c = -9223372036854775807L;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.c;
        nVar.b = 0;
        nVar.c = 0;
        this.d.clear();
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bd, code lost:
    
        if (r11 != ((r7 + 1) & 15)) goto L57;
     */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.o oVar) {
        f0 f0Var;
        int min;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.c;
        byte[] bArr = nVar.f1591a;
        int i = nVar.b;
        if (940 - i < 188) {
            int i2 = nVar.c - i;
            if (i2 > 0) {
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.c;
            nVar2.f1591a = bArr;
            nVar2.c = i2;
            nVar2.b = 0;
        }
        while (true) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar3 = this.c;
            int i3 = nVar3.c;
            int i4 = nVar3.b;
            if (i3 - i4 < 188) {
                int i5 = 940 - i3;
                int i6 = bVar.f;
                if (i6 == 0) {
                    min = 0;
                } else {
                    min = Math.min(i6, i5);
                    System.arraycopy(bVar.d, 0, bArr, i3, min);
                    bVar.b(min);
                }
                if (min == 0) {
                    bVar2 = bVar;
                    min = bVar2.a(bArr, i3, i5, 0, true);
                } else {
                    bVar2 = bVar;
                }
                if (min != -1) {
                    bVar2.c += min;
                }
                if (min == -1) {
                    return -1;
                }
                this.c.d(i3 + min);
                bVar = bVar2;
            } else {
                while (i4 < i3 && bArr[i4] != 71) {
                    i4++;
                }
                this.c.e(i4);
                int i7 = i4 + 188;
                if (i7 > i3) {
                    return 0;
                }
                int b = this.c.b();
                if ((8388608 & b) != 0) {
                    this.c.e(i7);
                    return 0;
                }
                boolean z = true;
                boolean z2 = (4194304 & b) != 0;
                int i8 = (2096896 & b) >> 8;
                boolean z3 = (b & 32) != 0;
                boolean z4 = (b & 16) != 0;
                if (this.f1478a != 2) {
                    int i9 = b & 15;
                    int i10 = this.d.get(i8, i9 - 1);
                    this.d.put(i8, i9);
                    if (i10 == i9) {
                        if (z4) {
                            this.c.e(i7);
                            return 0;
                        }
                    }
                }
                z = false;
                if (z3) {
                    int j = this.c.j();
                    com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar4 = this.c;
                    nVar4.e(nVar4.b + j);
                }
                if (z4 && (f0Var = (f0) this.f.get(i8)) != null) {
                    if (z) {
                        f0Var.a();
                    }
                    this.c.d(i7);
                    f0Var.a(this.c, z2);
                    this.c.d(i3);
                }
                this.c.e(i7);
                return 0;
            }
        }
    }

    public final void a() {
        this.g.clear();
        this.f.clear();
        this.e.getClass();
        SparseArray sparseArray = new SparseArray();
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            this.f.put(sparseArray.keyAt(i), (f0) sparseArray.valueAt(i));
        }
        this.f.put(0, new w(new z(this)));
        this.k = null;
    }
}
