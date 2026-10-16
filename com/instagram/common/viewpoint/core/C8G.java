package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.8G, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public class C8G extends AbstractC2150kY<M5> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 115);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{83, 90, 81, 81};
    }

    public C8G(String str) {
        super(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2150kY
    /* renamed from: A05, reason: merged with bridge method [inline-methods] */
    public final C1161Lz A04(M5 m5) {
        return new C1161Lz(this, m5 == null ? A00(0, 4, 114) : m5.A03());
    }
}
