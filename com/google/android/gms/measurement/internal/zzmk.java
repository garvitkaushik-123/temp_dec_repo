package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes5.dex */
final class zzmk implements Runnable {
    final /* synthetic */ zzmo zza;

    zzmk(zzmo zzmoVar) {
        this.zza = zzmoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmh zzmhVar;
        zzmo zzmoVar = this.zza;
        zzmhVar = zzmoVar.zzh;
        zzmoVar.zza = zzmhVar;
    }
}
