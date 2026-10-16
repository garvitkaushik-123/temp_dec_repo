package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zzmw extends zzgn {
    final /* synthetic */ AtomicReference zza;

    zzmw(zzny zznyVar, AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override // com.google.android.gms.measurement.internal.zzgo
    public final void zze(List list) {
        AtomicReference atomicReference = this.zza;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
