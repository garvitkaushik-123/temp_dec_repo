package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class WI {
    public static byte[] A00;
    public static final AtomicReference<String> A01;
    public static final AtomicReference<String> A02;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{Ascii.US, 34, 59, 52, 62, 52, 56, 62, 52, 57, Base64.padSymbol, 52, 52, 58, 52, Base64.padSymbol, 60, 34, 111, 120, 106, 126, Ascii.VT, 69, SignedBytes.MAX_POWER_OF_TWO, 74, 83, 123, 72, 75, 67, 67, 77, 74, 67, Ascii.VT, 114, 60, 57, 51, 42, 2, 46, 36, 51, 62, 111, 44, 109, 102, 119, 116, 108, 113, 104, 92, 98, 103, 112, 92, 96, 108, 110, 110, 108, 109, 37, 57, 57, Base64.padSymbol, 62, 119, 98, 98, 42, 63, 44, Base64.padSymbol, 37, 104, 62, 99, 43, 44, 46, 40, 47, 34, 34, 38, 99, 46, 34, 32, 81, 77, 77, 73, 74, 3, Ascii.SYN, Ascii.SYN, 78, 78, 78, Ascii.FS, 74, Ascii.ETB, 95, 88, 90, 92, 91, 86, 86, 82, Ascii.ETB, 90, 86, 84, Ascii.SO, Ascii.SO, Ascii.SO};
    }

    static {
        A09();
        A01 = new AtomicReference<>();
        A02 = new AtomicReference<>();
    }

    public static String A01(T8 t8) {
        return A05(t8) + A00(47, 19, 53);
    }

    public static String A02(T8 t8) {
        String loggingEndpointPrefix = C1379Up.A0X(t8);
        StringBuilder append = new StringBuilder().append(A07(t8, loggingEndpointPrefix));
        String loggingEndpointPrefix2 = A00(22, 14, 18);
        return append.append(loggingEndpointPrefix2).toString();
    }

    public static String A03(T8 t8) {
        return A05(t8) + A00(1, 21, 59);
    }

    public static String A04(T8 t8) {
        String syncEndpointPrefix = C1379Up.A0Y(t8);
        StringBuilder append = new StringBuilder().append(A07(t8, syncEndpointPrefix));
        String syncEndpointPrefix2 = A00(36, 11, 107);
        return append.append(syncEndpointPrefix2).toString();
    }

    public static String A05(T8 t8) {
        String str = A01.get();
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String urlOverride = A00(66, 28, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
        return A06(t8, urlOverride);
    }

    public static String A06(T8 t8, String str) {
        String sb;
        String A9Q = t8.A05().A9Q();
        Locale locale = Locale.US;
        if (TextUtils.isEmpty(A9Q)) {
            sb = A00(0, 0, 61);
        } else {
            StringBuilder sb2 = new StringBuilder();
            String prefix = A00(0, 1, 7);
            sb = sb2.append(prefix).append(A9Q).toString();
        }
        String prefix2 = String.format(locale, str, sb);
        return prefix2;
    }

    public static String A07(T8 t8, String str) {
        String str2 = A02.get();
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String urlOverride = A00(94, 26, 15);
        return A08(A06(t8, urlOverride), str);
    }

    public static String A08(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str.replace(A00(120, 3, 79), str2);
    }
}
