package com.google.android.gms.internal.ads;

import com.ironsource.C3061e8;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcbo implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcbp zzb;

    zzcbo(zzcbp zzcbpVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzcbpVar);
        this.zzb = zzcbpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", C3061e8.k, String.valueOf(this.zza));
    }
}
