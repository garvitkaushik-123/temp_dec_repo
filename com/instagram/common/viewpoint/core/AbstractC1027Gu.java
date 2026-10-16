package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Gu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1027Gu {
    public static byte[] A00;
    public static String[] A01 = {"xbfghvjfzJvhku5N8OELiq204nVuVPFf", "QHdNkhaNqF6P8ZoHbM5E7ac9pSEOFT0I", "gTrjGkh7SJSYjcOCOWWCub6Uckq9Yltj", "B1r", "bt5fTN19iCcMkB3LBJCDNqZ6iO4ZjItL", "3vLSrbB7SQdOWYeFWsx", "mXdQOoT87saNovPMynKxKkWZ", "FMZbalTyTizDclIiFtsmYNu0onhdvCq9"};
    public static final int[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1026Gt A04(C07354u c07354u) {
        int A04 = c07354u.A04(16);
        int A042 = c07354u.A04(16);
        int i = 0 + 2 + 2;
        if (A042 == 65535) {
            A042 = c07354u.A04(24);
            i += 3;
        }
        int i2 = A042 + i;
        if (A04 == 44097) {
            i2 += 2;
        }
        int A043 = c07354u.A04(2);
        if (A043 == 3) {
            A043 += A00(c07354u, 2);
            String[] strArr = A01;
            if (strArr[1].charAt(27) != strArr[4].charAt(27)) {
                A01[3] = "JeV";
            }
            throw new RuntimeException();
        }
        int A044 = c07354u.A04(10);
        if (c07354u.A0H() && c07354u.A04(3) > 0) {
            c07354u.A09(2);
        }
        boolean A0H = c07354u.A0H();
        if (A01[5].length() != 0) {
            A01[7] = "lwIINFZkQEgov7IcPWK4ANnqSDhXt22f";
            int i3 = A0H ? 48000 : 44100;
            int A045 = c07354u.A04(4);
            int i4 = 0;
            if (i3 != 44100 || A045 != 13) {
                if (i3 == 48000 && A045 < A02.length) {
                    i4 = A02[A045];
                    switch (A044 % 5) {
                        case 1:
                        case 3:
                            if (A045 == 3 || A045 == 8) {
                                i4++;
                                break;
                            }
                        case 2:
                            if (A045 == 8 || A045 == 11) {
                                i4++;
                                break;
                            }
                        case 4:
                            if (A045 == 3 || A045 == 8 || A045 == 11) {
                                i4++;
                                break;
                            }
                    }
                }
            } else {
                i4 = A02[A045];
            }
            return new C1026Gt(A043, 2, i3, i2, i4);
        }
        throw new RuntimeException();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A01[7].charAt(26) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "ZZS15YLfqnGzRKQmbGGBAS62S7daT6Pr";
            strArr[0] = "wbQ3s0ZhLtikxP7PtpYOpvXFjSSpaatC";
            copyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-121, -101, -118, -113, -107, 85, -121, -119, 90};
    }

    static {
        A06();
        A02 = new int[]{2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};
    }

    public static int A00(C07354u c07354u, int i) {
        int i2 = 0;
        while (true) {
            int value = c07354u.A04(i);
            int i3 = i2 + value;
            if (!c07354u.A0H()) {
                return i3;
            }
            i2 = (i3 + 1) << i;
        }
    }

    public static int A01(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return A04(new C07354u(bArr)).A03;
    }

    public static int A02(byte[] bArr, int i) {
        if (bArr.length < 7) {
            return -1;
        }
        int headerSize = bArr[2];
        int i2 = (headerSize & 255) << 8;
        int headerSize2 = bArr[3];
        int i3 = i2 | (headerSize2 & 255);
        int frameSize = 2 + 2;
        if (i3 == 65535) {
            int headerSize3 = bArr[4];
            int i4 = (headerSize3 & 255) << 16;
            int headerSize4 = bArr[5];
            int i5 = i4 | ((headerSize4 & 255) << 8);
            int headerSize5 = bArr[6];
            i3 = i5 | (headerSize5 & 255);
            frameSize += 3;
        }
        if (i == 44097) {
            frameSize += 2;
        }
        int i6 = i3 + frameSize;
        String[] strArr = A01;
        String str = strArr[1];
        String str2 = strArr[4];
        int charAt = str.charAt(27);
        int headerSize6 = str2.charAt(27);
        if (charAt == headerSize6) {
            throw new RuntimeException();
        }
        A01[7] = "5dLepgbvmcODZNjBgadRz1gh8sb0vEN9";
        return i6;
    }

    public static C2489qI A03(C07364v c07364v, String str, String str2, DrmInitData drmInitData) {
        c07364v.A0g(1);
        return new C06802p().A0y(str).A11(A05(0, 9, 31)).A0b(2).A0m(((c07364v.A0I() & 32) >> 5) == 1 ? 48000 : 44100).A0u(drmInitData).A10(str2).A14();
    }

    public static void A07(int i, C07364v c07364v) {
        c07364v.A0d(7);
        byte[] A0l = c07364v.A0l();
        A0l[0] = -84;
        A0l[1] = SignedBytes.MAX_POWER_OF_TWO;
        A0l[2] = -1;
        A0l[3] = -1;
        A0l[4] = (byte) ((i >> 16) & 255);
        A0l[5] = (byte) ((i >> 8) & 255);
        A0l[6] = (byte) (i & 255);
    }
}
