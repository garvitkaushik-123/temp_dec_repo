package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgsa extends zzgzh implements zzhat {
    private static final zzgsa zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgsg zze;
    private zzgtr zzf;

    static {
        zzgsa zzgsaVar = new zzgsa();
        zza = zzgsaVar;
        zzgzh.zzbZ(zzgsa.class, zzgsaVar);
    }

    private zzgsa() {
    }

    public static zzgry zzb() {
        return (zzgry) zza.zzaZ();
    }

    public static zzgsa zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgsa) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzi(zzgsa zzgsaVar, zzgsg zzgsgVar) {
        zzgsgVar.getClass();
        zzgsaVar.zze = zzgsgVar;
        zzgsaVar.zzc |= 1;
    }

    static /* synthetic */ void zzj(zzgsa zzgsaVar, zzgtr zzgtrVar) {
        zzgtrVar.getClass();
        zzgsaVar.zzf = zzgtrVar;
        zzgsaVar.zzc |= 2;
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzgsa();
        }
        zzgrz zzgrzVar = null;
        if (ordinal == 4) {
            return new zzgry(zzgrzVar);
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
        synchronized (zzgsa.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgsg zzf() {
        zzgsg zzgsgVar = this.zze;
        return zzgsgVar == null ? zzgsg.zzd() : zzgsgVar;
    }

    public final zzgtr zzg() {
        zzgtr zzgtrVar = this.zzf;
        return zzgtrVar == null ? zzgtr.zzd() : zzgtrVar;
    }
}
