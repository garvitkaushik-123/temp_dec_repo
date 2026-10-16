package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Hr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1050Hr implements InterfaceC1567aq {
    public static byte[] A01;
    public static String[] A02 = {"lymitVL5Elx23yNuagrdcc1tj4byFzuO", "OtHhm4I6MY8qhok47NcALtT", "GJmhN4rXhrf709OMeDU9UKBK4KfDlX2Y", "UKN", "ioCWBc07RK8NAgZ7uqzQ2Ov99bHrMaFb", "vsb8Ufoa8H", "zp4FcHB1hqlJdpy7ZALmHMQwB62WRf78", "qbR"};
    public final /* synthetic */ AnonymousClass55 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_AUTHENTICATION_EXPIRED);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A02[1].length() != 23) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[0] = "68tvMXLM0DzUKrc9PEEpmru8eIlurAzh";
        strArr[2] = "oZlS45uLmtttWs7KR8Y8sKnmk93hftbi";
        A01 = new byte[]{51, 49, 35, 48, Ascii.GS, 44, Ascii.US, 52, 39, 37, Ascii.US, 50, 39, 45, 44, Ascii.GS, 39, Ascii.US, 32};
    }

    static {
        A01();
    }

    public C1050Hr(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF7(String str) {
        C1558ah c1558ah;
        C1558ah c1558ah2;
        C1558ah c1558ah3;
        this.A00.A0H = false;
        c1558ah = this.A00.A05;
        if (c1558ah != null) {
            c1558ah3 = this.A00.A05;
            c1558ah3.setProgress(100);
        }
        c1558ah2 = this.A00.A05;
        YB.A0O(c1558ah2, 8);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AF9(String str) {
        C1558ah c1558ah;
        M8 m8;
        boolean z;
        int i;
        M8 m82;
        this.A00.A0H = true;
        c1558ah = this.A00.A05;
        YB.A0O(c1558ah, 0);
        m8 = this.A00.A04;
        if (m8 != null) {
            m82 = this.A00.A04;
            m82.setUrl(str);
        }
        z = this.A00.A0G;
        if (!z) {
            i = this.A00.A01;
            if (i > 1) {
                this.A00.A0G = true;
                this.A00.A0r(A00(0, 19, 88));
            }
        }
        AnonymousClass55 anonymousClass55 = this.A00;
        if (A02[1].length() != 23) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[7] = "Ijw";
        strArr[3] = "65M";
        AnonymousClass55.A03(anonymousClass55);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFY(int i) {
        boolean z;
        C1558ah c1558ah;
        C1558ah c1558ah2;
        z = this.A00.A0H;
        if (z) {
            c1558ah = this.A00.A05;
            if (c1558ah != null) {
                c1558ah2 = this.A00.A05;
                c1558ah2.setProgress(i);
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFb(String str) {
        M8 m8;
        M8 m82;
        m8 = this.A00.A04;
        if (m8 != null) {
            m82 = this.A00.A04;
            m82.setTitle(str);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1567aq
    public final void AFe() {
        ((AbstractC1068Ij) this.A00).A0B.ADJ(14);
    }
}
