package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public class I7 extends AbstractRunnableC1416Wc {
    public static byte[] A02;
    public static String[] A03 = {"", "vSeS2rx23zUd4am5Wdo", "UtlZDzt7", "dNEruPHPdkyj182N7GwirLXq8Db2eecB", "b1VGcsOgsecYYY6uN1zNid8VodysKnsR", "yg", "RqC1uxvv784HDfNbZXUq5U9jCsQW0kUg", "5jFX4DLWV5nBObgEbVC73yk5ncCVY3Kv"};
    public final /* synthetic */ C5S A00;
    public final /* synthetic */ C4A A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 72);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{51, 4, Ascii.ETB, Ascii.ETB, Ascii.DC4, 3, Ascii.CAN, Ascii.US, Ascii.SYN, 81, Ascii.CAN, Ascii.US, Ascii.NAK, Ascii.DC4, Ascii.ETB, Ascii.CAN, Ascii.US, Ascii.CAN, 5, Ascii.DC4, Ascii.GS, 8};
    }

    static {
        A01();
    }

    public I7(C5S c5s, C4A c4a) {
        this.A00 = c5s;
        this.A01 = c4a;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        C0966Ek c0966Ek;
        C0966Ek c0966Ek2;
        c0966Ek = this.A00.A0S;
        if (c0966Ek.getState() == EnumC1871fm.A02) {
            c0966Ek2 = this.A00.A0S;
            int currentPositionInMillis = c0966Ek2.getCurrentPositionInMillis();
            if (A03[2].length() != 8) {
                throw new RuntimeException();
            }
            A03[7] = "iv52OwD8pgB4ao6bV3eWAeQD9PjHFRbz";
            if (currentPositionInMillis == A00()) {
                this.A00.A0S(A00(0, 22, 57));
            }
        }
    }
}
