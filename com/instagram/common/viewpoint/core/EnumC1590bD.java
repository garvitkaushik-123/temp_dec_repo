package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.bD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public enum EnumC1590bD {
    A05(0),
    A04(1),
    A03(2);

    public static byte[] A01;
    public int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 120);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{78, 67, 76, 70, 81, 65, 67, 82, 71, 56, 39, 58, 60, 58, 41, 33, 60, Ascii.SYN, Ascii.CR, Ascii.DLE, 19, 6, 0, 10, 5, 10, 6, 7};
    }

    static {
        A02();
    }

    EnumC1590bD(int i) {
        this.A00 = i;
    }

    public static EnumC1590bD A00(int i) {
        for (EnumC1590bD enumC1590bD : values()) {
            if (enumC1590bD.A00 == i) {
                return enumC1590bD;
            }
        }
        return A04;
    }

    public final int A04() {
        return this.A00;
    }
}
