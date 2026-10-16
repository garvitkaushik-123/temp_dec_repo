package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhff extends zzgzh implements zzhat {
    private static final zzhff zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzhff zzhffVar = new zzhff();
        zza = zzhffVar;
        zzgzh.zzbZ(zzhff.class, zzhffVar);
    }

    private zzhff() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            zzgzn zzgznVar = zzhfe.zza;
            return zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", zzgznVar, "zze", zzgznVar});
        }
        if (ordinal == 3) {
            return new zzhff();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhfd(zzhfxVar);
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
        synchronized (zzhff.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
