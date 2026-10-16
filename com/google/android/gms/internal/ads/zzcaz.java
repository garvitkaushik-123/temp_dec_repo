package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcaz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcbf zzc;

    zzcaz(zzcbf zzcbfVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
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
            String str = this.zza;
            String str2 = this.zzb;
            zzcbgVar2 = zzcbfVar.zzr;
            zzcbgVar2.zzb(str, str2);
        }
    }
}
