package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhee extends zzgzh implements zzhat {
    private static final zzhee zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzhed zzd;
    private zzgxz zzf;
    private zzgxz zzg;
    private int zzh;
    private zzgxz zzi;
    private byte zzj = 2;
    private zzgzt zze = zzbK();

    static {
        zzhee zzheeVar = new zzhee();
        zza = zzheeVar;
        zzgzh.zzbZ(zzhee.class, zzheeVar);
    }

    private zzhee() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzf = zzgxzVar;
        this.zzg = zzgxzVar;
        this.zzi = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        zzhfx zzhfxVar = null;
        switch (zzgzgVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzj);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzj = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", "zzd", "zze", zzhdw.class, "zzf", "zzg", "zzh", "zzi"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhee();
            case NEW_BUILDER:
                return new zzheb(zzhfxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzhba zzhbaVar2 = zzb;
                if (zzhbaVar2 != null) {
                    return zzhbaVar2;
                }
                synchronized (zzhee.class) {
                    zzhbaVar = zzb;
                    if (zzhbaVar == null) {
                        zzhbaVar = new zzgzc(zza);
                        zzb = zzhbaVar;
                    }
                }
                return zzhbaVar;
            default:
                throw null;
        }
    }
}
