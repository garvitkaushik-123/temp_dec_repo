package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Hv, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1054Hv extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public final /* synthetic */ C5F A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{118, 73, 68, 69, 79, 0, 87, 65, 83, 0, 78, 69, 86, 69, 82, 0, 80, 82, 69, 80, 65, 82, 69, 68};
    }

    public C1054Hv(C5F c5f) {
        this.A00 = c5f;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        InterfaceC1749dm interfaceC1749dm;
        z = this.A00.A0T;
        if (!z) {
            interfaceC1749dm = this.A00.A0Z;
            interfaceC1749dm.AGQ(A00(0, 24, 86));
        }
    }
}
