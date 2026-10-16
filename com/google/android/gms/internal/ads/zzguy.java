package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzguy extends zzgzh implements zzhat {
    private static final zzguy zza;
    private static volatile zzhba zzb;
    private String zzc = "";

    static {
        zzguy zzguyVar = new zzguy();
        zza = zzguyVar;
        zzgzh.zzbZ(zzguy.class, zzguyVar);
    }

    private zzguy() {
    }

    public static zzguw zza() {
        return (zzguw) zza.zzaZ();
    }

    public static zzguy zzc() {
        return zza;
    }

    public static zzguy zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzguy) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzg(zzguy zzguyVar, String str) {
        str.getClass();
        zzguyVar.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
        }
        if (ordinal == 3) {
            return new zzguy();
        }
        zzgux zzguxVar = null;
        if (ordinal == 4) {
            return new zzguw(zzguxVar);
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
        synchronized (zzguy.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final String zzf() {
        return this.zzc;
    }
}
