package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaem implements zzaeu {
    private final zzeb zza;
    private final zzeb zzb;
    private long zzc;

    public zzaem(long[] jArr, long[] jArr2, long j) {
        int length = jArr.length;
        int length2 = jArr2.length;
        zzdd.zzd(length == length2);
        if (length2 <= 0 || jArr2[0] <= 0) {
            this.zza = new zzeb(length2);
            this.zzb = new zzeb(length2);
        } else {
            int i = length2 + 1;
            zzeb zzebVar = new zzeb(i);
            this.zza = zzebVar;
            zzeb zzebVar2 = new zzeb(i);
            this.zzb = zzebVar2;
            zzebVar.zzc(0L);
            zzebVar2.zzc(0L);
        }
        this.zza.zzd(jArr);
        this.zzb.zzd(jArr2);
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzeb zzebVar = this.zzb;
        if (zzebVar.zza() == 0) {
            zzaev zzaevVar = zzaev.zza;
            return new zzaes(zzaevVar, zzaevVar);
        }
        int zzb = zzex.zzb(zzebVar, j, true, true);
        long zzb2 = zzebVar.zzb(zzb);
        zzeb zzebVar2 = this.zza;
        zzaev zzaevVar2 = new zzaev(zzb2, zzebVar2.zzb(zzb));
        if (zzaevVar2.zzb == j || zzb == zzebVar.zza() - 1) {
            return new zzaes(zzaevVar2, zzaevVar2);
        }
        int i = zzb + 1;
        return new zzaes(zzaevVar2, new zzaev(zzebVar.zzb(i), zzebVar2.zzb(i)));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return this.zzb.zza() > 0;
    }
}
