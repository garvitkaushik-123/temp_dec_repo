package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class HX {
    public static byte[] A02;
    public static String[] A03 = {"", "4aEfCmC", "2kTu4wHTiMw5FCYmIpZKoA3S7RkYvI9O", "", "w", "MqF3b2p", "5cCqnzmPstBPsSiWHPZbbxeHAyWMz3nO", "kSg1dz9TqTWY2puBAJqsQN0JUmM78NMM"};
    public final HZ A00;
    public final HZ A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 82);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.ESC, Ascii.ETB, 123, 7};
    }

    static {
        A01();
    }

    public HX(HZ hz) {
        this(hz, hz);
    }

    public HX(HZ hz, HZ hz2) {
        this.A00 = (HZ) AbstractC07133y.A01(hz);
        this.A01 = (HZ) AbstractC07133y.A01(hz2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HX hx = (HX) obj;
        if (A03[7].charAt(24) != 'U') {
            throw new RuntimeException();
        }
        A03[4] = "g";
        return this.A00.equals(hx.A00) && this.A01.equals(hx.A01);
    }

    public final int hashCode() {
        return (this.A00.hashCode() * 31) + this.A01.hashCode();
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(A00(2, 1, 114)).append(this.A00);
        if (!this.A00.equals(this.A01)) {
            str = A00(0, 2, 101) + this.A01;
        } else {
            if (A03[0].length() != 0) {
                throw new RuntimeException();
            }
            A03[0] = "";
            str = A00(0, 0, 76);
        }
        return append.append(str).append(A00(3, 1, 8)).toString();
    }
}
