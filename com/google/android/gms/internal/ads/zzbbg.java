package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbbg implements Runnable {
    final /* synthetic */ zzbbk zza;

    zzbbg(zzbbk zzbbkVar) {
        Objects.requireNonNull(zzbbkVar);
        this.zza = zzbbkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbk.zzh(this.zza);
    }
}
