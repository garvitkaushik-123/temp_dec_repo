package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.pt, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2464pt implements AnonymousClass24 {
    public static byte[] A00;
    public static String[] A01 = {"aC8uc30vckBh0ldJ8CsDkWWGmQgl7sOm", "2", "dPCbCdxH5PRV4edn", "QHj", "dDf", "KHWYQA", "nwDl9CeJStZlhkBKgBcw2akg3aHE6X2p", "I5"};
    public static final String A02;
    public static final AnonymousClass23<AbstractC2464pt> A03;

    public static String A06(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 9);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{-126, -101, -104, -101, -100, -92, -101, 77, Byte.MAX_VALUE, -114, -95, -106, -101, -108, -127, -90, -99, -110, 103, 77};
    }

    static {
        A07();
        A02 = C5C.A0h(0);
        A03 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.pu
            @Override // com.instagram.common.viewpoint.core.AnonymousClass23
            public final AnonymousClass24 A6f(Bundle bundle) {
                AbstractC2464pt A04;
                A04 = AbstractC2464pt.A04(bundle);
                return A04;
            }
        };
    }

    public static AbstractC2464pt A04(Bundle bundle) {
        int i = bundle.getInt(A02, -1);
        switch (i) {
            case 0:
                return AX.A02.A6f(bundle);
            case 1:
                AV A6f = AV.A02.A6f(bundle);
                if (A01[6].charAt(2) != 'F') {
                    String[] strArr = A01;
                    strArr[7] = "RK";
                    strArr[1] = "0";
                    return A6f;
                }
                break;
            case 2:
                return AU.A04.A6f(bundle);
            case 3:
                AT A6f2 = AT.A02.A6f(bundle);
                if (A01[6].charAt(2) != 'F') {
                    String[] strArr2 = A01;
                    strArr2[7] = "Vr";
                    strArr2[1] = "2";
                    return A6f2;
                }
                break;
            default:
                throw new IllegalArgumentException(A06(0, 20, 36) + i);
        }
        throw new RuntimeException();
    }
}
