package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzamv implements zzamz {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzafb zzi;
    private zzafb zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzafb zzw;
    private long zzx;
    private final zzem zzc = new zzem(new byte[7], 7);
    private final zzen zzd = new zzen(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzamv(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzh();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzh();
    }

    private final void zzh() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzi() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private final void zzj(zzafb zzafbVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzafbVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final boolean zzk(zzen zzenVar, byte[] bArr, int i) {
        int min = Math.min(zzenVar.zza(), i - this.zzl);
        zzenVar.zzH(bArr, this.zzl, min);
        int i2 = this.zzl + min;
        this.zzl = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzen zzenVar, byte[] bArr, int i) {
        if (zzenVar.zza() < i) {
            return false;
        }
        zzenVar.zzH(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) throws zzaz {
        int i;
        byte b;
        char c;
        int i2;
        int i3;
        boolean z;
        int i4;
        this.zzi.getClass();
        String str = zzex.zza;
        while (zzenVar.zza() > 0) {
            int i5 = this.zzk;
            char c2 = 7;
            int i6 = 3;
            int i7 = 2;
            if (i5 == 0) {
                byte[] zzN = zzenVar.zzN();
                int zzc = zzenVar.zzc();
                int zzd = zzenVar.zzd();
                while (true) {
                    if (zzc >= zzd) {
                        zzenVar.zzL(zzc);
                        break;
                    }
                    i = zzc + 1;
                    b = zzN[zzc];
                    int i8 = b & 255;
                    int i9 = i6;
                    if (this.zzm != 512 || !zzl((byte) -1, (byte) i8)) {
                        c = c2;
                    } else {
                        if (this.zzo) {
                            break;
                        }
                        int i10 = zzc - 1;
                        zzenVar.zzL(zzc);
                        zzem zzemVar = this.zzc;
                        if (zzm(zzenVar, zzemVar.zza, 1)) {
                            zzemVar.zzl(4);
                            int zzd2 = zzemVar.zzd(1);
                            int i11 = this.zzp;
                            if (i11 == -1 || zzd2 == i11) {
                                if (this.zzq != -1) {
                                    if (!zzm(zzenVar, zzemVar.zza, 1)) {
                                        break;
                                    }
                                    zzemVar.zzl(i7);
                                    if (zzemVar.zzd(4) == this.zzq) {
                                        zzenVar.zzL(zzc + 1);
                                    }
                                }
                                if (!zzm(zzenVar, zzemVar.zza, 4)) {
                                    break;
                                }
                                zzemVar.zzl(14);
                                int zzd3 = zzemVar.zzd(13);
                                c = 7;
                                if (zzd3 >= 7) {
                                    byte[] zzN2 = zzenVar.zzN();
                                    int zzd4 = zzenVar.zzd();
                                    int i12 = i10 + zzd3;
                                    if (i12 < zzd4) {
                                        byte b2 = zzN2[i12];
                                        if (b2 != -1) {
                                            if (b2 == 73) {
                                                int i13 = i12 + 1;
                                                if (i13 == zzd4) {
                                                    break;
                                                }
                                                if (zzN2[i13] == 68) {
                                                    int i14 = i12 + 2;
                                                    if (i14 == zzd4) {
                                                        break;
                                                    } else if (zzN2[i14] == 51) {
                                                        break;
                                                    }
                                                }
                                            }
                                        } else {
                                            int i15 = i12 + 1;
                                            if (i15 == zzd4) {
                                                break;
                                            }
                                            byte b3 = zzN2[i15];
                                            if (zzl((byte) -1, b3) && ((b3 & 8) >> 3) == zzd2) {
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                        c = 7;
                    }
                    int i16 = this.zzm;
                    int i17 = i16 | i8;
                    if (i17 == 329) {
                        i2 = i9;
                        i3 = 2;
                        z = false;
                        i4 = 768;
                    } else if (i17 == 511) {
                        i2 = i9;
                        i3 = 2;
                        z = false;
                        i4 = 512;
                    } else if (i17 == 836) {
                        i2 = i9;
                        i3 = 2;
                        z = false;
                        i4 = 1024;
                    } else {
                        if (i17 == 1075) {
                            this.zzk = 2;
                            this.zzl = i9;
                            this.zzu = 0;
                            this.zzd.zzL(0);
                            zzenVar.zzL(i);
                            break;
                        }
                        if (i16 != 256) {
                            this.zzm = 256;
                            c2 = c;
                            i6 = i9;
                            i7 = 2;
                        } else {
                            i2 = i9;
                            i3 = 2;
                            z = false;
                            zzc = i;
                            i6 = i2;
                            c2 = c;
                            i7 = i3;
                        }
                    }
                    this.zzm = i4;
                    zzc = i;
                    i6 = i2;
                    c2 = c;
                    i7 = i3;
                }
                this.zzr = (b & 8) >> 3;
                this.zzn = 1 == ((b & 1) ^ 1);
                if (this.zzo) {
                    zzi();
                } else {
                    this.zzk = 1;
                    this.zzl = 0;
                }
                zzenVar.zzL(i);
            } else if (i5 != 1) {
                if (i5 == 2) {
                    zzen zzenVar2 = this.zzd;
                    if (zzk(zzenVar, zzenVar2.zzN(), 10)) {
                        this.zzj.zzr(zzenVar2, 10);
                        zzenVar2.zzL(6);
                        zzj(this.zzj, 0L, 10, zzenVar2.zzl() + 10);
                    }
                } else if (i5 != 3) {
                    int min = Math.min(zzenVar.zza(), this.zzu - this.zzl);
                    this.zzw.zzr(zzenVar, min);
                    int i18 = this.zzl + min;
                    this.zzl = i18;
                    if (i18 == this.zzu) {
                        zzdd.zzf(this.zzv != -9223372036854775807L);
                        this.zzw.zzt(this.zzv, 1, this.zzu, 0, null);
                        this.zzv += this.zzx;
                        zzh();
                    }
                } else {
                    int i19 = true != this.zzn ? 5 : 7;
                    zzem zzemVar2 = this.zzc;
                    if (zzk(zzenVar, zzemVar2.zza, i19)) {
                        zzemVar2.zzl(0);
                        if (this.zzs) {
                            zzemVar2.zzn(10);
                        } else {
                            int zzd5 = zzemVar2.zzd(2) + 1;
                            if (zzd5 != 2) {
                                zzea.zzf("AdtsReader", "Detected audio object type: " + zzd5 + ", but assuming AAC LC.");
                            }
                            zzemVar2.zzn(5);
                            int zzd6 = zzemVar2.zzd(3);
                            int i20 = this.zzq;
                            int i21 = zzacr.zza;
                            byte[] bArr = {(byte) (((i20 >> 1) & 7) | 16), (byte) (((zzd6 << 3) & 120) | ((i20 << 7) & 128))};
                            zzacp zza2 = zzacr.zza(bArr);
                            zzx zzxVar = new zzx();
                            zzxVar.zzS(this.zzh);
                            zzxVar.zzG(this.zzg);
                            zzxVar.zzah("audio/mp4a-latm");
                            zzxVar.zzE(zza2.zzc);
                            zzxVar.zzD(zza2.zzb);
                            zzxVar.zzai(zza2.zza);
                            zzxVar.zzT(Collections.singletonList(bArr));
                            zzxVar.zzW(this.zze);
                            zzxVar.zzaf(this.zzf);
                            zzz zzan = zzxVar.zzan();
                            this.zzt = 1024000000 / zzan.zzH;
                            this.zzi.zzm(zzan);
                            this.zzs = true;
                        }
                        zzemVar2.zzn(4);
                        int zzd7 = zzemVar2.zzd(13);
                        int i22 = zzd7 - 7;
                        if (this.zzn) {
                            i22 = zzd7 - 9;
                        }
                        zzj(this.zzi, this.zzt, 0, i22);
                    }
                }
            } else if (zzenVar.zza() != 0) {
                zzem zzemVar3 = this.zzc;
                zzemVar3.zza[0] = zzenVar.zzN()[zzenVar.zzc()];
                zzemVar3.zzl(2);
                int zzd8 = zzemVar3.zzd(4);
                int i23 = this.zzq;
                if (i23 == -1 || zzd8 == i23) {
                    if (!this.zzo) {
                        this.zzo = true;
                        this.zzp = this.zzr;
                        this.zzq = zzd8;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzh = zzaonVar.zzb();
        zzafb zzw = zzadyVar.zzw(zzaonVar.zza(), 1);
        this.zzi = zzw;
        this.zzw = zzw;
        if (!this.zzb) {
            this.zzj = new zzadr();
            return;
        }
        zzaonVar.zzc();
        zzafb zzw2 = zzadyVar.zzw(zzaonVar.zza(), 5);
        this.zzj = zzw2;
        zzx zzxVar = new zzx();
        zzxVar.zzS(zzaonVar.zzb());
        zzxVar.zzG(this.zzg);
        zzxVar.zzah("application/id3");
        zzw2.zzm(zzxVar.zzan());
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzv = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzv = -9223372036854775807L;
        zzg();
    }
}
