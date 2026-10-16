package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@Deprecated
/* loaded from: classes5.dex */
public final class zzgvi extends zzgzh implements zzhat {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvi zzb;
    private static volatile zzhba zzc;
    private String zzd = "";
    private zzgzt zze = zzbK();

    static {
        zzgvi zzgviVar = new zzgvi();
        zzb = zzgviVar;
        zzgzh.zzbZ(zzgvi.class, zzgviVar);
    }

    private zzgvi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    protected final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        zzhba zzhbaVar;
        int ordinal = zzgzgVar.ordinal();
        if (ordinal == 0) {
            return (byte) 1;
        }
        if (ordinal == 2) {
            return zzbQ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgui.class});
        }
        if (ordinal == 3) {
            return new zzgvi();
        }
        zzgvh zzgvhVar = null;
        if (ordinal == 4) {
            return new zzgvg(zzgvhVar);
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
        synchronized (zzgvi.class) {
            zzhbaVar = zzc;
            if (zzhbaVar == null) {
                zzhbaVar = new zzgzc(zzb);
                zzc = zzhbaVar;
            }
        }
        return zzhbaVar;
    }
}
