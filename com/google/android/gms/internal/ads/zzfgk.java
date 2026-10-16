package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfgk {
    public static final zzfgq zza(Callable callable, Object obj, zzfgs zzfgsVar) {
        zzgdy zzgdyVar;
        zzgdyVar = zzfgsVar.zzb;
        return zzb(callable, zzgdyVar, obj, zzfgsVar);
    }

    public static final zzfgq zzb(Callable callable, zzgdy zzgdyVar, Object obj, zzfgs zzfgsVar) {
        ListenableFuture listenableFuture;
        listenableFuture = zzfgs.zza;
        return new zzfgq(zzfgsVar, obj, listenableFuture, Collections.emptyList(), zzgdyVar.zzb(callable));
    }

    public static final zzfgq zzc(ListenableFuture listenableFuture, Object obj, zzfgs zzfgsVar) {
        ListenableFuture listenableFuture2;
        listenableFuture2 = zzfgs.zza;
        return new zzfgq(zzfgsVar, obj, listenableFuture2, Collections.emptyList(), listenableFuture);
    }

    public static final zzfgq zzd(final zzfgf zzfgfVar, zzgdy zzgdyVar, Object obj, zzfgs zzfgsVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfgj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfgf.this.zza();
                return null;
            }
        }, zzgdyVar, obj, zzfgsVar);
    }
}
