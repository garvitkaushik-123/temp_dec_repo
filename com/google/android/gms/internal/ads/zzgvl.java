package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgvl extends zzgzh implements zzhat {
    private static final zzgvl zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgvr zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgvl zzgvlVar = new zzgvl();
        zza = zzgvlVar;
        zzgzh.zzbZ(zzgvl.class, zzgvlVar);
    }

    private zzgvl() {
    }

    public static zzgvj zzb() {
        return (zzgvj) zza.zzaZ();
    }

    public static zzgvl zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgvl) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzi(zzgvl zzgvlVar, zzgvr zzgvrVar) {
        zzgvrVar.getClass();
        zzgvlVar.zze = zzgvrVar;
        zzgvlVar.zzc |= 1;
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
            return new zzgvl();
        }
        zzgvk zzgvkVar = null;
        if (ordinal == 4) {
            return new zzgvj(zzgvkVar);
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
        synchronized (zzgvl.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgvr zzf() {
        zzgvr zzgvrVar = this.zze;
        return zzgvrVar == null ? zzgvr.zzd() : zzgvrVar;
    }

    public final zzgxz zzg() {
        return this.zzf;
    }
}
