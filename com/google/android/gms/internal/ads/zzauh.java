package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzauh extends zzgzh implements zzhat {
    private static final zzauh zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgzt zzd = zzbK();
    private zzgxz zze = zzgxz.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzauh zzauhVar = new zzauh();
        zza = zzauhVar;
        zzgzh.zzbZ(zzauh.class, zzauhVar);
    }

    private zzauh() {
    }

    public static zzaug zza() {
        return (zzaug) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzauh zzauhVar, zzgxz zzgxzVar) {
        zzgzt zzgztVar = zzauhVar.zzd;
        if (!zzgztVar.zzc()) {
            zzauhVar.zzd = zzgzh.zzbL(zzgztVar);
        }
        zzauhVar.zzd.add(zzgxzVar);
    }

    static /* synthetic */ void zzd(zzauh zzauhVar, zzgxz zzgxzVar) {
        zzauhVar.zzc |= 1;
        zzauhVar.zze = zzgxzVar;
    }

    static /* synthetic */ void zzf(zzauh zzauhVar, int i) {
        zzauhVar.zzg = i - 1;
        zzauhVar.zzc |= 4;
    }

    static /* synthetic */ void zzg(zzauh zzauhVar, int i) {
        zzauhVar.zzf = 4;
        zzauhVar.zzc |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzaub.zza, "zzg", zzatx.zza});
        }
        if (ordinal == 3) {
            return new zzauh();
        }
        zzaui zzauiVar = null;
        if (ordinal == 4) {
            return new zzaug(zzauiVar);
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
        synchronized (zzauh.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
