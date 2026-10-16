package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@22.4.0 */
/* loaded from: classes5.dex */
final class zzjk implements Runnable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjp zzc;

    zzjk(zzjp zzjpVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        this.zzc = zzjpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpv zzpvVar;
        zzpv zzpvVar2;
        zzjp zzjpVar = this.zzc;
        zzpvVar = zzjpVar.zza;
        zzpvVar.zzL();
        zzpvVar2 = zzjpVar.zza;
        zzpvVar2.zzT(this.zza, this.zzb);
    }
}
