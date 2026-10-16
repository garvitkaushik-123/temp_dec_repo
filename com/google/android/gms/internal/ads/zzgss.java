package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgss extends zzgzh implements zzhat {
    private static final zzgss zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgsv zzd;
    private int zze;

    static {
        zzgss zzgssVar = new zzgss();
        zza = zzgssVar;
        zzgzh.zzbZ(zzgss.class, zzgssVar);
    }

    private zzgss() {
    }

    public static zzgsq zzb() {
        return (zzgsq) zza.zzaZ();
    }

    public static zzgss zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgss) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzh(zzgss zzgssVar, zzgsv zzgsvVar) {
        zzgsvVar.getClass();
        zzgssVar.zzd = zzgsvVar;
        zzgssVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzgss();
        }
        zzgsr zzgsrVar = null;
        if (ordinal == 4) {
            return new zzgsq(zzgsrVar);
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
        synchronized (zzgss.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgsv zzf() {
        zzgsv zzgsvVar = this.zzd;
        return zzgsvVar == null ? zzgsv.zzd() : zzgsvVar;
    }
}
