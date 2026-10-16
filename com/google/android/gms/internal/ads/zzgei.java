package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgei implements Runnable {
    zzgel zza;

    zzgei(zzgel zzgelVar) {
        this.zza = zzgelVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r2 = r1.zza;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        ListenableFuture listenableFuture;
        ScheduledFuture scheduledFuture;
        zzgel zzgelVar = this.zza;
        if (zzgelVar == null || listenableFuture == null) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isDone()) {
            zzgelVar.zzn(listenableFuture);
            return;
        }
        try {
            scheduledFuture = zzgelVar.zzb;
            zzgelVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgelVar.zzd(new zzgej(str, null));
                    throw th;
                }
            }
            zzgelVar.zzd(new zzgej(str + ": " + listenableFuture.toString(), null));
        } finally {
            listenableFuture.cancel(true);
        }
    }
}
