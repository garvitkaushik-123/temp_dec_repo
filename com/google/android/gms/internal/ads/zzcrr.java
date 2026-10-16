package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcrr implements zzhgr {
    private final zzcrq zza;

    private zzcrr(zzcrq zzcrqVar) {
        this.zza = zzcrqVar;
    }

    public static zzcrr zza(zzcrq zzcrqVar) {
        return new zzcrr(zzcrqVar);
    }

    public static zzfca zzd(zzcrq zzcrqVar) {
        zzfca zza = zzcrqVar.zza();
        zzhgz.zzb(zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final zzfca zzc() {
        return zzd(this.zza);
    }
}
