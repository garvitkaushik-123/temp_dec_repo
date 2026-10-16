package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaee implements zzaeu {
    private final zzaeg zza;
    private final long zzb;

    public zzaee(zzaeg zzaegVar, long j) {
        this.zza = zzaegVar;
        this.zzb = j;
    }

    private final zzaev zzb(long j, long j2) {
        return new zzaev((j * 1000000) / this.zza.zze, this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzaeg zzaegVar = this.zza;
        zzaef zzaefVar = zzaegVar.zzk;
        zzdd.zzb(zzaefVar);
        long[] jArr = zzaefVar.zza;
        long[] jArr2 = zzaefVar.zzb;
        int zzd = zzex.zzd(jArr, zzaegVar.zzb(j), true, false);
        zzaev zzb = zzb(zzd == -1 ? 0L : jArr[zzd], zzd != -1 ? jArr2[zzd] : 0L);
        if (zzb.zzb == j || zzd == jArr.length - 1) {
            return new zzaes(zzb, zzb);
        }
        int i = zzd + 1;
        return new zzaes(zzb, zzb(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
