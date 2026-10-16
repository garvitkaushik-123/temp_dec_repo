package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzant implements zzaoo {
    private final zzamz zza;
    private final zzem zzb = new zzem(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzeu zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzant(zzamz zzamzVar) {
        this.zza = zzamzVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzen zzenVar, byte[] bArr, int i) {
        int min = Math.min(zzenVar.zza(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzenVar.zzM(min);
        } else {
            zzenVar.zzH(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        return i2 == i;
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zza(zzen zzenVar, int i) throws zzaz {
        int i2;
        int i3;
        long j;
        long j2;
        zzdd.zzb(this.zze);
        int i4 = -1;
        int i5 = 2;
        if ((i & 1) != 0) {
            int i6 = this.zzc;
            if (i6 != 0 && i6 != 1) {
                if (i6 != 2) {
                    int i7 = this.zzj;
                    if (i7 != -1) {
                        zzea.zzf("PesReader", "Unexpected start indicator: expected " + i7 + " more bytes");
                    }
                    this.zza.zzc(zzenVar.zzd() == 0);
                } else {
                    zzea.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i8 = i;
        while (zzenVar.zza() > 0) {
            int i9 = this.zzc;
            if (i9 == 0) {
                i2 = i5;
                zzenVar.zzM(zzenVar.zza());
            } else if (i9 != 1) {
                if (i9 != i5) {
                    int zza = zzenVar.zza();
                    int i10 = this.zzj;
                    int i11 = i10 == i4 ? 0 : zza - i10;
                    if (i11 > 0) {
                        zza -= i11;
                        zzenVar.zzK(zzenVar.zzc() + zza);
                    }
                    zzamz zzamzVar = this.zza;
                    zzamzVar.zza(zzenVar);
                    int i12 = this.zzj;
                    if (i12 != i4) {
                        int i13 = i12 - zza;
                        this.zzj = i13;
                        if (i13 == 0) {
                            zzamzVar.zzc(false);
                            zze(1);
                        }
                    }
                } else {
                    int min = Math.min(10, this.zzi);
                    zzem zzemVar = this.zzb;
                    if (zzf(zzenVar, zzemVar.zza, min) && zzf(zzenVar, null, this.zzi)) {
                        zzemVar.zzl(0);
                        if (this.zzf) {
                            zzemVar.zzn(4);
                            long zzd = zzemVar.zzd(3);
                            zzemVar.zzn(1);
                            int zzd2 = zzemVar.zzd(15) << 15;
                            zzemVar.zzn(1);
                            long zzd3 = zzemVar.zzd(15);
                            zzemVar.zzn(1);
                            if (this.zzh || !this.zzg) {
                                j2 = zzd;
                            } else {
                                zzemVar.zzn(4);
                                j2 = zzd;
                                zzemVar.zzn(1);
                                int zzd4 = zzemVar.zzd(15) << 15;
                                zzemVar.zzn(1);
                                long zzd5 = zzemVar.zzd(15);
                                zzemVar.zzn(1);
                                this.zze.zzb((zzemVar.zzd(3) << 30) | zzd4 | zzd5);
                                this.zzh = true;
                            }
                            j = this.zze.zzb(zzd3 | (j2 << 30) | zzd2);
                        } else {
                            j = -9223372036854775807L;
                        }
                        i8 |= true != this.zzk ? 0 : 4;
                        this.zza.zzd(j, i8);
                        zze(3);
                        i4 = -1;
                        i5 = 2;
                    }
                }
                i2 = i5;
            } else {
                zzem zzemVar2 = this.zzb;
                if (zzf(zzenVar, zzemVar2.zza, 9)) {
                    zzemVar2.zzl(0);
                    int zzd6 = zzemVar2.zzd(24);
                    if (zzd6 != 1) {
                        zzea.zzf("PesReader", "Unexpected start code prefix: " + zzd6);
                        i4 = -1;
                        this.zzj = -1;
                        i3 = 0;
                        i2 = 2;
                    } else {
                        zzemVar2.zzn(8);
                        int zzd7 = zzemVar2.zzd(16);
                        zzemVar2.zzn(5);
                        this.zzk = zzemVar2.zzp();
                        i2 = 2;
                        zzemVar2.zzn(2);
                        this.zzf = zzemVar2.zzp();
                        this.zzg = zzemVar2.zzp();
                        zzemVar2.zzn(6);
                        int zzd8 = zzemVar2.zzd(8);
                        this.zzi = zzd8;
                        if (zzd7 == 0) {
                            this.zzj = -1;
                            i4 = -1;
                        } else {
                            int i14 = (zzd7 - 3) - zzd8;
                            this.zzj = i14;
                            if (i14 < 0) {
                                zzea.zzf("PesReader", "Found negative packet payload size: " + i14);
                                i4 = -1;
                                this.zzj = -1;
                            } else {
                                i4 = -1;
                            }
                        }
                        i3 = 2;
                    }
                    zze(i3);
                } else {
                    i4 = -1;
                    i2 = 2;
                }
            }
            i5 = i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzb(zzeu zzeuVar, zzady zzadyVar, zzaon zzaonVar) {
        this.zze = zzeuVar;
        this.zza.zzb(zzadyVar, zzaonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaoo
    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
