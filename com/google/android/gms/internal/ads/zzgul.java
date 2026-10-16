package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgul extends zzgzh implements zzhat {
    private static final zzgul zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgub zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgul zzgulVar = new zzgul();
        zza = zzgulVar;
        zzgzh.zzbZ(zzgul.class, zzgulVar);
    }

    private zzgul() {
    }

    public static zzguk zzc() {
        return (zzguk) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzgul zzgulVar, zzgub zzgubVar) {
        zzgubVar.getClass();
        zzgulVar.zzd = zzgubVar;
        zzgulVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgub zzb() {
        zzgub zzgubVar = this.zzd;
        return zzgubVar == null ? zzgub.zzd() : zzgubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (ordinal == 3) {
            return new zzgul();
        }
        zzgum zzgumVar = null;
        if (ordinal == 4) {
            return new zzguk(zzgumVar);
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
        synchronized (zzgul.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgvf zzf() {
        zzgvf zzb2 = zzgvf.zzb(this.zzg);
        return zzb2 == null ? zzgvf.UNRECOGNIZED : zzb2;
    }

    public final boolean zzj() {
        return (this.zzc & 1) != 0;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = i != 0 ? i != 1 ? i != 2 ? i != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
