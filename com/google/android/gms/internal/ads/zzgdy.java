package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public interface zzgdy extends ExecutorService {
    ListenableFuture zza(Runnable runnable);

    ListenableFuture zzb(Callable callable);
}
