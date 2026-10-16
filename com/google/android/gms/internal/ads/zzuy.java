package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzuy {
    private static final AtomicLong zza = new AtomicLong();

    public zzuy(long j, zzgo zzgoVar, long j2) {
        Uri uri = zzgoVar.zza;
        Collections.emptyMap();
    }

    public zzuy(long j, zzgo zzgoVar, Uri uri, Map map, long j2, long j3, long j4) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }
}
