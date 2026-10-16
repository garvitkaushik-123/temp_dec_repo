package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbh {
    private final ArrayDeque zza = new ArrayDeque();

    private zzhbh() {
    }

    static /* bridge */ /* synthetic */ zzgxz zza(zzhbh zzhbhVar, zzgxz zzgxzVar, zzgxz zzgxzVar2) {
        zzhbhVar.zzb(zzgxzVar);
        zzhbhVar.zzb(zzgxzVar2);
        ArrayDeque arrayDeque = zzhbhVar.zza;
        zzgxz zzgxzVar3 = (zzgxz) arrayDeque.pop();
        while (!arrayDeque.isEmpty()) {
            zzgxzVar3 = new zzhbk((zzgxz) arrayDeque.pop(), zzgxzVar3);
        }
        return zzgxzVar3;
    }

    private final void zzb(zzgxz zzgxzVar) {
        zzhbj zzhbjVar;
        if (!zzgxzVar.zzh()) {
            if (!(zzgxzVar instanceof zzhbk)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgxzVar.getClass()))));
            }
            zzhbk zzhbkVar = (zzhbk) zzgxzVar;
            zzb(zzhbkVar.zzd);
            zzb(zzhbkVar.zze);
            return;
        }
        int zzc = zzc(zzgxzVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int zzc2 = zzhbk.zzc(zzc + 1);
        if (arrayDeque.isEmpty() || ((zzgxz) arrayDeque.peek()).zzd() >= zzc2) {
            arrayDeque.push(zzgxzVar);
            return;
        }
        int zzc3 = zzhbk.zzc(zzc);
        zzgxz zzgxzVar2 = (zzgxz) arrayDeque.pop();
        while (true) {
            zzhbjVar = null;
            if (arrayDeque.isEmpty() || ((zzgxz) arrayDeque.peek()).zzd() >= zzc3) {
                break;
            } else {
                zzgxzVar2 = new zzhbk((zzgxz) arrayDeque.pop(), zzgxzVar2);
            }
        }
        zzhbk zzhbkVar2 = new zzhbk(zzgxzVar2, zzgxzVar);
        while (!arrayDeque.isEmpty()) {
            if (((zzgxz) arrayDeque.peek()).zzd() >= zzhbk.zzc(zzc(zzhbkVar2.zzd()) + 1)) {
                break;
            } else {
                zzhbkVar2 = new zzhbk((zzgxz) arrayDeque.pop(), zzhbkVar2);
            }
        }
        arrayDeque.push(zzhbkVar2);
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzhbk.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzhbh(zzhbj zzhbjVar) {
    }
}
