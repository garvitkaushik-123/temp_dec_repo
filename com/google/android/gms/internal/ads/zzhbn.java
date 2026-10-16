package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzhbn {
    public static final /* synthetic */ int zza = 0;
    private static final zzhbx zzb;

    static {
        int i = zzhbc.zza;
        zzb = new zzhbz();
    }

    public static void zzA(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzhcm zzhcmVar, zzhbl zzhblVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgyn) zzhcmVar).zzv(i, list.get(i2), zzhblVar);
        }
    }

    public static void zzC(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzy(i, list, z);
    }

    public static void zzD(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzA(i, list, z);
    }

    public static void zzE(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzC(i, list, z);
    }

    public static void zzF(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzE(i, list, z);
    }

    public static void zzG(int i, List list, zzhcm zzhcmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzH(i, list);
    }

    public static void zzH(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzJ(i, list, z);
    }

    public static void zzI(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzL(i, list, z);
    }

    static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgzi)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzgym.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzgzi zzgziVar = (zzgzi) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzgym.zzE(zzgziVar.zzd(i));
            i++;
        }
        return i3;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgym.zzD(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgym.zzD(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgzi)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzgym.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzgzi zzgziVar = (zzgzi) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzgym.zzE(zzgziVar.zzd(i));
            i++;
        }
        return i3;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhah)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzgym.zzE(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzhah zzhahVar = (zzhah) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzgym.zzE(zzhahVar.zza(i));
            i++;
        }
        return i3;
    }

    static int zzh(int i, Object obj, zzhbl zzhblVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzhad)) {
            return zzgym.zzD(i2) + zzgym.zzA((zzhas) obj, zzhblVar);
        }
        int zzD = zzgym.zzD(i2);
        int zza2 = ((zzhad) obj).zza();
        return zzD + zzgym.zzD(zza2) + zza2;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgzi)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzgym.zzD((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzgzi zzgziVar = (zzgzi) list;
        int i3 = 0;
        while (i < size) {
            int zzd = zzgziVar.zzd(i);
            i3 += zzgym.zzD((zzd >> 31) ^ (zzd + zzd));
            i++;
        }
        return i3;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhah)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzgym.zzE((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzhah zzhahVar = (zzhah) list;
        int i3 = 0;
        while (i < size) {
            long zza2 = zzhahVar.zza(i);
            i3 += zzgym.zzE((zza2 >> 63) ^ (zza2 + zza2));
            i++;
        }
        return i3;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzgzi)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzgym.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzgzi zzgziVar = (zzgzi) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzgym.zzD(zzgziVar.zzd(i));
            i++;
        }
        return i3;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzhah)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzgym.zzE(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzhah zzhahVar = (zzhah) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzgym.zzE(zzhahVar.zza(i));
            i++;
        }
        return i3;
    }

    public static zzhbx zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, List list, zzgzn zzgznVar, Object obj2, zzhbx zzhbxVar) {
        if (zzgznVar == null) {
            return obj2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (!zzgznVar.zza(intValue)) {
                    obj2 = zzo(obj, i, intValue, obj2, zzhbxVar);
                    it.remove();
                }
            }
            return obj2;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue2 = ((Integer) list.get(i3)).intValue();
            if (zzgznVar.zza(intValue2)) {
                if (i3 != i2) {
                    list.set(i2, Integer.valueOf(intValue2));
                }
                i2++;
            } else {
                obj2 = zzo(obj, i, intValue2, obj2, zzhbxVar);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return obj2;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzhbx zzhbxVar) {
        if (obj2 == null) {
            obj2 = zzhbxVar.zza(obj);
        }
        zzhbxVar.zzh(obj2, i, i2);
        return obj2;
    }

    static void zzp(zzgys zzgysVar, Object obj, Object obj2) {
        if (((zzgzd) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzq(zzhbx zzhbxVar, Object obj, Object obj2) {
        zzgzh zzgzhVar = (zzgzh) obj;
        zzhby zzhbyVar = zzgzhVar.zzt;
        zzhby zzhbyVar2 = ((zzgzh) obj2).zzt;
        if (!zzhby.zzc().equals(zzhbyVar2)) {
            if (zzhby.zzc().equals(zzhbyVar)) {
                zzhbyVar = zzhby.zze(zzhbyVar, zzhbyVar2);
            } else {
                zzhbyVar.zzd(zzhbyVar2);
            }
        }
        zzgzhVar.zzt = zzhbyVar;
    }

    public static void zzr(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzhcm zzhcmVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zze(i, list);
    }

    public static void zzt(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzg(i, list, z);
    }

    public static void zzu(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzj(i, list, z);
    }

    public static void zzv(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzl(i, list, z);
    }

    public static void zzw(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzn(i, list, z);
    }

    public static void zzx(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzp(i, list, z);
    }

    public static void zzy(int i, List list, zzhcm zzhcmVar, zzhbl zzhblVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgyn) zzhcmVar).zzq(i, list.get(i2), zzhblVar);
        }
    }

    public static void zzz(int i, List list, zzhcm zzhcmVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhcmVar.zzs(i, list, z);
    }
}
