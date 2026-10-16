package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zzlo implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzlw zzb;

    zzlo(zzlw zzlwVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
        this.zzb = zzlwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            try {
                zzlw zzlwVar = this.zzb;
                atomicReference.set(Double.valueOf(zzlwVar.zzu.zzf().zza(zzlwVar.zzu.zzh().zzm(), zzgi.zzad)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
