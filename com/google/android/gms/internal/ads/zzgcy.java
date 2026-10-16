package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgcy extends zzgcz {
    final /* synthetic */ zzgda zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgcy(zzgda zzgdaVar, Callable callable, Executor executor) {
        super(zzgdaVar, executor);
        Objects.requireNonNull(zzgdaVar);
        this.zza = zzgdaVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final String zzb() {
        return this.zzc.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgcz
    final void zzc(Object obj) {
        this.zza.zzc(obj);
    }
}
