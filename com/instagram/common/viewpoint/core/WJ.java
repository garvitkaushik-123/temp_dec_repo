package com.instagram.common.viewpoint.core;

import android.util.Log;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public class WJ implements InterfaceC1881fw {
    public static byte[] A01;
    public static String[] A02 = {"Pvxnryfp5C2YJ", "58Tt8xWVSP1vJRxeZG7By0J4DHdpZFgc", "d8fJjrUVSDGdkyzleHZclvn63G4sHX0L", "2vkexQ2kDfwHm", "C5INcofoFkRix0Rm4DG2QIlt8jox4BBj", "", "Y25u3HoHlGlpJYy8Y", "MTcvQGxX9nLrxfee4M1dH5SKsx5IsifC"};
    public final /* synthetic */ T8 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A02[5].length() == 8) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "YNZl3vrESdm0ZjqRAgqNuDMkNkDkDjcM";
            strArr[2] = "T4MR0Bp8ShJAOBNGhRUi97nIryoGWHBS";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 37);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{Ascii.SUB, 56, 55, 126, 45, 121, Base64.padSymbol, 48, 42, 41, 56, 45, 58, 49, 121, 58, 54, 44, 55, 45, 60, 43, 42, 119, 77, 96, 122, 121, 104, 125, 106, 97, 108, 109, 41, 106, 102, 124, 103, 125, 108, 123, 122, 39, 41, 91, 108, 122, 121, 102, 103, 122, 108, 51, 41};
    }

    static {
        A01();
    }

    public WJ(T8 t8) {
        this.A00 = t8;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1881fw
    public final void ADR(InterfaceC1879fu interfaceC1879fu) {
        if (this.A00.A05().AAO() && interfaceC1879fu != null) {
            String str = A00(24, 31, 44) + interfaceC1879fu.A73();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1881fw
    public final void ADq(Exception exc) {
        String str;
        if (this.A00.A05().AAO()) {
            str = VL.A01;
            Log.e(str, A00(0, 24, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), exc);
        }
    }
}
