package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.google.common.base.Ascii;
import io.bidmachine.media3.common.PlaybackException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class HS {
    public static byte[] A00;
    public static int[] A01;
    public static String[] A02 = {"unNLyNh5FR3GyMG68d", "fnHIAbwwkFQ1ZGNlnsc", "DMpYp1jOlcNpO4pJgPWh22Zerf91QM8t", "RZoQ8h3", "L8G6Aqwau6BJqNFKfla", "ElXYWWCxJdBggdMs0Hio0yCYqdZAyfAp", "A3sl", "vST53OIiICW6hrmD3wtDRemD3zmWyZSx"};
    public static final byte[] A03;
    public static final float[] A04;
    public static final Object A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static HP A06(byte[] bArr, int i, int i2) {
        HU hu = new HU(bArr, i, i2);
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        hu.A07(4);
        int A052 = hu.A05(3);
        hu.A06();
        int A053 = hu.A05(2);
        boolean A0A = hu.A0A();
        int A054 = hu.A05(5);
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (A02[0].length() == 10) {
                break;
            }
            String[] strArr = A02;
            strArr[2] = "xkwe1O9uU2dqAY7xWUY4fbTlKQKyvcwL";
            strArr[7] = "HeYhRuPqM40BhEn67WYdTTzYcbU6v3bu";
            if (i7 < 32) {
                if (hu.A0A()) {
                    i6 |= 1 << i7;
                }
                i7++;
            } else {
                int[] iArr = new int[6];
                for (int i8 = 0; i8 < iArr.length; i8++) {
                    iArr[i8] = hu.A05(8);
                }
                int A055 = hu.A05(8);
                int i9 = 0;
                for (int i10 = 0; i10 < A052; i10++) {
                    if (hu.A0A()) {
                        i9 += 89;
                    }
                    if (hu.A0A()) {
                        i9 += 8;
                    }
                }
                hu.A07(i9);
                if (A052 > 0) {
                    hu.A07((8 - A052) * 2);
                }
                int A042 = hu.A04();
                int A043 = hu.A04();
                if (A043 == 3) {
                    hu.A06();
                }
                int A044 = hu.A04();
                int A045 = hu.A04();
                if (hu.A0A()) {
                    int A046 = hu.A04();
                    int A047 = hu.A04();
                    int A048 = hu.A04();
                    int A049 = hu.A04();
                    A044 -= (A046 + A047) * ((A043 == 1 || A043 == 2) ? 2 : 1);
                    int i11 = (A048 + A049) * (A043 == 1 ? 2 : 1);
                    String[] strArr2 = A02;
                    if (strArr2[4].length() != strArr2[1].length()) {
                        A02[6] = "Hn3sdMz19WVmWCBK";
                        A045 -= i11;
                    } else {
                        A02[3] = "Jz4JSkPN0248kFDgiRzzjLGO7q";
                        A045 -= i11;
                    }
                }
                hu.A04();
                hu.A04();
                int A0410 = hu.A04();
                for (int i12 = hu.A0A() ? 0 : A052; i12 <= A052; i12++) {
                    hu.A04();
                    hu.A04();
                    hu.A04();
                }
                hu.A04();
                hu.A04();
                hu.A04();
                hu.A04();
                hu.A04();
                hu.A04();
                if (hu.A0A() && hu.A0A()) {
                    A0D(hu);
                }
                hu.A07(2);
                if (hu.A0A()) {
                    hu.A07(8);
                    hu.A04();
                    hu.A04();
                    hu.A06();
                }
                A0E(hu);
                if (hu.A0A()) {
                    for (int i13 = 0; i13 < hu.A04(); i13++) {
                        hu.A07(A0410 + 4 + 1);
                    }
                }
                hu.A07(2);
                float f = 1.0f;
                boolean A0A2 = hu.A0A();
                if (A02[0].length() != 10) {
                    String[] strArr3 = A02;
                    strArr3[2] = "CMlgeA8zQVByZrA2VMXzsS0jeMyo18qQ";
                    strArr3[7] = "QAK33uwHUZwexufQvU3o8DPmyRQmvUMz";
                    if (A0A2) {
                        if (hu.A0A()) {
                            int A056 = hu.A05(8);
                            if (A056 == 255) {
                                int A057 = hu.A05(16);
                                int A058 = hu.A05(16);
                                if (A057 != 0 && A058 != 0) {
                                    f = A057 / A058;
                                }
                            } else if (A056 < A04.length) {
                                f = A04[A056];
                            } else {
                                AbstractC07214g.A07(A0B(0, 11, 63), A0B(11, 35, 126) + A056);
                            }
                        }
                        if (hu.A0A()) {
                            hu.A06();
                        }
                        if (hu.A0A()) {
                            hu.A07(3);
                            boolean A0A3 = hu.A0A();
                            if (hu.A0A()) {
                                int A059 = hu.A05(8);
                                int A0510 = hu.A05(8);
                                hu.A07(8);
                                i3 = ColorInfo.A00(A059);
                                i4 = A0A3 ? 1 : 2;
                                if (A02[6].length() != 3) {
                                    A02[0] = "HGrGkdvIc2AkT14Ejxxa4aXBUNVha";
                                    i5 = ColorInfo.A01(A0510);
                                } else {
                                    i5 = ColorInfo.A01(A0510);
                                }
                            }
                        }
                        if (hu.A0A()) {
                            hu.A04();
                            hu.A04();
                        }
                        hu.A06();
                        if (hu.A0A()) {
                            A045 *= 2;
                        }
                    }
                    return new HP(A053, A0A, A054, i6, iArr, A055, A042, A044, A045, f, i3, i4, i5);
                }
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static HR A0A(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        HU hu = new HU(bArr, i, i2);
        int A052 = hu.A05(8);
        int A053 = hu.A05(8);
        int A054 = hu.A05(8);
        int A042 = hu.A04();
        int i5 = 1;
        if (A052 == 100 || A052 == 110 || A052 == 122 || A052 == 244 || A052 == 44 || A052 == 83 || A052 == 86 || A052 == 118 || A052 == 128 || A052 == 138) {
            i5 = hu.A04();
            r20 = i5 == 3 ? hu.A0A() : false;
            hu.A04();
            hu.A04();
            hu.A06();
            boolean A0A = hu.A0A();
            if (A02[0].length() != 10) {
                A02[0] = "qzm7RlaVhvQtMB0zhtauZ";
                if (A0A) {
                    int i6 = i5 != 3 ? 8 : 12;
                    int i7 = 0;
                    while (i7 < i6) {
                        if (hu.A0A()) {
                            A0F(hu, i7 < 6 ? 16 : 64);
                        }
                        i7++;
                    }
                }
            }
            throw new RuntimeException();
        }
        int A043 = hu.A04() + 4;
        int A044 = hu.A04();
        int i8 = 0;
        boolean z = false;
        if (A044 == 0) {
            i8 = hu.A04() + 4;
            if (A02[5].charAt(3) != 'Y') {
                A02[3] = "2NWfLRVEjhOO9";
            } else {
                A02[5] = "fn7YpbzvxXlInri96XbQTTrdseuocXrx";
            }
        } else {
            if (A044 == 1) {
                z = hu.A0A();
                hu.A03();
                hu.A03();
                long A045 = hu.A04();
                String[] strArr = A02;
                if (strArr[4].length() == strArr[1].length()) {
                    String[] strArr2 = A02;
                    strArr2[2] = "sL3yo27N596gnAOXUx3X3jVDrWZXEmHs";
                    strArr2[7] = "EWRRgQnwInix360952oSCS5kmFFjSZxj";
                    for (int i9 = 0; i9 < A045; i9++) {
                        hu.A04();
                    }
                }
                throw new RuntimeException();
            }
            String[] strArr3 = A02;
            if (strArr3[4].length() != strArr3[1].length()) {
                throw new RuntimeException();
            }
            A02[3] = "4FZcyZVF6YdFmLSwekyzJ";
        }
        int A046 = hu.A04();
        hu.A06();
        int A047 = hu.A04() + 1;
        int A048 = hu.A04() + 1;
        boolean A0A2 = hu.A0A();
        int i10 = (2 - (A0A2 ? 1 : 0)) * A048;
        if (!A0A2) {
            hu.A06();
        }
        hu.A06();
        int i11 = A047 * 16;
        int i12 = i10 * 16;
        if (hu.A0A()) {
            int A049 = hu.A04();
            int A0410 = hu.A04();
            int A0411 = hu.A04();
            int A0412 = hu.A04();
            if (i5 == 0) {
                i3 = 1;
                i4 = 2 - (A0A2 ? 1 : 0);
            } else {
                i3 = i5 == 3 ? 1 : 2;
                i4 = (2 - (A0A2 ? 1 : 0)) * (i5 == 1 ? 2 : 1);
            }
            i11 -= (A049 + A0410) * i3;
            i12 -= (A0411 + A0412) * i4;
        }
        float f = 1.0f;
        if (hu.A0A() && hu.A0A()) {
            int A055 = hu.A05(8);
            if (A055 == 255) {
                int A056 = hu.A05(16);
                int A057 = hu.A05(16);
                if (A056 != 0 && A057 != 0) {
                    f = A056 / A057;
                }
            } else if (A055 < A04.length) {
                f = A04[A055];
            } else {
                AbstractC07214g.A07(A0B(0, 11, 63), A0B(11, 35, 126) + A055);
            }
        }
        return new HR(A052, A053, A054, A042, A046, i11, i12, f, r20, A0A2, A043, A044, i8, z);
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_SETUP_REQUIRED);
        }
        return new String(copyOfRange);
    }

    public static void A0C() {
        A00 = new byte[]{-7, Ascii.FF, Ascii.ETB, 0, Ascii.EM, Ascii.DC4, Ascii.US, 0, Ascii.US, Ascii.DC4, Ascii.ETB, 63, 88, 79, 98, 90, 79, 77, 94, 79, 78, 10, 75, 93, 90, 79, 77, 94, 73, 92, 75, 94, 83, 89, 73, 83, 78, 77, 10, 96, 75, 86, 95, 79, 36, 10, 66, 53, 48, 49, 59, -5, 45, 66, 47, Ascii.ETB, 10, 5, 6, Ascii.DLE, -48, 9, 6, Ascii.ETB, 4};
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x010e, code lost:
    
        if (r13 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0110, code lost:
    
        r7[r5] = r17;
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0133, code lost:
    
        if (r13 != false) goto L60;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0E(HU hu) {
        int A042;
        int A043;
        int[] iArr;
        int A044 = hu.A04();
        int i = -1;
        int i2 = -1;
        int[] iArr2 = new int[0];
        int[] iArr3 = new int[0];
        int i3 = 0;
        while (i3 < A044) {
            if (i3 != 0 && hu.A0A()) {
                int i4 = i + i2;
                int A045 = (1 - ((hu.A0A() ? 1 : 0) * 2)) * (hu.A04() + 1);
                boolean[] zArr = new boolean[i4 + 1];
                for (int i5 = 0; i5 <= i4; i5++) {
                    if (hu.A0A()) {
                        zArr[i5] = true;
                    } else {
                        zArr[i5] = hu.A0A();
                    }
                }
                A042 = 0;
                int[] iArr4 = new int[i4 + 1];
                int[] iArr5 = new int[i4 + 1];
                for (int i6 = i2 - 1; i6 >= 0; i6--) {
                    int i7 = iArr3[i6] + A045;
                    if (i7 < 0 && zArr[i + i6]) {
                        iArr4[A042] = i7;
                        A042++;
                    }
                }
                if (A045 < 0 && zArr[i4]) {
                    iArr4[A042] = A045;
                    A042++;
                }
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = iArr2[i8] + A045;
                    if (A02[0].length() == 10) {
                        throw new RuntimeException();
                    }
                    A02[0] = "0xLwbNcICqBOIGnxvrVU0VkzUAjp";
                    if (i9 < 0) {
                        boolean z = zArr[i8];
                        if (A02[6].length() != 3) {
                            String[] strArr = A02;
                            strArr[2] = "OJAEm2QqqrF2kr0XAoMunq3AjjwiYhOO";
                            strArr[7] = "NvnxbUpcm9NzKSDUaYgmh21cCcr7HCKV";
                            if (!z) {
                            }
                            int i10 = A042 + 1;
                            iArr4[A042] = i9;
                            if (A02[0].length() == 10) {
                                A02[0] = "ZxDUqDztknTqk0noe7cSqrpf0";
                                A042 = i10;
                            } else {
                                A042 = i10;
                            }
                        } else {
                            String[] strArr2 = A02;
                            strArr2[2] = "O1Oy4mT2J3IqGA0cLz7TSW3zbNH41BLw";
                            strArr2[7] = "bMAFoAVZGrulVErqDQ8z4qjQetYlIImf";
                            if (!z) {
                            }
                            int i102 = A042 + 1;
                            iArr4[A042] = i9;
                            if (A02[0].length() == 10) {
                            }
                        }
                    }
                }
                iArr = Arrays.copyOf(iArr4, A042);
                A043 = 0;
                for (int i11 = i - 1; i11 >= 0; i11--) {
                    int i12 = iArr2[i11] + A045;
                    if (i12 > 0 && zArr[i11]) {
                        iArr5[A043] = i12;
                        A043++;
                    }
                }
                if (A045 > 0) {
                    boolean z2 = zArr[i4];
                    String[] strArr3 = A02;
                    if (strArr3[4].length() != strArr3[1].length()) {
                        A02[6] = "tgnVuwGZauQZxVLXvW8ZTDaij";
                    } else {
                        A02[0] = "U";
                    }
                }
                for (int i13 = 0; i13 < i2; i13++) {
                    int i14 = iArr3[i13] + A045;
                    if (i14 > 0 && zArr[i + i13]) {
                        iArr5[A043] = i14;
                        A043++;
                    }
                }
                if (A02[5].charAt(3) != 'Y') {
                    A02[5] = "VNLYj4nIEG05kgLFUbTjhWBq9LKgRHZO";
                    iArr3 = Arrays.copyOf(iArr5, A043);
                } else {
                    String[] strArr4 = A02;
                    strArr4[2] = "zCcqrsPkSftUPRel4Z8ZE6iGY8rnHFMe";
                    strArr4[7] = "knHf2kXaFD2hm93xyPTTBZZ0wItiA7C5";
                    iArr3 = Arrays.copyOf(iArr5, A043);
                }
            } else {
                A042 = hu.A04();
                A043 = hu.A04();
                iArr = new int[A042];
                for (int i15 = 0; i15 < A042; i15++) {
                    iArr[i15] = hu.A04() + 1;
                    hu.A06();
                }
                iArr3 = new int[A043];
                for (int i16 = 0; i16 < A043; i16++) {
                    iArr3[i16] = hu.A04() + 1;
                    hu.A06();
                }
            }
            i = A042;
            i2 = A043;
            iArr2 = iArr;
            if (A02[0].length() != 10) {
                String[] strArr5 = A02;
                strArr5[4] = "MHTDjP3q9jqJvcAulQ6";
                strArr5[1] = "VeGKMo1LwbXx0TG7y0g";
                i3++;
            } else {
                i3++;
            }
        }
    }

    static {
        A0C();
        A03 = new byte[]{0, 0, 0, 1};
        A04 = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
        A05 = new Object();
        A01 = new int[10];
    }

    public static int A00(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int A01(byte[] bArr, int i) {
        return bArr[i + 3] & Ascii.US;
    }

    public static int A02(byte[] bArr, int i) {
        int i2;
        synchronized (A05) {
            int scratchEscapeCount = 0;
            int i3 = 0;
            while (scratchEscapeCount < i) {
                scratchEscapeCount = A03(bArr, scratchEscapeCount, i);
                if (scratchEscapeCount < i) {
                    if (A01.length <= i3) {
                        A01 = Arrays.copyOf(A01, A01.length * 2);
                    }
                    A01[i3] = scratchEscapeCount;
                    scratchEscapeCount += 3;
                    i3++;
                }
            }
            i2 = i - i3;
            int unescapedPosition = 0;
            int escapedPosition = 0;
            for (int unescapedLength = 0; unescapedLength < i3; unescapedLength++) {
                int scratchEscapeCount2 = A01[unescapedLength];
                int scratchEscapeCount3 = scratchEscapeCount2 - unescapedPosition;
                System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, scratchEscapeCount3);
                int escapedPosition2 = escapedPosition + scratchEscapeCount3;
                int position = escapedPosition2 + 1;
                bArr[escapedPosition2] = 0;
                escapedPosition = position + 1;
                bArr[position] = 0;
                unescapedPosition += scratchEscapeCount3 + 3;
            }
            System.arraycopy(bArr, unescapedPosition, bArr, escapedPosition, i2 - escapedPosition);
        }
        return i2;
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0002 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(byte[] bArr, int i, int i2) {
        while (i < i) {
            int i3 = bArr[i];
            if (i3 == 0) {
                int i4 = i + 1;
                if (bArr[i4] == 0) {
                    int i5 = i + 2;
                    if (bArr[i5] == 3) {
                        return i;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0136, code lost:
    
        if (r0 == 1) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0138, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0144, code lost:
    
        if (r0 == 1) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A04(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        boolean z2;
        int i3 = i2 - i;
        AbstractC07133y.A08(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            A0H(zArr);
            int length = i - 3;
            return length;
        }
        if (i3 > 1 && zArr[1]) {
            int length2 = bArr[i];
            if (length2 == 1) {
                A0H(zArr);
                int length3 = i - 2;
                return length3;
            }
        }
        if (i3 > 2 && zArr[2]) {
            int length4 = bArr[i];
            if (length4 == 0) {
                int length5 = i + 1;
                byte b = bArr[length5];
                if (A02[0].length() == 10) {
                    throw new RuntimeException();
                }
                A02[6] = "PQW9C7kUOKDoPPw";
                if (b == 1) {
                    A0H(zArr);
                    int length6 = i - 1;
                    return length6;
                }
            }
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            int length7 = bArr[i5];
            if ((length7 & 254) == 0) {
                int length8 = i5 - 2;
                if (bArr[length8] == 0) {
                    int length9 = i5 - 1;
                    if (bArr[length9] == 0) {
                        int length10 = bArr[i5];
                        if (length10 == 1) {
                            A0H(zArr);
                            int length11 = i5 - 2;
                            return length11;
                        }
                    }
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (i3 > 2) {
            int length12 = i2 - 3;
            if (bArr[length12] == 0) {
                int length13 = i2 - 2;
                byte b2 = bArr[length13];
                if (A02[6].length() == 3) {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[4] = "tLizWOaN0OsagnuSy28";
                strArr[1] = "ZOtg0UvXTXpiFnpoxfp";
                if (b2 == 0) {
                    int length14 = i2 - 1;
                    if (bArr[length14] == 1) {
                        z = true;
                    }
                }
            }
            z = false;
        } else if (i3 == 2) {
            boolean z3 = zArr[2];
            if (A02[5].charAt(3) != 'Y') {
                throw new RuntimeException();
            }
            A02[0] = "TtHOfwpayoR";
            if (z3) {
                int length15 = i2 - 2;
                if (bArr[length15] == 0) {
                    int length16 = i2 - 1;
                    if (bArr[length16] == 1) {
                        z = true;
                    }
                }
            }
            z = false;
        } else {
            if (zArr[1]) {
                int i6 = i2 - 1;
                String[] strArr2 = A02;
                String str = strArr2[2];
                String str2 = strArr2[7];
                int charAt = str.charAt(3);
                int length17 = str2.charAt(3);
                if (charAt != length17) {
                    String[] strArr3 = A02;
                    strArr3[2] = "UGNUjS5TseBxte9hZy6MdiMKKivw8YU8";
                    strArr3[7] = "gAwFNStsKHXv5jMh5dTnIzvsHbrqE6D6";
                    int length18 = bArr[i6];
                } else {
                    A02[5] = "MYPYXnk67e7ylj87wlpJJbRJ3uYkeY13";
                    int length19 = bArr[i6];
                }
            }
            z = false;
        }
        zArr[0] = z;
        if (i3 > 1) {
            int length20 = i2 - 2;
            if (bArr[length20] == 0) {
                int length21 = i2 - 1;
                if (bArr[length21] == 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            if (zArr[2]) {
                int length22 = i2 - 1;
                if (bArr[length22] == 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        zArr[1] = z2;
        int length23 = i2 - 1;
        zArr[2] = bArr[length23] == 0;
        return i2;
    }

    public static HP A05(byte[] bArr, int i, int i2) {
        return A06(bArr, i + 2, i2);
    }

    public static HQ A07(byte[] bArr, int i, int i2) {
        return A08(bArr, i + 1, i2);
    }

    public static HQ A08(byte[] bArr, int i, int i2) {
        HU data = new HU(bArr, i, i2);
        int A042 = data.A04();
        int seqParameterSetId = data.A04();
        data.A06();
        return new HQ(A042, seqParameterSetId, data.A0A());
    }

    public static HR A09(byte[] bArr, int i, int i2) {
        return A0A(bArr, i + 1, i2);
    }

    public static void A0D(HU hu) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int matrixId = 1;
                if (!hu.A0A()) {
                    hu.A04();
                } else {
                    int sizeId = i << 1;
                    int min = Math.min(64, 1 << (sizeId + 4));
                    if (i > 1) {
                        hu.A03();
                    }
                    for (int sizeId2 = 0; sizeId2 < min; sizeId2++) {
                        hu.A03();
                    }
                }
                if (i == 3) {
                    matrixId = 3;
                }
                i2 += matrixId;
            }
        }
    }

    public static void A0F(HU hu, int i) {
        int i2 = 8;
        int lastScale = 8;
        for (int nextScale = 0; nextScale < i; nextScale++) {
            if (lastScale != 0) {
                int lastScale2 = hu.A03();
                lastScale = ((lastScale2 + i2) + 256) % 256;
            }
            if (lastScale != 0) {
                i2 = lastScale;
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0G(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int value = 0;
        while (length < position) {
            int length = byteBuffer.get(value);
            int offset = length & 255;
            if (i == 3) {
                if (offset == 1) {
                    int length2 = value + 1;
                    int consecutiveZeros = byteBuffer.get(length2) & 31;
                    if (consecutiveZeros == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        int length3 = value - 3;
                        duplicate.position(length3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                }
            } else if (offset == 0) {
                i++;
            }
            if (offset != 0) {
                i = 0;
            }
            value++;
        }
        byteBuffer.clear();
    }

    public static void A0H(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean A0I(String str, byte b) {
        if (A0B(46, 9, 96).equals(str) && (b & Ascii.US) == 6) {
            return true;
        }
        return A0B(55, 10, 53).equals(str) && ((b & 126) >> 1) == 39;
    }
}
