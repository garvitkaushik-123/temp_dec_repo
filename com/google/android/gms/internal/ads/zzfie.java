package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfie extends zzgzh implements zzhat {
    private static final zzfie zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzfib zzd;

    static {
        zzfie zzfieVar = new zzfie();
        zza = zzfieVar;
        zzgzh.zzbZ(zzfie.class, zzfieVar);
    }

    private zzfie() {
    }

    public static zzfid zza() {
        return (zzfid) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfie zzfieVar, zzfib zzfibVar) {
        zzfibVar.getClass();
        zzfieVar.zzd = zzfibVar;
        zzfieVar.zzc |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (ordinal == 3) {
            return new zzfie();
        }
        zzfif zzfifVar = null;
        if (ordinal == 4) {
            return new zzfid(zzfifVar);
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
        synchronized (zzfie.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
