package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.8y, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C08398y extends Exception {
    public static byte[] A03;
    public final int A00;
    public final C2489qI A01;
    public final boolean A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 74);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-26, Ascii.SUB, 9, Ascii.SO, Ascii.DC4, -7, Ascii.ETB, 6, 8, Ascii.DLE, -59, Ascii.FS, Ascii.ETB, Ascii.SO, Ascii.EM, 10, -59, Ascii.VT, 6, Ascii.SO, 17, 10, 9, -33, -59};
    }

    public C08398y(int i, C2489qI c2489qI, boolean z) {
        super(A00(0, 25, 91) + i);
        this.A02 = z;
        this.A00 = i;
        this.A01 = c2489qI;
    }
}
