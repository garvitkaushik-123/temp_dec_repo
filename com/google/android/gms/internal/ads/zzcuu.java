package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcuu {
    private final AtomicLong zza;

    zzcuu(zzfcn zzfcnVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.zza = atomicLong;
        atomicLong.set(zzfcnVar.zza.zza.zzt.get());
    }

    public final long zza() {
        return this.zza.get();
    }

    public final void zzb(long j) {
        this.zza.set(j);
    }
}
