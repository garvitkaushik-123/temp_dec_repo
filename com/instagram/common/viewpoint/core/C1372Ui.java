package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.Ui, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1372Ui {
    public final int A00;
    public final C1369Uf A01;

    public C1372Ui(int i, C1369Uf c1369Uf) {
        this.A00 = i;
        this.A01 = c1369Uf;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() throws IOException {
        return this.A01.A05();
    }

    public final UW A02(int i, byte[] bArr, int i2, int[] iArr, int i3) throws IOException {
        return this.A01.A06(i, bArr, i2, iArr, i3);
    }

    public final void A03() throws IOException {
        this.A01.A07();
    }

    public final void A04() throws IOException {
        this.A01.A08();
    }

    public final boolean A05(byte[] bArr) throws IOException {
        return this.A01.A09(bArr);
    }
}
