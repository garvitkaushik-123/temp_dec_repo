package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzagn extends zzaei {
    final /* synthetic */ zzaeu zza;
    final /* synthetic */ zzago zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzagn(zzago zzagoVar, zzaeu zzaeuVar, zzaeu zzaeuVar2) {
        super(zzaeuVar);
        this.zza = zzaeuVar2;
        Objects.requireNonNull(zzagoVar);
        this.zzb = zzagoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaei, com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long j2;
        long j3;
        zzaes zzg = this.zza.zzg(j);
        zzaev zzaevVar = zzg.zza;
        long j4 = zzaevVar.zzc;
        zzago zzagoVar = this.zzb;
        j2 = zzagoVar.zzb;
        zzaev zzaevVar2 = new zzaev(zzaevVar.zzb, j4 + j2);
        zzaev zzaevVar3 = zzg.zzb;
        long j5 = zzaevVar3.zzc;
        j3 = zzagoVar.zzb;
        return new zzaes(zzaevVar2, new zzaev(zzaevVar3.zzb, j5 + j3));
    }
}
