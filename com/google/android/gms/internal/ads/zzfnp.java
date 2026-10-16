package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfnp implements Runnable {
    zzfnp() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        Handler handler3;
        Runnable runnable2;
        handler = zzfns.zzc;
        if (handler != null) {
            handler2 = zzfns.zzc;
            runnable = zzfns.zzd;
            handler2.post(runnable);
            handler3 = zzfns.zzc;
            runnable2 = zzfns.zze;
            handler3.postDelayed(runnable2, 200L);
        }
    }
}
