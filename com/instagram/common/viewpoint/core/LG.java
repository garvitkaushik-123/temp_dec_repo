package com.instagram.common.viewpoint.core;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class LG {
    public static byte[] A05;
    public int A00;
    public String A01;
    public final int A02;
    public final int A03;
    public final String A04;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 16);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-81, 126, 124, -123, 124, -119, 120, -117, 124, 101, 124, -114, 96, 123, 63, SignedBytes.MAX_POWER_OF_TWO, 55, -124, -116, -118, -117, 55, 121, 124, 55, 122, 120, -125, -125, 124, 123, 55, 121, 124, 125, -122, -119, 124, 55, -119, 124, -117, -119, Byte.MIN_VALUE, 124, -115, Byte.MIN_VALUE, -123, 126, 55, Byte.MIN_VALUE, 123, -118, 69};
    }

    public LG(int i, int i2) {
        this(Integer.MIN_VALUE, i, i2);
    }

    public LG(int i, int i2, int i3) {
        String A00 = A00(0, 0, 0);
        this.A04 = i != Integer.MIN_VALUE ? i + A00(0, 1, 112) : A00;
        this.A02 = i2;
        this.A03 = i3;
        this.A00 = Integer.MIN_VALUE;
        this.A01 = A00;
    }

    private void A01() {
        if (this.A00 != Integer.MIN_VALUE) {
        } else {
            throw new IllegalStateException(A00(1, 53, 7));
        }
    }

    public final int A03() {
        A01();
        return this.A00;
    }

    public final String A04() {
        A01();
        return this.A01;
    }

    public final void A05() {
        this.A00 = this.A00 == Integer.MIN_VALUE ? this.A02 : this.A00 + this.A03;
        this.A01 = this.A04 + this.A00;
    }
}
