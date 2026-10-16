package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgby extends zzgca {
    zzgby(ListenableFuture listenableFuture, Class cls, zzgcu zzgcuVar) {
        super(listenableFuture, cls, zzgcuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final /* bridge */ /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        zzgcu zzgcuVar = (zzgcu) obj;
        ListenableFuture zza = zzgcuVar.zza(th);
        zzfvp.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgcuVar);
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final /* synthetic */ void zzf(Object obj) {
        zzn((ListenableFuture) obj);
    }
}
