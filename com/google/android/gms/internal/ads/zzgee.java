package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgee extends zzgeb implements AutoCloseable, zzgdz {
    final ScheduledExecutorService zza;

    zzgee(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzgch, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        if (this == ForkJoinPool.commonPool() || isTerminated()) {
            return;
        }
        shutdown();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                z = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z2) {
                    shutdownNow();
                }
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgeo zze = zzgeo.zze(runnable, null);
        return new zzgec(zze, scheduledExecutorService.schedule(zze, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzged zzgedVar = new zzged(runnable);
        return new zzgec(zzgedVar, this.zza.scheduleAtFixedRate(zzgedVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzged zzgedVar = new zzged(runnable);
        return new zzgec(zzgedVar, this.zza.scheduleWithFixedDelay(zzgedVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzgdx schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgeo zzgeoVar = new zzgeo(callable);
        return new zzgec(zzgeoVar, this.zza.schedule(zzgeoVar, j, timeUnit));
    }
}
