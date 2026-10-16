package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbyn implements ThreadFactory {
    private final AtomicInteger zza;

    zzbyn(zzbyo zzbyoVar) {
        Objects.requireNonNull(zzbyoVar);
        this.zza = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AdWorker(SCION_TASK_EXECUTOR) #" + this.zza.getAndIncrement());
    }
}
