package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgsp extends zzgzh implements zzhat {
    private static final zzgsp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgsv zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgsp zzgspVar = new zzgsp();
        zza = zzgspVar;
        zzgzh.zzbZ(zzgsp.class, zzgspVar);
    }

    private zzgsp() {
    }

    public static zzgsn zzb() {
        return (zzgsn) zza.zzaZ();
    }

    public static zzgsp zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgsp) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgsp zzgspVar, zzgsv zzgsvVar) {
        zzgsvVar.getClass();
        zzgspVar.zze = zzgsvVar;
        zzgspVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzgsp();
        }
        zzgso zzgsoVar = null;
        if (ordinal == 4) {
            return new zzgsn(zzgsoVar);
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
        synchronized (zzgsp.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgsv zzf() {
        zzgsv zzgsvVar = this.zze;
        return zzgsvVar == null ? zzgsv.zzd() : zzgsvVar;
    }

    public final zzgxz zzg() {
        return this.zzf;
    }
}
