package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class J8 extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public final /* synthetic */ C1705d4 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{87, 104, 101, 100, 110, 33, 118, 96, 114, 33, 111, 100, 119, 100, 115, 33, 113, 115, 100, 113, 96, 115, 100, 101};
    }

    public J8(C1705d4 c1705d4) {
        this.A00 = c1705d4;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        z = this.A00.A03;
        if (z) {
            return;
        }
        this.A00.A0I(A00(0, 24, 115));
    }
}
