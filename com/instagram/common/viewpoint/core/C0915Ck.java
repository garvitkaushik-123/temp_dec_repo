package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.Ck, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C0915Ck implements InterfaceC1896gB {
    public static byte[] A01;
    public final boolean A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{75, Ascii.SO, 48, Ascii.FS, Ascii.GS, 7, Ascii.SYN, Ascii.GS, 7, 73, 83, 42, Ascii.GS, Ascii.ESC, Ascii.GS, 17, Ascii.SO, Ascii.GS, 88, Ascii.CR, 10, Ascii.DC4, 66, 88, Ascii.RS, 57, 44, 57, 56, 62, 119, 109};
    }

    public C0915Ck(boolean z) {
        this.A00 = z;
    }

    private void A02(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String header : map.get(str)) {
                    String str2 = str + A00(1, 1, 74) + header;
                }
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1896gB
    public final boolean AAZ() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1896gB
    public final void ABt(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        String str = httpURLConnection.getRequestMethod() + A00(0, 1, 21) + httpURLConnection.getURL().toString();
        if (obj instanceof String) {
            String str2 = A00(2, 9, 13) + ((String) obj);
        }
        A02(httpURLConnection.getRequestProperties());
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1896gB
    public final void ABu(InterfaceC1879fu interfaceC1879fu) {
        if (interfaceC1879fu != null) {
            String str = A00(11, 13, 6) + interfaceC1879fu.getUrl();
            String str2 = A00(24, 8, 51) + interfaceC1879fu.A9C();
            A02(interfaceC1879fu.A8E());
        }
    }
}
