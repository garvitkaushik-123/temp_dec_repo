package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzaih implements zzaig {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzaih(long[] jArr, long[] jArr2, long j, long j2, long j3, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = i;
    }

    public static zzaih zzb(long j, long j2, zzaen zzaenVar, zzen zzenVar) {
        int zzm;
        zzen zzenVar2 = zzenVar;
        zzenVar2.zzM(6);
        int zzg = zzenVar2.zzg();
        long j3 = zzaenVar.zzc;
        long j4 = zzg;
        if (zzenVar2.zzg() <= 0) {
            return null;
        }
        long zzt = zzex.zzt((r4 * zzaenVar.zzg) - 1, zzaenVar.zzd);
        int zzq = zzenVar2.zzq();
        int zzq2 = zzenVar2.zzq();
        int zzq3 = zzenVar2.zzq();
        zzenVar2.zzM(2);
        long[] jArr = new long[zzq];
        long[] jArr2 = new long[zzq];
        int i = 0;
        long j5 = j2 + zzaenVar.zzc;
        while (i < zzq) {
            long j6 = j3;
            jArr[i] = (i * zzt) / zzq;
            jArr2[i] = j5;
            if (zzq3 == 1) {
                zzm = zzenVar2.zzm();
            } else if (zzq3 == 2) {
                zzm = zzenVar2.zzq();
            } else if (zzq3 == 3) {
                zzm = zzenVar2.zzo();
            } else {
                if (zzq3 != 4) {
                    return null;
                }
                zzm = zzenVar2.zzp();
            }
            j5 += zzm * zzq2;
            i++;
            zzenVar2 = zzenVar;
            zzq = zzq;
            j3 = j6;
        }
        long j7 = j2 + j3;
        long j8 = j7 + j4;
        if (j != -1 && j != j8) {
            zzea.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j8);
        }
        if (j8 != j5) {
            zzea.zzf("VbriSeeker", "VBRI bytes and ToC mismatch (using max): " + j8 + ", " + j5 + "\nSeeking will be inaccurate.");
            j8 = Math.max(j8, j5);
        }
        return new zzaih(jArr, jArr2, zzt, j7, j8, zzaenVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zze(long j) {
        return this.zza[zzex.zzd(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long[] jArr = this.zza;
        int zzd = zzex.zzd(jArr, j, true, true);
        long j2 = jArr[zzd];
        long[] jArr2 = this.zzb;
        zzaev zzaevVar = new zzaev(j2, jArr2[zzd]);
        if (zzaevVar.zzb >= j || zzd == jArr.length - 1) {
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
