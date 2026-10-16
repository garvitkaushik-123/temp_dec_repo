package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgel extends zzgdd {
    private ListenableFuture zza;
    private ScheduledFuture zzb;

    static ListenableFuture zzf(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgel zzgelVar = new zzgel(listenableFuture);
        zzgei zzgeiVar = new zzgei(zzgelVar);
        zzgelVar.zzb = scheduledExecutorService.schedule(zzgeiVar, j, timeUnit);
        listenableFuture.addListener(zzgeiVar, zzgdb.INSTANCE);
        return zzgelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final String zza() {
        ListenableFuture listenableFuture = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (listenableFuture == null) {
            return null;
        }
        String str = "inputFuture=[" + listenableFuture.toString() + C3040d4.i.e;
        if (scheduledFuture == null) {
            return str;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return str;
        }
        return str + ", remaining delay=[" + delay + " ms]";
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    protected final void zzb() {
        zzl(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }

    private zzgel(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
    }
}
