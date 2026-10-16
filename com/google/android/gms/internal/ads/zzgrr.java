package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgrr extends zzgzh implements zzhat {
    private static final zzgrr zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgxz zze = zzgxz.zzb;
    private zzgrx zzf;

    static {
        zzgrr zzgrrVar = new zzgrr();
        zza = zzgrrVar;
        zzgzh.zzbZ(zzgrr.class, zzgrrVar);
    }

    private zzgrr() {
    }

    public static zzgrp zzb() {
        return (zzgrp) zza.zzaZ();
    }

    public static zzgrr zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgrr) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgrr zzgrrVar, zzgrx zzgrxVar) {
        zzgrxVar.getClass();
        zzgrrVar.zzf = zzgrxVar;
        zzgrrVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzgrr();
        }
        zzgrq zzgrqVar = null;
        if (ordinal == 4) {
            return new zzgrp(zzgrqVar);
        }
        if (ordinal == 5) {
            return zza;
        }
        if (ordinal != 6) {
            throw null;
        }
        zzhba zzhbaVar2 = zzb;
        if (zzhbaVar2 != null) {
            return zzhbaVar2;
        }
        synchronized (zzgrr.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgrx zzf() {
        zzgrx zzgrxVar = this.zzf;
        return zzgrxVar == null ? zzgrx.zzd() : zzgrxVar;
    }

    public final zzgxz zzg() {
        return this.zze;
    }
}
