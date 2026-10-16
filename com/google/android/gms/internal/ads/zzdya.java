package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdya implements zzgdj {
    final /* synthetic */ zzdyb zza;

    zzdya(zzdyb zzdybVar) {
        Objects.requireNonNull(zzdybVar);
        this.zza = zzdybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcyy zzcyyVar;
        zzfcn zzfcnVar = (zzfcn) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcv)).booleanValue()) {
            zzcyyVar = this.zza.zzl;
            zzcyyVar.zzdo(zzfcnVar);
        }
    }
}
