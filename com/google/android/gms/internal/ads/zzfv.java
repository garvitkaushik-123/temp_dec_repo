package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfv {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzdd.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzi(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzi(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzi(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    zzi(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static int zzb(zzz zzzVar) {
        String str = zzzVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            return 1;
        }
        return (Objects.equals(str, "video/hevc") || zzay.zzg(zzzVar.zzk, "video/hevc")) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzfp zzd(byte[] bArr, int i, int i2, zzfs zzfsVar) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int zzc2;
        int i7;
        int i8;
        int i9;
        int i10;
        int zzc3;
        int i11;
        int i12;
        int i13;
        int i14;
        int zzc4;
        int i15;
        float f;
        zzfk zzfkVar;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        zzfr zzfrVar;
        int i26;
        int i27;
        zzfj zzfjVar;
        int i28;
        int i29;
        int i30;
        zzfn zzfnVar;
        zzfj zzm = zzm(new zzfw(bArr, i, i2));
        zzfw zzfwVar = new zzfw(bArr, i + 2, i2);
        zzfwVar.zzf(4);
        int zza2 = zzfwVar.zza(3);
        int i31 = zzm.zzb;
        if (i31 == 0 || zza2 != 7) {
            z = false;
        } else {
            zza2 = 7;
            z = true;
        }
        if (zzfsVar != null) {
            zzfyq zzfyqVar = zzfsVar.zza;
            if (!zzfyqVar.isEmpty()) {
                i3 = ((zzfi) zzfyqVar.get(Math.min(i31, zzfyqVar.size() - 1))).zza;
                zzfk zzfkVar2 = null;
                if (z) {
                    zzfwVar.zze();
                    zzfkVar2 = zzn(zzfwVar, true, zza2, null);
                } else if (zzfsVar != null) {
                    zzfl zzflVar = zzfsVar.zzb;
                    int i32 = zzflVar.zzb[i3];
                    zzfyq zzfyqVar2 = zzflVar.zza;
                    if (zzfyqVar2.size() > i32) {
                        zzfkVar2 = (zzfk) zzfyqVar2.get(i32);
                    }
                }
                int zzc5 = zzfwVar.zzc();
                if (z) {
                    int zzc6 = zzfwVar.zzc();
                    if (zzc6 == 3) {
                        zzfwVar.zze();
                        i4 = 3;
                    } else {
                        i4 = zzc6;
                    }
                    int zzc7 = zzfwVar.zzc();
                    int zzc8 = zzfwVar.zzc();
                    if (zzfwVar.zzh()) {
                        int zzc9 = zzfwVar.zzc();
                        int zzc10 = zzfwVar.zzc();
                        int zzc11 = zzfwVar.zzc();
                        int zzc12 = zzfwVar.zzc();
                        i6 = zzl(zzc7, i4, zzc9, zzc10);
                        i5 = zzk(zzc8, i4, zzc11, zzc12);
                    } else {
                        i5 = zzc8;
                        i6 = zzc7;
                    }
                    zzc2 = zzfwVar.zzc();
                    i7 = i5;
                    i8 = zzc8;
                    i9 = i6;
                    i10 = zzc7;
                    zzc3 = zzfwVar.zzc();
                    i11 = zzc6;
                } else {
                    int zza3 = zzfwVar.zzh() ? zzfwVar.zza(8) : -1;
                    if (zzfsVar != null && (zzfnVar = zzfsVar.zzc) != null) {
                        if (zza3 == -1) {
                            zza3 = zzfnVar.zzb[i3];
                        }
                        if (zza3 != -1) {
                            zzfyq zzfyqVar3 = zzfnVar.zza;
                            if (zzfyqVar3.size() > zza3) {
                                zzfm zzfmVar = (zzfm) zzfyqVar3.get(zza3);
                                int i33 = zzfmVar.zza;
                                i9 = zzfmVar.zzd;
                                i7 = zzfmVar.zze;
                                zzc2 = zzfmVar.zzb;
                                zzc3 = zzfmVar.zzc;
                                i11 = i33;
                                i8 = i7;
                                i10 = i9;
                            }
                        }
                    }
                    i8 = 0;
                    i10 = 0;
                    zzc2 = 0;
                    i11 = 0;
                    zzc3 = 0;
                    i7 = 0;
                    i9 = 0;
                }
                int zzc13 = zzfwVar.zzc();
                if (z) {
                    i12 = i8;
                    i13 = i10;
                    i14 = -1;
                    for (int i34 = true != zzfwVar.zzh() ? zza2 : 0; i34 <= zza2; i34++) {
                        zzfwVar.zzc();
                        i14 = Math.max(zzfwVar.zzc(), i14);
                        zzfwVar.zzc();
                    }
                } else {
                    i12 = i8;
                    i13 = i10;
                    i14 = -1;
                }
                zzfwVar.zzc();
                zzfwVar.zzc();
                zzfwVar.zzc();
                zzfwVar.zzc();
                zzfwVar.zzc();
                zzfwVar.zzc();
                if (zzfwVar.zzh()) {
                    if (z && zzfwVar.zzh()) {
                        zzfwVar.zzf(6);
                    } else if (zzfwVar.zzh()) {
                        int i35 = 4;
                        int i36 = 0;
                        while (i36 < i35) {
                            int i37 = i35;
                            int i38 = i14;
                            for (int i39 = 0; i39 < 6; i39 = i30 + (i36 == 3 ? 3 : 1)) {
                                if (zzfwVar.zzh()) {
                                    i30 = i39;
                                    int min = Math.min(64, 1 << ((i36 + i36) + 4));
                                    if (i36 > 1) {
                                        zzfwVar.zzb();
                                    }
                                    for (int i40 = 0; i40 < min; i40++) {
                                        zzfwVar.zzb();
                                    }
                                } else {
                                    zzfwVar.zzc();
                                    i30 = i39;
                                }
                            }
                            i36++;
                            i14 = i38;
                            i35 = i37;
                        }
                    }
                }
                int i41 = i14;
                zzfwVar.zzf(2);
                if (zzfwVar.zzh()) {
                    zzfwVar.zzf(8);
                    zzfwVar.zzc();
                    zzfwVar.zzc();
                    zzfwVar.zze();
                }
                zzc4 = zzfwVar.zzc();
                i15 = 0;
                int[] iArr = new int[0];
                int i42 = zza2;
                int[] iArr2 = new int[0];
                int i43 = zzc2;
                int i44 = -1;
                int i45 = -1;
                while (i15 < zzc4) {
                    if (i15 == 0 || !zzfwVar.zzh()) {
                        i26 = zzc4;
                        i27 = i15;
                        zzfjVar = zzm;
                        i28 = i3;
                        int zzc14 = zzfwVar.zzc();
                        int zzc15 = zzfwVar.zzc();
                        int[] iArr3 = new int[zzc14];
                        int i46 = 0;
                        while (i46 < zzc14) {
                            iArr3[i46] = (i46 > 0 ? iArr3[i46 - 1] : 0) - (zzfwVar.zzc() + 1);
                            zzfwVar.zze();
                            i46++;
                        }
                        int[] iArr4 = new int[zzc15];
                        int i47 = 0;
                        while (i47 < zzc15) {
                            iArr4[i47] = (i47 > 0 ? iArr4[i47 - 1] : 0) + zzfwVar.zzc() + 1;
                            zzfwVar.zze();
                            i47++;
                        }
                        iArr = iArr3;
                        iArr2 = iArr4;
                        i44 = zzc14;
                        i45 = zzc15;
                    } else {
                        i26 = zzc4;
                        int i48 = i44 + i45;
                        boolean zzh = zzfwVar.zzh();
                        boolean z2 = true;
                        int zzc16 = zzfwVar.zzc() + 1;
                        int i49 = 1 - ((zzh ? 1 : 0) + (zzh ? 1 : 0));
                        i27 = i15;
                        int i50 = i48 + 1;
                        zzfjVar = zzm;
                        boolean[] zArr = new boolean[i50];
                        int i51 = 0;
                        while (i51 <= i48) {
                            if (zzfwVar.zzh()) {
                                zArr[i51] = z2;
                            } else {
                                zArr[i51] = zzfwVar.zzh();
                            }
                            i51++;
                            z2 = true;
                        }
                        int i52 = i45 - 1;
                        int[] iArr5 = new int[i50];
                        int[] iArr6 = new int[i50];
                        int i53 = 0;
                        while (true) {
                            i29 = i49 * zzc16;
                            if (i52 < 0) {
                                break;
                            }
                            int i54 = iArr2[i52] + i29;
                            if (i54 < 0 && zArr[i44 + i52]) {
                                iArr5[i53] = i54;
                                i53++;
                            }
                            i52--;
                        }
                        if (i29 < 0 && zArr[i48]) {
                            iArr5[i53] = i29;
                            i53++;
                        }
                        i28 = i3;
                        int i55 = i53;
                        for (int i56 = 0; i56 < i44; i56++) {
                            int i57 = iArr[i56] + i29;
                            if (i57 < 0 && zArr[i56]) {
                                iArr5[i55] = i57;
                                i55++;
                            }
                        }
                        int[] copyOf = Arrays.copyOf(iArr5, i55);
                        int i58 = 0;
                        for (int i59 = i44 - 1; i59 >= 0; i59--) {
                            int i60 = iArr[i59] + i29;
                            if (i60 > 0 && zArr[i59]) {
                                iArr6[i58] = i60;
                                i58++;
                            }
                        }
                        if (i29 > 0 && zArr[i48]) {
                            iArr6[i58] = i29;
                            i58++;
                        }
                        int i61 = i58;
                        for (int i62 = 0; i62 < i45; i62++) {
                            int i63 = iArr2[i62] + i29;
                            if (i63 > 0 && zArr[i44 + i62]) {
                                iArr6[i61] = i63;
                                i61++;
                            }
                        }
                        iArr = copyOf;
                        iArr2 = Arrays.copyOf(iArr6, i61);
                        i44 = i55;
                        i45 = i61;
                    }
                    i15 = i27 + 1;
                    zzc4 = i26;
                    i3 = i28;
                    zzm = zzfjVar;
                }
                zzfj zzfjVar2 = zzm;
                int i64 = i3;
                if (zzfwVar.zzh()) {
                    int zzc17 = zzfwVar.zzc();
                    for (int i65 = 0; i65 < zzc17; i65++) {
                        zzfwVar.zzf(zzc13 + 5);
                    }
                }
                zzfwVar.zzf(2);
                float f2 = 1.0f;
                if (zzfwVar.zzh()) {
                    f = 1.0f;
                    zzfkVar = zzfkVar2;
                    i16 = zzc5;
                    i17 = i9;
                    i18 = i12;
                    i19 = i13;
                    i20 = -1;
                    i21 = -1;
                    i22 = -1;
                } else {
                    if (zzfwVar.zzh()) {
                        int zza4 = zzfwVar.zza(8);
                        if (zza4 == 255) {
                            int zza5 = zzfwVar.zza(16);
                            int zza6 = zzfwVar.zza(16);
                            if (zza5 != 0 && zza6 != 0) {
                                f2 = zza5 / zza6;
                            }
                        } else if (zza4 < 17) {
                            f2 = zzb[zza4];
                        } else {
                            zzea.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + zza4);
                        }
                    }
                    if (zzfwVar.zzh()) {
                        zzfwVar.zze();
                    }
                    if (zzfwVar.zzh()) {
                        zzfwVar.zzf(3);
                        i25 = true != zzfwVar.zzh() ? 2 : 1;
                        if (zzfwVar.zzh()) {
                            int zza7 = zzfwVar.zza(8);
                            int zza8 = zzfwVar.zza(8);
                            zzfwVar.zzf(8);
                            i23 = zzk.zza(zza7);
                            i24 = zzk.zzb(zza8);
                        } else {
                            i23 = -1;
                            i24 = -1;
                        }
                    } else {
                        if (zzfsVar != null && (zzfrVar = zzfsVar.zzd) != null) {
                            int i66 = zzfrVar.zzb[i64];
                            zzfyq zzfyqVar4 = zzfrVar.zza;
                            if (zzfyqVar4.size() > i66) {
                                zzfq zzfqVar = (zzfq) zzfyqVar4.get(i66);
                                int i67 = zzfqVar.zza;
                                int i68 = zzfqVar.zzb;
                                i24 = zzfqVar.zzc;
                                i23 = i67;
                                i25 = i68;
                            }
                        }
                        i23 = -1;
                        i24 = -1;
                        i25 = -1;
                    }
                    if (zzfwVar.zzh()) {
                        zzfwVar.zzc();
                        zzfwVar.zzc();
                    }
                    zzfwVar.zze();
                    if (zzfwVar.zzh()) {
                        i7 += i7;
                    }
                    i20 = i23;
                    f = f2;
                    zzfkVar = zzfkVar2;
                    i16 = zzc5;
                    i17 = i9;
                    i18 = i12;
                    i19 = i13;
                    i22 = i24;
                    i21 = i25;
                }
                return new zzfp(zzfjVar2, i42, zzfkVar, i11, i43, zzc3, i16, i17, i7, i19, i18, f, i41, i20, i21, i22);
            }
        }
        i3 = 0;
        zzfk zzfkVar22 = null;
        if (z) {
        }
        int zzc52 = zzfwVar.zzc();
        if (z) {
        }
        int zzc132 = zzfwVar.zzc();
        if (z) {
        }
        zzfwVar.zzc();
        zzfwVar.zzc();
        zzfwVar.zzc();
        zzfwVar.zzc();
        zzfwVar.zzc();
        zzfwVar.zzc();
        if (zzfwVar.zzh()) {
        }
        int i412 = i14;
        zzfwVar.zzf(2);
        if (zzfwVar.zzh()) {
        }
        zzc4 = zzfwVar.zzc();
        i15 = 0;
        int[] iArr7 = new int[0];
        int i422 = zza2;
        int[] iArr22 = new int[0];
        int i432 = zzc2;
        int i442 = -1;
        int i452 = -1;
        while (i15 < zzc4) {
        }
        zzfj zzfjVar22 = zzm;
        int i642 = i3;
        if (zzfwVar.zzh()) {
        }
        zzfwVar.zzf(2);
        float f22 = 1.0f;
        if (zzfwVar.zzh()) {
        }
        return new zzfp(zzfjVar22, i422, zzfkVar, i11, i432, zzc3, i16, i17, i7, i19, i18, f, i412, i20, i21, i22);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzfs zze(byte[] bArr, int i, int i2) {
        int i3;
        int[] iArr;
        zzfr zzfrVar;
        boolean z;
        int i4;
        boolean[][] zArr;
        int i5;
        int i6;
        int i7;
        zzfyq zzfyqVar;
        int i8;
        boolean[][] zArr2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr2;
        int[] iArr3;
        int i14;
        int i15;
        boolean zzh;
        int i16;
        int i17;
        int i18;
        int i19;
        int zzc2;
        int i20;
        int i21;
        boolean z2;
        boolean z3;
        zzfw zzfwVar = new zzfw(bArr, i, i2);
        zzfj zzm = zzm(zzfwVar);
        zzfwVar.zzf(4);
        boolean zzh2 = zzfwVar.zzh();
        boolean zzh3 = zzfwVar.zzh();
        int zza2 = zzfwVar.zza(6);
        int i22 = zza2 + 1;
        int zza3 = zzfwVar.zza(3);
        zzfwVar.zzf(17);
        zzfk zzn = zzn(zzfwVar, true, zza3, null);
        int i23 = 0;
        for (int i24 = true != zzfwVar.zzh() ? zza3 : 0; i24 <= zza3; i24++) {
            zzfwVar.zzc();
            zzfwVar.zzc();
            zzfwVar.zzc();
        }
        int zza4 = zzfwVar.zza(6);
        int zzc3 = zzfwVar.zzc() + 1;
        int i25 = 6;
        zzfl zzflVar = new zzfl(zzfyq.zzo(zzn), new int[1]);
        boolean z4 = i22 >= 2 && zzc3 >= 2;
        boolean z5 = zzh2 && zzh3;
        int i26 = 1;
        int i27 = zza4 + 1;
        if (!z4 || !z5 || i27 < i22) {
            return new zzfs(zzm, null, zzflVar, null, null);
        }
        int[][] iArr4 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, zzc3, i27);
        int[] iArr5 = new int[zzc3];
        int[] iArr6 = new int[zzc3];
        iArr4[0][0] = 0;
        iArr5[0] = 1;
        iArr6[0] = 0;
        int i28 = 1;
        while (i28 < zzc3) {
            int i29 = i23;
            while (i23 <= zza4) {
                if (zzfwVar.zzh()) {
                    iArr4[i28][i29] = i23;
                    iArr6[i28] = i23;
                    i29++;
                }
                iArr5[i28] = i29;
                i23++;
            }
            i28++;
            i23 = 0;
        }
        if (zzfwVar.zzh()) {
            zzfwVar.zzf(64);
            if (zzfwVar.zzh()) {
                zzfwVar.zzc();
            }
            int zzc4 = zzfwVar.zzc();
            int i30 = 0;
            while (i30 < zzc4) {
                zzfwVar.zzc();
                if (i30 == 0 || zzfwVar.zzh()) {
                    boolean zzh4 = zzfwVar.zzh();
                    boolean zzh5 = zzfwVar.zzh();
                    z3 = zzh4;
                    z2 = zzh5;
                    if (zzh4 || zzh5) {
                        zzh = zzfwVar.zzh();
                        if (zzh) {
                            zzfwVar.zzf(19);
                        }
                        zzfwVar.zzf(8);
                        if (zzh) {
                            zzfwVar.zzf(4);
                        }
                        zzfwVar.zzf(15);
                        i17 = zzh4;
                        i16 = zzh5;
                        i18 = 0;
                        while (i18 <= zza3) {
                            if (zzfwVar.zzh() || zzfwVar.zzh()) {
                                zzfwVar.zzc();
                            } else if (zzfwVar.zzh()) {
                                i19 = i30;
                                zzc2 = 0;
                                zzfj zzfjVar = zzm;
                                i20 = i17 + i16;
                                int[][] iArr7 = iArr4;
                                i21 = 0;
                                while (i21 < i20) {
                                    int i31 = i20;
                                    for (int i32 = 0; i32 <= zzc2; i32++) {
                                        zzfwVar.zzc();
                                        zzfwVar.zzc();
                                        if (zzh) {
                                            zzfwVar.zzc();
                                            zzfwVar.zzc();
                                        }
                                        zzfwVar.zze();
                                    }
                                    i21++;
                                    i20 = i31;
                                }
                                i18++;
                                zzm = zzfjVar;
                                i30 = i19;
                                iArr4 = iArr7;
                            }
                            i19 = i30;
                            zzc2 = zzfwVar.zzc();
                            zzfj zzfjVar2 = zzm;
                            i20 = i17 + i16;
                            int[][] iArr72 = iArr4;
                            i21 = 0;
                            while (i21 < i20) {
                            }
                            i18++;
                            zzm = zzfjVar2;
                            i30 = i19;
                            iArr4 = iArr72;
                        }
                        i30++;
                    }
                } else {
                    z3 = false;
                    z2 = false;
                }
                zzh = false;
                i17 = z3;
                i16 = z2;
                i18 = 0;
                while (i18 <= zza3) {
                }
                i30++;
            }
        }
        zzfj zzfjVar3 = zzm;
        int[][] iArr8 = iArr4;
        if (!zzfwVar.zzh()) {
            return new zzfs(zzfjVar3, null, zzflVar, null, null);
        }
        zzfwVar.zzd();
        zzfk zzn2 = zzn(zzfwVar, false, zza3, zzn);
        boolean zzh6 = zzfwVar.zzh();
        boolean[] zArr3 = new boolean[16];
        int i33 = 0;
        for (int i34 = 0; i34 < 16; i34++) {
            boolean zzh7 = zzfwVar.zzh();
            zArr3[i34] = zzh7;
            if (zzh7) {
                i33++;
            }
        }
        if (i33 == 0 || !zArr3[1]) {
            return new zzfs(zzfjVar3, null, zzflVar, null, null);
        }
        int i35 = i33 + 1;
        int[] iArr9 = new int[i33];
        for (int i36 = 0; i36 < i33 - (zzh6 ? 1 : 0); i36++) {
            iArr9[i36] = zzfwVar.zza(3);
        }
        int[] iArr10 = new int[i35];
        if (zzh6) {
            for (int i37 = 1; i37 < i33; i37++) {
                for (int i38 = 0; i38 < i37; i38++) {
                    iArr10[i37] = iArr10[i37] + iArr9[i38] + 1;
                }
            }
            iArr10[i33] = 6;
        }
        int[][] iArr11 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i22, i33);
        int[] iArr12 = new int[i22];
        iArr12[0] = 0;
        boolean zzh8 = zzfwVar.zzh();
        int i39 = 1;
        while (i39 < i22) {
            if (zzh8) {
                iArr12[i39] = zzfwVar.zza(i25);
            } else {
                iArr12[i39] = i39;
            }
            if (zzh6) {
                i15 = i39;
                for (int i40 = 0; i40 < i33; i40++) {
                    iArr11[i15][i40] = (iArr12[i15] & ((1 << iArr10[r32]) - 1)) >> iArr10[i40];
                }
            } else {
                int i41 = 0;
                while (i41 < i33) {
                    iArr11[i39][i41] = zzfwVar.zza(iArr9[i41] + 1);
                    i41++;
                    i39 = i39;
                }
                i15 = i39;
            }
            i39 = i15 + 1;
            i25 = 6;
        }
        int[] iArr13 = new int[i27];
        int i42 = 1;
        int i43 = 0;
        while (i43 < i22) {
            iArr13[iArr12[i43]] = -1;
            int[] iArr14 = iArr13;
            int i44 = 0;
            int i45 = 0;
            while (i44 < 16) {
                if (zArr3[i44]) {
                    i14 = i26;
                    if (i44 == i14) {
                        iArr14[iArr12[i43]] = iArr11[i43][i45];
                        i44 = i14;
                    }
                    i45++;
                } else {
                    i14 = i26;
                }
                i44 += i14;
                i26 = i14;
            }
            if (i43 > 0) {
                int i46 = 0;
                while (true) {
                    if (i46 >= i43) {
                        i42++;
                        break;
                    }
                    int i47 = i46;
                    if (iArr14[iArr12[i43]] == iArr14[iArr12[i46]]) {
                        break;
                    }
                    i46 = i47 + 1;
                }
            }
            i43++;
            iArr13 = iArr14;
            i26 = 1;
        }
        int[] iArr15 = iArr13;
        int zza5 = zzfwVar.zza(4);
        if (i42 < 2 || zza5 == 0) {
            return new zzfs(zzfjVar3, null, zzflVar, null, null);
        }
        int[] iArr16 = new int[i42];
        for (int i48 = 0; i48 < i42; i48++) {
            iArr16[i48] = zzfwVar.zza(zza5);
        }
        int[] iArr17 = new int[i27];
        for (int i49 = 0; i49 < i22; i49++) {
            iArr17[Math.min(iArr12[i49], zza4)] = i49;
        }
        zzfyn zzfynVar = new zzfyn();
        int i50 = 0;
        while (i50 <= zza4) {
            int[] iArr18 = iArr16;
            int i51 = i42;
            int min = Math.min(iArr15[i50], i51 - 1);
            int[] iArr19 = iArr17;
            zzfynVar.zzf(new zzfi(iArr19[i50], min >= 0 ? iArr18[min] : -1));
            i50++;
            i42 = i51;
            iArr16 = iArr18;
            iArr17 = iArr19;
        }
        zzfyq zzi = zzfynVar.zzi();
        if (((zzfi) zzi.get(0)).zzb == -1) {
            return new zzfs(zzfjVar3, null, zzflVar, null, null);
        }
        zzfl zzflVar2 = zzflVar;
        int i52 = 1;
        while (true) {
            zzfj zzfjVar4 = zzfjVar3;
            if (i52 > zza4) {
                zzfjVar3 = zzfjVar4;
                i3 = -1;
                i52 = -1;
                break;
            }
            zzfjVar3 = zzfjVar4;
            i3 = -1;
            if (((zzfi) zzi.get(i52)).zzb != -1) {
                break;
            }
            i52++;
        }
        if (i52 == i3) {
            return new zzfs(zzfjVar3, null, zzflVar2, null, null);
        }
        boolean[][] zArr4 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i22, i22);
        boolean[][] zArr5 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i22, i22);
        int i53 = 1;
        while (i53 < i22) {
            boolean[][] zArr6 = zArr5;
            for (int i54 = 0; i54 < i53; i54++) {
                boolean[] zArr7 = zArr4[i53];
                boolean[] zArr8 = zArr6[i53];
                boolean zzh9 = zzfwVar.zzh();
                zArr8[i54] = zzh9;
                zArr7[i54] = zzh9;
            }
            i53++;
            zArr5 = zArr6;
        }
        boolean[][] zArr9 = zArr5;
        for (int i55 = 1; i55 < i22; i55++) {
            int i56 = 0;
            while (i56 < zza2) {
                zzfl zzflVar3 = zzflVar2;
                int i57 = 0;
                while (true) {
                    if (i57 < i55) {
                        boolean[] zArr10 = zArr9[i55];
                        if (zArr10[i57] && zArr9[i57][i56]) {
                            zArr10[i56] = true;
                            break;
                        }
                        i57++;
                    }
                }
                i56++;
                zzflVar2 = zzflVar3;
            }
        }
        zzfl zzflVar4 = zzflVar2;
        int[] iArr20 = new int[i27];
        for (int i58 = 0; i58 < i22; i58++) {
            int i59 = 0;
            for (int i60 = 0; i60 < i58; i60++) {
                i59 += zArr4[i58][i60] ? 1 : 0;
            }
            iArr20[iArr12[i58]] = i59;
        }
        int i61 = 0;
        for (int i62 = 0; i62 < i22; i62++) {
            if (iArr20[iArr12[i62]] == 0) {
                i61++;
            }
        }
        if (i61 > 1) {
            return new zzfs(zzfjVar3, null, zzflVar4, null, null);
        }
        zzfl zzflVar5 = zzflVar4;
        int[] iArr21 = new int[i22];
        int[] iArr22 = new int[zzc3];
        if (zzfwVar.zzh()) {
            iArr = iArr22;
            int i63 = 0;
            while (i63 < i22) {
                int i64 = i63;
                iArr21[i64] = zzfwVar.zza(3);
                i63 = i64 + 1;
            }
        } else {
            iArr = iArr22;
            Arrays.fill(iArr21, 0, i22, zza3);
        }
        int i65 = 0;
        while (i65 < zzc3) {
            int i66 = i65;
            zzfl zzflVar6 = zzflVar5;
            int[] iArr23 = iArr12;
            int i67 = 0;
            for (int i68 = 0; i68 < iArr5[i66]; i68++) {
                i67 = Math.max(i67, iArr21[((zzfi) zzi.get(iArr8[i66][i68])).zza]);
            }
            iArr[i66] = i67 + 1;
            i65 = i66 + 1;
            zzflVar5 = zzflVar6;
            iArr12 = iArr23;
        }
        zzfl zzflVar7 = zzflVar5;
        int[] iArr24 = iArr12;
        if (zzfwVar.zzh()) {
            int i69 = 0;
            while (i69 < zza2) {
                int i70 = i69 + 1;
                for (int i71 = i70; i71 < i22; i71++) {
                    if (zArr4[i71][i69]) {
                        zzfwVar.zzf(3);
                    }
                }
                i69 = i70;
            }
        }
        zzfwVar.zze();
        int zzc5 = zzfwVar.zzc() + 1;
        zzfyn zzfynVar2 = new zzfyn();
        zzfynVar2.zzf(zzn);
        if (zzc5 > 1) {
            zzfynVar2.zzf(zzn2);
            for (int i72 = 2; i72 < zzc5; i72++) {
                zzn2 = zzn(zzfwVar, zzfwVar.zzh(), zza3, zzn2);
                zzfynVar2.zzf(zzn2);
            }
        }
        zzfyq zzi2 = zzfynVar2.zzi();
        int zzc6 = zzfwVar.zzc() + zzc3;
        if (zzc6 > zzc3) {
            return new zzfs(zzfjVar3, null, zzflVar7, null, null);
        }
        int zza6 = zzfwVar.zza(2);
        int i73 = 0;
        boolean[][] zArr11 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, zzc6, i27);
        int[] iArr25 = new int[zzc6];
        int[] iArr26 = new int[zzc6];
        int i74 = 0;
        while (i73 < zzc3) {
            iArr25[i73] = i74;
            boolean[][] zArr12 = zArr11;
            int i75 = iArr6[i73];
            iArr26[i73] = i75;
            if (zza6 == 0) {
                i13 = i73;
                iArr2 = iArr5;
                iArr3 = iArr25;
                Arrays.fill(zArr12[i73], i74, iArr5[i13], true);
                iArr3[i13] = iArr2[i13];
            } else {
                i13 = i73;
                iArr2 = iArr5;
                iArr3 = iArr25;
                if (zza6 == 1) {
                    for (int i76 = 0; i76 < iArr2[i13]; i76++) {
                        zArr12[i13][i76] = iArr8[i13][i76] == i75;
                    }
                    iArr3[i13] = 1;
                } else {
                    i74 = 0;
                    zArr12[0][0] = true;
                    iArr3[0] = 1;
                    i73 = i13 + 1;
                    zArr11 = zArr12;
                    iArr5 = iArr2;
                    iArr25 = iArr3;
                }
            }
            i74 = 0;
            i73 = i13 + 1;
            zArr11 = zArr12;
            iArr5 = iArr2;
            iArr25 = iArr3;
        }
        boolean[][] zArr13 = zArr11;
        int[] iArr27 = iArr5;
        int[] iArr28 = iArr25;
        int[] iArr29 = new int[i27];
        int i77 = 2;
        int[] iArr30 = new int[2];
        iArr30[1] = i27;
        iArr30[i74] = zzc6;
        boolean[][] zArr14 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iArr30);
        int i78 = 1;
        int i79 = 0;
        while (i78 < zzc6) {
            int i80 = zza6;
            if (zza6 == i77) {
                for (int i81 = 0; i81 < iArr27[i78]; i81++) {
                    zArr13[i78][i81] = zzfwVar.zzh();
                    int i82 = iArr28[i78];
                    boolean z6 = zArr13[i78][i81];
                    iArr28[i78] = i82 + (z6 ? 1 : 0);
                    if (z6) {
                        iArr26[i78] = iArr8[i78][i81];
                    }
                }
            }
            if (i79 == 0) {
                i9 = 0;
                if (iArr8[i78][0] == 0 && zArr13[i78][0]) {
                    int i83 = 0;
                    for (int i84 = 1; i84 < iArr27[i78]; i84++) {
                        if (iArr8[i78][i84] == i52 && zArr13[i78][i52]) {
                            i83 = i78;
                        }
                    }
                    i79 = i83;
                } else {
                    i79 = 0;
                }
            } else {
                i9 = 0;
            }
            int i85 = i9;
            while (i85 < iArr27[i78]) {
                if (zzc5 > 1) {
                    zArr14[i78][i85] = zArr13[i78][i85];
                    i12 = i52;
                    i10 = zzc5;
                    int zza7 = zzgbj.zza(zzc5, RoundingMode.CEILING);
                    if (!zArr14[i78][i85]) {
                        int i86 = ((zzfi) zzi.get(iArr8[i78][i85])).zza;
                        int i87 = i9;
                        while (i87 < i85) {
                            i11 = i85;
                            if (zArr9[i86][((zzfi) zzi.get(iArr8[i78][i87])).zza]) {
                                zArr14[i78][i11] = true;
                                break;
                            }
                            i87++;
                            i85 = i11;
                        }
                    }
                    i11 = i85;
                    if (zArr14[i78][i11]) {
                        if (i79 <= 0 || i78 != i79) {
                            zzfwVar.zzf(zza7);
                        } else {
                            iArr29[i11] = zzfwVar.zza(zza7);
                        }
                    }
                } else {
                    i10 = zzc5;
                    i11 = i85;
                    i12 = i52;
                }
                i85 = i11 + 1;
                i52 = i12;
                zzc5 = i10;
            }
            int i88 = zzc5;
            int i89 = i52;
            if (iArr28[i78] == 1 && iArr20[iArr26[i78]] > 0) {
                zzfwVar.zze();
            }
            i78++;
            zza6 = i80;
            i52 = i89;
            zzc5 = i88;
            i77 = 2;
        }
        if (i79 == 0) {
            return new zzfs(zzfjVar3, null, zzflVar7, null, null);
        }
        zzfj zzfjVar5 = zzfjVar3;
        int zzc7 = zzfwVar.zzc();
        int i90 = zzc7 + 1;
        zzfyn zzi3 = zzfyq.zzi(i90);
        int[] iArr31 = new int[i22];
        int i91 = 0;
        while (i91 < i90) {
            zzfyq zzfyqVar2 = zzi;
            int zza8 = zzfwVar.zza(16);
            zzfj zzfjVar6 = zzfjVar5;
            int zza9 = zzfwVar.zza(16);
            if (zzfwVar.zzh()) {
                zArr = zArr14;
                i5 = zzfwVar.zza(2);
                if (i5 == 3) {
                    zzfwVar.zze();
                }
                i6 = zzfwVar.zza(4);
                i7 = zzfwVar.zza(4);
            } else {
                zArr = zArr14;
                i5 = 0;
                i6 = 0;
                i7 = 0;
            }
            if (zzfwVar.zzh()) {
                int zzc8 = zzfwVar.zzc();
                i8 = i91;
                int zzc9 = zzfwVar.zzc();
                zArr2 = zArr4;
                int zzc10 = zzfwVar.zzc();
                zzfyqVar = zzi2;
                int zzc11 = zzfwVar.zzc();
                zza8 = zzl(zza8, i5, zzc8, zzc9);
                zza9 = zzk(zza9, i5, zzc10, zzc11);
            } else {
                zzfyqVar = zzi2;
                i8 = i91;
                zArr2 = zArr4;
            }
            zzi3.zzf(new zzfm(i5, i6, i7, zza8, zza9));
            i91 = i8 + 1;
            zzi = zzfyqVar2;
            zzfjVar5 = zzfjVar6;
            zArr14 = zArr;
            zArr4 = zArr2;
            zzi2 = zzfyqVar;
        }
        zzfyq zzfyqVar3 = zzi;
        zzfj zzfjVar7 = zzfjVar5;
        zzfyq zzfyqVar4 = zzi2;
        boolean[][] zArr15 = zArr14;
        boolean[][] zArr16 = zArr4;
        if (i90 <= 1 || !zzfwVar.zzh()) {
            for (int i92 = 1; i92 < i22; i92++) {
                iArr31[i92] = Math.min(i92, zzc7);
            }
        } else {
            int zza10 = zzgbj.zza(i90, RoundingMode.CEILING);
            for (int i93 = 1; i93 < i22; i93++) {
                iArr31[i93] = zzfwVar.zza(zza10);
            }
        }
        zzfn zzfnVar = new zzfn(zzi3.zzi(), iArr31);
        zzfwVar.zzf(2);
        for (int i94 = 1; i94 < i22; i94++) {
            if (iArr20[iArr24[i94]] == 0) {
                zzfwVar.zze();
            }
        }
        for (int i95 = 1; i95 < zzc6; i95++) {
            boolean zzh10 = zzfwVar.zzh();
            int i96 = 0;
            while (i96 < iArr[i95]) {
                if ((i96 <= 0 || !zzh10) ? i96 == 0 : zzfwVar.zzh()) {
                    for (int i97 = 0; i97 < iArr27[i95]; i97++) {
                        if (zArr15[i95][i97]) {
                            zzfwVar.zzc();
                        }
                    }
                    zzfwVar.zzc();
                    zzfwVar.zzc();
                }
                i96++;
            }
        }
        int zzc12 = zzfwVar.zzc() + 2;
        if (zzfwVar.zzh()) {
            zzfwVar.zzf(zzc12);
        } else {
            for (int i98 = 1; i98 < i22; i98++) {
                for (int i99 = 0; i99 < i98; i99++) {
                    if (zArr16[i98][i99]) {
                        zzfwVar.zzf(zzc12);
                    }
                }
            }
        }
        int zzc13 = zzfwVar.zzc();
        for (int i100 = 1; i100 <= zzc13; i100++) {
            zzfwVar.zzf(8);
        }
        if (zzfwVar.zzh()) {
            zzfwVar.zzd();
            if (zzfwVar.zzh() || zzfwVar.zzh()) {
                zzfwVar.zze();
            }
            boolean zzh11 = zzfwVar.zzh();
            boolean zzh12 = zzfwVar.zzh();
            if (zzh11 || zzh12) {
                for (int i101 = 0; i101 < zzc3; i101++) {
                    for (int i102 = 0; i102 < iArr[i101]; i102++) {
                        boolean zzh13 = zzh11 ? zzfwVar.zzh() : false;
                        boolean zzh14 = zzh12 ? zzfwVar.zzh() : false;
                        if (zzh13) {
                            zzfwVar.zzf(32);
                        }
                        if (zzh14) {
                            zzfwVar.zzf(18);
                        }
                    }
                }
            }
            boolean zzh15 = zzfwVar.zzh();
            if (zzh15) {
                z = true;
                i4 = zzfwVar.zza(4) + 1;
            } else {
                z = true;
                i4 = i22;
            }
            zzfyn zzi4 = zzfyq.zzi(i4);
            int[] iArr32 = new int[i22];
            int i103 = 0;
            while (i103 < i4) {
                zzfwVar.zzf(3);
                int i104 = z != zzfwVar.zzh() ? 2 : 1;
                int zza11 = zzk.zza(zzfwVar.zza(8));
                int zzb2 = zzk.zzb(zzfwVar.zza(8));
                zzfwVar.zzf(8);
                zzi4.zzf(new zzfq(zza11, i104, zzb2));
                i103++;
                z = true;
            }
            if (zzh15 && i4 > 1) {
                for (int i105 = 0; i105 < i22; i105++) {
                    iArr32[i105] = zzfwVar.zza(4);
                }
            }
            zzfrVar = new zzfr(zzi4.zzi(), iArr32);
        } else {
            zzfrVar = null;
        }
        return new zzfs(zzfjVar7, zzfyqVar3, new zzfl(zzfyqVar4, iArr29), zzfnVar, zzfrVar);
    }

    public static zzft zzf(byte[] bArr, int i, int i2) {
        zzfw zzfwVar = new zzfw(bArr, 4, i2);
        int zzc2 = zzfwVar.zzc();
        int zzc3 = zzfwVar.zzc();
        zzfwVar.zze();
        return new zzft(zzc2, zzc3, zzfwVar.zzh());
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzfu zzg(byte[] bArr, int i, int i2) {
        int zzc2;
        int i3;
        boolean z;
        int i4;
        int zzc3;
        int i5;
        int zzc4;
        int i6;
        int i7;
        boolean z2;
        boolean zzh;
        int i8;
        int i9;
        float f;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        zzfw zzfwVar = new zzfw(bArr, i, i2);
        int zza2 = zzfwVar.zza(8);
        int zza3 = zzfwVar.zza(8);
        int zza4 = zzfwVar.zza(8);
        int zzc5 = zzfwVar.zzc();
        if (zza2 != 100 && zza2 != 110 && zza2 != 122 && zza2 != 244 && zza2 != 44 && zza2 != 83 && zza2 != 86 && zza2 != 118 && zza2 != 128) {
            if (zza2 != 138) {
                zzc2 = 1;
                i4 = 16;
                i5 = 0;
                z = false;
                zzc3 = 0;
                int zzc6 = zzfwVar.zzc() + 4;
                zzc4 = zzfwVar.zzc();
                if (zzc4 != 0) {
                    i7 = zzfwVar.zzc() + 4;
                    i6 = 244;
                } else {
                    if (zzc4 == 1) {
                        boolean zzh2 = zzfwVar.zzh();
                        zzfwVar.zzb();
                        zzfwVar.zzb();
                        long zzc7 = zzfwVar.zzc();
                        for (int i15 = 0; i15 < zzc7; i15++) {
                            zzfwVar.zzc();
                        }
                        z2 = zzh2;
                        zzc4 = 1;
                        i6 = 244;
                        i7 = 0;
                        int zzc8 = zzfwVar.zzc();
                        zzfwVar.zze();
                        int zzc9 = zzfwVar.zzc() + 1;
                        int zzc10 = zzfwVar.zzc() + 1;
                        zzh = zzfwVar.zzh();
                        int i16 = 2 - (zzh ? 1 : 0);
                        if (!zzh) {
                            zzfwVar.zze();
                        }
                        zzfwVar.zze();
                        int i17 = zzc9 * 16;
                        int i18 = zzc10 * i16 * 16;
                        if (zzfwVar.zzh()) {
                            int zzc11 = zzfwVar.zzc();
                            int zzc12 = zzfwVar.zzc();
                            int zzc13 = zzfwVar.zzc();
                            int zzc14 = zzfwVar.zzc();
                            if (zzc2 == 0) {
                                i14 = 1;
                            } else {
                                i14 = zzc2 == 3 ? 1 : 2;
                                i16 *= zzc2 == 1 ? 2 : 1;
                            }
                            i17 -= (zzc11 + zzc12) * i14;
                            i18 -= (zzc13 + zzc14) * i16;
                        }
                        if (zza2 != 44 && zza2 != 86 && zza2 != 100 && zza2 != 110 && zza2 != 122) {
                            if (zza2 == i6) {
                                zza2 = i6;
                            }
                            i8 = i4;
                            float f2 = 1.0f;
                            int i19 = -1;
                            if (zzfwVar.zzh()) {
                                i9 = i8;
                                f = 1.0f;
                                i10 = -1;
                                i11 = -1;
                            } else {
                                if (zzfwVar.zzh()) {
                                    int zza5 = zzfwVar.zza(8);
                                    if (zza5 == 255) {
                                        int i20 = i4;
                                        int zza6 = zzfwVar.zza(i20);
                                        int zza7 = zzfwVar.zza(i20);
                                        if (zza6 != 0 && zza7 != 0) {
                                            f2 = zza6 / zza7;
                                        }
                                    } else if (zza5 < 17) {
                                        f2 = zzb[zza5];
                                    } else {
                                        zzea.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + zza5);
                                    }
                                }
                                if (zzfwVar.zzh()) {
                                    zzfwVar.zze();
                                }
                                if (zzfwVar.zzh()) {
                                    zzfwVar.zzf(3);
                                    int i21 = true != zzfwVar.zzh() ? 2 : 1;
                                    if (zzfwVar.zzh()) {
                                        int zza8 = zzfwVar.zza(8);
                                        int zza9 = zzfwVar.zza(8);
                                        zzfwVar.zzf(8);
                                        i12 = zzk.zza(zza8);
                                        i13 = zzk.zzb(zza9);
                                    } else {
                                        i12 = -1;
                                        i13 = -1;
                                    }
                                    i19 = i21;
                                } else {
                                    i12 = -1;
                                    i13 = -1;
                                }
                                if (zzfwVar.zzh()) {
                                    zzfwVar.zzc();
                                    zzfwVar.zzc();
                                }
                                if (zzfwVar.zzh()) {
                                    zzfwVar.zzf(65);
                                }
                                boolean zzh3 = zzfwVar.zzh();
                                if (zzh3) {
                                    zzo(zzfwVar);
                                }
                                boolean zzh4 = zzfwVar.zzh();
                                if (zzh4) {
                                    zzo(zzfwVar);
                                }
                                if (zzh3 || zzh4) {
                                    zzfwVar.zze();
                                }
                                zzfwVar.zze();
                                if (zzfwVar.zzh()) {
                                    zzfwVar.zze();
                                    zzfwVar.zzc();
                                    zzfwVar.zzc();
                                    zzfwVar.zzc();
                                    zzfwVar.zzc();
                                    i8 = zzfwVar.zzc();
                                    zzfwVar.zzc();
                                }
                                i11 = i13;
                                i9 = i8;
                                f = f2;
                                i10 = i19;
                                i19 = i12;
                            }
                            return new zzfu(zza2, zza3, zza4, zzc5, zzc8, i17, i18, f, i5, zzc3, z, zzh, zzc6, zzc4, i7, z2, i19, i10, i11, i9);
                        }
                        if ((zza3 & 16) != 0) {
                            i8 = 0;
                            float f22 = 1.0f;
                            int i192 = -1;
                            if (zzfwVar.zzh()) {
                            }
                            return new zzfu(zza2, zza3, zza4, zzc5, zzc8, i17, i18, f, i5, zzc3, z, zzh, zzc6, zzc4, i7, z2, i192, i10, i11, i9);
                        }
                        i8 = i4;
                        float f222 = 1.0f;
                        int i1922 = -1;
                        if (zzfwVar.zzh()) {
                        }
                        return new zzfu(zza2, zza3, zza4, zzc5, zzc8, i17, i18, f, i5, zzc3, z, zzh, zzc6, zzc4, i7, z2, i1922, i10, i11, i9);
                    }
                    i6 = 244;
                    i7 = 0;
                }
                z2 = false;
                int zzc82 = zzfwVar.zzc();
                zzfwVar.zze();
                int zzc92 = zzfwVar.zzc() + 1;
                int zzc102 = zzfwVar.zzc() + 1;
                zzh = zzfwVar.zzh();
                int i162 = 2 - (zzh ? 1 : 0);
                if (!zzh) {
                }
                zzfwVar.zze();
                int i172 = zzc92 * 16;
                int i182 = zzc102 * i162 * 16;
                if (zzfwVar.zzh()) {
                }
                if (zza2 != 44) {
                    if (zza2 == i6) {
                    }
                    i8 = i4;
                    float f2222 = 1.0f;
                    int i19222 = -1;
                    if (zzfwVar.zzh()) {
                    }
                    return new zzfu(zza2, zza3, zza4, zzc5, zzc82, i172, i182, f, i5, zzc3, z, zzh, zzc6, zzc4, i7, z2, i19222, i10, i11, i9);
                }
                if ((zza3 & 16) != 0) {
                }
                i8 = i4;
                float f22222 = 1.0f;
                int i192222 = -1;
                if (zzfwVar.zzh()) {
                }
                return new zzfu(zza2, zza3, zza4, zzc5, zzc82, i172, i182, f, i5, zzc3, z, zzh, zzc6, zzc4, i7, z2, i192222, i10, i11, i9);
            }
            zza2 = 138;
        }
        zzc2 = zzfwVar.zzc();
        if (zzc2 == 3) {
            z = zzfwVar.zzh();
            i3 = 3;
        } else {
            i3 = zzc2;
            z = false;
        }
        i4 = 16;
        int zzc15 = zzfwVar.zzc();
        zzc3 = zzfwVar.zzc();
        zzfwVar.zze();
        if (zzfwVar.zzh()) {
            int i22 = i3 != 3 ? 8 : 12;
            int i23 = 0;
            while (i23 < i22) {
                if (zzfwVar.zzh()) {
                    int i24 = i23 < 6 ? 16 : 64;
                    int i25 = 8;
                    int i26 = 8;
                    for (int i27 = 0; i27 < i24; i27++) {
                        if (i25 != 0) {
                            i25 = ((i26 + zzfwVar.zzb()) + 256) % 256;
                        }
                        if (i25 != 0) {
                            i26 = i25;
                        }
                    }
                }
                i23++;
            }
        }
        i5 = zzc15;
        int zzc62 = zzfwVar.zzc() + 4;
        zzc4 = zzfwVar.zzc();
        if (zzc4 != 0) {
        }
        z2 = false;
        int zzc822 = zzfwVar.zzc();
        zzfwVar.zze();
        int zzc922 = zzfwVar.zzc() + 1;
        int zzc1022 = zzfwVar.zzc() + 1;
        zzh = zzfwVar.zzh();
        int i1622 = 2 - (zzh ? 1 : 0);
        if (!zzh) {
        }
        zzfwVar.zze();
        int i1722 = zzc922 * 16;
        int i1822 = zzc1022 * i1622 * 16;
        if (zzfwVar.zzh()) {
        }
        if (zza2 != 44) {
        }
        if ((zza3 & 16) != 0) {
        }
        i8 = i4;
        float f222222 = 1.0f;
        int i1922222 = -1;
        if (zzfwVar.zzh()) {
        }
        return new zzfu(zza2, zza3, zza4, zzc5, zzc822, i1722, i1822, f, i5, zzc3, z, zzh, zzc62, zzc4, i7, z2, i1922222, i10, i11, i9);
    }

    public static String zzh(List list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = (byte[]) list.get(i);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                int i2 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                int i3 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i3 >= length2) {
                        break;
                    }
                    int zza2 = zza(bArr, i3, length2, zArr);
                    if (zza2 != length2) {
                        zzfynVar.zzf(Integer.valueOf(zza2));
                    }
                    i3 = zza2 + 3;
                }
                zzfyq zzi = zzfynVar.zzi();
                for (int i4 = 0; i4 < zzi.size(); i4++) {
                    if (((Integer) zzi.get(i4)).intValue() + 3 < length) {
                        zzfw zzfwVar = new zzfw(bArr, ((Integer) zzi.get(i4)).intValue() + 3, length);
                        zzfj zzm = zzm(zzfwVar);
                        if (zzm.zza == 33 && zzm.zzb == 0) {
                            zzfwVar.zzf(4);
                            int zza3 = zzfwVar.zza(3);
                            zzfwVar.zze();
                            zzfk zzn = zzn(zzfwVar, true, zza3, null);
                            return zzdk.zzd(zzn.zza, zzn.zzb, zzn.zzc, zzn.zzd, zzn.zze, zzn.zzf);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void zzi(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean zzj(byte[] bArr, int i, int i2, zzz zzzVar) {
        String str = zzzVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            byte b = bArr[4];
            if (((b & 96) >> 5) != 0) {
                return true;
            }
            int i3 = b & Ascii.US;
            return (i3 == 1 || i3 == 9 || i3 == 14) ? false : true;
        }
        if (Objects.equals(str, "video/hevc")) {
            zzfj zzm = zzm(new zzfw(bArr, 4, i2 + 4));
            int i4 = zzm.zza;
            if (i4 == 35) {
                return false;
            }
            return (i4 <= 14 && i4 % 2 == 0 && zzm.zzc == zzzVar.zzF + (-1)) ? false : true;
        }
        return true;
    }

    private static int zzk(int i, int i2, int i3, int i4) {
        return i - ((i2 == 1 ? 2 : 1) * (i3 + i4));
    }

    private static int zzl(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (i2 != 1 && i2 != 2) {
            i5 = 1;
        }
        return i - (i5 * (i3 + i4));
    }

    private static zzfj zzm(zzfw zzfwVar) {
        zzfwVar.zze();
        return new zzfj(zzfwVar.zza(6), zzfwVar.zza(6), zzfwVar.zza(3) - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzfk zzn(zzfw zzfwVar, boolean z, int i, zzfk zzfkVar) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        int[] iArr2 = new int[6];
        if (z) {
            int zza2 = zzfwVar.zza(2);
            z3 = zzfwVar.zzh();
            i5 = zzfwVar.zza(5);
            i6 = 0;
            for (int i7 = 0; i7 < 32; i7++) {
                if (zzfwVar.zzh()) {
                    i6 |= 1 << i7;
                }
            }
            for (int i8 = 0; i8 < 6; i8++) {
                iArr2[i8] = zzfwVar.zza(8);
            }
            i2 = zza2;
        } else {
            if (zzfkVar == null) {
                iArr = iArr2;
                i2 = 0;
                z2 = false;
                i3 = 0;
                i4 = 0;
                int zza3 = zzfwVar.zza(8);
                int i9 = 0;
                for (int i10 = 0; i10 < i; i10++) {
                    if (zzfwVar.zzh()) {
                        i9 += 88;
                    }
                    if (zzfwVar.zzh()) {
                        i9 += 8;
                    }
                }
                zzfwVar.zzf(i9);
                if (i > 0) {
                    int i11 = 8 - i;
                    zzfwVar.zzf(i11 + i11);
                }
                return new zzfk(i2, z2, i3, i4, iArr, zza3);
            }
            int i12 = zzfkVar.zza;
            z3 = zzfkVar.zzb;
            i5 = zzfkVar.zzc;
            i6 = zzfkVar.zzd;
            iArr2 = zzfkVar.zze;
            i2 = i12;
        }
        iArr = iArr2;
        z2 = z3;
        i3 = i5;
        i4 = i6;
        int zza32 = zzfwVar.zza(8);
        int i92 = 0;
        while (i10 < i) {
        }
        zzfwVar.zzf(i92);
        if (i > 0) {
        }
        return new zzfk(i2, z2, i3, i4, iArr, zza32);
    }

    private static void zzo(zzfw zzfwVar) {
        int zzc2 = zzfwVar.zzc() + 1;
        zzfwVar.zzf(8);
        for (int i = 0; i < zzc2; i++) {
            zzfwVar.zzc();
            zzfwVar.zzc();
            zzfwVar.zze();
        }
        zzfwVar.zzf(20);
    }

    public static int zzc(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }
}
