package com.mbridge.msdk.foundation.tools;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import java.lang.reflect.Array;

/* compiled from: FastBlurUtil.java */
/* loaded from: classes6.dex */
public class z {
    public static Bitmap a(Bitmap bitmap, int i, boolean z) {
        int i2;
        int i3 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i3 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr = new int[i4];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3;
        int i8 = i7 + 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width, height)];
        int i9 = (i7 + 2) >> 1;
        int i10 = i9 * i9;
        int i11 = i10 * 256;
        int[] iArr6 = new int[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            iArr6[i13] = i13 / i10;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i8, 3);
        int i14 = i3 + 1;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < height) {
            int[] iArr8 = iArr6;
            int i18 = -i3;
            int i19 = i12;
            int i20 = i19;
            int i21 = i20;
            int i22 = i21;
            int i23 = i22;
            int i24 = i23;
            int i25 = i24;
            int i26 = i25;
            int i27 = i26;
            while (i18 <= i3) {
                int[] iArr9 = iArr4;
                Bitmap bitmap2 = copy;
                int i28 = i12;
                int i29 = iArr[i16 + Math.min(i5, Math.max(i18, i28))];
                int[] iArr10 = iArr7[i18 + i3];
                iArr10[i28] = (i29 & 16711680) >> 16;
                iArr10[1] = (i29 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i29 & 255;
                int abs = i14 - Math.abs(i18);
                int i30 = iArr10[i28];
                i20 += i30 * abs;
                int i31 = iArr10[1];
                i19 += i31 * abs;
                int i32 = iArr10[2];
                i27 += abs * i32;
                if (i18 > 0) {
                    i24 += i30;
                    i25 += i31;
                    i26 += i32;
                } else {
                    i23 += i30;
                    i22 += i31;
                    i21 += i32;
                }
                i18++;
                iArr4 = iArr9;
                copy = bitmap2;
                i12 = 0;
            }
            int[] iArr11 = iArr4;
            Bitmap bitmap3 = copy;
            int i33 = i3;
            int i34 = 0;
            while (i34 < width) {
                iArr2[i16] = iArr8[i20];
                iArr3[i16] = iArr8[i19];
                iArr11[i16] = iArr8[i27];
                int i35 = i20 - i23;
                int i36 = i19 - i22;
                int i37 = i27 - i21;
                int[] iArr12 = iArr7[((i33 - i3) + i8) % i8];
                int i38 = i23 - iArr12[0];
                int i39 = i22 - iArr12[1];
                int i40 = i21 - iArr12[2];
                if (i15 == 0) {
                    i2 = i34;
                    iArr5[i2] = Math.min(i34 + i3 + 1, i5);
                } else {
                    i2 = i34;
                }
                int i41 = iArr[i17 + iArr5[i2]];
                int i42 = (i41 & 16711680) >> 16;
                iArr12[0] = i42;
                int i43 = (i41 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i43;
                int i44 = i41 & 255;
                iArr12[2] = i44;
                int i45 = i24 + i42;
                int i46 = i25 + i43;
                int i47 = i26 + i44;
                i20 = i35 + i45;
                i19 = i36 + i46;
                i27 = i37 + i47;
                i33 = (i33 + 1) % i8;
                int[] iArr13 = iArr7[i33 % i8];
                int i48 = iArr13[0];
                i23 = i38 + i48;
                int i49 = iArr13[1];
                i22 = i39 + i49;
                int i50 = iArr13[2];
                i21 = i40 + i50;
                i24 = i45 - i48;
                i25 = i46 - i49;
                i26 = i47 - i50;
                i16++;
                i34 = i2 + 1;
            }
            i17 += width;
            i15++;
            iArr6 = iArr8;
            iArr4 = iArr11;
            copy = bitmap3;
            i12 = 0;
        }
        int[] iArr14 = iArr6;
        int[] iArr15 = iArr4;
        Bitmap bitmap4 = copy;
        int i51 = 0;
        while (i51 < width) {
            int i52 = -i3;
            int i53 = i51;
            int i54 = i52 * width;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            while (i52 <= i3) {
                int max = Math.max(0, i54) + i53;
                int[] iArr16 = iArr7[i52 + i];
                iArr16[0] = iArr2[max];
                iArr16[1] = iArr3[max];
                iArr16[2] = iArr15[max];
                int abs2 = i14 - Math.abs(i52);
                i56 += iArr2[max] * abs2;
                i55 += iArr3[max] * abs2;
                i63 += iArr15[max] * abs2;
                if (i52 > 0) {
                    i60 += iArr16[0];
                    i61 += iArr16[1];
                    i62 += iArr16[2];
                } else {
                    i59 += iArr16[0];
                    i58 += iArr16[1];
                    i57 += iArr16[2];
                }
                if (i52 < i6) {
                    i54 += width;
                }
                i52++;
                i3 = i;
            }
            int i64 = i;
            int i65 = i63;
            int i66 = i53;
            for (int i67 = 0; i67 < height; i67++) {
                iArr[i66] = (iArr[i66] & (-16777216)) | (iArr14[i56] << 16) | (iArr14[i55] << 8) | iArr14[i65];
                int i68 = i56 - i59;
                int i69 = i55 - i58;
                int i70 = i65 - i57;
                int[] iArr17 = iArr7[((i64 - i) + i8) % i8];
                int i71 = i59 - iArr17[0];
                int i72 = i58 - iArr17[1];
                int i73 = i57 - iArr17[2];
                int i74 = i64;
                if (i53 == 0) {
                    iArr5[i67] = Math.min(i67 + i14, i6) * width;
                }
                int i75 = i53 + iArr5[i67];
                int i76 = iArr2[i75];
                iArr17[0] = i76;
                int i77 = iArr3[i75];
                iArr17[1] = i77;
                int i78 = iArr15[i75];
                iArr17[2] = i78;
                int i79 = i60 + i76;
                int i80 = i61 + i77;
                int i81 = i62 + i78;
                i56 = i68 + i79;
                i55 = i69 + i80;
                i65 = i70 + i81;
                i64 = (i74 + 1) % i8;
                int[] iArr18 = iArr7[i64];
                int i82 = iArr18[0];
                i59 = i71 + i82;
                int i83 = iArr18[1];
                i58 = i72 + i83;
                int i84 = iArr18[2];
                i57 = i73 + i84;
                i60 = i79 - i82;
                i61 = i80 - i83;
                i62 = i81 - i84;
                i66 += width;
            }
            i51 = i53 + 1;
            i3 = i;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i <= 0) {
            i = 10;
        }
        return a(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i, bitmap.getHeight() / i, false), 8, true);
    }
}
