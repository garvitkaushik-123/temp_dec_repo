package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.85, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass85 extends AbstractC2133kH {
    public static byte[] A02;
    public Map<String, String> A00;
    public final Uri A01;

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
        A02 = new byte[]{36, 33, 38, 35};
    }

    public AnonymousClass85(C1929gi c1929gi, VA va, String str, Uri uri, Map<String, String> mExtraData) {
        super(c1929gi, va, str, null, true, true);
        this.A01 = uri;
        this.A00 = mExtraData;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2133kH
    public final EnumC1178Mq A0H() {
        A0J(this.A00, null);
        return EnumC1178Mq.A09;
    }

    public final Uri A0M() {
        String uri = this.A01.getQueryParameter(A00(0, 4, 5));
        if (uri == null) {
            uri = A00(0, 0, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        }
        return XB.A00(uri);
    }
}
