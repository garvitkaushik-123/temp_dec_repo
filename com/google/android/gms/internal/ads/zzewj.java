package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzewj implements zzhgr {
    private final zzewi zza;

    private zzewj(zzewi zzewiVar) {
        this.zza = zzewiVar;
    }

    public static zzewj zza(zzewi zzewiVar) {
        return new zzewj(zzewiVar);
    }

    public static String zzd(zzewi zzewiVar) {
        String zze = zzewiVar.zze();
        zzhgz.zzb(zze);
        return zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final String zzc() {
        return zzd(this.zza);
    }
}
