package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Mt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1181Mt {
    public static byte[] A04;
    public InterfaceC1179Mr A00;
    public final C1929gi A01;
    public final VA A02;
    public final String A03;

    static {
        A0D();
    }

    public static String A0B(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A0D() {
        A04 = new byte[]{84, 69, 69, 106, 84, 81, 108, 105, 110, 107, 95, 99, 108, 105, 99, 107, 112, 102, 115, 100, 111, 88, 102, 105, 99, 88, 101, 117, 104, 112, 116, 98};
    }

    public abstract EnumC1178Mq A0G(String str);

    public AbstractC1181Mt(C1929gi c1929gi, VA va, String str) {
        this.A01 = c1929gi;
        this.A02 = va;
        this.A03 = str;
    }

    public static String A0A() {
        return A0B(16, 16, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
    }

    public static String A0C(AbstractC1181Mt abstractC1181Mt) {
        if (abstractC1181Mt instanceof AnonymousClass84) {
            return A0B(6, 10, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
        }
        return A0B(0, 6, 79);
    }

    public final InterfaceC1179Mr A0E() {
        return this.A00;
    }

    public final void A0F(InterfaceC1179Mr interfaceC1179Mr) {
        this.A00 = interfaceC1179Mr;
    }
}
