package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.facebook.ads.redexgen.X.lL, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2197lL implements InterfaceC1131Kv {
    public static byte[] A0B;
    public static String[] A0C = {"Sri33Nkjg2q1UfSTa8c1c4poMbcRpRLi", "09hX7cFAjusi8bmxYUkedKuhTIWBBFyj", "9Nq5ciBjH0E2wAdqO8kDicSSF4ASqfED", "QsWxT4gaPPGppGCvyiz5txfiFuAY8zGx", "IfMd", "WTVPPiGNk6qIrjWgxgkH9oFnGfUzUO7U", "kZSjpU6etDs1IBDvrqsQrqQjBcHBIo8z", "H6v3RmW3GvMpIK1G5kWvIHPLiCmsEM1C"};
    public static final float[] A0D;
    public long A00;
    public long A01;
    public InterfaceC1036Hd A02;
    public C1135Kz A03;
    public String A04;
    public boolean A05;
    public final C07364v A06;
    public final C1134Ky A07;
    public final L4 A08;
    public final LJ A09;
    public final boolean[] A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 69);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0B = new byte[]{66, 56, 60, 57, 88, 111, 107, 110, 111, 120, Ascii.DC2, 53, 45, 58, 55, 50, 63, 123, 58, 40, 43, 62, 56, 47, 123, 41, 58, 47, 50, 52, 125, 90, 66, 85, 88, 93, 80, Ascii.DC4, 66, 91, 68, 107, 93, 90, 87, 70, 81, 89, 81, 90, SignedBytes.MAX_POWER_OF_TWO, 107, SignedBytes.MAX_POWER_OF_TWO, 93, 89, 81, 107, 70, 81, 71, 91, 88, 65, SignedBytes.MAX_POWER_OF_TWO, 93, 91, 90, 77, 118, 112, 121, 118, 124, 116, 125, 124, 56, 110, 113, 124, 125, 119, 56, 119, 122, 114, 125, 123, 108, 56, 116, 121, 97, 125, 106, 56, 107, 112, 121, 104, 125, 45, 50, 63, 62, 52, 116, 54, 43, 111, 45, 118, 62, 40};
    }

    static {
        A02();
        A0D = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    }

    public C2197lL() {
        this(null);
    }

    public C2197lL(LJ lj) {
        this.A09 = lj;
        this.A0A = new boolean[4];
        this.A07 = new C1134Ky(128);
        this.A00 = -9223372036854775807L;
        if (lj != null) {
            this.A08 = new L4(178, 128);
            this.A06 = new C07364v();
        } else {
            this.A08 = null;
            this.A06 = null;
        }
    }

    public static C2489qI A00(C1134Ky c1134Ky, int i, String str) {
        float f;
        byte[] copyOf = Arrays.copyOf(c1134Ky.A02, c1134Ky.A00);
        C07354u c07354u = new C07354u(copyOf);
        c07354u.A0A(i);
        c07354u.A0A(4);
        c07354u.A07();
        c07354u.A09(8);
        if (c07354u.A0H()) {
            c07354u.A09(4);
            c07354u.A09(3);
        }
        int A04 = c07354u.A04(4);
        String A01 = A01(10, 20, 30);
        String A012 = A01(0, 10, 79);
        if (A04 == 15) {
            int A042 = c07354u.A04(8);
            String[] strArr = A0C;
            if (strArr[1].charAt(10) != strArr[6].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[1] = "pNVnHJusVCsmPjFYzkWaaBxpUvIALZFH";
            strArr2[6] = "5W5bueKBkmsFSlOt61KpehVGJe26nslO";
            int A043 = c07354u.A04(8);
            if (A043 == 0) {
                AbstractC07214g.A07(A012, A01);
                f = 1.0f;
            } else {
                f = A042 / A043;
            }
        } else if (A04 < A0D.length) {
            f = A0D[A04];
        } else {
            AbstractC07214g.A07(A012, A01);
            f = 1.0f;
        }
        if (c07354u.A0H()) {
            c07354u.A09(2);
            c07354u.A09(1);
            boolean A0H = c07354u.A0H();
            if (A0C[2].charAt(24) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr3 = A0C;
            strArr3[1] = "a7iwuG0S7TsvBO2g0yc87XIFTOWCV0GN";
            strArr3[6] = "G4F0gcHQBssTN40k2zdU8kwKQEhYA5ZF";
            if (A0H) {
                c07354u.A09(15);
                c07354u.A07();
                c07354u.A09(15);
                c07354u.A07();
                c07354u.A09(15);
                c07354u.A07();
                c07354u.A09(3);
                c07354u.A09(11);
                c07354u.A07();
                c07354u.A09(15);
                c07354u.A07();
            }
        }
        if (c07354u.A04(2) != 0) {
            AbstractC07214g.A07(A012, A01(67, 34, 93));
        }
        c07354u.A07();
        int A044 = c07354u.A04(16);
        c07354u.A07();
        if (c07354u.A0H()) {
            if (A044 == 0) {
                AbstractC07214g.A07(A012, A01(30, 37, 113));
            } else {
                int i2 = 0;
                for (int i3 = A044 - 1; i3 > 0; i3 >>= 1) {
                    i2++;
                }
                c07354u.A09(i2);
            }
        }
        c07354u.A07();
        int videoObjectLayerWidth = c07354u.A04(13);
        c07354u.A07();
        int A045 = c07354u.A04(13);
        c07354u.A07();
        c07354u.A07();
        return new C06802p().A0y(str).A11(A01(101, 13, 30)).A0r(videoObjectLayerWidth).A0f(A045).A0Y(f).A12(Collections.singletonList(copyOf)).A14();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x009e, code lost:
    
        throw new java.lang.RuntimeException();
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5A(C07364v c07364v) {
        AbstractC07133y.A02(this.A03);
        AbstractC07133y.A02(this.A02);
        int A09 = c07364v.A09();
        int A0A = c07364v.A0A();
        byte[] A0l = c07364v.A0l();
        long j = this.A01;
        int offset = c07364v.A07();
        this.A01 = j + offset;
        InterfaceC1036Hd interfaceC1036Hd = this.A02;
        int offset2 = c07364v.A07();
        interfaceC1036Hd.AIr(c07364v, offset2);
        while (true) {
            int lengthToStartCode = HS.A04(A0l, A09, A0A, this.A0A);
            if (lengthToStartCode == A0A) {
                if (!this.A05) {
                    C1134Ky c1134Ky = this.A07;
                    int limit = A0C[7].charAt(0);
                    if (limit != 51) {
                        A0C[4] = "80MY";
                        c1134Ky.A03(A0l, A09, A0A);
                    }
                }
                this.A03.A03(A0l, A09, A0A);
                if (this.A08 != null) {
                    this.A08.A02(A0l, A09, A0A);
                    return;
                }
                return;
            }
            int offset3 = lengthToStartCode + 3;
            int startCodeValue = c07364v.A0l()[offset3] & 255;
            int i = lengthToStartCode - A09;
            if (!this.A05) {
                if (i > 0) {
                    this.A07.A03(A0l, A09, lengthToStartCode);
                }
                int limit2 = i < 0 ? -i : 0;
                if (this.A07.A04(startCodeValue, limit2)) {
                    InterfaceC1036Hd interfaceC1036Hd2 = this.A02;
                    C1134Ky c1134Ky2 = this.A07;
                    String[] strArr = A0C;
                    String str = strArr[1];
                    String str2 = strArr[6];
                    int limit3 = str.charAt(10);
                    int offset4 = str2.charAt(10);
                    if (limit3 != offset4) {
                        break;
                    }
                    String[] strArr2 = A0C;
                    strArr2[1] = "jCMcU5kX01siyiD9Xw2jZ38LNAQD3esf";
                    strArr2[6] = "NTL8nbB45bsjwa3rfW6th5wXRcuqzfwM";
                    int limit4 = this.A07.A01;
                    interfaceC1036Hd2.A6e(A00(c1134Ky2, limit4, (String) AbstractC07133y.A01(this.A04)));
                    this.A05 = true;
                }
            }
            this.A03.A03(A0l, A09, lengthToStartCode);
            if (this.A08 != null) {
                int i2 = 0;
                if (i > 0) {
                    L4 l4 = this.A08;
                    int limit5 = A0C[4].length();
                    if (limit5 != 4) {
                        break;
                    }
                    A0C[2] = "pGtfbhZ8gA4Y3zya71EFVTXhFPoVLYfI";
                    l4.A02(A0l, A09, lengthToStartCode);
                } else {
                    i2 = -i;
                }
                if (this.A08.A04(i2)) {
                    byte[] bArr = this.A08.A01;
                    int offset5 = this.A08.A00;
                    ((C07364v) C5C.A0f(this.A06)).A0j(this.A08.A01, HS.A02(bArr, offset5));
                    ((LJ) C5C.A0f(this.A09)).A02(this.A00, this.A06);
                }
                if (startCodeValue == 178) {
                    int offset6 = lengthToStartCode + 2;
                    if (c07364v.A0l()[offset6] == 1) {
                        this.A08.A01(startCodeValue);
                    }
                }
            }
            int i3 = A0A - lengthToStartCode;
            this.A03.A02(this.A01 - i3, i3, this.A05);
            this.A03.A01(startCodeValue, this.A00);
            A09 = lengthToStartCode + 3;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A04 = lg.A04();
        this.A02 = ha.AKS(lg.A03(), 2);
        this.A03 = new C1135Kz(this.A02);
        if (this.A09 != null) {
            this.A09.A03(ha, lg);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGp() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGq(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A00 = j;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AJ5() {
        HS.A0H(this.A0A);
        this.A07.A02();
        if (this.A03 != null) {
            this.A03.A00();
        }
        if (this.A08 != null) {
            this.A08.A00();
        }
        if (A0C[4].length() != 4) {
            throw new RuntimeException();
        }
        A0C[2] = "KHBnxT5PT6gCJIZCrRbgphkbFp7MF5Ts";
        this.A01 = 0L;
        this.A00 = -9223372036854775807L;
    }
}
