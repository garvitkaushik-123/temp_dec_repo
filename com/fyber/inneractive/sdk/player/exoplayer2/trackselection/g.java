package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class g extends i {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f1549a = new SparseArray();
    public final SparseBooleanArray b = new SparseBooleanArray();

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01cc, code lost:
    
        if (r8 == (-1)) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01de, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01dc, code lost:
    
        if (r9 == (-1)) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01bd  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j a(com.fyber.inneractive.sdk.player.exoplayer2.a[] aVarArr, z zVar) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int[][] iArr;
        int i3;
        boolean z3;
        c cVar;
        int[][][] iArr2;
        int i4;
        int i5;
        y yVar;
        ArrayList arrayList;
        boolean z4;
        int i6;
        boolean a2;
        boolean z5;
        int i7;
        int i8;
        int i9;
        boolean z6;
        int[] iArr3;
        boolean z7 = true;
        int[] iArr4 = new int[aVarArr.length + 1];
        int length = aVarArr.length + 1;
        y[][] yVarArr = new y[length][];
        int[][][] iArr5 = new int[aVarArr.length + 1][][];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = zVar.f1544a;
            yVarArr[i10] = new y[i11];
            iArr5[i10] = new int[i11][];
        }
        int length2 = aVarArr.length;
        int[] iArr6 = new int[length2];
        for (int i12 = 0; i12 < length2; i12++) {
            aVarArr[i12].getClass();
            iArr6[i12] = 4;
        }
        int i13 = 0;
        while (i13 < zVar.f1544a) {
            y yVar2 = zVar.b[i13];
            int length3 = aVarArr.length;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (i14 >= aVarArr.length) {
                    z6 = z7;
                    break;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.a aVar = aVarArr[i14];
                int i16 = 0;
                while (i16 < yVar2.f1543a) {
                    o oVar = yVar2.b[i16];
                    z6 = z7;
                    com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) aVar;
                    cVar2.getClass();
                    try {
                        int b = cVar2.b(cVar2.h, oVar) & 3;
                        if (b > i15) {
                            if (b == 3) {
                                length3 = i14;
                                break;
                            }
                            i15 = b;
                            length3 = i14;
                        }
                        i16++;
                        z7 = z6;
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.f e) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e);
                    }
                }
                i14++;
            }
            if (length3 == aVarArr.length) {
                iArr3 = new int[yVar2.f1543a];
            } else {
                com.fyber.inneractive.sdk.player.exoplayer2.a aVar2 = aVarArr[length3];
                int[] iArr7 = new int[yVar2.f1543a];
                for (int i17 = 0; i17 < yVar2.f1543a; i17++) {
                    o oVar2 = yVar2.b[i17];
                    com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c cVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.c) aVar2;
                    cVar3.getClass();
                    try {
                        iArr7[i17] = cVar3.b(cVar3.h, oVar2);
                    } catch (com.fyber.inneractive.sdk.player.exoplayer2.mediacodec.f e2) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.d(e2);
                    }
                }
                iArr3 = iArr7;
            }
            int i18 = iArr4[length3];
            yVarArr[length3][i18] = yVar2;
            iArr5[length3][i18] = iArr3;
            iArr4[length3] = i18 + 1;
            i13++;
            z7 = z6;
        }
        boolean z8 = z7;
        z[] zVarArr = new z[aVarArr.length];
        int[] iArr8 = new int[aVarArr.length];
        for (int i19 = 0; i19 < aVarArr.length; i19++) {
            int i20 = iArr4[i19];
            zVarArr[i19] = new z((y[]) Arrays.copyOf(yVarArr[i19], i20));
            iArr5[i19] = (int[][]) Arrays.copyOf(iArr5[i19], i20);
            iArr8[i19] = aVarArr[i19].f1380a;
        }
        new z((y[]) Arrays.copyOf(yVarArr[aVarArr.length], iArr4[aVarArr.length]));
        int length4 = aVarArr.length;
        b[] bVarArr = new b[length4];
        c cVar4 = (c) ((d) this).c.get();
        int i21 = 0;
        boolean z9 = false;
        while (i21 < length4) {
            if (2 == aVarArr[i21].f1380a) {
                if (z9) {
                    cVar = cVar4;
                    iArr2 = iArr5;
                    i4 = i21;
                } else {
                    z zVar2 = zVarArr[i21];
                    int[][] iArr9 = iArr5[i21];
                    cVar4.getClass();
                    y yVar3 = null;
                    int i22 = 0;
                    int i23 = 0;
                    int i24 = 0;
                    int i25 = -1;
                    int i26 = -1;
                    while (i22 < zVar2.f1544a) {
                        y yVar4 = zVar2.b[i22];
                        c cVar5 = cVar4;
                        ArrayList arrayList2 = new ArrayList(yVar4.f1543a);
                        int[][][] iArr10 = iArr5;
                        for (int i27 = 0; i27 < yVar4.f1543a; i27++) {
                            arrayList2.add(Integer.valueOf(i27));
                        }
                        int[] iArr11 = iArr9[i22];
                        int i28 = i24;
                        int i29 = i25;
                        int i30 = i21;
                        int i31 = i29;
                        int i32 = i26;
                        z zVar3 = zVar2;
                        int i33 = i32;
                        y yVar5 = yVar3;
                        int i34 = 0;
                        while (i34 < yVar4.f1543a) {
                            int i35 = i34;
                            if (d.a(iArr11[i34], z8)) {
                                o oVar3 = yVar4.b[i35];
                                if (arrayList2.contains(Integer.valueOf(i35))) {
                                    int i36 = oVar3.j;
                                    yVar = yVar4;
                                    arrayList = arrayList2;
                                    if ((i36 == -1 || i36 <= Integer.MAX_VALUE) && (((i8 = oVar3.k) == -1 || i8 <= Integer.MAX_VALUE) && ((i9 = oVar3.b) == -1 || i9 <= Integer.MAX_VALUE))) {
                                        z4 = true;
                                        i6 = !z4 ? 2 : 1;
                                        boolean z10 = z4;
                                        a2 = d.a(iArr11[i35], false);
                                        if (a2) {
                                            i6 += 1000;
                                        }
                                        z5 = i6 <= i28;
                                        if (i6 != i28) {
                                            if (oVar3.b() != i31) {
                                                int b2 = oVar3.b();
                                                i5 = i28;
                                                i7 = -1;
                                                if (b2 != -1) {
                                                    if (i31 != -1) {
                                                        i7 = b2 - i31;
                                                    }
                                                    i7 = 1;
                                                }
                                                z5 = a2 || !z10 ? i7 < 0 : i7 > 0;
                                            } else {
                                                i5 = i28;
                                                i7 = -1;
                                                int i37 = oVar3.b;
                                                if (i37 != -1) {
                                                    if (i33 != -1) {
                                                        i7 = i37 - i33;
                                                    }
                                                    i7 = 1;
                                                }
                                                if (a2) {
                                                }
                                            }
                                            i34 = i35 + 1;
                                            yVar4 = yVar;
                                            arrayList2 = arrayList;
                                            z8 = true;
                                        } else {
                                            i5 = i28;
                                        }
                                        if (z5) {
                                            i33 = oVar3.b;
                                            i31 = oVar3.b();
                                            i28 = i6;
                                            i23 = i35;
                                            yVar5 = yVar;
                                            i34 = i35 + 1;
                                            yVar4 = yVar;
                                            arrayList2 = arrayList;
                                            z8 = true;
                                        }
                                    }
                                } else {
                                    yVar = yVar4;
                                    arrayList = arrayList2;
                                }
                                z4 = false;
                                if (!z4) {
                                }
                                boolean z102 = z4;
                                a2 = d.a(iArr11[i35], false);
                                if (a2) {
                                }
                                if (i6 <= i28) {
                                }
                                if (i6 != i28) {
                                }
                                if (z5) {
                                }
                            } else {
                                i5 = i28;
                                yVar = yVar4;
                                arrayList = arrayList2;
                            }
                            i28 = i5;
                            i34 = i35 + 1;
                            yVar4 = yVar;
                            arrayList2 = arrayList;
                            z8 = true;
                        }
                        int i38 = i28;
                        i22++;
                        i25 = i31;
                        i21 = i30;
                        i26 = i33;
                        zVar2 = zVar3;
                        cVar4 = cVar5;
                        iArr5 = iArr10;
                        yVar3 = yVar5;
                        i24 = i38;
                        z8 = true;
                    }
                    cVar = cVar4;
                    iArr2 = iArr5;
                    i4 = i21;
                    e eVar = yVar3 == null ? null : new e(yVar3, i23);
                    bVarArr[i4] = eVar;
                    z9 = eVar != null;
                }
                int i39 = zVarArr[i4].f1544a;
            } else {
                cVar = cVar4;
                iArr2 = iArr5;
                i4 = i21;
            }
            i21 = i4 + 1;
            cVar4 = cVar;
            iArr5 = iArr2;
            z8 = true;
        }
        c cVar6 = cVar4;
        int[][][] iArr12 = iArr5;
        boolean z11 = false;
        boolean z12 = false;
        int i40 = 0;
        while (i40 < length4) {
            int i41 = aVarArr[i40].f1380a;
            if (i41 == 1) {
                z = z11;
                i = length4;
                z2 = z12;
                if (!z2) {
                    z zVar4 = zVarArr[i40];
                    int[][] iArr13 = iArr12[i40];
                    cVar6.getClass();
                    int i42 = 0;
                    int i43 = 0;
                    int i44 = -1;
                    int i45 = -1;
                    while (i42 < zVar4.f1544a) {
                        y yVar6 = zVar4.b[i42];
                        int[] iArr14 = iArr13[i42];
                        int i46 = i45;
                        int i47 = 0;
                        while (i47 < yVar6.f1543a) {
                            int[][] iArr15 = iArr13;
                            if (d.a(iArr14[i47], true)) {
                                o oVar4 = yVar6.b[i47];
                                int i48 = iArr14[i47];
                                int i49 = (oVar4.x & 1) != 0 ? 2 : 1;
                                i2 = i42;
                                if (d.a(i48, false)) {
                                    i49 += 1000;
                                }
                                if (i49 > i43) {
                                    i44 = i47;
                                    i43 = i49;
                                    i46 = i2;
                                }
                            } else {
                                i2 = i42;
                            }
                            i47++;
                            i42 = i2;
                            iArr13 = iArr15;
                        }
                        i42++;
                        i45 = i46;
                        iArr13 = iArr13;
                    }
                    e eVar2 = i45 == -1 ? null : new e(zVar4.b[i45], i44);
                    bVarArr[i40] = eVar2;
                    z2 = eVar2 != null;
                    z11 = z;
                    i40++;
                    length4 = i;
                    z12 = z2;
                }
            } else if (i41 == 2) {
                z = z11;
                i = length4;
                z2 = z12;
            } else if (i41 != 3) {
                z zVar5 = zVarArr[i40];
                int[][] iArr16 = iArr12[i40];
                cVar6.getClass();
                y yVar7 = null;
                int i50 = 0;
                int i51 = 0;
                int i52 = 0;
                while (i50 < zVar5.f1544a) {
                    y yVar8 = zVar5.b[i50];
                    int[] iArr17 = iArr16[i50];
                    boolean z13 = z11;
                    int i53 = length4;
                    int i54 = 0;
                    while (i54 < yVar8.f1543a) {
                        int i55 = i54;
                        if (d.a(iArr17[i54], true)) {
                            int i56 = (yVar8.b[i55].x & 1) != 0 ? 2 : 1;
                            z3 = z12;
                            if (d.a(iArr17[i55], false)) {
                                i56 += 1000;
                            }
                            if (i56 > i52) {
                                i52 = i56;
                                yVar7 = yVar8;
                                i51 = i55;
                            }
                        } else {
                            z3 = z12;
                        }
                        i54 = i55 + 1;
                        z12 = z3;
                    }
                    i50++;
                    z11 = z13;
                    length4 = i53;
                }
                z = z11;
                i = length4;
                z2 = z12;
                bVarArr[i40] = yVar7 == null ? null : new e(yVar7, i51);
            } else {
                z = z11;
                i = length4;
                z2 = z12;
                if (!z) {
                    z zVar6 = zVarArr[i40];
                    int[][] iArr18 = iArr12[i40];
                    cVar6.getClass();
                    y yVar9 = null;
                    int i57 = 0;
                    int i58 = 0;
                    int i59 = 0;
                    while (i57 < zVar6.f1544a) {
                        y yVar10 = zVar6.b[i57];
                        int[] iArr19 = iArr18[i57];
                        y yVar11 = yVar9;
                        int i60 = 0;
                        while (i60 < yVar10.f1543a) {
                            z zVar7 = zVar6;
                            if (d.a(iArr19[i60], true)) {
                                int i61 = yVar10.b[i60].x;
                                boolean z14 = (i61 & 1) != 0;
                                boolean z15 = (i61 & 2) != 0;
                                if (!z14) {
                                    i3 = z15 ? 1 : 3;
                                }
                                iArr = iArr18;
                                if (d.a(iArr19[i60], false)) {
                                    i3 += 1000;
                                }
                                if (i3 > i59) {
                                    i59 = i3;
                                    i58 = i60;
                                    yVar11 = yVar10;
                                }
                                i60++;
                                zVar6 = zVar7;
                                iArr18 = iArr;
                            }
                            iArr = iArr18;
                            i60++;
                            zVar6 = zVar7;
                            iArr18 = iArr;
                        }
                        i57++;
                        yVar9 = yVar11;
                    }
                    e eVar3 = yVar9 == null ? null : new e(yVar9, i58);
                    bVarArr[i40] = eVar3;
                    z11 = eVar3 != null;
                    i40++;
                    length4 = i;
                    z12 = z2;
                }
            }
            z11 = z;
            i40++;
            length4 = i;
            z12 = z2;
        }
        for (int i62 = 0; i62 < aVarArr.length; i62++) {
            if (this.b.get(i62)) {
                bVarArr[i62] = null;
            } else {
                z zVar8 = zVarArr[i62];
                Map map = (Map) this.f1549a.get(i62);
                if (map != null && map.containsKey(zVar8)) {
                    if (((Map) this.f1549a.get(i62)).get(zVar8) != null) {
                        throw new ClassCastException();
                    }
                    bVarArr[i62] = null;
                }
            }
        }
        f fVar = new f(zVarArr);
        t[] tVarArr = new t[aVarArr.length];
        for (int i63 = 0; i63 < aVarArr.length; i63++) {
            tVarArr[i63] = bVarArr[i63] != null ? t.b : null;
        }
        return new j(zVar, new h(bVarArr), fVar, tVarArr);
    }
}
