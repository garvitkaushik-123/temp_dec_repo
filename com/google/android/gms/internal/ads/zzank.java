package com.google.android.gms.internal.ads;

import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzank implements zzamz {
    private final String zza;
    private final int zzb;
    private final String zzc = "video/mp2t";
    private final zzen zzd;
    private final zzem zze;
    private zzafb zzf;
    private String zzg;
    private zzz zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private String zzw;

    public zzank(String str, int i, String str2) {
        this.zza = str;
        this.zzb = i;
        zzen zzenVar = new zzen(1024);
        this.zzd = zzenVar;
        byte[] zzN = zzenVar.zzN();
        this.zze = new zzem(zzN, zzN.length);
        this.zzm = -9223372036854775807L;
    }

    private final int zzf(zzem zzemVar) throws zzaz {
        int zza = zzemVar.zza();
        zzacp zzb = zzacr.zzb(zzemVar, true);
        this.zzw = zzb.zzc;
        this.zzt = zzb.zza;
        this.zzv = zzb.zzb;
        return zza - zzemVar.zza();
    }

    private static long zzg(zzem zzemVar) {
        return zzemVar.zzd((zzemVar.zzd(2) + 1) * 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x015a, code lost:
    
        if (r14.zzn == false) goto L89;
     */
    @Override // com.google.android.gms.internal.ads.zzamz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(zzen zzenVar) throws zzaz {
        int i;
        int i2;
        int i3;
        boolean zzp;
        zzdd.zzb(this.zzf);
        while (zzenVar.zza() > 0) {
            int i4 = this.zzi;
            if (i4 != 0) {
                if (i4 == 1) {
                    int zzm = zzenVar.zzm();
                    if ((zzm & 224) == 224) {
                        this.zzl = zzm;
                        this.zzi = 2;
                    } else if (zzm != 86) {
                        this.zzi = 0;
                    }
                } else if (i4 != 2) {
                    int min = Math.min(zzenVar.zza(), this.zzk - this.zzj);
                    zzem zzemVar = this.zze;
                    zzenVar.zzH(zzemVar.zza, this.zzj, min);
                    int i5 = this.zzj + min;
                    this.zzj = i5;
                    if (i5 == this.zzk) {
                        zzemVar.zzl(0);
                        if (!zzemVar.zzp()) {
                            this.zzn = true;
                            int zzd = zzemVar.zzd(1);
                            if (zzd == 1) {
                                i3 = zzemVar.zzd(1);
                                i2 = 1;
                            } else {
                                i2 = zzd;
                                i3 = 0;
                            }
                            this.zzo = i3;
                            if (i3 != 0) {
                                throw zzaz.zza(null, null);
                            }
                            if (i2 == 1) {
                                zzg(zzemVar);
                                i2 = 1;
                            }
                            if (!zzemVar.zzp()) {
                                throw zzaz.zza(null, null);
                            }
                            this.zzp = zzemVar.zzd(6);
                            int zzd2 = zzemVar.zzd(4);
                            int zzd3 = zzemVar.zzd(3);
                            if (zzd2 != 0 || zzd3 != 0) {
                                throw zzaz.zza(null, null);
                            }
                            if (i2 == 0) {
                                int zzc = zzemVar.zzc();
                                int zzf = zzf(zzemVar);
                                zzemVar.zzl(zzc);
                                byte[] bArr = new byte[(zzf + 7) / 8];
                                zzemVar.zzh(bArr, 0, zzf);
                                zzx zzxVar = new zzx();
                                zzxVar.zzS(this.zzg);
                                zzxVar.zzG(this.zzc);
                                zzxVar.zzah("audio/mp4a-latm");
                                zzxVar.zzE(this.zzw);
                                zzxVar.zzD(this.zzv);
                                zzxVar.zzai(this.zzt);
                                zzxVar.zzT(Collections.singletonList(bArr));
                                zzxVar.zzW(this.zza);
                                zzxVar.zzaf(this.zzb);
                                zzz zzan = zzxVar.zzan();
                                if (!zzan.equals(this.zzh)) {
                                    this.zzh = zzan;
                                    this.zzu = 1024000000 / zzan.zzH;
                                    this.zzf.zzm(zzan);
                                }
                            } else {
                                zzemVar.zzn(((int) zzg(zzemVar)) - zzf(zzemVar));
                            }
                            int zzd4 = zzemVar.zzd(3);
                            this.zzq = zzd4;
                            if (zzd4 == 0) {
                                zzemVar.zzn(8);
                            } else if (zzd4 == 1) {
                                zzemVar.zzn(9);
                            } else if (zzd4 == 3 || zzd4 == 4 || zzd4 == 5) {
                                zzemVar.zzn(6);
                            } else {
                                if (zzd4 != 6 && zzd4 != 7) {
                                    throw new IllegalStateException();
                                }
                                zzemVar.zzn(1);
                            }
                            boolean zzp2 = zzemVar.zzp();
                            this.zzr = zzp2;
                            this.zzs = 0L;
                            if (zzp2) {
                                if (i2 != 1) {
                                    do {
                                        zzp = zzemVar.zzp();
                                        this.zzs = (this.zzs << 8) + zzemVar.zzd(8);
                                    } while (zzp);
                                } else {
                                    this.zzs = zzg(zzemVar);
                                }
                            }
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(8);
                            }
                        }
                        if (this.zzo != 0) {
                            throw zzaz.zza(null, null);
                        }
                        if (this.zzp != 0) {
                            throw zzaz.zza(null, null);
                        }
                        if (this.zzq != 0) {
                            throw zzaz.zza(null, null);
                        }
                        int i6 = 0;
                        while (true) {
                            int zzd5 = zzemVar.zzd(8);
                            i = i6 + zzd5;
                            if (zzd5 != 255) {
                                break;
                            } else {
                                i6 = i;
                            }
                        }
                        int zzc2 = zzemVar.zzc();
                        if ((zzc2 & 7) == 0) {
                            this.zzd.zzL(zzc2 >> 3);
                        } else {
                            zzen zzenVar2 = this.zzd;
                            zzemVar.zzh(zzenVar2.zzN(), 0, i * 8);
                            zzenVar2.zzL(0);
                        }
                        this.zzf.zzr(this.zzd, i);
                        zzdd.zzf(this.zzm != -9223372036854775807L);
                        this.zzf.zzt(this.zzm, 1, i, 0, null);
                        this.zzm += this.zzu;
                        if (this.zzr) {
                            zzemVar.zzn((int) this.zzs);
                        }
                        this.zzi = 0;
                    } else {
                        continue;
                    }
                } else {
                    int zzm2 = ((this.zzl & (-225)) << 8) | zzenVar.zzm();
                    this.zzk = zzm2;
                    zzen zzenVar3 = this.zzd;
                    if (zzm2 > zzenVar3.zzN().length) {
                        zzenVar3.zzI(zzm2);
                        zzem zzemVar2 = this.zze;
                        byte[] zzN = zzenVar3.zzN();
                        zzemVar2.zzk(zzN, zzN.length);
                    }
                    this.zzj = 0;
                    this.zzi = 3;
                }
            } else if (zzenVar.zzm() == 86) {
                this.zzi = 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzf = zzadyVar.zzw(zzaonVar.zza(), 1);
        this.zzg = zzaonVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzi = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = false;
    }
}
