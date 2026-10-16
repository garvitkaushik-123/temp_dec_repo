package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public interface zzgdz extends ScheduledExecutorService, zzgdy {
    zzgdx zzc(Callable callable, long j, TimeUnit timeUnit);
}
