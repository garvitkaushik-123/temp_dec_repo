package com.instagram.common.viewpoint.core;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class JH {
    public static byte[] A00;
    public static String[] A01 = {InneractiveMediationDefs.GENDER_FEMALE, "wBzTr9isyWuzk0Was82fzP", "sjHXZ8xDB", "rmj8ZpQPq6N", "k0JnkexrU5JvppKLiAvWnmQe", "wOTrIZh22Rcriy8Kptm38zvp", "MO9vm10BV89BFpJ5cx5aSl", "G2cEiJ7mV"};

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 26);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        byte[] bArr = {-68, -33, -33, -44, -83, -32, -37, -39, -63, -32, -43, -40, -20, 5, 10, Ascii.FF, 7, 7, 6, 9, Ascii.VT, -4, -5, -73, 7, 10, 10, -1, -73, Ascii.CR, -4, 9, 10, 0, 6, 5, -47, -73};
        String[] strArr = A01;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "tjOAGVDnT";
        strArr2[7] = "ur6F1gHbb";
        A00 = bArr;
    }

    static {
        A03();
    }

    public static JG A00(byte[] bArr) {
        C07364v c07364v = new C07364v(bArr);
        if (c07364v.A0A() < 32) {
            return null;
        }
        c07364v.A0f(0);
        if (c07364v.A0C() != c07364v.A07() + 4 || c07364v.A0C() != 1886614376) {
            return null;
        }
        int dataSize = AbstractC1078Iu.A01(c07364v.A0C());
        if (dataSize > 1) {
            AbstractC07214g.A07(A01(0, 12, 82), A01(12, 26, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) + dataSize);
            return null;
        }
        UUID uuid = new UUID(c07364v.A0P(), c07364v.A0P());
        if (dataSize == 1) {
            c07364v.A0g(c07364v.A0L() * 16);
        }
        int atomType = c07364v.A0L();
        String[] strArr = A01;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A01[6] = "Op4nBnIC0DPoqkcvuw04qL";
        if (atomType != c07364v.A07()) {
            return null;
        }
        byte[] bArr2 = new byte[atomType];
        c07364v.A0k(bArr2, 0, atomType);
        return new JG(uuid, dataSize, bArr2);
    }

    public static UUID A02(byte[] bArr) {
        UUID uuid;
        JG parsedAtom = A00(bArr);
        if (parsedAtom != null) {
            uuid = parsedAtom.A01;
            return uuid;
        }
        return null;
    }
}
