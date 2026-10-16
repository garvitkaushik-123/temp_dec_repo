package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzza extends zzzd {
    protected abstract Pair zzd(zzyz zzyzVar, int[][][] iArr, int[] iArr2, zzvh zzvhVar, zzbl zzblVar) throws zzin;

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzze zzo(zzmd[] zzmdVarArr, zzxk zzxkVar, zzvh zzvhVar, zzbl zzblVar) throws zzin {
        List[] listArr;
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzbm[][] zzbmVarArr = new zzbm[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzxkVar.zzb;
            zzbmVarArr[i] = new zzbm[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzmdVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzxkVar.zzb) {
            zzbm zzb = zzxkVar.zzb(i5);
            int i6 = zzb.zzc;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzmd zzmdVar = zzmdVarArr[i8];
                int i10 = 0;
                for (int i11 = 0; i11 < zzb.zza; i11++) {
                    i10 = Math.max(i10, zzmdVar.zzZ(zzb.zzb(i11)) & 7);
                }
                boolean z3 = iArr2[i8] == 0;
                if (i10 > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = i10;
                } else if (i10 == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = i10;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzb.zza];
            } else {
                zzmd zzmdVar2 = zzmdVarArr[i7];
                int i12 = zzb.zza;
                int[] iArr5 = new int[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    iArr5[i13] = zzmdVar2.zzZ(zzb.zzb(i13));
                }
                iArr = iArr5;
            }
            int i14 = iArr2[i7];
            zzbmVarArr[i7][i14] = zzb;
            iArr3[i7][i14] = iArr;
            iArr2[i7] = i14 + 1;
            i5++;
            i3 = 2;
        }
        zzxk[] zzxkVarArr = new zzxk[i3];
        String[] strArr = new String[i3];
        int[] iArr6 = new int[i3];
        int i15 = 0;
        while (i15 < i3) {
            int i16 = iArr2[i15];
            zzxkVarArr[i15] = new zzxk((zzbm[]) zzex.zzQ(zzbmVarArr[i15], i16));
            iArr3[i15] = (int[][]) zzex.zzQ(iArr3[i15], i16);
            strArr[i15] = zzmdVarArr[i15].zzV();
            iArr6[i15] = zzmdVarArr[i15].zzb();
            i15++;
            i3 = 2;
        }
        int i17 = i3;
        zzyz zzyzVar = new zzyz(strArr, iArr6, zzxkVarArr, iArr4, iArr3, new zzxk((zzbm[]) zzex.zzQ(zzbmVarArr[i17], iArr2[i17])));
        Pair zzd = zzd(zzyzVar, iArr3, iArr4, zzvhVar, zzblVar);
        zzzb[] zzzbVarArr = (zzzb[]) zzd.second;
        List[] listArr2 = new List[zzzbVarArr.length];
        for (int i18 = 0; i18 < zzzbVarArr.length; i18++) {
            zzzb zzzbVar = zzzbVarArr[i18];
            listArr2[i18] = zzzbVar != null ? zzfyq.zzo(zzzbVar) : zzfyq.zzn();
        }
        zzfyn zzfynVar = new zzfyn();
        for (int i19 = 0; i19 < 2; i19++) {
            zzxk zzd2 = zzyzVar.zzd(i19);
            List list = listArr2[i19];
            int i20 = 0;
            while (i20 < zzd2.zzb) {
                zzbm zzb2 = zzd2.zzb(i20);
                boolean z4 = zzyzVar.zza(i19, i20, false) != 0;
                int i21 = zzb2.zza;
                int[] iArr7 = new int[i21];
                boolean[] zArr = new boolean[i21];
                int i22 = 0;
                while (i22 < i21) {
                    iArr7[i22] = zzyzVar.zzb(i19, i20, i22) & 7;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= list.size()) {
                            listArr = listArr2;
                            z = false;
                            break;
                        }
                        zzzb zzzbVar2 = (zzzb) list.get(i23);
                        listArr = listArr2;
                        if (zzzbVar2.zzc().equals(zzb2) && zzzbVar2.zzg(i22) != -1) {
                            z = true;
                            break;
                        }
                        i23++;
                        listArr2 = listArr;
                    }
                    zArr[i22] = z;
                    i22++;
                    listArr2 = listArr;
                }
                zzfynVar.zzf(new zzbs(zzb2, z4, iArr7, zArr));
                i20++;
                listArr2 = listArr2;
            }
        }
        zzxk zze = zzyzVar.zze();
        for (int i24 = 0; i24 < zze.zzb; i24++) {
            zzbm zzb3 = zze.zzb(i24);
            int i25 = zzb3.zza;
            int[] iArr8 = new int[i25];
            Arrays.fill(iArr8, 0);
            zzfynVar.zzf(new zzbs(zzb3, false, iArr8, new boolean[i25]));
        }
        return new zzze((zzme[]) zzd.first, (zzyw[]) zzd.second, new zzbt(zzfynVar.zzi()), zzyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zzp(Object obj) {
    }
}
