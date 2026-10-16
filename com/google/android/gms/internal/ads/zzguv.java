package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzguv extends zzgzh implements zzhat {
    private static final zzguv zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzguy zze;

    static {
        zzguv zzguvVar = new zzguv();
        zza = zzguvVar;
        zzgzh.zzbZ(zzguv.class, zzguvVar);
    }

    private zzguv() {
    }

    public static zzgut zzb() {
        return (zzgut) zza.zzaZ();
    }

    public static zzguv zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzguv) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzg() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzh(zzguv zzguvVar, zzguy zzguyVar) {
        zzguyVar.getClass();
        zzguvVar.zze = zzguyVar;
        zzguvVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzguv();
        }
        zzguu zzguuVar = null;
        if (ordinal == 4) {
            return new zzgut(zzguuVar);
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
        synchronized (zzguv.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzguy zzf() {
        zzguy zzguyVar = this.zze;
        return zzguyVar == null ? zzguy.zzc() : zzguyVar;
    }
}
