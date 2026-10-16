package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzarx extends zzgzh implements zzhat {
    private static final zzarx zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private boolean zzg;
    private zzasp zzi;
    private zzass zzj;
    private boolean zzk;
    private boolean zze = true;
    private String zzf = "unknown_host";
    private boolean zzh = true;

    static {
        zzarx zzarxVar = new zzarx();
        zza = zzarxVar;
        zzgzh.zzbZ(zzarx.class, zzarxVar);
    }

    private zzarx() {
    }

    public static zzarv zza() {
        return (zzarv) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzarx zzarxVar, boolean z) {
        zzarxVar.zzc |= 8;
        zzarxVar.zzg = z;
    }

    static /* synthetic */ void zzh(zzarx zzarxVar, String str) {
        str.getClass();
        zzarxVar.zzc |= 4;
        zzarxVar.zzf = str;
    }

    public final zzasp zzc() {
        zzasp zzaspVar = this.zzi;
        return zzaspVar == null ? zzasp.zzc() : zzaspVar;
    }

    public final zzass zzd() {
        zzass zzassVar = this.zzj;
        return zzassVar == null ? zzass.zzb() : zzassVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", zzary.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (ordinal == 3) {
            return new zzarx();
        }
        zzarw zzarwVar = null;
        if (ordinal == 4) {
            return new zzarv(zzarwVar);
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
        synchronized (zzarx.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final String zzf() {
        return this.zzf;
    }

    @Deprecated
    public final boolean zzi() {
        return this.zzg;
    }
}
