package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhfl extends zzgzh implements zzhat {
    private static final zzhfl zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private String zze = "";

    static {
        zzhfl zzhflVar = new zzhfl();
        zza = zzhflVar;
        zzgzh.zzbZ(zzhfl.class, zzhflVar);
    }

    private zzhfl() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", zzhfk.zza, "zze"});
        }
        if (ordinal == 3) {
            return new zzhfl();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhfj(zzhfxVar);
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
        synchronized (zzhfl.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
