package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class W7 extends AbstractRunnableC1416Wc {
    public static byte[] A07;
    public final /* synthetic */ long A00;
    public final /* synthetic */ W6 A01;
    public final /* synthetic */ String A02;
    public final /* synthetic */ String A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ boolean A05;
    public final /* synthetic */ boolean A06;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 82);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{Ascii.NAK, 33, Ascii.US, -32, Ascii.CAN, 19, Ascii.NAK, Ascii.ETB, Ascii.DC4, 33, 33, Ascii.GS, -32, Ascii.GS, 19, 38, 19, 32, 19, -32, 34, 36, 33, 40, Ascii.ESC, Ascii.SYN, Ascii.ETB, 36, -32, -5, 32, 37, 38, 19, Ascii.RS, Ascii.RS, 4, Ascii.ETB, Ascii.CAN, Ascii.ETB, 36, 36, Ascii.ETB, 36, 2, 36, 33, 40, Ascii.ESC, Ascii.SYN, Ascii.ETB, 36, -74, -62, -64, -127, -68, -63, -58, -57, -76, -70, -59, -76, -64, -127, -74, -62, -63, -57, -72, -63, -57, -61, -59, -62, -55, -68, -73, -72, -59, -127, -100, -63, -58, -57, -76, -65, -65, -91, -72, -71, -72, -59, -59, -72, -59, -93, -59, -62, -55, -68, -73, -72, -59};
    }

    public W7(W6 w6, boolean z, String str, String str2, String str3, long j, boolean z2) {
        this.A01 = w6;
        this.A06 = z;
        this.A02 = str;
        this.A04 = str2;
        this.A03 = str3;
        this.A00 = j;
        this.A05 = z2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean fb4aResult;
        fb4aResult = this.A01.A03(A00(0, 52, 96), this.A06, this.A02, this.A04, this.A03, this.A00);
        if (fb4aResult) {
            return;
        }
        boolean fb4aResult2 = this.A05;
        if (fb4aResult2) {
            this.A01.A03(A00(52, 53, 1), this.A06, this.A02, this.A04, this.A03, this.A00);
        }
    }
}
