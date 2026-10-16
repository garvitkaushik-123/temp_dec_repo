package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbta extends zzbhs {
    final /* synthetic */ zzbtd zza;

    /* synthetic */ zzbta(zzbtd zzbtdVar, zzbtc zzbtcVar) {
        Objects.requireNonNull(zzbtdVar);
        this.zza = zzbtdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbht
    public final void zze(zzbhj zzbhjVar, String str) {
        zzbtd zzbtdVar = this.zza;
        if (zzbtdVar.zzb == null) {
            return;
        }
        zzbtdVar.zzb.onCustomClick(zzbtdVar.zzf(zzbhjVar), str);
    }
}
