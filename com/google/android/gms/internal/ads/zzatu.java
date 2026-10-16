package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzatu extends zzgzh implements zzhat {
    private static final zzatu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd;
    private zzgxz zze;
    private zzgxz zzf;
    private zzgxz zzg;

    static {
        zzatu zzatuVar = new zzatu();
        zza = zzatuVar;
        zzgzh.zzbZ(zzatu.class, zzatuVar);
    }

    private zzatu() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzd = zzgxzVar;
        this.zze = zzgxzVar;
        this.zzf = zzgxzVar;
        this.zzg = zzgxzVar;
    }

    public static zzatt zza() {
        return (zzatt) zza.zzaZ();
    }

    public static zzatu zzc(byte[] bArr, zzgyr zzgyrVar) throws zzgzw {
        return (zzatu) zzgzh.zzbx(zza, bArr, zzgyrVar);
    }

    static /* synthetic */ void zzi(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 1;
        zzatuVar.zzd = zzgxzVar;
    }

    static /* synthetic */ void zzj(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 2;
        zzatuVar.zze = zzgxzVar;
    }

    static /* synthetic */ void zzk(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 8;
        zzatuVar.zzg = zzgxzVar;
    }

    static /* synthetic */ void zzl(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 4;
        zzatuVar.zzf = zzgxzVar;
    }

    public final zzgxz zzd() {
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
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (ordinal == 3) {
            return new zzatu();
        }
        zzaui zzauiVar = null;
        if (ordinal == 4) {
            return new zzatt(zzauiVar);
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
        synchronized (zzatu.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }

    public final zzgxz zzf() {
        return this.zze;
    }

    public final zzgxz zzg() {
        return this.zzg;
    }

    public final zzgxz zzh() {
        return this.zzf;
    }
}
