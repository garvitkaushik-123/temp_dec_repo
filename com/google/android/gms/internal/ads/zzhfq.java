package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhfq extends zzgzh implements zzhat {
    private static final zzhfq zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private int zzg;
    private String zze = "";
    private zzgzp zzf = zzbG();
    private zzgzt zzh = zzbK();
    private zzgxz zzi = zzgxz.zzb;

    static {
        zzhfq zzhfqVar = new zzhfq();
        zza = zzhfqVar;
        zzgzh.zzbZ(zzhfq.class, zzhfqVar);
    }

    private zzhfq() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzhfo.class, "zzi"});
        }
        if (ordinal == 3) {
            return new zzhfq();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhfp(zzhfxVar);
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
        synchronized (zzhfq.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
