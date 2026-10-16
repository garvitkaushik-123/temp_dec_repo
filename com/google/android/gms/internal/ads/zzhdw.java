package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhdw extends zzgzh implements zzhat {
    private static final zzhdw zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd;
    private zzgxz zze;
    private byte zzf = 2;

    static {
        zzhdw zzhdwVar = new zzhdw();
        zza = zzhdwVar;
        zzgzh.zzbZ(zzhdw.class, zzhdwVar);
    }

    private zzhdw() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzd = zzgxzVar;
        this.zze = zzgxzVar;
    }

    public static zzhdv zzc() {
        return (zzhdv) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhdw zzhdwVar, zzgxz zzgxzVar) {
        zzhdwVar.zzc |= 1;
        zzhdwVar.zzd = zzgxzVar;
    }

    static /* synthetic */ void zzg(zzhdw zzhdwVar, zzgxz zzgxzVar) {
        zzhdwVar.zzc |= 2;
        zzhdwVar.zze = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        zzhfx zzhfxVar = null;
        switch (zzgzgVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzf);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzf = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
            case NEW_MUTABLE_INSTANCE:
                return new zzhdw();
            case NEW_BUILDER:
                return new zzhdv(zzhfxVar);
            case GET_DEFAULT_INSTANCE:
                return zza;
            case GET_PARSER:
                zzhba zzhbaVar2 = zzb;
                if (zzhbaVar2 != null) {
                    return zzhbaVar2;
                }
                synchronized (zzhdw.class) {
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
