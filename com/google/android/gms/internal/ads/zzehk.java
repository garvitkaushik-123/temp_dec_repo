package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzehk {
    private zzehb zza;

    zzehk() {
    }

    private zzehk(zzehb zzehbVar) {
        this.zza = zzehbVar;
    }

    public static zzehk zzb(zzehb zzehbVar) {
        return new zzehk(zzehbVar);
    }

    public final zzehb zza(Clock clock, zzehd zzehdVar, zzedr zzedrVar, zzfjy zzfjyVar) {
        zzehb zzehbVar = this.zza;
        return zzehbVar != null ? zzehbVar : new zzehb(clock, zzehdVar, zzedrVar, zzfjyVar);
    }
}
