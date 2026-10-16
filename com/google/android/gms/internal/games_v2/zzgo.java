package com.google.android.gms.internal.games_v2;

/* compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* loaded from: classes5.dex */
final class zzgo extends zzgq {
    zzgo() {
        super(null);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgq
    public final zzgq zza(Comparable comparable, Comparable comparable2) {
        zzgq zzgqVar;
        zzgq zzgqVar2;
        zzgq zzgqVar3;
        int compareTo = comparable.compareTo(comparable2);
        if (compareTo < 0) {
            zzgqVar3 = zzgq.zzb;
            return zzgqVar3;
        }
        if (compareTo > 0) {
            zzgqVar2 = zzgq.zzc;
            return zzgqVar2;
        }
        zzgqVar = zzgq.zza;
        return zzgqVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgq
    public final int zzb() {
        return 0;
    }
}
