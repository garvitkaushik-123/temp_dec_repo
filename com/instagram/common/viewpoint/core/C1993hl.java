package com.instagram.common.viewpoint.core;

import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.hl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1993hl implements QM {
    public static byte[] A01;
    public final /* synthetic */ C7M A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_SKIP_LIMIT_REACHED);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-10, 0, -9};
    }

    public C1993hl(C7M c7m) {
        this.A00 = c7m;
    }

    private final void A02(QN qn) {
        throw new NullPointerException(A00(0, 3, 40));
    }

    @Override // com.instagram.common.viewpoint.core.QM
    public final void ADg(QN qn) {
        A02(qn);
        throw null;
    }
}
