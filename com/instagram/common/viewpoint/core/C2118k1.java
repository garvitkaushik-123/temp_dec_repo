package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.k1, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2118k1 extends AbstractC1873fo {
    public static byte[] A01;
    public final /* synthetic */ AnonymousClass81 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{78, 77, 66, 66, 73, 94};
    }

    public C2118k1(AnonymousClass81 anonymousClass81) {
        this.A00 = anonymousClass81;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1873fo
    public final void A03() {
        Y2 y2;
        Y2 y22;
        AnonymousClass76 anonymousClass76;
        C2102jl c2102jl;
        AnonymousClass76 anonymousClass762;
        C08077o c08077o;
        C1874fp c1874fp;
        Y2 y23;
        C08077o c08077o2;
        VA va;
        C08077o c08077o3;
        AnonymousClass76 anonymousClass763;
        C08077o c08077o4;
        C08077o c08077o5;
        C1193Ng A2A;
        AnonymousClass76 anonymousClass764;
        C1874fp c1874fp2;
        AnonymousClass76 anonymousClass765;
        C08077o c08077o6;
        y2 = this.A00.A0H;
        if (!y2.A07()) {
            y22 = this.A00.A0H;
            y22.A05();
            anonymousClass76 = this.A00.A04;
            InterfaceC2156kf A0F = anonymousClass76.A0F();
            c2102jl = this.A00.A02;
            A0F.A4Q(c2102jl != null);
            anonymousClass762 = this.A00.A04;
            anonymousClass762.A0F().A3L();
            c08077o = this.A00.A03;
            AbstractC1213Oa.A02(c08077o.A0y(), AbstractC1449Xm.A00(A00(0, 6, 63)));
            C1586b9 c1586b9 = new C1586b9();
            c1874fp = this.A00.A0B;
            C1586b9 A03 = c1586b9.A03(c1874fp);
            y23 = this.A00.A0H;
            C1586b9 A02 = A03.A02(y23);
            c08077o2 = this.A00.A03;
            Map<String, String> A05 = A02.A04(c08077o2.A0z()).A05();
            va = this.A00.A05;
            c08077o3 = this.A00.A03;
            va.ABJ(c08077o3.A2E(), A05);
            anonymousClass763 = this.A00.A04;
            if (C1379Up.A1A(anonymousClass763)) {
                anonymousClass765 = this.A00.A04;
                C1425Wl A00 = C1425Wl.A00(anonymousClass765);
                String adPlacementType = AdPlacementType.BANNER.toString();
                c08077o6 = this.A00.A03;
                A00.A0E(adPlacementType, c08077o6.A2E());
            }
            c08077o4 = this.A00.A03;
            if (c08077o4 == null) {
                A2A = null;
            } else {
                c08077o5 = this.A00.A03;
                A2A = c08077o5.A2A();
            }
            anonymousClass764 = this.A00.A04;
            C1193Ng.A07(A2A, anonymousClass764);
            c1874fp2 = this.A00.A0B;
            c1874fp2.A0V();
        }
    }
}
