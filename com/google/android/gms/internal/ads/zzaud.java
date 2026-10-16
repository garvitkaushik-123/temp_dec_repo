package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaud extends zzgzh implements zzhat {
    private static final zzaud zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd;
    private String zze = "";
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzaud zzaudVar = new zzaud();
        zza = zzaudVar;
        zzgzh.zzbZ(zzaud.class, zzaudVar);
    }

    private zzaud() {
    }

    public static zzaud zzc() {
        return zza;
    }

    public final long zza() {
        return this.zzd;
    }

    public final zzgxz zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (ordinal == 3) {
            return new zzaud();
        }
        zzaui zzauiVar = null;
        if (ordinal == 4) {
            return new zzauc(zzauiVar);
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
        synchronized (zzaud.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final String zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return (this.zzc & 1) != 0;
    }
}
