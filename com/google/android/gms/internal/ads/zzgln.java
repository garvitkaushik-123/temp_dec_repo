package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgln {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long zzb = zzb(bArr, 0, 0);
        long zzb2 = zzb(bArr, 3, 2) & 67108611;
        long zzb3 = zzb(bArr, 6, 4) & 67092735;
        long zzb4 = zzb(bArr, 9, 6) & 66076671;
        long zzb5 = zzb(bArr, 12, 8) & 1048575;
        int i = 17;
        byte[] bArr3 = new byte[17];
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            int length = bArr2.length;
            if (i2 >= length) {
                long j6 = j + (j2 >> 26);
                long j7 = j6 & 67108863;
                long j8 = j3 + (j6 >> 26);
                long j9 = j8 & 67108863;
                long j10 = j4 + (j8 >> 26);
                long j11 = j10 & 67108863;
                long j12 = j5 + ((j10 >> 26) * 5);
                long j13 = j12 & 67108863;
                long j14 = j13 + 5;
                long j15 = (j2 & 67108863) + (j12 >> 26);
                long j16 = j15 + (j14 >> 26);
                long j17 = (j16 >> 26) + j7;
                long j18 = j9 + (j17 >> 26);
                long j19 = (j11 + (j18 >> 26)) - 67108864;
                long j20 = j19 >> 63;
                long j21 = ~j20;
                long j22 = (j15 & j20) | (j16 & 67108863 & j21);
                long j23 = (j7 & j20) | (j17 & 67108863 & j21);
                long j24 = (j9 & j20) | (j18 & 67108863 & j21);
                long j25 = (j11 & j20) | (j19 & j21);
                long zzc = (((j20 & j13) | (j14 & 67108863 & j21) | (j22 << 26)) & 4294967295L) + zzc(bArr, 16);
                long zzc2 = (((j22 >> 6) | (j23 << 20)) & 4294967295L) + zzc(bArr, 20);
                long zzc3 = (((j23 >> 12) | (j24 << 14)) & 4294967295L) + zzc(bArr, 24);
                long zzc4 = (((j24 >> 18) | (j25 << 8)) & 4294967295L) + zzc(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, zzc & 4294967295L, 0);
                long j26 = zzc2 + (zzc >> 32);
                zzd(bArr4, j26 & 4294967295L, 4);
                long j27 = zzc3 + (j26 >> 32);
                zzd(bArr4, j27 & 4294967295L, 8);
                zzd(bArr4, (zzc4 + (j27 >> 32)) & 4294967295L, 12);
                return bArr4;
            }
            int min = Math.min(16, length - i2);
            System.arraycopy(bArr2, i2, bArr3, 0, min);
            bArr3[min] = 1;
            if (min != 16) {
                Arrays.fill(bArr3, min + 1, i, (byte) 0);
            }
            long j28 = zzb5 * 5;
            long j29 = zzb4 * 5;
            long j30 = zzb3 * 5;
            long zzb6 = j5 + zzb(bArr3, 0, 0);
            long zzb7 = j2 + zzb(bArr3, 3, 2);
            long zzb8 = j + zzb(bArr3, 6, 4);
            long zzb9 = j3 + zzb(bArr3, 9, 6);
            long zzb10 = j4 + (zzb(bArr3, 12, 8) | (bArr3[16] << Ascii.CAN));
            long j31 = zzb7 * zzb;
            long j32 = zzb7 * zzb2;
            long j33 = zzb7 * zzb3;
            long j34 = zzb9 * zzb;
            long j35 = zzb7 * zzb4;
            long j36 = zzb10 * zzb;
            long j37 = (zzb6 * zzb) + (zzb7 * j28) + (zzb8 * j29) + (zzb9 * j30) + (zzb2 * 5 * zzb10);
            long j38 = (zzb6 * zzb2) + j31 + (zzb8 * j28) + (zzb9 * j29) + (j30 * zzb10) + (j37 >> 26);
            long j39 = (zzb6 * zzb3) + j32 + (zzb8 * zzb) + (zzb9 * j28) + (j29 * zzb10) + (j38 >> 26);
            long j40 = (zzb6 * zzb4) + j33 + (zzb8 * zzb2) + j34 + (zzb10 * j28) + (j39 >> 26);
            long j41 = (zzb6 * zzb5) + j35 + (zzb8 * zzb3) + (zzb9 * zzb2) + j36 + (j40 >> 26);
            long j42 = (j37 & 67108863) + ((j41 >> 26) * 5);
            j2 = (j38 & 67108863) + (j42 >> 26);
            i2 += 16;
            j = j39 & 67108863;
            j3 = j40 & 67108863;
            j4 = j41 & 67108863;
            i = 17;
            j5 = j42 & 67108863;
        }
    }

    private static long zzb(byte[] bArr, int i, int i2) {
        return (zzc(bArr, i) >> i2) & 67108863;
    }

    private static long zzc(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return (((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16)) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i + i2] = (byte) (255 & j);
            j >>= 8;
        }
    }
}
