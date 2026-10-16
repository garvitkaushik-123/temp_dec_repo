package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcp {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private double zzw;

    public zzcp(int i, int i2, float f, float f2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = i / i3;
        this.zzf = i / 400;
        int i4 = i / 65;
        this.zzg = i4;
        int i5 = i4 + i4;
        this.zzh = i5;
        this.zzi = new short[i5];
        int i6 = i5 * i2;
        this.zzj = new short[i6];
        this.zzl = new short[i6];
        this.zzn = new short[i6];
    }

    private final int zzg(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 255;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                int i10 = this.zzb * i;
                i8 += Math.abs(sArr[i10 + i9] - sArr[(i10 + i2) + i9]);
            }
            int i11 = i8 * i6;
            int i12 = i4 * i2;
            if (i11 < i12) {
                i4 = i8;
            }
            if (i11 < i12) {
                i6 = i2;
            }
            int i13 = i8 * i5;
            int i14 = i7 * i2;
            if (i13 > i14) {
                i7 = i8;
            }
            if (i13 > i14) {
                i5 = i2;
            }
            i2++;
        }
        this.zzu = i4 / i6;
        this.zzv = i7 / i5;
        return i6;
    }

    private final void zzh(short[] sArr, int i, int i2) {
        short[] zzl = zzl(this.zzl, this.zzm, i2);
        this.zzl = zzl;
        int i3 = this.zzm;
        int i4 = this.zzb;
        System.arraycopy(sArr, i * i4, zzl, i3 * i4, i2 * i4);
        this.zzm += i2;
    }

    private final void zzi(short[] sArr, int i, int i2) {
        int i3;
        for (int i4 = 0; i4 < this.zzh / i2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.zzb;
                i3 = i7 * i2;
                if (i5 < i3) {
                    i6 += sArr[(i7 * i) + (i3 * i4) + i5];
                    i5++;
                }
            }
            this.zzi[i4] = (short) (i6 / i3);
        }
    }

    private static void zzj(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    private final short[] zzl(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.zzb;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int zza() {
        zzdd.zzf(this.zzm >= 0);
        int i = this.zzm * this.zzb;
        return i + i;
    }

    public final int zzb() {
        int i = this.zzk * this.zzb;
        return i + i;
    }

    public final void zzc() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
        this.zzw = 0.0d;
    }

    public final void zzd(ShortBuffer shortBuffer) {
        zzdd.zzf(this.zzm >= 0);
        int remaining = shortBuffer.remaining();
        int i = this.zzb;
        int min = Math.min(remaining / i, this.zzm);
        int i2 = min * i;
        shortBuffer.put(this.zzl, 0, i2);
        int i3 = this.zzm - min;
        this.zzm = i3;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, i2, sArr, 0, i3 * i);
    }

    public final void zze() {
        int i = this.zzk;
        int i2 = this.zzr;
        int i3 = this.zzm;
        float f = this.zzc;
        float f2 = this.zzd;
        int i4 = i3 + ((int) (((((((i - i2) / (f / f2)) + i2) + this.zzw) + this.zzo) / (this.zze * f2)) + 0.5d));
        this.zzw = 0.0d;
        int i5 = this.zzh;
        int i6 = i5 + i5;
        this.zzj = zzl(this.zzj, i, i + i6);
        int i7 = 0;
        while (true) {
            int i8 = this.zzb;
            if (i7 >= i6 * i8) {
                break;
            }
            this.zzj[(i8 * i) + i7] = 0;
            i7++;
        }
        this.zzk += i6;
        zzk();
        if (this.zzm > i4) {
            this.zzm = Math.max(i4, 0);
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zzf(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = remaining / i;
        int i3 = i2 * i;
        short[] zzl = zzl(this.zzj, this.zzk, i2);
        this.zzj = zzl;
        shortBuffer.get(zzl, this.zzk * i, (i3 + i3) / 2);
        this.zzk += i2;
        zzk();
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0293 A[LOOP:4: B:58:0x0036->B:64:0x0293, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0192 A[EDGE_INSN: B:65:0x0192->B:66:0x0192 BREAK  A[LOOP:4: B:58:0x0036->B:64:0x0293], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzk() {
        float f;
        int i;
        int i2;
        double d;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        int i10;
        int i11;
        long j;
        long j2;
        float f3 = this.zzc;
        float f4 = this.zzd;
        double d2 = f3 / f4;
        int i12 = this.zzm;
        int i13 = 0;
        int i14 = 1;
        if (d2 > 1.0000100135803223d || d2 < 0.9999899864196777d) {
            int i15 = this.zzk;
            int i16 = this.zzh;
            if (i15 >= i16) {
                int i17 = 0;
                while (true) {
                    int i18 = this.zzr;
                    if (i18 > 0) {
                        int min = Math.min(i16, i18);
                        zzh(this.zzj, i17, min);
                        this.zzr -= min;
                        i17 += min;
                        f = f4;
                        d = d2;
                    } else {
                        short[] sArr = this.zzj;
                        int i19 = this.zza;
                        int i20 = i19 > 4000 ? i19 / 4000 : i14;
                        int i21 = this.zzb;
                        if (i21 == i14) {
                            if (i20 == i14) {
                                i = zzg(sArr, i17, this.zzf, this.zzg);
                                f = f4;
                                i2 = i14;
                                int i22 = this.zzu;
                                int i23 = (i22 != 0 || (i7 = this.zzs) == 0 || this.zzv > i22 * 3 || i22 + i22 <= this.zzt * 3) ? i : i7;
                                int i24 = i17 + i23;
                                this.zzt = i22;
                                this.zzs = i;
                                double d3 = i23;
                                if (d2 <= 1.0d) {
                                    short[] sArr2 = this.zzj;
                                    double d4 = d2 - 1.0d;
                                    if (d2 >= 2.0d) {
                                        i5 = i23;
                                        double d5 = (d3 / d4) + this.zzw;
                                        int round = (int) Math.round(d5);
                                        d = d2;
                                        this.zzw = d5 - round;
                                        i6 = round;
                                    } else {
                                        d = d2;
                                        i5 = i23;
                                        double d6 = ((d3 * (2.0d - d)) / d4) + this.zzw;
                                        int round2 = (int) Math.round(d6);
                                        this.zzr = round2;
                                        this.zzw = d6 - round2;
                                        i6 = i5;
                                    }
                                    short[] zzl = zzl(this.zzl, this.zzm, i6);
                                    this.zzl = zzl;
                                    zzj(i6, i2, zzl, this.zzm, sArr2, i17, sArr2, i24);
                                    this.zzm += i6;
                                    i17 += i5 + i6;
                                } else {
                                    int i25 = i17;
                                    d = d2;
                                    int i26 = i23;
                                    short[] sArr3 = this.zzj;
                                    double d7 = 1.0d - d;
                                    if (d < 0.5d) {
                                        double d8 = ((d3 * d) / d7) + this.zzw;
                                        int round3 = (int) Math.round(d8);
                                        this.zzw = d8 - round3;
                                        i4 = round3;
                                        i3 = i12;
                                    } else {
                                        i3 = i12;
                                        double d9 = ((d3 * ((d + d) - 1.0d)) / d7) + this.zzw;
                                        int round4 = (int) Math.round(d9);
                                        this.zzr = round4;
                                        this.zzw = d9 - round4;
                                        i4 = i26;
                                    }
                                    int i27 = i26 + i4;
                                    short[] zzl2 = zzl(this.zzl, this.zzm, i27);
                                    this.zzl = zzl2;
                                    System.arraycopy(sArr3, i25 * i2, zzl2, this.zzm * i2, i26 * i2);
                                    zzj(i4, i2, this.zzl, this.zzm + i26, sArr3, i24, sArr3, i25);
                                    this.zzm += i27;
                                    i17 = i25 + i4;
                                    if (i17 + i16 <= i15) {
                                        break;
                                    }
                                    i14 = 1;
                                    f4 = f;
                                    i12 = i3;
                                    d2 = d;
                                    i13 = 0;
                                }
                            } else {
                                i21 = i14;
                            }
                        }
                        zzi(sArr, i17, i20);
                        short[] sArr4 = this.zzi;
                        int i28 = this.zzf;
                        int i29 = this.zzg;
                        f = f4;
                        int zzg = zzg(sArr4, i13, i28 / i20, i29 / i20);
                        if (i20 != 1) {
                            int i30 = zzg * i20;
                            int i31 = i20 * 4;
                            int i32 = i30 - i31;
                            if (i32 >= i28) {
                                i28 = i32;
                            }
                            int i33 = i30 + i31;
                            if (i33 <= i29) {
                                i29 = i33;
                            }
                            if (i21 == 1) {
                                i = zzg(sArr, i17, i28, i29);
                            } else {
                                zzi(sArr, i17, 1);
                                i = zzg(sArr4, i13, i28, i29);
                            }
                        } else {
                            i = zzg;
                        }
                        i2 = i21;
                        int i222 = this.zzu;
                        if (i222 != 0) {
                        }
                        int i242 = i17 + i23;
                        this.zzt = i222;
                        this.zzs = i;
                        double d32 = i23;
                        if (d2 <= 1.0d) {
                        }
                    }
                    i3 = i12;
                    if (i17 + i16 <= i15) {
                    }
                }
                int i34 = this.zzk - i17;
                short[] sArr5 = this.zzj;
                int i35 = this.zzb;
                System.arraycopy(sArr5, i17 * i35, sArr5, 0, i35 * i34);
                this.zzk = i34;
                f2 = this.zze * f;
                if (f2 != 1.0f || this.zzm == (i8 = i3)) {
                }
                int i36 = this.zza;
                long j3 = i36;
                long j4 = (long) (i36 / f2);
                while (j4 != 0 && j3 != 0 && j4 % 2 == 0 && j3 % 2 == 0) {
                    j4 /= 2;
                    j3 /= 2;
                }
                int i37 = this.zzm - i8;
                short[] zzl3 = zzl(this.zzn, this.zzo, i37);
                this.zzn = zzl3;
                short[] sArr6 = this.zzl;
                int i38 = this.zzb;
                System.arraycopy(sArr6, i8 * i38, zzl3, this.zzo * i38, i37 * i38);
                this.zzm = i8;
                this.zzo += i37;
                int i39 = 0;
                while (true) {
                    i9 = this.zzo;
                    i10 = i9 - 1;
                    if (i39 >= i10) {
                        break;
                    }
                    while (true) {
                        i11 = this.zzp + 1;
                        j = i11;
                        long j5 = j * j4;
                        j2 = this.zzq;
                        if (j5 <= j2 * j3) {
                            break;
                        }
                        this.zzl = zzl(this.zzl, this.zzm, 1);
                        int i40 = 0;
                        while (i40 < i38) {
                            short[] sArr7 = this.zzl;
                            int i41 = this.zzm * i38;
                            short[] sArr8 = this.zzn;
                            int i42 = (i39 * i38) + i40;
                            short s = sArr8[i42];
                            short s2 = sArr8[i42 + i38];
                            int i43 = i40;
                            long j6 = (r11 + 1) * j4;
                            long j7 = j6 - (this.zzp * j4);
                            long j8 = j6 - (this.zzq * j3);
                            sArr7[i41 + i43] = (short) (((j8 * s) + ((j7 - j8) * s2)) / j7);
                            i40 = i43 + 1;
                        }
                        this.zzq++;
                        this.zzm++;
                    }
                    this.zzp = i11;
                    if (j == j3) {
                        this.zzp = 0;
                        zzdd.zzf(j2 == j4);
                        this.zzq = 0;
                    }
                    i39++;
                }
                if (i10 != 0) {
                    short[] sArr9 = this.zzn;
                    System.arraycopy(sArr9, i10 * i38, sArr9, 0, (i9 - i10) * i38);
                    this.zzo -= i10;
                    return;
                }
                return;
            }
        } else {
            zzh(this.zzj, 0, this.zzk);
            this.zzk = 0;
        }
        f = f4;
        i3 = i12;
        f2 = this.zze * f;
        if (f2 != 1.0f) {
        }
    }
}
