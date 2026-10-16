package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Collections;

/* renamed from: com.facebook.ads.redexgen.X.lM, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2198lM implements InterfaceC1131Kv {
    public static byte[] A0G;
    public static String[] A0H = {"cAtU07tvAHmpQwteCa8pEQH5gF5iUcfh", "Hjeg7grS71Jm6r5NKbmR8o7Al25NvLrB", "8TbkpeEOwiN436cBQhp4NSePMq1Z0ZNp", "wFA3Sleqv", "yws6lvEdJf3TdH9okNAymdfPd8aH69ii", "xvx7jE251jeLUpmQ5JTTtAODp7RTPAZj", "flKrm8KbmQNj7vJDUwRTOfFPMCPuTaKn", "2PQM5lIFNms8BVmrvHkuPmbcHqu7a2gR"};
    public static final double[] A0I;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public InterfaceC1036Hd A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final C07364v A0B;
    public final C1132Kw A0C;
    public final L4 A0D;
    public final LJ A0E;
    public final boolean[] A0F;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static Pair<C2489qI, Long> A00(C1132Kw c1132Kw, String str) {
        byte[] copyOf = Arrays.copyOf(c1132Kw.A02, c1132Kw.A00);
        int i = copyOf[4] & 255;
        int i2 = copyOf[5] & 255;
        int i3 = (i << 4) | (i2 >> 4);
        int i4 = ((i2 & 15) << 8) | (copyOf[6] & 255);
        float f = 1.0f;
        switch ((copyOf[7] & 240) >> 4) {
            case 2:
                float f2 = i4 * 4;
                float f3 = i3 * 3;
                if (A0H[2].charAt(3) == 'k') {
                    A0H[1] = "IKG5315UEoYuWi8w79ZvxkF28jax6fmF";
                    f = f2 / f3;
                    break;
                }
                throw new RuntimeException();
            case 3:
                f = (i4 * 16) / (i3 * 9);
                break;
            case 4:
                f = (i4 * Sdk.SDKError.Reason.TPAT_ERROR_VALUE) / (i3 * 100);
                break;
        }
        C2489qI A14 = new C06802p().A0y(str).A11(A01(0, 11, 62)).A0r(i3).A0f(i4).A0Y(f).A12(Collections.singletonList(copyOf)).A14();
        long j = 0;
        int i5 = (copyOf[7] & Ascii.SI) - 1;
        if (i5 >= 0 && i5 < A0I.length) {
            double d = A0I[i5];
            int i6 = c1132Kw.A01;
            int i7 = (copyOf[i6 + 9] & 96) >> 5;
            if (i7 != (copyOf[i6 + 9] & Ascii.US)) {
                double d2 = i7;
                if (A0H[2].charAt(3) == 'k') {
                    String[] strArr = A0H;
                    strArr[5] = "rAMAKKtXIRKmVhmwxuLKv06bcSnWRDth";
                    strArr[7] = "TlBzrdA8FTcPVEmXq7DzDEHR3QnpW5Am";
                    d *= (d2 + 1.0d) / (r6 + 1);
                }
                throw new RuntimeException();
            }
            j = (long) (1000000.0d / d);
        }
        return Pair.create(A14, Long.valueOf(j));
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {50, 45, 32, 33, 43, 107, 41, 52, 33, 35, 118};
        if (A0H[4].charAt(19) != 'y') {
            throw new RuntimeException();
        }
        A0H[2] = "5b4kHrs0qMccPUXJRINIqLrMs4aEtqXr";
        A0G = bArr;
    }

    static {
        A02();
        A0I = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    }

    public C2198lM() {
        this(null);
    }

    public C2198lM(LJ lj) {
        this.A0E = lj;
        this.A0F = new boolean[4];
        this.A0C = new C1132Kw(128);
        if (lj != null) {
            this.A0D = new L4(178, 128);
            this.A0B = new C07364v();
        } else {
            this.A0D = null;
            this.A0B = null;
        }
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0115, code lost:
    
        if (r3 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x011b, code lost:
    
        if (r23.A03 == (-9223372036854775807L)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011d, code lost:
    
        r4 = -9223372036854775807L;
        r23.A05.AIu(r23.A03, r23.A09 ? 1 : 0, ((int) (r23.A04 - r23.A02)) - r11, r11, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01ae, code lost:
    
        if (r3 != false) goto L44;
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A5A(C07364v c07364v) {
        long j;
        AbstractC07133y.A02(this.A05);
        int A09 = c07364v.A09();
        int A0A = c07364v.A0A();
        byte[] A0l = c07364v.A0l();
        this.A04 += c07364v.A07();
        this.A05.AIr(c07364v, c07364v.A07());
        while (true) {
            int A04 = HS.A04(A0l, A09, A0A, this.A0F);
            if (A04 == A0A) {
                boolean z = this.A07;
                String[] strArr = A0H;
                if (strArr[6].length() != strArr[3].length()) {
                    A0H[1] = "ooUhAAd1UFU3ZsdgbXiiZIdc17zvx9JT";
                    if (!z) {
                        this.A0C.A01(A0l, A09, A0A);
                    }
                    if (this.A0D != null) {
                        this.A0D.A02(A0l, A09, A0A);
                        return;
                    }
                    return;
                }
            } else {
                int i = c07364v.A0l()[A04 + 3] & 255;
                int i2 = A04 - A09;
                if (!this.A07) {
                    if (i2 > 0) {
                        this.A0C.A01(A0l, A09, A04);
                    }
                    if (this.A0C.A02(i, i2 < 0 ? -i2 : 0)) {
                        Pair<C2489qI, Long> A00 = A00(this.A0C, (String) AbstractC07133y.A01(this.A06));
                        this.A05.A6e((C2489qI) A00.first);
                        this.A00 = ((Long) A00.second).longValue();
                        this.A07 = true;
                    }
                }
                if (this.A0D != null) {
                    int i3 = 0;
                    if (i2 > 0) {
                        this.A0D.A02(A0l, A09, A04);
                    } else {
                        i3 = -i2;
                    }
                    if (this.A0D.A04(i3)) {
                        ((C07364v) C5C.A0f(this.A0B)).A0j(this.A0D.A01, HS.A02(this.A0D.A01, this.A0D.A00));
                        ((LJ) C5C.A0f(this.A0E)).A02(this.A03, this.A0B);
                    }
                    if (i == 178 && c07364v.A0l()[A04 + 2] == 1) {
                        this.A0D.A01(i);
                    }
                }
                if (i == 0 || i == 179) {
                    int i4 = A0A - A04;
                    long j2 = -9223372036854775807L;
                    if (this.A08) {
                        boolean z2 = this.A07;
                        if (A0H[2].charAt(3) == 'k') {
                            A0H[4] = "I3q7BGa2d1yxMNRbgKUy1FZhwbtqEBv0";
                        }
                    }
                    boolean z3 = this.A0A;
                    String[] strArr2 = A0H;
                    if (strArr2[6].length() == strArr2[3].length()) {
                        break;
                    }
                    A0H[1] = "M1cTpkEI0lqbwMedLRZ4APYv7Db9TSYf";
                    if (!z3 || this.A08) {
                        this.A02 = this.A04 - i4;
                        if (this.A01 != j2) {
                            j = this.A01;
                        } else if (this.A03 != j2) {
                            long j3 = this.A03;
                            if (A0H[0].charAt(10) != 'm') {
                                j = this.A00 + j3;
                            } else {
                                A0H[0] = "FNyxia2DuWmH1fHrZAJ70vL24BcjBrNj";
                                j = this.A00 + j3;
                            }
                        } else {
                            j = j2;
                        }
                        this.A03 = j;
                        this.A09 = false;
                        this.A01 = j2;
                        this.A0A = true;
                    }
                    this.A08 = i == 0;
                } else if (i == 184) {
                    this.A09 = true;
                }
                A09 = A04 + 3;
            }
        }
        throw new RuntimeException();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A06 = lg.A04();
        this.A05 = ha.AKS(lg.A03(), 2);
        if (this.A0E != null) {
            this.A0E.A03(ha, lg);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGp() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AGq(long j, int i) {
        this.A01 = j;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void AJ5() {
        HS.A0H(this.A0F);
        this.A0C.A00();
        if (this.A0D != null) {
            L4 l4 = this.A0D;
            if (A0H[1].length() != 32) {
                throw new RuntimeException();
            }
            A0H[0] = "joVCJevLOtmtIagsqVBvfxemqq2mA7LA";
            l4.A00();
        }
        this.A04 = 0L;
        this.A0A = false;
        this.A01 = -9223372036854775807L;
        this.A03 = -9223372036854775807L;
    }
}
