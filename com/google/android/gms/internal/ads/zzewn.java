package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzewn implements zzhgr {
    private final zzewi zza;

    private zzewn(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewn zza(zzewi zzewiVar) {
        return new zzewn(zzewiVar);
    }

    public static String zzd(zzewi zzewiVar) {
        String zzg = zzewiVar.zzg();
        zzhgz.zzb(zzg);
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final String zzc() {
        return zzd(this.zza);
    }
}
