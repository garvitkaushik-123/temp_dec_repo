package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.na, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2323na implements InterfaceC1036Hd {
    public static byte[] A0Y;
    public static String[] A0Z = {"85R60pw", "bhfqNyhgsMMcgxDZV18ZYvPWnAETveJ8", "tBTQ49uE8lCvjdowyQOxeOaVlddkkQsD", "cRYvTCVhA9B6pxggP4HMUODB0FrVm2He", "qWsUB7mYWdY8z", "PljQg4leV4XdGi9pMhsrxdm25IT3iHNc", "UH2NGYtrpmiPe", "fmnhpkR"};
    public int A00;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public long A08;

    @MetaExoPlayerCustomization("Added in D14652852 for LiveTrace")
    public Uri A0A;
    public C2489qI A0B;
    public C2489qI A0C;
    public C2489qI A0D;
    public InterfaceC08559s A0E;
    public DP A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final A1 A0T;
    public final A6 A0U;
    public final DL A0V;
    public final DN A0W = new DN();
    public int A01 = 1000;
    public int[] A0P = new int[this.A01];
    public long[] A0Q = new long[this.A01];
    public long[] A0R = new long[this.A01];
    public int[] A0N = new int[this.A01];
    public int[] A0O = new int[this.A01];
    public C1034Hb[] A0S = new C1034Hb[this.A01];
    public final C0934De<DO> A0X = new C0934De<>(new AnonymousClass49() { // from class: com.facebook.ads.redexgen.X.nb
        @Override // com.instagram.common.viewpoint.core.AnonymousClass49
        public final void A39(Object obj) {
            ((DO) obj).A01.AHb();
        }
    });
    public long A09 = Long.MIN_VALUE;
    public long A06 = Long.MIN_VALUE;
    public long A07 = Long.MIN_VALUE;
    public boolean A0L = true;
    public boolean A0M = true;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private synchronized int A03(C07926z c07926z, C2410p0 c2410p0, boolean z, boolean z2, DN dn) {
        c2410p0.A04 = false;
        if (!A0K()) {
            if (!z2 && !this.A0G) {
                if (this.A0D == null || (!z && this.A0D == this.A0B)) {
                    return -3;
                }
                A0H((C2489qI) AbstractC07133y.A01(this.A0D), c07926z);
                return -5;
            }
            c2410p0.A02(4);
            return -4;
        }
        C2489qI c2489qI = this.A0X.A01(A0O()).A00;
        if (z || c2489qI != this.A0B) {
            A0H(c2489qI, c07926z);
            return -5;
        }
        int A00 = A00(this.A03);
        if (!A0L(A00)) {
            c2410p0.A04 = true;
            return -3;
        }
        c2410p0.A02(this.A0N[A00]);
        c2410p0.A01 = this.A0R[A00];
        if (c2410p0.A01 < this.A09) {
            c2410p0.A00(Integer.MIN_VALUE);
        }
        dn.A00 = this.A0O[A00];
        dn.A01 = this.A0Q[A00];
        dn.A02 = this.A0S[A00];
        return -4;
    }

    public static String A0C(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0Y, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A0Y = new byte[]{35, 74, 57, 70, 70, Base64.padSymbol, 56, Base64.padSymbol, 66, 59, -12, 73, 66, 57, 76, 68, 57, 55, 72, 57, 56, -12, 66, 67, 66, 1, 71, 77, 66, 55, -12, 71, 53, 65, 68, SignedBytes.MAX_POWER_OF_TWO, 57, -12, 58, 67, 70, -12, 58, 67, 70, 65, 53, 72, Ascii.SO, -12, -62, -48, -36, -33, -37, -44, -64, -28, -44, -28, -44};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private synchronized void A0G(long j, int i, long j2, int i2, C1034Hb c1034Hb) {
        if (this.A02 > 0) {
            int A00 = A00(this.A02 - 1);
            AbstractC07133y.A07(this.A0Q[A00] + ((long) this.A0O[A00]) <= j2);
        }
        this.A0G = (536870912 & i) != 0;
        this.A07 = Math.max(this.A07, j);
        int A002 = A00(this.A02);
        this.A0R[A002] = j;
        this.A0Q[A002] = j2;
        this.A0O[A002] = i2;
        this.A0N[A002] = i;
        this.A0S[A002] = c1034Hb;
        this.A0P[A002] = this.A05;
        if (this.A0X.A06() || !this.A0X.A00().A00.equals(this.A0D)) {
            this.A0X.A05(A0P(), new DO((C2489qI) AbstractC07133y.A01(this.A0D), this.A0U != null ? this.A0U.AH3(this.A0T, this.A0D) : A5.A00));
        }
        this.A02++;
        if (this.A02 == this.A01) {
            int i3 = this.A01 + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            C1034Hb[] c1034HbArr = new C1034Hb[i3];
            int i4 = this.A01 - this.A04;
            System.arraycopy(this.A0Q, this.A04, jArr, 0, i4);
            System.arraycopy(this.A0R, this.A04, jArr2, 0, i4);
            System.arraycopy(this.A0N, this.A04, iArr2, 0, i4);
            System.arraycopy(this.A0O, this.A04, iArr3, 0, i4);
            System.arraycopy(this.A0S, this.A04, c1034HbArr, 0, i4);
            System.arraycopy(this.A0P, this.A04, iArr, 0, i4);
            int i5 = this.A04;
            System.arraycopy(this.A0Q, 0, jArr, i4, i5);
            System.arraycopy(this.A0R, 0, jArr2, i4, i5);
            System.arraycopy(this.A0N, 0, iArr2, i4, i5);
            System.arraycopy(this.A0O, 0, iArr3, i4, i5);
            System.arraycopy(this.A0S, 0, c1034HbArr, i4, i5);
            System.arraycopy(this.A0P, 0, iArr, i4, i5);
            this.A0Q = jArr;
            this.A0R = jArr2;
            this.A0N = iArr2;
            this.A0O = iArr3;
            this.A0S = c1034HbArr;
            this.A0P = iArr;
            this.A04 = 0;
            this.A01 = i3;
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized long A0S() {
        return this.A02 == 0 ? Long.MIN_VALUE : this.A0R[this.A04];
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final /* synthetic */ int AIp(InterfaceC06692c interfaceC06692c, int i, boolean z) {
        return AbstractC1033Ha.A00(this, interfaceC06692c, i, z);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final /* synthetic */ void AIr(C07364v c07364v, int i) {
        AbstractC1033Ha.A01(this, c07364v, i);
    }

    static {
        A0E();
    }

    public C2323na(F0 f0, A6 a6, A1 a1) {
        this.A0U = a6;
        this.A0T = a1;
        this.A0V = new DL(f0);
    }

    private int A00(int i) {
        int i2 = this.A04 + i;
        int relativeIndex = this.A01;
        if (i2 < relativeIndex) {
            return i2;
        }
        int relativeIndex2 = this.A01;
        return i2 - relativeIndex2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if ((r0 & 1) != 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A01(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.A0R[i] <= j; i4++) {
            if (z) {
                int sampleCountToTarget = this.A0N[i];
            }
            i3 = i4;
            if (this.A0R[i] == j) {
                break;
            }
            i++;
            int sampleCountToTarget2 = this.A01;
            if (i == sampleCountToTarget2) {
                i = 0;
            }
        }
        return i3;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int A02(long j) {
        int i = this.A02;
        int count = this.A02;
        int A00 = A00(count - 1);
        while (i > count && this.A0R[A00] >= j) {
            i--;
            A00--;
            if (A00 == -1) {
                int i2 = this.A01;
                String[] strArr = A0Z;
                String str = strArr[5];
                String str2 = strArr[2];
                int relativeSampleIndex = str.charAt(3);
                int count2 = str2.charAt(3);
                if (relativeSampleIndex != count2) {
                    throw new RuntimeException();
                }
                A0Z[1] = "AmG8zl9kQR5zaFQB0ENdPerRnzM6g9Ua";
                A00 = i2 - 1;
            }
        }
        return i;
    }

    private synchronized long A04() {
        if (this.A02 == 0) {
            return -1L;
        }
        return A06(this.A02);
    }

    private final synchronized long A05() {
        return Math.max(this.A06, A08(this.A03));
    }

    private long A06(int i) {
        this.A06 = Math.max(this.A06, A08(i));
        this.A02 -= i;
        this.A00 += i;
        this.A04 += i;
        if (this.A04 >= this.A01) {
            this.A04 -= this.A01;
        }
        this.A03 -= i;
        if (this.A03 < 0) {
            this.A03 = 0;
        }
        this.A0X.A04(this.A00);
        if (this.A02 == 0) {
            int relativeLastDiscardIndex = this.A04 == 0 ? this.A01 : this.A04;
            int i2 = relativeLastDiscardIndex - 1;
            long j = this.A0Q[i2];
            int relativeLastDiscardIndex2 = this.A0O[i2];
            return j + relativeLastDiscardIndex2;
        }
        return this.A0Q[this.A04];
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long A07(int i) {
        boolean z;
        int discardCount;
        int A0P = A0P() - i;
        boolean z2 = false;
        if (A0P >= 0) {
            int i2 = this.A02;
            int discardCount2 = this.A03;
            if (A0P <= i2 - discardCount2) {
                z = true;
                AbstractC07133y.A07(z);
                int discardCount3 = this.A02;
                this.A02 = discardCount3 - A0P;
                long j = this.A06;
                int discardCount4 = this.A02;
                this.A07 = Math.max(j, A08(discardCount4));
                if (A0P == 0) {
                    boolean z3 = this.A0G;
                    String[] strArr = A0Z;
                    String str = strArr[0];
                    String str2 = strArr[7];
                    int length = str.length();
                    int discardCount5 = str2.length();
                    if (length != discardCount5) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0Z;
                    strArr2[4] = "9q2py6RZjKVKU";
                    strArr2[6] = "N5i42TN5jvK54";
                    if (z3) {
                        z2 = true;
                    }
                }
                this.A0G = z2;
                this.A0X.A03(i);
                discardCount = this.A02;
                if (discardCount == 0) {
                    int discardCount6 = this.A02;
                    int relativeLastWriteIndex = A00(discardCount6 - 1);
                    long j2 = this.A0Q[relativeLastWriteIndex];
                    int discardCount7 = this.A0O[relativeLastWriteIndex];
                    return j2 + discardCount7;
                }
                return 0L;
            }
        }
        z = false;
        AbstractC07133y.A07(z);
        int discardCount32 = this.A02;
        this.A02 = discardCount32 - A0P;
        long j3 = this.A06;
        int discardCount42 = this.A02;
        this.A07 = Math.max(j3, A08(discardCount42));
        if (A0P == 0) {
        }
        this.A0G = z2;
        this.A0X.A03(i);
        discardCount = this.A02;
        if (discardCount == 0) {
        }
    }

    private long A08(int i) {
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        long j = Long.MIN_VALUE;
        int A00 = A00(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.A0R[A00]);
            int i3 = this.A0N[A00];
            if ((i3 & 1) != 0) {
                break;
            }
            A00--;
            if (A00 == -1) {
                A00 = this.A01 - 1;
            }
        }
        return j;
    }

    private synchronized long A09(long j, boolean z, boolean z2) {
        if (this.A02 != 0 && j >= this.A0R[this.A04]) {
            int A01 = A01(this.A04, (!z2 || this.A03 == this.A02) ? this.A02 : this.A03 + 1, j, z);
            if (A01 == -1) {
                return -1L;
            }
            return A06(A01);
        }
        return -1L;
    }

    private final C2489qI A0A(C2489qI c2489qI) {
        if (this.A08 != 0 && c2489qI.A0M != Long.MAX_VALUE) {
            return c2489qI.A07().A0s(c2489qI.A0M + this.A08).A14();
        }
        return c2489qI;
    }

    public static C2323na A0B(F0 f0, A6 a6, A1 a1) {
        return new C2323na(f0, (A6) AbstractC07133y.A01(a6), (A1) AbstractC07133y.A01(a1));
    }

    private void A0D() {
        if (this.A0E != null) {
            this.A0E.AHc(this.A0T);
            this.A0E = null;
            this.A0B = null;
        }
    }

    private synchronized void A0F() {
        this.A03 = 0;
        this.A0V.A0B();
    }

    private void A0H(C2489qI c2489qI, C07926z c07926z) {
        C2489qI c2489qI2;
        boolean z = this.A0B == null;
        DrmInitData newDrmInitData = z ? null : this.A0B.A0O;
        this.A0B = c2489qI;
        DrmInitData oldDrmInitData = c2489qI.A0O;
        if (this.A0U != null) {
            c2489qI2 = c2489qI.A08(this.A0U.A7W(c2489qI));
        } else {
            c2489qI2 = c2489qI;
        }
        c07926z.A00 = c2489qI2;
        c07926z.A01 = this.A0E;
        if (this.A0U == null) {
            return;
        }
        if (!z) {
            boolean A1E = C5C.A1E(newDrmInitData, oldDrmInitData);
            String[] strArr = A0Z;
            if (strArr[5].charAt(3) != strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Z;
            strArr2[5] = "kvzQNhfSOapIkFZHH0bucpMR2mlOE4Ro";
            strArr2[2] = "pNWQqJuQrvmashmvXYzFnQ0x9nljUjVN";
            if (A1E) {
                return;
            }
        }
        if (Looper.myLooper() == null) {
            return;
        }
        InterfaceC08559s interfaceC08559s = this.A0E;
        this.A0E = this.A0U.A3C(this.A0T, c2489qI);
        c07926z.A01 = this.A0E;
        if (interfaceC08559s != null) {
            interfaceC08559s.AHc(this.A0T);
        }
    }

    private final void A0J(boolean z) {
        this.A0V.A0A();
        this.A02 = 0;
        this.A00 = 0;
        this.A04 = 0;
        this.A03 = 0;
        this.A0M = true;
        this.A09 = Long.MIN_VALUE;
        this.A06 = Long.MIN_VALUE;
        this.A07 = Long.MIN_VALUE;
        this.A0G = false;
        this.A0X.A02();
        if (z) {
            this.A0C = null;
            this.A0D = null;
            this.A0L = true;
        }
    }

    private boolean A0K() {
        return this.A03 != this.A02;
    }

    private boolean A0L(int i) {
        return this.A0E == null || this.A0E.A9A() == 4 || ((this.A0N[i] & 1073741824) == 0 && this.A0E.AH1());
    }

    private synchronized boolean A0M(long j) {
        boolean z = true;
        if (this.A02 == 0) {
            if (j <= this.A06) {
                z = false;
            }
            return z;
        }
        if (A05() >= j) {
            return false;
        }
        int A02 = A02(j);
        int retainCount = this.A00;
        A07(retainCount + A02);
        return true;
    }

    private synchronized boolean A0N(C2489qI c2489qI) {
        this.A0L = false;
        if (C5C.A1E(c2489qI, this.A0D)) {
            return false;
        }
        if (!this.A0X.A06() && this.A0X.A00().A00.equals(c2489qI)) {
            this.A0D = this.A0X.A00().A00;
        } else {
            this.A0D = c2489qI;
        }
        this.A0J = C3J.A0G(this.A0D.A0W, this.A0D.A0R);
        this.A0H = false;
        return true;
    }

    public final int A0O() {
        return this.A00 + this.A03;
    }

    public final int A0P() {
        return this.A00 + this.A02;
    }

    public final synchronized int A0Q(long j, boolean z) {
        int A00 = A00(this.A03);
        if (A0K() && j >= this.A0R[A00]) {
            if (j > this.A07 && z) {
                int i = this.A02;
                int relativeReadIndex = this.A03;
                return i - relativeReadIndex;
            }
            int i2 = this.A02;
            int relativeReadIndex2 = this.A03;
            int offset = A01(A00, i2 - relativeReadIndex2, j, true);
            if (offset == -1) {
                return 0;
            }
            return offset;
        }
        return 0;
    }

    public final int A0R(C07926z c07926z, C2410p0 c2410p0, int i, boolean z) {
        int A03 = A03(c07926z, c2410p0, (i & 2) != 0, z, this.A0W);
        if (A03 == -4 && !c2410p0.A05()) {
            int result = i & 1;
            boolean z2 = result != 0;
            int result2 = i & 4;
            if (result2 == 0) {
                if (z2) {
                    this.A0V.A0E(c2410p0, this.A0W);
                } else {
                    this.A0V.A0F(c2410p0, this.A0W);
                }
            }
            if (!z2) {
                int result3 = this.A03;
                this.A03 = result3 + 1;
            }
        }
        return A03;
    }

    public final synchronized long A0T() {
        return this.A07;
    }

    public final synchronized C2489qI A0U() {
        return this.A0L ? null : this.A0D;
    }

    public final void A0V() {
        this.A0V.A0C(A04());
    }

    public final void A0W() throws IOException {
        if (this.A0E == null || this.A0E.A9A() != 1) {
        } else {
            throw ((C08539q) AbstractC07133y.A01(this.A0E.A80()));
        }
    }

    public final void A0X() {
        A0V();
        A0D();
    }

    public final void A0Y() {
        A0J(true);
        A0D();
    }

    public final void A0Z() {
        A0J(false);
    }

    public final synchronized void A0a(int i) {
        boolean z;
        if (i >= 0) {
            if (this.A03 + i <= this.A02) {
                z = true;
                AbstractC07133y.A07(z);
                this.A03 += i;
            }
        }
        z = false;
        AbstractC07133y.A07(z);
        this.A03 += i;
    }

    public final void A0b(long j) {
        this.A09 = j;
    }

    public final void A0c(long j, boolean z, boolean z2) {
        this.A0V.A0C(A09(j, z, z2));
    }

    public final void A0d(DP dp) {
        this.A0F = dp;
    }

    public final synchronized boolean A0e() {
        return this.A0G;
    }

    public final synchronized boolean A0f(long j, boolean z) {
        A0F();
        int A00 = A00(this.A03);
        if (!A0K() || j < this.A0R[A00] || (j > this.A07 && !z)) {
            return false;
        }
        int i = this.A02;
        int relativeReadIndex = this.A03;
        int offset = A01(A00, i - relativeReadIndex, j, true);
        if (offset == -1) {
            return false;
        }
        this.A09 = j;
        int relativeReadIndex2 = this.A03;
        this.A03 = relativeReadIndex2 + offset;
        return true;
    }

    public final synchronized boolean A0g(boolean z) {
        boolean z2 = true;
        if (!A0K()) {
            if (!z && !this.A0G && (this.A0D == null || this.A0D == this.A0B)) {
                z2 = false;
            }
            return z2;
        }
        if (this.A0X.A01(A0O()).A00 != this.A0B) {
            return true;
        }
        return A0L(A00(this.A03));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final void A6e(C2489qI c2489qI) {
        C2489qI A0A = A0A(c2489qI);
        this.A0K = false;
        this.A0C = c2489qI;
        boolean upstreamFormatChanged = A0N(A0A);
        if (this.A0F != null && upstreamFormatChanged) {
            this.A0F.AGL(A0A);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final int AIq(InterfaceC06692c interfaceC06692c, int i, boolean z, int i2) throws IOException {
        return this.A0V.A08(interfaceC06692c, i, z);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final void AIs(C07364v c07364v, int i, int i2) {
        this.A0V.A0D(c07364v, i);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    public final void AIu(long j, int i, int i2, int flags, C1034Hb c1034Hb) {
        int i3 = i;
        if (this.A0K) {
            A6e((C2489qI) AbstractC07133y.A02(this.A0C));
        }
        boolean z = (i3 & 1) != 0;
        if (this.A0M) {
            if (!z) {
                return;
            } else {
                this.A0M = false;
            }
        }
        long j2 = j + this.A08;
        if (this.A0J) {
            if (j2 < this.A09) {
                return;
            }
            if ((i3 & 1) == 0) {
                if (!this.A0H) {
                    AbstractC07214g.A07(A0C(50, 11, 13), A0C(0, 50, 114) + this.A0D);
                    this.A0H = true;
                }
                i3 |= 1;
            }
        }
        if (this.A0I) {
            if (z) {
                boolean A0M = A0M(j2);
                String[] strArr = A0Z;
                String str = strArr[0];
                String str2 = strArr[7];
                int length = str.length();
                int flags2 = str2.length();
                if (length == flags2) {
                    A0Z[3] = "Q9ljdKDjpshc47nqlMYBFO0YDotnOqX8";
                    if (!A0M) {
                        return;
                    } else {
                        this.A0I = false;
                    }
                }
                throw new RuntimeException();
            }
            return;
        }
        long A09 = this.A0V.A09();
        if (A0Z[1].charAt(24) == 'n') {
            A0Z[3] = "281h4YOhy96mUgaRFHojQOWi7hgLUzVm";
            A0G(j2, i3, (A09 - i2) - flags, i2, c1034Hb);
            return;
        }
        throw new RuntimeException();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1036Hd
    @MetaExoPlayerCustomization("Added in D14652852 for LiveTrace")
    public final void AKf(Uri uri) {
        this.A0A = uri;
    }
}
