package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzul implements zzvf, zzve {
    public final zzvf zza;
    long zzb;
    private zzve zzc;
    private zzuk[] zzd = new zzuk[0];
    private long zze = 0;

    public zzul(zzvf zzvfVar, boolean z, long j, long j2) {
        this.zza = zzvfVar;
        this.zzb = j2;
    }

    private static long zzr(long j, long j2, long j3) {
        long max = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(max, j3) : max;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zza(long j, zzmi zzmiVar) {
        if (j == 0) {
            return 0L;
        }
        long j2 = zzmiVar.zzc;
        String str = zzex.zza;
        long max = Math.max(0L, Math.min(j2, j));
        long j3 = zzmiVar.zzd;
        long j4 = this.zzb;
        long max2 = Math.max(0L, Math.min(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j));
        if (max != j2 || max2 != j3) {
            zzmiVar = new zzmi(max, max2);
        }
        return this.zza.zza(j, zzmiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        long zzb = this.zza.zzb();
        if (zzb != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzb < j) {
                return zzb;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        long zzc = this.zza.zzc();
        if (zzc != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || zzc < j) {
                return zzc;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzd() {
        if (zzq()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long zzd = zzd();
            return zzd != -9223372036854775807L ? zzd : j;
        }
        long zzd2 = this.zza.zzd();
        if (zzd2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzr(zzd2, 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zze(long j) {
        this.zze = -9223372036854775807L;
        for (zzuk zzukVar : this.zzd) {
            if (zzukVar != null) {
                zzukVar.zzc();
            }
        }
        return zzr(this.zza.zze(j), 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzf(zzyw[] zzywVarArr, boolean[] zArr, zzwz[] zzwzVarArr, boolean[] zArr2, long j) {
        int length = zzwzVarArr.length;
        this.zzd = new zzuk[length];
        zzwz[] zzwzVarArr2 = new zzwz[length];
        int i = 0;
        while (true) {
            zzwz zzwzVar = null;
            if (i >= zzwzVarArr.length) {
                break;
            }
            zzuk[] zzukVarArr = this.zzd;
            zzuk zzukVar = (zzuk) zzwzVarArr[i];
            zzukVarArr[i] = zzukVar;
            if (zzukVar != null) {
                zzwzVar = zzukVar.zza;
            }
            zzwzVarArr2[i] = zzwzVar;
            i++;
        }
        long zzf = this.zza.zzf(zzywVarArr, zArr, zzwzVarArr2, zArr2, j);
        long zzr = zzr(zzf, j, this.zzb);
        long j2 = -9223372036854775807L;
        if (zzq()) {
            if (zzf >= j) {
                if (zzf != 0) {
                    for (zzyw zzywVar : zzywVarArr) {
                        if (zzywVar != null) {
                            zzz zzb = zzywVar.zzb();
                            if (!zzay.zzf(zzb.zzo, zzb.zzk)) {
                            }
                        }
                    }
                }
            }
            j2 = zzr;
            break;
        }
        this.zze = j2;
        for (int i2 = 0; i2 < zzwzVarArr.length; i2++) {
            zzwz zzwzVar2 = zzwzVarArr2[i2];
            if (zzwzVar2 == null) {
                this.zzd[i2] = null;
            } else {
                zzuk[] zzukVarArr2 = this.zzd;
                zzuk zzukVar2 = zzukVarArr2[i2];
                if (zzukVar2 == null || zzukVar2.zza != zzwzVar2) {
                    zzukVarArr2[i2] = new zzuk(this, zzwzVar2);
                }
            }
            zzwzVarArr[i2] = this.zzd[i2];
        }
        return zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final zzxk zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzh(long j, boolean z) {
        this.zza.zzh(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzi() throws IOException {
        this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final /* bridge */ /* synthetic */ void zzj(zzxb zzxbVar) {
        zzve zzveVar = this.zzc;
        zzveVar.getClass();
        zzveVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzk(zzve zzveVar, long j) {
        this.zzc = zzveVar;
        this.zza.zzk(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    public final void zzn(long j, long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        return this.zza.zzo(zzlaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        return this.zza.zzp();
    }

    final boolean zzq() {
        return this.zze != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        zzve zzveVar = this.zzc;
        zzveVar.getClass();
        zzveVar.zzl(this);
    }
}
