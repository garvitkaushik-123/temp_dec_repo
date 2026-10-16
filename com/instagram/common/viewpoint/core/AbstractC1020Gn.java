package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Gn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1020Gn {
    public static byte[] A00;
    public static String[] A01 = {"jnpQs", "68vQr4mYnLI0oxp3WZBPcyc6w04l8sdO", "1OtBqA6VhuQLpqBNtIteBoMpw2BUtlZT", "iBOJpCpDP8DiwQrVeW3OV9Em66L9h1f8", "Xaj0HtPMuTBdCp8NFbjtiHIpdpZCFdAK", "i4DAEtymK6yFJNiO2QALezQZgNrDh5qR", "4Bsy9O0lknqqP9xR2TNdH0U1zi1weR0A", "FgP5ewPOxCae6ADOyhugLxvte5BfjSLb"};
    public static final int[] A02;
    public static final int[] A03;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 121);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-10, -10, -8, -43, Ascii.GS, Ascii.SUB, Ascii.SYN, Ascii.EM, Ascii.SUB, 39, -43, Ascii.RS, 35, 40, 42, Ascii.ESC, Ascii.ESC, Ascii.RS, Ascii.CAN, Ascii.RS, Ascii.SUB, 35, 41, -43, Ascii.EM, Ascii.SYN, 41, Ascii.SYN, -13, -13, -11, -46, Ascii.SUB, Ascii.ETB, 19, Ascii.SYN, Ascii.ETB, 36, -46, 41, 36, 33, 32, Ascii.EM, -46, 5, 19, Ascii.US, 34, Ascii.RS, Ascii.ESC, 32, Ascii.EM, -46, -8, 36, Ascii.ETB, 35, 39, Ascii.ETB, 32, Ascii.NAK, 43, -46, -5, 32, Ascii.SYN, Ascii.ETB, 42, 5, 37, 39, Ascii.EM, 56, 45, 48, Ascii.DLE, 41, 32, 51, 43, 32, Ascii.RS, 47, 32, Ascii.US, -37, 33, 45, Ascii.FS, 40, 32, 7, 32, 41, 34, 47, 35, 1, 39, Ascii.FS, 34, -37, -8, -37, -20, -8, 17, Ascii.SYN, Ascii.CAN, 19, 19, Ascii.DC2, Ascii.NAK, Ascii.ETB, 8, 7, -61, 4, Ascii.CAN, 7, Ascii.FF, Ascii.DC2, -61, Ascii.DC2, 5, Ascii.CR, 8, 6, Ascii.ETB, -61, Ascii.ETB, Ascii.FS, 19, 8, -35, -61, 68, 93, 98, 100, 95, 95, 94, 97, 99, 84, 83, Ascii.SI, 84, 95, 50, 94, 93, 85, 88, 86, 41, Ascii.SI, -19, -16, -76, -31, -82, -76, -80, -82};
    }

    static {
        A05();
        A03 = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
        A02 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    }

    public static int A00(C07354u c07354u) {
        int A04 = c07354u.A04(5);
        if (A04 == 31) {
            int audioObjectType = c07354u.A04(6);
            return audioObjectType + 32;
        }
        return A04;
    }

    public static int A01(C07354u c07354u) throws C3K {
        int A04 = c07354u.A04(4);
        if (A04 == 15) {
            int A012 = c07354u.A01();
            if (A01[0].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "q0W1UZuAU1h4xSNvnmv6o4fLVDdZ81si";
            strArr[4] = "TmcMI11py7mWue9QV51Oyh4sKPsH3Jhr";
            if (A012 >= 24) {
                int frequencyIndex = c07354u.A04(24);
                return frequencyIndex;
            }
            throw C3K.A01(A04(0, 28, 60), null);
        }
        if (A04 < 13) {
            int frequencyIndex2 = A03[A04];
            return frequencyIndex2;
        }
        throw C3K.A01(A04(28, 41, 57), null);
    }

    public static C1019Gm A02(C07354u c07354u, boolean z) throws C3K {
        int A002 = A00(c07354u);
        int A012 = A01(c07354u);
        int A04 = c07354u.A04(4);
        String str = A04(159, 8, 7) + A002;
        if (A002 == 5 || A002 == 29) {
            A012 = A01(c07354u);
            A002 = A00(c07354u);
            if (A002 == 22) {
                A04 = c07354u.A04(4);
            }
        }
        if (z) {
            switch (A002) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                case 7:
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    A06(c07354u, A002, A04);
                    int sampleRateHz = A01[0].length();
                    if (sampleRateHz == 5) {
                        String[] strArr = A01;
                        strArr[6] = "3cbQZ4WWsbXwvX2zvxOiUlmwqxsyxREi";
                        strArr[3] = "nPAxNfqqgI9TB5NmScWQIj27S1nluV3e";
                        switch (A002) {
                            case 17:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                                int A042 = c07354u.A04(2);
                                if (A042 == 2 || A042 == 3) {
                                    throw C3K.A00(A04(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 22, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE) + A042);
                                }
                                break;
                        }
                    } else {
                        throw new RuntimeException();
                    }
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 18:
                default:
                    throw C3K.A00(A04(106, 31, 42) + A002);
            }
        }
        int channelCount = A02[A04];
        if (channelCount != -1) {
            return new C1019Gm(A012, channelCount, str);
        }
        throw C3K.A01(null, null);
    }

    public static C1019Gm A03(byte[] bArr) throws C3K {
        return A02(new C07354u(bArr), false);
    }

    public static void A06(C07354u c07354u, int i, int i2) {
        boolean frameLengthFlag = c07354u.A0H();
        if (frameLengthFlag) {
            AbstractC07214g.A07(A04(69, 7, 75), A04(76, 30, 66));
        }
        boolean frameLengthFlag2 = c07354u.A0H();
        if (frameLengthFlag2) {
            if (A01[5].charAt(15) != 's') {
                String[] strArr = A01;
                strArr[7] = "v2arTuVBFpHRdd6zD5uQKVaL6J866891";
                strArr[2] = "F7KamgaQFU4osqLd0R7CHRmLJ4QhMqsw";
                c07354u.A09(14);
            }
            throw new RuntimeException();
        }
        boolean A0H = c07354u.A0H();
        if (i2 != 0) {
            if (i == 6 || i == 20) {
                c07354u.A09(3);
            }
            if (A0H) {
                if (i == 22) {
                    c07354u.A09(16);
                }
                if (i == 17 || i == 19 || i == 20 || i == 23) {
                    c07354u.A09(3);
                }
                String[] strArr2 = A01;
                if (strArr2[1].charAt(21) != strArr2[4].charAt(21)) {
                    String[] strArr3 = A01;
                    strArr3[6] = "QrL8Tr8yy4gY8AXmFxmkTTkkR7JmfqMW";
                    strArr3[3] = "IjkFi7C6bNI16jdHGSbHtjLd4dsdDQNH";
                    c07354u.A09(1);
                    return;
                }
                throw new RuntimeException();
            }
            return;
        }
        throw new UnsupportedOperationException();
    }

    public static byte[] A07(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & 120))};
    }
}
