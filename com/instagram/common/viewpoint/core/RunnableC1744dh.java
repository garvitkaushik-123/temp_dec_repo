package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.dh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1744dh implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass56 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{98, 93, 80, 81, 91, 100, 88, 85, 77, 86, 85, 87, 95, 113, 70, 70, 91, 70};
    }

    public RunnableC1744dh(AnonymousClass56 anonymousClass56) {
        this.A00 = anonymousClass56;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0s(A00(0, 18, 82));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
