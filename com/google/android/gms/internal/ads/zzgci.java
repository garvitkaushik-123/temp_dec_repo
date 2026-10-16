package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgci extends zzgck {
    zzgci(ListenableFuture listenableFuture, zzgcu zzgcuVar) {
        super(listenableFuture, zzgcuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgck
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzgcu zzgcuVar = (zzgcu) obj;
        ListenableFuture zza = zzgcuVar.zza(obj2);
        zzfvp.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgcuVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgck
    final /* synthetic */ void zzf(Object obj) {
        zzn((ListenableFuture) obj);
    }
}
