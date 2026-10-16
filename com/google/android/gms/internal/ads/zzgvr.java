package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgvr extends zzgzh implements zzhat {
    private static final zzgvr zza;
    private static volatile zzhba zzb;
    private int zzc;

    static {
        zzgvr zzgvrVar = new zzgvr();
        zza = zzgvrVar;
        zzgzh.zzbZ(zzgvr.class, zzgvrVar);
    }

    private zzgvr() {
    }

    public static zzgvp zzb() {
        return (zzgvp) zza.zzaZ();
    }

    public static zzgvr zzd() {
        return zza;
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
        }
        if (ordinal == 3) {
            return new zzgvr();
        }
        zzgvq zzgvqVar = null;
        if (ordinal == 4) {
            return new zzgvp(zzgvqVar);
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
        synchronized (zzgvr.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
