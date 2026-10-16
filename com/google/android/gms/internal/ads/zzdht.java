package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdht implements zzhgr {
    private final zzhha zza;

    private zzdht(zzdhp zzdhpVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdht zza(zzdhp zzdhpVar, zzhha zzhhaVar) {
        return new zzdht(zzdhpVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdjb zzb() {
        zzdhn zzdhnVar = (zzdhn) this.zza.zzb();
        zzhgz.zzb(zzdhnVar);
        return zzdhnVar;
    }
}
