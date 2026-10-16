package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzanq {
    public static zzano zza(zzem zzemVar) throws zzaz {
        int i;
        int i2;
        char c;
        int i3;
        int i4;
        int i5;
        char c2;
        int zzd = zzemVar.zzd(8);
        int i6 = 5;
        int zzd2 = zzemVar.zzd(5);
        if (zzd2 != 31) {
            switch (zzd2) {
                case 0:
                    i = 96000;
                    break;
                case 1:
                    i = 88200;
                    break;
                case 2:
                    i = 64000;
                    break;
                case 3:
                    i = 48000;
                    break;
                case 4:
                    i = 44100;
                    break;
                case 5:
                    i = 32000;
                    break;
                case 6:
                    i = 24000;
                    break;
                case 7:
                    i = 22050;
                    break;
                case 8:
                    i = 16000;
                    break;
                case 9:
                    i = 12000;
                    break;
                case 10:
                    i = 11025;
                    break;
                case 11:
                    i = 8000;
                    break;
                case 12:
                    i = 7350;
                    break;
                case 13:
                case 14:
                default:
                    throw zzaz.zzc("Unsupported sampling rate index " + zzd2);
                case 15:
                    i = 57600;
                    break;
                case 16:
                    i = 51200;
                    break;
                case 17:
                    i = 40000;
                    break;
                case 18:
                    i = 38400;
                    break;
                case 19:
                    i = 34150;
                    break;
                case 20:
                    i = 28800;
                    break;
                case 21:
                    i = 25600;
                    break;
                case 22:
                    i = 20000;
                    break;
                case 23:
                    i = 19200;
                    break;
                case 24:
                    i = 17075;
                    break;
                case 25:
                    i = 14400;
                    break;
                case 26:
                    i = 12800;
                    break;
                case 27:
                    i = 9600;
                    break;
            }
        } else {
            i = zzemVar.zzd(24);
        }
        int zzd3 = zzemVar.zzd(3);
        int i7 = 1;
        if (zzd3 == 0) {
            i2 = 768;
        } else if (zzd3 == 1) {
            i2 = 1024;
        } else if (zzd3 == 2 || zzd3 == 3) {
            i2 = 2048;
        } else {
            if (zzd3 != 4) {
                throw zzaz.zzc("Unsupported coreSbrFrameLengthIndex " + zzd3);
            }
            i2 = 4096;
        }
        if (zzd3 == 0 || zzd3 == 1) {
            c = 0;
        } else if (zzd3 == 2) {
            c = 2;
        } else if (zzd3 == 3) {
            c = 3;
        } else {
            if (zzd3 != 4) {
                throw zzaz.zzc("Unsupported coreSbrFrameLengthIndex " + zzd3);
            }
            c = 1;
        }
        zzemVar.zzn(2);
        zze(zzemVar);
        int zzd4 = zzemVar.zzd(5);
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = 16;
            if (i8 < zzd4 + 1) {
                int zzd5 = zzemVar.zzd(3);
                i9 += zzc(zzemVar, 5, 8, 16) + 1;
                if ((zzd5 == 0 || zzd5 == 2) && zzemVar.zzp()) {
                    zze(zzemVar);
                }
                i8++;
            } else {
                int zzc = zzc(zzemVar, 4, 8, 16) + 1;
                zzemVar.zzm();
                int i11 = 0;
                while (true) {
                    double d = 2.0d;
                    if (i11 >= zzc) {
                        int i12 = zzd;
                        byte[] bArr = null;
                        if (zzemVar.zzp()) {
                            int zzc2 = zzc(zzemVar, 2, 4, 8) + 1;
                            for (int i13 = 0; i13 < zzc2; i13++) {
                                int zzc3 = zzc(zzemVar, 4, 8, 16);
                                int zzc4 = zzc(zzemVar, 4, 8, 16);
                                if (zzc3 == 7) {
                                    int zzd6 = zzemVar.zzd(4) + 1;
                                    zzemVar.zzn(4);
                                    byte[] bArr2 = new byte[zzd6];
                                    for (int i14 = 0; i14 < zzd6; i14++) {
                                        bArr2[i14] = (byte) zzemVar.zzd(8);
                                    }
                                    bArr = bArr2;
                                } else {
                                    zzemVar.zzn(zzc4 * 8);
                                }
                            }
                        }
                        byte[] bArr3 = bArr;
                        switch (i) {
                            case 14700:
                            case 16000:
                                d = 3.0d;
                                break;
                            case 22050:
                            case 24000:
                                break;
                            case 29400:
                            case 32000:
                            case 58800:
                            case 64000:
                                d = 1.5d;
                                break;
                            case 44100:
                            case 48000:
                            case 88200:
                            case 96000:
                                d = 1.0d;
                                break;
                            default:
                                throw zzaz.zzc("Unsupported sampling rate " + i);
                        }
                        return new zzano(i12, (int) (i * d), (int) (i2 * d), bArr3, null);
                    }
                    int zzd7 = zzemVar.zzd(2);
                    if (zzd7 == 0) {
                        i3 = zzd;
                        i4 = i7;
                        zzf(zzemVar);
                        if (c > 0) {
                            zzd(zzemVar);
                        }
                    } else if (zzd7 == i7) {
                        i4 = i7;
                        if (zzf(zzemVar)) {
                            zzemVar.zzm();
                        }
                        if (c > 0) {
                            zzd(zzemVar);
                            i5 = zzemVar.zzd(2);
                            c2 = c;
                        } else {
                            i5 = 0;
                            c2 = 0;
                        }
                        if (i5 > 0) {
                            zzemVar.zzn(6);
                            int zzd8 = zzemVar.zzd(2);
                            zzemVar.zzn(4);
                            if (zzemVar.zzp()) {
                                zzemVar.zzn(i6);
                            }
                            if (i5 == 2 || i5 == 3) {
                                zzemVar.zzn(6);
                            }
                            if (zzd8 == 2) {
                                zzemVar.zzm();
                            }
                        }
                        i3 = zzd;
                        int floor = ((int) Math.floor(Math.log(i9 - 1) / Math.log(2.0d))) + 1;
                        int zzd9 = zzemVar.zzd(2);
                        if (zzd9 > 0 && zzemVar.zzp()) {
                            zzemVar.zzn(floor);
                        }
                        if (zzemVar.zzp()) {
                            zzemVar.zzn(floor);
                        }
                        if (c2 == 0 && zzd9 == 0) {
                            zzemVar.zzm();
                        }
                    } else if (zzd7 != 3) {
                        i3 = zzd;
                        i4 = i7;
                    } else {
                        zzc(zzemVar, 4, 8, i10);
                        int zzc5 = zzc(zzemVar, 4, 8, i10);
                        i4 = i7;
                        if (zzemVar.zzp()) {
                            zzc(zzemVar, 8, i10, 0);
                        }
                        zzemVar.zzm();
                        if (zzc5 > 0) {
                            zzemVar.zzn(zzc5 * 8);
                        }
                        i3 = zzd;
                    }
                    i11++;
                    zzd = i3;
                    i7 = i4;
                    i6 = 5;
                    i10 = 16;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zzb(zzem zzemVar, zzann zzannVar) throws zzaz {
        long zze;
        zzemVar.zzb();
        int zzc = zzc(zzemVar, 3, 8, 8);
        zzannVar.zza = zzc;
        if (zzc == -1) {
            return false;
        }
        zzdd.zzd(Math.max(Math.max(2, 8), 32) <= 63);
        zzgbo.zza(zzgbo.zza(3L, 255L), 4294967296L);
        if (zzemVar.zza() >= 2) {
            zze = zzemVar.zze(2);
            if (zze == 3) {
                if (zzemVar.zza() >= 8) {
                    long zze2 = zzemVar.zze(8);
                    long j = zze2 + 3;
                    if (zze2 != 255) {
                        zze = j;
                    } else if (zzemVar.zza() >= 32) {
                        zze = j + zzemVar.zze(32);
                    }
                }
            }
            zzannVar.zzb = zze;
            if (zze != -1) {
                return false;
            }
            if (zze > 16) {
                throw zzaz.zzc("Contains sub-stream with an invalid packet label " + zze);
            }
            if (zze == 0) {
                int i = zzannVar.zza;
                if (i == 1) {
                    throw zzaz.zza("Mpegh3daConfig packet with invalid packet label 0", null);
                }
                if (i == 2) {
                    throw zzaz.zza("Mpegh3daFrame packet with invalid packet label 0", null);
                }
                if (i == 17) {
                    throw zzaz.zza("AudioTruncation packet with invalid packet label 0", null);
                }
            }
            int zzc2 = zzc(zzemVar, 11, 24, 24);
            zzannVar.zzc = zzc2;
            return zzc2 != -1;
        }
        zze = -1;
        zzannVar.zzb = zze;
        if (zze != -1) {
        }
    }

    private static int zzc(zzem zzemVar, int i, int i2, int i3) {
        zzdd.zzd(Math.max(Math.max(i, i2), i3) <= 31);
        int i4 = (1 << i) - 1;
        int i5 = (1 << i2) - 1;
        zzgbm.zza(zzgbm.zza(i4, i5), 1 << i3);
        if (zzemVar.zza() < i) {
            return -1;
        }
        int zzd = zzemVar.zzd(i);
        if (zzd != i4) {
            return zzd;
        }
        if (zzemVar.zza() < i2) {
            return -1;
        }
        int zzd2 = zzemVar.zzd(i2);
        int i6 = zzd + zzd2;
        if (zzd2 != i5) {
            return i6;
        }
        if (zzemVar.zza() < i3) {
            return -1;
        }
        return i6 + zzemVar.zzd(i3);
    }

    private static void zzd(zzem zzemVar) {
        zzemVar.zzn(3);
        zzemVar.zzn(8);
        boolean zzp = zzemVar.zzp();
        boolean zzp2 = zzemVar.zzp();
        if (zzp) {
            zzemVar.zzn(5);
        }
        if (zzp2) {
            zzemVar.zzn(6);
        }
    }

    private static void zze(zzem zzemVar) {
        int zzd;
        int zzd2 = zzemVar.zzd(2);
        if (zzd2 == 0) {
            zzemVar.zzn(6);
            return;
        }
        int zzc = zzc(zzemVar, 5, 8, 16) + 1;
        if (zzd2 == 1) {
            zzemVar.zzn(zzc * 7);
            return;
        }
        if (zzd2 == 2) {
            boolean zzp = zzemVar.zzp();
            int i = true != zzp ? 5 : 1;
            int i2 = true == zzp ? 7 : 5;
            int i3 = true == zzp ? 8 : 6;
            int i4 = 0;
            while (i4 < zzc) {
                if (zzemVar.zzp()) {
                    zzemVar.zzn(7);
                    zzd = 0;
                } else {
                    if (zzemVar.zzd(2) == 3 && zzemVar.zzd(i2) * i != 0) {
                        zzemVar.zzm();
                    }
                    zzd = zzemVar.zzd(i3) * i;
                    if (zzd != 0 && zzd != 180) {
                        zzemVar.zzm();
                    }
                    zzemVar.zzm();
                }
                if (zzd != 0 && zzd != 180 && zzemVar.zzp()) {
                    i4++;
                }
                i4++;
            }
        }
    }

    private static boolean zzf(zzem zzemVar) {
        zzemVar.zzn(3);
        boolean zzp = zzemVar.zzp();
        if (zzp) {
            zzemVar.zzn(13);
        }
        return zzp;
    }
}
