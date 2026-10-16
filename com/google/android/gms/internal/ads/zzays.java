package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzays extends zzgzh implements zzhat {
    private static final zzays zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzays zzaysVar = new zzays();
        zza = zzaysVar;
        zzgzh.zzbZ(zzays.class, zzaysVar);
    }

    private zzays() {
    }

    public static zzayq zzd() {
        return (zzayq) zza.zzaZ();
    }

    public static zzays zzg() {
        return zza;
    }

    public static zzays zzh(zzgxz zzgxzVar) throws zzgzw {
        return (zzays) zzgzh.zzbm(zza, zzgxzVar);
    }

    public static zzays zzi(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzays) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzl(zzays zzaysVar, String str) {
        str.getClass();
        zzaysVar.zzc |= 2;
        zzaysVar.zze = str;
    }

    static /* synthetic */ void zzm(zzays zzaysVar, long j) {
        zzaysVar.zzc |= 8;
        zzaysVar.zzg = j;
    }

    static /* synthetic */ void zzn(zzays zzaysVar, long j) {
        zzaysVar.zzc |= 4;
        zzaysVar.zzf = j;
    }

    static /* synthetic */ void zzo(zzays zzaysVar, long j) {
        zzaysVar.zzc |= 16;
        zzaysVar.zzh = j;
    }

    static /* synthetic */ void zzp(zzays zzaysVar, String str) {
        str.getClass();
        zzaysVar.zzc |= 1;
        zzaysVar.zzd = str;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final long zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (ordinal == 3) {
            return new zzays();
        }
        zzayr zzayrVar = null;
        if (ordinal == 4) {
            return new zzayq(zzayrVar);
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
        synchronized (zzays.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
