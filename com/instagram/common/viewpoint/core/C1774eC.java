package com.instagram.common.viewpoint.core;

import com.facebook.ads.AudienceNetworkAds;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.eC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1774eC extends AbstractRunnableC1416Wc {
    public static byte[] A02;
    public final /* synthetic */ AudienceNetworkAds.InitListener A00;
    public final /* synthetic */ AudienceNetworkAds.InitResult A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 77);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{81, 80, 80, 82, 6, 1, 85, 83, Ascii.DLE, 7, 8, 99, 42, 45, 42, 55, 42, 34, 47, 42, 57, 34, 55, 42, 44, 45, 99, 32, 44, 46, 51, 47, 38, 55, 38, 17, Ascii.SYN, Ascii.CR, 48, 2, 5, 6};
    }

    public C1774eC(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        this.A00 = initListener;
        this.A01 = initResult;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        AbstractC1412Vy.A05(A00(35, 7, 46), A00(8, 27, 14), A00(0, 8, 40));
        this.A00.onInitialized(this.A01);
    }
}
