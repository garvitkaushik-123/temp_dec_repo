package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzadk implements zzaeu {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzadk(long j, long j2, int i, int i2, boolean z) {
        long zzc;
        this.zza = j;
        this.zzb = j2;
        this.zzc = i2 == -1 ? 1 : i2;
        this.zze = i;
        if (j == -1) {
            this.zzd = -1L;
            zzc = -9223372036854775807L;
        } else {
            this.zzd = j - j2;
            zzc = zzc(j, j2, i);
        }
        this.zzf = zzc;
    }

    private static long zzc(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / i;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzf;
    }

    public final long zzb(long j) {
        return zzc(j, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -1) {
            zzaev zzaevVar = new zzaev(0L, this.zzb);
            return new zzaes(zzaevVar, zzaevVar);
        }
        long j3 = this.zzc;
        long j4 = (((this.zze * j) / 8000000) / j3) * j3;
        if (j2 != -1) {
            j4 = Math.min(j4, j2 - j3);
        }
        long max = this.zzb + Math.max(j4, 0L);
        long zzb = zzb(max);
        zzaev zzaevVar2 = new zzaev(zzb, max);
        if (j2 != -1 && zzb < j) {
            long j5 = max + j3;
            if (j5 < this.zza) {
                return new zzaes(zzaevVar2, new zzaev(zzb(j5), j5));
            }
        }
        return new zzaes(zzaevVar2, zzaevVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return this.zzd != -1;
    }
}
