package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgve extends zzgzh implements zzhat {
    private static final zzgve zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";
    private zzguf zze;

    static {
        zzgve zzgveVar = new zzgve();
        zza = zzgveVar;
        zzgzh.zzbZ(zzgve.class, zzgveVar);
    }

    private zzgve() {
    }

    public static zzgvc zzb() {
        return (zzgvc) zza.zzaZ();
    }

    public static zzgve zzd() {
        return zza;
    }

    public static zzgve zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgve) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    static /* synthetic */ void zzh(zzgve zzgveVar, zzguf zzgufVar) {
        zzgufVar.getClass();
        zzgveVar.zze = zzgufVar;
        zzgveVar.zzc |= 1;
    }

    static /* synthetic */ void zzi(zzgve zzgveVar, String str) {
        str.getClass();
        zzgveVar.zzd = str;
    }

    public final zzguf zza() {
        zzguf zzgufVar = this.zze;
        return zzgufVar == null ? zzguf.zzd() : zzgufVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzgve();
        }
        zzgvd zzgvdVar = null;
        if (ordinal == 4) {
            return new zzgvc(zzgvdVar);
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
        synchronized (zzgve.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final String zzg() {
        return this.zzd;
    }
}
