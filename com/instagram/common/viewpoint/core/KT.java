package com.instagram.common.viewpoint.core;

import android.text.Layout;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class KT {
    public static byte[] A0J;
    public static String[] A0K = {"Usxox1Jpg4zI1D26A46628IJoKVIfDOb", "DJj4Y7Lf5wmbgFbmipnyENDrbENW0zBu", "xAirbBVx6sN", "JUHzrsF6PskbrsOcxUQeRZ6EJgAR84BH", "g21uR390", "sct5cBRRGNi", "fSzYgZjiZ3zjw2rk03FKz0970uetzuqd", "YzsQQs1"};
    public float A00;
    public int A02;
    public int A04;
    public Layout.Alignment A0C;
    public Layout.Alignment A0D;
    public KI A0E;
    public String A0F;
    public String A0G;
    public boolean A0H;
    public boolean A0I;
    public int A07 = -1;
    public int A0B = -1;
    public int A03 = -1;
    public int A06 = -1;
    public int A05 = -1;
    public int A09 = -1;
    public int A08 = -1;
    public int A0A = -1;
    public float A01 = Float.MAX_VALUE;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 111);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0J = new byte[]{-24, 7, 9, 17, Ascii.CR, Ascii.CAN, Ascii.NAK, Ascii.ESC, Ascii.DC4, 10, -58, 9, Ascii.NAK, Ascii.DC2, Ascii.NAK, Ascii.CAN, -58, Ascii.SO, 7, Ascii.EM, -58, Ascii.DC4, Ascii.NAK, Ascii.SUB, -58, 8, Ascii.VT, Ascii.VT, Ascii.DC4, -58, 10, Ascii.VT, Ascii.FF, Ascii.SI, Ascii.DC4, Ascii.VT, 10, -44, -27, Ascii.SO, Ascii.CR, 19, -65, 2, Ascii.SO, Ascii.VT, Ascii.SO, 17, -65, 7, 0, Ascii.DC2, -65, Ascii.CR, Ascii.SO, 19, -65, 1, 4, 4, Ascii.CR, -65, 3, 4, 5, 8, Ascii.CR, 4, 3, -51};
    }

    static {
        A02();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a4, code lost:
    
        if (r6.A0D == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r5.A0D = r6.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ac, code lost:
    
        if (r5.A0C != null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
    
        if (r6.A0C == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        r5.A0C = r6.A0C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b8, code lost:
    
        if (r5.A0A != (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ba, code lost:
    
        r5.A0A = r6.A0A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c0, code lost:
    
        if (r5.A05 != (-1)) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
    
        r5.A05 = r6.A05;
        r5.A00 = r6.A00;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cc, code lost:
    
        if (r5.A0E != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ce, code lost:
    
        r5.A0E = r6.A0E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d9, code lost:
    
        if (r5.A01 != Float.MAX_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00db, code lost:
    
        r5.A01 = r6.A01;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00df, code lost:
    
        if (r7 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e3, code lost:
    
        if (r5.A0H != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e7, code lost:
    
        if (r6.A0H == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e9, code lost:
    
        A0G(r6.A02);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ee, code lost:
    
        if (r7 == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f2, code lost:
    
        if (r5.A09 != (-1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f6, code lost:
    
        if (r6.A09 == (-1)) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
    
        r5.A09 = r6.A09;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0104, code lost:
    
        if (r4 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private KT A00(KT kt, boolean z) {
        if (kt != null) {
            if (!this.A0I && kt.A0I) {
                A0H(kt.A04);
            }
            if (this.A03 == -1) {
                this.A03 = kt.A03;
            }
            if (this.A06 == -1) {
                this.A06 = kt.A06;
            }
            if (this.A0F == null) {
                String str = kt.A0F;
                String[] strArr = A0K;
                if (strArr[3].charAt(11) != strArr[1].charAt(11)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0K;
                strArr2[2] = "cxifAUO6W4n";
                strArr2[5] = "Va8L5s638mc";
                if (str != null) {
                    this.A0F = kt.A0F;
                }
            }
            if (this.A07 == -1) {
                this.A07 = kt.A07;
            }
            if (this.A0B == -1) {
                this.A0B = kt.A0B;
            }
            int i = this.A08;
            String[] strArr3 = A0K;
            if (strArr3[2].length() != strArr3[5].length()) {
                throw new RuntimeException();
            }
            A0K[6] = "rpCcf5jyKzMEHl3XckJI6ROuZzizfKVN";
            if (i == -1) {
                this.A08 = kt.A08;
            }
            Layout.Alignment alignment = this.A0D;
            if (A0K[6].charAt(6) != 'j') {
                A0K[0] = "iHkaK3PGLb6DAQNakyilLZ3b8fweVD8f";
            } else {
                A0K[0] = "IvRWfCdmbtpyZ5Utg7SC4PH3AC5nND0h";
            }
        }
        return this;
    }

    public final float A03() {
        return this.A00;
    }

    public final float A04() {
        return this.A01;
    }

    public final int A05() {
        if (this.A0H) {
            return this.A02;
        }
        throw new IllegalStateException(A01(0, 38, 55));
    }

    public final int A06() {
        if (this.A0I) {
            return this.A04;
        }
        throw new IllegalStateException(A01(38, 32, 48));
    }

    public final int A07() {
        return this.A05;
    }

    public final int A08() {
        return this.A08;
    }

    public final int A09() {
        return this.A09;
    }

    public final int A0A() {
        if (this.A03 == -1 && this.A06 == -1) {
            return -1;
        }
        int i = (this.A03 == 1 ? 1 : 0) | (this.A06 == 1 ? 2 : 0);
        String[] strArr = A0K;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0K;
        strArr2[2] = "pc7acbLDMjB";
        strArr2[5] = "xuQHQFUerHu";
        return i;
    }

    public final Layout.Alignment A0B() {
        return this.A0C;
    }

    public final Layout.Alignment A0C() {
        return this.A0D;
    }

    public final KI A0D() {
        return this.A0E;
    }

    public final KT A0E(float f) {
        this.A00 = f;
        return this;
    }

    public final KT A0F(float f) {
        this.A01 = f;
        return this;
    }

    public final KT A0G(int i) {
        this.A02 = i;
        this.A0H = true;
        return this;
    }

    public final KT A0H(int i) {
        this.A04 = i;
        this.A0I = true;
        return this;
    }

    public final KT A0I(int i) {
        this.A05 = i;
        return this;
    }

    public final KT A0J(int i) {
        this.A08 = i;
        return this;
    }

    public final KT A0K(int i) {
        this.A09 = i;
        return this;
    }

    public final KT A0L(Layout.Alignment alignment) {
        this.A0C = alignment;
        return this;
    }

    public final KT A0M(Layout.Alignment alignment) {
        this.A0D = alignment;
        return this;
    }

    public final KT A0N(KI ki) {
        this.A0E = ki;
        return this;
    }

    public final KT A0O(KT kt) {
        return A00(kt, true);
    }

    public final KT A0P(String str) {
        this.A0F = str;
        return this;
    }

    public final KT A0Q(String str) {
        this.A0G = str;
        return this;
    }

    public final KT A0R(boolean z) {
        this.A03 = z ? 1 : 0;
        return this;
    }

    public final KT A0S(boolean z) {
        this.A06 = z ? 1 : 0;
        return this;
    }

    public final KT A0T(boolean z) {
        this.A07 = z ? 1 : 0;
        return this;
    }

    public final KT A0U(boolean z) {
        this.A0A = z ? 1 : 0;
        return this;
    }

    public final KT A0V(boolean z) {
        this.A0B = z ? 1 : 0;
        return this;
    }

    public final String A0W() {
        return this.A0F;
    }

    public final String A0X() {
        return this.A0G;
    }

    public final boolean A0Y() {
        return this.A0A == 1;
    }

    public final boolean A0Z() {
        return this.A0H;
    }

    public final boolean A0a() {
        return this.A0I;
    }

    public final boolean A0b() {
        return this.A07 == 1;
    }

    public final boolean A0c() {
        return this.A0B == 1;
    }
}
