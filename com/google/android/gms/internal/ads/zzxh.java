package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzxh implements zzvf, zzve {
    private final zzvf zza;
    private final long zzb;
    private zzve zzc;

    public zzxh(zzvf zzvfVar, long j) {
        this.zza = zzvfVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zza(long j, zzmi zzmiVar) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzmiVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        long zzb = this.zza.zzb();
        if (zzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        long zzc = this.zza.zzc();
        if (zzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzd() {
        long zzd = this.zza.zzd();
        if (zzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzf(zzyw[] zzywVarArr, boolean[] zArr, zzwz[] zzwzVarArr, boolean[] zArr2, long j) {
        zzwz[] zzwzVarArr2 = new zzwz[zzwzVarArr.length];
        int i = 0;
        while (true) {
            zzwz zzwzVar = null;
            if (i >= zzwzVarArr.length) {
                break;
            }
            zzxg zzxgVar = (zzxg) zzwzVarArr[i];
            if (zzxgVar != null) {
                zzwzVar = zzxgVar.zzc();
            }
            zzwzVarArr2[i] = zzwzVar;
            i++;
        }
        zzvf zzvfVar = this.zza;
        long j2 = this.zzb;
        long zzf = zzvfVar.zzf(zzywVarArr, zArr, zzwzVarArr2, zArr2, j - j2);
        for (int i2 = 0; i2 < zzwzVarArr.length; i2++) {
            zzwz zzwzVar2 = zzwzVarArr2[i2];
            if (zzwzVar2 == null) {
                zzwzVarArr[i2] = null;
            } else {
                zzwz zzwzVar3 = zzwzVarArr[i2];
                if (zzwzVar3 == null || ((zzxg) zzwzVar3).zzc() != zzwzVar2) {
                    zzwzVarArr[i2] = new zzxg(zzwzVar2, j2);
                }
            }
        }
        return zzf + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final zzxk zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzh(long j, boolean z) {
        this.zza.zzh(j - this.zzb, false);
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
        this.zza.zzk(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzvf zzn() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        long j = zzlaVar.zza;
        long j2 = this.zzb;
        zzky zza = zzlaVar.zza();
        zza.zze(j - j2);
        return this.zza.zzo(zza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        zzve zzveVar = this.zzc;
        zzveVar.getClass();
        zzveVar.zzl(this);
    }
}
