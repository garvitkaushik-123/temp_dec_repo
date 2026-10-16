package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdlm implements zzgdj {
    final /* synthetic */ zzdrr zza;
    final /* synthetic */ zzdln zzb;

    zzdlm(zzdln zzdlnVar, zzdrr zzdrrVar) {
        this.zza = zzdrrVar;
        Objects.requireNonNull(zzdlnVar);
        this.zzb = zzdlnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzdsd zzdsdVar;
        zzdsdVar = this.zzb.zzd;
        zzdsdVar.zza().putLong(this.zza.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
    }
}
