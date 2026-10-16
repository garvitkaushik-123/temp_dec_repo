package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzanf {
    private final zzafb zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final byte[] zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;

    public zzanf(zzafb zzafbVar, boolean z, boolean z2) {
        this.zza = zzafbVar;
        byte[] bArr = new byte[128];
        this.zzd = bArr;
        new zzfw(bArr, 0, 0);
        this.zzh = false;
    }

    public final void zza(zzft zzftVar) {
        this.zzc.append(zzftVar.zza, zzftVar);
    }

    public final void zzb(zzfu zzfuVar) {
        this.zzb.append(zzfuVar.zzd, zzfuVar);
    }

    public final void zzc() {
        this.zzh = false;
    }

    public final void zzd(long j, int i, long j2, boolean z) {
        this.zze = i;
        this.zzg = j2;
        this.zzf = j;
        this.zzl = z;
    }

    public final boolean zze(long j, int i, boolean z) {
        boolean z2 = false;
        if (this.zze == 9) {
            if (z && this.zzh) {
                long j2 = this.zzf;
                int i2 = i + ((int) (j - j2));
                long j3 = this.zzj;
                if (j3 != -9223372036854775807L) {
                    long j4 = this.zzi;
                    if (j2 != j4) {
                        this.zza.zzt(j3, this.zzk ? 1 : 0, (int) (j2 - j4), i2, null);
                    }
                }
            }
            this.zzi = this.zzf;
            this.zzj = this.zzg;
            this.zzk = false;
            this.zzh = true;
        }
        boolean z3 = this.zzl;
        boolean z4 = this.zzk;
        int i3 = this.zze;
        if (i3 == 5 || (z3 && i3 == 1)) {
            z2 = true;
        }
        boolean z5 = z4 | z2;
        this.zzk = z5;
        this.zze = 24;
        return z5;
    }
}
