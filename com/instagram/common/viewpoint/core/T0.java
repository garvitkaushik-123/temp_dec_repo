package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.common.PlaybackException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class T0 {
    public static int A00;
    public static int A01;
    public static int A02;
    public static int A03;
    public static int A04;
    public static int A05;
    public static int A06;
    public static int A07;
    public static byte[] A08;
    public static final String A09;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + PlaybackException.ERROR_CODE_PREMIUM_ACCOUNT_REQUIRED);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-47, -17, -15, -10, -13, -82, -14, -9, 1, -7, -82, -12, -17, -9, -6, 3, 0, -13, -68, -72, -42, -40, -35, -38, -107, -39, -34, -24, -32, -107, -24, -22, -40, -40, -38, -24, -24, -93, -7, Ascii.ETB, Ascii.EM, Ascii.RS, Ascii.ESC, -42, Ascii.SUB, 37, 45, 36, 34, 37, Ascii.ETB, Ascii.SUB, -42, Ascii.FS, Ascii.ETB, Ascii.US, 34, 43, 40, Ascii.ESC, -28, -80, -50, -48, -43, -46, -115, -43, -42, -31, -101, -63, -33, -31, -26, -29, -98, -21, -25, -15, -15, -84, 19, Ascii.SYN, 17, Ascii.NAK, 36, Ascii.ETB, 19, 38, Ascii.ESC, 40, Ascii.ETB, 17, 37, Ascii.ESC, 44, Ascii.ETB, 17, Ascii.DC4, 43, 38, Ascii.ETB, 37, -33, -30, -35, -31, -16, -29, -33, -14, -25, -12, -29, -35, -14, -9, -18, -29, Ascii.GS, 32, Ascii.ESC, 34, 43, 46, 41, Ascii.GS, 48, Ascii.ESC, 48, 53, 44, 33, -10, -7, -12, 7, -6, 6, 10, -6, 8, 9, -12, -2, -7, 67, 86, 86, 71, 79, 82, 86, Ascii.RS, Ascii.FS, Ascii.RS, 35, 32, 63, Base64.padSymbol, 63, 68, 65, 59, 63, 75, 74, 80, 65, 84, 80, -35, -40, -32, -29, -20, -23, -36, -42, -23, -36, -40, -22, -26, -27, Ascii.ETB, Ascii.ESC, Ascii.SI, Ascii.NAK, 19, Ascii.FS, Ascii.US, 17, Ascii.DC4, Ascii.SI, 36, Ascii.EM, Ascii.GS, Ascii.NAK, 70, 67, Base64.padSymbol};
    }

    static {
        A01();
        A09 = T0.class.getSimpleName();
        A05 = AbstractC1341Td.A0o;
        A06 = AbstractC1341Td.A0s;
        A02 = AbstractC1341Td.A0l;
        A01 = AbstractC1341Td.A0k;
        A03 = AbstractC1341Td.A0m;
        A00 = AbstractC1341Td.A0i;
        A04 = AbstractC1341Td.A0n;
        A07 = AbstractC1341Td.A0t;
    }

    public static void A02(T8 t8, C1328Sq c1328Sq, int i, String str, long j) {
        if (!A06(t8)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 85), c1328Sq.A01);
            jSONObject.put(A00(134, 13, 46), c1328Sq.A02);
            if (j > 0) {
                jSONObject.put(A00(191, 9, 73), Y1.A07(System.currentTimeMillis() - j));
            }
            C1342Te c1342Te = new C1342Te(str);
            c1342Te.A07(jSONObject);
            c1342Te.A05(1);
            t8.A08().ABD(A00(154, 5, 84), i, c1342Te);
        } catch (Throwable deLogException) {
            t8.A08().A4I(deLogException);
        }
    }

    public static void A03(T8 t8, C1333Sv c1333Sv, String str, int i, String str2, Long l, Long l2) {
        if (A06(t8)) {
            A05(t8, c1333Sv.A06, c1333Sv.A07, c1333Sv.A08, A00(186, 5, 71), str, i, str2, l, l2, null);
        }
    }

    public static void A04(T8 t8, C1337Sz c1337Sz, boolean z) {
        if (!A06(t8)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 85), c1337Sz.A01);
            jSONObject.put(A00(134, 13, 46), c1337Sz.A03);
            jSONObject.put(A00(104, 16, 23), c1337Sz.A02);
            jSONObject.put(A00(159, 13, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), c1337Sz.A00);
            if (C1379Up.A2T(t8)) {
                jSONObject.put(A00(200, 3, 106), c1337Sz.A04);
            }
            String A002 = z ? A00(61, 10, 6) : A00(71, 11, 23);
            int i = z ? A05 : A06;
            C1342Te c1342Te = new C1342Te(A002);
            c1342Te.A07(jSONObject);
            c1342Te.A05(1);
            t8.A08().ABD(A00(154, 5, 84), i, c1342Te);
        } catch (Throwable th) {
            t8.A08().A4I(th);
        }
    }

    public static void A05(T8 t8, String str, String str2, String str3, String str4, String str5, int i, String str6, Long l, Long l2, Integer num) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(A00(120, 14, 85), str);
            jSONObject.put(A00(134, 13, 46), str2);
            jSONObject.put(A00(104, 16, 23), str4);
            if (str6 != null) {
                jSONObject.put(A00(172, 14, 16), str6);
            }
            if (l != null) {
                jSONObject.put(A00(82, 22, 75), String.valueOf(l));
            }
            if (l2 != null) {
                jSONObject.put(A00(191, 9, 73), String.valueOf(l2));
            }
            if (num != null) {
                jSONObject.put(A00(147, 7, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE), String.valueOf(num));
            }
            jSONObject.put(A00(159, 13, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), str5);
            if (C1379Up.A2T(t8)) {
                jSONObject.put(A00(200, 3, 106), str3);
            }
            String A002 = A00(19, 19, 14);
            if (i == A03) {
                A002 = A00(38, 23, 79);
            } else if (i == A01) {
                A002 = A00(0, 19, 39);
            }
            C1342Te c1342Te = new C1342Te(A002);
            c1342Te.A07(jSONObject);
            c1342Te.A05(1);
            t8.A08().ABD(A00(154, 5, 84), i, c1342Te);
        } catch (Throwable th) {
            t8.A08().A4I(th);
        }
    }

    public static boolean A06(T8 t8) {
        int A062;
        if (t8.A05().AAO()) {
            A062 = 1;
        } else {
            A062 = AbstractC1381Ur.A06(t8);
        }
        if (A062 == 0) {
            return false;
        }
        return A062 <= 0 || t8.A09().A00() <= 1.0d / ((double) A062);
    }
}
