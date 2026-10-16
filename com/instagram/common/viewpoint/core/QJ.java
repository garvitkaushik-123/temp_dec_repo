package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class QJ implements InterfaceC1454Xr {
    public static byte[] A03;
    public int A00;
    public String A01;
    public final InterfaceC1454Xr A02;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-93, -93, -107, -104};
    }

    public QJ(InterfaceC1454Xr interfaceC1454Xr) {
        this.A02 = interfaceC1454Xr;
    }

    private void A01() {
        if (this.A01 != null) {
            this.A02.AH8(this.A01 + A00(0, 4, 67) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void AH8(String str) {
        boolean A0A;
        String A04;
        A0A = AbstractC1456Xt.A0A(str);
        if (A0A) {
            A01();
            this.A02.AH8(str);
            return;
        }
        A04 = AbstractC1456Xt.A04(str);
        String filtered = this.A01;
        if (A04.equals(filtered)) {
            this.A00++;
            return;
        }
        A01();
        this.A01 = A04;
        this.A00 = 1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1454Xr
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
