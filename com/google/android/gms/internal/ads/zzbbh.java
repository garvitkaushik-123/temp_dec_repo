package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbbh implements zzazw {
    final /* synthetic */ zzbbk zza;

    zzbbh(zzbbk zzbbkVar) {
        Objects.requireNonNull(zzbbkVar);
        this.zza = zzbbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        if (z) {
            this.zza.zzl();
        } else {
            zzbbk.zzh(this.zza);
        }
    }
}
