package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.e1, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1763e1 implements InterfaceC1878ft {
    public static byte[] A01;
    public final C1925ge A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 74);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{82, 39, 76, 72, 39, 90, 101, 101, 102, 39, 88, 101, Byte.MAX_VALUE, 126, 99, 100, 109, 39, 94, 101, 97, 111, 100, Ascii.FF, 10, Ascii.FS, Ascii.VT, 84, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.ETB, Ascii.CR};
    }

    public C1763e1(C1925ge c1925ge) {
        this.A00 = c1925ge;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1878ft
    public final Map<String, String> A6g(boolean z) {
        HashMap hashMap = new HashMap();
        if (!SZ.A00().A04()) {
            hashMap.put(A00(0, 23, 64), UG.A00().A01(this.A00, true).A04());
        }
        hashMap.put(A00(23, 10, 51), UJ.A06(new C1352To(this.A00), this.A00, z));
        return hashMap;
    }
}
