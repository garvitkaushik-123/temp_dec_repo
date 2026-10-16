package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class H7 {
    public static byte[] A00;
    public static String[] A01 = {"Y8HEI18e1GadHrln0qmDFCEaxi", "oL2ricEuOMEwxHFhMskly09xAYMP2tCR", "T", "KMY19rMWfOVULyqsMixIRosvw7BV", "hLcN9Ked", "HwmbqduaXfn6sstptA", "kxZRIOPiX6BuamdrhGUbsB3Guhn0rTOf", "HgYihtPWg4cBhJSwUBMvBFzsg3tZPPZN"};
    public static final int[] A02;
    public static final int[] A03;
    public static final int[] A04;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{7, 19, 2, Ascii.SI, 9, 73, Ascii.DLE, 8, 2, 72, 2, Ascii.DC2, Ascii.NAK};
    }

    static {
        A06();
        A02 = new int[]{1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
        A03 = new int[]{-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
        A04 = new int[]{64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    }

    public static int A00(ByteBuffer byteBuffer) {
        int nblks;
        int position = byteBuffer.position();
        int position2 = byteBuffer.get(position);
        switch (position2) {
            case -2:
                int position3 = position + 5;
                int i = (byteBuffer.get(position3) & 1) << 6;
                int position4 = position + 4;
                nblks = i | ((byteBuffer.get(position4) & 252) >> 2);
                break;
            case -1:
                int position5 = position + 4;
                int i2 = (byteBuffer.get(position5) & 7) << 4;
                int position6 = position + 7;
                nblks = i2 | ((byteBuffer.get(position6) & 60) >> 2);
                break;
            case 31:
                int position7 = position + 5;
                int i3 = (byteBuffer.get(position7) & 7) << 4;
                int position8 = position + 6;
                nblks = i3 | ((byteBuffer.get(position8) & 60) >> 2);
                break;
            default:
                int position9 = position + 4;
                int i4 = (byteBuffer.get(position9) & 1) << 6;
                int position10 = position + 5;
                nblks = i4 | ((byteBuffer.get(position10) & 252) >> 2);
                break;
        }
        int position11 = nblks + 1;
        return position11 * 32;
    }

    public static int A01(byte[] bArr) {
        int i;
        boolean z = false;
        switch (bArr[0]) {
            case -2:
                byte b = bArr[4];
                String[] strArr = A01;
                if (strArr[5].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[5] = "4XRrhZnjb0Sc0OiDCf";
                strArr2[0] = "emycfV24cXaR3M70231yELMb9K";
                i = (((b & 3) << 12) | ((bArr[7] & 255) << 4) | ((bArr[6] & 240) >> 4)) + 1;
                break;
            case -1:
                i = (((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4) | ((bArr[9] & 60) >> 2)) + 1;
                z = true;
                break;
            case 31:
                i = (((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4) | ((bArr[8] & 60) >> 2)) + 1;
                z = true;
                break;
            default:
                i = (((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4) | ((bArr[7] & 240) >> 4)) + 1;
                break;
        }
        return z ? (i * 16) / 14 : i;
    }

    public static int A02(byte[] bArr) {
        int i;
        switch (bArr[0]) {
            case -2:
                int nblks = bArr[5];
                i = ((nblks & 1) << 6) | ((bArr[4] & 252) >> 2);
                break;
            case -1:
                i = ((bArr[4] & 7) << 4) | ((bArr[7] & 60) >> 2);
                break;
            case 31:
                i = ((bArr[5] & 7) << 4) | ((bArr[6] & 60) >> 2);
                break;
            default:
                i = ((bArr[4] & 1) << 6) | ((bArr[5] & 252) >> 2);
                break;
        }
        int nblks2 = i + 1;
        return nblks2 * 32;
    }

    public static C2489qI A03(byte[] bArr, String str, String str2, DrmInitData drmInitData) {
        int i;
        C07354u A042 = A04(bArr);
        A042.A09(60);
        int amode = A042.A04(6);
        int bitrate = A02[amode];
        int amode2 = A042.A04(4);
        int rate = A03[amode2];
        int amode3 = A042.A04(5);
        if (amode3 >= A04.length) {
            i = -1;
        } else {
            i = (A04[amode3] * 1000) / 2;
        }
        A042.A09(10);
        int amode4 = A042.A04(2);
        int amode5 = amode4 > 0 ? 1 : 0;
        return new C06802p().A0y(str).A11(A05(0, 13, 27)).A0a(i).A0b(bitrate + amode5).A0m(rate).A0u(drmInitData).A10(str2).A14();
    }

    public static C07354u A04(byte[] bArr) {
        if (bArr[0] == Byte.MAX_VALUE) {
            return new C07354u(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (A08(copyOf)) {
            for (int i = 0; i < copyOf.length - 1; i += 2) {
                byte b = copyOf[i];
                copyOf[i] = copyOf[i + 1];
                copyOf[i + 1] = b;
            }
        }
        C07354u c07354u = new C07354u(copyOf);
        if (copyOf[0] == 31) {
            C07354u c07354u2 = new C07354u(copyOf);
            while (c07354u2.A01() >= 16) {
                c07354u2.A09(2);
                int A042 = c07354u2.A04(14);
                if (A01[4].length() == 13) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[1] = "nbIesC19CiuPXGAO1XmsVCjTSWLNlLKJ";
                strArr[7] = "ltOJbsz7vYOuZPV8QSj4f10zt4SJvXCJ";
                c07354u.A0B(A042, 14);
            }
        }
        c07354u.A0D(copyOf);
        return c07354u;
    }

    public static boolean A07(int i) {
        return i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368;
    }

    public static boolean A08(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }
}
