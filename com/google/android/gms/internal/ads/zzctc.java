package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzctc implements zzdbq, zzcxm {
    private final Clock zza;
    private final zzcte zzb;
    private final zzfcw zzc;
    private final String zzd;

    zzctc(Clock clock, zzcte zzcteVar, zzfcw zzfcwVar, String str) {
        this.zza = clock;
        this.zzb = zzcteVar;
        this.zzc = zzfcwVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdbq
    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        Clock clock = this.zza;
        this.zzb.zzd(this.zzc.zzf, this.zzd, clock.elapsedRealtime());
    }
}
