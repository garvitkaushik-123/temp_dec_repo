package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdts implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzdts(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzdts zza(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzdts(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdtr((zzdtu) this.zza.zzb(), ((zzdtq) this.zzb).zzb());
    }
}
