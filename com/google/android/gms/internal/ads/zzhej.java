package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@Deprecated
/* loaded from: classes5.dex */
public final class zzhej extends zzgzh implements zzhat {
    private static final zzhej zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzhei zze;
    private zzhei zzf;

    static {
        zzhej zzhejVar = new zzhej();
        zza = zzhejVar;
        zzgzh.zzbZ(zzhej.class, zzhejVar);
    }

    private zzhej() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzheg.zza, "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzhej();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhef(zzhfxVar);
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
        synchronized (zzhej.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
