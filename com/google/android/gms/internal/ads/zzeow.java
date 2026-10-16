package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeow implements zzeuc {
    private final zzgdy zza;

    zzeow(zzgdy zzgdyVar) {
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 55;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzeov
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzeox(Long.valueOf(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zza()).longValue());
            }
        });
    }
}
