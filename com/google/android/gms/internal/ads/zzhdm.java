package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhdm extends zzgzh implements zzhat {
    private static final zzhdm zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhdm zzhdmVar = new zzhdm();
        zza = zzhdmVar;
        zzgzh.zzbZ(zzhdm.class, zzhdmVar);
    }

    private zzhdm() {
    }

    public static zzhdl zzc() {
        return (zzhdl) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhdm zzhdmVar, String str) {
        zzhdmVar.zzc |= 1;
        zzhdmVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (ordinal == 3) {
            return new zzhdm();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhdl(zzhfxVar);
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
        synchronized (zzhdm.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
