package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzayp extends zzgzh implements zzhat {
    private static final zzayp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzays zzd;
    private zzgxz zze;
    private zzgxz zzf;

    static {
        zzayp zzaypVar = new zzayp();
        zza = zzaypVar;
        zzgzh.zzbZ(zzayp.class, zzaypVar);
    }

    private zzayp() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zze = zzgxzVar;
        this.zzf = zzgxzVar;
    }

    public static zzayp zzb(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzayp) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public final zzays zzc() {
        zzays zzaysVar = this.zzd;
        return zzaysVar == null ? zzays.zzg() : zzaysVar;
    }

    public final zzgxz zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzayp();
        }
        zzayo zzayoVar = null;
        if (ordinal == 4) {
            return new zzayn(zzayoVar);
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
        synchronized (zzayp.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgxz zzf() {
        return this.zze;
    }
}
