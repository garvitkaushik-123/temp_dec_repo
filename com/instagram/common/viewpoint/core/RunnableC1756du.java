package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.du, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1756du implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C07194e A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.SYN, 41, 36, 37, 47, Ascii.DLE, 44, 33, 57, 34, 33, 35, 43, 5, 50, 50, 47, 50};
    }

    public RunnableC1756du(C07194e c07194e) {
        this.A00 = c07194e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0Q(A00(0, 18, 81));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
