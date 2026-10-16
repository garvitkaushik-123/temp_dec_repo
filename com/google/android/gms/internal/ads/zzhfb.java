package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhfb extends zzgzh implements zzhat {
    private static final zzhfb zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zze;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private boolean zzk;
    private String zzd = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzhfb zzhfbVar = new zzhfb();
        zza = zzhfbVar;
        zzgzh.zzbZ(zzhfb.class, zzhfbVar);
    }

    private zzhfb() {
    }

    public static zzhfa zzc() {
        return (zzhfa) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhfb zzhfbVar, String str) {
        zzhfbVar.zzc |= 1;
        zzhfbVar.zzd = str;
    }

    static /* synthetic */ void zzg(zzhfb zzhfbVar, long j) {
        zzhfbVar.zzc |= 2;
        zzhfbVar.zze = j;
    }

    static /* synthetic */ void zzh(zzhfb zzhfbVar, boolean z) {
        zzhfbVar.zzc |= 4;
        zzhfbVar.zzf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhfc.zza, "zzh", "zzi", "zzj", "zzk"});
        }
        if (ordinal == 3) {
            return new zzhfb();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhfa(zzhfxVar);
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
        synchronized (zzhfb.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
