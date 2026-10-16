package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfmd implements Runnable {
    final /* synthetic */ zzfme zza;

    zzfmd(zzfme zzfmeVar) {
        Objects.requireNonNull(zzfmeVar);
        this.zza = zzfmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicBoolean atomicBoolean;
        AtomicReference atomicReference;
        Handler handler;
        zzfme zzfmeVar = this.zza;
        float zza = zzfme.zza(zzfmeVar);
        atomicBoolean = zzfmeVar.zze;
        atomicBoolean.set(false);
        atomicReference = zzfmeVar.zzd;
        if (((Float) atomicReference.getAndSet(Float.valueOf(zza))).floatValue() != zza) {
            handler = zzfmeVar.zza;
            handler.post(new zzfmc(this, zza));
        }
    }
}
