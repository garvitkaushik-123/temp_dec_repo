package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcbm implements Runnable {
    final /* synthetic */ zzcbp zza;

    zzcbm(zzcbp zzcbpVar) {
        Objects.requireNonNull(zzcbpVar);
        this.zza = zzcbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceCreated", new String[0]);
    }
}
