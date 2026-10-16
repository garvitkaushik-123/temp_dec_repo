package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzacy {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Removed duplicated region for block: B:108:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzz zza(zzen zzenVar, String str, String str2, zzs zzsVar) throws zzaz {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean zzp;
        int i7;
        int zzd;
        int zzd2;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        zzem zzemVar = new zzem();
        zzemVar.zzj(zzenVar);
        int zza2 = zzemVar.zza();
        int zzd3 = zzemVar.zzd(3);
        if (zzd3 > 1) {
            throw zzaz.zzc("Unsupported AC-4 DSI version: " + zzd3);
        }
        int zzd4 = zzemVar.zzd(7);
        int i14 = true != zzemVar.zzp() ? 44100 : 48000;
        zzemVar.zzn(4);
        int zzd5 = zzemVar.zzd(9);
        if (zzd4 > 1) {
            if (zzd3 == 0) {
                throw zzaz.zzc("Invalid AC-4 DSI version: 0");
            }
            if (zzemVar.zzp()) {
                zzemVar.zzn(16);
                if (zzemVar.zzp()) {
                    zzemVar.zzn(128);
                }
            }
        }
        if (zzd3 == 1) {
            if (!zzg(zzemVar)) {
                throw zzaz.zzc("Invalid AC-4 DSI bitrate.");
            }
            zzemVar.zzf();
        }
        zzacv zzacvVar = new zzacv(null);
        for (int i15 = 0; i15 < zzd5; i15++) {
            if (zzd3 == 0) {
                zzp = zzemVar.zzp();
                i7 = 8;
                zzd = zzemVar.zzd(5);
                zzd2 = zzemVar.zzd(5);
                i8 = 0;
                i9 = 0;
                z = false;
            } else {
                int zzd6 = zzemVar.zzd(8);
                i8 = zzemVar.zzd(8);
                i7 = 8;
                if (i8 == 255) {
                    i8 = zzemVar.zzd(16) + 255;
                }
                if (zzd6 > 2) {
                    zzemVar.zzn(i8 * 8);
                } else {
                    int zza3 = (zza2 - zzemVar.zza()) / 8;
                    zzd = zzemVar.zzd(5);
                    z = zzd == 31;
                    zzd2 = zzd6;
                    i9 = zza3;
                    zzp = false;
                }
            }
            zzacvVar.zzf = zzd2;
            if (zzp || z || zzd != 6) {
                zzacvVar.zzg = zzemVar.zzd(3);
                if (zzemVar.zzp()) {
                    zzemVar.zzn(5);
                }
                zzemVar.zzn(2);
                if (zzd3 == 1) {
                    if (zzd2 != 1) {
                        if (zzd2 == 2) {
                            zzd2 = 2;
                        }
                    }
                    zzemVar.zzn(2);
                }
                zzemVar.zzn(5);
                zzemVar.zzn(10);
                if (zzd3 == 1) {
                    if (zzd2 > 0) {
                        zzacvVar.zza = zzemVar.zzp();
                    }
                    if (zzacvVar.zza) {
                        if (zzd2 != 1) {
                            i11 = 2;
                            if (zzd2 == 2) {
                                i13 = 2;
                            } else {
                                i10 = zza2;
                                i13 = zzd2;
                                zzemVar.zzn(24);
                                i12 = 1;
                            }
                        } else {
                            i13 = 1;
                        }
                        i10 = zza2;
                        int zzd7 = zzemVar.zzd(5);
                        if (zzd7 >= 0 && zzd7 <= 15) {
                            zzacvVar.zzb = zzd7;
                        }
                        if (zzd7 < 11 || zzd7 > 14) {
                            i11 = 2;
                        } else {
                            zzacvVar.zzd = zzemVar.zzp();
                            i11 = 2;
                            zzacvVar.zze = zzemVar.zzd(2);
                        }
                        zzemVar.zzn(24);
                        i12 = 1;
                    } else {
                        i10 = zza2;
                        i11 = 2;
                        i12 = 1;
                        i13 = zzd2;
                    }
                    if (zzd2 == i12 || zzd2 == i11) {
                        if (zzemVar.zzp() && zzemVar.zzp()) {
                            zzemVar.zzn(i11);
                        }
                        if (zzemVar.zzp()) {
                            zzemVar.zzm();
                            int i16 = i7;
                            int zzd8 = zzemVar.zzd(i16);
                            int i17 = 0;
                            while (i17 < zzd8) {
                                zzemVar.zzn(i16);
                                i17++;
                                i16 = 8;
                            }
                        }
                    }
                    zzd2 = i13;
                } else {
                    i10 = zza2;
                }
                if (zzp || z) {
                    i3 = 2;
                    if (zzd2 == 0) {
                        zzd(zzemVar, zzacvVar);
                        zzd2 = 0;
                        zzemVar.zzm();
                        if (!zzemVar.zzp()) {
                            i5 = 7;
                            if (zzd2 > 0) {
                                if (zzemVar.zzp() && !zzg(zzemVar)) {
                                    throw zzaz.zzc("Can't parse bitrate DSI.");
                                }
                                if (zzemVar.zzp()) {
                                    zzemVar.zzf();
                                    zzemVar.zzo(zzemVar.zzd(16));
                                    i2 = 5;
                                    int zzd9 = zzemVar.zzd(5);
                                    int i18 = 0;
                                    while (true) {
                                        i = 3;
                                        if (i18 >= zzd9) {
                                            break;
                                        }
                                        zzemVar.zzn(3);
                                        zzemVar.zzn(8);
                                        i18++;
                                    }
                                    i4 = 8;
                                    zzemVar.zzf();
                                    if (zzd3 == 1) {
                                        int zza4 = ((i10 - zzemVar.zza()) / 8) - i9;
                                        if (i8 < zza4) {
                                            throw zzaz.zzc("pres_bytes is smaller than presentation bytes read.");
                                        }
                                        zzemVar.zzo(i8 - zza4);
                                    }
                                    if (zzacvVar.zza) {
                                        i6 = -1;
                                        if (zzacvVar.zzb == -1) {
                                            throw zzaz.zzc("Can't determine channel mode of presentation " + i15);
                                        }
                                    }
                                    i6 = -1;
                                }
                            }
                            i2 = 5;
                            i = 3;
                            i4 = 8;
                            zzemVar.zzf();
                            if (zzd3 == 1) {
                            }
                            if (zzacvVar.zza) {
                            }
                            i6 = -1;
                        }
                    } else {
                        zze(zzemVar, zzacvVar);
                        zzemVar.zzm();
                        if (!zzemVar.zzp()) {
                        }
                    }
                } else {
                    zzemVar.zzm();
                    if (zzd == 0 || zzd == 1 || zzd == 2) {
                        if (zzd2 == 0) {
                            i3 = 2;
                            for (int i19 = 0; i19 < 2; i19++) {
                                zzd(zzemVar, zzacvVar);
                            }
                            zzd2 = 0;
                            zzemVar.zzm();
                            if (!zzemVar.zzp()) {
                            }
                        } else {
                            i3 = 2;
                            for (int i20 = 0; i20 < 2; i20++) {
                                zze(zzemVar, zzacvVar);
                            }
                            zzemVar.zzm();
                            if (!zzemVar.zzp()) {
                            }
                        }
                    } else if (zzd != 3 && zzd != 4) {
                        if (zzd != 5) {
                            int zzd10 = zzemVar.zzd(7);
                            for (int i21 = 0; i21 < zzd10; i21++) {
                                zzemVar.zzn(8);
                            }
                        } else if (zzd2 == 0) {
                            zzd(zzemVar, zzacvVar);
                            i3 = 2;
                            zzd2 = 0;
                            zzemVar.zzm();
                            if (!zzemVar.zzp()) {
                            }
                        } else {
                            int zzd11 = zzemVar.zzd(3);
                            for (int i22 = 0; i22 < zzd11 + 2; i22++) {
                                zze(zzemVar, zzacvVar);
                            }
                        }
                        i3 = 2;
                        zzemVar.zzm();
                        if (!zzemVar.zzp()) {
                        }
                    } else if (zzd2 == 0) {
                        for (int i23 = 0; i23 < 3; i23++) {
                            zzd(zzemVar, zzacvVar);
                        }
                        i3 = 2;
                        zzd2 = 0;
                        zzemVar.zzm();
                        if (!zzemVar.zzp()) {
                        }
                    } else {
                        for (int i24 = 0; i24 < 3; i24++) {
                            zze(zzemVar, zzacvVar);
                        }
                        i3 = 2;
                        zzemVar.zzm();
                        if (!zzemVar.zzp()) {
                        }
                    }
                }
                if (zzacvVar.zza) {
                    int i25 = zzacvVar.zzb;
                    boolean z2 = zzacvVar.zzd;
                    int i26 = zzacvVar.zze;
                    switch (i25) {
                        case 0:
                            i2 = 1;
                            break;
                        case 1:
                            i2 = i3;
                            break;
                        case 2:
                            i2 = i;
                            break;
                        case 3:
                            break;
                        case 4:
                            i2 = 6;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            i2 = i5;
                            break;
                        case 6:
                        case 8:
                        case 10:
                            i2 = i4;
                            break;
                        case 11:
                            i2 = 11;
                            break;
                        case 12:
                            i2 = 12;
                            break;
                        case 13:
                            i2 = 13;
                            break;
                        case 14:
                            i2 = 14;
                            break;
                        case 15:
                            i2 = 24;
                            break;
                        default:
                            i2 = i6;
                            break;
                    }
                    if (i25 == 11 || i25 == 12 || i25 == 13 || i25 == 14) {
                        if (!z2) {
                            i2 -= 2;
                        }
                        if (i26 == 0) {
                            i2 -= 4;
                        } else if (i26 == 1) {
                            i2 -= 2;
                        }
                    }
                } else {
                    i2 = zzacvVar.zzc + 1;
                    if (zzacvVar.zzg == 4 && i2 == 17) {
                        i2 = 21;
                    }
                }
                if (i2 <= 0) {
                    throw zzaz.zzc("Can't determine channel count of presentation.");
                }
                Object[] objArr = {Integer.valueOf(zzd4), Integer.valueOf(zzacvVar.zzf), Integer.valueOf(zzacvVar.zzg)};
                String str3 = zzex.zza;
                String format = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr);
                zzx zzxVar = new zzx();
                zzxVar.zzS(str);
                zzxVar.zzah("audio/ac4");
                zzxVar.zzD(i2);
                zzxVar.zzai(i14);
                zzxVar.zzL(zzsVar);
                zzxVar.zzW(str2);
                zzxVar.zzE(format);
                return zzxVar.zzan();
            }
            i10 = zza2;
            i3 = 2;
            i5 = 7;
            int zzd12 = zzemVar.zzd(7);
            for (int i27 = 0; i27 < zzd12; i27++) {
                zzemVar.zzn(15);
            }
            if (zzd2 > 0) {
            }
            i2 = 5;
            i = 3;
            i4 = 8;
            zzemVar.zzf();
            if (zzd3 == 1) {
            }
            if (zzacvVar.zza) {
            }
            i6 = -1;
            if (zzacvVar.zza) {
            }
            if (i2 <= 0) {
            }
        }
        i = 3;
        i2 = 5;
        i3 = 2;
        i4 = 8;
        i5 = 7;
        i6 = -1;
        if (zzacvVar.zza) {
        }
        if (i2 <= 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (r11 != 11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0095, code lost:
    
        if (r11 != 11) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009a, code lost:
    
        if (r11 != 8) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzacw zzb(zzem zzemVar) {
        int i;
        int i2;
        int zzd;
        int zzd2 = zzemVar.zzd(16);
        int zzd3 = zzemVar.zzd(16);
        if (zzd3 == 65535) {
            zzd3 = zzemVar.zzd(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = zzd3 + i;
        if (zzd2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int zzd4 = zzemVar.zzd(2);
        int i5 = 0;
        if (zzd4 == 3) {
            int i6 = 0;
            while (true) {
                zzd = i6 + zzemVar.zzd(2);
                if (!zzemVar.zzp()) {
                    break;
                }
                i6 = (zzd + 1) << 2;
            }
            zzd4 = zzd + 3;
        }
        int i7 = zzd4;
        int zzd5 = zzemVar.zzd(10);
        if (zzemVar.zzp() && zzemVar.zzd(3) > 0) {
            zzemVar.zzn(2);
        }
        int i8 = 44100;
        if (true != zzemVar.zzp()) {
            i2 = 44100;
        } else {
            i2 = 44100;
            i8 = 48000;
        }
        int zzd6 = zzemVar.zzd(4);
        if (i8 == i2 && zzd6 == 13) {
            i5 = zzb[13];
        } else if (i8 == 48000 && zzd6 < 14) {
            i5 = zzb[zzd6];
            int i9 = zzd5 % 5;
            if (i9 != 1) {
                if (i9 == 2) {
                    if (zzd6 != 8) {
                    }
                    i5++;
                } else if (i9 != 3) {
                    if (i9 == 4) {
                        if (zzd6 != 3) {
                            if (zzd6 != 8) {
                            }
                        }
                        i5++;
                    }
                }
            }
            if (zzd6 != 3) {
            }
            i5++;
        }
        return new zzacw(i7, 2, i8, i4, i5, null);
    }

    public static void zzc(int i, zzen zzenVar) {
        zzenVar.zzI(7);
        byte[] zzN = zzenVar.zzN();
        zzN[0] = -84;
        zzN[1] = SignedBytes.MAX_POWER_OF_TWO;
        zzN[2] = -1;
        zzN[3] = -1;
        zzN[4] = (byte) ((i >> 16) & 255);
        zzN[5] = (byte) ((i >> 8) & 255);
        zzN[6] = (byte) (i & 255);
    }

    private static void zzd(zzem zzemVar, zzacv zzacvVar) throws zzaz {
        int zzd = zzemVar.zzd(5);
        zzemVar.zzn(2);
        if (zzemVar.zzp()) {
            zzemVar.zzn(5);
        }
        if (zzd >= 7 && zzd <= 10) {
            zzemVar.zzm();
        }
        if (zzemVar.zzp()) {
            int zzd2 = zzemVar.zzd(3);
            if (zzacvVar.zzb == -1 && zzd >= 0 && zzd <= 15 && (zzd2 == 0 || zzd2 == 1)) {
                zzacvVar.zzb = zzd;
            }
            if (zzemVar.zzp()) {
                zzf(zzemVar);
            }
        }
    }

    private static void zze(zzem zzemVar, zzacv zzacvVar) throws zzaz {
        zzemVar.zzn(2);
        boolean zzp = zzemVar.zzp();
        int zzd = zzemVar.zzd(8);
        for (int i = 0; i < zzd; i++) {
            zzemVar.zzn(2);
            if (zzemVar.zzp()) {
                zzemVar.zzn(5);
            }
            if (zzp) {
                zzemVar.zzn(24);
            } else {
                if (zzemVar.zzp()) {
                    if (!zzemVar.zzp()) {
                        zzemVar.zzn(4);
                    }
                    zzacvVar.zzc = zzemVar.zzd(6) + 1;
                }
                zzemVar.zzn(4);
            }
        }
        if (zzemVar.zzp()) {
            zzemVar.zzn(3);
            if (zzemVar.zzp()) {
                zzf(zzemVar);
            }
        }
    }

    private static void zzf(zzem zzemVar) throws zzaz {
        int zzd = zzemVar.zzd(6);
        if (zzd < 2 || zzd > 42) {
            throw zzaz.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(zzd)));
        }
        zzemVar.zzn(zzd * 8);
    }

    private static boolean zzg(zzem zzemVar) {
        if (zzemVar.zza() < 66) {
            return false;
        }
        zzemVar.zzn(66);
        return true;
    }
}
