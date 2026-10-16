package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgtr extends zzgzh implements zzhat {
    private static final zzgtr zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgtx zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgtr zzgtrVar = new zzgtr();
        zza = zzgtrVar;
        zzgzh.zzbZ(zzgtr.class, zzgtrVar);
    }

    private zzgtr() {
    }

    public static zzgtp zzb() {
        return (zzgtp) zza.zzaZ();
    }

    public static zzgtr zzd() {
        return zza;
    }

    public static zzgtr zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) throws zzgzw {
        return (zzgtr) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzi() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzk(zzgtr zzgtrVar, zzgtx zzgtxVar) {
        zzgtxVar.getClass();
        zzgtrVar.zze = zzgtxVar;
        zzgtrVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzgtr();
        }
        zzgtq zzgtqVar = null;
        if (ordinal == 4) {
            return new zzgtp(zzgtqVar);
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
        synchronized (zzgtr.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgtx zzg() {
        zzgtx zzgtxVar = this.zze;
        return zzgtxVar == null ? zzgtx.zzf() : zzgtxVar;
    }

    public final zzgxz zzh() {
        return this.zzf;
    }
}
