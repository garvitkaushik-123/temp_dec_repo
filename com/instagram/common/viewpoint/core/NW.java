package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public enum NW {
    A04(A01(23, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE)),
    A05(A01(37, 9, 3));

    public static byte[] A01;
    public static String[] A02 = {"wiqydbsLJDwKBvl8t", "43d9HmwIqa0UmHFIq", "pggHvImyjq29EoPdIbNPEyFQYY47zx5L", "Y7HVzfyHvrAyRWnGs1HIvpl", "hbOUIe", "Z6uWuqD1EDiaZecfB", "H4uwq6", "uO2zzJUzM8GpymnowP"};
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            String[] strArr = A02;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A02[7] = "YRQbc7SZzU6A3uauK9TIi077IJfJ6";
            copyOfRange[i4] = (byte) ((b - i3) - 59);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{-84, -72, -73, -67, -82, -63, -67, -66, -86, -75, -56, -86, -71, -71, -30, -45, -39, -41, -15, -30, -31, -27, -26, Ascii.DC4, 32, Ascii.US, 37, Ascii.SYN, 41, 37, 38, Ascii.DC2, Ascii.GS, Ascii.DLE, Ascii.DC2, 33, 33, -82, -97, -91, -93, -99, -82, -83, -79, -78};
        String[] strArr = A02;
        if (strArr[3].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[6] = "ja6ocK";
        strArr2[4] = "zrwWzc";
    }

    static {
        A02();
    }

    NW(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0046, code lost:
    
        if (r3 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0056, code lost:
    
        if (r3 != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static NW A00(String str) {
        char c;
        switch (str.hashCode()) {
            case 883765328:
                if (str.equals(A01(37, 9, 3))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1434358835:
                boolean equals = str.equals(A01(23, 14, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE));
                if (A02[7].length() == 12) {
                    String[] strArr = A02;
                    strArr[3] = "XJGJWrBy1UqGLv6Rhel9amw";
                    strArr[1] = "eBE1kZuIIDAbDWtcc";
                    break;
                } else {
                    A02[7] = "bogI3bwqsUF49nq3u6zYPkLLi";
                    break;
                }
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return A04;
            default:
                NW nw = A05;
                if (A02[2].charAt(22) == 'a') {
                    throw new RuntimeException();
                }
                A02[7] = "wI7Mn7kKRaTG8Mvy9wZ";
                return nw;
        }
    }
}
