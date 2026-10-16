package com.instagram.common.viewpoint.core;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class IL extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public static String[] A02 = {"mPUp", "QaVG6HdjpkfaxAZj0g", InneractiveMediationDefs.GENDER_FEMALE, "awRGdU6dgRZhiPVlhe", "rFOzx0t9VnUrXKVKNhKeQ4JnbF82l9OW", "Jupus4hVDLzI", "SNB8L6kKTybUpjfk2kEtWCUyw", "zmy1APRNrfa5"};
    public final /* synthetic */ C5S A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 26);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-23, -4, -9, -8, 2, -77, 10, -12, 6, -77, 1, -8, 9, -8, 5, -77, 3, 5, -8, 3, -12, 5, -8, -9};
    }

    static {
        A01();
    }

    public IL(C5S c5s) {
        this.A00 = c5s;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        z = this.A00.A0C;
        if (!z) {
            C5S c5s = this.A00;
            String[] strArr = A02;
            if (strArr[2].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            A02[3] = "r7zn";
            c5s.A0S(A00(0, 24, Sdk.SDKError.Reason.TPAT_ERROR_VALUE));
        }
    }
}
