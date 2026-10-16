package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfig extends zzgzh implements zzhat {
    private static final zzfig zza;
    private static volatile zzhba zzb;
    private zzgzt zzc = zzbK();

    static {
        zzfig zzfigVar = new zzfig();
        zza = zzfigVar;
        zzgzh.zzbZ(zzfig.class, zzfigVar);
    }

    private zzfig() {
    }

    public static zzfic zzb() {
        return (zzfic) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzfig zzfigVar, zzfie zzfieVar) {
        zzfieVar.getClass();
        zzgzt zzgztVar = zzfigVar.zzc;
        if (!zzgztVar.zzc()) {
            zzfigVar.zzc = zzgzh.zzbL(zzgztVar);
        }
        zzfigVar.zzc.add(zzfieVar);
    }

    public final int zza() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfie.class});
        }
        if (ordinal == 3) {
            return new zzfig();
        }
        zzfif zzfifVar = null;
        if (ordinal == 4) {
            return new zzfic(zzfifVar);
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
        synchronized (zzfig.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
