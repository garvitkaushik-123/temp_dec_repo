package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.dY, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1735dY implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C5G A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 83);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{78, 113, 124, 125, 119, 72, 116, 121, 97, 122, 121, 123, 115, 93, 106, 106, 119, 106};
    }

    public RunnableC1735dY(C5G c5g) {
        this.A00 = c5g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC1749dm interfaceC1749dm;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1749dm = this.A00.A00.A0Z;
            interfaceC1749dm.AGQ(A00(0, 18, 75));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
