package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* renamed from: com.facebook.ads.redexgen.X.11, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AnonymousClass11 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 75);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{120, 122, 109, 112, 111, 112, 109, 96, 70, 118, 123, 115, 124, 122, 109, 70, 112, 125, SignedBytes.MAX_POWER_OF_TWO, 66, 85, 72, 87, 72, 85, 88, 126, 87, 72, 68, 86, 126, 85, 88, 81, 68, 112, 117, 78, 125, 120, 98, 101, 116, Byte.MAX_VALUE, 116, 99, 78, 98, 116, 101, 73, 76, 119, 92, 81, 88, 77, 83, 65, 66, 87, 81, 70, 109, SignedBytes.MAX_POWER_OF_TWO, 83, 70, 91, 93, 75, 73, 68, 68, 119, 65, 79, 70, 71, 90, 77, 76, 45, 38, 47, 39, 32, 43, 42, Ascii.US, Ascii.DC4, Ascii.GS, Ascii.NAK, Ascii.DC2, Ascii.EM, Ascii.CAN, 35, Ascii.GS, Ascii.CAN, 35, Ascii.NAK, Ascii.DC2, Ascii.CAN, Ascii.EM, 4, 112, 123, 114, 122, 125, 118, 119, 76, 99, 114, 97, 114, 126, 96, 76, 121, 96, 124, 125, Ascii.SUB, Ascii.CR, Ascii.CR, Ascii.DLE, Ascii.CR, 32, Ascii.FS, Ascii.DLE, Ascii.ESC, Ascii.SUB, 97, 118, 118, 107, 118, 91, 105, 97, 119, 119, 101, 99, 97, 113, 108, 119, 113, 100, 96, 125, 123, 122, 48, 57, 43, 7, 58, 49, 60, Ascii.RS, Ascii.ETB, 5, 41, Ascii.NAK, Ascii.EM, Ascii.CAN, 2, 4, Ascii.EM, Ascii.SUB, Ascii.SUB, 19, 4, 93, 84, 70, 106, 89, 92, 70, 65, 80, 91, 80, 71, 99, 106, 120, 84, 124, 110, 105, 125, 98, 110, 124, 34, 42, 41, Ascii.DC4, 47, 34, 56, 42, 41, 39, 46, 47, Ascii.DC4, 41, 50, Ascii.DC4, 44, 32, Ascii.DC2, Ascii.US, 108, 118, 90, 108, 107, 115, 100, 105, 108, 97, 100, 113, 96, 97, 9, 19, 63, Ascii.FF, 5, 6, Ascii.DC4, 63, Ascii.DC4, Ascii.SI, Ascii.DLE, 63, 8, 1, Ascii.FF, 6, 35, 57, Ascii.NAK, 58, 63, 40, 38, 35, 41, 56, 34, Ascii.SO, 34, 33, Base64.padSymbol, 56, 37, Ascii.SO, 34, 50, 35, 52, 52, 63, Ascii.SO, 55, Base64.padSymbol, 48, 54, Ascii.SO, 48, 53, 53, 52, 53, 47, 53, Ascii.EM, 53, 51, 54, 54, 41, 52, 50, 35, 34, Ascii.EM, 47, 40, Ascii.EM, 39, 54, 54, Base64.padSymbol, 50, 58, 88, 91, 85, 80, 107, 81, 76, 81, 87, 65, SignedBytes.MAX_POWER_OF_TWO, 93, 91, 90, 107, 67, 85, 93, SignedBytes.MAX_POWER_OF_TWO, 107, SignedBytes.MAX_POWER_OF_TWO, 93, 89, 81, 107, 89, 71, 39, 36, 42, 47, Ascii.DC4, 63, 34, 38, 46, Ascii.DC4, 38, 56, Ascii.CR, Ascii.SO, 0, 5, 8, Ascii.SI, 6, 62, 0, 5, 0, 17, Ascii.NAK, 4, 19, 40, 36, 43, 44, 35, 32, 54, 49, Ascii.SUB, 40, 50, Ascii.SUB, 54, 48, 53, 53, 42, 55, 49, 75, 67, 66, 79, 71, 82, 79, 73, 72, 121, 73, 80, 67, 84, 74, 71, 95, 121, 85, 67, 82, 60, 52, 34, 34, 48, 54, 52, Ascii.DLE, Ascii.DC2, Ascii.EM, Ascii.CAN, 5, Ascii.US, 55, 7, Ascii.ESC, 55, Ascii.ESC, Ascii.GS, Ascii.CAN, Ascii.CAN, 7, Ascii.SUB, Ascii.FS, Ascii.VT, Ascii.SYN, Ascii.CR, 1, 10, Ascii.DLE, 5, Ascii.DLE, Ascii.CR, Ascii.VT, 10, 68, 88, 85, 87, 81, 89, 81, 90, SignedBytes.MAX_POWER_OF_TWO, 107, 93, 80, Ascii.VT, Ascii.ETB, Ascii.SUB, Ascii.CAN, Ascii.RS, Ascii.SYN, Ascii.RS, Ascii.NAK, Ascii.SI, 36, Ascii.SI, 2, Ascii.VT, Ascii.RS, Ascii.CAN, Ascii.SUB, 7, Ascii.RS, 1, Ascii.FF, Ascii.CR, Ascii.SUB, 58, 45, 41, 59, 39, 38, 71, 80, 68, SignedBytes.MAX_POWER_OF_TWO, 80, 70, 65, 106, 92, 81, 99, 116, 98, 100, 125, 101, 10, 17, Ascii.SYN, Ascii.SO, 38, Ascii.VT, Ascii.FS, 10, Ascii.FF, Ascii.NAK, Ascii.CR, 94, 70, 68, 93, 114, 95, 72, 76, 94, 66, 67, 97, 125, 103, 96, 113, 119, Ascii.ESC, Ascii.CAN, 55, Ascii.ESC, Ascii.VT, 55, 5, Ascii.US, 55, 7, Ascii.ESC, 55, Ascii.ESC, Ascii.GS, Ascii.CAN, Ascii.CAN, 7, Ascii.SUB, Ascii.FS, 95, 82, 91, 78, Byte.MAX_VALUE, 81, Ascii.NAK, 71, 88, 85, 84, 94, Ascii.ETB, 8, 4, Ascii.SYN, 62, Ascii.NAK, Ascii.CAN, 17, 4, 81, 78, 66, 80, 70, 69, 75, 66, 120, 85, 70, 83, 78, 72, 70, 89, 67, 89, 82, 89, 92, 89, 68, 73, 77, 84, 83, 101, 92, 91, 86, 73, 95, 101, 72, 95, 91, 73, 85, 84};
    }
}
