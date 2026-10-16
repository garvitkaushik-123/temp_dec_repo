package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgsj extends zzgzh implements zzhat {
    private static final zzgsj zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgsm zzd;
    private int zze;

    static {
        zzgsj zzgsjVar = new zzgsj();
        zza = zzgsjVar;
        zzgzh.zzbZ(zzgsj.class, zzgsjVar);
    }

    private zzgsj() {
    }

    public static zzgsh zzb() {
        return (zzgsh) zza.zzaZ();
    }

    public static zzgsj zzd() {
        return zza;
    }

    static /* synthetic */ void zzh(zzgsj zzgsjVar, zzgsm zzgsmVar) {
        zzgsmVar.getClass();
        zzgsjVar.zzd = zzgsmVar;
        zzgsjVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
        }
        if (ordinal == 3) {
            return new zzgsj();
        }
        zzgsi zzgsiVar = null;
        if (ordinal == 4) {
            return new zzgsh(zzgsiVar);
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
        synchronized (zzgsj.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgsm zzf() {
        zzgsm zzgsmVar = this.zzd;
        return zzgsmVar == null ? zzgsm.zzd() : zzgsmVar;
    }
}
