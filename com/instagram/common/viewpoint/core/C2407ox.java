package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ox, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2407ox implements AnonymousClass74 {
    public static byte[] A0B;
    public static String[] A0C = {"WWBqbqM8cT7NtZ20aOE3uXs3Aw8DSv9K", "wsMqXc0RGaIy4bMjDS0CDKFK5K3H0E7a", "tXUn5oHGArEZhR5EfIYxUHEmkE2i7Wlz", "L3oqKt7yiugAXq9nLkVCiYddeszNHWIU", "GxMV2HKS42DeS6e3iSG9rTJ", "iBUmcZRwnnz5BMe8LKV", "MLtAALupoqSZMT31TgfSKHmksSEA2gyG", "KlBG0Bt2bdiLbLP3pzzetkFN2"};
    public int A00;
    public boolean A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final long A07;
    public final C2299nC A08;
    public final boolean A09;
    public final boolean A0A;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 69);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A0B = new byte[]{-127, -60, -62, -49, -49, -48, -43, -127, -61, -58, -127, -51, -58, -44, -44, -127, -43, -55, -62, -49, -127, 123, -91, -58, -57, -62, -42, -51, -43, -83, -48, -62, -59, -92, -48, -49, -43, -45, -48, -51, 3, Ascii.DLE, 33, Ascii.SYN, Ascii.DC4, 35, -49, 17, 36, Ascii.NAK, Ascii.NAK, Ascii.DC4, 33, -49, 34, Ascii.CAN, 41, Ascii.DC4, -49, 33, Ascii.DC4, Ascii.DLE, Ascii.DC2, Ascii.ETB, Ascii.DC4, 19, -49, 38, Ascii.CAN, 35, Ascii.ETB, -49, Ascii.ESC, Ascii.DC4, 34, 34, -49, 35, Ascii.ETB, Ascii.DLE, Ascii.GS, -49, -28, -33, -33, Ascii.FS, 34, -49, Ascii.RS, Ascii.NAK, -49, 17, 36, Ascii.NAK, Ascii.NAK, Ascii.DC4, 33, Ascii.DC4, 19, -49, Ascii.FS, Ascii.DC4, 19, Ascii.CAN, Ascii.DLE, -49, 19, Ascii.DLE, 35, Ascii.DLE, -35, -36, -37, -35, -27, -68, -17, -32, -32, -33, -20, -66, -17, -20, -37, -18, -29, -23, -24, -57, -19, -77, -58, -73, -73, -74, -61, -105, -64, -61, -95, -67, -78, -54, -77, -78, -76, -68, -110, -73, -59, -74, -61, -93, -74, -77, -58, -73, -73, -74, -61, -98, -60, Ascii.NAK, 40, Ascii.EM, Ascii.EM, Ascii.CAN, 37, -7, 34, 37, 3, Ascii.US, Ascii.DC4, 44, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.RS, 0, 38, -12, -24, -1, -55, -4, -19, -19, -20, -7, -44, -6, 43, 39, 44, 0, 51, 36, 36, 35, 48, Ascii.VT, 49};
    }

    static {
        A03();
    }

    public C2407ox() {
        this(new C2299nC(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public C2407ox(C2299nC c2299nC, int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        int i7;
        String A02 = A02(163, 19, 110);
        String A022 = A02(21, 1, 6);
        A04(i3, 0, A02, A022);
        String A023 = A02(Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 32, 12);
        A04(i4, 0, A023, A022);
        String A024 = A02(193, 11, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        A04(i, i3, A024, A02);
        A04(i, i4, A024, A023);
        A04(i2, i, A02(182, 11, 66), A024);
        A04(i6, 0, A02(111, 20, 53), A022);
        this.A08 = c2299nC;
        this.A07 = C5C.A0O(i);
        this.A06 = C5C.A0O(i2);
        this.A05 = C5C.A0O(i3);
        this.A04 = C5C.A0O(i4);
        this.A02 = i5;
        if (this.A02 != -1) {
            i7 = this.A02;
        } else {
            i7 = 13107200;
        }
        this.A00 = i7;
        this.A09 = z;
        this.A03 = C5C.A0O(i6);
        this.A0A = z2;
    }

    public static int A00(int i) {
        switch (i) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return 144310272;
            case 1:
                return 13107200;
            case 2:
                if (A0C[7].length() == 32) {
                    throw new RuntimeException();
                }
                A0C[5] = "ABED08YC";
                return 131072000;
            case 3:
                return 131072;
            case 4:
                return 131072;
            case 5:
                return 131072;
            case 6:
                return 131072;
        }
    }

    private final int A01(InterfaceC2301nE[] interfaceC2301nEArr) {
        int i = 0;
        for (InterfaceC2301nE interfaceC2301nE : interfaceC2301nEArr) {
            if (interfaceC2301nE != null) {
                int targetBufferSize = interfaceC2301nE.A9L().A02;
                i += A00(targetBufferSize);
            }
        }
        int max = Math.max(13107200, i);
        if (A0C[0].charAt(6) == 'f') {
            throw new RuntimeException();
        }
        A0C[0] = "RHrwW0B94f4UqoylhYQPwgHgnQSWW3zM";
        return max;
    }

    public static void A04(int i, int i2, String str, String str2) {
        AbstractC07133y.A09(i >= i2, str + A02(0, 21, 28) + str2);
    }

    private void A05(boolean z) {
        int i;
        if (this.A02 == -1) {
            i = 13107200;
        } else {
            i = this.A02;
        }
        this.A00 = i;
        this.A01 = false;
        if (z) {
            this.A08.A01();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final C2299nC A6v() {
        return this.A08;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final long A70(C8O c8o) {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final void AFR(C8O c8o) {
        A05(false);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final void AFc(C8O c8o) {
        A05(true);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final void AG6(C8O c8o) {
        A05(true);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final void AGF(AnonymousClass73 anonymousClass73, C2319nW c2319nW, InterfaceC2301nE[] interfaceC2301nEArr) {
        int i;
        if (this.A02 == -1) {
            i = A01(interfaceC2301nEArr);
        } else {
            i = this.A02;
        }
        this.A00 = i;
        this.A08.A02(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final boolean AIn(C8O c8o) {
        return this.A0A;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final boolean AJv(AnonymousClass73 anonymousClass73) {
        boolean z = true;
        boolean z2 = this.A08.A00() >= this.A00;
        long j = this.A07;
        if (anonymousClass73.A00 > 1.0f) {
            j = Math.min(C5C.A0Q(j, anonymousClass73.A00), this.A06);
        }
        if (anonymousClass73.A01 < Math.max(j, 500000L)) {
            boolean targetBufferSizeReached = this.A09;
            if (!targetBufferSizeReached && z2) {
                z = false;
            }
            this.A01 = z;
            boolean targetBufferSizeReached2 = this.A01;
            if (!targetBufferSizeReached2 && anonymousClass73.A01 < 500000) {
                AbstractC07214g.A07(A02(22, 18, 28), A02(40, 71, 106));
            }
        } else if (anonymousClass73.A01 >= this.A06 || z2) {
            this.A01 = false;
        }
        boolean targetBufferSizeReached3 = this.A01;
        return targetBufferSizeReached3;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass74
    public final boolean AJy(long j, float f, boolean z, boolean z2, long minBufferDurationUs) {
        long A0R = C5C.A0R(j, f);
        long j2 = z ? this.A04 : this.A05;
        String[] strArr = A0C;
        if (strArr[3].charAt(20) == strArr[1].charAt(20)) {
            throw new RuntimeException();
        }
        A0C[4] = "l7tzQS6toEbIIxnpfZA1NGx";
        if (minBufferDurationUs != -9223372036854775807L) {
            j2 = Math.min(minBufferDurationUs / 2, j2);
        }
        return j2 <= 0 || A0R >= j2 || (!this.A09 && this.A08.A00() >= this.A00);
    }
}
