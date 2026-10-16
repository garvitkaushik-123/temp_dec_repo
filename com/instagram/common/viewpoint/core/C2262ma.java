package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.ma, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2262ma extends AbstractC1053Hu {
    public static byte[] A06;
    public static String[] A07 = {"k0wYTkKie1JHeFYg", "DKl7H6qsoN4MQmGVFxhVfc9YoKR", "eOp5RF4DxMr8YboQGZKTl4GQk1b", "2gSlciuhxyUpZq2z", "EzoVAngWIMXE2t797gVmsxYwwugMTqE8", "YSwU3mnkrzPmwh4w8hA9Gpc9iPzLacTq", "wmfh6", "T9R7fvqNl5WyvyD6SUGUJNeU84vDYmq7"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final C07364v A04;
    public final C07364v A05;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 64);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{68, 123, 118, 119, 125, 50, 116, 125, 96, Byte.MAX_VALUE, 115, 102, 50, 124, 125, 102, 50, 97, 103, 98, 98, 125, 96, 102, 119, 118, 40, 50, 43, 52, 57, 56, 50, 114, 60, 43, 62};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.AbstractC1053Hu
    public final boolean A0C(C07364v c07364v, long j) throws C3K {
        int A0I = c07364v.A0I();
        long A0D = j + (c07364v.A0D() * 1000);
        if (A0I == 0 && !this.A02) {
            C07364v c07364v2 = new C07364v(new byte[c07364v.A07()]);
            c07364v.A0k(c07364v2.A0l(), 0, c07364v.A07());
            C1028Gv A00 = C1028Gv.A00(c07364v2);
            this.A01 = A00.A02;
            super.A00.A6e(new C06802p().A11(A00(28, 9, 29)).A0w(A00.A04).A0r(A00.A03).A0f(A00.A01).A0Y(A00.A00).A12(A00.A05).A14());
            this.A02 = true;
            return false;
        }
        if (A0I != 1 || !this.A02) {
            return false;
        }
        int i = this.A00;
        if (A07[1].length() != 27) {
            throw new RuntimeException();
        }
        A07[5] = "ywa4QqUhdtSZ68DIQ13xWUOznnvwilgI";
        boolean z = i == 1;
        if (A07[2].length() == 28) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "IIAwH";
        strArr[0] = "qu1M6PwQ9kLePSP6";
        if (!this.A03 && !z) {
            return false;
        }
        byte[] A0l = this.A04.A0l();
        A0l[0] = 0;
        A0l[1] = 0;
        A0l[2] = 0;
        int i2 = 4 - this.A01;
        int i3 = 0;
        while (c07364v.A07() > 0) {
            c07364v.A0k(this.A04.A0l(), i2, this.A01);
            this.A04.A0f(0);
            int A0L = this.A04.A0L();
            this.A05.A0f(0);
            super.A00.AIr(this.A05, 4);
            super.A00.AIr(c07364v, A0L);
            i3 = i3 + 4 + A0L;
        }
        super.A00.AIu(A0D, z ? 1 : 0, i3, 0, null);
        this.A03 = true;
        return true;
    }

    static {
        A01();
    }

    public C2262ma(InterfaceC1036Hd interfaceC1036Hd) {
        super(interfaceC1036Hd);
        this.A05 = new C07364v(HS.A03);
        this.A04 = new C07364v(4);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1053Hu
    public final boolean A0B(C07364v c07364v) throws C2263mb {
        int A0I = c07364v.A0I();
        int header = A0I >> 4;
        int frameType = header & 15;
        int i = A0I & 15;
        if (i == 7) {
            this.A00 = frameType;
            return frameType != 5;
        }
        throw new C2263mb(A00(0, 28, 82) + i);
    }
}
