package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Hn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1046Hn extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public static String[] A02 = {"MrnT4Eks85vPuqQr37JMtu4NfaYgfi6f", "zfkVjNlCcNBydFIcz2mD", "Bee43nRREoDmuohWbk", "LYOPzNoZy5N5VpEZxT", "78Vp0AX9Eb5UezJBTqKvLg5S66jER", "qnB2IM", "Ag3pKfa1yi0C6RoVnqVP", "pygY9b2"};
    public final /* synthetic */ AnonymousClass55 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            byte b = copyOfRange[i4];
            if (A02[4].length() != 29) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[2] = "zTo8qTO106BkbxhANT";
            strArr[3] = "z1bPe1QyN1GViRGZCE";
            copyOfRange[i4] = (byte) ((b - i3) - 15);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-111, -92, -97, -96, -86, 91, -78, -100, -82, 91, -87, -96, -79, -96, -83, 91, -85, -83, -96, -85, -100, -83, -96, -97};
    }

    static {
        A01();
    }

    public C1046Hn(AnonymousClass55 anonymousClass55) {
        this.A00 = anonymousClass55;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        z = this.A00.A0M;
        if (!z) {
            AnonymousClass55 anonymousClass55 = this.A00;
            String[] strArr = A02;
            if (strArr[7].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            A02[1] = "EIUkH3ntVfUyNEjhHXbRpTHh";
            anonymousClass55.A0s(A00(0, 24, 44));
        }
    }
}
