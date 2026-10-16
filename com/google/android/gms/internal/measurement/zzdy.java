package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.4.0 */
/* loaded from: classes5.dex */
final class zzdy extends zzda {
    final /* synthetic */ Runnable zza;

    zzdy(zzdz zzdzVar, Runnable runnable) {
        this.zza = runnable;
    }

    @Override // com.google.android.gms.internal.measurement.zzdb
    public final void zze() {
        this.zza.run();
    }
}
