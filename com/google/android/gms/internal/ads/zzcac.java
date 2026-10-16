package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcac implements Executor {
    private final Handler zza = new com.google.android.gms.ads.internal.util.zzf(Looper.getMainLooper());

    zzcac() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            this.zza.post(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.util.zzs.zzN(com.google.android.gms.ads.internal.zzv.zzp().zzd(), th);
            throw th;
        }
    }
}
