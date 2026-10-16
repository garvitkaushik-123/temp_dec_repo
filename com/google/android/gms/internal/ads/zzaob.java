package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaob implements zzaoo {
    private final zzaoa zza;
    private final zzen zzb = new zzen(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzaob(zzaoa zzaoaVar) {
        this.zza = zzaoaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zza(zzen zzenVar, int i) {
        int i2 = i & 1;
        int zzc = i2 != 0 ? zzenVar.zzc() + zzenVar.zzm() : -1;
        if (this.zzf) {
            if (i2 == 0) {
                return;
            }
            this.zzf = false;
            zzenVar.zzL(zzc);
            this.zzd = 0;
        }
        while (zzenVar.zza() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int zzm = zzenVar.zzm();
                    zzenVar.zzL(zzenVar.zzc() - 1);
                    if (zzm == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int min = Math.min(zzenVar.zza(), 3 - this.zzd);
                zzen zzenVar2 = this.zzb;
                zzenVar.zzH(zzenVar2.zzN(), this.zzd, min);
                int i4 = this.zzd + min;
                this.zzd = i4;
                if (i4 == 3) {
                    zzenVar2.zzL(0);
                    zzenVar2.zzK(3);
                    zzenVar2.zzM(1);
                    int zzm2 = zzenVar2.zzm();
                    boolean z = (zzm2 & 128) != 0;
                    int zzm3 = zzenVar2.zzm();
                    this.zze = z;
                    this.zzc = (((zzm2 & 15) << 8) | zzm3) + 3;
                    int zzb = zzenVar2.zzb();
                    int i5 = this.zzc;
                    if (zzb < i5) {
                        int zzb2 = zzenVar2.zzb();
                        zzenVar2.zzF(Math.min(4098, Math.max(i5, zzb2 + zzb2)));
                    }
                }
            } else {
                int min2 = Math.min(zzenVar.zza(), this.zzc - this.zzd);
                zzen zzenVar3 = this.zzb;
                zzenVar.zzH(zzenVar3.zzN(), this.zzd, min2);
                int i6 = this.zzd + min2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        zzenVar3.zzK(i7);
                    } else {
                        if (zzex.zzf(zzenVar3.zzN(), 0, i7, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        zzenVar3.zzK(this.zzc - 4);
                    }
                    zzenVar3.zzL(0);
                    this.zza.zza(zzenVar3);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
        this.zza.zzb(zzeuVar, zzadyVar, zzaonVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzc() {
        this.zzf = true;
    }
}
