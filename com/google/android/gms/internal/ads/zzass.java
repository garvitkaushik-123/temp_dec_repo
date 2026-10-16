package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzass extends zzgzh implements zzhat {
    public static final /* synthetic */ int zza = 0;
    private static final zzass zzb;
    private static volatile zzhba zzc;
    private int zzd;
    private boolean zzf;
    private boolean zzg;
    private long zze = 100;
    private long zzh = 300;
    private long zzi = 1000;

    static {
        zzass zzassVar = new zzass();
        zzb = zzassVar;
        zzgzh.zzbZ(zzass.class, zzassVar);
    }

    private zzass() {
    }

    public static zzass zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (ordinal == 3) {
            return new zzass();
        }
        zzasr zzasrVar = null;
        if (ordinal == 4) {
            return new zzasq(zzasrVar);
        }
        if (ordinal == 5) {
            return zzb;
        }
        if (ordinal != 6) {
            throw null;
        }
        zzhba zzhbaVar2 = zzc;
        if (zzhbaVar2 != null) {
            return zzhbaVar2;
        }
        synchronized (zzass.class) {
            zzhbaVar = zzc;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zzb);
                zzc = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
