package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-appset@@16.0.0 */
/* loaded from: classes5.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    /* synthetic */ zzj(zzl zzlVar, zzi zziVar) {
        this.zza = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        long zza = this.zza.zza();
        if (zza == -1 || DefaultClock.getInstance().currentTimeMillis() <= zza) {
            return;
        }
        context = this.zza.zzb;
        zzl.zze(context);
    }
}
