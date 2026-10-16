package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class JJ implements InterfaceC1712dB {
    public static byte[] A01;
    public static String[] A02 = {"j0Llx0J1MSgFmdDCajgZS", "WqPPZqRc0dX4AocYH9RDHKNy8FKfctFv", "x4SSjhhb9i0sKdnf0Wf5s", "xtX3gCAokrJDAeXWoUYA8plxhmXwCeOm", "uRKBJqZuIeGTpbClJ99Pe9ZmQekDyja2", "rD1ESZhEMARN2moY0NiI8P2eIcx2KKt8", "vMF11DxP2anc735da3YXnRmNGLge", "xeUiMncNmqcgkFgn7eafy8FxNu3C"};
    public final /* synthetic */ AnonymousClass62 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[6] = "mcgN6rOfJkIrJEn9BPtko0s6E0JP";
            strArr2[7] = "7NujJgKdrQLNFT4Mmbwt8V3uSlrM";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 20);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{47, 46, 88, Ascii.ESC, 10, Ascii.EM, Ascii.VT, Ascii.DLE, Ascii.GS, Ascii.FS, Ascii.FS, Ascii.SO, 9, 52, Ascii.GS, 2, Ascii.SO, Ascii.FS};
    }

    static {
        A01();
    }

    public JJ(AnonymousClass62 anonymousClass62) {
        this.A00 = anonymousClass62;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1712dB
    public final void AFU() {
        C1925ge context = T7.A00();
        if (context != null) {
            context.A08().ABC(A00(10, 8, 127), AbstractC1341Td.A2g, new C1342Te(A00(0, 10, 108)));
        }
    }
}
