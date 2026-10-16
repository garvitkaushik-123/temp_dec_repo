package com.instagram.common.viewpoint.core;

import java.io.Serializable;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Nj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1196Nj implements Serializable {
    public static byte[] A04 = null;
    public static final long serialVersionUID = 351643298236575729L;
    public final String A00;
    public final String A01;
    public final String A02;
    public final String A03;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 63);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-124, -2, -26, -8, -11, -11, -24, -15, -26, -4, 0, -36, -46, -42, -62, -49, -43, -54, -43, -38, -34};
    }

    public C1196Nj(C1195Ni c1195Ni) {
        String str;
        String str2;
        String str3;
        String str4;
        str = c1195Ni.A02;
        this.A02 = str;
        str2 = c1195Ni.A03;
        this.A03 = str2;
        str3 = c1195Ni.A00;
        this.A00 = str3;
        str4 = c1195Ni.A01;
        this.A01 = str4;
    }

    public static String A01(String str, String str2, int i) {
        String replace = str.replace(A00(1, 10, 68), str2);
        String A00 = A00(0, 0, 39);
        if (i > 0) {
            StringBuilder append = new StringBuilder().append(i);
            String updatedString = A00(0, 1, 37);
            A00 = append.append(updatedString).toString();
        }
        String updatedString2 = A00(11, 10, 34);
        return replace.replace(updatedString2, A00);
    }

    public final String A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }

    public final String A05() {
        return this.A02;
    }

    public final String A06(String str, int i) {
        return A01(this.A03, str, i);
    }
}
