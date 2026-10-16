package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzerk implements zzeuc {
    private final zzgdy zza;
    private final zzfcw zzb;

    zzerk(zzgdy zzgdyVar, zzfcw zzfcwVar) {
        this.zza = zzgdyVar;
        this.zzb = zzfcwVar;
    }

    public static /* synthetic */ zzerl zzc(zzerk zzerkVar) {
        return new zzerl("requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzerkVar.zzb.zzd)));
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 21;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzerj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzerk.zzc(zzerk.this);
            }
        });
    }
}
