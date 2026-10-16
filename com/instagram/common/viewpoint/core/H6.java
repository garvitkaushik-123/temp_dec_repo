package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class H6 {
    public static byte[] A03;
    public static String[] A04 = {"HU4YGL7IwZePYHnBLI2PbuSTKGYLERhV", "fFsJPZ9", "v5n0jNlIC8VEk9kcmtdxoaJ1lX", "iKo8W6GX5Xgtq", "u9GtZMdpfWAUjc", "5VwMttC", "nQaWhqWLYmZyv", "CiiXTe9emjL8TKahiZ469ARUB1y9RvmO"};
    public final int A00;
    public final int A01;
    public final String A02;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 55);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-73, -83, -81, -81, -60, -79, -127, -89, -71, -85, -88, -11, -14, 3, -66};
    }

    static {
        A02();
    }

    public H6(int i, int i2, String str) {
        this.A01 = i;
        this.A00 = i2;
        this.A02 = str;
    }

    public static H6 A00(C07364v c07364v) {
        String A01;
        c07364v.A0g(2);
        int profileData = c07364v.A0I();
        int i = profileData >> 1;
        int A0I = ((profileData & 1) << 5) | ((c07364v.A0I() >> 3) & 31);
        if (i == 4 || i == 5 || i == 7) {
            A01 = A01(7, 4, 12);
        } else if (i == 8) {
            A01 = A01(11, 4, 86);
        } else {
            int dvProfile = A04[2].length();
            if (dvProfile != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[3] = "DwVGRWEQxSiyr";
            strArr[6] = "AkYplpXV9U4Nr";
            if (i == 9) {
                A01 = A01(3, 4, 23);
            } else {
                return null;
            }
        }
        StringBuilder append = new StringBuilder().append(A01);
        String A012 = A01(1, 2, 72);
        StringBuilder append2 = append.append(A012).append(i);
        if (A0I >= 10) {
            A012 = A01(0, 1, 82);
        }
        return new H6(i, A0I, append2.append(A012).append(A0I).toString());
    }
}
