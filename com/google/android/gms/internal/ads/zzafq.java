package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzafq {
    private final zzafp zza;
    private final zzafb zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private long[] zzm;
    private int[] zzn;

    public zzafq(int i, zzafp zzafpVar, zzafb zzafbVar) {
        this.zza = zzafpVar;
        int zzb = zzafpVar.zzb();
        boolean z = true;
        if (zzb != 1) {
            if (zzb == 2) {
                zzb = 2;
            } else {
                z = false;
            }
        }
        zzdd.zzd(z);
        this.zzc = zzh(i, zzb == 2 ? 1667497984 : 1651965952);
        this.zze = zzafpVar.zzc();
        this.zzb = zzafbVar;
        this.zzd = zzb == 2 ? zzh(i, 1650720768) : -1;
        this.zzl = -1L;
        this.zzm = new long[512];
        this.zzn = new int[512];
        this.zzf = zzafpVar.zzd;
    }

    private static int zzh(int i, int i2) {
        return (((i % 10) + 48) << 8) | ((i / 10) + 48) | i2;
    }

    private final long zzi(int i) {
        return (this.zze * i) / this.zzf;
    }

    private final zzaev zzj(int i) {
        return new zzaev(this.zzn[i] * zzi(1), this.zzm[i]);
    }

    public final zzaes zza(long j) {
        if (this.zzk == 0) {
            zzaev zzaevVar = new zzaev(0L, this.zzl);
            return new zzaes(zzaevVar, zzaevVar);
        }
        int zzi = (int) (j / zzi(1));
        int zzc = zzex.zzc(this.zzn, zzi, true, true);
        if (this.zzn[zzc] == zzi) {
            zzaev zzj = zzj(zzc);
            return new zzaes(zzj, zzj);
        }
        zzaev zzj2 = zzj(zzc);
        int i = zzc + 1;
        return i < this.zzm.length ? new zzaes(zzj2, zzj(i)) : new zzaes(zzj2, zzj2);
    }

    public final void zzb(long j, boolean z) {
        if (this.zzl == -1) {
            this.zzl = j;
        }
        if (z) {
            if (this.zzk == this.zzn.length) {
                long[] jArr = this.zzm;
                this.zzm = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.zzn;
                this.zzn = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.zzm;
            int i = this.zzk;
            jArr2[i] = j;
            this.zzn[i] = this.zzj;
            this.zzk = i + 1;
        }
        this.zzj++;
    }

    public final void zzc() {
        int i;
        this.zzm = Arrays.copyOf(this.zzm, this.zzk);
        this.zzn = Arrays.copyOf(this.zzn, this.zzk);
        if ((this.zzc & 1651965952) != 1651965952 || this.zza.zzf == 0 || (i = this.zzk) <= 0) {
            return;
        }
        this.zzf = i;
    }

    public final void zzd(int i) {
        this.zzg = i;
        this.zzh = i;
    }

    public final void zze(long j) {
        if (this.zzk == 0) {
            this.zzi = 0;
        } else {
            this.zzi = this.zzn[zzex.zzd(this.zzm, j, true, true)];
        }
    }

    public final boolean zzf(int i) {
        return this.zzc == i || this.zzd == i;
    }

    public final boolean zzg(zzadw zzadwVar) throws IOException {
        int i = this.zzh;
        zzafb zzafbVar = this.zzb;
        int zzf = i - zzafbVar.zzf(zzadwVar, i, false);
        this.zzh = zzf;
        boolean z = zzf == 0;
        if (z) {
            if (this.zzg > 0) {
                zzafbVar.zzt(zzi(this.zzi), Arrays.binarySearch(this.zzn, this.zzi) >= 0 ? 1 : 0, this.zzg, 0, null);
            }
            this.zzi++;
        }
        return z;
    }
}
