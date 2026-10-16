package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class GU extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public final /* synthetic */ C4V A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 30);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{102, 89, 84, 85, 95, Ascii.DLE, 71, 81, 67, Ascii.DLE, 94, 85, 70, 85, 66, Ascii.DLE, SignedBytes.MAX_POWER_OF_TWO, 66, 85, SignedBytes.MAX_POWER_OF_TWO, 81, 66, 85, 84};
    }

    public GU(C4V c4v) {
        this.A00 = c4v;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        z = this.A00.A0E;
        if (!z) {
            this.A00.A0Q(A00(0, 24, 46));
        }
    }
}
