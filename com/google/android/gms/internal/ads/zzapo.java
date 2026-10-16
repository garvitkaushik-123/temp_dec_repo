package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzapo implements Runnable {
    final /* synthetic */ zzaqd zza;
    final /* synthetic */ zzapp zzb;

    zzapo(zzapp zzappVar, zzaqd zzaqdVar) {
        this.zza = zzaqdVar;
        Objects.requireNonNull(zzappVar);
        this.zzb = zzappVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BlockingQueue blockingQueue;
        try {
            blockingQueue = this.zzb.zzc;
            blockingQueue.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
