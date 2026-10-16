package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzct implements Runnable {
    final Future zza;
    final zzcs zzb;

    zzct(Future future, zzcs zzcsVar) {
        this.zza = future;
        this.zzb = zzcsVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza;
        Future future = this.zza;
        if ((future instanceof zzdf) && (zza = zzdg.zza((zzdf) future)) != null) {
            this.zzb.zza(zza);
            return;
        }
        try {
            if (!future.isDone()) {
                throw new IllegalStateException(zzbj.zza("Future was expected to be done: %s", future));
            }
            boolean z = false;
            Future future2 = future;
            while (true) {
                try {
                    obj = future2.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                    future2 = future2;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    public final String toString() {
        zzbc zza = zzbe.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
