package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgtb extends zzgzh implements zzhat {
    private static final zzgtb zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;

    static {
        zzgtb zzgtbVar = new zzgtb();
        zza = zzgtbVar;
        zzgzh.zzbZ(zzgtb.class, zzgtbVar);
    }

    private zzgtb() {
    }

    public static zzgsz zzc() {
        return (zzgsz) zza.zzaZ();
    }

    public static zzgtb zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgtb) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
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
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd"});
        }
        if (ordinal == 3) {
            return new zzgtb();
        }
        zzgta zzgtaVar = null;
        if (ordinal == 4) {
            return new zzgsz(zzgtaVar);
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
        synchronized (zzgtb.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
