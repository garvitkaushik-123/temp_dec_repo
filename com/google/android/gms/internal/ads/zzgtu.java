package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgtu extends zzgzh implements zzhat {
    private static final zzgtu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgtx zzd;
    private int zze;
    private int zzf;

    static {
        zzgtu zzgtuVar = new zzgtu();
        zza = zzgtuVar;
        zzgzh.zzbZ(zzgtu.class, zzgtuVar);
    }

    private zzgtu() {
    }

    public static zzgts zzc() {
        return (zzgts) zza.zzaZ();
    }

    public static zzgtu zzf() {
        return zza;
    }

    public static zzgtu zzg(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgtu) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzj(zzgtu zzgtuVar, zzgtx zzgtxVar) {
        zzgtxVar.getClass();
        zzgtuVar.zzd = zzgtxVar;
        zzgtuVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzgtu();
        }
        zzgtt zzgttVar = null;
        if (ordinal == 4) {
            return new zzgts(zzgttVar);
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
        synchronized (zzgtu.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgtx zzh() {
        zzgtx zzgtxVar = this.zzd;
        return zzgtxVar == null ? zzgtx.zzf() : zzgtxVar;
    }
}
