package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.Gf, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1012Gf implements InterfaceC1463Ya {
    public static byte[] A01;
    public static String[] A02 = {"csDJTKMsYdQDTZ6oaAKl5T8I2UfElmlw", "ZPoBWwRbmlxJW4JBXeHiCznpgduRwX0R", "YnHNxwrcL4VP2rzDabEPBpSRhKQlF70O", "ZXjFBdL6N8QRVPocRq4T6yjW", "DvDV4BG5U2fSuPxyYCt3atNQBem4gb3r", "Lz5NxPzXDVZYAcKGP0xvxFjIAyYktO5Y", "USLnjf5V4FwfzNcoOXwUO87ZM5qcDzRn", "2jpbWPspWwKCP4YD7vZxOkEv1N6M1MwD"};
    public final /* synthetic */ C1011Ge A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 89);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        if (A02[0].charAt(1) == '2') {
            throw new RuntimeException();
        }
        A02[3] = "dLINtRlzHu";
        A01 = new byte[]{117, 109, 111, 118};
    }

    static {
        A01();
    }

    public C1012Gf(C1011Ge c1011Ge) {
        this.A00 = c1011Ge;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1463Ya
    public final void ACl(AbstractC1464Yb abstractC1464Yb) {
        AbstractC1068Ij abstractC1068Ij;
        VI vi;
        AbstractC1068Ij abstractC1068Ij2;
        if (abstractC1464Yb.getToolbarActionMode() == 8) {
            abstractC1068Ij = this.A00.A04;
            if (abstractC1068Ij != null) {
                vi = this.A00.A0F;
                vi.A04(VH.A0Y, null);
                abstractC1068Ij2 = this.A00.A04;
                abstractC1068Ij2.A1D(A00(0, 4, 95));
                this.A00.A0G();
                return;
            }
        }
        this.A00.A0E();
    }
}
