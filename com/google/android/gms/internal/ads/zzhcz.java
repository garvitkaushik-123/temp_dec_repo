package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhcz extends zzgzh implements zzhat {
    private static final zzhcz zza;
    private static volatile zzhba zzb;
    private zzgzt zzc = zzbK();

    static {
        zzhcz zzhczVar = new zzhcz();
        zza = zzhczVar;
        zzgzh.zzbZ(zzhcz.class, zzhczVar);
    }

    private zzhcz() {
    }

    public static zzhcy zzc() {
        return (zzhcy) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhcz zzhczVar, zzhcx zzhcxVar) {
        zzhcxVar.getClass();
        zzgzt zzgztVar = zzhczVar.zzc;
        if (!zzgztVar.zzc()) {
            zzhczVar.zzc = zzgzh.zzbL(zzgztVar);
        }
        zzhczVar.zzc.add(zzhcxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhcx.class});
        }
        if (ordinal == 3) {
            return new zzhcz();
        }
        zzhda zzhdaVar = null;
        if (ordinal == 4) {
            return new zzhcy(zzhdaVar);
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
        synchronized (zzhcz.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
