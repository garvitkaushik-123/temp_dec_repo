package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgbz extends zzgca {
    zzgbz(ListenableFuture listenableFuture, Class cls, zzfve zzfveVar) {
        super(listenableFuture, cls, zzfveVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final /* synthetic */ Object zze(Object obj, Throwable th) throws Exception {
        return ((zzfve) obj).apply(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgca
    final void zzf(Object obj) {
        zzc(obj);
    }
}
