package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzadi implements zzaeu {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzadi(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length <= 0) {
            this.zzf = 0L;
        } else {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
        }
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        return "ChunkIndex(length=" + this.zza + ", sizes=" + Arrays.toString(this.zzb) + ", offsets=" + Arrays.toString(jArr3) + ", timeUs=" + Arrays.toString(jArr2) + ", durationsUs=" + Arrays.toString(jArr) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long[] jArr = this.zze;
        int zzd = zzex.zzd(jArr, j, true, true);
        long j2 = jArr[zzd];
        long[] jArr2 = this.zzc;
        zzaev zzaevVar = new zzaev(j2, jArr2[zzd]);
        if (zzaevVar.zzb >= j || zzd == this.zza - 1) {
            return new zzaes(zzaevVar, zzaevVar);
        }
        int i = zzd + 1;
        return new zzaes(zzaevVar, new zzaev(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
