package com.instagram.common.viewpoint.core;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.facebook.ads.redexgen.X.lG, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2192lG implements InterfaceC1131Kv {
    public static String[] A0C = {"sfI6nyeMmjCQTVuCF4qtLy1yjQ", "oMMkuqn3AEHt3nTJ2MOQ2D2uSIMoL5hR", "njiJ7f0cFz7yvYhslZfI3p6AsrETAKAq", "CO", "QYzjeJ7DBautBSe7mq0LOiDdFPwmAbmn", "JPkUATb4vKYtG67zqSLtKl3hIns3qHla", "LddklOggznimrifNDzyDRJC2bK2Jwwl3", "KQOf5F07mNCBpldsJ3B6cw89YczO0oD4"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public long A04;
    public InterfaceC1036Hd A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public final C07364v A09;
    public final HN A0A;
    public final String A0B;

    public C2192lG() {
        this(null);
    }

    public C2192lG(String str) {
        this.A02 = 0;
        this.A09 = new C07364v(4);
        this.A09.A0l()[0] = -1;
        this.A0A = new HN();
        this.A04 = -9223372036854775807L;
        this.A0B = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A00(C07364v c07364v) {
        boolean z;
        String str;
        int startOffset;
        byte[] A0l = c07364v.A0l();
        int A0A = c07364v.A0A();
        for (int A09 = c07364v.A09(); A09 < A0A; A09++) {
            int startOffset2 = A0l[A09];
            boolean z2 = (startOffset2 & 255) == 255;
            if (this.A08) {
                int startOffset3 = A0l[A09];
                if ((startOffset3 & 224) == 224) {
                    z = true;
                    this.A08 = z2;
                    String[] strArr = A0C;
                    String str2 = strArr[1];
                    str = strArr[4];
                    startOffset = str2.charAt(11);
                    if (startOffset == str.charAt(11)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0C;
                    strArr2[1] = "cXytat7P8iKtLP6TqIlLVzlvPDaZG4kX";
                    strArr2[4] = "jOC7bwxKPNAtckDXCFNPXzZbhL30f8uL";
                    if (z) {
                        c07364v.A0f(A09 + 1);
                        this.A08 = false;
                        this.A09.A0l()[1] = A0l[A09];
                        this.A00 = 2;
                        this.A02 = 1;
                        return;
                    }
                }
            }
            z = false;
            this.A08 = z2;
            String[] strArr3 = A0C;
            String str22 = strArr3[1];
            str = strArr3[4];
            startOffset = str22.charAt(11);
            if (startOffset == str.charAt(11)) {
            }
        }
        c07364v.A0f(A0A);
    }

    @RequiresNonNull({"output"})
    private void A01(C07364v c07364v) {
        int min = Math.min(c07364v.A07(), this.A01 - this.A00);
        this.A05.AIr(c07364v, min);
        int bytesToRead = this.A00;
        this.A00 = bytesToRead + min;
        int i = this.A00;
        int bytesToRead2 = this.A01;
        if (i < bytesToRead2) {
            return;
        }
        if (this.A04 != -9223372036854775807L) {
            InterfaceC1036Hd interfaceC1036Hd = this.A05;
            String[] strArr = A0C;
            String str = strArr[5];
            String str2 = strArr[6];
            int charAt = str.charAt(20);
            int bytesToRead3 = str2.charAt(20);
            if (charAt == bytesToRead3) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[2] = "FJBco80YTxCtRjQ9gQqQy4qETqBIMl0G";
            strArr2[7] = "R9O1kZ0wfg8ZyFlwYf0hmCttc3ths7ud";
            interfaceC1036Hd.AIu(this.A04, 1, this.A01, 0, null);
            this.A04 += this.A03;
        }
        this.A00 = 0;
        this.A02 = 0;
    }

    @RequiresNonNull({"output"})
    private void A02(C07364v c07364v) {
        int min = Math.min(c07364v.A07(), 4 - this.A00);
        byte[] A0l = this.A09.A0l();
        int bytesToRead = this.A00;
        c07364v.A0k(A0l, bytesToRead, min);
        int bytesToRead2 = this.A00;
        this.A00 = bytesToRead2 + min;
        int bytesToRead3 = this.A00;
        if (bytesToRead3 < 4) {
            return;
        }
        this.A09.A0f(0);
        HN hn = this.A0A;
        int bytesToRead4 = this.A09.A0C();
        if (!hn.A00(bytesToRead4)) {
            this.A00 = 0;
            this.A02 = 1;
            return;
        }
        int bytesToRead5 = this.A0A.A02;
        this.A01 = bytesToRead5;
        if (!this.A07) {
            int bytesToRead6 = this.A0A.A04;
            long j = bytesToRead6 * 1000000;
            int bytesToRead7 = this.A0A.A03;
            this.A03 = j / bytesToRead7;
            C06802p A0h = new C06802p().A0y(this.A06).A11(this.A0A.A06).A0h(4096);
            int bytesToRead8 = this.A0A.A01;
            C06802p A0b = A0h.A0b(bytesToRead8);
            int bytesToRead9 = this.A0A.A03;
            this.A05.A6e(A0b.A0m(bytesToRead9).A10(this.A0B).A14());
            this.A07 = true;
        }
        this.A09.A0f(0);
        this.A05.AIr(this.A09, 4);
        this.A02 = 2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5A(C07364v c07364v) {
        AbstractC07133y.A02(this.A05);
        while (c07364v.A07() > 0) {
            switch (this.A02) {
                case 0:
                    A00(c07364v);
                    break;
                case 1:
                    A02(c07364v);
                    break;
                case 2:
                    A01(c07364v);
                    break;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1131Kv
    public final void A5c(HA ha, LG lg) {
        lg.A05();
        this.A06 = lg.A04();
        this.A05 = ha.AKS(lg.A03(), 1);
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
