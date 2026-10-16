package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Nx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1210Nx implements XN {
    public static byte[] A01;
    public final /* synthetic */ NO A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{69, 81, 80, 75, 71, 72, 77, 71, 79};
    }

    public C1210Nx(NO no) {
        this.A00 = no;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        boolean z;
        boolean z2;
        z = this.A00.A0H;
        if (!z) {
            z2 = this.A00.A0G;
            if (!z2) {
                this.A00.A0W(false, A00(0, 9, 80));
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
    }
}
