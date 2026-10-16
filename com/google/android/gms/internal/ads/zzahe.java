package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzahe {
    public static final zzahc zza = new Object() { // from class: com.google.android.gms.internal.ads.zzahc
    };

    /* JADX WARN: Removed duplicated region for block: B:6:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final zzav zza(byte[] bArr, int i, zzahc zzahcVar, zzagq zzagqVar) {
        zzahd zzahdVar;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ArrayList arrayList = new ArrayList();
        zzen zzenVar = new zzen(bArr, i);
        boolean z2 = false;
        if (zzenVar.zza() < 10) {
            zzea.zzf("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int zzo = zzenVar.zzo();
            if (zzo == 4801587) {
                int zzm = zzenVar.zzm();
                zzenVar.zzM(1);
                int zzm2 = zzenVar.zzm();
                int zzl = zzenVar.zzl();
                if (zzm == 2) {
                    if ((zzm2 & 64) != 0) {
                        zzea.zzf("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                    }
                    zzahdVar = new zzahd(zzm, zzm >= 4 && (zzm2 & 128) != 0, zzl);
                } else {
                    if (zzm == 3) {
                        if ((zzm2 & 64) != 0) {
                            int zzg = zzenVar.zzg();
                            zzenVar.zzM(zzg);
                            zzl -= zzg + 4;
                        }
                    } else if (zzm == 4) {
                        if ((zzm2 & 64) != 0) {
                            int zzl2 = zzenVar.zzl();
                            zzenVar.zzM(zzl2 - 4);
                            zzl -= zzl2;
                        }
                        if ((zzm2 & 16) != 0) {
                            zzl -= 10;
                        }
                    } else {
                        zzea.zzf("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + zzm);
                    }
                    zzahdVar = new zzahd(zzm, zzm >= 4 && (zzm2 & 128) != 0, zzl);
                }
                if (zzahdVar != null) {
                    return null;
                }
                int zzc = zzenVar.zzc();
                i2 = zzahdVar.zza;
                int i9 = i2 == 2 ? 6 : 10;
                i3 = zzahdVar.zzc;
                z = zzahdVar.zzb;
                if (z) {
                    i8 = zzahdVar.zzc;
                    i3 = zze(zzenVar, i8);
                }
                zzenVar.zzK(zzc + i3);
                i4 = zzahdVar.zza;
                if (!zzj(zzenVar, i4, i9, false)) {
                    i6 = zzahdVar.zza;
                    if (i6 != 4 || !zzj(zzenVar, 4, i9, true)) {
                        i7 = zzahdVar.zza;
                        zzea.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + i7);
                        return null;
                    }
                    z2 = true;
                }
                while (zzenVar.zza() >= i9) {
                    i5 = zzahdVar.zza;
                    zzahf zzl3 = zzl(i5, zzenVar, z2, i9, zzahcVar);
                    if (zzl3 != null) {
                        arrayList.add(zzl3);
                    }
                }
                return new zzav(arrayList);
            }
            zzea.zzf("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.valueOf(String.format("%06X", Integer.valueOf(zzo)))));
        }
        zzahdVar = null;
        if (zzahdVar != null) {
        }
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int zzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            int i3 = zzd + 1;
            if ((zzd - i) % 2 == 0 && bArr[i3] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzen zzenVar, int i) {
        byte[] zzN = zzenVar.zzN();
        int zzc = zzenVar.zzc();
        int i2 = zzc;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= zzc + i) {
                return i;
            }
            if ((zzN[i2] & 255) == 255 && zzN[i3] == 0) {
                System.arraycopy(zzN, i2 + 2, zzN, i3, (i - (i2 - zzc)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    private static zzfyq zzf(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzfyq.zzo("");
        }
        int i3 = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        int zzc = zzc(bArr, i2, i);
        while (i2 < zzc) {
            zzfynVar.zzf(new String(bArr, i2, zzc - i2, zzi(i)));
            i2 = zzb(i) + zzc;
            zzc = zzc(bArr, i2, i);
        }
        zzfyq zzi = zzfynVar.zzi();
        return zzi.isEmpty() ? zzfyq.zzo("") : zzi;
    }

    private static String zzg(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzh(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean zzj(zzen zzenVar, int i, int i2, boolean z) {
        boolean z2;
        int zzo;
        long zzo2;
        int i3;
        int i4;
        int zzc = zzenVar.zzc();
        while (true) {
            try {
                z2 = true;
                z2 = true;
                int i5 = 1;
                int i6 = 1;
                if (zzenVar.zza() >= i2) {
                    if (i >= 3) {
                        zzo = zzenVar.zzg();
                        zzo2 = zzenVar.zzu();
                        i3 = zzenVar.zzq();
                    } else {
                        zzo = zzenVar.zzo();
                        zzo2 = zzenVar.zzo();
                        i3 = 0;
                    }
                    if (zzo == 0 && zzo2 == 0 && i3 == 0) {
                        break;
                    }
                    if (i == 4 && !z) {
                        if ((8421504 & zzo2) != 0) {
                            break;
                        }
                        zzo2 = ((zzo2 >> 24) << 21) | (((zzo2 >> 16) & 255) << 14) | (zzo2 & 255) | (((zzo2 >> 8) & 255) << 7);
                    }
                    if (i == 4) {
                        if ((i3 & 64) == 0) {
                            i5 = 0;
                        }
                        int i7 = i5;
                        i6 = i3 & 1;
                        i4 = i7;
                    } else if (i == 3) {
                        i4 = (i3 & 32) != 0 ? 1 : 0;
                        if ((i3 & 128) == 0) {
                            i6 = 0;
                        }
                    } else {
                        i4 = 0;
                        i6 = 0;
                    }
                    if (i6 != 0) {
                        i4 += 4;
                    }
                    if (zzo2 >= i4 && zzenVar.zza() >= zzo2) {
                        zzenVar.zzM((int) zzo2);
                    }
                } else {
                    break;
                }
            } finally {
                zzenVar.zzL(zzc);
            }
        }
        return z2;
    }

    private static byte[] zzk(byte[] bArr, int i, int i2) {
        return i2 <= i ? zzex.zzb : Arrays.copyOfRange(bArr, i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:215:0x0287, code lost:
    
        if (r9 == 67) goto L153;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0500  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzahf zzl(int i, zzen zzenVar, boolean z, int i2, zzahc zzahcVar) {
        int zzp;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        String str;
        zzahf zzahfVar;
        int i6;
        zzahf zzagxVar;
        zzahf zzahiVar;
        int zzd;
        String zza2;
        int zzm = zzenVar.zzm();
        int zzm2 = zzenVar.zzm();
        int zzm3 = zzenVar.zzm();
        int zzm4 = i >= 3 ? zzenVar.zzm() : 0;
        if (i == 4) {
            zzp = zzenVar.zzp();
            if (!z) {
                zzp = ((zzp >> 24) << 21) | (zzp & 255) | (((zzp >> 8) & 255) << 7) | (((zzp >> 16) & 255) << 14);
            }
        } else {
            zzp = i == 3 ? zzenVar.zzp() : zzenVar.zzo();
        }
        int zzq = i >= 3 ? zzenVar.zzq() : 0;
        if (zzm == 0 && zzm2 == 0 && zzm3 == 0 && zzm4 == 0 && zzp == 0 && zzq == 0) {
            zzenVar.zzL(zzenVar.zzd());
            return null;
        }
        int zzc = zzenVar.zzc() + zzp;
        if (zzc > zzenVar.zzd()) {
            zzea.zzf("Id3Decoder", "Frame size exceeds remaining tag data");
            zzenVar.zzL(zzenVar.zzd());
            return null;
        }
        if (zzahcVar != null) {
            zzenVar.zzL(zzc);
            return null;
        }
        if (i == 3) {
            int i7 = zzq & 64;
            i3 = (zzq & 128) != 0 ? 1 : 0;
            i5 = 0;
            z3 = i7 != 0;
            z2 = (zzq & 32) != 0;
            i4 = i3;
        } else if (i == 4) {
            boolean z4 = (zzq & 64) != 0;
            int i8 = (zzq & 8) != 0 ? 1 : 0;
            z3 = (zzq & 4) != 0;
            i5 = (zzq & 2) != 0 ? 1 : 0;
            i4 = zzq & 1;
            int i9 = i8;
            z2 = z4;
            i3 = i9;
        } else {
            i3 = 0;
            i4 = 0;
            z2 = false;
            z3 = false;
            i5 = 0;
        }
        if (i3 != 0 || z3) {
            zzea.zzf("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            zzenVar.zzL(zzc);
            return null;
        }
        if (z2) {
            zzenVar.zzM(1);
            zzp--;
        }
        if (i4 != 0) {
            zzenVar.zzM(4);
            zzp -= 4;
        }
        if (i5 != 0) {
            zzp = zze(zzenVar, zzp);
        }
        try {
            try {
                if (zzm == 84 && zzm2 == 88 && zzm3 == 88 && (i == 2 || zzm4 == 88)) {
                    if (zzp > 0) {
                        int zzm5 = zzenVar.zzm();
                        int i10 = zzp - 1;
                        byte[] bArr = new byte[i10];
                        zzenVar.zzH(bArr, 0, i10);
                        int zzc2 = zzc(bArr, 0, zzm5);
                        zzagxVar = new zzahk("TXXX", new String(bArr, 0, zzc2, zzi(zzm5)), zzf(bArr, zzm5, zzc2 + zzb(zzm5)));
                        i5 = zzm;
                        str = "Id3Decoder";
                        zzenVar.zzL(zzc);
                        zzahfVar = zzagxVar;
                        e = null;
                    }
                    i5 = zzm;
                    str = "Id3Decoder";
                    zzagxVar = null;
                    zzenVar.zzL(zzc);
                    zzahfVar = zzagxVar;
                    e = null;
                } else if (zzm == 84) {
                    String zzh = zzh(i, 84, zzm2, zzm3, zzm4);
                    if (zzp > 0) {
                        int zzm6 = zzenVar.zzm();
                        int i11 = zzp - 1;
                        byte[] bArr2 = new byte[i11];
                        zzenVar.zzH(bArr2, 0, i11);
                        i5 = zzm;
                        zzagxVar = new zzahk(zzh, null, zzf(bArr2, zzm6, 0));
                        str = "Id3Decoder";
                        zzenVar.zzL(zzc);
                        zzahfVar = zzagxVar;
                        e = null;
                    }
                    i5 = zzm;
                    str = "Id3Decoder";
                    zzagxVar = null;
                    zzenVar.zzL(zzc);
                    zzahfVar = zzagxVar;
                    e = null;
                } else {
                    if (zzm != 87) {
                        i6 = zzm;
                    } else if (zzm2 != 88 || zzm3 != 88 || (i != 2 && zzm4 != 88)) {
                        i6 = 87;
                    } else if (zzp <= 0) {
                        i5 = zzm;
                        str = "Id3Decoder";
                        zzagxVar = null;
                        zzenVar.zzL(zzc);
                        zzahfVar = zzagxVar;
                        e = null;
                    } else {
                        int zzm7 = zzenVar.zzm();
                        int i12 = zzp - 1;
                        byte[] bArr3 = new byte[i12];
                        zzenVar.zzH(bArr3, 0, i12);
                        int zzc3 = zzc(bArr3, 0, zzm7);
                        String str2 = new String(bArr3, 0, zzc3, zzi(zzm7));
                        int zzb = zzc3 + zzb(zzm7);
                        zzagxVar = new zzahl("WXXX", str2, zzg(bArr3, zzb, zzd(bArr3, zzb), StandardCharsets.ISO_8859_1));
                        i5 = zzm;
                        str = "Id3Decoder";
                        zzenVar.zzL(zzc);
                        zzahfVar = zzagxVar;
                        e = null;
                    }
                    if (i6 == 87) {
                        String zzh2 = zzh(i, 87, zzm2, zzm3, zzm4);
                        byte[] bArr4 = new byte[zzp];
                        zzenVar.zzH(bArr4, 0, zzp);
                        zzagxVar = new zzahl(zzh2, null, new String(bArr4, 0, zzd(bArr4, 0), StandardCharsets.ISO_8859_1));
                    } else {
                        if (i6 == 80) {
                            if (zzm2 == 82 && zzm3 == 73 && zzm4 == 86) {
                                byte[] bArr5 = new byte[zzp];
                                zzenVar.zzH(bArr5, 0, zzp);
                                int zzd2 = zzd(bArr5, 0);
                                zzagxVar = new zzahj(new String(bArr5, 0, zzd2, StandardCharsets.ISO_8859_1), zzk(bArr5, zzd2 + 1, zzp));
                            } else {
                                i6 = 80;
                            }
                        }
                        try {
                            try {
                                if (i6 == 71) {
                                    if (zzm2 != 69 || zzm3 != 79) {
                                        str = "Id3Decoder";
                                        i6 = 71;
                                        if (i != 2) {
                                            if (i6 == 80 && zzm2 == 73 && zzm3 == 67) {
                                                int zzm8 = zzenVar.zzm();
                                                Charset zzi = zzi(zzm8);
                                                int i13 = zzp - 1;
                                                byte[] bArr6 = new byte[i13];
                                                zzenVar.zzH(bArr6, 0, i13);
                                                if (i == 2) {
                                                    zza2 = "image/".concat(String.valueOf(zzfuv.zza(new String(bArr6, 0, 3, StandardCharsets.ISO_8859_1))));
                                                    if ("image/jpg".equals(zza2)) {
                                                        zza2 = "image/jpeg";
                                                    }
                                                    zzd = 2;
                                                } else {
                                                    zzd = zzd(bArr6, 0);
                                                    zza2 = zzfuv.zza(new String(bArr6, 0, zzd, StandardCharsets.ISO_8859_1));
                                                    if (zza2.indexOf(47) == -1) {
                                                        zza2 = "image/".concat(String.valueOf(zza2));
                                                    }
                                                }
                                                int i14 = bArr6[zzd + 1] & 255;
                                                int i15 = zzd + 2;
                                                int zzc4 = zzc(bArr6, i15, zzm8);
                                                i5 = zzm;
                                                zzagxVar = new zzagw(zza2, new String(bArr6, i15, zzc4 - i15, zzi), i14, zzk(bArr6, zzc4 + zzb(zzm8), i13));
                                                zzenVar.zzL(zzc);
                                                zzahfVar = zzagxVar;
                                                e = null;
                                            }
                                            i5 = zzm;
                                            if (i6 == 67 || zzm2 != 79 || zzm3 != 77 || (zzm4 != 77 && i != 2)) {
                                                if (i6 != 67 && zzm2 == 72 && zzm3 == 65 && zzm4 == 80) {
                                                    int zzc5 = zzenVar.zzc();
                                                    int zzd3 = zzd(zzenVar.zzN(), zzc5);
                                                    String str3 = new String(zzenVar.zzN(), zzc5, zzd3 - zzc5, StandardCharsets.ISO_8859_1);
                                                    zzenVar.zzL(zzd3 + 1);
                                                    int zzg = zzenVar.zzg();
                                                    int zzg2 = zzenVar.zzg();
                                                    long zzu = zzenVar.zzu();
                                                    if (zzu == 4294967295L) {
                                                        zzu = -1;
                                                    }
                                                    long j = zzu;
                                                    long zzu2 = zzenVar.zzu();
                                                    if (zzu2 == 4294967295L) {
                                                        zzu2 = -1;
                                                    }
                                                    long j2 = zzu2;
                                                    ArrayList arrayList = new ArrayList();
                                                    int i16 = zzc5 + zzp;
                                                    while (zzenVar.zzc() < i16) {
                                                        zzahf zzl = zzl(i, zzenVar, z, i2, null);
                                                        if (zzl != null) {
                                                            arrayList.add(zzl);
                                                        }
                                                    }
                                                    zzahiVar = new zzagy(str3, zzg, zzg2, j, j2, (zzahf[]) arrayList.toArray(new zzahf[0]));
                                                } else if (i6 != 67 && zzm2 == 84 && zzm3 == 79 && zzm4 == 67) {
                                                    int zzc6 = zzenVar.zzc();
                                                    int zzd4 = zzd(zzenVar.zzN(), zzc6);
                                                    String str4 = new String(zzenVar.zzN(), zzc6, zzd4 - zzc6, StandardCharsets.ISO_8859_1);
                                                    zzenVar.zzL(zzd4 + 1);
                                                    int zzm9 = zzenVar.zzm();
                                                    boolean z5 = (zzm9 & 2) != 0;
                                                    int i17 = zzm9 & 1;
                                                    int zzm10 = zzenVar.zzm();
                                                    String[] strArr = new String[zzm10];
                                                    int i18 = 0;
                                                    while (i18 < zzm10) {
                                                        int zzc7 = zzenVar.zzc();
                                                        int i19 = zzc6;
                                                        int zzd5 = zzd(zzenVar.zzN(), zzc7);
                                                        String[] strArr2 = strArr;
                                                        strArr2[i18] = new String(zzenVar.zzN(), zzc7, zzd5 - zzc7, StandardCharsets.ISO_8859_1);
                                                        zzenVar.zzL(zzd5 + 1);
                                                        i18++;
                                                        zzc6 = i19;
                                                        zzm10 = zzm10;
                                                        str4 = str4;
                                                        strArr = strArr2;
                                                    }
                                                    int i20 = zzc6;
                                                    String str5 = str4;
                                                    String[] strArr3 = strArr;
                                                    ArrayList arrayList2 = new ArrayList();
                                                    int i21 = i20 + zzp;
                                                    while (zzenVar.zzc() < i21) {
                                                        zzahf zzl2 = zzl(i, zzenVar, z, i2, null);
                                                        if (zzl2 != null) {
                                                            arrayList2.add(zzl2);
                                                        }
                                                    }
                                                    zzahiVar = new zzagz(str5, z5, 1 == i17, strArr3, (zzahf[]) arrayList2.toArray(new zzahf[0]));
                                                } else if (i6 != 77 && zzm2 == 76 && zzm3 == 76 && zzm4 == 84) {
                                                    int zzq2 = zzenVar.zzq();
                                                    int zzo = zzenVar.zzo();
                                                    int zzo2 = zzenVar.zzo();
                                                    int zzm11 = zzenVar.zzm();
                                                    int zzm12 = zzenVar.zzm();
                                                    zzem zzemVar = new zzem();
                                                    zzemVar.zzj(zzenVar);
                                                    int i22 = ((zzp - 10) * 8) / (zzm11 + zzm12);
                                                    int[] iArr = new int[i22];
                                                    int[] iArr2 = new int[i22];
                                                    for (int i23 = 0; i23 < i22; i23++) {
                                                        int zzd6 = zzemVar.zzd(zzm11);
                                                        int zzd7 = zzemVar.zzd(zzm12);
                                                        iArr[i23] = zzd6;
                                                        iArr2[i23] = zzd7;
                                                    }
                                                    zzahiVar = new zzahi(zzq2, zzo, zzo2, iArr, iArr2);
                                                } else {
                                                    String zzh3 = zzh(i, i6, zzm2, zzm3, zzm4);
                                                    byte[] bArr7 = new byte[zzp];
                                                    zzenVar.zzH(bArr7, 0, zzp);
                                                    zzagxVar = new zzagx(zzh3, bArr7);
                                                }
                                                zzagxVar = zzahiVar;
                                            } else if (zzp < 4) {
                                                zzagxVar = null;
                                            } else {
                                                int zzm13 = zzenVar.zzm();
                                                Charset zzi2 = zzi(zzm13);
                                                byte[] bArr8 = new byte[3];
                                                zzenVar.zzH(bArr8, 0, 3);
                                                String str6 = new String(bArr8, 0, 3);
                                                int i24 = zzp - 4;
                                                byte[] bArr9 = new byte[i24];
                                                zzenVar.zzH(bArr9, 0, i24);
                                                int zzc8 = zzc(bArr9, 0, zzm13);
                                                String str7 = new String(bArr9, 0, zzc8, zzi2);
                                                int zzb2 = zzc8 + zzb(zzm13);
                                                zzagxVar = new zzaha(str6, str7, zzg(bArr9, zzb2, zzc(bArr9, zzb2, zzm13), zzi2));
                                            }
                                            zzenVar.zzL(zzc);
                                            zzahfVar = zzagxVar;
                                            e = null;
                                        } else {
                                            if (i6 == 65) {
                                                if (zzm2 == 80) {
                                                    if (zzm3 == 73) {
                                                    }
                                                }
                                            }
                                            i5 = zzm;
                                            if (i6 == 67) {
                                            }
                                            if (i6 != 67) {
                                            }
                                            if (i6 != 67) {
                                            }
                                            if (i6 != 77) {
                                            }
                                            String zzh32 = zzh(i, i6, zzm2, zzm3, zzm4);
                                            byte[] bArr72 = new byte[zzp];
                                            zzenVar.zzH(bArr72, 0, zzp);
                                            zzagxVar = new zzagx(zzh32, bArr72);
                                            zzenVar.zzL(zzc);
                                            zzahfVar = zzagxVar;
                                            e = null;
                                        }
                                    } else if (zzm4 == 66 || i == 2) {
                                        try {
                                            int zzm14 = zzenVar.zzm();
                                            Charset zzi3 = zzi(zzm14);
                                            int i25 = zzp - 1;
                                            byte[] bArr10 = new byte[i25];
                                            zzenVar.zzH(bArr10, 0, i25);
                                            int zzd8 = zzd(bArr10, 0);
                                            str = "Id3Decoder";
                                            String zze = zzay.zze(new String(bArr10, 0, zzd8, StandardCharsets.ISO_8859_1));
                                            int i26 = zzd8 + 1;
                                            int zzc9 = zzc(bArr10, i26, zzm14);
                                            String zzg3 = zzg(bArr10, i26, zzc9, zzi3);
                                            int zzb3 = zzc9 + zzb(zzm14);
                                            int zzc10 = zzc(bArr10, zzb3, zzm14);
                                            i5 = zzm;
                                            zzagxVar = new zzahb(zze, zzg3, zzg(bArr10, zzb3, zzc10, zzi3), zzk(bArr10, zzc10 + zzb(zzm14), i25));
                                            zzenVar.zzL(zzc);
                                            zzahfVar = zzagxVar;
                                            e = null;
                                        } catch (Exception e) {
                                            e = e;
                                            str = "Id3Decoder";
                                            i5 = zzm;
                                            zzenVar.zzL(zzc);
                                            zzahfVar = null;
                                            if (zzahfVar == null) {
                                            }
                                            return zzahfVar;
                                        } catch (OutOfMemoryError e2) {
                                            e = e2;
                                            str = "Id3Decoder";
                                            i5 = zzm;
                                            zzenVar.zzL(zzc);
                                            zzahfVar = null;
                                            if (zzahfVar == null) {
                                            }
                                            return zzahfVar;
                                        }
                                    } else {
                                        i6 = 71;
                                    }
                                }
                                if (i != 2) {
                                }
                            } catch (Exception e3) {
                                e = e3;
                                zzenVar.zzL(zzc);
                                zzahfVar = null;
                                if (zzahfVar == null) {
                                }
                                return zzahfVar;
                            } catch (OutOfMemoryError e4) {
                                e = e4;
                                zzenVar.zzL(zzc);
                                zzahfVar = null;
                                if (zzahfVar == null) {
                                }
                                return zzahfVar;
                            }
                            str = "Id3Decoder";
                        } catch (Exception e5) {
                            e = e5;
                        } catch (OutOfMemoryError e6) {
                            e = e6;
                        }
                    }
                    i5 = zzm;
                    str = "Id3Decoder";
                    zzenVar.zzL(zzc);
                    zzahfVar = zzagxVar;
                    e = null;
                }
            } catch (Throwable th) {
                zzenVar.zzL(zzc);
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            i5 = zzm;
            str = "Id3Decoder";
            zzenVar.zzL(zzc);
            zzahfVar = null;
            if (zzahfVar == null) {
            }
            return zzahfVar;
        } catch (OutOfMemoryError e8) {
            e = e8;
            i5 = zzm;
            str = "Id3Decoder";
            zzenVar.zzL(zzc);
            zzahfVar = null;
            if (zzahfVar == null) {
            }
            return zzahfVar;
        }
        if (zzahfVar == null) {
            zzea.zzg(str, "Failed to decode frame: id=" + zzh(i, i5, zzm2, zzm3, zzm4) + ", frameSize=" + zzp, e);
        }
        return zzahfVar;
    }

    private static Charset zzi(int i) {
        return i != 1 ? i != 2 ? i != 3 ? StandardCharsets.ISO_8859_1 : StandardCharsets.UTF_8 : StandardCharsets.UTF_16BE : StandardCharsets.UTF_16;
    }
}
