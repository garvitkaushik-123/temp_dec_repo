package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Mc, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1164Mc implements XN {
    public static byte[] A01;
    public final /* synthetic */ MW A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 62);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{36, 48, 49, 42, 38, 41, 44, 38, 46};
    }

    public C1164Mc(MW mw) {
        this.A00 = mw;
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void ADS() {
        boolean z;
        boolean z2;
        z = this.A00.A0C;
        if (!z) {
            z2 = this.A00.A0B;
            if (!z2) {
                this.A00.A0V(false, A00(0, 9, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.XN
    public final void AFV(float f) {
    }
}
