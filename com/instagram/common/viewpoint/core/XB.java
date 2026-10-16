package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.io.encoding.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class XB {
    public static byte[] A00;
    public static String[] A01 = {"h7TbtU4Y3aavuK2RNDrR490o97xA3UQR", "nWlFT6gMh83RN55hOK2s7jkd0", "m7AJmaDY7", "gyeYb9LWXFqsSrKIVSRt0Co29LGYuhaR", "EW8hQNBuni4zfziLp651zBZrhIaSPPe", "twQOenmklhEl", "GklYvNYuNnGVP8xhiRThcatIgfshVE", "s31M0lMjYrtgq4OJcDKBiGgiocxpngd"};

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A00 = new byte[]{Ascii.FF, Byte.MAX_VALUE, 69, 9, 94, 101, 9, 126, 121, Byte.MAX_VALUE, 69, 9, 94, 101, 9, 126, Ascii.DC4, 9, Ascii.GS, Ascii.SI, 10, 9, 121, Ascii.SO, Ascii.CR, Ascii.ESC, 112, 65, 82, 83, 73, 78, 71, 0, 85, 82, 76, 0, 5, 83, 0, 67, 65, 85, 83, 69, 68, 0, 69, 88, 67, 69, 80, 84, 73, 79, 78, Ascii.SUB, 0, 5, 83, Ascii.SO, 55, 72, 67, 84, 67, 2, 87, 80, 75, 2, 0, 7, 81, 0, 2, 76, 77, 86, 2, 71, 83, 87, 67, 78, 2, 86, 77, 2, 67, 76, 70, 80, 77, 75, 70, 2, 87, 80, 75, 2, 0, 7, 81, 0, Ascii.FF, 2, 102, 71, SignedBytes.MAX_POWER_OF_TWO, 87, 69, 2, 75, 76, 68, 77, Ascii.CAN, 2, 7, 81, Ascii.FF, 2, 109, 80, 75, 69, 75, 76, 67, 78, 2, 87, 80, 75, Ascii.CAN, 2, 7, 81, 116, Byte.MAX_VALUE, 104, Byte.MAX_VALUE, 75, 108, 119, 62, Byte.MAX_VALUE, 107, 106, 118, 113, 108, 119, 106, 103, 36, 62, 60, 59, 109, 60, 48, 62, Byte.MAX_VALUE, 112, 122, 108, 113, 119, 122, 75, 108, 119, 62, Byte.MAX_VALUE, 107, 106, 118, 113, 108, 119, 106, 103, 36, 62, 60, 59, 109, 60, 48, 51, 56, 47, 56, Ascii.FF, 43, 48, 121, 54, 41, 56, 40, 44, 60, 121, 41, 56, 43, 45, 99, 121, 123, 124, 42, 123, 119, 121, 56, 55, Base64.padSymbol, 43, 54, 48, Base64.padSymbol, Ascii.FF, 43, 48, 121, 54, 41, 56, 40, 44, 60, 121, 41, 56, 43, 45, 99, 121, 123, 124, 42, 123, 119, 35, 40, 63, 40, Ascii.FS, 59, 32, 105, 57, 40, Base64.padSymbol, 33, 115, 105, 107, 108, 58, 107, 103, 105, 40, 39, 45, 59, 38, 32, 45, Ascii.FS, 59, 32, 105, 57, 40, Base64.padSymbol, 33, 115, 105, 107, 108, 58, 107, 103, 5, Ascii.SO, Ascii.EM, Ascii.SO, 58, Ascii.GS, 6, 79, Ascii.FS, Ascii.FF, 7, 10, 2, 10, 85, 79, 77, 74, Ascii.FS, 77, 65, 79, Ascii.SO, 1, Ascii.VT, Ascii.GS, 0, 6, Ascii.VT, 58, Ascii.GS, 6, 79, Ascii.FS, Ascii.FF, 7, 10, 2, 10, 85, 79, 77, 74, Ascii.FS, 77, 65};
    }

    static {
        A09();
    }

    public static Uri A00(String str) {
        Uri parse = Uri.parse(str);
        C1925ge A002 = T7.A00();
        if (A002 != null && !C1379Up.A2x(A002)) {
            return parse;
        }
        if (!A0D(parse)) {
            Uri androidUri = A01(str);
            return androidUri;
        }
        A0A(str, parse);
        return parse;
    }

    public static Uri A01(String str) {
        try {
            URI uri = new URI(str);
            if (uri.isOpaque()) {
                Uri androidUri = A03(uri);
                A0B(str, uri, androidUri);
                return androidUri;
            }
            Uri androidUri2 = A02(uri);
            A0C(str, uri, androidUri2, false);
            return androidUri2;
        } catch (URISyntaxException e) {
            throw A04(str, e);
        }
    }

    public static Uri A02(URI uri) {
        return new Uri.Builder().scheme(uri.getScheme()).encodedAuthority(uri.getRawAuthority()).encodedPath(uri.getRawPath()).encodedQuery(uri.getRawQuery()).encodedFragment(uri.getRawFragment()).build();
    }

    public static Uri A03(URI uri) {
        return new Uri.Builder().scheme(uri.getScheme()).encodedOpaquePart(uri.getRawSchemeSpecificPart()).encodedFragment(uri.getRawFragment()).build();
    }

    public static SecurityException A04(String str, URISyntaxException uRISyntaxException) {
        return new SecurityException(String.format(Locale.US, A05(26, 36, 89), str, uRISyntaxException.getMessage()));
    }

    public static URI A06(Uri uri) {
        try {
            URI javaUri = new URI(uri.toString());
            if (A0F(javaUri, uri)) {
                return javaUri;
            }
            return null;
        } catch (URISyntaxException unused) {
            return null;
        }
    }

    public static URI A07(String str, Uri uri) {
        try {
            return new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), uri.getPath(), uri.getQuery(), uri.getFragment());
        } catch (URISyntaxException e) {
            URI A06 = A06(uri);
            if (A06 != null) {
                return A06;
            }
            throw A04(str, e);
        }
    }

    public static URI A08(String str, Uri uri) {
        try {
            return new URI(uri.getScheme(), uri.getSchemeSpecificPart(), uri.getFragment());
        } catch (URISyntaxException e) {
            throw A04(str, e);
        }
    }

    public static void A0A(String str, Uri uri) throws SecurityException {
        if (uri.isOpaque()) {
            URI A08 = A08(str, uri);
            if (A01[6].length() != 30) {
                throw new RuntimeException();
            }
            A01[2] = "XZATJK5ui";
            A0B(str, A08, uri);
            return;
        }
        URI A07 = A07(str, uri);
        A0C(str, A07, uri, A0F(A07, uri));
    }

    public static void A0B(String str, URI uri, Uri uri2) {
        boolean A0E = A0E(uri.getScheme(), uri2.getScheme());
        boolean A0E2 = A0E(uri.getSchemeSpecificPart(), uri2.getSchemeSpecificPart());
        if (A0E && A0E2) {
            return;
        }
        String A05 = A05(0, 0, 3);
        if (!A0E) {
            A05 = A05 + String.format(Locale.US, A05(290, 46, 22), uri.getScheme(), uri2.getScheme());
        }
        if (!A0E2) {
            A05 = A05 + String.format(Locale.US, A05(192, 56, 32), uri.getSchemeSpecificPart(), uri2.getSchemeSpecificPart());
        }
        Locale locale = Locale.US;
        String debugInfo = uri.toString();
        throw new SecurityException(String.format(locale, A05(63, 77, 91), debugInfo, uri2.toString(), A05, str));
    }

    public static void A0C(String str, URI uri, Uri uri2, boolean z) {
        boolean A0E = A0E(uri.getScheme(), uri2.getScheme());
        boolean A0E2 = A0E(uri.getAuthority(), uri2.getAuthority());
        boolean A0E3 = A0E(uri.getPath(), uri2.getPath());
        String A05 = A05(0, 0, 3);
        if (!A0E) {
            A05 = A05 + String.format(Locale.US, A05(290, 46, 22), uri.getScheme(), uri2.getScheme());
        }
        if (!z && !A0E2) {
            A05 = A05 + String.format(Locale.US, A05(140, 52, 103), uri.getAuthority(), uri2.getAuthority());
        }
        if (!A0E3) {
            A05 = A05 + String.format(Locale.US, A05(248, 42, 48), uri.getPath(), uri2.getPath());
        }
        if (A0E && A0E2 && A0E3) {
        } else {
            throw new SecurityException(String.format(Locale.US, A05(63, 77, 91), uri.toString(), uri2.toString(), A05, str));
        }
    }

    public static boolean A0D(Uri uri) {
        if (uri.getScheme() == null) {
            return true;
        }
        return uri.getScheme().matches(A05(0, 26, 93));
    }

    public static boolean A0E(String str, String str2) {
        String A05 = A05(0, 0, 3);
        if (str == null || str.equals(A05)) {
            return str2 == null || str2.equals(A05);
        }
        return str.equals(str2);
    }

    public static boolean A0F(URI uri, Uri uri2) {
        String host = uri2.getHost();
        String androidHost = uri.getHost();
        if (androidHost == null && host != null) {
            String androidHost2 = A05(62, 1, 17);
            if (host.contains(androidHost2)) {
                return true;
            }
        }
        return false;
    }
}
