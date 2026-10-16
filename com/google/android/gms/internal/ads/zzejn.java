package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzejn implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdfc zza;

    zzejn(zzejo zzejoVar, zzdfc zzdfcVar) {
        this.zza = zzdfcVar;
        Objects.requireNonNull(zzejoVar);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdfc zzdfcVar = this.zza;
        zzdfcVar.zzc().zza();
        zzdfcVar.zzf().zza();
    }
}
