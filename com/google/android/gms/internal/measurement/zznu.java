package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.4.0 */
/* loaded from: classes5.dex */
final class zznu {
    public static final /* synthetic */ int zza = 0;
    private static final zzoe zzb;

    static {
        int i = zznp.zza;
        zzb = new zzog();
    }

    public static void zzA(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
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
        if (!(list instanceof zzme)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlk.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzme zzmeVar = (zzme) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlk.zzA(zzmeVar.zze(i));
            i++;
        }
        return i3;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlk.zzz(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzlk.zzz(i << 3) + 8);
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
        if (!(list instanceof zzme)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlk.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzme zzmeVar = (zzme) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlk.zzA(zzmeVar.zze(i));
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
        if (!(list instanceof zzmw)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlk.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzmw zzmwVar = (zzmw) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlk.zzA(zzmwVar.zza(i));
            i++;
        }
        return i3;
    }

    static int zzh(int i, Object obj, zzns zznsVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzms)) {
            return zzlk.zzz(i2) + zzlk.zzx((zznh) obj, zznsVar);
        }
        int zzz = zzlk.zzz(i2);
        int zza2 = ((zzms) obj).zza();
        return zzz + zzlk.zzz(zza2) + zza2;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzme)) {
            int i2 = 0;
            while (i < size) {
                int intValue = ((Integer) list.get(i)).intValue();
                i2 += zzlk.zzz((intValue >> 31) ^ (intValue + intValue));
                i++;
            }
            return i2;
        }
        zzme zzmeVar = (zzme) list;
        int i3 = 0;
        while (i < size) {
            int zze = zzmeVar.zze(i);
            i3 += zzlk.zzz((zze >> 31) ^ (zze + zze));
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
        if (!(list instanceof zzmw)) {
            int i2 = 0;
            while (i < size) {
                long longValue = ((Long) list.get(i)).longValue();
                i2 += zzlk.zzA((longValue >> 63) ^ (longValue + longValue));
                i++;
            }
            return i2;
        }
        zzmw zzmwVar = (zzmw) list;
        int i3 = 0;
        while (i < size) {
            long zza2 = zzmwVar.zza(i);
            i3 += zzlk.zzA((zza2 >> 63) ^ (zza2 + zza2));
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
        if (!(list instanceof zzme)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlk.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
            return i2;
        }
        zzme zzmeVar = (zzme) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlk.zzz(zzmeVar.zze(i));
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
        if (!(list instanceof zzmw)) {
            int i2 = 0;
            while (i < size) {
                i2 += zzlk.zzA(((Long) list.get(i)).longValue());
                i++;
            }
            return i2;
        }
        zzmw zzmwVar = (zzmw) list;
        int i3 = 0;
        while (i < size) {
            i3 += zzlk.zzA(zzmwVar.zza(i));
            i++;
        }
        return i3;
    }

    public static zzoe zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzoe zzoeVar) {
        Object obj3 = obj2;
        if (obj2 == null) {
            zzmd zzmdVar = (zzmd) obj;
            zzof zzofVar = zzmdVar.zzc;
            obj3 = zzofVar;
            if (zzofVar == zzof.zzc()) {
                zzof zzf = zzof.zzf();
                zzmdVar.zzc = zzf;
                obj3 = zzf;
            }
        }
        ((zzof) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    static void zzo(zzlq zzlqVar, Object obj, Object obj2) {
        if (((zzma) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zzoe zzoeVar, Object obj, Object obj2) {
        zzmd zzmdVar = (zzmd) obj;
        zzof zzofVar = zzmdVar.zzc;
        zzof zzofVar2 = ((zzmd) obj2).zzc;
        if (!zzof.zzc().equals(zzofVar2)) {
            if (zzof.zzc().equals(zzofVar)) {
                zzofVar = zzof.zze(zzofVar, zzofVar2);
            } else {
                zzofVar.zzd(zzofVar2);
            }
        }
        zzmdVar.zzc = zzofVar;
    }

    public static void zzq(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzor zzorVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzorVar.zzA(i, list, z);
    }
}
