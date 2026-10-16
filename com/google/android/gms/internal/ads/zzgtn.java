package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgtn extends zzgzh implements zzhat {
    private static final zzgtn zza;
    private static volatile zzhba zzb;

    static {
        zzgtn zzgtnVar = new zzgtn();
        zza = zzgtnVar;
        zzgzh.zzbZ(zzgtn.class, zzgtnVar);
    }

    private zzgtn() {
    }

    public static zzgtn zzb() {
        return zza;
    }

    public static zzgtn zzc(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgtn) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        zzgtm zzgtmVar = null;
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0000", null);
        }
        if (ordinal == 3) {
            return new zzgtn();
        }
        if (ordinal == 4) {
            return new zzgtl(zzgtmVar);
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
        synchronized (zzgtn.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
