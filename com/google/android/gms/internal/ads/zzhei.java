package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhei extends zzgzh implements zzhat {
    private static final zzhei zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzhei zzheiVar = new zzhei();
        zza = zzheiVar;
        zzgzh.zzbZ(zzhei.class, zzheiVar);
    }

    private zzhei() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            zzgzn zzgznVar = zzheg.zza;
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zzc", "zzd", zzgznVar, "zze", "zzf", zzgznVar});
        }
        if (ordinal == 3) {
            return new zzhei();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzheh(zzhfxVar);
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
        synchronized (zzhei.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
