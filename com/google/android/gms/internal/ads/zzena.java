package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzena {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzemz zzb;

    final zzemz zza() {
        return this.zzb;
    }

    final void zzb(zzemz zzemzVar) {
        this.zzb = zzemzVar;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
