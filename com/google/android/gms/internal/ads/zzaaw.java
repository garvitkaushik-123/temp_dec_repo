package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaaw implements zzacm {
    final /* synthetic */ zztf zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzaba zzd;

    zzaaw(zzaba zzabaVar, zztf zztfVar, int i, long j) {
        this.zza = zztfVar;
        this.zzb = i;
        this.zzc = j;
        Objects.requireNonNull(zzabaVar);
        this.zzd = zzabaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zza(long j) {
        this.zzd.zzam(this.zza, this.zzb, this.zzc, j);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzb() {
        this.zzd.zzas(this.zza, this.zzb, this.zzc);
    }
}
