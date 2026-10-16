package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.jm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2103jm extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public final /* synthetic */ C2102jl A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 14);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-107, -116, -95, -116, -98, -114, -99, -108, -101, -97, 101};
    }

    public C2103jm(C2102jl c2102jl) {
        this.A00 = c2102jl;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C1929gi c1929gi;
        AbstractC1575ay abstractC1575ay;
        C2104jn c2104jn;
        c1929gi = this.A00.A03;
        c1929gi.A0F().AKw();
        abstractC1575ay = this.A00.A05;
        StringBuilder append = new StringBuilder().append(A00(0, 11, 29));
        c2104jn = this.A00.A00;
        abstractC1575ay.loadUrl(append.append(c2104jn.A03()).toString());
    }
}
