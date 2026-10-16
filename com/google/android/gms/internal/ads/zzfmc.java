package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfmc implements Runnable {
    final /* synthetic */ float zza;
    final /* synthetic */ zzfmd zzb;

    zzfmc(zzfmd zzfmdVar, float f) {
        this.zza = f;
        Objects.requireNonNull(zzfmdVar);
        this.zzb = zzfmdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfmq zzfmqVar;
        zzfmqVar = this.zzb.zza.zzg;
        zzfmqVar.zze(this.zza);
    }
}
