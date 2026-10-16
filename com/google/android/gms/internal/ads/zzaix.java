package com.google.android.gms.internal.ads;

import android.util.Pair;
import io.bidmachine.media3.common.C;
import io.bidmachine.media3.common.MimeTypes;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaix {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        String str = zzex.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    public static zzav zzb(zzfc zzfcVar) {
        zzfa zzfaVar;
        zzfd zzb2 = zzfcVar.zzb(1751411826);
        zzfd zzb3 = zzfcVar.zzb(1801812339);
        zzfd zzb4 = zzfcVar.zzb(1768715124);
        if (zzb2 != null && zzb3 != null && zzb4 != null && zzi(zzb2.zza) == 1835299937) {
            zzen zzenVar = zzb3.zza;
            zzenVar.zzL(12);
            int zzg = zzenVar.zzg();
            String[] strArr = new String[zzg];
            for (int i = 0; i < zzg; i++) {
                int zzg2 = zzenVar.zzg();
                zzenVar.zzM(4);
                strArr[i] = zzenVar.zzB(zzg2 - 8, StandardCharsets.UTF_8);
            }
            zzen zzenVar2 = zzb4.zza;
            zzenVar2.zzL(8);
            ArrayList arrayList = new ArrayList();
            while (zzenVar2.zza() > 8) {
                int zzc = zzenVar2.zzc() + zzenVar2.zzg();
                int zzg3 = zzenVar2.zzg() - 1;
                if (zzg3 < 0 || zzg3 >= zzg) {
                    zzea.zzf("BoxParsers", "Skipped metadata with unknown key index: " + zzg3);
                } else {
                    String str = strArr[zzg3];
                    while (true) {
                        int zzc2 = zzenVar2.zzc();
                        if (zzc2 >= zzc) {
                            zzfaVar = null;
                            break;
                        }
                        int zzg4 = zzenVar2.zzg();
                        if (zzenVar2.zzg() == 1684108385) {
                            int zzg5 = zzenVar2.zzg();
                            int zzg6 = zzenVar2.zzg();
                            int i2 = zzg4 - 16;
                            byte[] bArr = new byte[i2];
                            zzenVar2.zzH(bArr, 0, i2);
                            zzfaVar = new zzfa(str, bArr, zzg6, zzg5);
                            break;
                        }
                        zzenVar2.zzL(zzc2 + zzg4);
                    }
                    if (zzfaVar != null) {
                        arrayList.add(zzfaVar);
                    }
                }
                zzenVar2.zzL(zzc);
            }
            if (!arrayList.isEmpty()) {
                return new zzav(arrayList);
            }
        }
        return null;
    }

    public static zzav zzc(zzfd zzfdVar) {
        int zzn;
        zzen zzenVar = zzfdVar.zza;
        zzenVar.zzL(8);
        zzav zzavVar = new zzav(-9223372036854775807L, new zzau[0]);
        while (zzenVar.zza() >= 8) {
            int zzc = zzenVar.zzc();
            int zzg = zzenVar.zzg() + zzc;
            int zzg2 = zzenVar.zzg();
            zzav zzavVar2 = null;
            if (zzg2 == 1835365473) {
                zzenVar.zzL(zzc);
                zzenVar.zzM(8);
                zzg(zzenVar);
                while (true) {
                    if (zzenVar.zzc() >= zzg) {
                        break;
                    }
                    int zzc2 = zzenVar.zzc();
                    int zzg3 = zzenVar.zzg() + zzc2;
                    if (zzenVar.zzg() == 1768715124) {
                        zzenVar.zzL(zzc2);
                        zzenVar.zzM(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzenVar.zzc() < zzg3) {
                            zzau zza2 = zzajf.zza(zzenVar);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzavVar2 = new zzav(arrayList);
                        }
                    } else {
                        zzenVar.zzL(zzg3);
                    }
                }
                zzavVar = zzavVar.zzd(zzavVar2);
            } else if (zzg2 == 1936553057) {
                zzenVar.zzL(zzc);
                zzenVar.zzM(12);
                while (true) {
                    if (zzenVar.zzc() >= zzg) {
                        break;
                    }
                    int zzc3 = zzenVar.zzc();
                    int zzg4 = zzenVar.zzg();
                    if (zzenVar.zzg() != 1935766900) {
                        zzenVar.zzL(zzc3 + zzg4);
                    } else if (zzg4 >= 16) {
                        zzenVar.zzM(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int zzm = zzenVar.zzm();
                            int zzm2 = zzenVar.zzm();
                            if (zzm == 0) {
                                i = zzm2;
                            } else if (zzm == 1) {
                                i2 = zzm2;
                            }
                        }
                        if (i == 12) {
                            zzn = 240;
                        } else if (i == 13) {
                            zzn = 120;
                        } else {
                            if (i == 21 && zzenVar.zza() >= 8 && zzenVar.zzc() + 8 <= zzg) {
                                int zzg5 = zzenVar.zzg();
                                int zzg6 = zzenVar.zzg();
                                if (zzg5 >= 12 && zzg6 == 1936877170) {
                                    zzn = zzenVar.zzn();
                                }
                            }
                            zzn = -2147483647;
                        }
                        if (zzn != -2147483647) {
                            zzavVar2 = new zzav(-9223372036854775807L, new zzahp(zzn, i2));
                        }
                    }
                }
                zzavVar = zzavVar.zzd(zzavVar2);
            } else if (zzg2 == -1451722374) {
                zzavVar = zzavVar.zzd(zzm(zzenVar));
            }
            zzenVar.zzL(zzg);
        }
        return zzavVar;
    }

    public static zzfh zzd(zzen zzenVar) {
        long zzt;
        long zzt2;
        zzenVar.zzL(8);
        if (zza(zzenVar.zzg()) == 0) {
            zzt = zzenVar.zzu();
            zzt2 = zzenVar.zzu();
        } else {
            zzt = zzenVar.zzt();
            zzt2 = zzenVar.zzt();
        }
        return new zzfh(zzt, zzt2, zzenVar.zzu());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzajs zze(zzajp zzajpVar, zzfc zzfcVar, zzaej zzaejVar) throws zzaz {
        zzaiq zzaiuVar;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        zzz zzzVar;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j;
        long j2;
        long j3;
        long[] jArr3;
        long[] jArr4;
        int i7;
        int i8;
        int i9;
        int length;
        int[] iArr3;
        int i10;
        int i11;
        int[] iArr4;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        long j4;
        int i18;
        int i19;
        int i20;
        int i21;
        zzajp zzajpVar2 = zzajpVar;
        zzfd zzb2 = zzfcVar.zzb(1937011578);
        if (zzb2 != null) {
            zzaiuVar = new zzait(zzb2, zzajpVar2.zzg);
        } else {
            zzfd zzb3 = zzfcVar.zzb(1937013298);
            if (zzb3 == null) {
                throw zzaz.zza("Track has no sample table size information", null);
            }
            zzaiuVar = new zzaiu(zzb3);
        }
        int zzb4 = zzaiuVar.zzb();
        if (zzb4 == 0) {
            return new zzajs(zzajpVar2, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        if (zzajpVar2.zzb == 2) {
            long j5 = zzajpVar2.zzf;
            if (j5 > 0) {
                zzx zzb5 = zzajpVar2.zzg.zzb();
                zzb5.zzO(zzb4 / (j5 / 1000000.0f));
                zzajpVar2 = zzajpVar2.zza(zzb5.zzan());
            }
        }
        zzfd zzb6 = zzfcVar.zzb(1937007471);
        if (zzb6 == null) {
            zzb6 = zzfcVar.zzb(1668232756);
            zzb6.getClass();
            z = true;
        } else {
            z = false;
        }
        zzfd zzb7 = zzfcVar.zzb(1937011555);
        zzb7.getClass();
        zzen zzenVar = zzb7.zza;
        zzfd zzb8 = zzfcVar.zzb(1937011827);
        zzb8.getClass();
        zzen zzenVar2 = zzb8.zza;
        zzfd zzb9 = zzfcVar.zzb(1937011571);
        zzen zzenVar3 = zzb9 != null ? zzb9.zza : null;
        zzfd zzb10 = zzfcVar.zzb(1668576371);
        zzen zzenVar4 = zzb10 != null ? zzb10.zza : null;
        zzaim zzaimVar = new zzaim(zzenVar, zzb6.zza, z);
        zzenVar2.zzL(12);
        int zzp = zzenVar2.zzp() - 1;
        int zzp2 = zzenVar2.zzp();
        int zzp3 = zzenVar2.zzp();
        if (zzenVar4 != null) {
            zzenVar4.zzL(12);
            i = zzenVar4.zzp();
        } else {
            i = 0;
        }
        if (zzenVar3 != null) {
            zzenVar3.zzL(12);
            i2 = zzenVar3.zzp();
            if (i2 > 0) {
                i4 = zzenVar3.zzp() - 1;
                i3 = 0;
            } else {
                i3 = 0;
                i4 = -1;
                zzenVar3 = null;
            }
        } else {
            i2 = 0;
            i3 = 0;
            i4 = -1;
        }
        int zza2 = zzaiuVar.zza();
        zzz zzzVar2 = zzajpVar2.zzg;
        if (zza2 != -1) {
            String str = zzzVar2.zzo;
            i5 = 1;
            if (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && zzp == 0) {
                if (i == 0 && i2 == 0) {
                    int i22 = zzaimVar.zza;
                    long[] jArr5 = new long[i22];
                    int[] iArr5 = new int[i22];
                    while (zzaimVar.zza()) {
                        int i23 = zzaimVar.zzb;
                        jArr5[i23] = zzaimVar.zzd;
                        iArr5[i23] = zzaimVar.zzc;
                    }
                    long j6 = zzp3;
                    int i24 = 8192 / zza2;
                    int i25 = i3;
                    int i26 = i25;
                    while (i25 < i22) {
                        int i27 = iArr5[i25];
                        String str2 = zzex.zza;
                        i26 += ((i27 + i24) - 1) / i24;
                        i25++;
                    }
                    jArr2 = new long[i26];
                    int[] iArr6 = new int[i26];
                    jArr = new long[i26];
                    iArr2 = new int[i26];
                    int i28 = i3;
                    int i29 = i28;
                    int i30 = i29;
                    int i31 = i30;
                    int i32 = i31;
                    while (i30 < i22) {
                        int i33 = iArr5[i30];
                        long j7 = jArr5[i30];
                        int i34 = i32;
                        int i35 = i22;
                        int i36 = i31;
                        int i37 = i34;
                        int i38 = i29;
                        int i39 = i33;
                        while (i39 > 0) {
                            int min = Math.min(i24, i39);
                            jArr2[i37] = j7;
                            int i40 = i24;
                            int i41 = zza2 * min;
                            iArr6[i37] = i41;
                            i38 += i41;
                            i36 = Math.max(i36, i41);
                            jArr[i37] = i28 * j6;
                            iArr2[i37] = 1;
                            j7 += iArr6[i37];
                            i28 += min;
                            i39 -= min;
                            i37++;
                            i24 = i40;
                            iArr5 = iArr5;
                        }
                        int i42 = i24;
                        i30++;
                        int i43 = i37;
                        i31 = i36;
                        i22 = i35;
                        i32 = i43;
                        i29 = i38;
                        i24 = i42;
                    }
                    j2 = i29;
                    zzzVar = zzzVar2;
                    j = j6 * i28;
                    iArr = iArr6;
                    i6 = i31;
                    long[] jArr6 = jArr2;
                    int[] iArr7 = iArr2;
                    j3 = zzajpVar2.zzf;
                    if (j3 > 0) {
                        long zzu = zzex.zzu(j2 * 8, 1000000L, j3, RoundingMode.HALF_DOWN);
                        if (zzu > 0 && zzu < 2147483647L) {
                            zzx zzb11 = zzzVar.zzb();
                            zzb11.zzC((int) zzu);
                            zzajpVar2 = zzajpVar2.zza(zzb11.zzan());
                        }
                    }
                    long j8 = zzajpVar2.zzc;
                    long zzu2 = zzex.zzu(j, 1000000L, j8, RoundingMode.DOWN);
                    jArr3 = zzajpVar2.zzi;
                    if (jArr3 == null) {
                        zzex.zzG(jArr, 1000000L, j8);
                        return new zzajs(zzajpVar2, jArr6, iArr, i6, jArr, iArr7, zzu2);
                    }
                    int length2 = jArr3.length;
                    int i44 = 1;
                    if (length2 == 1) {
                        if (zzajpVar2.zzb == 1 && (length = jArr.length) >= 2) {
                            long[] jArr7 = zzajpVar2.zzj;
                            jArr7.getClass();
                            long j9 = jArr7[i3];
                            long j10 = jArr3[i3];
                            long j11 = zzajpVar2.zzd;
                            long zzu3 = zzex.zzu(j10, j8, j11, RoundingMode.DOWN) + j9;
                            int i45 = length - 1;
                            int i46 = i3;
                            int max = Math.max(i46, Math.min(4, i45));
                            int max2 = Math.max(i46, Math.min(length - 4, i45));
                            long j12 = jArr[i46];
                            if (j12 > j9 || j9 >= jArr[max] || jArr[max2] >= zzu3 || zzu3 > j) {
                                j8 = j8;
                            } else {
                                long j13 = zzajpVar2.zzg.zzH;
                                long zzu4 = zzex.zzu(j9 - j12, j13, j8, RoundingMode.DOWN);
                                long zzu5 = zzex.zzu(j - zzu3, j13, j8, RoundingMode.DOWN);
                                j8 = j8;
                                if (zzu4 == 0) {
                                    if (zzu5 != 0) {
                                        zzu4 = 0;
                                    }
                                }
                                if (zzu4 <= 2147483647L && zzu5 <= 2147483647L) {
                                    zzaejVar.zza = (int) zzu4;
                                    zzaejVar.zzb = (int) zzu5;
                                    zzex.zzG(jArr, 1000000L, j8);
                                    return new zzajs(zzajpVar2, jArr6, iArr, i6, jArr, iArr7, zzex.zzu(jArr3[0], 1000000L, j11, RoundingMode.DOWN));
                                }
                            }
                        }
                        length2 = 1;
                        i44 = 1;
                    }
                    if (length2 == i44 && jArr3[0] == 0) {
                        long[] jArr8 = zzajpVar2.zzj;
                        jArr8.getClass();
                        long j14 = jArr8[0];
                        for (int i47 = 0; i47 < jArr.length; i47++) {
                            jArr[i47] = zzex.zzu(jArr[i47] - j14, 1000000L, j8, RoundingMode.DOWN);
                        }
                        return new zzajs(zzajpVar2, jArr6, iArr, i6, jArr, iArr7, zzex.zzu(j - j14, 1000000L, j8, RoundingMode.DOWN));
                    }
                    long j15 = j8;
                    int[] iArr8 = iArr;
                    int i48 = zzajpVar2.zzb;
                    boolean z2 = i48 == 1;
                    long[] jArr9 = zzajpVar2.zzj;
                    int[] iArr9 = new int[length2];
                    int[] iArr10 = new int[length2];
                    jArr9.getClass();
                    long[] jArr10 = jArr9;
                    int i49 = 0;
                    int i50 = 0;
                    int i51 = 0;
                    boolean z3 = false;
                    while (i50 < jArr3.length) {
                        int[] iArr11 = iArr10;
                        long j16 = jArr10[i50];
                        if (j16 != -1) {
                            jArr4 = jArr10;
                            i7 = i50;
                            long j17 = j15;
                            long zzu6 = zzex.zzu(jArr3[i50], j17, zzajpVar2.zzd, RoundingMode.DOWN);
                            j15 = j17;
                            iArr9[i7] = zzex.zzd(jArr, j16, true, true);
                            long j18 = j16 + zzu6;
                            iArr11[i7] = zzex.zza(jArr, j18, z2, false);
                            int i52 = iArr9[i7];
                            while (true) {
                                i8 = iArr9[i7];
                                if (i8 < 0 || (iArr7[i8] & 1) != 0) {
                                    break;
                                }
                                iArr9[i7] = i8 - 1;
                            }
                            if (i8 < 0) {
                                iArr9[i7] = i52;
                                while (true) {
                                    i9 = iArr9[i7];
                                    if (i9 >= iArr11[i7] || (iArr7[i9] & 1) != 0) {
                                        break;
                                    }
                                    iArr9[i7] = i9 + 1;
                                }
                            } else {
                                i9 = i8;
                            }
                            if (i48 == 2 && i9 != iArr11[i7]) {
                                while (true) {
                                    int i53 = iArr11[i7];
                                    if (i53 >= jArr.length - 1) {
                                        break;
                                    }
                                    int i54 = i53 + 1;
                                    if (jArr[i54] > j18) {
                                        break;
                                    }
                                    iArr11[i7] = i54;
                                }
                            }
                            int i55 = iArr11[i7];
                            int i56 = iArr9[i7];
                            i51 += i55 - i56;
                            z3 = (i49 != i56) | z3;
                            i49 = i55;
                        } else {
                            jArr4 = jArr10;
                            i7 = i50;
                        }
                        i50 = i7 + 1;
                        jArr10 = jArr4;
                        iArr10 = iArr11;
                    }
                    int[] iArr12 = iArr10;
                    boolean z4 = (i51 != zzb4) | z3;
                    long[] jArr11 = z4 ? new long[i51] : jArr6;
                    int[] iArr13 = z4 ? new int[i51] : iArr8;
                    if (true == z4) {
                        i6 = 0;
                    }
                    int[] iArr14 = z4 ? new int[i51] : iArr7;
                    long[] jArr12 = new long[i51];
                    long j19 = 0;
                    int i57 = i6;
                    int i58 = 0;
                    boolean z5 = false;
                    int i59 = 0;
                    while (i58 < jArr3.length) {
                        long j20 = jArr9[i58];
                        int i60 = iArr9[i58];
                        int i61 = iArr12[i58];
                        long[] jArr13 = jArr3;
                        if (z4) {
                            int i62 = i61 - i60;
                            System.arraycopy(jArr6, i60, jArr11, i59, i62);
                            System.arraycopy(iArr8, i60, iArr13, i59, i62);
                            System.arraycopy(iArr7, i60, iArr14, i59, i62);
                        }
                        int i63 = i57;
                        while (i60 < i61) {
                            boolean z6 = z4;
                            long[] jArr14 = jArr11;
                            long zzu7 = zzex.zzu(j19, 1000000L, zzajpVar2.zzd, RoundingMode.DOWN);
                            long zzu8 = zzex.zzu(jArr[i60] - j20, 1000000L, j15, RoundingMode.DOWN);
                            z5 = (!(zzu8 >= 0)) | z5;
                            jArr12[i59] = zzu7 + zzu8;
                            if (z6 && iArr13[i59] > i63) {
                                i63 = iArr8[i60];
                            }
                            i59++;
                            i60++;
                            z4 = z6;
                            jArr11 = jArr14;
                        }
                        j19 += jArr13[i58];
                        i58++;
                        z4 = z4;
                        i57 = i63;
                        jArr3 = jArr13;
                        jArr11 = jArr11;
                    }
                    long[] jArr15 = jArr11;
                    long zzu9 = zzex.zzu(j19, 1000000L, zzajpVar2.zzd, RoundingMode.DOWN);
                    if (z5) {
                        zzx zzb12 = zzajpVar2.zzg.zzb();
                        zzb12.zzP(true);
                        zzajpVar2 = zzajpVar2.zza(zzb12.zzan());
                    }
                    return new zzajs(zzajpVar2, jArr15, iArr13, i57, jArr12, iArr14, zzu9);
                }
                zzp = i3;
            }
        } else {
            i5 = 1;
        }
        long[] jArr16 = new long[zzb4];
        int[] iArr15 = new int[zzb4];
        long[] jArr17 = new long[zzb4];
        zzen zzenVar5 = zzenVar4;
        int[] iArr16 = new int[zzb4];
        zzaiq zzaiqVar = zzaiuVar;
        int i64 = i2;
        zzzVar = zzzVar2;
        int i65 = zzp;
        int i66 = zzp2;
        long j21 = 0;
        long j22 = 0;
        int i67 = i4;
        int i68 = i;
        int i69 = i3;
        int i70 = i69;
        int i71 = i70;
        int i72 = i71;
        int i73 = i72;
        long j23 = 0;
        while (true) {
            if (i69 >= zzb4) {
                iArr3 = iArr15;
                jArr = jArr17;
                jArr2 = jArr16;
                break;
            }
            long j24 = j21;
            int i74 = i5;
            while (true) {
                if (i72 != 0) {
                    i19 = zzb4;
                    i20 = i72;
                    i21 = i74;
                    break;
                }
                boolean zza3 = zzaimVar.zza();
                if (zza3 == 0) {
                    i19 = zzb4;
                    i20 = i3;
                    i21 = zza3;
                    break;
                }
                zzen zzenVar6 = zzenVar2;
                long j25 = zzaimVar.zzd;
                i72 = zzaimVar.zzc;
                j24 = j25;
                zzenVar2 = zzenVar6;
                zzenVar3 = zzenVar3;
                zzb4 = zzb4;
                i74 = zza3;
            }
            zzen zzenVar7 = zzenVar2;
            zzen zzenVar8 = zzenVar3;
            if (i21 == 0) {
                zzea.zzf("BoxParsers", "Unexpected end of chunk data");
                long[] copyOf = Arrays.copyOf(jArr16, i69);
                iArr3 = Arrays.copyOf(iArr15, i69);
                long[] copyOf2 = Arrays.copyOf(jArr17, i69);
                iArr16 = Arrays.copyOf(iArr16, i69);
                jArr2 = copyOf;
                jArr = copyOf2;
                zzb4 = i69;
                break;
            }
            if (zzenVar5 != null) {
                while (true) {
                    if (i73 != 0) {
                        break;
                    }
                    if (i68 <= 0) {
                        i73 = i3;
                        break;
                    }
                    i68--;
                    i73 = zzenVar5.zzp();
                    i70 = zzenVar5.zzg();
                }
                i73--;
            }
            jArr16[i69] = j24;
            int zzc = zzaiqVar.zzc();
            iArr15[i69] = zzc;
            j23 += zzc;
            if (zzc > i71) {
                i71 = zzc;
            }
            jArr17[i69] = j22 + i70;
            iArr16[i69] = zzenVar8 == null ? i5 : i3;
            if (i69 == i67) {
                iArr16[i69] = i5;
                i64--;
                if (i64 > 0) {
                    zzenVar8.getClass();
                    i67 = zzenVar8.zzp() - 1;
                }
            }
            j22 += zzp3;
            i66--;
            if (i66 == 0) {
                if (i65 > 0) {
                    i65--;
                    i66 = zzenVar7.zzp();
                    zzp3 = zzenVar7.zzg();
                } else {
                    i66 = i3;
                }
            }
            long j26 = j24 + iArr15[i69];
            i72 = i20 - 1;
            i69++;
            zzenVar2 = zzenVar7;
            j21 = j26;
            zzenVar3 = zzenVar8;
            zzb4 = i19;
        }
        iArr2 = iArr16;
        long j27 = j22 + i70;
        if (zzenVar5 != null) {
            while (i68 > 0) {
                if (zzenVar5.zzp() != 0) {
                    i10 = i3;
                    break;
                }
                zzenVar5.zzg();
                i68--;
            }
        }
        i10 = i5;
        if (i64 != 0) {
            i11 = zzb4;
            iArr4 = iArr3;
            i12 = i72;
            i13 = i65;
            i14 = i73;
            i15 = i66;
            i16 = i10;
            i17 = i64;
        } else if (i66 != 0) {
            i11 = zzb4;
            iArr4 = iArr3;
            i12 = i72;
            i13 = i65;
            i14 = i73;
            i15 = i66;
            i16 = i10;
            i17 = i3;
        } else if (i72 != 0) {
            i11 = zzb4;
            iArr4 = iArr3;
            i15 = i3;
            i12 = i72;
            i13 = i65;
            i14 = i73;
            i16 = i10;
            i17 = i15;
        } else if (i65 != 0) {
            i11 = zzb4;
            iArr4 = iArr3;
            i15 = i3;
            i12 = i15;
            i13 = i65;
            i14 = i73;
            i16 = i10;
            i17 = i12;
        } else if (i73 != 0) {
            i11 = zzb4;
            iArr4 = iArr3;
            i15 = i3;
            i12 = i15;
            i13 = i12;
            i14 = i73;
            i16 = i10;
            i17 = i13;
        } else if (i10 == 0) {
            i11 = zzb4;
            iArr4 = iArr3;
            i17 = i3;
            i16 = i17;
            i15 = i16;
            i12 = i15;
            i13 = i12;
            i14 = i13;
        } else {
            i11 = zzb4;
            iArr4 = iArr3;
            i18 = i71;
            j4 = j27;
            zzb4 = i11;
            j2 = j23;
            iArr = iArr4;
            i6 = i18;
            j = j4;
            long[] jArr62 = jArr2;
            int[] iArr72 = iArr2;
            j3 = zzajpVar2.zzf;
            if (j3 > 0) {
            }
            long j82 = zzajpVar2.zzc;
            long zzu22 = zzex.zzu(j, 1000000L, j82, RoundingMode.DOWN);
            jArr3 = zzajpVar2.zzi;
            if (jArr3 == null) {
            }
        }
        int i75 = zzajpVar2.zza;
        i18 = i71;
        j4 = j27;
        StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
        sb.append(i75);
        sb.append(": remainingSynchronizationSamples ");
        sb.append(i17);
        sb.append(", remainingSamplesAtTimestampDelta ");
        sb.append(i15);
        sb.append(", remainingSamplesInChunk ");
        sb.append(i12);
        sb.append(", remainingTimestampDeltaChanges ");
        sb.append(i13);
        sb.append(", remainingSamplesAtTimestampOffset ");
        sb.append(i14);
        sb.append(i5 != i16 ? ", ctts invalid" : "");
        zzea.zzf("BoxParsers", sb.toString());
        zzb4 = i11;
        j2 = j23;
        iArr = iArr4;
        i6 = i18;
        j = j4;
        long[] jArr622 = jArr2;
        int[] iArr722 = iArr2;
        j3 = zzajpVar2.zzf;
        if (j3 > 0) {
        }
        long j822 = zzajpVar2.zzc;
        long zzu222 = zzex.zzu(j, 1000000L, j822, RoundingMode.DOWN);
        jArr3 = zzajpVar2.zzi;
        if (jArr3 == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0dd2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0e05  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x06c2  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x06d0  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x06dc  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0b73  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x0b75  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0d66  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x0d6a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0e10 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:594:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0286  */
    /* JADX WARN: Type inference failed for: r11v38, types: [int] */
    /* JADX WARN: Type inference failed for: r33v0 */
    /* JADX WARN: Type inference failed for: r33v1 */
    /* JADX WARN: Type inference failed for: r33v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List zzf(zzfc zzfcVar, zzaej zzaejVar, long j, zzs zzsVar, boolean z, boolean z2, zzfve zzfveVar) throws zzaz {
        int i;
        ?? r33;
        long j2;
        int i2;
        int i3;
        boolean z3;
        long j3;
        long j4;
        long zzu;
        int zza2;
        int i4;
        int i5;
        long j5;
        long j6;
        int i6;
        String str;
        zzfd zzb2;
        int i7;
        int i8;
        String str2;
        ArrayList arrayList;
        zzfc zzfcVar2;
        long[] jArr;
        long[] jArr2;
        zzz zzzVar;
        int i9;
        int i10;
        long j7;
        long j8;
        zzfve zzfveVar2;
        zzajp zzajpVar;
        int i11;
        Pair create;
        int i12;
        zzen zzenVar;
        int i13;
        int i14;
        int i15;
        zzs zzsVar2;
        int i16;
        String str3;
        ArrayList arrayList2;
        zzfc zzfcVar3;
        int i17;
        byte b;
        char c;
        char c2;
        int i18;
        int i19;
        String str4;
        long j9;
        long j10;
        long j11;
        long j12;
        int i20;
        int i21;
        int i22;
        boolean z4;
        int i23;
        String str5;
        zzais zzaisVar;
        int i24;
        int i25;
        zzfs zzfsVar;
        int i26;
        byte b2;
        byte b3;
        zzfyq zzfyqVar;
        boolean z5;
        int i27;
        int i28;
        String str6;
        byte[] bArr;
        char c3;
        int i29;
        zzaio zzaioVar;
        zzair zzairVar;
        boolean z6;
        zzaio zzaioVar2;
        zzair zzairVar2;
        boolean z7;
        int i30;
        boolean z8;
        String str7;
        int i31;
        zzfs zzfsVar2;
        boolean z9;
        int i32;
        int i33;
        int i34;
        zzfyq zzfyqVar2;
        boolean z10;
        boolean z11;
        String str8;
        long j13;
        zzfyq zzo;
        long j14;
        int i35;
        boolean z12;
        zzajp zzajpVar2;
        ArrayList arrayList3;
        zzfc zzfcVar4 = zzfcVar;
        ArrayList arrayList4 = new ArrayList();
        int i36 = 0;
        while (true) {
            List list = zzfcVar4.zzc;
            if (i36 >= list.size()) {
                return arrayList4;
            }
            zzfc zzfcVar5 = (zzfc) list.get(i36);
            if (zzfcVar5.zzd != 1953653099) {
                arrayList3 = arrayList4;
                i = i36;
            } else {
                zzfd zzb3 = zzfcVar4.zzb(1836476516);
                zzb3.getClass();
                zzfc zza3 = zzfcVar5.zza(1835297121);
                zza3.getClass();
                zzfd zzb4 = zza3.zzb(1751411826);
                zzb4.getClass();
                int zzi = zzi(zzb4.zza);
                boolean z13 = true;
                int i37 = zzi == 1936684398 ? 1 : zzi == 1986618469 ? 2 : (zzi == 1952807028 || zzi == 1935832172 || zzi == 1937072756 || zzi == 1668047728) ? 3 : zzi == 1835365473 ? 5 : -1;
                if (i37 == -1) {
                    zzfveVar2 = zzfveVar;
                    arrayList = arrayList4;
                    i = i36;
                    zzfcVar2 = zzfcVar5;
                } else {
                    zzfd zzb5 = zzfcVar5.zzb(1953196132);
                    zzb5.getClass();
                    zzen zzenVar2 = zzb5.zza;
                    zzenVar2.zzL(8);
                    int zza4 = zza(zzenVar2.zzg());
                    zzenVar2.zzM(zza4 == 0 ? 8 : 16);
                    int zzg = zzenVar2.zzg();
                    zzenVar2.zzM(4);
                    int zzc = zzenVar2.zzc();
                    int i38 = 0;
                    while (true) {
                        int i39 = zza4 == 0 ? 4 : 8;
                        i = i36;
                        r33 = 0;
                        if (i38 >= i39) {
                            zzenVar2.zzM(i39);
                            break;
                        }
                        if (zzenVar2.zzN()[zzc + i38] != -1) {
                            long zzu2 = zza4 == 0 ? zzenVar2.zzu() : zzenVar2.zzw();
                            if (zzu2 != 0) {
                                j2 = zzu2;
                            }
                        } else {
                            i38++;
                            i36 = i;
                        }
                    }
                    j2 = -9223372036854775807L;
                    zzenVar2.zzM(10);
                    int zzq = zzenVar2.zzq();
                    zzenVar2.zzM(4);
                    int zzg2 = zzenVar2.zzg();
                    int zzg3 = zzenVar2.zzg();
                    zzenVar2.zzM(4);
                    int zzg4 = zzenVar2.zzg();
                    int zzg5 = zzenVar2.zzg();
                    if (zzg2 == 0) {
                        if (zzg3 == 65536) {
                            if (zzg4 != -65536) {
                                if (zzg4 == 65536) {
                                    z12 = zzg5 != 0;
                                    i35 = 65536;
                                }
                                zzg3 = 65536;
                            } else {
                                i35 = zzg4;
                                z12 = zzg5 != 0;
                            }
                            if (true != z12) {
                                i2 = 90;
                                i3 = i2;
                                zzaiv zzaivVar = new zzaiv(zzg, j2, zzq, i3);
                                if (j != -9223372036854775807L) {
                                    j14 = zzaivVar.zzb;
                                    j3 = j14;
                                } else {
                                    j3 = j;
                                }
                                long j15 = zzd(zzb3.zza).zzc;
                                if (j3 != -9223372036854775807L) {
                                    j4 = j15;
                                    zzu = -9223372036854775807L;
                                } else {
                                    j4 = j15;
                                    zzu = zzex.zzu(j3, 1000000L, j15, RoundingMode.DOWN);
                                }
                                zzfc zza5 = zza3.zza(1835626086);
                                zza5.getClass();
                                zzfc zza6 = zza5.zza(1937007212);
                                zza6.getClass();
                                zzfd zzb6 = zza3.zzb(1835296868);
                                zzb6.getClass();
                                zzen zzenVar3 = zzb6.zza;
                                zzenVar3.zzL(8);
                                zza2 = zza(zzenVar3.zzg());
                                zzenVar3.zzM(zza2 != 0 ? 8 : 16);
                                long zzu3 = zzenVar3.zzu();
                                int zzc2 = zzenVar3.zzc();
                                i4 = 0;
                                while (true) {
                                    i5 = zza2 != 0 ? 4 : 8;
                                    if (i4 < i5) {
                                        j5 = zzu3;
                                        zzenVar3.zzM(i5);
                                        j6 = -9223372036854775807L;
                                        break;
                                    }
                                    if (zzenVar3.zzN()[zzc2 + i4] != -1) {
                                        long zzu4 = zza2 == 0 ? zzenVar3.zzu() : zzenVar3.zzw();
                                        if (zzu4 == 0) {
                                            j6 = -9223372036854775807L;
                                            j5 = zzu3;
                                        } else {
                                            j5 = zzu3;
                                            j6 = zzex.zzu(zzu4, 1000000L, j5, RoundingMode.DOWN);
                                        }
                                    } else {
                                        i4++;
                                    }
                                }
                                int zzq2 = zzenVar3.zzq();
                                char[] cArr = {(char) (((zzq2 >> 10) & 31) + 96), (char) (((zzq2 >> 5) & 31) + 96), (char) ((zzq2 & 31) + 96)};
                                for (i6 = 0; i6 < 3; i6++) {
                                    char c4 = cArr[i6];
                                    if (c4 < 'a' || c4 > 'z') {
                                        str = null;
                                        break;
                                    }
                                }
                                str = new String(cArr);
                                zzaip zzaipVar = new zzaip(j5, j6, str);
                                zzb2 = zza6.zzb(1937011556);
                                if (zzb2 != null) {
                                    throw zzaz.zza("Malformed sample table (stbl) missing sample description (stsd)", null);
                                }
                                i7 = zzaivVar.zza;
                                i8 = zzaivVar.zzd;
                                str2 = zzaipVar.zzc;
                                zzen zzenVar4 = zzb2.zza;
                                zzenVar4.zzL(12);
                                int zzg6 = zzenVar4.zzg();
                                zzais zzaisVar2 = new zzais(zzg6);
                                int i40 = 8;
                                int i41 = 0;
                                while (i41 < zzg6) {
                                    int i42 = i37;
                                    int zzc3 = zzenVar4.zzc();
                                    int i43 = i40;
                                    int zzg7 = zzenVar4.zzg();
                                    String str9 = "childAtomSize must be positive";
                                    zzadz.zzc(zzg7 > 0 ? z13 : r33, "childAtomSize must be positive");
                                    int zzg8 = zzenVar4.zzg();
                                    if (zzg8 == 1635148593 || zzg8 == 1635148595 || zzg8 == 1701733238 || zzg8 == 1831958048 || zzg8 == 1836070006 || zzg8 == 1752589105 || zzg8 == 1751479857 || zzg8 == 1932670515 || zzg8 == 1211250227 || zzg8 == 1748121139 || zzg8 == 1987063864 || zzg8 == 1987063865 || zzg8 == 1635135537 || zzg8 == 1685479798 || zzg8 == 1685479729 || zzg8 == 1685481573 || zzg8 == 1685481521 || zzg8 == 1634760241) {
                                        int i44 = zzg8;
                                        i12 = i42;
                                        byte b4 = 3;
                                        zzenVar = zzenVar4;
                                        zzenVar.zzL(zzc3 + 16);
                                        zzenVar.zzM(16);
                                        int zzq3 = zzenVar.zzq();
                                        int zzq4 = zzenVar.zzq();
                                        i13 = i41;
                                        zzenVar.zzM(50);
                                        int zzc4 = zzenVar.zzc();
                                        i14 = zzg6;
                                        int i45 = 1701733238;
                                        if (i44 == 1701733238) {
                                            Pair zzj = zzj(zzenVar, zzc3, zzg7);
                                            if (zzj != null) {
                                                i45 = ((Integer) zzj.first).intValue();
                                                if (zzsVar == null) {
                                                    i15 = zzc3;
                                                    zzsVar2 = null;
                                                } else {
                                                    i15 = zzc3;
                                                    zzsVar2 = zzsVar.zzb(((zzajq) zzj.second).zzb);
                                                }
                                                zzaisVar2.zza[i13] = (zzajq) zzj.second;
                                            } else {
                                                i15 = zzc3;
                                                zzsVar2 = zzsVar;
                                            }
                                            zzenVar.zzL(zzc4);
                                            i44 = i45;
                                        } else {
                                            i15 = zzc3;
                                            zzsVar2 = zzsVar;
                                        }
                                        if (i44 == 1831958048) {
                                            int i46 = i44;
                                            str3 = "video/mpeg";
                                            i16 = i46;
                                        } else {
                                            i16 = 1211250227;
                                            if (i44 == 1211250227) {
                                                str3 = "video/3gpp";
                                            } else {
                                                i16 = i44;
                                                str3 = null;
                                            }
                                        }
                                        zzs zzsVar3 = zzsVar2;
                                        int i47 = i7;
                                        String str10 = str2;
                                        int i48 = zzc4;
                                        arrayList2 = arrayList4;
                                        int i49 = i8;
                                        String str11 = str3;
                                        zzfcVar3 = zzfcVar5;
                                        float f = 1.0f;
                                        int i50 = 8;
                                        int i51 = -1;
                                        int i52 = 8;
                                        zzfs zzfsVar3 = null;
                                        int i53 = -1;
                                        int i54 = -1;
                                        byte b5 = -1;
                                        List list2 = null;
                                        ByteBuffer byteBuffer = null;
                                        zzail zzailVar = null;
                                        zzain zzainVar = null;
                                        int i55 = -1;
                                        int i56 = -1;
                                        byte[] bArr2 = null;
                                        int i57 = -1;
                                        boolean z14 = false;
                                        int i58 = -1;
                                        String str12 = null;
                                        while (i48 - i15 < zzg7) {
                                            zzenVar.zzL(i48);
                                            int zzc5 = zzenVar.zzc();
                                            int zzg9 = zzenVar.zzg();
                                            if (zzg9 == 0) {
                                                i20 = i48;
                                                if (zzenVar.zzc() - i15 == zzg7) {
                                                    break;
                                                }
                                                i21 = 0;
                                            } else {
                                                i20 = i48;
                                                i21 = zzg9;
                                            }
                                            if (i21 > 0) {
                                                i22 = zzg7;
                                                z4 = true;
                                            } else {
                                                i22 = zzg7;
                                                z4 = false;
                                            }
                                            zzadz.zzc(z4, str9);
                                            int zzg10 = zzenVar.zzg();
                                            if (zzg10 != 1635148611) {
                                                if (zzg10 == 1752589123) {
                                                    int i59 = zzc5 + 8;
                                                    zzadz.zzc(str11 == null, null);
                                                    zzenVar.zzL(i59);
                                                    zzaek zza7 = zzaek.zza(zzenVar);
                                                    List list3 = zza7.zza;
                                                    zzaisVar2.zzc = zza7.zzb;
                                                    if (z14) {
                                                        z10 = true;
                                                    } else {
                                                        f = zza7.zzl;
                                                        z10 = false;
                                                    }
                                                    int i60 = zza7.zzm;
                                                    int i61 = zza7.zzc;
                                                    String str13 = zza7.zzn;
                                                    ?? r11 = zza7.zzk;
                                                    byte b6 = r11;
                                                    if (r11 == -1) {
                                                        b6 = b5;
                                                    }
                                                    int i62 = zza7.zzd;
                                                    int i63 = zza7.zze;
                                                    int i64 = zza7.zzh;
                                                    int i65 = zza7.zzi;
                                                    int i66 = zza7.zzj;
                                                    int i67 = zza7.zzf;
                                                    int i68 = zza7.zzg;
                                                    zzfsVar = zza7.zzo;
                                                    i24 = i16;
                                                    i50 = i68;
                                                    str5 = str9;
                                                    zzaisVar = zzaisVar2;
                                                    str12 = str13;
                                                    i58 = i62;
                                                    i53 = i65;
                                                    b3 = b4;
                                                    list2 = list3;
                                                    str11 = "video/hevc";
                                                    i55 = i61;
                                                    z14 = z10;
                                                    i51 = i66;
                                                    i52 = i67;
                                                    i56 = i60;
                                                    i57 = i63;
                                                    i54 = i64;
                                                    b5 = b6;
                                                } else if (zzg10 == 1818785347) {
                                                    int i69 = zzc5 + 8;
                                                    zzadz.zzc("video/hevc".equals(str11), "lhvC must follow hvcC atom");
                                                    if (zzfsVar3 == null) {
                                                        zzfsVar2 = null;
                                                    } else if (zzfsVar3.zza.size() >= 2) {
                                                        zzfsVar2 = zzfsVar3;
                                                        z9 = true;
                                                        zzadz.zzc(z9, "must have at least two layers");
                                                        zzenVar.zzL(i69);
                                                        zzfsVar2.getClass();
                                                        zzaek zzb7 = zzaek.zzb(zzenVar, zzfsVar2);
                                                        zzadz.zzc(zzaisVar2.zzc != zzb7.zzb, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                                        i32 = zzb7.zzh;
                                                        if (i32 != -1) {
                                                            zzadz.zzc(i54 == i32, "colorSpace must be the same for both views");
                                                        }
                                                        i33 = zzb7.zzi;
                                                        if (i33 != -1) {
                                                            zzadz.zzc(i53 == i33, "colorRange must be the same for both views");
                                                        }
                                                        i34 = zzb7.zzj;
                                                        if (i34 != -1) {
                                                            zzadz.zzc(i51 == i34, "colorTransfer must be the same for both views");
                                                        }
                                                        zzadz.zzc(i52 != zzb7.zzf, "bitdepthLuma must be the same for both views");
                                                        zzadz.zzc(i50 != zzb7.zzg, "bitdepthChroma must be the same for both views");
                                                        if (list2 == null) {
                                                            int i70 = zzfyq.zzd;
                                                            zzfyn zzfynVar = new zzfyn();
                                                            zzfynVar.zzh(list2);
                                                            zzfynVar.zzh(zzb7.zza);
                                                            zzfyqVar2 = zzfynVar.zzi();
                                                        } else {
                                                            zzadz.zzc(false, "initializationData must be already set from hvcC atom");
                                                            zzfyqVar2 = null;
                                                        }
                                                        i24 = i16;
                                                        zzfsVar = zzfsVar2;
                                                        str12 = zzb7.zzn;
                                                        str5 = str9;
                                                        zzaisVar = zzaisVar2;
                                                        list2 = zzfyqVar2;
                                                        str11 = MimeTypes.VIDEO_MV_HEVC;
                                                        b3 = b4;
                                                    } else {
                                                        zzfsVar2 = zzfsVar3;
                                                    }
                                                    z9 = false;
                                                    zzadz.zzc(z9, "must have at least two layers");
                                                    zzenVar.zzL(i69);
                                                    zzfsVar2.getClass();
                                                    zzaek zzb72 = zzaek.zzb(zzenVar, zzfsVar2);
                                                    zzadz.zzc(zzaisVar2.zzc != zzb72.zzb, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                                    i32 = zzb72.zzh;
                                                    if (i32 != -1) {
                                                    }
                                                    i33 = zzb72.zzi;
                                                    if (i33 != -1) {
                                                    }
                                                    i34 = zzb72.zzj;
                                                    if (i34 != -1) {
                                                    }
                                                    zzadz.zzc(i52 != zzb72.zzf, "bitdepthLuma must be the same for both views");
                                                    zzadz.zzc(i50 != zzb72.zzg, "bitdepthChroma must be the same for both views");
                                                    if (list2 == null) {
                                                    }
                                                    i24 = i16;
                                                    zzfsVar = zzfsVar2;
                                                    str12 = zzb72.zzn;
                                                    str5 = str9;
                                                    zzaisVar = zzaisVar2;
                                                    list2 = zzfyqVar2;
                                                    str11 = MimeTypes.VIDEO_MV_HEVC;
                                                    b3 = b4;
                                                } else if (zzg10 == 1986361461) {
                                                    zzenVar.zzL(zzc5 + 8);
                                                    int zzc6 = zzenVar.zzc();
                                                    zzaisVar = zzaisVar2;
                                                    zzaio zzaioVar3 = null;
                                                    while (zzc6 - zzc5 < i21) {
                                                        zzenVar.zzL(zzc6);
                                                        int zzg11 = zzenVar.zzg();
                                                        if (zzg11 > 0) {
                                                            i30 = zzc6;
                                                            z8 = true;
                                                        } else {
                                                            i30 = zzc6;
                                                            z8 = false;
                                                        }
                                                        zzadz.zzc(z8, str9);
                                                        int i71 = i50;
                                                        if (zzenVar.zzg() == 1702454643) {
                                                            zzenVar.zzL(i30 + 8);
                                                            int zzc7 = zzenVar.zzc();
                                                            while (true) {
                                                                if (zzc7 - i30 >= zzg11) {
                                                                    str7 = str9;
                                                                    i31 = zzg11;
                                                                    zzaioVar3 = null;
                                                                    break;
                                                                }
                                                                zzenVar.zzL(zzc7);
                                                                int zzg12 = zzenVar.zzg();
                                                                zzadz.zzc(zzg12 > 0, str9);
                                                                int i72 = zzc7;
                                                                if (zzenVar.zzg() == 1937011305) {
                                                                    zzenVar.zzM(4);
                                                                    int zzm = zzenVar.zzm();
                                                                    str7 = str9;
                                                                    i31 = zzg11;
                                                                    zzaioVar3 = new zzaio(new zzair(1 == (zzm & 1), (zzm & 2) == 2, (zzm & 8) == 8));
                                                                } else {
                                                                    zzc7 = i72 + zzg12;
                                                                }
                                                            }
                                                        } else {
                                                            str7 = str9;
                                                            i31 = zzg11;
                                                        }
                                                        zzc6 = i30 + i31;
                                                        i50 = i71;
                                                        str9 = str7;
                                                    }
                                                    i23 = i50;
                                                    str5 = str9;
                                                    zzaiw zzaiwVar = zzaioVar3 == null ? null : new zzaiw(zzaioVar3);
                                                    if (zzaiwVar != null) {
                                                        if (zzfsVar3 == null) {
                                                            zzfsVar3 = null;
                                                        } else if (zzfsVar3.zza.size() >= 2) {
                                                            zzadz.zzc(zzaiwVar.zzb(), "both eye views must be marked as available");
                                                            zzaioVar2 = zzaiwVar.zza;
                                                            zzairVar2 = zzaioVar2.zza;
                                                            z7 = zzairVar2.zzc;
                                                            zzadz.zzc(!z7, "for MV-HEVC, eye_views_reversed must be set to false");
                                                        }
                                                        if (b5 == -1) {
                                                            zzaioVar = zzaiwVar.zza;
                                                            zzairVar = zzaioVar.zza;
                                                            z6 = zzairVar.zzc;
                                                            i24 = i16;
                                                            zzfsVar = zzfsVar3;
                                                            if (true != z6) {
                                                                b3 = b4;
                                                                b5 = 4;
                                                            } else {
                                                                b5 = 5;
                                                                b3 = b4;
                                                            }
                                                            i50 = i23;
                                                        } else {
                                                            i24 = i16;
                                                            zzfsVar = zzfsVar3;
                                                            b3 = b4;
                                                            i50 = i23;
                                                        }
                                                    }
                                                    i24 = i16;
                                                    i25 = i52;
                                                    zzfsVar = zzfsVar3;
                                                    i26 = i53;
                                                    b2 = b5;
                                                    b3 = b4;
                                                    i50 = i23;
                                                    i52 = i25;
                                                    i53 = i26;
                                                    b5 = b2;
                                                } else {
                                                    i23 = i50;
                                                    str5 = str9;
                                                    zzaisVar = zzaisVar2;
                                                    if (zzg10 == 1685480259 || zzg10 == 1685485123 || zzg10 == 1685485379) {
                                                        i24 = i16;
                                                        i25 = i52;
                                                        zzfsVar = zzfsVar3;
                                                        i26 = i53;
                                                        b2 = b5;
                                                        b3 = b4;
                                                        int i73 = i21 - 8;
                                                        int i74 = zzc5 + 8;
                                                        byte[] bArr3 = new byte[i73];
                                                        zzenVar.zzH(bArr3, 0, i73);
                                                        if (list2 != null) {
                                                            int i75 = zzfyq.zzd;
                                                            zzfyn zzfynVar2 = new zzfyn();
                                                            zzfynVar2.zzh(list2);
                                                            zzfynVar2.zzf(bArr3);
                                                            zzfyqVar = zzfynVar2.zzi();
                                                        } else {
                                                            zzadz.zzc(false, "initializationData must already be set from hvcC or avcC atom");
                                                            zzfyqVar = null;
                                                        }
                                                        zzenVar.zzL(i74);
                                                        zzez zza8 = zzez.zza(zzenVar);
                                                        if (zza8 != null) {
                                                            str12 = zza8.zza;
                                                            list2 = zzfyqVar;
                                                            str11 = "video/dolby-vision";
                                                        } else {
                                                            list2 = zzfyqVar;
                                                        }
                                                    } else if (zzg10 == 1987076931) {
                                                        int i76 = zzc5 + 12;
                                                        zzadz.zzc(str11 == null, null);
                                                        zzenVar.zzL(i76);
                                                        byte zzm2 = (byte) zzenVar.zzm();
                                                        byte zzm3 = (byte) zzenVar.zzm();
                                                        int zzm4 = zzenVar.zzm();
                                                        int i77 = zzm4 >> 4;
                                                        int i78 = zzm4 >> 1;
                                                        String str14 = i16 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                        if (str14.equals("video/x-vnd.on2.vp9")) {
                                                            int i79 = zzdk.zza;
                                                            c3 = '\f';
                                                            byte[] bArr4 = new byte[12];
                                                            i29 = 1;
                                                            bArr4[0] = 1;
                                                            bArr4[1] = 1;
                                                            bArr4[2] = zzm2;
                                                            bArr4[b4] = 2;
                                                            bArr4[4] = 1;
                                                            bArr4[5] = zzm3;
                                                            bArr4[6] = b4;
                                                            bArr4[7] = 1;
                                                            bArr4[8] = (byte) i77;
                                                            bArr4[9] = 4;
                                                            bArr4[10] = 1;
                                                            bArr4[11] = (byte) (i78 & 7);
                                                            list2 = zzfyq.zzo(bArr4);
                                                        } else {
                                                            c3 = '\f';
                                                            i29 = 1;
                                                        }
                                                        int i80 = zzm4 & 1;
                                                        int zzm5 = zzenVar.zzm();
                                                        int zzm6 = zzenVar.zzm();
                                                        int zza9 = zzk.zza(zzm5);
                                                        i53 = i29 != i80 ? 2 : 1;
                                                        i24 = i16;
                                                        i54 = zza9;
                                                        i50 = i77;
                                                        zzfsVar = zzfsVar3;
                                                        b3 = b4;
                                                        i51 = zzk.zzb(zzm6);
                                                        str11 = str14;
                                                        i52 = i50;
                                                    } else {
                                                        if (zzg10 == 1635135811) {
                                                            int i81 = i21 - 8;
                                                            byte[] bArr5 = new byte[i81];
                                                            zzenVar.zzH(bArr5, 0, i81);
                                                            zzfyq zzo2 = zzfyq.zzo(bArr5);
                                                            zzenVar.zzL(zzc5 + 8);
                                                            zzk zzl = zzl(zzenVar);
                                                            i27 = zzl.zzf;
                                                            int i82 = zzl.zzg;
                                                            int i83 = zzl.zzb;
                                                            int i84 = zzl.zzc;
                                                            i28 = zzl.zzd;
                                                            list2 = zzo2;
                                                            i24 = i16;
                                                            i50 = i82;
                                                            i54 = i83;
                                                            i53 = i84;
                                                            str11 = "video/av01";
                                                            zzfsVar = zzfsVar3;
                                                            b3 = b4;
                                                        } else if (zzg10 == 1668050025) {
                                                            ByteBuffer zzp = byteBuffer == null ? zzp() : byteBuffer;
                                                            zzp.position(21);
                                                            zzp.putShort(zzenVar.zzE());
                                                            zzp.putShort(zzenVar.zzE());
                                                            byteBuffer = zzp;
                                                            i24 = i16;
                                                            zzfsVar = zzfsVar3;
                                                            b3 = b4;
                                                            i50 = i23;
                                                        } else {
                                                            if (zzg10 == 1835295606) {
                                                                ByteBuffer zzp2 = byteBuffer == null ? zzp() : byteBuffer;
                                                                short zzE = zzenVar.zzE();
                                                                short zzE2 = zzenVar.zzE();
                                                                short zzE3 = zzenVar.zzE();
                                                                short zzE4 = zzenVar.zzE();
                                                                i24 = i16;
                                                                short zzE5 = zzenVar.zzE();
                                                                zzfsVar = zzfsVar3;
                                                                short zzE6 = zzenVar.zzE();
                                                                i25 = i52;
                                                                short zzE7 = zzenVar.zzE();
                                                                i26 = i53;
                                                                short zzE8 = zzenVar.zzE();
                                                                long zzu5 = zzenVar.zzu();
                                                                long zzu6 = zzenVar.zzu();
                                                                b2 = b5;
                                                                zzp2.position(1);
                                                                zzp2.putShort(zzE5);
                                                                zzp2.putShort(zzE6);
                                                                zzp2.putShort(zzE);
                                                                zzp2.putShort(zzE2);
                                                                zzp2.putShort(zzE3);
                                                                zzp2.putShort(zzE4);
                                                                zzp2.putShort(zzE7);
                                                                zzp2.putShort(zzE8);
                                                                zzp2.putShort((short) (zzu5 / 10000));
                                                                zzp2.putShort((short) (zzu6 / 10000));
                                                                byteBuffer = zzp2;
                                                            } else {
                                                                i24 = i16;
                                                                i25 = i52;
                                                                zzfsVar = zzfsVar3;
                                                                i26 = i53;
                                                                b2 = b5;
                                                                if (zzg10 == 1681012275) {
                                                                    zzadz.zzc(str11 == null, null);
                                                                    str6 = "video/3gpp";
                                                                } else if (zzg10 == 1702061171) {
                                                                    zzadz.zzc(str11 == null, null);
                                                                    zzain zzo3 = zzo(zzenVar, zzc5);
                                                                    str6 = zzo3.zza;
                                                                    bArr = zzo3.zzb;
                                                                    if (bArr != null) {
                                                                        zzainVar = zzo3;
                                                                        str11 = str6;
                                                                        list2 = zzfyq.zzo(bArr);
                                                                    } else {
                                                                        zzainVar = zzo3;
                                                                    }
                                                                } else if (zzg10 == 1651798644) {
                                                                    zzailVar = zzn(zzenVar, zzc5);
                                                                } else if (zzg10 == 1885434736) {
                                                                    zzenVar.zzL(zzc5 + 8);
                                                                    f = zzenVar.zzp() / zzenVar.zzp();
                                                                    b3 = b4;
                                                                    i50 = i23;
                                                                    i52 = i25;
                                                                    i53 = i26;
                                                                    b5 = b2;
                                                                    z14 = true;
                                                                } else if (zzg10 == 1937126244) {
                                                                    int i85 = zzc5 + 8;
                                                                    while (i85 - zzc5 < i21) {
                                                                        zzenVar.zzL(i85);
                                                                        int zzg13 = zzenVar.zzg() + i85;
                                                                        if (zzenVar.zzg() == 1886547818) {
                                                                            bArr2 = Arrays.copyOfRange(zzenVar.zzN(), i85, zzg13);
                                                                        } else {
                                                                            i85 = zzg13;
                                                                        }
                                                                    }
                                                                    b3 = b4;
                                                                    i50 = i23;
                                                                    i52 = i25;
                                                                    i53 = i26;
                                                                    b5 = b2;
                                                                    bArr2 = null;
                                                                } else if (zzg10 == 1936995172) {
                                                                    int zzm7 = zzenVar.zzm();
                                                                    b3 = b4;
                                                                    zzenVar.zzM(b3);
                                                                    if (zzm7 == 0) {
                                                                        int zzm8 = zzenVar.zzm();
                                                                        if (zzm8 == 0) {
                                                                            i50 = i23;
                                                                            i52 = i25;
                                                                            i53 = i26;
                                                                            b5 = 0;
                                                                        } else if (zzm8 == 1) {
                                                                            i50 = i23;
                                                                            i52 = i25;
                                                                            i53 = i26;
                                                                            b5 = 1;
                                                                        } else if (zzm8 == 2) {
                                                                            i50 = i23;
                                                                            i52 = i25;
                                                                            i53 = i26;
                                                                            b5 = 2;
                                                                        } else if (zzm8 == b3) {
                                                                            b5 = b3;
                                                                            i50 = i23;
                                                                            i52 = i25;
                                                                            i53 = i26;
                                                                        }
                                                                    }
                                                                } else {
                                                                    b3 = b4;
                                                                    if (zzg10 == 1634760259) {
                                                                        int i86 = i21 - 12;
                                                                        byte[] bArr6 = new byte[i86];
                                                                        zzenVar.zzL(zzc5 + 12);
                                                                        zzenVar.zzH(bArr6, 0, i86);
                                                                        zzfyq zzo4 = zzfyq.zzo(bArr6);
                                                                        zzk zzk = zzk(new zzen(bArr6));
                                                                        i27 = zzk.zzf;
                                                                        int i87 = zzk.zzg;
                                                                        int i88 = zzk.zzb;
                                                                        int i89 = zzk.zzc;
                                                                        i28 = zzk.zzd;
                                                                        list2 = zzo4;
                                                                        i50 = i87;
                                                                        i54 = i88;
                                                                        i53 = i89;
                                                                        str11 = MimeTypes.VIDEO_APV;
                                                                        b5 = b2;
                                                                    } else if (zzg10 == 1668246642) {
                                                                        if (i54 == -1) {
                                                                            if (i51 == -1) {
                                                                                int zzg14 = zzenVar.zzg();
                                                                                if (zzg14 == 1852009592 || zzg14 == 1852009571) {
                                                                                    int zzq5 = zzenVar.zzq();
                                                                                    int zzq6 = zzenVar.zzq();
                                                                                    zzenVar.zzM(2);
                                                                                    if (i21 == 19) {
                                                                                        if ((zzenVar.zzm() & 128) != 0) {
                                                                                            i21 = 19;
                                                                                            z5 = true;
                                                                                            i54 = zzk.zza(zzq5);
                                                                                            i53 = true == z5 ? 2 : 1;
                                                                                            i50 = i23;
                                                                                            i52 = i25;
                                                                                            b5 = b2;
                                                                                            i51 = zzk.zzb(zzq6);
                                                                                        } else {
                                                                                            i21 = 19;
                                                                                        }
                                                                                    }
                                                                                    z5 = false;
                                                                                    i54 = zzk.zza(zzq5);
                                                                                    i53 = true == z5 ? 2 : 1;
                                                                                    i50 = i23;
                                                                                    i52 = i25;
                                                                                    b5 = b2;
                                                                                    i51 = zzk.zzb(zzq6);
                                                                                } else {
                                                                                    zzea.zzf("BoxParsers", "Unsupported color type: ".concat(zzff.zze(zzg14)));
                                                                                    i51 = -1;
                                                                                    i54 = -1;
                                                                                }
                                                                            } else {
                                                                                i54 = -1;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                str11 = str6;
                                                            }
                                                            b3 = b4;
                                                            i50 = i23;
                                                            i52 = i25;
                                                            i53 = i26;
                                                            b5 = b2;
                                                        }
                                                        i51 = i28;
                                                        i52 = i27;
                                                    }
                                                    i50 = i23;
                                                    i52 = i25;
                                                    i53 = i26;
                                                    b5 = b2;
                                                }
                                                break;
                                            }
                                            int i90 = zzc5 + 8;
                                            zzadz.zzc(str11 == null, null);
                                            zzenVar.zzL(i90);
                                            zzacz zza10 = zzacz.zza(zzenVar);
                                            List list4 = zza10.zza;
                                            zzaisVar2.zzc = zza10.zzb;
                                            if (z14) {
                                                z11 = true;
                                            } else {
                                                f = zza10.zzk;
                                                z11 = false;
                                            }
                                            String str15 = zza10.zzl;
                                            int i91 = zza10.zzj;
                                            int i92 = zza10.zzg;
                                            i53 = zza10.zzh;
                                            int i93 = zza10.zzi;
                                            int i94 = zza10.zze;
                                            i50 = zza10.zzf;
                                            i56 = i91;
                                            i51 = i93;
                                            i54 = i92;
                                            str11 = "video/avc";
                                            i24 = i16;
                                            str12 = str15;
                                            str5 = str9;
                                            z14 = z11;
                                            zzaisVar = zzaisVar2;
                                            zzfsVar = zzfsVar3;
                                            i52 = i94;
                                            b3 = b4;
                                            list2 = list4;
                                            i48 = i20 + i21;
                                            b4 = b3;
                                            zzg7 = i22;
                                            zzaisVar2 = zzaisVar;
                                            i16 = i24;
                                            zzfsVar3 = zzfsVar;
                                            str9 = str5;
                                        }
                                        int i95 = i50;
                                        i17 = zzg7;
                                        int i96 = i52;
                                        zzais zzaisVar3 = zzaisVar2;
                                        int i97 = i53;
                                        byte b7 = b5;
                                        b = b4;
                                        c = 65535;
                                        c2 = '\f';
                                        i18 = 8;
                                        if (str11 == null) {
                                            str4 = str10;
                                            i19 = i49;
                                            i7 = i47;
                                            zzaisVar2 = zzaisVar3;
                                        } else {
                                            zzx zzxVar = new zzx();
                                            i7 = i47;
                                            zzxVar.zzR(i7);
                                            zzxVar.zzah(str11);
                                            zzxVar.zzE(str12);
                                            zzxVar.zzam(zzq3);
                                            zzxVar.zzQ(zzq4);
                                            zzxVar.zzK(i58);
                                            zzxVar.zzJ(i57);
                                            zzxVar.zzad(f);
                                            i19 = i49;
                                            zzxVar.zzag(i19);
                                            zzxVar.zzae(bArr2);
                                            zzxVar.zzak(b7);
                                            zzxVar.zzT(list2);
                                            zzxVar.zzY(i56);
                                            zzxVar.zzZ(i55);
                                            zzxVar.zzL(zzsVar3);
                                            str4 = str10;
                                            zzxVar.zzW(str4);
                                            zzi zziVar = new zzi();
                                            zziVar.zzc(i54);
                                            zziVar.zzb(i97);
                                            zziVar.zzd(i51);
                                            zziVar.zze(byteBuffer != null ? byteBuffer.array() : null);
                                            zziVar.zzf(i96);
                                            zziVar.zza(i95);
                                            zzxVar.zzF(zziVar.zzg());
                                            if (zzailVar != null) {
                                                j11 = zzailVar.zza;
                                                zzxVar.zzC(zzgbt.zzf(j11));
                                                j12 = zzailVar.zzb;
                                                zzxVar.zzac(zzgbt.zzf(j12));
                                            } else if (zzainVar != null) {
                                                j9 = zzainVar.zzc;
                                                zzxVar.zzC(zzgbt.zzf(j9));
                                                j10 = zzainVar.zzd;
                                                zzxVar.zzac(zzgbt.zzf(j10));
                                            }
                                            zzaisVar2 = zzaisVar3;
                                            zzaisVar2.zzb = zzxVar.zzan();
                                        }
                                    } else if (zzg8 == 1836069985 || zzg8 == 1701733217 || zzg8 == 1633889587 || zzg8 == 1700998451 || zzg8 == 1633889588 || zzg8 == 1835823201 || zzg8 == 1685353315 || zzg8 == 1685353317 || zzg8 == 1685353320 || zzg8 == 1685353324 || zzg8 == 1685353336 || zzg8 == 1935764850 || zzg8 == 1935767394 || zzg8 == 1819304813 || zzg8 == 1936684916 || zzg8 == 1953984371 || zzg8 == 778924082 || zzg8 == 778924083 || zzg8 == 1835557169 || zzg8 == 1835560241 || zzg8 == 1634492771 || zzg8 == 1634492791 || zzg8 == 1970037111 || zzg8 == 1332770163 || zzg8 == 1716281667 || zzg8 == 1767992678 || zzg8 == 1768973165 || zzg8 == 1718641517) {
                                        i12 = i42;
                                        zzq(zzenVar4, zzg8, zzc3, zzg7, i7, str2, z2, zzsVar, zzaisVar2, i41);
                                        zzenVar = zzenVar4;
                                        i15 = zzc3;
                                        i17 = zzg7;
                                        str4 = str2;
                                        i13 = i41;
                                        arrayList2 = arrayList4;
                                        i19 = i8;
                                        c = 65535;
                                        zzfcVar3 = zzfcVar5;
                                        i14 = zzg6;
                                        b = 3;
                                        c2 = '\f';
                                        i18 = 8;
                                    } else {
                                        if (zzg8 == 1414810956 || zzg8 == 1954034535 || zzg8 == 2004251764 || zzg8 == 1937010800 || zzg8 == 1664495672) {
                                            zzenVar4.zzL(zzc3 + 16);
                                            if (zzg8 == 1414810956) {
                                                str8 = "application/ttml+xml";
                                            } else if (zzg8 == 1954034535) {
                                                int i98 = zzg7 - 16;
                                                byte[] bArr7 = new byte[i98];
                                                zzenVar4.zzH(bArr7, 0, i98);
                                                zzo = zzfyq.zzo(bArr7);
                                                str8 = "application/x-quicktime-tx3g";
                                                j13 = Long.MAX_VALUE;
                                                zzx zzxVar2 = new zzx();
                                                zzxVar2.zzR(i7);
                                                zzxVar2.zzah(str8);
                                                zzxVar2.zzW(str2);
                                                zzxVar2.zzal(j13);
                                                zzxVar2.zzT(zzo);
                                                zzaisVar2.zzb = zzxVar2.zzan();
                                            } else if (zzg8 == 2004251764) {
                                                str8 = "application/x-mp4-vtt";
                                            } else if (zzg8 == 1937010800) {
                                                str8 = "application/ttml+xml";
                                                j13 = 0;
                                                zzo = null;
                                                zzx zzxVar22 = new zzx();
                                                zzxVar22.zzR(i7);
                                                zzxVar22.zzah(str8);
                                                zzxVar22.zzW(str2);
                                                zzxVar22.zzal(j13);
                                                zzxVar22.zzT(zzo);
                                                zzaisVar2.zzb = zzxVar22.zzan();
                                            } else {
                                                zzaisVar2.zzd = 1;
                                                str8 = "application/x-mp4-cea-608";
                                            }
                                            j13 = Long.MAX_VALUE;
                                            zzo = null;
                                            zzx zzxVar222 = new zzx();
                                            zzxVar222.zzR(i7);
                                            zzxVar222.zzah(str8);
                                            zzxVar222.zzW(str2);
                                            zzxVar222.zzal(j13);
                                            zzxVar222.zzT(zzo);
                                            zzaisVar2.zzb = zzxVar222.zzan();
                                        } else if (zzg8 == 1835365492) {
                                            zzenVar4.zzL(zzc3 + 16);
                                            char c5 = r33;
                                            zzenVar4.zzy(c5);
                                            String zzy = zzenVar4.zzy(c5);
                                            if (zzy != null) {
                                                zzx zzxVar3 = new zzx();
                                                zzxVar3.zzR(i7);
                                                zzxVar3.zzah(zzy);
                                                zzaisVar2.zzb = zzxVar3.zzan();
                                            }
                                        } else if (zzg8 == 1667329389) {
                                            zzx zzxVar4 = new zzx();
                                            zzxVar4.zzR(i7);
                                            zzxVar4.zzah("application/x-camera-motion");
                                            zzaisVar2.zzb = zzxVar4.zzan();
                                        }
                                        zzenVar = zzenVar4;
                                        i15 = zzc3;
                                        i17 = zzg7;
                                        str4 = str2;
                                        arrayList2 = arrayList4;
                                        i19 = i8;
                                        zzfcVar3 = zzfcVar5;
                                        i14 = zzg6;
                                        i12 = i42;
                                        i18 = i43;
                                        b = 3;
                                        c = 65535;
                                        c2 = '\f';
                                        i13 = i41;
                                    }
                                    zzenVar.zzL(i15 + i17);
                                    i41 = i13 + 1;
                                    zzenVar4 = zzenVar;
                                    i8 = i19;
                                    str2 = str4;
                                    i37 = i12;
                                    zzg6 = i14;
                                    i40 = i18;
                                    arrayList4 = arrayList2;
                                    zzfcVar5 = zzfcVar3;
                                    z13 = true;
                                    r33 = 0;
                                }
                                int i99 = i37;
                                int i100 = i40;
                                arrayList = arrayList4;
                                zzfc zzfcVar6 = zzfcVar5;
                                if (z) {
                                    zzfcVar2 = zzfcVar6;
                                } else {
                                    zzfcVar2 = zzfcVar6;
                                    zzfc zza11 = zzfcVar2.zza(1701082227);
                                    if (zza11 != null) {
                                        zzfd zzb8 = zza11.zzb(1701606260);
                                        if (zzb8 == null) {
                                            create = null;
                                        } else {
                                            zzen zzenVar5 = zzb8.zza;
                                            zzenVar5.zzL(i100);
                                            int zza12 = zza(zzenVar5.zzg());
                                            int zzp3 = zzenVar5.zzp();
                                            long[] jArr3 = new long[zzp3];
                                            long[] jArr4 = new long[zzp3];
                                            for (int i101 = 0; i101 < zzp3; i101++) {
                                                jArr3[i101] = zza12 == 1 ? zzenVar5.zzw() : zzenVar5.zzu();
                                                jArr4[i101] = zza12 == 1 ? zzenVar5.zzt() : zzenVar5.zzg();
                                                if (zzenVar5.zzE() != 1) {
                                                    throw new IllegalArgumentException("Unsupported media rate.");
                                                }
                                                zzenVar5.zzM(2);
                                            }
                                            create = Pair.create(jArr3, jArr4);
                                        }
                                        if (create != null) {
                                            long[] jArr5 = (long[]) create.first;
                                            jArr2 = (long[]) create.second;
                                            jArr = jArr5;
                                            zzzVar = zzaisVar2.zzb;
                                            if (zzzVar != null) {
                                                zzfveVar2 = zzfveVar;
                                            } else {
                                                i9 = zzaivVar.zzc;
                                                if (i9 != 0) {
                                                    i11 = zzaivVar.zzc;
                                                    zzfb zzfbVar = new zzfb(i11);
                                                    zzx zzb9 = zzzVar.zzb();
                                                    zzav zzavVar = zzzVar.zzl;
                                                    zzb9.zzaa(zzavVar != null ? zzavVar.zzc(zzfbVar) : new zzav(-9223372036854775807L, zzfbVar));
                                                    zzzVar = zzb9.zzan();
                                                }
                                                i10 = zzaivVar.zza;
                                                j7 = zzaipVar.zza;
                                                j8 = zzaipVar.zzb;
                                                zzajp zzajpVar3 = new zzajp(i10, i99, j7, j4, zzu, j8, zzzVar, zzaisVar2.zzd, zzaisVar2.zza, zzaisVar2.zzc, jArr, jArr2);
                                                zzfveVar2 = zzfveVar;
                                                zzajpVar = zzajpVar3;
                                                zzajpVar2 = (zzajp) zzfveVar2.apply(zzajpVar);
                                                if (zzajpVar2 == null) {
                                                    zzfc zza13 = zzfcVar2.zza(1835297121);
                                                    zza13.getClass();
                                                    zzfc zza14 = zza13.zza(1835626086);
                                                    zza14.getClass();
                                                    zzfc zza15 = zza14.zza(1937007212);
                                                    zza15.getClass();
                                                    zzajs zze = zze(zzajpVar2, zza15, zzaejVar);
                                                    arrayList3 = arrayList;
                                                    arrayList3.add(zze);
                                                } else {
                                                    arrayList3 = arrayList;
                                                }
                                            }
                                        }
                                    }
                                }
                                jArr = null;
                                jArr2 = null;
                                zzzVar = zzaisVar2.zzb;
                                if (zzzVar != null) {
                                }
                            } else {
                                zzg4 = i35;
                                zzg3 = 65536;
                            }
                        }
                        zzg2 = 0;
                    }
                    if (zzg2 == 0) {
                        if (zzg3 == -65536) {
                            if (zzg4 != 65536) {
                                if (zzg4 == -65536) {
                                    z3 = zzg5 != 0;
                                    zzg4 = -65536;
                                }
                                zzg3 = -65536;
                            } else {
                                z3 = zzg5 != 0;
                            }
                            if (true != z3) {
                                i2 = 270;
                                i3 = i2;
                                zzaiv zzaivVar2 = new zzaiv(zzg, j2, zzq, i3);
                                if (j != -9223372036854775807L) {
                                }
                                long j152 = zzd(zzb3.zza).zzc;
                                if (j3 != -9223372036854775807L) {
                                }
                                zzfc zza52 = zza3.zza(1835626086);
                                zza52.getClass();
                                zzfc zza62 = zza52.zza(1937007212);
                                zza62.getClass();
                                zzfd zzb62 = zza3.zzb(1835296868);
                                zzb62.getClass();
                                zzen zzenVar32 = zzb62.zza;
                                zzenVar32.zzL(8);
                                zza2 = zza(zzenVar32.zzg());
                                zzenVar32.zzM(zza2 != 0 ? 8 : 16);
                                long zzu32 = zzenVar32.zzu();
                                int zzc22 = zzenVar32.zzc();
                                i4 = 0;
                                while (true) {
                                    if (zza2 != 0) {
                                    }
                                    if (i4 < i5) {
                                    }
                                    i4++;
                                }
                                int zzq22 = zzenVar32.zzq();
                                char[] cArr2 = {(char) (((zzq22 >> 10) & 31) + 96), (char) (((zzq22 >> 5) & 31) + 96), (char) ((zzq22 & 31) + 96)};
                                while (i6 < 3) {
                                }
                                str = new String(cArr2);
                                zzaip zzaipVar2 = new zzaip(j5, j6, str);
                                zzb2 = zza62.zzb(1937011556);
                                if (zzb2 != null) {
                                }
                            }
                            zzg3 = -65536;
                        }
                        zzg2 = 0;
                    }
                    if ((zzg2 == -65536 || zzg2 == 65536) && zzg3 == 0 && zzg4 == 0 && zzg5 == -65536) {
                        i2 = 180;
                        i3 = i2;
                        zzaiv zzaivVar22 = new zzaiv(zzg, j2, zzq, i3);
                        if (j != -9223372036854775807L) {
                        }
                        long j1522 = zzd(zzb3.zza).zzc;
                        if (j3 != -9223372036854775807L) {
                        }
                        zzfc zza522 = zza3.zza(1835626086);
                        zza522.getClass();
                        zzfc zza622 = zza522.zza(1937007212);
                        zza622.getClass();
                        zzfd zzb622 = zza3.zzb(1835296868);
                        zzb622.getClass();
                        zzen zzenVar322 = zzb622.zza;
                        zzenVar322.zzL(8);
                        zza2 = zza(zzenVar322.zzg());
                        zzenVar322.zzM(zza2 != 0 ? 8 : 16);
                        long zzu322 = zzenVar322.zzu();
                        int zzc222 = zzenVar322.zzc();
                        i4 = 0;
                        while (true) {
                            if (zza2 != 0) {
                            }
                            if (i4 < i5) {
                            }
                            i4++;
                        }
                        int zzq222 = zzenVar322.zzq();
                        char[] cArr22 = {(char) (((zzq222 >> 10) & 31) + 96), (char) (((zzq222 >> 5) & 31) + 96), (char) ((zzq222 & 31) + 96)};
                        while (i6 < 3) {
                        }
                        str = new String(cArr22);
                        zzaip zzaipVar22 = new zzaip(j5, j6, str);
                        zzb2 = zza622.zzb(1937011556);
                        if (zzb2 != null) {
                        }
                    } else {
                        i3 = 0;
                        zzaiv zzaivVar222 = new zzaiv(zzg, j2, zzq, i3);
                        if (j != -9223372036854775807L) {
                        }
                        long j15222 = zzd(zzb3.zza).zzc;
                        if (j3 != -9223372036854775807L) {
                        }
                        zzfc zza5222 = zza3.zza(1835626086);
                        zza5222.getClass();
                        zzfc zza6222 = zza5222.zza(1937007212);
                        zza6222.getClass();
                        zzfd zzb6222 = zza3.zzb(1835296868);
                        zzb6222.getClass();
                        zzen zzenVar3222 = zzb6222.zza;
                        zzenVar3222.zzL(8);
                        zza2 = zza(zzenVar3222.zzg());
                        zzenVar3222.zzM(zza2 != 0 ? 8 : 16);
                        long zzu3222 = zzenVar3222.zzu();
                        int zzc2222 = zzenVar3222.zzc();
                        i4 = 0;
                        while (true) {
                            if (zza2 != 0) {
                            }
                            if (i4 < i5) {
                            }
                            i4++;
                        }
                        int zzq2222 = zzenVar3222.zzq();
                        char[] cArr222 = {(char) (((zzq2222 >> 10) & 31) + 96), (char) (((zzq2222 >> 5) & 31) + 96), (char) ((zzq2222 & 31) + 96)};
                        while (i6 < 3) {
                        }
                        str = new String(cArr222);
                        zzaip zzaipVar222 = new zzaip(j5, j6, str);
                        zzb2 = zza6222.zzb(1937011556);
                        if (zzb2 != null) {
                        }
                    }
                }
                zzajpVar = null;
                zzajpVar2 = (zzajp) zzfveVar2.apply(zzajpVar);
                if (zzajpVar2 == null) {
                }
            }
            i36 = i + 1;
            zzfcVar4 = zzfcVar;
            arrayList4 = arrayList3;
        }
    }

    public static void zzg(zzen zzenVar) {
        int zzc = zzenVar.zzc();
        zzenVar.zzM(4);
        if (zzenVar.zzg() != 1751411826) {
            zzc += 4;
        }
        zzenVar.zzL(zzc);
    }

    private static int zzh(zzen zzenVar) {
        int zzm = zzenVar.zzm();
        int i = zzm & 127;
        while ((zzm & 128) == 128) {
            zzm = zzenVar.zzm();
            i = (i << 7) | (zzm & 127);
        }
        return i;
    }

    private static int zzi(zzen zzenVar) {
        zzenVar.zzL(16);
        return zzenVar.zzg();
    }

    private static Pair zzj(zzen zzenVar, int i, int i2) throws zzaz {
        Integer num;
        zzajq zzajqVar;
        Pair create;
        int i3;
        int i4;
        Integer num2;
        boolean z;
        int zzc = zzenVar.zzc();
        while (zzc - i < i2) {
            zzenVar.zzL(zzc);
            int zzg = zzenVar.zzg();
            zzadz.zzc(zzg > 0, "childAtomSize must be positive");
            if (zzenVar.zzg() == 1936289382) {
                int i5 = zzc + 8;
                int i6 = 0;
                int i7 = -1;
                Integer num3 = null;
                String str = null;
                while (i5 - zzc < zzg) {
                    zzenVar.zzL(i5);
                    int zzg2 = zzenVar.zzg();
                    int zzg3 = zzenVar.zzg();
                    if (zzg3 == 1718775137) {
                        num3 = Integer.valueOf(zzenVar.zzg());
                    } else if (zzg3 == 1935894637) {
                        zzenVar.zzM(4);
                        str = zzenVar.zzB(4, StandardCharsets.UTF_8);
                    } else if (zzg3 == 1935894633) {
                        i7 = i5;
                        i6 = zzg2;
                    }
                    i5 += zzg2;
                }
                byte[] bArr = null;
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    zzadz.zzc(num3 != null, "frma atom is mandatory");
                    zzadz.zzc(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = num3;
                            zzajqVar = null;
                            break;
                        }
                        zzenVar.zzL(i8);
                        int zzg4 = zzenVar.zzg();
                        if (zzenVar.zzg() == 1952804451) {
                            int zza2 = zza(zzenVar.zzg());
                            zzenVar.zzM(1);
                            if (zza2 == 0) {
                                zzenVar.zzM(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzm = zzenVar.zzm();
                                i3 = zzm & 15;
                                i4 = (zzm & 240) >> 4;
                            }
                            if (zzenVar.zzm() == 1) {
                                num2 = num3;
                                z = true;
                            } else {
                                num2 = num3;
                                z = false;
                            }
                            int zzm2 = zzenVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzenVar.zzH(bArr2, 0, 16);
                            if (z && zzm2 == 0) {
                                int zzm3 = zzenVar.zzm();
                                byte[] bArr3 = new byte[zzm3];
                                zzenVar.zzH(bArr3, 0, zzm3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzajqVar = new zzajq(z, str, zzm2, bArr2, i4, i3, bArr);
                        } else {
                            i8 += zzg4;
                        }
                    }
                    zzadz.zzc(zzajqVar != null, "tenc atom is mandatory");
                    String str2 = zzex.zza;
                    create = Pair.create(num, zzajqVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            zzc += zzg;
        }
        return null;
    }

    private static zzk zzk(zzen zzenVar) {
        zzi zziVar = new zzi();
        byte[] zzN = zzenVar.zzN();
        zzem zzemVar = new zzem(zzN, zzN.length);
        zzemVar.zzl(zzenVar.zzc() * 8);
        zzemVar.zzo(1);
        int zzd = zzemVar.zzd(8);
        for (int i = 0; i < zzd; i++) {
            zzemVar.zzo(1);
            int zzd2 = zzemVar.zzd(8);
            for (int i2 = 0; i2 < zzd2; i2++) {
                zzemVar.zzn(6);
                boolean zzp = zzemVar.zzp();
                zzemVar.zzm();
                zzemVar.zzo(11);
                zzemVar.zzn(4);
                int zzd3 = zzemVar.zzd(4) + 8;
                zziVar.zzf(zzd3);
                zziVar.zza(zzd3);
                zzemVar.zzo(1);
                if (zzp) {
                    int zzd4 = zzemVar.zzd(8);
                    int zzd5 = zzemVar.zzd(8);
                    zzemVar.zzo(1);
                    boolean zzp2 = zzemVar.zzp();
                    zziVar.zzc(zzk.zza(zzd4));
                    zziVar.zzb(true != zzp2 ? 2 : 1);
                    zziVar.zzd(zzk.zzb(zzd5));
                }
            }
        }
        return zziVar.zzg();
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0141, code lost:
    
        if (r6 == 1) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static zzk zzl(zzen zzenVar) {
        int i;
        int zzd;
        int zzd2;
        zzi zziVar = new zzi();
        byte[] zzN = zzenVar.zzN();
        zzem zzemVar = new zzem(zzN, zzN.length);
        zzemVar.zzl(zzenVar.zzc() * 8);
        zzemVar.zzo(1);
        int zzd3 = zzemVar.zzd(3);
        zzemVar.zzn(6);
        boolean zzp = zzemVar.zzp();
        boolean zzp2 = zzemVar.zzp();
        boolean z = false;
        if (zzd3 == 2) {
            if (zzp) {
                i = true == zzp2 ? 12 : 10;
                zziVar.zzf(i);
                zziVar.zza(i);
                int i2 = 13;
                zzemVar.zzn(13);
                zzemVar.zzm();
                zzd = zzemVar.zzd(4);
                if (zzd == 1) {
                    zzea.zze("BoxParsers", "Unsupported obu_type: " + zzd);
                    return zziVar.zzg();
                }
                if (zzemVar.zzp()) {
                    zzea.zze("BoxParsers", "Unsupported obu_extension_flag");
                    return zziVar.zzg();
                }
                boolean zzp3 = zzemVar.zzp();
                zzemVar.zzm();
                if (zzp3 && zzemVar.zzd(8) > 127) {
                    zzea.zze("BoxParsers", "Excessive obu_size");
                    return zziVar.zzg();
                }
                int zzd4 = zzemVar.zzd(3);
                zzemVar.zzm();
                if (zzemVar.zzp()) {
                    zzea.zze("BoxParsers", "Unsupported reduced_still_picture_header");
                    return zziVar.zzg();
                }
                if (zzemVar.zzp()) {
                    zzea.zze("BoxParsers", "Unsupported timing_info_present_flag");
                    return zziVar.zzg();
                }
                if (zzemVar.zzp()) {
                    zzea.zze("BoxParsers", "Unsupported initial_display_delay_present_flag");
                    return zziVar.zzg();
                }
                int zzd5 = zzemVar.zzd(5);
                for (int i3 = 0; i3 <= zzd5; i3++) {
                    zzemVar.zzn(12);
                    if (zzemVar.zzd(5) > 7) {
                        zzemVar.zzm();
                    }
                }
                int zzd6 = zzemVar.zzd(4);
                int zzd7 = zzemVar.zzd(4);
                zzemVar.zzn(zzd6 + 1);
                zzemVar.zzn(zzd7 + 1);
                if (zzemVar.zzp()) {
                    zzemVar.zzn(7);
                }
                zzemVar.zzn(7);
                boolean zzp4 = zzemVar.zzp();
                if (zzp4) {
                    zzemVar.zzn(2);
                }
                if ((zzemVar.zzp() || zzemVar.zzd(1) > 0) && !zzemVar.zzp()) {
                    zzemVar.zzn(1);
                }
                if (zzp4) {
                    zzemVar.zzn(3);
                }
                zzemVar.zzn(3);
                boolean zzp5 = zzemVar.zzp();
                if (zzd4 == 2) {
                    if (zzp5) {
                        zzemVar.zzm();
                    }
                }
                if (zzemVar.zzp()) {
                    z = true;
                }
                if (zzemVar.zzp()) {
                    int zzd8 = zzemVar.zzd(8);
                    int zzd9 = zzemVar.zzd(8);
                    int zzd10 = zzemVar.zzd(8);
                    if (!z && zzd8 == 1) {
                        if (zzd9 != 13) {
                            zzd8 = 1;
                        } else if (zzd10 == 0) {
                            zzd2 = 1;
                            zzd8 = 1;
                            zziVar.zzc(zzk.zza(zzd8));
                            zziVar.zzb(zzd2 != 1 ? 2 : 1);
                            zziVar.zzd(zzk.zzb(i2));
                        } else {
                            zzd8 = 1;
                            zzd2 = zzemVar.zzd(1);
                            zziVar.zzc(zzk.zza(zzd8));
                            zziVar.zzb(zzd2 != 1 ? 2 : 1);
                            zziVar.zzd(zzk.zzb(i2));
                        }
                    }
                    i2 = zzd9;
                    zzd2 = zzemVar.zzd(1);
                    zziVar.zzc(zzk.zza(zzd8));
                    zziVar.zzb(zzd2 != 1 ? 2 : 1);
                    zziVar.zzd(zzk.zzb(i2));
                }
                return zziVar.zzg();
            }
            zzp = false;
            zzd3 = 2;
        }
        if (zzd3 <= 2) {
            i = true != zzp ? 8 : 10;
            zziVar.zzf(i);
            zziVar.zza(i);
        }
        int i22 = 13;
        zzemVar.zzn(13);
        zzemVar.zzm();
        zzd = zzemVar.zzd(4);
        if (zzd == 1) {
        }
    }

    private static zzav zzm(zzen zzenVar) {
        short zzE = zzenVar.zzE();
        zzenVar.zzM(2);
        String zzB = zzenVar.zzB(zzE, StandardCharsets.UTF_8);
        int max = Math.max(zzB.lastIndexOf(43), zzB.lastIndexOf(45));
        try {
            return new zzav(-9223372036854775807L, new zzfg(Float.parseFloat(zzB.substring(0, max)), Float.parseFloat(zzB.substring(max, zzB.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzail zzn(zzen zzenVar, int i) {
        zzenVar.zzL(i + 8);
        zzenVar.zzM(4);
        return new zzail(zzenVar.zzu(), zzenVar.zzu());
    }

    private static zzain zzo(zzen zzenVar, int i) {
        zzenVar.zzL(i + 12);
        zzenVar.zzM(1);
        zzh(zzenVar);
        zzenVar.zzM(2);
        int zzm = zzenVar.zzm();
        if ((zzm & 128) != 0) {
            zzenVar.zzM(2);
        }
        if ((zzm & 64) != 0) {
            zzenVar.zzM(zzenVar.zzm());
        }
        if ((zzm & 32) != 0) {
            zzenVar.zzM(2);
        }
        zzenVar.zzM(1);
        zzh(zzenVar);
        String zzd = zzay.zzd(zzenVar.zzm());
        if ("audio/mpeg".equals(zzd) || "audio/vnd.dts".equals(zzd) || "audio/vnd.dts.hd".equals(zzd)) {
            return new zzain(zzd, null, -1L, -1L);
        }
        zzenVar.zzM(4);
        long zzu = zzenVar.zzu();
        long zzu2 = zzenVar.zzu();
        zzenVar.zzM(1);
        int zzh = zzh(zzenVar);
        long j = zzu2;
        byte[] bArr = new byte[zzh];
        zzenVar.zzH(bArr, 0, zzh);
        if (j <= 0) {
            j = -1;
        }
        return new zzain(zzd, bArr, j, zzu > 0 ? zzu : -1L);
    }

    private static ByteBuffer zzp() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:231:0x016a, code lost:
    
        if (r11 == (-1)) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzq(zzen zzenVar, int i, int i2, int i3, int i4, String str, boolean z, zzs zzsVar, zzais zzaisVar, int i5) throws zzaz {
        int i6;
        int zzq;
        int zzn;
        int zzg;
        int i7;
        int i8;
        String str2;
        long j;
        long j2;
        long j3;
        long j4;
        int i9;
        int i10;
        int i11;
        int i12;
        String str3;
        byte[] bArr;
        int i13;
        int i14;
        int i15;
        boolean z2;
        boolean z3;
        zzen zzenVar2 = zzenVar;
        int i16 = i;
        int i17 = i3;
        zzs zzsVar2 = zzsVar;
        zzenVar2.zzL(i2 + 16);
        if (z) {
            i6 = zzenVar2.zzq();
            zzenVar2.zzM(6);
        } else {
            zzenVar2.zzM(8);
            i6 = 0;
        }
        if (i6 == 0 || i6 == 1) {
            zzq = zzenVar2.zzq();
            zzenVar2.zzM(6);
            zzn = zzenVar2.zzn();
            zzenVar2.zzL(zzenVar2.zzc() - 4);
            zzg = zzenVar2.zzg();
            i7 = 2;
            if (i6 == 1) {
                zzenVar2.zzM(16);
            }
            i8 = -1;
        } else {
            if (i6 != 2) {
                return;
            }
            zzenVar2.zzM(16);
            zzn = (int) Math.round(Double.longBitsToDouble(zzenVar2.zzt()));
            int zzp = zzenVar2.zzp();
            zzenVar2.zzM(4);
            int zzp2 = zzenVar2.zzp();
            int zzp3 = zzenVar2.zzp();
            int i18 = zzp3 & 1;
            int i19 = zzp3 & 2;
            if (i18 == 0) {
                if (zzp2 == 8) {
                    i8 = 3;
                } else if (zzp2 == 16) {
                    i8 = i19 != 0 ? 268435456 : 2;
                } else if (zzp2 == 24) {
                    i8 = i19 != 0 ? C.ENCODING_PCM_24BIT_BIG_ENDIAN : 21;
                } else {
                    if (zzp2 == 32) {
                        i8 = i19 != 0 ? C.ENCODING_PCM_32BIT_BIG_ENDIAN : 22;
                    }
                    i8 = -1;
                }
                zzenVar2.zzM(8);
                zzq = zzp;
                i7 = 2;
                zzg = 0;
            } else {
                if (zzp2 == 32) {
                    i8 = 4;
                    zzenVar2.zzM(8);
                    zzq = zzp;
                    i7 = 2;
                    zzg = 0;
                }
                i8 = -1;
                zzenVar2.zzM(8);
                zzq = zzp;
                i7 = 2;
                zzg = 0;
            }
        }
        if (i16 == 1767992678) {
            zzn = -1;
            zzq = -1;
        } else {
            if (i16 == 1935764850) {
                zzn = 8000;
            } else if (i16 == 1935767394) {
                zzn = 16000;
                i16 = 1935767394;
            }
            zzq = 1;
        }
        int zzc = zzenVar2.zzc();
        int i20 = 1701733217;
        if (i16 == 1701733217) {
            Pair zzj = zzj(zzenVar2, i2, i17);
            if (zzj != null) {
                i20 = ((Integer) zzj.first).intValue();
                zzsVar2 = zzsVar2 == null ? null : zzsVar2.zzb(((zzajq) zzj.second).zzb);
                zzaisVar.zza[i5] = (zzajq) zzj.second;
            }
            i16 = i20;
            zzenVar2.zzL(zzc);
        }
        if (i16 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i16 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i16 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i16 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i16 == 1685353320 || i16 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i16 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i16 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i16 == 1935764850) {
            str2 = "audio/3gpp";
        } else if (i16 == 1935767394) {
            str2 = "audio/amr-wb";
        } else {
            if (i16 != 1936684916) {
                if (i16 == 1953984371) {
                    str2 = "audio/raw";
                    i8 = 268435456;
                } else if (i16 != 1819304813) {
                    if (i16 == 778924082 || i16 == 778924083) {
                        str2 = "audio/mpeg";
                    } else if (i16 == 1835557169) {
                        str2 = "audio/mha1";
                    } else if (i16 == 1835560241) {
                        str2 = "audio/mhm1";
                    } else if (i16 == 1634492771) {
                        str2 = "audio/alac";
                    } else if (i16 == 1634492791) {
                        str2 = "audio/g711-alaw";
                    } else if (i16 == 1970037111) {
                        str2 = "audio/g711-mlaw";
                    } else if (i16 == 1332770163) {
                        str2 = "audio/opus";
                    } else if (i16 == 1716281667) {
                        str2 = "audio/flac";
                    } else if (i16 == 1835823201) {
                        str2 = "audio/true-hd";
                    } else if (i16 == 1767992678) {
                        str2 = MimeTypes.AUDIO_IAMF;
                        i16 = 1767992678;
                    } else {
                        str2 = null;
                    }
                }
            }
            i8 = i7;
            str2 = "audio/raw";
        }
        int i21 = i8;
        List list = null;
        String str4 = null;
        zzain zzainVar = null;
        zzail zzailVar = null;
        while (zzc - i2 < i17) {
            zzenVar2.zzL(zzc);
            int zzg2 = zzenVar2.zzg();
            String str5 = str4;
            zzadz.zzc(zzg2 > 0, "childAtomSize must be positive");
            int zzg3 = zzenVar2.zzg();
            int i22 = zzn;
            if (zzg3 == 1835557187) {
                zzenVar2.zzL(zzc + 8);
                zzenVar2.zzM(1);
                int zzm = zzenVar2.zzm();
                zzenVar2.zzM(1);
                String format = Objects.equals(str2, "audio/mhm1") ? String.format("mhm1.%02X", Integer.valueOf(zzm)) : String.format("mha1.%02X", Integer.valueOf(zzm));
                int zzq2 = zzenVar2.zzq();
                byte[] bArr2 = new byte[zzq2];
                str5 = format;
                z3 = false;
                zzenVar2.zzH(bArr2, 0, zzq2);
                if (list == null) {
                    list = zzfyq.zzo(bArr2);
                    zzn = i22;
                    i12 = i16;
                    i9 = zzg;
                    str4 = str5;
                } else {
                    list = zzfyq.zzp(bArr2, (byte[]) list.get(0));
                    str4 = str5;
                    zzn = i22;
                    i12 = i16;
                    i9 = zzg;
                }
            } else if (zzg3 == 1835557200) {
                zzenVar2.zzL(zzc + 8);
                int zzm2 = zzenVar2.zzm();
                if (zzm2 > 0) {
                    byte[] bArr3 = new byte[zzm2];
                    z3 = false;
                    zzenVar2.zzH(bArr3, 0, zzm2);
                    if (list == null) {
                        list = zzfyq.zzo(bArr3);
                        zzn = i22;
                        i12 = i16;
                        i9 = zzg;
                        str4 = str5;
                    } else {
                        list = zzfyq.zzp((byte[]) list.get(0), bArr3);
                        str4 = str5;
                        zzn = i22;
                        i12 = i16;
                        i9 = zzg;
                    }
                }
                zzn = i22;
                i12 = i16;
                i9 = zzg;
                str4 = str5;
            } else {
                if (zzg3 == 1702061171) {
                    zzn = i22;
                    i9 = zzg;
                    i10 = zzc;
                    i11 = -1;
                } else if (z && zzg3 == 2002876005) {
                    int zzc2 = zzenVar2.zzc();
                    zzadz.zzc(zzc2 >= zzc, null);
                    int i23 = zzc2;
                    while (true) {
                        if (i23 - zzc >= zzg2) {
                            zzn = i22;
                            i9 = zzg;
                            i10 = -1;
                            break;
                        }
                        zzenVar2.zzL(i23);
                        int zzg4 = zzenVar2.zzg();
                        if (zzg4 > 0) {
                            i15 = i23;
                            z2 = true;
                        } else {
                            i15 = i23;
                            z2 = false;
                        }
                        zzadz.zzc(z2, "childAtomSize must be positive");
                        if (zzenVar2.zzg() == 1702061171) {
                            zzn = i22;
                            i9 = zzg;
                            i10 = i15;
                            break;
                        }
                        i23 = i15 + zzg4;
                    }
                    i11 = -1;
                } else if (zzg3 == 1651798644) {
                    zzailVar = zzn(zzenVar2, zzc);
                    str4 = str5;
                    zzn = i22;
                    i12 = i16;
                    i9 = zzg;
                } else {
                    if (zzg3 == 1684103987) {
                        zzenVar2.zzL(zzc + 8);
                        zzaisVar.zzb = zzacu.zzc(zzenVar2, Integer.toString(i4), str, zzsVar2);
                    } else if (zzg3 == 1684366131) {
                        zzenVar2.zzL(zzc + 8);
                        zzaisVar.zzb = zzacu.zzd(zzenVar2, Integer.toString(i4), str, zzsVar2);
                    } else if (zzg3 == 1684103988) {
                        zzenVar2.zzL(zzc + 8);
                        zzaisVar.zzb = zzacy.zza(zzenVar2, Integer.toString(i4), str, zzsVar2);
                    } else if (zzg3 != 1684892784) {
                        if (zzg3 == 1684305011 || zzg3 == 1969517683) {
                            i9 = zzg;
                            zzx zzxVar = new zzx();
                            zzxVar.zzR(i4);
                            zzxVar.zzah(str2);
                            zzxVar.zzD(zzq);
                            zzn = i22;
                            zzxVar.zzai(zzn);
                            zzxVar.zzL(zzsVar2);
                            zzxVar.zzW(str);
                            zzaisVar.zzb = zzxVar.zzan();
                        } else {
                            if (zzg3 == 1682927731) {
                                int i24 = zzg2 - 8;
                                byte[] bArr4 = zzb;
                                int length = bArr4.length;
                                i9 = zzg;
                                byte[] copyOf = Arrays.copyOf(bArr4, length + i24);
                                zzenVar2.zzL(zzc + 8);
                                zzenVar2.zzH(copyOf, length, i24);
                                list = zzaeq.zze(copyOf);
                            } else {
                                i9 = zzg;
                                if (zzg3 == 1684425825) {
                                    byte[] bArr5 = new byte[zzg2 - 8];
                                    bArr5[0] = 102;
                                    bArr5[1] = 76;
                                    bArr5[i7] = 97;
                                    bArr5[3] = 67;
                                    zzenVar2.zzL(zzc + 12);
                                    zzenVar2.zzH(bArr5, 4, zzg2 - 12);
                                    list = zzfyq.zzo(bArr5);
                                } else if (zzg3 == 1634492771) {
                                    int i25 = zzg2 - 12;
                                    byte[] bArr6 = new byte[i25];
                                    zzenVar2.zzL(zzc + 12);
                                    zzenVar2.zzH(bArr6, 0, i25);
                                    int i26 = zzdk.zza;
                                    zzen zzenVar3 = new zzen(bArr6);
                                    zzenVar3.zzL(9);
                                    int zzm3 = zzenVar3.zzm();
                                    zzenVar3.zzL(20);
                                    Pair create = Pair.create(Integer.valueOf(zzenVar3.zzp()), Integer.valueOf(zzm3));
                                    int intValue = ((Integer) create.first).intValue();
                                    str4 = str5;
                                    i12 = i16;
                                    zzq = ((Integer) create.second).intValue();
                                    list = zzfyq.zzo(bArr6);
                                    zzn = intValue;
                                } else if (zzg3 == 1767990114) {
                                    zzenVar2.zzL(zzc + 9);
                                    int zzb2 = zzgbt.zzb(zzenVar2.zzv());
                                    byte[] bArr7 = new byte[zzb2];
                                    zzenVar2.zzH(bArr7, 0, zzb2);
                                    list = zzfyq.zzo(bArr7);
                                } else if (zzg3 == 1885564227) {
                                    zzenVar2.zzL(zzc + 12);
                                    ByteOrder byteOrder = (zzenVar2.zzm() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                    int zzm4 = zzenVar2.zzm();
                                    if (i16 == 1768973165) {
                                        i13 = zzex.zzn(zzm4, byteOrder);
                                        i14 = -1;
                                    } else {
                                        if (i16 == 1718641517 && zzm4 == 32 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) {
                                            i13 = 4;
                                            i14 = -1;
                                        }
                                        i13 = i21;
                                        i14 = -1;
                                    }
                                    str4 = str5;
                                    if (i13 != i14) {
                                        zzn = i22;
                                        i12 = i16;
                                        i21 = i13;
                                        str2 = "audio/raw";
                                    } else {
                                        zzn = i22;
                                        i12 = i16;
                                        i21 = i13;
                                    }
                                } else {
                                    zzn = i22;
                                }
                            }
                            str4 = str5;
                            zzn = i22;
                            i12 = i16;
                        }
                        i12 = i16;
                        str4 = str5;
                    } else {
                        if (zzg <= 0) {
                            throw zzaz.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + zzg, null);
                        }
                        str4 = str5;
                        i12 = i16;
                        zzn = zzg;
                        i9 = zzn;
                        zzq = i7;
                    }
                    zzn = i22;
                    i12 = i16;
                    i9 = zzg;
                    str4 = str5;
                }
                if (i10 != i11) {
                    zzainVar = zzo(zzenVar2, i10);
                    str3 = zzainVar.zza;
                    bArr = zzainVar.zzb;
                    if (bArr == null) {
                        i12 = i16;
                    } else if ("audio/vorbis".equals(str3)) {
                        zzen zzenVar4 = new zzen(bArr);
                        zzenVar4.zzM(1);
                        int i27 = 0;
                        while (zzenVar4.zza() > 0 && zzenVar4.zzf() == 255) {
                            zzenVar4.zzM(1);
                            i27 += 255;
                        }
                        int zzm5 = i27 + zzenVar4.zzm();
                        int i28 = 0;
                        while (true) {
                            if (zzenVar4.zza() <= 0) {
                                i12 = i16;
                                break;
                            }
                            i12 = i16;
                            if (zzenVar4.zzf() != 255) {
                                break;
                            }
                            zzenVar4.zzM(1);
                            i28 += 255;
                            i16 = i12;
                        }
                        int zzm6 = i28 + zzenVar4.zzm();
                        byte[] bArr8 = new byte[zzm5];
                        int zzc3 = zzenVar4.zzc();
                        System.arraycopy(bArr, zzc3, bArr8, 0, zzm5);
                        int i29 = zzc3 + zzm5 + zzm6;
                        int length2 = bArr.length - i29;
                        byte[] bArr9 = new byte[length2];
                        System.arraycopy(bArr, i29, bArr9, 0, length2);
                        list = zzfyq.zzp(bArr8, bArr9);
                    } else {
                        i12 = i16;
                        if ("audio/mp4a-latm".equals(str3)) {
                            zzacp zza2 = zzacr.zza(bArr);
                            zzn = zza2.zza;
                            zzq = zza2.zzb;
                            str4 = zza2.zzc;
                        } else {
                            str4 = str5;
                        }
                        list = zzfyq.zzo(bArr);
                        str2 = str3;
                    }
                    str4 = str5;
                    str2 = str3;
                }
                i12 = i16;
                str4 = str5;
            }
            zzc += zzg2;
            zzenVar2 = zzenVar;
            i17 = i3;
            zzg = i9;
            i16 = i12;
        }
        String str6 = str4;
        if (zzaisVar.zzb != null || str2 == null) {
            return;
        }
        zzx zzxVar2 = new zzx();
        zzxVar2.zzR(i4);
        zzxVar2.zzah(str2);
        zzxVar2.zzE(str6);
        zzxVar2.zzD(zzq);
        zzxVar2.zzai(zzn);
        zzxVar2.zzab(i21);
        zzxVar2.zzT(list);
        zzxVar2.zzL(zzsVar2);
        zzxVar2.zzW(str);
        if (zzainVar != null) {
            j3 = zzainVar.zzc;
            zzxVar2.zzC(zzgbt.zzf(j3));
            j4 = zzainVar.zzd;
            zzxVar2.zzac(zzgbt.zzf(j4));
        } else if (zzailVar != null) {
            j = zzailVar.zza;
            zzxVar2.zzC(zzgbt.zzf(j));
            j2 = zzailVar.zzb;
            zzxVar2.zzac(zzgbt.zzf(j2));
        }
        zzaisVar.zzb = zzxVar2.zzan();
    }
}
