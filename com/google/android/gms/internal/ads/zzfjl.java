package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfjl extends zzgzh implements zzhat {
    private static final zzfjl zza;
    private static volatile zzhba zzb;
    private long zzc;
    private long zzd;
    private zzgzt zze = zzgzh.zzbK();

    static {
        zzfjl zzfjlVar = new zzfjl();
        zza = zzfjlVar;
        zzgzh.zzbZ(zzfjl.class, zzfjlVar);
    }

    private zzfjl() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003Ț", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzfjl();
        }
        zzfjk zzfjkVar = null;
        if (ordinal == 4) {
            return new zzfjj(zzfjkVar);
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
        synchronized (zzfjl.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
