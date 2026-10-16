package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zznr implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zznx zzb;

    zznr(zznx zznxVar, ComponentName componentName) {
        this.zza = componentName;
        this.zzb = zznxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzny.zzx(this.zzb.zza, this.zza);
    }
}
