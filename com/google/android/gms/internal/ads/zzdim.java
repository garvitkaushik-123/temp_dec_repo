package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdim implements zzgdj {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdio zzb;

    zzdim(zzdio zzdioVar, String str, boolean z) {
        Objects.requireNonNull(zzdioVar);
        this.zzb = zzdioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfH)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdit zzditVar;
        zzdit zzditVar2;
        zzdio zzdioVar = this.zzb;
        zzditVar = zzdioVar.zze;
        zzditVar.zzT((zzcfg) obj);
        zzditVar2 = zzdioVar.zze;
        zzcak zzp = zzditVar2.zzp();
        zzedh zzf = zzdioVar.zzf(this.zza, true);
        if (zzf != null && zzp != null) {
            zzp.zzc(zzf);
        } else if (zzp != null) {
            zzp.cancel(false);
        }
    }
}
