package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcba implements Runnable {
    final /* synthetic */ zzcbf zza;

    zzcba(zzcbf zzcbfVar) {
        Objects.requireNonNull(zzcbfVar);
        this.zza = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbg zzcbgVar;
        zzcbg zzcbgVar2;
        zzcbf zzcbfVar = this.zza;
        zzcbgVar = zzcbfVar.zzr;
        if (zzcbgVar != null) {
            zzcbgVar2 = zzcbfVar.zzr;
            zzcbgVar2.zzh();
        }
    }
}
