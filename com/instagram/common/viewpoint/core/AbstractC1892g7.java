package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.g7, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1892g7 {
    public static byte[] A05;
    public static String[] A06 = {"cXHhWS2U0AEbFhhmPHmVuH", "wVYzC7Nkmxeng7LXEltnvgZwmBeHxDlH", "QdB4DFNTOqs3kzyCIXC3RbQ0s8ofNHfi", "NfO94uVHpQsZyAD7D3sB88", "Qb7NVaH0CDkMRhWHzZDzGB0JzykCOgpa", "79nTtHn72qGvVt6br", "vvJx1YlMdzFVt9WMGmsv2mWYh0j6ZH0a", "LFbWjj4EQG077AWDW1GPYYaHkUkOcLUG"};
    public C1888g3 A00;
    public EnumC1891g6 A01;
    public String A02;
    public String A03;
    public byte[] A04;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-121};
        String[] strArr = A06;
        if (strArr[3].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[2] = "4G6bp2JlnqCaKfrAR3d18U2njy0G4HP7";
        strArr2[6] = "szJTv6Q1Z3W9cwFEkaj97Hf7uwsDfHCt";
        A05 = bArr;
    }

    static {
        A01();
    }

    public AbstractC1892g7(String str, C1894g9 c1894g9, C1888g3 c1888g3) {
        this.A03 = A00(0, 0, 34);
        if (str != null) {
            this.A03 = str;
        }
        if (c1894g9 != null && !c1894g9.A06().isEmpty()) {
            this.A03 += A00(0, 1, 55) + c1894g9.A06();
        }
        this.A00 = c1888g3;
    }

    public final C1888g3 A02() {
        return this.A00;
    }

    public final EnumC1891g6 A03() {
        return this.A01;
    }

    public final String A04() {
        return this.A02;
    }

    public final String A05() {
        return this.A03;
    }

    public final byte[] A06() {
        return this.A04;
    }
}
