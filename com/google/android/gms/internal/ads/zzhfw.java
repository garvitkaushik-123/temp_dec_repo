package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhfw extends zzgzh implements zzhat {
    private static final zzhfw zza;
    private static volatile zzhba zzb;
    private int zzc;
    private boolean zzj;
    private double zzk;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzu;
    private String zzd = "";
    private String zze = "";
    private int zzf = 4;
    private zzgzt zzg = zzgzh.zzbK();
    private String zzh = "";
    private String zzi = "";
    private zzgzt zzl = zzbK();

    static {
        zzhfw zzhfwVar = new zzhfw();
        zza = zzhfwVar;
        zzgzh.zzbZ(zzhfw.class, zzhfwVar);
    }

    private zzhfw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zzc", "zzd", "zzf", zzhfv.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzhfu.class, "zze", "zzm", zzhfs.zza, "zzn", "zzo", "zzp", "zzu"});
        }
        if (ordinal == 3) {
            return new zzhfw();
        }
        zzhfx zzhfxVar = null;
        if (ordinal == 4) {
            return new zzhfr(zzhfxVar);
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
        synchronized (zzhfw.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
