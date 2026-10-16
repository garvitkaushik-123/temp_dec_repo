package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgtx extends zzgzh implements zzhat {
    private static final zzgtx zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;

    static {
        zzgtx zzgtxVar = new zzgtx();
        zza = zzgtxVar;
        zzgzh.zzbZ(zzgtx.class, zzgtxVar);
    }

    private zzgtx() {
    }

    public static zzgtv zzc() {
        return (zzgtv) zza.zzaZ();
    }

    public static zzgtx zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgto zzb() {
        int i = this.zzc;
        zzgto zzgtoVar = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? null : zzgto.SHA224 : zzgto.SHA512 : zzgto.SHA256 : zzgto.SHA384 : zzgto.SHA1 : zzgto.UNKNOWN_HASH;
        return zzgtoVar == null ? zzgto.UNRECOGNIZED : zzgtoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
        }
        if (ordinal == 3) {
            return new zzgtx();
        }
        zzgtw zzgtwVar = null;
        if (ordinal == 4) {
            return new zzgtv(zzgtwVar);
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
        synchronized (zzgtx.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
