package com.instagram.common.viewpoint.core;

import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Wv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1434Wv implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C1929gi A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_SETUP_REQUIRED);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-55, -50, -51, -58, -1, -3, 6, -3, 10, 1, -5};
    }

    public RunnableC1434Wv(C1929gi c1929gi) {
        this.A00 = c1929gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            C1342Te otsl = new C1342Te(A00(0, 4, 14));
            otsl.A05(1);
            otsl.A06(1);
            otsl.A0A(false);
            this.A00.A08().ABD(A00(4, 7, 44), AbstractC1341Td.A1Y, otsl);
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
