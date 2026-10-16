package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhed extends zzgzh implements zzhat {
    private static final zzhed zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgxz zze;
    private zzgxz zzf;

    static {
        zzhed zzhedVar = new zzhed();
        zza = zzhedVar;
        zzgzh.zzbZ(zzhed.class, zzhedVar);
    }

    private zzhed() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zze = zzgxzVar;
        this.zzf = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzhed();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhec(zzhfxVar);
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
        synchronized (zzhed.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
