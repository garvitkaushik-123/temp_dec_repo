package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgem extends zzgdv {
    final /* synthetic */ zzgeo zza;
    private final zzgct zzb;

    zzgem(zzgeo zzgeoVar, zzgct zzgctVar) {
        Objects.requireNonNull(zzgeoVar);
        this.zza = zzgeoVar;
        this.zzb = zzgctVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgct zzgctVar = this.zzb;
        ListenableFuture zza = zzgctVar.zza();
        zzfvp.zzd(zza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgctVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final /* synthetic */ void zze(Object obj) {
        this.zza.zzn((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final boolean zzg() {
        return this.zza.isDone();
    }
}
