package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Vw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1410Vw extends N2 {
    public static byte[] A01;
    public final /* synthetic */ UK A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 30);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{95, 112, 101, 120, 103, 116, 49, 112, 117, 98, 49, 124, 112, Byte.MAX_VALUE, 112, 118, 116, 99, 49, 101, 121, 116, 120, 99, 49, 126, 102, Byte.MAX_VALUE, 49, 120, 124, 97, 99, 116, 98, 98, 120, 126, Byte.MAX_VALUE, 98, 63};
    }

    public C1410Vw(UK uk) {
        this.A00 = uk;
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0B(C2111ju c2111ju) {
        this.A00.A1d(c2111ju);
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0C() {
        InterfaceC1359Tv interfaceC1359Tv;
        InterfaceC1359Tv interfaceC1359Tv2;
        interfaceC1359Tv = this.A00.A0I;
        if (interfaceC1359Tv != null) {
            interfaceC1359Tv2 = this.A00.A0I;
            interfaceC1359Tv2.ACm();
        }
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0D() {
        throw new IllegalStateException(A00(0, 41, 15));
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0F(N1 n1) {
        C07997g c07997g;
        C07997g c07997g2;
        c07997g = this.A00.A0B;
        if (c07997g != null) {
            c07997g2 = this.A00.A0B;
            c07997g2.A0M();
        }
    }

    @Override // com.instagram.common.viewpoint.core.N2
    public final void A0G(C1401Vm c1401Vm) {
        long j;
        InterfaceC1359Tv interfaceC1359Tv;
        InterfaceC1359Tv interfaceC1359Tv2;
        InterfaceC1155Lt A0F = this.A00.A16().A0F();
        j = this.A00.A00;
        A0F.A3N(Y1.A01(j), c1401Vm.A03().getErrorCode(), c1401Vm.A04());
        interfaceC1359Tv = this.A00.A0I;
        if (interfaceC1359Tv != null) {
            interfaceC1359Tv2 = this.A00.A0I;
            interfaceC1359Tv2.ADp(c1401Vm);
        }
    }
}
