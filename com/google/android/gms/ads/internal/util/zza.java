package com.google.android.gms.ads.internal.util;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zza implements Runnable {
    final /* synthetic */ zzb zza;

    zza(zzb zzbVar) {
        Objects.requireNonNull(zzbVar);
        this.zza = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.zza;
        zzbVar.zzb = Thread.currentThread();
        zzbVar.zza();
    }
}
