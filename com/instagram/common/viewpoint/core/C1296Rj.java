package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Build;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.Rj, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1296Rj {
    public static byte[] A04;
    public static String[] A05 = {"MJXAzUwyiLvMzZCrP1QJf8uMs9b", "sHuNTXgsBnW3HGqskl7KH5QkikNWpABj", "q8u9vKEVkpk3dMxroB1EFzM5kwDKfJOq", "eyGwnlQBA4bCraIcft5FxvFgN7f8TC5N", "FmmRYKiwjJl3dX1FB2pV6kIWJpsNLC6h", "flBitaWG3wpDSjkerYNuTkR3r5UhRox3", "xkUQOvOGGj42jMnQjSDdoLzQvdQiYUba", "XqZ9VL6XKZ5Y"};
    public final Intent A00;
    public final C1291Re A01;
    public final C1929gi A02;
    public final VA A03;

    public static String A0K(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(copyOfRange);
    }

    public static void A0L() {
        A04 = new byte[]{99, Byte.MAX_VALUE, 4, 1, 58, 1, 4, 17, 4, 58, 7, Ascii.DLE, Ascii.VT, 1, 9, 0, 43, 41, 36, 36, 45, 58, Ascii.FS, 49, 56, 45, 119, 124, 117, 125, 122, 113, 112, 85, 112, 80, 117, 96, 117, 86, 97, 122, 112, 120, 113, 35, 44, 41, 49, 32, 55, 32, 33, Ascii.SUB, 38, 41, 44, 38, 46, Ascii.SUB, 33, 32, 41, 36, 60, Ascii.SUB, 40, 54, 123, 97, 77, 100, 32, 77, 118, 119, 97, 123, 117, 124, 116, 123, 110, 115, 108, Byte.MAX_VALUE, 91, 126, 94, 123, 110, 123, 88, 111, 116, 126, 118, Byte.MAX_VALUE, 32, 55, 37, 51, 32, 54, 55, 54, 4, 59, 54, 55, Base64.padSymbol, 19, 54, Ascii.SYN, 51, 38, 51, Ascii.DLE, 39, 60, 54, 62, 55, Ascii.SYN, 9, 4, 5, Ascii.SI, 63, Ascii.DC4, 9, Ascii.CR, 5, 63, Ascii.DLE, Ascii.SI, Ascii.FF, Ascii.FF, 9, Ascii.SO, 7, 63, 9, Ascii.SO, Ascii.DC4, 5, Ascii.DC2, Ascii.SYN, 1, Ascii.FF};
    }

    static {
        A0L();
    }

    public C1296Rj(C1291Re c1291Re, Intent intent, VA va, C1929gi c1929gi) {
        this.A01 = c1291Re;
        this.A00 = intent;
        this.A03 = va;
        this.A02 = c1929gi;
    }

    private AbstractC2094jd A00() {
        int i = Build.VERSION.SDK_INT;
        String A0K = A0K(80, 18, 33);
        if (i >= 33) {
            return (AbstractC2094jd) this.A00.getSerializableExtra(A0K, AbstractC2094jd.class);
        }
        Intent intent = this.A00;
        String[] strArr = A05;
        if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
            throw new RuntimeException();
        }
        A05[1] = "LmjecX6z1NXmevkMdudhCsYVgseeBlBL";
        return (AbstractC2094jd) intent.getSerializableExtra(A0K);
    }

    private C2088jT A01() {
        int i = Build.VERSION.SDK_INT;
        String A0K = A0K(26, 19, 47);
        if (i >= 33) {
            return (C2088jT) this.A00.getSerializableExtra(A0K, C2088jT.class);
        }
        return (C2088jT) this.A00.getSerializableExtra(A0K);
    }

    private C08067n A02() {
        int i = Build.VERSION.SDK_INT;
        String A0K = A0K(2, 14, 94);
        if (i >= 33) {
            return (C08067n) this.A00.getSerializableExtra(A0K, C08067n.class);
        }
        return (C08067n) this.A00.getSerializableExtra(A0K);
    }

    private C08047l A03() {
        int i = Build.VERSION.SDK_INT;
        String A0K = A0K(98, 25, 105);
        if (i >= 33) {
            return (C08047l) this.A00.getSerializableExtra(A0K, C08047l.class);
        }
        return (C08047l) this.A00.getSerializableExtra(A0K);
    }

    private InterfaceC1471Yi A05() {
        boolean booleanExtra = this.A00.getBooleanExtra(A0K(68, 12, 41), false);
        boolean isV2Design = C1379Up.A2w(this.A02);
        if (isV2Design) {
            String stringExtra = this.A00.getStringExtra(A0K(45, 23, 126));
            C1291Re c1291Re = this.A01;
            C1929gi c1929gi = this.A02;
            VA va = this.A03;
            C1975hS c1975hS = new C1975hS(this.A01);
            String stringExtra2 = this.A00.getStringExtra(A0K(16, 10, 115));
            if (stringExtra == null) {
                stringExtra = A0K(0, 2, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE);
            }
            int parseInt = Integer.parseInt(stringExtra);
            String clickDelayMs = A05[5];
            if (clickDelayMs.charAt(3) != 'i') {
                throw new RuntimeException();
            }
            A05[4] = "YY09SF1W0j6b6KfCSgRusx8TJPca7HgC";
            return new ViewOnClickListenerC07906x(c1291Re, c1929gi, va, c1975hS, stringExtra2, parseInt);
        }
        return new PZ(this.A01, this.A02, this.A03, new C1975hS(this.A01), booleanExtra);
    }

    private InterfaceC1471Yi A06() {
        C08067n A02 = A02();
        if (A02 == null) {
            return null;
        }
        return A08(new AnonymousClass77(this.A01), A02, A02.A1G(), new MH());
    }

    private InterfaceC1471Yi A07() {
        C08047l A03 = A03();
        if (A03 == null) {
            return null;
        }
        return A08(new AnonymousClass77(this.A01), A03, A03.A1G(), new MG());
    }

    private InterfaceC1471Yi A08(InterfaceC1470Yh interfaceC1470Yh, AbstractC2094jd abstractC2094jd, String str, ZU zu) {
        if (abstractC2094jd.A29().A0H().A07() != null) {
            C1201No A07 = abstractC2094jd.A29().A0H().A07();
            if (abstractC2094jd.A1n()) {
                return new MW(this.A02, this.A03, interfaceC1470Yh, abstractC2094jd, A07, str, zu);
            }
            return new NO(this.A02, this.A03, interfaceC1470Yh, abstractC2094jd, str, zu);
        }
        interfaceC1470Yh.A4j(zu.A81());
        interfaceC1470Yh.A4j(zu.A7w());
        return null;
    }

    private PJ A09(WK wk) {
        AbstractC2094jd A02;
        if (wk == WK.A0G) {
            A02 = A03();
            String[] strArr = A05;
            if (strArr[6].charAt(13) != strArr[2].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "BHjTvXd0Vicw2MzqRZQvpavg35ntNS6w";
            strArr2[2] = "NWBwsXtlP0iXXM4o1NBUiSzzY7vvtUxs";
            if (A02 == null) {
                return null;
            }
        } else if (wk != WK.A0A || (A02 = A02()) == null) {
            return null;
        }
        A02.A1L(this.A01.A08());
        if (A02.A1a()) {
            return new C4U(this.A02, this.A03, new C1335Sx(this.A02), new C1975hS(this.A01), A02);
        }
        return new C4T(this.A02, this.A03, new C1335Sx(this.A02), new C1975hS(this.A01), A02);
    }

    private final MT A0A() {
        return new MT(this.A02, this.A01);
    }

    private MI A0B(RelativeLayout relativeLayout) {
        MI mi = new MI(this.A02, new C1974hR(this), this.A03, new C1975hS(this.A01));
        mi.A05(relativeLayout);
        mi.A04(this.A00.getIntExtra(A0K(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE, 27, 91), 200));
        YB.A0N(relativeLayout, -16777216);
        return mi;
    }

    private AnonymousClass66 A0C() {
        C08067n A02 = A02();
        if (A02 == null) {
            return null;
        }
        return new AnonymousClass66(this.A02, this.A03, new C1975hS(this.A01), A02, new MH(), 1);
    }

    private AnonymousClass66 A0D() {
        C08047l A03 = A03();
        if (A03 == null) {
            return null;
        }
        return new AnonymousClass66(this.A02, this.A03, new C1975hS(this.A01), A03, new MG(), 0);
    }

    private JD A0E() {
        C1713dC A02;
        AbstractC2094jd A00 = A00();
        if (A00 == null || (A02 = AbstractC1714dD.A02(A00.A1D())) == null) {
            return null;
        }
        return new JD(this.A02, new C1975hS(this.A01), A02, A00.A2E());
    }

    private C1011Ge A0F(WK wk) {
        ZU mg;
        InterfaceC1470Yh anonymousClass77;
        C2088jT A01 = A01();
        if (A01 == null) {
            return null;
        }
        if (wk == WK.A04) {
            mg = new MH();
            anonymousClass77 = new C1975hS(this.A01);
        } else {
            mg = new MG();
            anonymousClass77 = new AnonymousClass77(this.A01);
        }
        return new C1011Ge(this.A02, mg, this.A03, A01, new C1335Sx(this.A02), anonymousClass77);
    }

    private C07384x A0G() {
        C08067n A02 = A02();
        if (A02 != null) {
            return new C07384x(this.A02, new MH(), this.A03, A02, new C1335Sx(this.A02), new C1975hS(this.A01));
        }
        if (A05[1].charAt(5) != 'X') {
            throw new RuntimeException();
        }
        A05[3] = "TvLwsmu9uaa0faVP4fF8b7PGg31O8U7I";
        return null;
    }

    private C4V A0H() {
        C08067n A02 = A02();
        if (A02 == null) {
            return null;
        }
        return new C4V(this.A02, new MH(), this.A03, A02, new C1335Sx(this.A02), new C1975hS(this.A01));
    }

    private C4V A0I() {
        C08047l A03 = A03();
        if (A03 == null) {
            return null;
        }
        return new C4V(this.A02, new MG(), this.A03, A03, new C1335Sx(this.A02), new AnonymousClass77(this.A01));
    }

    private GB A0J(WK wk) {
        AbstractC2094jd A02;
        AbstractC2094jd A022;
        if (wk == WK.A0J) {
            A02 = A03();
            if (A02 == null || (A022 = A03()) == null) {
                return null;
            }
        } else if (wk != WK.A0E || (A02 = A02()) == null || (A022 = A02()) == null) {
            return null;
        }
        return new GB(this.A02, this.A03, A02, A022, new AnonymousClass77(this.A01), this.A01, wk);
    }

    public final InterfaceC1471Yi A0M(WK wk, RelativeLayout relativeLayout) {
        if (wk == null) {
            return null;
        }
        switch (C1295Ri.A00[wk.ordinal()]) {
            case 1:
                if (relativeLayout != null) {
                    return A0B(relativeLayout);
                }
                return null;
            case 2:
            case 3:
                return A09(wk);
            case 4:
                return A0I();
            case 5:
                return A07();
            case 6:
                InterfaceC1471Yi A052 = A05();
                if (A05[4].charAt(13) != '3') {
                    A05[1] = "IIJ0HXviRARge0yizoGTY0JUA2Nzjczv";
                    return A052;
                }
                String[] strArr = A05;
                strArr[6] = "UHMFNKnwuKHYyMbevaCPtufG1H9dhH1t";
                strArr[2] = "s6UgSHR7PtydXMVItCKPjBxPhDp7nABU";
                return A052;
            case 7:
                return A0H();
            case 8:
                return A0G();
            case 9:
                return A06();
            case 10:
                return A0E();
            case 11:
                AnonymousClass66 A0C = A0C();
                if (A05[5].charAt(3) != 'i') {
                    throw new RuntimeException();
                }
                A05[3] = "7AQwH6OZkLua7JLoKEhUfmskdEmJStMK";
                return A0C;
            case 12:
                return A0D();
            case 13:
            case 14:
                return A0F(wk);
            case 15:
                return A0A();
            case 16:
            case 17:
                return A0J(wk);
            default:
                return null;
        }
    }
}
