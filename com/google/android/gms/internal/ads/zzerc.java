package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerc implements zzeuc {
    private final zzgdy zza;

    public zzerc(zzgdy zzgdyVar) {
        this.zza = zzgdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 20;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzerd(com.google.android.gms.ads.internal.zzv.zzu().zzb(), com.google.android.gms.ads.internal.zzv.zzu().zzm());
            }
        });
    }
}
