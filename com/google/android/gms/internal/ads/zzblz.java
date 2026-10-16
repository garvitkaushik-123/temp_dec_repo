package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzblz implements Runnable {
    final /* synthetic */ zzbmc zza;

    zzblz(zzbmc zzbmcVar) {
        Objects.requireNonNull(zzbmcVar);
        this.zza = zzbmcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbmc.zzc(this.zza);
    }
}
