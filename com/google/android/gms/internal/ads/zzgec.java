package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgec extends zzgdh implements zzgdx {
    private final ScheduledFuture zza;

    public zzgec(ListenableFuture listenableFuture, ScheduledFuture scheduledFuture) {
        super(listenableFuture);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzgdg, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = zzb().cancel(z);
        if (cancel) {
            this.zza.cancel(z);
        }
        return cancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
