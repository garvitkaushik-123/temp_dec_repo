package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcbb implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcbf zzc;

    zzcbb(zzcbf zzcbfVar, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        Objects.requireNonNull(zzcbfVar);
        this.zzc = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbg zzcbgVar;
        zzcbg zzcbgVar2;
        zzcbf zzcbfVar = this.zzc;
        zzcbgVar = zzcbfVar.zzr;
        if (zzcbgVar != null) {
            int i = this.zza;
            int i2 = this.zzb;
            zzcbgVar2 = zzcbfVar.zzr;
            zzcbgVar2.zzj(i, i2);
        }
    }
}
