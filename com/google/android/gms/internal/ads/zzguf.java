package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzguf extends zzgzh implements zzhat {
    private static final zzguf zza;
    private static volatile zzhba zzb;
    private String zzc = "";
    private zzgxz zzd = zzgxz.zzb;
    private int zze;

    static {
        zzguf zzgufVar = new zzguf();
        zza = zzgufVar;
        zzgzh.zzbZ(zzguf.class, zzgufVar);
    }

    private zzguf() {
    }

    public static zzgud zza() {
        return (zzgud) zza.zzaZ();
    }

    public static zzgud zzb(zzguf zzgufVar) {
        return (zzgud) zza.zzba(zzgufVar);
    }

    public static zzguf zzd() {
        return zza;
    }

    public static zzguf zzf(byte[] bArr, zzgyr zzgyrVar) throws zzgzw {
        return (zzguf) zzgzh.zzbx(zza, bArr, zzgyrVar);
    }

    static /* synthetic */ void zzk(zzguf zzgufVar, String str) {
        str.getClass();
        zzgufVar.zzc = str;
    }

    static /* synthetic */ void zzl(zzguf zzgufVar, zzgxz zzgxzVar) {
        zzgxzVar.getClass();
        zzgufVar.zzd = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzguf();
        }
        zzgue zzgueVar = null;
        if (ordinal == 4) {
            return new zzgud(zzgueVar);
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
        synchronized (zzguf.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgvf zzg() {
        zzgvf zzb2 = zzgvf.zzb(this.zze);
        return zzb2 == null ? zzgvf.UNRECOGNIZED : zzb2;
    }

    public final zzgxz zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
