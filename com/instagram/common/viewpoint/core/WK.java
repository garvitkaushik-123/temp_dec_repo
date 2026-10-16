package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.mediation.LevelPlayAdError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public enum WK {
    A0D(A00(IronSourceError.ERROR_AD_UNIT_CAPPED, 25, 31)),
    A0B(A00(477, 25, 4)),
    A0A(A00(449, 28, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE)),
    A0C(A00(502, 28, 36)),
    A0E(A00(555, 35, 90)),
    A09(A00(432, 17, 93)),
    A0I(A00(648, 14, 112)),
    A0H(A00(LevelPlayAdError.ERROR_CODE_SHOW_WHILE_LOAD, 17, 94)),
    A0G(A00(614, 17, 52)),
    A03(A00(342, 7, 0)),
    A07(A00(396, 14, 65)),
    A06(A00(376, 20, 12)),
    A08(A00(410, 22, 6)),
    A05(A00(363, 13, 53)),
    A04(A00(349, 14, 83)),
    A0F(A00(590, 24, 113)),
    A0J(A00(EventTypeExtended.EVENT_TYPE_EXTENDED_SK_OVERLAY_PRESENTING_VALUE, 22, 37));

    public static byte[] A01;
    public final String A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-91, -75, -78, -70, -74, -88, -75, -25, -20, -27, -19, -14, -23, -24, 3, -19, -14, -8, 3, -27, -24, -77, -72, -79, -71, -66, -75, -76, -49, -62, -58, -49, -79, -76, -96, -75, -86, -99, -87, -91, -97, -69, -91, -86, -80, -95, -82, -81, -80, -91, -80, -91, -99, -88, -94, -73, -84, -97, -85, -89, -95, -67, -84, -97, -78, -89, -76, -93, -89, -68, -79, -92, -80, -84, -90, -62, -75, -88, -70, -92, -75, -89, -88, -89, -62, -71, -84, -89, -88, -78, 3, Ascii.DC2, 9, 9, Ascii.FS, Ascii.DLE, 0, Ascii.SI, 2, 2, Ascii.VT, Ascii.FS, 19, 6, 1, 2, Ascii.FF, -64, -59, -53, -68, -55, -54, -53, -64, -53, -64, -72, -61, -42, -59, -72, -53, -64, -51, -68, -42, -70, -72, -55, -58, -52, -54, -68, -61, -12, -7, -1, -16, -3, -2, -1, -12, -1, -12, -20, -9, 10, -7, -20, -1, -12, 1, -16, 10, -12, -8, -20, -14, -16, -35, -30, -24, -39, -26, -25, -24, -35, -24, -35, -43, -32, -13, -30, -43, -24, -35, -22, -39, -13, -28, -32, -43, -19, -43, -42, -32, -39, Ascii.US, 36, 42, Ascii.ESC, 40, 41, 42, Ascii.US, 42, Ascii.US, Ascii.ETB, 34, 53, 36, Ascii.ETB, 42, Ascii.US, 44, Ascii.ESC, 53, 44, Ascii.US, Ascii.SUB, Ascii.ESC, 37, -2, 3, 9, -6, 7, 8, 9, -2, 9, -2, -10, 1, Ascii.DC4, Ascii.VT, -2, -7, -6, 4, Ascii.DC4, 1, -6, -10, -7, -2, 3, -4, Ascii.DC4, 5, 1, -10, Ascii.SO, -10, -9, 1, -6, -9, -22, -14, -12, -7, -22, 4, -26, -24, -7, -18, -5, -18, -7, -2, 4, -15, -26, -6, -13, -24, -19, -22, -9, -50, -63, -45, -67, -50, -64, -63, -64, -37, -65, -67, -50, -53, -47, -49, -63, -56, -43, -56, -38, -60, -43, -57, -56, -57, -30, -45, -49, -60, -36, -60, -59, -49, -56, -76, -89, -71, -93, -76, -90, -89, -90, -63, -72, -85, -90, -89, -79, -29, -42, -47, -46, -36, -20, -39, -46, -50, -47, -42, -37, -44, -20, -35, -39, -50, -26, -50, -49, -39, -46, -71, -55, -58, -50, -54, -68, -55, Ascii.CR, Ascii.DC2, Ascii.VT, 19, Ascii.CAN, Ascii.SI, Ascii.SO, 9, 19, Ascii.CAN, Ascii.RS, 9, Ascii.VT, Ascii.SO, -17, -12, -19, -11, -6, -15, -16, -21, -2, 2, -21, -19, -16, -57, -36, -47, -60, -48, -52, -58, -62, -52, -47, -41, -56, -43, -42, -41, -52, -41, -52, -60, -49, -4, 17, 6, -7, 5, 1, -5, -9, 6, -7, Ascii.FF, 1, Ascii.SO, -3, -63, -42, -53, -66, -54, -58, -64, -68, -49, -62, -44, -66, -49, -63, -62, -63, -68, -45, -58, -63, -62, -52, Ascii.SUB, 41, 32, 32, 19, 39, Ascii.ETB, 38, Ascii.EM, Ascii.EM, 34, 19, 42, Ascii.GS, Ascii.CAN, Ascii.EM, 35, 58, 63, 69, 54, 67, 68, 69, 58, 69, 58, 50, Base64.padSymbol, 48, 63, 50, 69, 58, 71, 54, 48, 52, 50, 67, SignedBytes.MAX_POWER_OF_TWO, 70, 68, 54, Base64.padSymbol, -60, -55, -49, -64, -51, -50, -49, -60, -49, -60, -68, -57, -70, -55, -68, -49, -60, -47, -64, -70, -60, -56, -68, -62, -64, -28, -23, -17, -32, -19, -18, -17, -28, -17, -28, -36, -25, -38, -23, -36, -17, -28, -15, -32, -38, -21, -25, -36, -12, -36, -35, -25, -32, -33, -28, -22, -37, -24, -23, -22, -33, -22, -33, -41, -30, -43, -28, -41, -22, -33, -20, -37, -43, -20, -33, -38, -37, -27, Ascii.SUB, Ascii.US, 37, Ascii.SYN, 35, 36, 37, Ascii.SUB, 37, Ascii.SUB, Ascii.DC2, Ascii.GS, Ascii.DLE, 39, Ascii.SUB, Ascii.NAK, Ascii.SYN, 32, Ascii.DLE, Ascii.GS, Ascii.SYN, Ascii.DC2, Ascii.NAK, Ascii.SUB, Ascii.US, Ascii.CAN, Ascii.DLE, 33, Ascii.GS, Ascii.DC2, 42, Ascii.DC2, 19, Ascii.GS, Ascii.SYN, 58, 45, 53, 55, 60, 45, 39, 41, 43, 60, 49, 62, 49, 60, 65, 39, 52, 41, Base64.padSymbol, 54, 43, 48, 45, 58, -3, -16, 2, -20, -3, -17, -16, -17, -22, -18, -20, -3, -6, 0, -2, -16, -9, 39, Ascii.SUB, 44, Ascii.SYN, 39, Ascii.EM, Ascii.SUB, Ascii.EM, Ascii.DC4, 37, 33, Ascii.SYN, 46, Ascii.SYN, Ascii.ETB, 33, Ascii.SUB, 57, 44, 62, 40, 57, 43, 44, 43, 38, Base64.padSymbol, 48, 43, 44, 54, -14, -27, -32, -31, -21, -37, -24, -31, -35, -32, -27, -22, -29, -37, -20, -24, -35, -11, -35, -34, -24, -31};
    }

    static {
        A01();
    }

    WK(String str) {
        this.A00 = str;
    }

    public final String A03() {
        return this.A00;
    }
}
