package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.hr, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1999hr extends R2 implements RE {
    public static byte[] A0F;
    public static String[] A0G = {"ZTDwmEtle1avZIcEXO6Ngzge8j05pfT9", "s1YfUPq4amp3sGXTr0KOnMWCCCkrB2x5", "RLSriKm", "hA4l3MFFurEjuKvfb479JjwTp2cnC09n", "5GFF521rSn4TdhEStccPhauxYrt7NMVp", "XQN2s9DMc1xKucEpv2CitIAcNHBR8E7y", "8ubGCSX", "EFysGv6XChRnXfWxG2n7d2ksHTdYT6om"};
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public AbstractC1273Qm A04;
    public boolean A05;
    public int A06;
    public C1269Qh A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C1267Qf A0D;
    public final C1268Qg A0E;

    public static String A0T(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 91);
        }
        return new String(copyOfRange);
    }

    public static void A0V() {
        A0F = new byte[]{Ascii.US, Ascii.CAN, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, 86, Ascii.EM, 4, Ascii.US, 19, Ascii.CAN, 2, Ascii.ETB, 2, Ascii.US, Ascii.EM, Ascii.CAN, 76};
    }

    static {
        A0V();
    }

    public C1999hr(Context context) {
        this(context, 1, false);
    }

    public C1999hr(Context context, int i, boolean z) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C1267Qf(this);
        this.A0E = new C1268Qg();
        this.A06 = 2;
        A2C(i);
        A0h(z);
        A1T(true);
    }

    private final int A04(int i, RA ra, RH rh) {
        if (A0Y() == 0 || i == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A2B();
        int absDy = i > 0 ? 1 : -1;
        int consumed = Math.abs(i);
        A0Y(absDy, consumed, true, rh);
        int i2 = this.A07.A07;
        int layoutDirection = A07(ra, this.A07, rh, false);
        int i3 = i2 + layoutDirection;
        if (i3 < 0) {
            return 0;
        }
        int absDy2 = consumed > i3 ? absDy * i3 : i;
        int layoutDirection2 = -absDy2;
        this.A04.A0J(layoutDirection2);
        this.A07.A04 = absDy2;
        return absDy2;
    }

    private int A05(int i, RA ra, RH rh, boolean z) {
        int fixOffset;
        int gap = this.A04.A07() - i;
        if (gap > 0) {
            int i2 = -A04(-gap, ra, rh);
            int i3 = i + i2;
            if (z && (fixOffset = this.A04.A07() - i3) > 0) {
                this.A04.A0J(fixOffset);
                return fixOffset + i2;
            }
            return i2;
        }
        return 0;
    }

    private int A06(int i, RA ra, RH rh, boolean z) {
        int A0A;
        int gap = i - this.A04.A0A();
        if (gap > 0) {
            int i2 = -A04(gap, ra, rh);
            int i3 = i + i2;
            if (z && (A0A = i3 - this.A04.A0A()) > 0) {
                this.A04.A0J(-A0A);
                return i2 - A0A;
            }
            return i2;
        }
        return 0;
    }

    private final int A07(RA ra, C1269Qh c1269Qh, RH rh, boolean z) {
        int i = c1269Qh.A00;
        int start = c1269Qh.A07;
        if (start != Integer.MIN_VALUE) {
            int start2 = c1269Qh.A00;
            if (start2 < 0) {
                int i2 = c1269Qh.A07;
                int start3 = c1269Qh.A00;
                c1269Qh.A07 = i2 + start3;
            }
            A0e(ra, c1269Qh);
        }
        int i3 = c1269Qh.A00;
        int start4 = c1269Qh.A02;
        int i4 = i3 + start4;
        C1268Qg c1268Qg = this.A0E;
        while (true) {
            if ((!c1269Qh.A09 && i4 <= 0) || !c1269Qh.A05(rh)) {
                break;
            }
            c1268Qg.A00();
            A2F(ra, rh, c1269Qh, c1268Qg);
            if (!c1268Qg.A01) {
                int i5 = c1269Qh.A06;
                int remainingSpace = c1268Qg.A00;
                int start5 = c1269Qh.A05;
                c1269Qh.A06 = i5 + (remainingSpace * start5);
                if (!c1268Qg.A03 || this.A07.A08 != null || !rh.A07()) {
                    int remainingSpace2 = c1269Qh.A00;
                    int start6 = c1268Qg.A00;
                    c1269Qh.A00 = remainingSpace2 - start6;
                    int start7 = c1268Qg.A00;
                    i4 -= start7;
                }
                int start8 = c1269Qh.A07;
                if (start8 != Integer.MIN_VALUE) {
                    int remainingSpace3 = c1269Qh.A07;
                    int start9 = c1268Qg.A00;
                    c1269Qh.A07 = remainingSpace3 + start9;
                    int start10 = c1269Qh.A00;
                    if (start10 < 0) {
                        int remainingSpace4 = c1269Qh.A07;
                        int start11 = c1269Qh.A00;
                        c1269Qh.A07 = remainingSpace4 + start11;
                    }
                    A0e(ra, c1269Qh);
                }
                if (z && c1268Qg.A02) {
                    break;
                }
            } else {
                break;
            }
        }
        int start12 = c1269Qh.A00;
        return i - start12;
    }

    private int A08(RH rh) {
        if (A0Y() == 0) {
            return 0;
        }
        A2B();
        return RL.A00(rh, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
    }

    private int A0A(RH rh) {
        if (A0Y() != 0) {
            A2B();
            return RL.A02(rh, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B, this.A05);
        }
        if (A0G[3].charAt(25) != '2') {
            throw new RuntimeException();
        }
        A0G[1] = "J9JFedtgHh7lzsKv2wGVe5URJzbGPRgH";
        return 0;
    }

    private int A0B(RH rh) {
        if (A0Y() == 0) {
            return 0;
        }
        A2B();
        return RL.A01(rh, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
    }

    private final int A0C(RH rh) {
        if (rh.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0D() {
        return A0H(0, A0Y());
    }

    private View A0E() {
        return A0H(A0Y() - 1, -1);
    }

    private View A0F() {
        return A0v(this.A05 ? 0 : A0Y() - 1);
    }

    private View A0G() {
        return A0v(this.A05 ? A0Y() - 1 : 0);
    }

    private final View A0H(int i, int i2) {
        int next;
        int acceptableBoundsFlag;
        int preferredBoundsFlag;
        A2B();
        if (i2 > i) {
            next = 1;
        } else {
            next = i2 < i ? -1 : 0;
        }
        if (next == 0) {
            return A0v(i);
        }
        int preferredBoundsFlag2 = this.A04.A0F(A0v(i));
        int next2 = this.A04.A0A();
        if (preferredBoundsFlag2 < next2) {
            acceptableBoundsFlag = 16644;
            preferredBoundsFlag = 16388;
        } else {
            acceptableBoundsFlag = 4161;
            preferredBoundsFlag = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        int next3 = this.A00;
        if (next3 == 0) {
            return super.A04.A00(i, i2, acceptableBoundsFlag, preferredBoundsFlag);
        }
        return super.A05.A00(i, i2, acceptableBoundsFlag, preferredBoundsFlag);
    }

    private final View A0I(int i, int i2, boolean z, boolean z2) {
        int i3;
        A2B();
        int i4 = 0;
        if (z) {
            i3 = 24579;
        } else {
            i3 = Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
        }
        if (z2) {
            i4 = Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE;
        }
        int i5 = this.A00;
        int acceptableBoundsFlag = A0G[5].charAt(29);
        if (acceptableBoundsFlag != 69) {
            throw new RuntimeException();
        }
        A0G[5] = "CO2lCdhiUyNnJNyVLVKK7uQ85cne8EHP";
        if (i5 == 0) {
            return super.A04.A00(i, i2, i3, i4);
        }
        return super.A05.A00(i, i2, i3, i4);
    }

    private View A0J(RA ra, RH rh) {
        return A2A(ra, rh, 0, A0Y(), rh.A03());
    }

    private View A0L(RA ra, RH rh) {
        return A2A(ra, rh, A0Y() - 1, -1, rh.A03());
    }

    private View A0M(RA ra, RH rh) {
        return this.A05 ? A0D() : A0E();
    }

    private View A0N(RA ra, RH rh) {
        return this.A05 ? A0E() : A0D();
    }

    private View A0O(RA ra, RH rh) {
        return this.A05 ? A0J(ra, rh) : A0L(ra, rh);
    }

    private View A0P(RA ra, RH rh) {
        return this.A05 ? A0L(ra, rh) : A0J(ra, rh);
    }

    private View A0Q(boolean z, boolean z2) {
        if (this.A05) {
            return A0I(0, A0Y(), z, z2);
        }
        return A0I(A0Y() - 1, -1, z, z2);
    }

    private View A0R(boolean z, boolean z2) {
        if (this.A05) {
            return A0I(A0Y() - 1, -1, z, z2);
        }
        return A0I(0, A0Y(), z, z2);
    }

    private final C1269Qh A0S() {
        return new C1269Qh();
    }

    private void A0U() {
        if (this.A00 == 1 || !A2H()) {
            this.A05 = this.A0A;
        } else {
            this.A05 = !this.A0A;
        }
    }

    private void A0W(int i, int i2) {
        this.A07.A00 = this.A04.A07() - i2;
        this.A07.A03 = this.A05 ? -1 : 1;
        this.A07.A01 = i;
        this.A07.A05 = 1;
        this.A07.A06 = i2;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0X(int i, int i2) {
        this.A07.A00 = i2 - this.A04.A0A();
        this.A07.A01 = i;
        this.A07.A03 = this.A05 ? 1 : -1;
        this.A07.A05 = -1;
        this.A07.A06 = i2;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0Y(int i, int i2, boolean z, RH rh) {
        int A0A;
        this.A07.A09 = A0i();
        this.A07.A02 = A0C(rh);
        this.A07.A05 = i;
        if (i == 1) {
            this.A07.A02 += this.A04.A08();
            View A0F2 = A0F();
            C1269Qh c1269Qh = this.A07;
            if (!this.A05) {
                r4 = 1;
            }
            c1269Qh.A03 = r4;
            this.A07.A01 = A0r(A0F2) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(A0F2);
            A0A = this.A04.A0C(A0F2) - this.A04.A07();
        } else {
            View A0G2 = A0G();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0r(A0G2) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(A0G2);
            A0A = (-this.A04.A0F(A0G2)) + this.A04.A0A();
        }
        this.A07.A00 = i2;
        if (z) {
            C1269Qh c1269Qh2 = this.A07;
            int scrollingOffset = c1269Qh2.A00;
            c1269Qh2.A00 = scrollingOffset - A0A;
        }
        this.A07.A07 = A0A;
    }

    private void A0Z(C1267Qf c1267Qf) {
        A0W(c1267Qf.A01, c1267Qf.A00);
    }

    private void A0a(C1267Qf c1267Qf) {
        A0X(c1267Qf.A01, c1267Qf.A00);
    }

    private void A0b(RA ra, int i) {
        int A0Y = A0Y();
        if (i < 0) {
            return;
        }
        int A06 = this.A04.A06() - i;
        boolean z = this.A05;
        int limit = A0G[3].charAt(25);
        if (limit != 50) {
            throw new RuntimeException();
        }
        A0G[1] = "5eQap7viEGWOuRbzagNYDGjkAWEMIhVp";
        if (z) {
            for (int i2 = 0; i2 < A0Y; i2++) {
                View A0v = A0v(i2);
                int childCount = this.A04.A0F(A0v);
                if (childCount >= A06) {
                    int childCount2 = this.A04.A0H(A0v);
                    if (childCount2 >= A06) {
                    }
                }
                int limit2 = A0G[4].length();
                if (limit2 != 13) {
                    String[] strArr = A0G;
                    strArr[6] = "EiwXPaP";
                    strArr[2] = "4OvxlWI";
                    A0d(ra, 0, i2);
                    return;
                }
                A0d(ra, 0, i2);
                return;
            }
            return;
        }
        for (int i3 = A0Y - 1; i3 >= 0; i3--) {
            View A0v2 = A0v(i3);
            int childCount3 = this.A04.A0F(A0v2);
            if (childCount3 >= A06) {
                int childCount4 = this.A04.A0H(A0v2);
                if (childCount4 >= A06) {
                }
            }
            int childCount5 = A0Y - 1;
            A0d(ra, childCount5, i3);
            return;
        }
    }

    private void A0c(RA ra, int i) {
        if (i < 0) {
            return;
        }
        int A0Y = A0Y();
        if (this.A05) {
            for (int i2 = A0Y - 1; i2 >= 0; i2--) {
                View A0v = A0v(i2);
                AbstractC1273Qm abstractC1273Qm = this.A04;
                int childCount = A0G[5].charAt(29);
                if (childCount != 69) {
                    throw new RuntimeException();
                }
                A0G[3] = "CCkneFsBnjHsOQTiipl2DNgji2H70UcR";
                int limit = abstractC1273Qm.A0C(A0v);
                if (limit <= i) {
                    int limit2 = this.A04.A0G(A0v);
                    if (limit2 <= i) {
                    }
                }
                int limit3 = A0Y - 1;
                A0d(ra, limit3, i2);
                return;
            }
            return;
        }
        for (int i3 = 0; i3 < A0Y; i3++) {
            View A0v2 = A0v(i3);
            int limit4 = this.A04.A0C(A0v2);
            if (limit4 <= i) {
                int limit5 = this.A04.A0G(A0v2);
                if (limit5 <= i) {
                }
            }
            A0d(ra, 0, i3);
            return;
        }
    }

    private void A0d(RA ra, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 > i) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                A16(i3, ra);
            }
            return;
        }
        while (i > i2) {
            A16(i, ra);
            i--;
        }
    }

    private void A0e(RA ra, C1269Qh c1269Qh) {
        if (!c1269Qh.A0B || c1269Qh.A09) {
            return;
        }
        if (c1269Qh.A05 == -1) {
            A0b(ra, c1269Qh.A07);
        } else {
            A0c(ra, c1269Qh.A07);
        }
    }

    private void A0f(RA ra, RH rh, int scrapExtraEnd, int scrapExtraEnd2) {
        if (!rh.A08() || A0Y() == 0 || rh.A07() || !A24()) {
            return;
        }
        int i = 0;
        int scrapExtraStart = 0;
        List<RK> A0J = ra.A0J();
        int i2 = A0J.size();
        int A0r = A0r(A0v(0));
        for (int scrapSize = 0; scrapSize < i2; scrapSize++) {
            RK rk = A0J.get(scrapSize);
            if (!rk.A0g()) {
                int direction = 1;
                if ((rk.A0O() < A0r) != this.A05) {
                    direction = -1;
                }
                if (direction == -1) {
                    i += this.A04.A0D(rk.A0H);
                } else {
                    scrapExtraStart += this.A04.A0D(rk.A0H);
                }
            }
        }
        this.A07.A08 = A0J;
        if (i > 0) {
            A0X(A0r(A0G()), scrapExtraEnd);
            this.A07.A02 = i;
            this.A07.A00 = 0;
            this.A07.A04();
            A07(ra, this.A07, rh, false);
        }
        if (scrapExtraStart > 0) {
            A0W(A0r(A0F()), scrapExtraEnd2);
            this.A07.A02 = scrapExtraStart;
            this.A07.A00 = 0;
            this.A07.A04();
            A07(ra, this.A07, rh, false);
        }
        this.A07.A08 = null;
    }

    private void A0g(RA ra, RH rh, C1267Qf c1267Qf) {
        if (A0k(rh, c1267Qf) || A0j(ra, rh, c1267Qf)) {
            return;
        }
        c1267Qf.A02();
        c1267Qf.A01 = this.A0C ? rh.A03() - 1 : 0;
    }

    private final void A0h(boolean z) {
        A20(null);
        if (z == this.A0A) {
            return;
        }
        this.A0A = z;
        A10();
    }

    private final boolean A0i() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0j(RA ra, RH rh, C1267Qf c1267Qf) {
        View A0P;
        int A0A;
        if (A0Y() == 0) {
            return false;
        }
        View A0u = A0u();
        if (A0u != null && c1267Qf.A06(A0u, rh)) {
            c1267Qf.A05(A0u);
            return true;
        }
        if (this.A08 != this.A0C) {
            return false;
        }
        if (c1267Qf.A02) {
            A0P = A0O(ra, rh);
        } else {
            A0P = A0P(ra, rh);
        }
        if (A0P == null) {
            return false;
        }
        c1267Qf.A04(A0P);
        if (!rh.A07() && A24()) {
            if (this.A04.A0F(A0P) >= this.A04.A07() || this.A04.A0C(A0P) < this.A04.A0A()) {
                if (c1267Qf.A02) {
                    A0A = this.A04.A07();
                } else {
                    A0A = this.A04.A0A();
                }
                c1267Qf.A00 = A0A;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b2, code lost:
    
        if ((r7 - r6) < 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        r10.A00 = r8.A04.A0A();
        r10.A02 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        r1 = r8.A04.A07() - r8.A04.A0C(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
    
        if (r1 >= 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d9, code lost:
    
        r10.A00 = r8.A04.A07();
        r10.A02 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e3, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e6, code lost:
    
        if (r10.A02 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e8, code lost:
    
        r1 = r8.A04.A0C(r5);
        r1 = r1 + r8.A04.A05();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f5, code lost:
    
        r10.A00 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f8, code lost:
    
        r1 = r8.A04.A0F(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c7, code lost:
    
        if ((r7 - r6) < 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A0k(RH rh, C1267Qf c1267Qf) {
        if (rh.A07() || this.A01 == -1) {
            return false;
        }
        int i = this.A01;
        if (A0G[7].charAt(1) != 'F') {
            throw new RuntimeException();
        }
        A0G[7] = "TFIDoufW7PPC7ZEj7Y5tPHllsDSURNN1";
        if (i < 0 || this.A01 >= rh.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        c1267Qf.A01 = this.A01;
        if (this.A03 != null && this.A03.A01()) {
            c1267Qf.A02 = this.A03.A02;
            if (c1267Qf.A02) {
                c1267Qf.A00 = this.A04.A07() - this.A03.A00;
            } else {
                c1267Qf.A00 = this.A04.A0A() + this.A03.A00;
            }
            return true;
        }
        if (this.A02 == Integer.MIN_VALUE) {
            View A1o = A1o(this.A01);
            if (A1o != null) {
                if (this.A04.A0D(A1o) > this.A04.A0B()) {
                    c1267Qf.A02();
                    return true;
                }
                int A0F2 = this.A04.A0F(A1o);
                int A0A = this.A04.A0A();
                if (A0G[7].charAt(1) != 'F') {
                    A0G[1] = "BfWLqmz6tLXTBl9sOf8GvQUpsUyqil7O";
                } else {
                    A0G[3] = "F1yYn32nqotC7GL2fjmWFlYeH2UBHhCV";
                }
            } else {
                if (A0Y() > 0) {
                    View child = A0v(0);
                    c1267Qf.A02 = (this.A01 < A0r(child)) == this.A05;
                }
                c1267Qf.A02();
            }
            return true;
        }
        boolean z = this.A05;
        if (A0G[5].charAt(29) != 'E') {
            throw new RuntimeException();
        }
        A0G[7] = "6FIelR57229tmCeHfVqBadRckpOvBeMr";
        c1267Qf.A02 = z;
        if (this.A05) {
            c1267Qf.A00 = this.A04.A07() - this.A02;
        } else {
            c1267Qf.A00 = this.A04.A0A() + this.A02;
        }
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public int A1f(int i, RA ra, RH rh) {
        if (this.A00 == 1) {
            return 0;
        }
        return A04(i, ra, rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public int A1g(int i, RA ra, RH rh) {
        if (this.A00 == 0) {
            return 0;
        }
        return A04(i, ra, rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final int A1h(RH rh) {
        return A08(rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final int A1i(RH rh) {
        return A0A(rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final int A1j(RH rh) {
        return A0B(rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final int A1k(RH rh) {
        return A08(rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final int A1l(RH rh) {
        return A0A(rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final int A1m(RH rh) {
        return A0B(rh);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final Parcelable A1n() {
        if (this.A03 != null) {
            return new WrappedParcelable(new LinearLayoutManager$SavedState(this.A03));
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (A0Y() > 0) {
            A2B();
            boolean didLayoutFromEnd = this.A08 ^ this.A05;
            linearLayoutManager$SavedState.A02 = didLayoutFromEnd;
            if (didLayoutFromEnd) {
                View refChild = A0F();
                linearLayoutManager$SavedState.A00 = this.A04.A07() - this.A04.A0C(refChild);
                linearLayoutManager$SavedState.A01 = A0r(refChild);
            } else {
                View A0G2 = A0G();
                linearLayoutManager$SavedState.A01 = A0r(A0G2);
                linearLayoutManager$SavedState.A00 = this.A04.A0F(A0G2) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState.A00();
        }
        return new WrappedParcelable(linearLayoutManager$SavedState);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final View A1o(int i) {
        int firstChild = A0Y();
        if (firstChild == 0) {
            return null;
        }
        int childCount = i - A0r(A0v(0));
        if (childCount >= 0 && childCount < firstChild) {
            View A0v = A0v(childCount);
            if (A0r(A0v) == i) {
                return A0v;
            }
        }
        return super.A1o(i);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public View A1p(View view, int i, RA ra, RH rh) {
        int maxScroll;
        View nextFocus;
        View A0F2;
        A0U();
        if (A0Y() == 0 || (maxScroll = A29(i)) == Integer.MIN_VALUE) {
            return null;
        }
        A2B();
        A2B();
        int layoutDir = this.A04.A0B();
        A0Y(maxScroll, (int) (layoutDir * 0.33333334f), false, rh);
        this.A07.A07 = Integer.MIN_VALUE;
        this.A07.A0B = false;
        A07(ra, this.A07, rh, true);
        if (maxScroll == -1) {
            nextFocus = A0N(ra, rh);
        } else {
            nextFocus = A0M(ra, rh);
        }
        if (maxScroll == -1) {
            A0F2 = A0G();
        } else {
            A0F2 = A0F();
        }
        if (A0F2.hasFocusable()) {
            if (nextFocus == null) {
                return null;
            }
            return A0F2;
        }
        return nextFocus;
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public R3 A1q() {
        return new R3(-2, -2);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public void A1r(int i) {
        this.A01 = i;
        this.A02 = Integer.MIN_VALUE;
        if (this.A03 != null) {
            this.A03.A00();
        }
        A10();
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final void A1s(int i, int i2, RH rh, R0 r0) {
        if (this.A00 != 0) {
            i = i2;
        }
        int delta = A0Y();
        if (delta == 0 || i == 0) {
            return;
        }
        A2B();
        int i3 = i > 0 ? 1 : -1;
        int delta2 = Math.abs(i);
        A0Y(i3, delta2, true, rh);
        A2G(rh, this.A07, r0);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final void A1t(int i, R0 r0) {
        boolean z;
        int direction;
        if (this.A03 != null && this.A03.A01()) {
            z = this.A03.A02;
            direction = this.A03.A01;
        } else {
            A0U();
            z = this.A05;
            if (this.A01 == -1) {
                direction = z ? i - 1 : 0;
            } else {
                direction = this.A01;
            }
        }
        int anchorPos = z ? -1 : 1;
        for (int i2 = 0; i2 < this.A06 && direction >= 0 && direction < i; i2++) {
            r0.A42(direction, 0);
            direction += anchorPos;
        }
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final void A1u(Parcelable parcelable) {
        ClassLoader classLoader;
        if (!(parcelable instanceof WrappedParcelable) || (classLoader = getClass().getClassLoader()) == null) {
            return;
        }
        Parcelable state = ((WrappedParcelable) parcelable).unwrap(classLoader);
        if (state instanceof LinearLayoutManager$SavedState) {
            this.A03 = (LinearLayoutManager$SavedState) state;
            A10();
        }
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final void A1v(AccessibilityEvent accessibilityEvent) {
        super.A1v(accessibilityEvent);
        if (A0Y() > 0) {
            accessibilityEvent.setFromIndex(A26());
            if (A0G[1].charAt(13) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[6] = "JM0e54P";
            strArr[2] = "62qYDCA";
            accessibilityEvent.setToIndex(A27());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0240, code lost:
    
        if (r8 < r7) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x024e, code lost:
    
        if (r9.A04.A0C(r5) > r9.A04.A0A()) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0250, code lost:
    
        r9.A0D.A05(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0257, code lost:
    
        if (r8 < r7) goto L86;
     */
    @Override // com.instagram.common.viewpoint.core.R2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A1w(RA ra, RH rh) {
        int startOffset;
        int fixOffset;
        int extraForStart;
        View A1o;
        int fixOffset2;
        int extraForStart2 = -1;
        if ((this.A03 != null || this.A01 != -1) && rh.A03() == 0) {
            A1K(ra);
            return;
        }
        if (this.A03 != null && this.A03.A01()) {
            this.A01 = this.A03.A01;
        }
        A2B();
        C1269Qh c1269Qh = this.A07;
        if (A0G[4].length() == 13) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[6] = "TEU8GGg";
        strArr[2] = "lg12FnG";
        c1269Qh.A0B = false;
        A0U();
        View A0u = A0u();
        if (!this.A0D.A03 || this.A01 != -1 || this.A03 != null) {
            this.A0D.A03();
            this.A0D.A02 = this.A05 ^ this.A0C;
            A0g(ra, rh, this.A0D);
            this.A0D.A03 = true;
        } else if (A0u != null) {
            int startOffset2 = this.A04.A0F(A0u);
            int lastElement = this.A04.A07();
            if (A0G[0].charAt(9) != '8') {
                A0G[1] = "cu8BBcv0k6hBgzqZsr0VN3sfifuVMQ62";
            }
        }
        int lastElement2 = A0C(rh);
        if (this.A07.A04 >= 0) {
            startOffset = 0;
        } else {
            startOffset = lastElement2;
            lastElement2 = 0;
        }
        int current = startOffset + this.A04.A0A();
        int startOffset3 = lastElement2 + this.A04.A08();
        if (rh.A07() && this.A01 != -1 && this.A02 != Integer.MIN_VALUE && (A1o = A1o(this.A01)) != null) {
            if (this.A05) {
                fixOffset2 = (this.A04.A07() - this.A04.A0C(A1o)) - this.A02;
            } else {
                fixOffset2 = this.A02 - (this.A04.A0F(A1o) - this.A04.A0A());
            }
            if (fixOffset2 > 0) {
                current += fixOffset2;
            } else {
                startOffset3 -= fixOffset2;
            }
        }
        if (this.A0D.A02) {
            if (this.A05) {
                extraForStart2 = 1;
            }
        } else if (!this.A05) {
            extraForStart2 = 1;
        }
        A2E(ra, rh, this.A0D, extraForStart2);
        A1J(ra);
        this.A07.A09 = A0i();
        this.A07.A0A = rh.A07();
        if (this.A0D.A02) {
            A0a(this.A0D);
            this.A07.A02 = current;
            A07(ra, this.A07, rh, false);
            extraForStart = this.A07.A06;
            int extraForEnd = this.A07.A01;
            if (this.A07.A00 > 0) {
                C1269Qh c1269Qh2 = this.A07;
                if (A0G[7].charAt(1) != 'F') {
                    String[] strArr2 = A0G;
                    strArr2[6] = "MJWLhmn";
                    strArr2[2] = "Xdeja1C";
                    startOffset3 += c1269Qh2.A00;
                } else {
                    A0G[3] = "HkWuM96xU0ciNRE25G4cwktgC29lbS6I";
                    startOffset3 += c1269Qh2.A00;
                }
            }
            A0Z(this.A0D);
            this.A07.A02 = startOffset3;
            this.A07.A01 += this.A07.A03;
            A07(ra, this.A07, rh, false);
            fixOffset = this.A07.A06;
            if (this.A07.A00 > 0) {
                int i = this.A07.A00;
                A0X(extraForEnd, extraForStart);
                this.A07.A02 = i;
                A07(ra, this.A07, rh, false);
                extraForStart = this.A07.A06;
            }
        } else {
            A0Z(this.A0D);
            this.A07.A02 = startOffset3;
            A07(ra, this.A07, rh, false);
            fixOffset = this.A07.A06;
            int extraForEnd2 = this.A07.A01;
            if (this.A07.A00 > 0) {
                current += this.A07.A00;
            }
            A0a(this.A0D);
            this.A07.A02 = current;
            this.A07.A01 += this.A07.A03;
            A07(ra, this.A07, rh, false);
            extraForStart = this.A07.A06;
            if (this.A07.A00 > 0) {
                int i2 = this.A07.A00;
                A0W(extraForEnd2, fixOffset);
                this.A07.A02 = i2;
                A07(ra, this.A07, rh, false);
                fixOffset = this.A07.A06;
            }
        }
        if (A0Y() > 0) {
            if (this.A05 ^ this.A0C) {
                int A05 = A05(fixOffset, ra, rh, true);
                int extraForStart3 = extraForStart + A05;
                int fixOffset3 = fixOffset + A05;
                int A06 = A06(extraForStart3, ra, rh, false);
                extraForStart = extraForStart3 + A06;
                fixOffset = fixOffset3 + A06;
            } else {
                int A062 = A06(extraForStart, ra, rh, true);
                int extraForStart4 = extraForStart + A062;
                int fixOffset4 = fixOffset + A062;
                int A052 = A05(fixOffset4, ra, rh, false);
                extraForStart = extraForStart4 + A052;
                fixOffset = fixOffset4 + A052;
            }
        }
        A0f(ra, rh, extraForStart, fixOffset);
        if (!rh.A07()) {
            this.A04.A0I();
        } else {
            this.A0D.A03();
        }
        this.A08 = this.A0C;
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public void A1x(RH rh) {
        super.A1x(rh);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final void A1y(C7M c7m, RA ra) {
        super.A1y(c7m, ra);
        if (this.A09) {
            A1K(ra);
            ra.A0P();
        }
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public void A1z(C7M c7m, RH rh, int i) {
        C1998hq linearSmoothScroller = new C1998hq(c7m.getContext());
        linearSmoothScroller.A0A(i);
        A1N(linearSmoothScroller);
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final void A20(String str) {
        if (this.A03 == null) {
            super.A20(str);
        }
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final boolean A21() {
        return (A0a() == 1073741824 || A0k() == 1073741824 || !A1U()) ? false : true;
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final boolean A22() {
        return this.A00 == 0;
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public final boolean A23() {
        return this.A00 == 1;
    }

    @Override // com.instagram.common.viewpoint.core.R2
    public boolean A24() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A25() {
        View child = A0I(0, A0Y(), true, false);
        if (child == null) {
            return -1;
        }
        return A0r(child);
    }

    public final int A26() {
        View child = A0I(0, A0Y(), false, true);
        if (child == null) {
            return -1;
        }
        return A0r(child);
    }

    public final int A27() {
        View child = A0I(A0Y() - 1, -1, false, true);
        if (child == null) {
            return -1;
        }
        return A0r(child);
    }

    public final int A28() {
        return this.A00;
    }

    public final int A29(int i) {
        switch (i) {
            case 1:
                if (this.A00 == 1) {
                    return -1;
                }
                boolean A2H = A2H();
                if (A0G[4].length() != 13) {
                    A0G[7] = "JFBGAdvw0W46p1IiHd184rfjlhxsbjRk";
                    return A2H ? 1 : -1;
                }
                break;
            case 2:
                return (this.A00 != 1 && A2H()) ? -1 : 1;
            case 17:
                if (this.A00 == 0) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            case 33:
                if (this.A00 == 1) {
                    return -1;
                }
                return Integer.MIN_VALUE;
            case 66:
                int i2 = this.A00;
                String[] strArr = A0G;
                if (strArr[6].length() == strArr[2].length()) {
                    A0G[0] = "A4gNOGqmCbgTlyYHXDAs3UqrHjABAhAn";
                    return i2 == 0 ? 1 : Integer.MIN_VALUE;
                }
                break;
            case 130:
                return this.A00 == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
        throw new RuntimeException();
    }

    public View A2A(RA ra, RH rh, int i, int i2, int i3) {
        A2B();
        View view = null;
        View view2 = null;
        int A0A = this.A04.A0A();
        int boundsEnd = this.A04.A07();
        int boundsStart = i2 > i ? 1 : -1;
        while (i != i2) {
            View outOfBoundsMatch = A0v(i);
            int A0r = A0r(outOfBoundsMatch);
            if (A0r >= 0 && A0r < i3) {
                if (((R3) outOfBoundsMatch.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = outOfBoundsMatch;
                    }
                } else if (this.A04.A0F(outOfBoundsMatch) >= boundsEnd || this.A04.A0C(outOfBoundsMatch) < A0A) {
                    if (view2 == null) {
                        view2 = outOfBoundsMatch;
                    }
                } else {
                    return outOfBoundsMatch;
                }
            }
            i += boundsStart;
        }
        return view2 != null ? view2 : view;
    }

    public final void A2B() {
        if (this.A07 == null) {
            C1269Qh A0S = A0S();
            if (A0G[3].charAt(25) != '2') {
                throw new RuntimeException();
            }
            A0G[7] = "6FRvOBuqOIFmnj4QgnBJgNDOjl7oudHL";
            this.A07 = A0S;
        }
        if (this.A04 == null) {
            this.A04 = AbstractC1273Qm.A02(this, this.A00);
        }
    }

    public final void A2C(int i) {
        if (i == 0 || i == 1) {
            A20(null);
            if (i == this.A00) {
                return;
            }
            this.A00 = i;
            this.A04 = null;
            A10();
            return;
        }
        throw new IllegalArgumentException(A0T(0, 20, 45) + i);
    }

    public final void A2D(int i, int i2) {
        this.A01 = i;
        this.A02 = i2;
        if (this.A03 != null) {
            this.A03.A00();
        }
        A10();
    }

    public void A2E(RA ra, RH rh, C1267Qf c1267Qf, int i) {
    }

    public void A2F(RA ra, RH rh, C1269Qh c1269Qh, C1268Qg c1268Qg) {
        int A0i;
        int right;
        int i;
        int i2;
        View A03 = c1269Qh.A03(ra);
        if (A03 == null) {
            c1268Qg.A01 = true;
            return;
        }
        R3 r3 = (R3) A03.getLayoutParams();
        if (c1269Qh.A08 == null) {
            if (this.A05 == (c1269Qh.A05 == -1)) {
                A19(A03);
            } else {
                A1B(A03, 0);
            }
        } else {
            boolean z = this.A05;
            int bottom = c1269Qh.A05;
            if (z == (bottom == -1)) {
                A18(A03);
            } else {
                A1A(A03, 0);
            }
        }
        A1C(A03, 0, 0);
        c1268Qg.A00 = this.A04.A0D(A03);
        if (this.A00 == 1) {
            if (A2H()) {
                i2 = A0j() - A0h();
                i = i2 - this.A04.A0E(A03);
            } else {
                i = A0g();
                i2 = this.A04.A0E(A03) + i;
            }
            if (c1269Qh.A05 == -1) {
                right = c1269Qh.A06;
                A0i = c1269Qh.A06 - c1268Qg.A00;
            } else {
                A0i = c1269Qh.A06;
                right = c1269Qh.A06 + c1268Qg.A00;
            }
        } else {
            A0i = A0i();
            right = this.A04.A0E(A03) + A0i;
            int bottom2 = c1269Qh.A05;
            if (bottom2 == -1) {
                i2 = c1269Qh.A06;
                int i3 = c1269Qh.A06;
                int bottom3 = c1268Qg.A00;
                i = i3 - bottom3;
            } else {
                i = c1269Qh.A06;
                int i4 = c1269Qh.A06;
                int bottom4 = c1268Qg.A00;
                i2 = i4 + bottom4;
            }
        }
        A1D(A03, i, A0i, i2, right);
        if (r3.A02() || r3.A01()) {
            c1268Qg.A03 = true;
        }
        c1268Qg.A02 = A03.hasFocusable();
    }

    public void A2G(RH rh, C1269Qh c1269Qh, R0 r0) {
        int i = c1269Qh.A01;
        if (i >= 0) {
            int pos = rh.A03();
            if (i < pos) {
                int pos2 = c1269Qh.A07;
                r0.A42(i, Math.max(0, pos2));
            }
        }
    }

    public final boolean A2H() {
        return A0c() == 1;
    }

    @Override // com.instagram.common.viewpoint.core.RE
    public final PointF A56(int i) {
        if (A0Y() == 0) {
            return null;
        }
        boolean z = i < A0r(A0v(0));
        boolean z2 = this.A05;
        int firstChildPos = A0G[4].length();
        if (firstChildPos == 13) {
            throw new RuntimeException();
        }
        A0G[7] = "FFnbbIQmxzlcCB5QJgqtb02Njm6aLfkX";
        int i2 = z != z2 ? -1 : 1;
        int direction = this.A00;
        if (direction == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }
}
