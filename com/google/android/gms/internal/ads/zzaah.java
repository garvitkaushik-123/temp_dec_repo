package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaah implements zzaai {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzdn zzb;

    zzaah(Executor executor, zzdn zzdnVar) {
        this.zza = executor;
        this.zzb = zzdnVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzaai
    public final void zza() {
        this.zzb.zza(this.zza);
    }
}
