package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class JP {
    public static byte[] A05;
    public static String[] A06 = {"8Hrr", "h", "0Fdee0wg4hsenc5DHvlvwY", "0vqFlF7HyuYg3TUYlVTMC9xVo", "FyWFMrZuY5MlICM", "PN9pA9f0QUy", "hrYl81FOJTp7gpX67gLzFhurxBV", "ujvsBGrB8Jik"};
    public final int A00;
    public final C1034Hb A01;
    public final String A02;
    public final boolean A03;
    public final byte[] A04;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{40, 33, 47, 78, 124, 124, 122, 98, 102, 97, 104, 47, 78, 74, 92, 34, 76, 91, 93, 47, 108, 125, 118, Byte.MAX_VALUE, 123, 96, 47, 98, 96, 107, 106, 33, 38, 0, 19, 17, Ascii.EM, 55, Ascii.FS, 17, 0, Ascii.VT, 2, 6, Ascii.ESC, Ascii.GS, Ascii.FS, 48, Ascii.GS, 10, 95, 100, 121, Byte.MAX_VALUE, 122, 122, 101, 120, 126, 111, 110, 42, 122, 120, 101, 126, 111, 105, 126, 99, 101, 100, 42, 121, 105, 98, 111, 103, 111, 42, 126, 115, 122, 111, 42, 45, 115, 114, 115, 33, 41, 40, 41, 57, 60, 58, 49, 60, 120, 126, 117, 104};
    }

    static {
        A02();
    }

    public JP(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        AbstractC07133y.A07((bArr2 == null) ^ (i == 0));
        this.A03 = z;
        this.A02 = str;
        this.A00 = i;
        this.A04 = bArr2;
        this.A01 = new C1034Hb(A00(str), bArr, i2, i3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(String str) {
        char c;
        if (str == null) {
            return 1;
        }
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(A01(86, 4, 80))) {
                    c = 2;
                    switch (c) {
                        case 0:
                        case 1:
                            return 1;
                        case 2:
                        case 3:
                            return 2;
                        default:
                            AbstractC07214g.A07(A01(32, 18, 50), A01(50, 36, 74) + str + A01(0, 32, 79));
                            return 1;
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 3046671:
                if (str.equals(A01(90, 4, 10))) {
                    c = 3;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 3049879:
                if (str.equals(A01(94, 4, 31))) {
                    c = 0;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 3049895:
                String[] strArr = A06;
                if (strArr[6].length() != strArr[1].length()) {
                    A06[5] = "5D1VNf4Gt9Q";
                    if (str.equals(A01(98, 4, 91))) {
                        c = 1;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                } else {
                    throw new RuntimeException();
                }
            default:
                c = 65535;
                switch (c) {
                }
        }
    }
}
