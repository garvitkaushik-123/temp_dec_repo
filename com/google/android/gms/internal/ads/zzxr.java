package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzxr extends zzxt {
    protected zzxr(zzbm zzbmVar, int[] iArr, int i, zzzl zzzlVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List list, zzdj zzdjVar) {
        super(zzbmVar, iArr, 0);
        zzfyq.zzl(list);
    }

    static /* bridge */ /* synthetic */ zzfyq zzd(zzyv[] zzyvVarArr) {
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = 1;
            if (i3 >= 2) {
                break;
            }
            zzyv zzyvVar = zzyvVarArr[i3];
            if (zzyvVar == null || zzyvVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                int i4 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                zzfynVar.zzf(new zzxp(0L, 0L));
                arrayList.add(zzfynVar);
            }
            i3++;
        }
        long[][] jArr = new long[2][];
        for (int i5 = 0; i5 < 2; i5++) {
            zzyv zzyvVar2 = zzyvVarArr[i5];
            if (zzyvVar2 == null) {
                jArr[i5] = new long[0];
            } else {
                int[] iArr = zzyvVar2.zzb;
                jArr[i5] = new long[iArr.length];
                for (int i6 = 0; i6 < iArr.length; i6++) {
                    long j = zzyvVar2.zza.zzb(iArr[i6]).zzj;
                    long[] jArr2 = jArr[i5];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i6] = j;
                }
                Arrays.sort(jArr[i5]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i7 = 0; i7 < 2; i7++) {
            long[] jArr4 = jArr[i7];
            jArr3[i7] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        zzi(arrayList, jArr3);
        zzfzb zza = zzfzw.zzc(zzgab.zzc()).zzb(2).zza();
        int i8 = 0;
        while (i8 < 2) {
            int length = jArr[i8].length;
            if (length > i) {
                double[] dArr = new double[length];
                int i9 = i2;
                while (true) {
                    long[] jArr5 = jArr[i8];
                    double d = 0.0d;
                    if (i9 >= jArr5.length) {
                        break;
                    }
                    long j2 = jArr5[i9];
                    if (j2 != -1) {
                        d = Math.log(j2);
                    }
                    dArr[i9] = d;
                    i9++;
                }
                int i10 = length - 1;
                double d2 = dArr[i10] - dArr[i2];
                int i11 = i2;
                while (i11 < i10) {
                    double d3 = dArr[i11];
                    i11++;
                    zza.zzq(Double.valueOf(d2 == 0.0d ? 1.0d : (((d3 + dArr[i11]) * 0.5d) - dArr[i2]) / d2), Integer.valueOf(i8));
                    i = i;
                    i2 = 0;
                }
            }
            i8++;
            i = i;
            i2 = 0;
        }
        zzfyq zzl = zzfyq.zzl(zza.zzr());
        for (int i12 = 0; i12 < zzl.size(); i12++) {
            int intValue = ((Integer) zzl.get(i12)).intValue();
            int i13 = iArr2[intValue] + 1;
            iArr2[intValue] = i13;
            jArr3[intValue] = jArr[intValue][i13];
            zzi(arrayList, jArr3);
        }
        for (int i14 = 0; i14 < 2; i14++) {
            if (arrayList.get(i14) != null) {
                long j3 = jArr3[i14];
                jArr3[i14] = j3 + j3;
            }
        }
        zzi(arrayList, jArr3);
        zzfyn zzfynVar2 = new zzfyn();
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            zzfyn zzfynVar3 = (zzfyn) arrayList.get(i15);
            zzfynVar2.zzf(zzfynVar3 == null ? zzfyq.zzn() : zzfynVar3.zzi());
        }
        return zzfynVar2.zzi();
    }

    private static void zzi(List list, long[] jArr) {
        long j = 0;
        for (int i = 0; i < 2; i++) {
            j += jArr[i];
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzfyn zzfynVar = (zzfyn) list.get(i2);
            if (zzfynVar != null) {
                zzfynVar.zzf(new zzxp(j, jArr[i2]));
            }
        }
    }
}
