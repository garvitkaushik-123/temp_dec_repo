package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgsd extends zzgzh implements zzhat {
    private static final zzgsd zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgsj zzd;
    private zzgtu zze;

    static {
        zzgsd zzgsdVar = new zzgsd();
        zza = zzgsdVar;
        zzgzh.zzbZ(zzgsd.class, zzgsdVar);
    }

    private zzgsd() {
    }

    public static zzgsb zza() {
        return (zzgsb) zza.zzaZ();
    }

    public static zzgsd zzc(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgsd) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzg(zzgsd zzgsdVar, zzgsj zzgsjVar) {
        zzgsjVar.getClass();
        zzgsdVar.zzd = zzgsjVar;
        zzgsdVar.zzc |= 1;
    }

    static /* synthetic */ void zzh(zzgsd zzgsdVar, zzgtu zzgtuVar) {
        zzgtuVar.getClass();
        zzgsdVar.zze = zzgtuVar;
        zzgsdVar.zzc |= 2;
    }

    public final zzgsj zzd() {
        zzgsj zzgsjVar = this.zzd;
        return zzgsjVar == null ? zzgsj.zzd() : zzgsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzgsd();
        }
        zzgsc zzgscVar = null;
        if (ordinal == 4) {
            return new zzgsb(zzgscVar);
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
        synchronized (zzgsd.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgtu zzf() {
        zzgtu zzgtuVar = this.zze;
        return zzgtuVar == null ? zzgtu.zzf() : zzgtuVar;
    }
}
