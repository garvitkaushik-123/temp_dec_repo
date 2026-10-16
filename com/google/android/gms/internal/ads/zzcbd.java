package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcbd implements Runnable {
    final /* synthetic */ zzcbf zza;

    zzcbd(zzcbf zzcbfVar) {
        Objects.requireNonNull(zzcbfVar);
        this.zza = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbg zzcbgVar;
        boolean z;
        zzcbg zzcbgVar2;
        zzcbg zzcbgVar3;
        zzcbf zzcbfVar = this.zza;
        zzcbgVar = zzcbfVar.zzr;
        if (zzcbgVar != null) {
            z = zzcbfVar.zzs;
            if (!z) {
                zzcbgVar3 = zzcbfVar.zzr;
                zzcbgVar3.zzg();
                zzcbfVar.zzs = true;
            }
            zzcbgVar2 = zzcbfVar.zzr;
            zzcbgVar2.zze();
        }
    }
}
