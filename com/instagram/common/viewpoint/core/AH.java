package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: assets/audience_network/classes2.dex */
public final class AH implements InterfaceC2425pF {
    public static byte[] A03;
    public final int A00;
    public final AbstractC06943d A01;
    public final InterfaceC2425pF A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{1, 3, 0, -12, -10, -10, -11, -32, 3, -27, -7, 3, 0, 8};
    }

    public AH(InterfaceC2425pF interfaceC2425pF, AbstractC06943d abstractC06943d, int i) {
        this.A02 = (InterfaceC2425pF) AbstractC07133y.A01(interfaceC2425pF);
        AbstractC07133y.A01(abstractC06943d);
        this.A01 = null;
        this.A00 = i;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final void A43(InterfaceC07605t interfaceC07605t) {
        AbstractC07133y.A01(interfaceC07605t);
        this.A02.A43(interfaceC07605t);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final Map<String, List<String>> A8t() {
        return this.A02.A8t();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final Uri A9P() {
        return this.A02.A9P();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final long AGi(C07495i c07495i) throws IOException {
        throw new NullPointerException(A00(0, 14, 104));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2425pF
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC06692c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        throw new NullPointerException(A00(0, 14, 104));
    }
}
