package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
abstract class zzgcz extends zzgdv {
    private final Executor zza;
    final /* synthetic */ zzgda zzb;

    zzgcz(zzgda zzgdaVar, Executor executor) {
        Objects.requireNonNull(zzgdaVar);
        this.zzb = zzgdaVar;
        executor.getClass();
        this.zza = executor;
    }

    abstract void zzc(Object obj);

    @Override // com.google.android.gms.internal.ads.zzgdv
    final void zzd(Throwable th) {
        zzgda zzgdaVar = this.zzb;
        zzgdaVar.zza = null;
        if (th instanceof ExecutionException) {
            zzgdaVar.zzd(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzgdaVar.cancel(false);
        } else {
            zzgdaVar.zzd(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzd(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdv
    final boolean zzg() {
        return this.zzb.isDone();
    }
}
