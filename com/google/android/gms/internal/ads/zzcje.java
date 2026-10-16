package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcje implements zzdtu {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    private final Context zze;
    private final zzble zzf;
    private final zzcio zzg;
    private final zzcje zzh = this;

    zzcje(zzcio zzcioVar, Context context, zzble zzbleVar) {
        this.zzg = zzcioVar;
        this.zze = context;
        this.zzf = zzbleVar;
        zzhgr zza = zzhgs.zza(this);
        this.zza = zza;
        zzhgr zza2 = zzhgs.zza(zzbleVar);
        this.zzb = zza2;
        zzdtq zzd = zzdtq.zzd(zza2);
        this.zzc = zzd;
        this.zzd = zzhgq.zzc(zzdts.zza(zza, zzd));
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdtl zzb() {
        return new zzcjb(this.zzg, this.zzh, null);
    }

    final zzdtp zzc() {
        return zzdtq.zzc(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdtr zzd() {
        return (zzdtr) this.zzd.zzb();
    }
}
