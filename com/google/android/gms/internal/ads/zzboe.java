package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzboe implements zzcam {
    final /* synthetic */ zzboc zza;

    zzboe(zzboh zzbohVar, zzboc zzbocVar) {
        this.zza = zzbocVar;
        Objects.requireNonNull(zzbohVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("Rejecting reference for JS Engine.");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhZ)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
