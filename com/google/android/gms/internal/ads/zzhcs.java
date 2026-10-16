package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhcs extends zzgzh implements zzhat {
    private static final zzhcs zza;
    private static volatile zzhba zzb;
    private zzgzp zzc = zzbG();
    private zzgzp zzd = zzbG();

    static {
        zzhcs zzhcsVar = new zzhcs();
        zza = zzhcsVar;
        zzgzh.zzbZ(zzhcs.class, zzhcsVar);
    }

    private zzhcs() {
    }

    public static zzhcs zzd(byte[] bArr, zzgyr zzgyrVar) throws zzgzw {
        return (zzhcs) zzgzh.zzbx(zza, bArr, zzgyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u0016\u0003\u0016", new Object[]{"zzc", "zzd"});
        }
        if (ordinal == 3) {
            return new zzhcs();
        }
        zzhct zzhctVar = null;
        if (ordinal == 4) {
            return new zzhcr(zzhctVar);
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
        synchronized (zzhcs.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
