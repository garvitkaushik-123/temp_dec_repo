package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class GT extends AbstractRunnableC1416Wc {
    public static byte[] A02;
    public static String[] A03 = {"zQTxaAZtyj5Zf7xpyBa5Wo13", "ZyRPoqiC9PInhvt4VYdLIOd5Fjjwld3Q", "AJVcAlxtfo1o3uDwHkILc2qtWBcw5I", "qm4l90vWWtQXhhB5Cv7", "msnWA3qGYryppWjZvi7PZr4M3Bb415RH", "kQT0oRvSr6py", "zmROIVOKOovaIXaapuTgFe6PU", "TFR8Ke0ijybG7ZAZ7LbnVmkovmXx0N"};
    public final /* synthetic */ C4V A00;
    public final /* synthetic */ C4A A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 22);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{120, -85, -100, -100, -101, -88, -97, -92, -99, 86, -97, -92, -102, -101, -100, -97, -92, -97, -86, -101, -94, -81};
    }

    static {
        A01();
    }

    public GT(C4V c4v, C4A c4a) {
        this.A00 = c4v;
        this.A01 = c4a;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        c0966Ek = this.A00.A0M;
        if (c0966Ek.getState() == EnumC1871fm.A02) {
            c0966Ek2 = this.A00.A0M;
            int currentPositionInMillis = c0966Ek2.getCurrentPositionInMillis();
            if (A03[1].charAt(3) != 'P') {
                throw new RuntimeException();
            }
            A03[3] = "tIcfuB5su4wQORzkX2J";
            if (currentPositionInMillis == A00()) {
                this.A00.A0Q(A00(0, 22, 32));
            }
        }
    }
}
