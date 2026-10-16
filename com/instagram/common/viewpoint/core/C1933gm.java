package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.gm, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1933gm implements InterfaceC1148Lm {
    public static byte[] A01;
    public static String[] A02 = {"DkadTd3hzRbbbOHMxE7l2HcIgF77c2Wg", "0ZuZJmAU8cZIcQf3szyGmXM5AilOTJtQ", "s7OtZpyonCiYFMYFU1WCjmQvHXym6FPj", "3vySfQzjuhiXchKud6RTPthf0ulaYdWV", "CDvhYqwZm7dYJUP65EPDHmFcAmisUun7", "F", "FueLju8lXT0mR7zmJE5", "4fFvsSsvSh6WJapTHyxRGbQ9SIVR6447"};
    public final /* synthetic */ C1925ge A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 23);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-89, -85, -97, -91, -93};
        String[] strArr = A02;
        if (strArr[4].charAt(11) == strArr[0].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[4] = "8YVOAkqjlCZIfPO923uAjm7vB9HJVDjx";
        strArr2[0] = "zjuPMStvlm1D7VGZIKzQB2odE0473uv0";
        A01 = bArr;
    }

    static {
        A01();
    }

    public C1933gm(C1925ge c1925ge) {
        this.A00 = c1925ge;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1148Lm
    public final void AB4(Throwable th) {
        this.A00.A08().ABC(A00(0, 5, 39), AbstractC1341Td.A1e, new C1342Te(th));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1148Lm
    public final void ABI(Throwable th) {
        this.A00.A08().ABC(A00(0, 5, 39), AbstractC1341Td.A1g, new C1342Te(th));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1148Lm
    public final void AHU(String str, int i, String str2, Long l, Long l2, LX lx) {
        T0.A05(this.A00, lx.A06, lx.A08, lx.A09, lx.A07, lx.A03, i, str2, l, l2, null);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1148Lm
    public final void AHV(String str, boolean z, LX lx) {
        T0.A04(this.A00, new C1337Sz(lx.A06, lx.A08, lx.A07, lx.A03, str), z);
    }
}
