package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcde implements Runnable {
    final /* synthetic */ zzcdf zza;

    zzcde(zzcdf zzcdfVar) {
        Objects.requireNonNull(zzcdfVar);
        this.zza = zzcdfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzv.zzA().zzc(this.zza);
    }
}
