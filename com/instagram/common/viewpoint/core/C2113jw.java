package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.jw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2113jw implements InterfaceC1327Sp {
    public static byte[] A04;
    public final /* synthetic */ N9 A00;
    public final /* synthetic */ AnonymousClass80 A01;
    public final /* synthetic */ AnonymousClass76 A02;
    public final /* synthetic */ Z2 A03;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-109, -82, -74, -71, -78, -79, 109, -63, -68, 109, -79, -68, -60, -69, -71, -68, -82, -79, 109, -82, 109, -70, -78, -79, -74, -82, 123};
    }

    public C2113jw(AnonymousClass80 anonymousClass80, Z2 z2, N9 n9, AnonymousClass76 anonymousClass76) {
        this.A01 = anonymousClass80;
        this.A03 = z2;
        this.A00 = n9;
        this.A02 = anonymousClass76;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADL() {
        long j;
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String A00 = A00(0, 27, 69);
        InterfaceC2156kf A0F = this.A02.A0F();
        j = this.A01.A00;
        A0F.A3N(Y1.A01(j), adErrorType.getErrorCode(), A00);
        this.A00.AEN(this.A01, C1401Vm.A01(adErrorType, A00));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1327Sp
    public final void ADT() {
        N9 n9;
        this.A03.A0J();
        this.A00.ADD(this.A01, this.A03);
        InterfaceC2156kf A0F = this.A02.A0F();
        n9 = this.A01.A01;
        A0F.A4O(n9 != null);
    }
}
