package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfgi {
    final /* synthetic */ zzfgs zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfgi(zzfgs zzfgsVar, Object obj, List list, zzfgr zzfgrVar) {
        Objects.requireNonNull(zzfgsVar);
        this.zza = zzfgsVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfgq zza(Callable callable) {
        zzgdy zzgdyVar;
        List list = this.zzc;
        zzgdl zzb = zzgdn.zzb(list);
        ListenableFuture zza = zzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfgh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcaf.zzg);
        zzfgs zzfgsVar = this.zza;
        zzgdyVar = zzfgsVar.zzb;
        return new zzfgq(zzfgsVar, this.zzb, zza, list, zzb.zza(callable, zzgdyVar));
    }
}
