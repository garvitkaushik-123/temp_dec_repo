package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzkm implements zzlz {
    final /* synthetic */ zzkt zza;

    zzkm(zzkt zzktVar) {
        Objects.requireNonNull(zzktVar);
        this.zza = zzktVar;
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final void zza() {
        boolean zzax;
        zzdt zzdtVar;
        zzkt zzktVar = this.zza;
        zzax = zzktVar.zzax();
        if (zzax) {
            zzdtVar = zzktVar.zzi;
            zzdtVar.zzj(2);
        }
    }
}
