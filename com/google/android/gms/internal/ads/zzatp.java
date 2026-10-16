package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzatp extends zzgzh implements zzhat {
    private static final zzatp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzatp zzatpVar = new zzatp();
        zza = zzatpVar;
        zzgzh.zzbZ(zzatp.class, zzatpVar);
    }

    private zzatp() {
    }

    public static zzato zza() {
        return (zzato) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 32;
        zzatpVar.zzi = j;
    }

    static /* synthetic */ void zzd(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 4;
        zzatpVar.zzf = j;
    }

    static /* synthetic */ void zzf(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 1;
        zzatpVar.zzd = j;
    }

    static /* synthetic */ void zzg(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 8;
        zzatpVar.zzg = j;
    }

    static /* synthetic */ void zzh(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 16;
        zzatpVar.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (ordinal == 3) {
            return new zzatp();
        }
        zzaui zzauiVar = null;
        if (ordinal == 4) {
            return new zzato(zzauiVar);
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
        synchronized (zzatp.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
