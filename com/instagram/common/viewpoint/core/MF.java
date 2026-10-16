package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public class MF implements InterfaceC1494Zf {
    public static byte[] A01;
    public static String[] A02 = {"8F1ylXiPLmOJlxHuSB0OfTD8ERnub0Jc", "S6BOYeNFrgFu99vNdASrFyo", "dJPilyeR7SZ6Rr21hdX", "myhsKKLHgmC4nogMMn1nxIO", "jSXY2xjzyKT8sDO", "m4o2VQ2UIP9pfbMg6FrqdCCZlyPN5tpn", "ArrKoNW9WxnAbKv8I1vfh8MoVmXkp7wv", "MU6Xe0UyfSgNRnTq3TqZG"};
    public final /* synthetic */ AbstractC1492Zd A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 17);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{1, Ascii.CR, Ascii.SI, 76, 4, 3, 1, 7, 0, Ascii.CR, Ascii.CR, 9, 76, 3, 6, 17, 76, 3, 6, Ascii.DLE, 7, Ascii.DC2, Ascii.CR, Ascii.DLE, Ascii.SYN, Ascii.VT, Ascii.FF, 5, 76, 36, 43, 44, 43, 49, 42, Base64.padSymbol, 35, 38, Base64.padSymbol, 48, 39, 50, 45, 48, 54, 43, 44, 37, Base64.padSymbol, 36, 46, 45, 53};
    }

    static {
        A01();
    }

    public MF(AbstractC1492Zd abstractC1492Zd) {
        this.A00 = abstractC1492Zd;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void A53() {
        InterfaceC1470Yh interfaceC1470Yh;
        InterfaceC1470Yh interfaceC1470Yh2;
        interfaceC1470Yh = this.A00.A09;
        if (interfaceC1470Yh == null) {
            return;
        }
        interfaceC1470Yh2 = this.A00.A09;
        interfaceC1470Yh2.A4j(A00(0, 53, 115));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void A54() {
        InterfaceC1471Yi interfaceC1471Yi;
        InterfaceC1491Zc interfaceC1491Zc;
        InterfaceC1491Zc interfaceC1491Zc2;
        InterfaceC1471Yi interfaceC1471Yi2;
        this.A00.A0P();
        interfaceC1471Yi = this.A00.A0A;
        if (interfaceC1471Yi != null) {
            interfaceC1471Yi2 = this.A00.A0A;
            interfaceC1471Yi2.AFi(true);
        }
        interfaceC1491Zc = this.A00.A05;
        if (interfaceC1491Zc != null) {
            interfaceC1491Zc2 = this.A00.A05;
            interfaceC1491Zc2.ACr();
        }
        this.A00.A0E();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void A9c() {
        C1223Ok c1223Ok;
        C1223Ok c1223Ok2;
        C1223Ok c1223Ok3;
        C1929gi c1929gi;
        c1223Ok = this.A00.A04;
        if (c1223Ok == null) {
            A54();
            if (A02[0].charAt(15) == 'S') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "E4Sw3glaT0j7tztglKcmJ4X";
            strArr[3] = "i6sG1P4DTWmVPFfNkRQLKmp";
            return;
        }
        AbstractC1492Zd.A03(this.A00);
        c1223Ok2 = this.A00.A04;
        if (c1223Ok2.A02() != null) {
            AbstractC1492Zd abstractC1492Zd = this.A00;
            c1223Ok3 = this.A00.A04;
            abstractC1492Zd.A0H(c1223Ok3.A02());
        } else {
            this.A00.A0F();
        }
        c1929gi = this.A00.A07;
        if (C1379Up.A2Z(c1929gi)) {
            this.A00.performAccessibilityAction(128, null);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void AAp() {
        C1219Og c1219Og;
        C1222Oj c1222Oj;
        C1929gi c1929gi;
        C1219Og c1219Og2;
        String str;
        c1219Og = this.A00.A06;
        if (!TextUtils.isEmpty(c1219Og.A0I())) {
            X6 x6 = new X6();
            c1929gi = this.A00.A07;
            c1219Og2 = this.A00.A06;
            Uri A00 = XB.A00(c1219Og2.A0I());
            str = this.A00.A0B;
            X6.A0O(x6, c1929gi, A00, str);
        }
        c1222Oj = this.A00.A03;
        c1222Oj.A04();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void AAq() {
        InterfaceC1471Yi interfaceC1471Yi;
        C1219Og c1219Og;
        C1222Oj c1222Oj;
        C1929gi c1929gi;
        C1219Og c1219Og2;
        String str;
        InterfaceC1471Yi interfaceC1471Yi2;
        this.A00.A0P();
        interfaceC1471Yi = this.A00.A0A;
        if (interfaceC1471Yi != null) {
            interfaceC1471Yi2 = this.A00.A0A;
            interfaceC1471Yi2.AFi(true);
        }
        c1219Og = this.A00.A06;
        if (!TextUtils.isEmpty(c1219Og.A0C())) {
            X6 x6 = new X6();
            c1929gi = this.A00.A07;
            c1219Og2 = this.A00.A06;
            Uri A00 = XB.A00(c1219Og2.A0C());
            str = this.A00.A0B;
            X6.A0O(x6, c1929gi, A00, str);
        }
        c1222Oj = this.A00.A03;
        c1222Oj.A06();
        this.A00.A0E();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void AEr(EnumC1221Oi enumC1221Oi) {
        EnumC1221Oi enumC1221Oi2;
        C1219Og c1219Og;
        C1223Ok A0B;
        C1219Og c1219Og2;
        C1219Og c1219Og3;
        AbstractC1492Zd.A02(this.A00);
        this.A00.A02 = enumC1221Oi;
        enumC1221Oi2 = this.A00.A02;
        if (enumC1221Oi2 != EnumC1221Oi.A04) {
            AbstractC1492Zd abstractC1492Zd = this.A00;
            if (A02[0].charAt(15) != 'S') {
                String[] strArr = A02;
                strArr[6] = "aVWWA7RlXQ4WxwD1lKH3adLgfY6YTeho";
                strArr[5] = "uW2I9G42iXHj1OU85KkNtz4HKFKkrOfh";
                c1219Og2 = abstractC1492Zd.A06;
                A0B = c1219Og2.A0B();
            } else {
                c1219Og = abstractC1492Zd.A06;
                A0B = c1219Og.A0B();
            }
        } else {
            c1219Og3 = this.A00.A06;
            A0B = c1219Og3.A0A();
        }
        AbstractC1492Zd abstractC1492Zd2 = this.A00;
        String[] strArr2 = A02;
        if (strArr2[6].charAt(11) == strArr2[5].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A02;
        strArr3[1] = "uGU0gkKbqe2rkd9hIKZj6BU";
        strArr3[3] = "Cw3GzUJKwEhWx9AKZcDfceI";
        abstractC1492Zd2.A0H(A0B);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1494Zf
    public final void AF4(C1223Ok c1223Ok) {
        C1222Oj c1222Oj;
        AbstractC1492Zd.A02(this.A00);
        c1222Oj = this.A00.A03;
        c1222Oj.A07(c1223Ok.A01());
        if (!c1223Ok.A05().isEmpty()) {
            AbstractC1492Zd abstractC1492Zd = this.A00;
            String[] strArr = A02;
            if (strArr[2].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[6] = "wullz3k0Ma2cYDBinBI95xBWIfHYuzlI";
            strArr2[5] = "wkJ6jlNGXVBBqnzofRVuEUhlZdNAnE5y";
            abstractC1492Zd.A0H(c1223Ok);
            return;
        }
        this.A00.A0G(c1223Ok);
    }
}
