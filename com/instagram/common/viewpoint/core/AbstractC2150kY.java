package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.kY, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2150kY<T> implements M0<T> {
    public static byte[] A01;
    public final String A00;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 21);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{-90, -83, -92, -92};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kY != com.facebook.ads.funnel.FunnelParamType$AbstractFunnelParamType<T> */
    public AbstractC2150kY(String str) {
        this.A00 = str;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kY != com.facebook.ads.funnel.FunnelParamType$AbstractFunnelParamType<T> */
    public C1161Lz A04(T t) {
        return new C1161Lz(this, t == null ? A02(0, 4, 35) : t.toString());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kY != com.facebook.ads.funnel.FunnelParamType$AbstractFunnelParamType<T> */
    @Override // com.instagram.common.viewpoint.core.M0
    public final String getName() {
        return this.A00;
    }
}
