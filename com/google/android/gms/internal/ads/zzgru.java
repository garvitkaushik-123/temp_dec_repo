package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgru extends zzgzh implements zzhat {
    private static final zzgru zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgrx zze;

    static {
        zzgru zzgruVar = new zzgru();
        zza = zzgruVar;
        zzgzh.zzbZ(zzgru.class, zzgruVar);
    }

    private zzgru() {
    }

    public static zzgrs zzb() {
        return (zzgrs) zza.zzaZ();
    }

    public static zzgru zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgru) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzh(zzgru zzgruVar, zzgrx zzgrxVar) {
        zzgrxVar.getClass();
        zzgruVar.zze = zzgrxVar;
        zzgruVar.zzc |= 1;
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
            return new zzgru();
        }
        zzgrt zzgrtVar = null;
        if (ordinal == 4) {
            return new zzgrs(zzgrtVar);
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
        synchronized (zzgru.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgrx zzf() {
        zzgrx zzgrxVar = this.zze;
        return zzgrxVar == null ? zzgrx.zzd() : zzgrxVar;
    }
}
