package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzanm implements zzamz {
    private String zzf;
    private zzafb zzg;
    private boolean zzj;
    private int zzl;
    private int zzm;
    private int zzo;
    private int zzp;
    private int zzt;
    private boolean zzv;
    private final String zza = "video/mp2t";
    private int zze = 0;
    private final zzen zzb = new zzen(new byte[15], 2);
    private final zzem zzc = new zzem();
    private final zzen zzd = new zzen();
    private final zzann zzq = new zzann();
    private int zzr = -2147483647;
    private int zzs = -1;
    private long zzu = -1;
    private boolean zzk = true;
    private boolean zzn = true;
    private double zzh = -9.223372036854776E18d;
    private double zzi = -9.223372036854776E18d;

    public zzanm(String str) {
    }

    private static final void zzf(zzen zzenVar, zzen zzenVar2, boolean z) {
        int zzc = zzenVar.zzc();
        int min = Math.min(zzenVar.zza(), zzenVar2.zza());
        zzenVar.zzH(zzenVar2.zzN(), zzenVar2.zzc(), min);
        zzenVar2.zzM(min);
        if (z) {
            zzenVar.zzL(zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) throws zzaz {
        int i;
        zzdd.zzb(this.zzg);
        while (zzenVar.zza() > 0) {
            int i2 = this.zze;
            int i3 = 0;
            if (i2 == 0) {
                int i4 = this.zzl;
                if ((i4 & 2) != 0) {
                    if ((i4 & 4) == 0) {
                        while (zzenVar.zza() > 0) {
                            int i5 = this.zzm << 8;
                            this.zzm = i5;
                            int zzm = i5 | zzenVar.zzm();
                            this.zzm = zzm;
                            if ((zzm & ViewCompat.MEASURED_SIZE_MASK) == 12583333) {
                                zzenVar.zzL(zzenVar.zzc() - 3);
                                this.zzm = 0;
                            }
                        }
                    }
                    this.zze = 1;
                    break;
                }
                zzenVar.zzL(zzenVar.zzd());
            } else if (i2 != 1) {
                zzann zzannVar = this.zzq;
                int i6 = zzannVar.zza;
                if (i6 == 1 || i6 == 17) {
                    zzf(zzenVar, this.zzd, true);
                }
                int min = Math.min(zzenVar.zza(), zzannVar.zzc - this.zzo);
                this.zzg.zzr(zzenVar, min);
                int i7 = this.zzo + min;
                this.zzo = i7;
                if (i7 == zzannVar.zzc) {
                    int i8 = zzannVar.zza;
                    if (i8 == 1) {
                        byte[] zzN = this.zzd.zzN();
                        zzano zza = zzanq.zza(new zzem(zzN, zzN.length));
                        this.zzr = zza.zzb;
                        this.zzs = zza.zzc;
                        long j = this.zzu;
                        long j2 = zzannVar.zzb;
                        if (j != j2) {
                            this.zzu = j2;
                            int i9 = zza.zza;
                            String concat = i9 != -1 ? "mhm1".concat(String.valueOf(String.format(".%02X", Integer.valueOf(i9)))) : "mhm1";
                            byte[] bArr = zza.zzd;
                            zzfyq zzfyqVar = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfyqVar = zzfyq.zzp(zzex.zzb, bArr);
                            }
                            zzx zzxVar = new zzx();
                            zzxVar.zzS(this.zzf);
                            zzxVar.zzG(this.zza);
                            zzxVar.zzah("audio/mhm1");
                            zzxVar.zzai(this.zzr);
                            zzxVar.zzE(concat);
                            zzxVar.zzT(zzfyqVar);
                            this.zzg.zzm(zzxVar.zzan());
                        }
                        this.zzv = true;
                    } else if (i8 == 17) {
                        byte[] zzN2 = this.zzd.zzN();
                        zzem zzemVar = new zzem(zzN2, zzN2.length);
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(2);
                            i3 = zzemVar.zzd(13);
                        }
                        this.zzt = i3;
                    } else if (i8 == 2) {
                        if (this.zzv) {
                            this.zzk = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i10 = this.zzs - this.zzt;
                        double d = this.zzr;
                        long round = Math.round(this.zzh);
                        if (this.zzj) {
                            this.zzj = false;
                            this.zzh = this.zzi;
                        } else {
                            this.zzh += (i10 * 1000000.0d) / d;
                        }
                        this.zzg.zzt(round, i, this.zzp, 0, null);
                        this.zzv = false;
                        this.zzt = 0;
                        this.zzp = 0;
                    }
                    this.zze = 1;
                }
            } else {
                zzen zzenVar2 = this.zzb;
                zzf(zzenVar, zzenVar2, false);
                if (zzenVar2.zza() == 0) {
                    zzem zzemVar2 = this.zzc;
                    int zzd = zzenVar2.zzd();
                    zzemVar2.zzk(zzenVar2.zzN(), zzd);
                    zzann zzannVar2 = this.zzq;
                    if (zzanq.zzb(zzemVar2, zzannVar2)) {
                        this.zzo = 0;
                        this.zzp += zzannVar2.zzc + zzd;
                        zzenVar2.zzL(0);
                        this.zzg.zzr(zzenVar2, zzenVar2.zzd());
                        zzenVar2.zzI(2);
                        this.zzd.zzI(zzannVar2.zzc);
                        this.zzn = true;
                        this.zze = 2;
                    } else if (zzenVar2.zzd() < 15) {
                        zzenVar2.zzK(zzenVar2.zzd() + 1);
                    }
                }
                this.zzn = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzf = zzaonVar.zzb();
        this.zzg = zzadyVar.zzw(zzaonVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzl = i;
        if (!this.zzk && (this.zzp != 0 || !this.zzn)) {
            this.zzj = true;
        }
        if (j != -9223372036854775807L) {
            double d = j;
            if (this.zzj) {
                this.zzi = d;
            } else {
                this.zzh = d;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zze = 0;
        this.zzm = 0;
        this.zzb.zzI(2);
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = -2147483647;
        this.zzs = -1;
        this.zzt = 0;
        this.zzu = -1L;
        this.zzv = false;
        this.zzj = false;
        this.zzn = true;
        this.zzk = true;
        this.zzh = -9.223372036854776E18d;
        this.zzi = -9.223372036854776E18d;
    }
}
