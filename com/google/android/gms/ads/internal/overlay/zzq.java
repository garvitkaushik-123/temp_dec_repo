package com.google.android.gms.ads.internal.overlay;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzq implements Callable {
    private final long zza;

    zzq(long j) {
        this.zza = j;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ConcurrentHashMap concurrentHashMap;
        long j = this.zza;
        concurrentHashMap = AdOverlayInfoParcel.zzz;
        if (concurrentHashMap.remove(Long.valueOf(j)) == null) {
            return null;
        }
        com.google.android.gms.ads.internal.zzv.zzp().zzw(new Exception("Key was non-null in AdOverlayObjectsCleanupTask"), "AdOverlayObjectsCleanupTask");
        return null;
    }
}
