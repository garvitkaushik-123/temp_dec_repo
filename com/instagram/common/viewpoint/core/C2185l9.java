package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.l9, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2185l9 implements LH {
    public static String[] A06 = {"EnQWPJ3V2xjVAThncas5joPITTvIB7EF", "1EuaMqG73HQ", "rjBteZjJ0vNfufCjCKCkAuxJVtJJHvWb", "xDvWT2DyWg3zA1fFgEAgA6zc8FBdFJ1B", "sfKNNRwM9cmkD7QHngaf04", "qaF2qGcI8dYBUqEwfxAr3oVVO8wm", "moKLjsoCWr0SdwKtjYcTHr1Csc5rll9E", "bRjHr7kF"};
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final C07364v A04 = new C07364v(32);
    public final L8 A05;

    public C2185l9(L8 l8) {
        this.A05 = l8;
    }

    @Override // com.instagram.common.viewpoint.core.LH
    public final void A5B(C07364v c07364v, int i) {
        boolean z = (i & 1) != 0;
        int i2 = -1;
        if (z) {
            i2 = c07364v.A09() + c07364v.A0I();
        }
        boolean payloadUnitStartIndicator = this.A03;
        if (payloadUnitStartIndicator) {
            if (!z) {
                return;
            }
            this.A03 = false;
            c07364v.A0f(i2);
            this.A00 = 0;
        }
        while (c07364v.A07() > 0) {
            if (this.A00 < 3) {
                if (this.A00 == 0) {
                    int A0I = c07364v.A0I();
                    c07364v.A0f(c07364v.A09() - 1);
                    if (A0I == 255) {
                        this.A03 = true;
                        return;
                    }
                }
                int min = Math.min(c07364v.A07(), 3 - this.A00);
                c07364v.A0k(this.A04.A0l(), this.A00, min);
                this.A00 += min;
                if (this.A00 == 3) {
                    this.A04.A0f(0);
                    this.A04.A0e(3);
                    this.A04.A0g(1);
                    int A0I2 = this.A04.A0I();
                    int A0I3 = this.A04.A0I();
                    boolean payloadUnitStartIndicator2 = (A0I2 & 128) != 0;
                    this.A02 = payloadUnitStartIndicator2;
                    this.A01 = (((A0I2 & 15) << 8) | A0I3) + 3;
                    if (this.A04.A08() < this.A01) {
                        this.A04.A0c(Math.min(4098, Math.max(this.A01, this.A04.A08() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(c07364v.A07(), this.A01 - this.A00);
                c07364v.A0k(this.A04.A0l(), this.A00, min2);
                this.A00 += min2;
                if (this.A00 == this.A01) {
                    boolean payloadUnitStartIndicator3 = this.A02;
                    if (payloadUnitStartIndicator3) {
                        if (C5C.A0I(this.A04.A0l(), 0, this.A01, -1) != 0) {
                            this.A03 = true;
                            return;
                        }
                        this.A04.A0e(this.A01 - 4);
                    } else {
                        this.A04.A0e(this.A01);
                    }
                    this.A04.A0f(0);
                    L8 l8 = this.A05;
                    if (A06[3].charAt(18) == '6') {
                        throw new RuntimeException();
                    }
                    A06[6] = "q6sMTbjJkDPtFUqTMgY1hgSKkn8mDgdv";
                    l8.A5A(this.A04);
                    this.A00 = 0;
                } else {
                    continue;
                }
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.LH
    public final void AAA(AnonymousClass53 anonymousClass53, HA ha, LG lg) {
        this.A05.AAA(anonymousClass53, ha, lg);
        this.A03 = true;
    }

    @Override // com.instagram.common.viewpoint.core.LH
    public final void AJ5() {
        this.A03 = true;
    }
}
