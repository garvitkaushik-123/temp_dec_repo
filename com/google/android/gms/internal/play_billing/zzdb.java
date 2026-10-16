package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzdb implements Runnable {
    zzde zza;

    zzdb(zzde zzdeVar) {
        this.zza = zzdeVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r2 = r1.zzd;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        zzcz zzczVar;
        ScheduledFuture scheduledFuture;
        zzde zzdeVar = this.zza;
        if (zzdeVar == null || zzczVar == null) {
            return;
        }
        this.zza = null;
        if (zzczVar.isDone()) {
            zzdeVar.zzj(zzczVar);
            return;
        }
        try {
            scheduledFuture = zzdeVar.zze;
            zzdeVar.zze = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzdeVar.zzi(new zzdc(str, null));
                    throw th;
                }
            }
            zzdeVar.zzi(new zzdc(str + ": " + zzczVar.toString(), null));
        } finally {
            zzczVar.cancel(true);
        }
    }
}
