package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgus extends zzgzh implements zzhat {
    private static final zzgus zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgzt zzd = zzbK();

    static {
        zzgus zzgusVar = new zzgus();
        zza = zzgusVar;
        zzgzh.zzbZ(zzgus.class, zzgusVar);
    }

    private zzgus() {
    }

    public static zzguo zza() {
        return (zzguo) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzgus zzgusVar, zzguq zzguqVar) {
        zzguqVar.getClass();
        zzgzt zzgztVar = zzgusVar.zzd;
        if (!zzgztVar.zzc()) {
            zzgusVar.zzd = zzgzh.zzbL(zzgztVar);
        }
        zzgusVar.zzd.add(zzguqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzguq.class});
        }
        if (ordinal == 3) {
            return new zzgus();
        }
        zzgur zzgurVar = null;
        if (ordinal == 4) {
            return new zzguo(zzgurVar);
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
        synchronized (zzgus.class) {
            zzhbaVar = zzb;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zza);
                zzb = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
