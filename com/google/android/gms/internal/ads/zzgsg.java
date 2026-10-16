package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgsg extends zzgzh implements zzhat {
    private static final zzgsg zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgsm zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgsg zzgsgVar = new zzgsg();
        zza = zzgsgVar;
        zzgzh.zzbZ(zzgsg.class, zzgsgVar);
    }

    private zzgsg() {
    }

    public static zzgse zzb() {
        return (zzgse) zza.zzaZ();
    }

    public static zzgsg zzd() {
        return zza;
    }

    static /* synthetic */ void zzi(zzgsg zzgsgVar, zzgsm zzgsmVar) {
        zzgsmVar.getClass();
        zzgsgVar.zze = zzgsmVar;
        zzgsgVar.zzc |= 1;
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
            return new zzgsg();
        }
        zzgsf zzgsfVar = null;
        if (ordinal == 4) {
            return new zzgse(zzgsfVar);
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
        synchronized (zzgsg.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgsm zzf() {
        zzgsm zzgsmVar = this.zze;
        return zzgsmVar == null ? zzgsm.zzd() : zzgsmVar;
    }

    public final zzgxz zzg() {
        return this.zzf;
    }
}
