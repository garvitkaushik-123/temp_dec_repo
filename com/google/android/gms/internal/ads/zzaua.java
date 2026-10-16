package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaua extends zzgzh implements zzhat {
    private static final zzaua zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzf;
    private long zzh;
    private long zzi;
    private String zzd = "";
    private String zze = "";
    private String zzg = "D";

    static {
        zzaua zzauaVar = new zzaua();
        zza = zzauaVar;
        zzgzh.zzbZ(zzaua.class, zzauaVar);
    }

    private zzaua() {
    }

    public static zzatz zza() {
        return (zzatz) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzaua zzauaVar, String str) {
        zzauaVar.zzc |= 1;
        zzauaVar.zzd = "0.460000000";
    }

    static /* synthetic */ void zzd(zzaua zzauaVar, String str) {
        str.getClass();
        zzauaVar.zzc |= 2;
        zzauaVar.zze = str;
    }

    static /* synthetic */ void zzf(zzaua zzauaVar, String str) {
        str.getClass();
        zzauaVar.zzc |= 8;
        zzauaVar.zzg = str;
    }

    static /* synthetic */ void zzg(zzaua zzauaVar, long j) {
        zzauaVar.zzc |= 4;
        zzauaVar.zzf = j;
    }

    static /* synthetic */ void zzh(zzaua zzauaVar, long j) {
        zzauaVar.zzc |= 32;
        zzauaVar.zzi = j;
    }

    static /* synthetic */ void zzi(zzaua zzauaVar, long j) {
        zzauaVar.zzc |= 16;
        zzauaVar.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (ordinal == 3) {
            return new zzaua();
        }
        zzaui zzauiVar = null;
        if (ordinal == 4) {
            return new zzatz(zzauiVar);
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
        synchronized (zzaua.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
