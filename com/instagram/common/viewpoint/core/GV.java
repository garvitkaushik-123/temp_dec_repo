package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class GV extends AbstractRunnableC1416Wc {
    public static byte[] A01;
    public static String[] A02 = {"ziFc1AxLwl06l9cm2ro8EEkTqcfxuLTc", "Ot3h47XlIqwqlb0VDKX34tYNREgAb88h", "XErmhi3UBKLFfekLEXmFG5T5AXnu", "x4ahbzSdp8w2tJq97wkZytqruvrbxvGd", "5eNtQA6JlDjBFR49aczWqHsgt2phfPFu", "5gzf4", "tgwS2khKEZgsCudiehRL6tpdm2kFQW", "Wy"};
    public final /* synthetic */ C4V A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 14);
            if (A02[5].length() != 5) {
                throw new RuntimeException();
            }
            A02[2] = "VyWbJGKy3Ebs7lO";
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{62, 1, Ascii.FF, Ascii.CR, 7, 72, 6, Ascii.CR, Ascii.RS, Ascii.CR, Ascii.SUB, 72, Ascii.ESC, Ascii.FS, 9, Ascii.SUB, Ascii.FS, Ascii.CR, Ascii.FF, 72, Ascii.CAN, 4, 9, 17, 1, 6, Ascii.SI};
    }

    static {
        A01();
    }

    public GV(C4V c4v) {
        this.A00 = c4v;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        boolean z;
        z = this.A00.A0F;
        if (!z) {
            this.A00.A0Q(A00(0, 27, 102));
        }
    }
}
