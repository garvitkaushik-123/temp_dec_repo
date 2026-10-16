package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.lW, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2208lW implements InterfaceC1131Kv {
    public static byte[] A0C;
    public static String[] A0D = {"zgZfEJGGgdHtew2g1FfNkkcnB", "zHXWmVVfspRqZTFEHweYGYwJXvEszQMx", "7abqffqd10TBp3FWdGN7VvMrN7O1UkYM", "p0MVW5l5", "JyEkXe6y14TztCHpc8kpfDGRXJv0nuKA", "euIGF7oBB7KZa", "ak0CBs2Ex4lMz9dSuXO", "PviIixxcvW6ZcpMh0sztGl9"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public C2489qI A05;
    public InterfaceC1036Hd A06;
    public String A07;
    public boolean A08;
    public final C07354u A09;
    public final C07364v A0A;
    public final String A0B;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{40, 60, 45, 32, 38, 102, 40, 42, 122};
    }

    static {
        A02();
    }

    public C2208lW() {
        this(null);
    }

    public C2208lW(String str) {
        this.A09 = new C07354u(new byte[128]);
        this.A0A = new C07364v(this.A09.A00);
        this.A02 = 0;
        this.A04 = -9223372036854775807L;
        this.A0B = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
    
        if (com.instagram.common.viewpoint.core.C5C.A1E(r3.A06, r6.A05.A0W) != false) goto L18;
     */
    @RequiresNonNull({"output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A01() {
        this.A09.A08(0);
        C1023Gq A09 = AbstractC1024Gr.A09(this.A09);
        if (this.A05 != null) {
            int i = A09.A01;
            int i2 = this.A05.A06;
            String[] strArr = A0D;
            if (strArr[2].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[0] = "s5ZnNr7Ga7MlLfd70p6uFHM8x";
            strArr2[5] = "utwzV9oXgtTkd";
            if (i == i2) {
                int i3 = A09.A04;
                String[] strArr3 = A0D;
                if (strArr3[4].charAt(13) == strArr3[1].charAt(13)) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0D;
                strArr4[2] = "MPTvnFyqCCYkwFwXTKwYW3O2KaIbPHbI";
                strArr4[6] = "dVnQ4greYxNN5pQgdCf";
                if (i3 == this.A05.A0G) {
                }
            }
        }
        C06802p A0j = new C06802p().A0y(this.A07).A11(A09.A06).A0b(A09.A01).A0m(A09.A04).A10(this.A0B).A0j(A09.A00);
        if (A00(0, 9, 31).equals(A09.A06)) {
            A0j.A0a(A09.A00);
        }
        this.A05 = A0j.A14();
        this.A06.A6e(this.A05);
        this.A01 = A09.A02;
        this.A03 = (A09.A03 * 1000000) / this.A05.A0G;
    }

    private boolean A03(C07364v c07364v) {
        while (true) {
            if (c07364v.A07() <= 0) {
                return false;
            }
            boolean z = this.A08;
            if (A0D[3].length() != 8) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[4] = "9XFIg7618hJvvA4xETZzayJ4sl88kXfd";
            strArr[1] = "F6kFQyxnROPq81yNs7RnOkiGPjgAvEmB";
            if (!z) {
                this.A08 = c07364v.A0I() == 11;
            } else {
                int A0I = c07364v.A0I();
                if (A0I == 119) {
                    this.A08 = false;
                    return true;
                }
                this.A08 = A0I == 11;
            }
        }
    }

    private boolean A04(C07364v c07364v, byte[] bArr, int i) {
        int min = Math.min(c07364v.A07(), i - this.A00);
        int bytesToRead = this.A00;
        c07364v.A0k(bArr, bytesToRead, min);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + min;
        int bytesToRead3 = this.A00;
        return bytesToRead3 == i;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5A(C07364v c07364v) {
        AbstractC07133y.A02(this.A06);
        while (c07364v.A07() > 0) {
            int i = this.A02;
            String[] strArr = A0D;
            if (strArr[0].length() != strArr[5].length()) {
                String[] strArr2 = A0D;
                strArr2[0] = "xuhMWsLm7IhyfpFjlZpQdmw9F";
                strArr2[5] = "BOgMYXTSIypYk";
                switch (i) {
                    case 0:
                        if (!A03(c07364v)) {
                            break;
                        } else {
                            this.A02 = 1;
                            this.A0A.A0l()[0] = Ascii.VT;
                            this.A0A.A0l()[1] = 119;
                            this.A00 = 2;
                            break;
                        }
                    case 1:
                        if (!A04(c07364v, this.A0A.A0l(), 128)) {
                            break;
                        } else {
                            A01();
                            this.A0A.A0f(0);
                            this.A06.AIr(this.A0A, 128);
                            this.A02 = 2;
                            break;
                        }
                    case 2:
                        int min = Math.min(c07364v.A07(), this.A01 - this.A00);
                        this.A06.AIr(c07364v, min);
                        this.A00 += min;
                        if (this.A00 == this.A01) {
                            if (this.A04 != -9223372036854775807L) {
                                this.A06.AIu(this.A04, 1, this.A01, 0, null);
                                this.A04 += this.A03;
                            }
                            this.A02 = 0;
                            break;
                        } else {
                            break;
                        }
                }
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A07 = lg.A04();
        this.A06 = ha.AKS(lg.A03(), 1);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGp() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGq(long j, int i) {
        if (j != -9223372036854775807L) {
            this.A04 = j;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AJ5() {
        this.A02 = 0;
        this.A00 = 0;
        this.A08 = false;
        this.A04 = -9223372036854775807L;
    }
}
