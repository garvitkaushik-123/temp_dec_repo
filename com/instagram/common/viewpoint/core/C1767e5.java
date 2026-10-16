package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.e5, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1767e5 {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final NR A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 112);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{89, 91, 72, 94, 89, 84, 78, 7, 5, Ascii.SYN, 0, Ascii.CR, 10, 0};
    }

    public C1767e5(int i, int i2, NR nr) {
        this.A01 = i;
        this.A00 = i2;
        this.A02 = nr;
    }

    public final int A02() {
        return this.A01;
    }

    public final NR A03() {
        return this.A02;
    }

    public final Map<String, String> A04() {
        HashMap hashMap = new HashMap();
        StringBuilder append = new StringBuilder().append(this.A01);
        String A00 = A00(0, 0, 41);
        hashMap.put(A00(7, 7, 20), append.append(A00).toString());
        hashMap.put(A00(0, 7, 74), this.A00 + A00);
        return hashMap;
    }
}
