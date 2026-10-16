package com.instagram.common.viewpoint.core;

import android.view.View;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class ZO implements View.OnClickListener {
    public static byte[] A01;
    public static String[] A02 = {"Rngvbb3vMR3b56rBexb50Rjom5JamLMR", "BOyMrOLOVyOlAA7tdLfD", "PSvH7Ca0GqwbJXrw1OxZU20X4aHcam0S", "dzm7VVMnrqblx5opBv2tkfICkL24O513", "rKXY71", "THxRt8Yss0BlXBXFFRIVlNUaizFLAmop", "EnNQl89tpWVbcex4LtQ2YfadlOVOSM9k", "1aWdi1c8aZwiTk2zvtk8Xc2vTbtrER0G"};
    public final /* synthetic */ MI A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 38);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{0, Ascii.NAK, 2, Ascii.SYN, Ascii.US, 2, Ascii.GS, 51, 4, 17, 51, Ascii.FS, Ascii.EM, 19, Ascii.ESC};
    }

    static {
        A01();
    }

    public ZO(MI mi) {
        this.A00 = mi;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1470Yh interfaceC1470Yh;
        if (WU.A02(this)) {
            return;
        }
        try {
            interfaceC1470Yh = this.A00.A06;
            interfaceC1470Yh.A4j(A00(0, 15, 86));
        } catch (Throwable th) {
            WU.A00(th, this);
            String[] strArr = A02;
            if (strArr[7].charAt(31) == strArr[5].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[6] = "qnEa0qqxoU4sFli1HS9Y3SbmuU3eBkbM";
            strArr2[0] = "NnijgEsxsjK8xKe1vFUOE7dsdCVZHTLh";
        }
    }
}
