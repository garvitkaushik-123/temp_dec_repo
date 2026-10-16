package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzhbx {
    private static volatile int zza = 100;

    zzhbx() {
    }

    abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i, int i2);

    abstract void zze(Object obj, int i, long j);

    abstract void zzf(Object obj, int i, Object obj2);

    abstract void zzg(Object obj, int i, zzgxz zzgxzVar);

    abstract void zzh(Object obj, int i, long j);

    abstract void zzi(Object obj);

    abstract void zzj(Object obj, Object obj2);

    final boolean zzk(Object obj, zzhbf zzhbfVar, int i) throws IOException {
        int zzd = zzhbfVar.zzd();
        int i2 = zzd >>> 3;
        int i3 = zzd & 7;
        if (i3 == 0) {
            zzh(obj, i2, zzhbfVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zze(obj, i2, zzhbfVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zzg(obj, i2, zzhbfVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new zzgzw("Protocol message end-group tag did not match expected tag.");
            }
            if (i3 != 5) {
                throw new zzgzv("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i2, zzhbfVar.zzf());
            return true;
        }
        Object zzb = zzb();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzgzw("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzhbfVar.zzc() != Integer.MAX_VALUE && zzk(zzb, zzhbfVar, i5)) {
        }
        if ((i4 | 4) != zzhbfVar.zzd()) {
            throw new zzgzw("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i2, zzc(zzb));
        return true;
    }
}
