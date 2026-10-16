package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzemd implements zzeuc {
    private final Clock zza;
    private final zzfcw zzb;

    zzemd(Clock clock, zzfcw zzfcwVar) {
        this.zza = clock;
        this.zzb = zzfcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        return zzgdn.zzh(new zzeme(this.zzb, this.zza.currentTimeMillis()));
    }
}
