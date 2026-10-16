package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhde extends zzgzh implements zzhat {
    private static final zzhde zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private long zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzhde zzhdeVar = new zzhde();
        zza = zzhdeVar;
        zzgzh.zzbZ(zzhde.class, zzhdeVar);
    }

    private zzhde() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", zzhdd.zza, "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzhde();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhdc(zzhfxVar);
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
        synchronized (zzhde.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
