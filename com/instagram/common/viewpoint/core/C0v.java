package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.0v, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0v extends C1B {
    public static byte[] A00;
    public static final CC A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 70);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{9, 34, 43, 56, 7, 43, 62, 41, 34, 47, 56, 100, 36, 37, 36, 47, 98, 99};
    }

    static {
        A01();
        A01 = new C0v();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0v() {
        new C2S(r0) { // from class: com.facebook.ads.redexgen.X.1B
            public final String A00;

            {
                this.A00 = (String) AbstractC2159ki.A04(r2);
            }

            public final String toString() {
                return this.A00;
            }
        };
        final String A002 = A00(0, 18, 12);
    }

    @Override // com.instagram.common.viewpoint.core.CC
    public final int A08(CharSequence sequence, int start) {
        int length = sequence.length();
        AbstractC2159ki.A01(start, length);
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.CC
    public final boolean A09(char c) {
        return false;
    }
}
