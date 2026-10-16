package com.instagram.common.viewpoint.core;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* renamed from: com.facebook.ads.redexgen.X.Kn, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1123Kn {
    public static byte[] A00;
    public static String[] A01 = {"6VJGxYRVGzkOFylAWqo", "TQDRStRjVTcp84EAqriMHD1W", "Y0YMWliml1c9R0RakThzWHnpZrTCSrBu", "hjS3TiOTsIfHHkhXtOFrFHFAaycKEbQY", "GvjOo5wC83Psjizly91M8Dr7lGNbFkes", "VFbjP0ZwmY6IK0pKGb7V8NSJj5u1SgyV", "T0F9FjreghpLds1JHOV1Zh8xCqpA0ysb", "F9ZBXP7xE9Rr53rKOaE"};
    public static final Pattern A02;
    public static final Map<String, Integer> A03;
    public static final Map<String, Integer> A04;
    public static final Pattern A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A06(List<C1111Kb> list, String str, C1119Kj c1119Kj) {
        List<C1120Kk> A0E = A0E(list, str, c1119Kj);
        for (int i = 0; i < A0E.size(); i++) {
            C1111Kb c1111Kb = A0E.get(i).A01;
            if (c1111Kb.A07() != -1) {
                return c1111Kb.A07();
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        if (r10 != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r0 = r4 - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0094, code lost:
    
        r0 = r4 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0091, code lost:
    
        if (r10 != false) goto L25;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SpannedString A07(String str, String str2, List<C1111Kb> list) {
        int i;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int length = str2.length();
            if (A01[3].charAt(21) == 'Z') {
                throw new RuntimeException();
            }
            A01[5] = "AeTA9zfG0TGme9BEKFHCyzeTODloAdj0";
            if (i2 >= length) {
                while (!arrayDeque.isEmpty()) {
                    A0K(str, (C1119Kj) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                A0K(str, C1119Kj.A00(), Collections.emptyList(), spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char charAt = str2.charAt(i2);
            switch (charAt) {
                case '&':
                    int indexOf = str2.indexOf(59, i2 + 1);
                    int indexOf2 = str2.indexOf(32, i2 + 1);
                    if (indexOf == -1) {
                        indexOf = indexOf2;
                    } else if (indexOf2 != -1) {
                        indexOf = Math.min(indexOf, indexOf2);
                    }
                    if (indexOf == -1) {
                        spannableStringBuilder.append(charAt);
                        i2++;
                        break;
                    } else {
                        A0J(str2.substring(i2 + 1, indexOf), spannableStringBuilder);
                        if (indexOf == indexOf2) {
                            spannableStringBuilder.append((CharSequence) A0C(1, 1, 38));
                        }
                        i2 = indexOf + 1;
                        break;
                    }
                case '<':
                    if (i2 + 1 < str2.length()) {
                        int i3 = i2;
                        boolean z = str2.charAt(i3 + 1) == '/';
                        i2 = A05(str2, i3 + 1);
                        boolean z2 = str2.charAt(i2 + (-2)) == '/';
                        int i4 = (z ? 2 : 1) + i3;
                        if (A01[1].length() != 9) {
                            String[] strArr = A01;
                            strArr[2] = "RmddLkS1dXQ96i0rYlSMmYhsPXo1tsUj";
                            strArr[6] = "bXvTM6kBQx9RsuQ7PFPuWtENxJrNvh3v";
                            break;
                        }
                        String substring = str2.substring(i4, i);
                        if (!substring.trim().isEmpty()) {
                            String A0D = A0D(substring);
                            if (!A0O(A0D)) {
                                break;
                            } else if (!z) {
                                if (!z2) {
                                    int length2 = spannableStringBuilder.length();
                                    if (A01[4].charAt(3) == 'a') {
                                        arrayDeque.push(C1119Kj.A01(substring, length2));
                                        break;
                                    } else {
                                        String[] strArr2 = A01;
                                        strArr2[0] = "wdDtpexUk8e3MYkSHhs";
                                        strArr2[7] = "WrocTxwzP1SCyFuF7cP";
                                        arrayDeque.push(C1119Kj.A01(substring, length2));
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                while (!arrayDeque.isEmpty()) {
                                    C1119Kj c1119Kj = (C1119Kj) arrayDeque.pop();
                                    A0K(str, c1119Kj, arrayList, spannableStringBuilder, list);
                                    if (!arrayDeque.isEmpty()) {
                                        arrayList.add(new C1118Ki(c1119Kj, spannableStringBuilder.length()));
                                    } else if (A01[1].length() != 9) {
                                        A01[3] = "6LBQPk5FkDk3NWAQRRtmrnBQ3lB0BSgu";
                                        arrayList.clear();
                                    } else {
                                        arrayList.clear();
                                    }
                                    if (c1119Kj.A01.equals(A0D)) {
                                        break;
                                    }
                                }
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        i2++;
                        break;
                    }
                default:
                    spannableStringBuilder.append(charAt);
                    i2++;
                    break;
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C1115Kf A0A(C07364v c07364v, List<C1111Kb> list) {
        String A0T = c07364v.A0T();
        if (A0T == null) {
            return null;
        }
        Matcher matcher = A02.matcher(A0T);
        if (matcher.matches()) {
            return A0B(null, matcher, c07364v, list);
        }
        String A0T2 = c07364v.A0T();
        if (A0T2 == null) {
            return null;
        }
        Matcher matcher2 = A02.matcher(A0T2);
        if (matcher2.matches()) {
            return A0B(A0T.trim(), matcher2, c07364v, list);
        }
        return null;
    }

    public static String A0C(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(copyOfRange);
    }

    public static void A0F() {
        A00 = new byte[]{81, 0, 85, 68, 48, 63, 71, 83, 69, 86, 68, 48, 63, 71, 69, 0, 106, 118, 51, Ascii.DC4, Ascii.FF, Ascii.ESC, Ascii.SYN, 19, Ascii.RS, 90, 93, Ascii.FF, Ascii.US, 8, Ascii.SO, 19, Ascii.EM, Ascii.ESC, Ascii.SYN, 93, 90, Ascii.FF, Ascii.ESC, Ascii.SYN, Ascii.SI, Ascii.US, SignedBytes.MAX_POWER_OF_TWO, 90, 63, Ascii.CAN, 0, Ascii.ETB, Ascii.SUB, Ascii.US, Ascii.DC2, 86, Ascii.ETB, Ascii.SUB, Ascii.US, 17, Ascii.CAN, Ascii.ESC, 19, Ascii.CAN, 2, 86, 0, Ascii.ETB, Ascii.SUB, 3, 19, 76, 86, 82, 117, 109, 122, 119, 114, Byte.MAX_VALUE, 59, 122, 117, 120, 115, 116, 105, 59, 109, 122, 119, 110, 126, 33, 59, 46, Ascii.SYN, Ascii.DC4, Ascii.CR, Ascii.CR, Ascii.DC4, 19, Ascii.SUB, 93, Ascii.US, Ascii.FS, Ascii.EM, 93, Ascii.RS, 8, Ascii.CAN, 93, Ascii.SO, Ascii.CAN, 9, 9, Ascii.DC4, 19, Ascii.SUB, 71, 93, 63, 7, 5, Ascii.FS, Ascii.FS, 5, 2, Ascii.VT, 76, Ascii.SI, Ascii.EM, 9, 76, Ascii.ESC, 5, Ascii.CAN, 4, 76, Ascii.SO, Ascii.CR, 8, 76, 4, 9, Ascii.CR, 8, 9, Ascii.RS, 86, 76, 53, Ascii.SO, Ascii.VT, Ascii.SO, Ascii.SI, Ascii.ETB, Ascii.SO, SignedBytes.MAX_POWER_OF_TWO, 3, Ascii.NAK, 5, SignedBytes.MAX_POWER_OF_TWO, 19, 5, Ascii.DC4, Ascii.DC4, 9, Ascii.SO, 7, SignedBytes.MAX_POWER_OF_TWO, 10, 56, 63, 43, 41, 41, Ascii.RS, 40, 56, Ascii.CR, 60, 47, 46, 56, 47, 40, 83, 47, 93, 46, 123, Ascii.CR, 121, 118, Ascii.SO, Ascii.FF, 121, 86, Ascii.SO, 8, 8, Ascii.ESC, 121, 86, Ascii.SO, Ascii.CR, 121, 118, Ascii.SO, Ascii.FF, Ascii.CR, Ascii.VT, Ascii.SI, Ascii.FF, Ascii.SUB, 1, 81, 92, 89, 87, 94, 10, 6, Ascii.ESC, 45, 93, 88, 96, 93, 83, 94, 92, 84, 4, 1, 57, 4, 10, 19, 3, 119, 114, 74, 118, 108, 116, 123, 118, 115, 75, 120, 125, 121, 113, 7, 2, 58, 8, 4, 2, 0, Ascii.VT, 17, 4, 39, 34, Ascii.SUB, 55, 32, 33, SignedBytes.MAX_POWER_OF_TWO, 69, 125, 85, 74, 75, 86, 71, 91, 94, 102, SignedBytes.MAX_POWER_OF_TWO, 92, 85, 85, 86, 78, 6, 8, 5, 7, Ascii.SI, Ascii.SI, 1, Ascii.CAN, 8, 7, 101, 99, 104, 114, 99, 116, 7, Ascii.GS, 5, 10, 117, 126, 116, 65, 82, 0, 3, Ascii.CR, 4, 5, Ascii.CAN, 3, 4, Ascii.CR, 74, Ascii.US, 4, Ascii.EM, Ascii.US, Ascii.SUB, Ascii.SUB, 5, Ascii.CAN, Ascii.RS, Ascii.SI, Ascii.SO, 74, Ascii.SI, 4, Ascii.RS, 3, Ascii.RS, 19, 80, 74, 77, 76, 90, 87, 88, 81, 69, 76, 79, 93, 107, 110, 106, 98, 65, 68, 67, 72, 35, 38, 33, 42, 98, 35, 42, 41, 59, 113, 116, 115, 120, 48, 111, 116, 122, 117, 105, 106, 116, 113, 105, 79, 67, 69, 71, 76, 86, 67, 5, 1, Ascii.FF, Ascii.FF, 4, Ascii.CR, 53, 57, 40, 43, Ascii.GS, 2, Ascii.RS, 4, Ascii.EM, 4, 2, 3, 73, 94, 95, 84, 79, 65, 78, 82, 37, 59, 69, 67, 7, 0, Ascii.ETB, Ascii.FF, 86, 76, 95, SignedBytes.MAX_POWER_OF_TWO, 0, 7, Ascii.DC2, 1, 7, 110, 124, 44, 63, 40, 46, 51, 57, 59, 54, 68, 91, 90, 71, 86, 52, 40, 33, 33, 34, 58};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0H(SpannableStringBuilder spannableStringBuilder, String str, C1119Kj c1119Kj, List<C1118Ki> list, List<C1111Kb> list2) {
        C1119Kj c1119Kj2;
        C1119Kj c1119Kj3;
        C1119Kj c1119Kj4;
        int i;
        int A06 = A06(list2, str, c1119Kj);
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        Collections.sort(arrayList, C1118Ki.A03());
        int i2 = 0;
        int i3 = c1119Kj.A00;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            c1119Kj2 = ((C1118Ki) arrayList.get(i4)).A01;
            if (A0C(TTAdConstant.VIDEO_COVER_URL_CODE, 2, 49).equals(c1119Kj2.A01)) {
                C1118Ki c1118Ki = (C1118Ki) arrayList.get(i4);
                c1119Kj3 = c1118Ki.A01;
                int A002 = A00(A06(list2, str, c1119Kj3), A06, 1);
                c1119Kj4 = c1118Ki.A01;
                int i5 = c1119Kj4.A00 - i2;
                i = c1118Ki.A00;
                int i6 = i - i2;
                CharSequence subSequence = spannableStringBuilder.subSequence(i5, i6);
                spannableStringBuilder.delete(i5, i6);
                spannableStringBuilder.setSpan(new C2435pP(subSequence.toString(), A002), i3, i5, 33);
                i2 += subSequence.length();
                i3 = i5;
            }
        }
    }

    static {
        A0F();
        A02 = Pattern.compile(A0C(187, 26, 35));
        A05 = Pattern.compile(A0C(3, 12, 106));
        HashMap hashMap = new HashMap();
        hashMap.put(A0C(440, 5, 53), Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap.put(A0C(349, 4, 1), Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap.put(A0C(300, 4, 98), Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap.put(A0C(405, 3, 61), Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap.put(A0C(445, 6, 75), Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap.put(A0C(380, 7, 36), Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap.put(A0C(289, 4, 107), Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap.put(A0C(284, 5, 98), Integer.valueOf(Color.rgb(0, 0, 0)));
        Map<String, Integer> defaultColors = Collections.unmodifiableMap(hashMap);
        A04 = defaultColors;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A0C(267, 8, 36), Integer.valueOf(Color.rgb(255, 255, 255)));
        hashMap2.put(A0C(244, 7, 18), Integer.valueOf(Color.rgb(0, 255, 0)));
        hashMap2.put(A0C(237, 7, 19), Integer.valueOf(Color.rgb(0, 255, 255)));
        hashMap2.put(A0C(261, 6, 67), Integer.valueOf(Color.rgb(255, 0, 0)));
        hashMap2.put(A0C(275, 9, 63), Integer.valueOf(Color.rgb(255, 255, 0)));
        hashMap2.put(A0C(251, 10, 99), Integer.valueOf(Color.rgb(255, 0, 255)));
        hashMap2.put(A0C(230, 7, 96), Integer.valueOf(Color.rgb(0, 0, 255)));
        hashMap2.put(A0C(Sdk.SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE, 8, 57), Integer.valueOf(Color.rgb(0, 0, 0)));
        Map<String, Integer> defaultBackgroundColors = Collections.unmodifiableMap(hashMap2);
        A03 = defaultBackgroundColors;
    }

    public static int A00(int i, int i2, int i3) {
        if (i != -1) {
            return i;
        }
        if (i2 != -1) {
            return i2;
        }
        if (i3 != -1) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0092 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A01(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(A0C(294, 6, 0))) {
                    c = 1;
                    switch (c) {
                        case 0:
                            return 0;
                        case 1:
                        case 2:
                            return 1;
                        case 3:
                            return 2;
                        default:
                            AbstractC07214g.A07(A0C(167, 15, 91), A0C(69, 22, 29) + str);
                            return Integer.MIN_VALUE;
                    }
                }
                c = 65535;
                switch (c) {
                }
            case -1074341483:
                if (A01[1].length() == 9) {
                    throw new RuntimeException();
                }
                A01[4] = "zDr3pXiReOD9C2voGl4pNyTssnTsthj2";
                if (str.equals(A0C(387, 6, 110))) {
                    c = 2;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 100571:
                if (str.equals(A0C(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, 3, 22))) {
                    c = 3;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 109757538:
                if (str.equals(A0C(425, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                    c = 0;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            default:
                c = 65535;
                switch (c) {
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A02(String str) {
        char c;
        switch (str.hashCode()) {
            case -1842484672:
                if (str.equals(A0C(357, 9, 73))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals(A0C(294, 6, 0))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1276788989:
                if (str.equals(A0C(366, 10, 27))) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals(A0C(387, 6, 110))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (str.equals(A0C(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, 3, 22))) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (str.equals(A0C(425, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return 0;
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            default:
                AbstractC07214g.A07(A0C(167, 15, 91), A0C(69, 22, 29) + str);
                return Integer.MIN_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A03(String str) {
        char c;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(A0C(294, 6, 0))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1074341483:
                if (str.equals(A0C(387, 6, 110))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 100571:
                if (str.equals(A0C(Sdk.SDKError.Reason.AD_EXPIRED_VALUE, 3, 22))) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3317767:
                if (str.equals(A0C(345, 4, 47))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals(A0C(408, 5, 32))) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 109757538:
                if (str.equals(A0C(425, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 4;
            case 2:
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            default:
                AbstractC07214g.A07(A0C(167, 15, 91), A0C(44, 25, 112) + str);
                return 2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A04(String str) {
        char c;
        switch (str.hashCode()) {
            case 3462:
                if (str.equals(A0C(376, 2, 0))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3642:
                if (str.equals(A0C(TTAdConstant.VIDEO_INFO_CODE, 2, 81))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                AbstractC07214g.A07(A0C(167, 15, 91), A0C(18, 26, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + str);
                return Integer.MIN_VALUE;
        }
    }

    public static int A05(String str, int i) {
        int indexOf = str.indexOf(62, i);
        if (indexOf == -1) {
            int index = str.length();
            return index;
        }
        int index2 = indexOf + 1;
        return index2;
    }

    public static C07033o A08(String str) {
        C1122Km builder = new C1122Km();
        A0L(str, builder);
        return builder.A07();
    }

    public static C2439pT A09(CharSequence charSequence) {
        C1122Km infoBuilder = new C1122Km();
        infoBuilder.A0A = charSequence;
        return infoBuilder.A07().A0H();
    }

    public static C1115Kf A0B(String str, Matcher matcher, C07364v c07364v, List<C1111Kb> list) {
        C1122Km c1122Km = new C1122Km();
        try {
            c1122Km.A09 = AbstractC1124Ko.A01((String) AbstractC07133y.A01(matcher.group(1)));
            c1122Km.A08 = AbstractC1124Ko.A01((String) AbstractC07133y.A01(matcher.group(2)));
            A0L((String) AbstractC07133y.A01(matcher.group(3)), c1122Km);
            StringBuilder sb = new StringBuilder();
            String A0T = c07364v.A0T();
            while (true) {
                boolean isEmpty = TextUtils.isEmpty(A0T);
                if (A01[5].charAt(2) == 'h') {
                    throw new RuntimeException();
                }
                A01[1] = "2AwiW2AhFaTR";
                if (!isEmpty) {
                    if (sb.length() > 0) {
                        sb.append(A0C(0, 1, 93));
                    }
                    sb.append(A0T.trim());
                    A0T = c07364v.A0T();
                } else {
                    c1122Km.A0A = A07(str, sb.toString(), list);
                    return c1122Km.A08();
                }
            }
        } catch (NumberFormatException unused) {
            AbstractC07214g.A07(A0C(167, 15, 91), A0C(Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, 30, 106) + matcher.group());
            return null;
        }
    }

    public static String A0D(String str) {
        String trim = str.trim();
        AbstractC07133y.A07(!trim.isEmpty());
        return C5C.A1P(trim, A0C(182, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE))[0];
    }

    public static List<C1120Kk> A0E(List<C1111Kb> list, String str, C1119Kj c1119Kj) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            C1111Kb c1111Kb = list.get(i);
            int i2 = c1111Kb.A09(str, c1119Kj.A01, c1119Kj.A03, c1119Kj.A02);
            if (i2 > 0) {
                arrayList.add(new C1120Kk(i2, c1111Kb));
            }
        }
        Collections.sort(arrayList);
        if (A01[3].charAt(21) == 'Z') {
            throw new RuntimeException();
        }
        A01[3] = "10DtqaDx3Mjis7pngfRsmCfeCaw0vB2Q";
        return arrayList;
    }

    public static void A0G(SpannableStringBuilder spannableStringBuilder, C1111Kb c1111Kb, int i, int i2) {
        if (c1111Kb == null) {
            return;
        }
        if (c1111Kb.A08() != -1) {
            AbstractC07083t.A00(spannableStringBuilder, new StyleSpan(c1111Kb.A08()), i, i2, 33);
        }
        if (c1111Kb.A0S()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        boolean A0T = c1111Kb.A0T();
        if (A01[3].charAt(21) != 'Z') {
            A01[3] = "1YLI45HvZzSZe2yut9V0MUcCwjpGC5gE";
            if (A0T) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
            }
            if (c1111Kb.A0R()) {
                AbstractC07083t.A00(spannableStringBuilder, new ForegroundColorSpan(c1111Kb.A05()), i, i2, 33);
            }
            if (c1111Kb.A0Q()) {
                AbstractC07083t.A00(spannableStringBuilder, new BackgroundColorSpan(c1111Kb.A04()), i, i2, 33);
            }
            if (c1111Kb.A0K() != null) {
                AbstractC07083t.A00(spannableStringBuilder, new TypefaceSpan(c1111Kb.A0K()), i, i2, 33);
            }
            switch (c1111Kb.A06()) {
                case 1:
                    AbstractC07083t.A00(spannableStringBuilder, new AbsoluteSizeSpan((int) c1111Kb.A03(), true), i, i2, 33);
                    break;
                case 2:
                    AbstractC07083t.A00(spannableStringBuilder, new RelativeSizeSpan(c1111Kb.A03()), i, i2, 33);
                    break;
                case 3:
                    AbstractC07083t.A00(spannableStringBuilder, new RelativeSizeSpan(c1111Kb.A03() / 100.0f), i, i2, 33);
                    break;
            }
            if (c1111Kb.A0P()) {
                spannableStringBuilder.setSpan(new C2436pQ(), i, i2, 33);
                return;
            }
            return;
        }
        throw new RuntimeException();
    }

    public static void A0I(SpannableStringBuilder spannableStringBuilder, Set<String> set, int i, int i2) {
        for (String str : set) {
            boolean containsKey = A04.containsKey(str);
            if (A01[1].length() == 9) {
                throw new RuntimeException();
            }
            A01[5] = "YNIn8hUAyZDjSH3JhERqEXsouXgj93JS";
            if (containsKey) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(A04.get(str).intValue()), i, i2, 33);
            } else {
                Map<String, Integer> map = A03;
                String className = A01[3];
                if (className.charAt(21) != 'Z') {
                    A01[3] = "z1JdxX10iLj514Di1TKQv9nGlpU0X7eV";
                    if (map.containsKey(str)) {
                        spannableStringBuilder.setSpan(new BackgroundColorSpan(A03.get(str).intValue()), i, i2, 33);
                    }
                } else if (map.containsKey(str)) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(A03.get(str).intValue()), i, i2, 33);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0J(String str, SpannableStringBuilder spannableStringBuilder) {
        char c;
        switch (str.hashCode()) {
            case 3309:
                boolean equals = str.equals(A0C(307, 2, 32));
                String[] strArr = A01;
                if (strArr[0].length() == strArr[7].length()) {
                    A01[1] = "Z6Yq6aysKH1bmBhKZFPJxCKyS02If";
                    if (equals) {
                        c = 1;
                        switch (c) {
                            case 0:
                                spannableStringBuilder.append(Typography.less);
                                return;
                            case 1:
                                spannableStringBuilder.append(Typography.greater);
                                return;
                            case 2:
                                spannableStringBuilder.append(' ');
                                return;
                            case 3:
                                spannableStringBuilder.append(Typography.amp);
                                return;
                            default:
                                AbstractC07214g.A07(A0C(167, 15, 91), A0C(Sdk.SDKError.Reason.AD_HTML_FAILED_TO_LOAD_VALUE, 31, 108) + str + A0C(16, 2, 87));
                                return;
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                }
                throw new RuntimeException();
            case 3464:
                if (str.equals(A0C(378, 2, 27))) {
                    c = 0;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            case 96708:
                boolean equals2 = str.equals(A0C(Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 3, 109));
                if (A01[5].charAt(2) != 'h') {
                    String[] strArr2 = A01;
                    strArr2[2] = "0e7ADHSVMy4QvuNOaRsoWPMCToECBQOy";
                    strArr2[6] = "0jhJvpoe9graGazv1ZIcpM6WWqxYTLD3";
                    if (equals2) {
                        c = 3;
                        switch (c) {
                        }
                    }
                    c = 65535;
                    switch (c) {
                    }
                }
                throw new RuntimeException();
            case 3374865:
                if (str.equals(A0C(393, 4, 93))) {
                    c = 2;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            default:
                c = 65535;
                switch (c) {
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Incorrect condition in loop: B:15:0x00ee */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f0 A[LOOP:0: B:14:0x00ea->B:16:0x00f0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0017 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void A0K(String str, C1119Kj c1119Kj, List<C1118Ki> list, SpannableStringBuilder spannableStringBuilder, List<C1111Kb> list2) {
        int start;
        List<C1120Kk> A0E;
        int end;
        int start2;
        int i = c1119Kj.A00;
        int i2 = spannableStringBuilder.length();
        String str2 = c1119Kj.A01;
        int start3 = str2.hashCode();
        switch (start3) {
            case 0:
                if (str2.equals(A0C(0, 0, 43))) {
                    start = 7;
                    switch (start) {
                        case 0:
                            spannableStringBuilder.setSpan(new StyleSpan(1), i, i2, 33);
                            break;
                        case 1:
                            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
                            break;
                        case 2:
                            A0H(spannableStringBuilder, str, c1119Kj, list, list2);
                            break;
                        case 3:
                            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
                            break;
                        case 4:
                            A0I(spannableStringBuilder, c1119Kj.A03, i, i2);
                            break;
                        case 5:
                        case 6:
                        case 7:
                            break;
                        default:
                            return;
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    for (end = 0; end < start2; end++) {
                        A0G(spannableStringBuilder, A0E.get(end).A01, i, i2);
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case 98:
                if (str2.equals(A0C(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 1, 73))) {
                    start = 0;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case 99:
                if (str2.equals(A0C(293, 1, 98))) {
                    start = 4;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case 105:
                if (str2.equals(A0C(Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE, 1, 111))) {
                    start = 1;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case ASSET_FAILED_STATUS_CODE_VALUE:
                if (str2.equals(A0C(430, 1, 29))) {
                    start = 3;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                if (str2.equals(A0C(431, 1, 12))) {
                    start = 6;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case 3314158:
                if (str2.equals(A0C(341, 4, 48))) {
                    start = 5;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            case 3511770:
                boolean equals = str2.equals(A0C(TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 4, 115));
                String[] strArr = A01;
                String str3 = strArr[0];
                String str4 = strArr[7];
                int end2 = str3.length();
                int start4 = str4.length();
                if (end2 != start4) {
                    throw new RuntimeException();
                }
                A01[3] = "p1tLKUYj0fLqnT8dJpZfHw2ryYMkTMQB";
                if (equals) {
                    start = 2;
                    switch (start) {
                    }
                    A0E = A0E(list2, str, c1119Kj);
                    while (end < start2) {
                    }
                    return;
                }
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
            default:
                start = -1;
                switch (start) {
                }
                A0E = A0E(list2, str, c1119Kj);
                while (end < start2) {
                }
                return;
        }
    }

    public static void A0L(String str, C1122Km c1122Km) {
        String value = A0C(167, 15, 91);
        Matcher matcher = A05.matcher(str);
        while (matcher.find()) {
            Object A012 = AbstractC07133y.A01(matcher.group(1));
            String[] strArr = A01;
            if (strArr[2].charAt(10) == strArr[6].charAt(10)) {
                throw new RuntimeException();
            }
            A01[3] = "IuLRiWa83LmFflMS6GnqXQo4BkpBDAaM";
            String str2 = (String) A012;
            String str3 = (String) AbstractC07133y.A01(matcher.group(2));
            try {
                if (A0C(353, 4, 43).equals(str2)) {
                    A0M(str3, c1122Km);
                } else if (A0C(Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE, 5, 54).equals(str2)) {
                    c1122Km.A06 = A03(str3);
                } else if (A0C(397, 8, 107).equals(str2)) {
                    A0N(str3, c1122Km);
                } else if (A0C(421, 4, 35).equals(str2)) {
                    c1122Km.A02 = AbstractC1124Ko.A00(str3);
                } else if (A0C(432, 8, 92).equals(str2)) {
                    c1122Km.A07 = A04(str3);
                } else {
                    AbstractC07214g.A07(value, A0C(147, 20, 102) + str2 + A0C(15, 1, 60) + str3);
                }
            } catch (NumberFormatException unused) {
                AbstractC07214g.A07(value, A0C(91, 26, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) + matcher.group());
            }
        }
    }

    public static void A0M(String str, C1122Km c1122Km) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            int commaIndex = indexOf + 1;
            c1122Km.A03 = A01(str.substring(commaIndex));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith(A0C(2, 1, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE))) {
            c1122Km.A00 = AbstractC1124Ko.A00(str);
            c1122Km.A04 = 0;
        } else {
            int commaIndex2 = Integer.parseInt(str);
            c1122Km.A00 = commaIndex2;
            c1122Km.A04 = 1;
        }
    }

    public static void A0N(String str, C1122Km c1122Km) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            int commaIndex = indexOf + 1;
            c1122Km.A05 = A02(str.substring(commaIndex));
            str = str.substring(0, indexOf);
        }
        c1122Km.A01 = AbstractC1124Ko.A00(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        if (r7.equals(A0C(431, 1, 12)) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
    
        r0 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        if (r7.equals(A0C(431, 1, 6)) != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00fe A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0O(String str) {
        char c;
        switch (str.hashCode()) {
            case 98:
                if (str.equals(A0C(Sdk.SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE, 1, 73))) {
                    c = 0;
                    switch (c) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            return true;
                        default:
                            return false;
                    }
                }
                break;
            case 99:
                if (str.equals(A0C(293, 1, 98))) {
                    c = 1;
                    switch (c) {
                    }
                }
                break;
            case 105:
                String A0C = A0C(Sdk.SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE, 1, 111);
                String[] strArr = A01;
                if (strArr[2].charAt(10) == strArr[6].charAt(10)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[2] = "lfhFeDS1O2o1uIM0aOGK2jmnN5o1ZQFy";
                strArr2[6] = "gZA4cz0ExJhogJKpMVDSuYGHtyxwi0jr";
                if (str.equals(A0C)) {
                    c = 2;
                    switch (c) {
                    }
                }
                break;
            case ASSET_FAILED_STATUS_CODE_VALUE:
                if (str.equals(A0C(430, 1, 29))) {
                    c = 6;
                    switch (c) {
                    }
                }
                break;
            case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                if (A01[3].charAt(21) == 'Z') {
                    A01[1] = "d0efHOF5zOPljB40";
                    break;
                } else {
                    A01[4] = "nN5IyC8pDtxjsjNmobfqstup1YpOndtX";
                    break;
                }
                switch (c) {
                }
            case 3650:
                if (A01[3].charAt(21) == 'Z') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A01;
                strArr3[0] = "3Lkw1PxTKRAL7UJ3iME";
                strArr3[7] = "Pvn03sQd9gQ2SLf9pLX";
                if (str.equals(A0C(TTAdConstant.VIDEO_COVER_URL_CODE, 2, 49))) {
                    c = 5;
                    switch (c) {
                    }
                }
                break;
            case 3314158:
                if (str.equals(A0C(341, 4, 48))) {
                    c = 3;
                    switch (c) {
                    }
                }
                break;
            case 3511770:
                if (str.equals(A0C(TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME, 4, 115))) {
                    c = 4;
                    switch (c) {
                    }
                }
                break;
        }
        c = 65535;
        switch (c) {
        }
    }
}
