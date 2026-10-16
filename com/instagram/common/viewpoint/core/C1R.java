package com.instagram.common.viewpoint.core;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.facebook.ads.redexgen.X.1R, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1R extends C8T {
    public static byte[] A05;
    public static String[] A06 = {"W2LX5ghCjNUdHPD6UOG9gNVP2r8Jjr9N", "hy0Kd51hxMRklx2U40MO6uTjDebxbFFc", "3rXKYQ25IDS9XLMelMDoz8fDuc1jWejt", "VHZF6nyXCVj1GWlzSFxOxU8Mk9", "1hZxQPwvp7yuSjm13xBtOFGqAv7wvaBL", "2txr67moghbeiUbFZCBGyiXHK8tBuFWn", "gHf8B0vtrS2LcJp", "q573XCdkPfkFHQHQX29TvMro8DPY3qfe"};
    public static final Pattern A07;
    public float A00;
    public float A01;
    public Map<String, KC> A02;
    public final K7 A03;
    public final boolean A04;

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A05 = new byte[]{85, 39, 48, 53, 39, 83, 107, 36, 38, 53, 38, 48, 39, 83, 107, 36, 38, 53, 39, 83, 107, 36, 38, 84, 53, 33, 82, 39, 83, 107, 36, 38, 75, 35, 52, Ascii.EM, 17, Ascii.FS, Ascii.US, Ascii.ETB, 5, Ascii.NAK, 74, 75, 98, Byte.MAX_VALUE, 96, 108, 121, 55, 101, 93, 95, 70, 70, 95, 88, 81, Ascii.SYN, 17, 101, 66, 79, 90, 83, Ascii.FF, 17, Ascii.SYN, 90, 95, 88, 83, Ascii.SYN, 84, 83, 80, 89, 68, 83, Ascii.SYN, 17, 112, 89, 68, 91, 87, 66, Ascii.FF, 17, Ascii.SYN, 90, 95, 88, 83, Ascii.FF, Ascii.SYN, 37, Ascii.GS, Ascii.US, 6, 6, Ascii.US, Ascii.CAN, 17, 86, Ascii.DC2, Ascii.US, Ascii.ETB, Ascii.SUB, Ascii.EM, 17, 3, 19, 86, Ascii.SUB, Ascii.US, Ascii.CAN, 19, 86, Ascii.DC4, 19, Ascii.DLE, Ascii.EM, 4, 19, 86, Ascii.NAK, Ascii.EM, Ascii.ESC, 6, Ascii.SUB, 19, 2, 19, 86, Ascii.DLE, Ascii.EM, 4, Ascii.ESC, Ascii.ETB, 2, 76, 86, 53, Ascii.CR, Ascii.SI, Ascii.SYN, Ascii.SYN, Ascii.SI, 8, 1, 70, 2, Ascii.SI, 7, 10, 9, 1, 19, 3, 70, 10, Ascii.SI, 8, 3, 70, 17, Ascii.SI, Ascii.DC2, Ascii.SO, 70, 0, 3, 17, 3, Ascii.DC4, 70, 5, 9, 10, 19, Ascii.VT, 8, Ascii.NAK, 70, Ascii.DC2, Ascii.SO, 7, 8, 70, 0, 9, Ascii.DC4, Ascii.VT, 7, Ascii.DC2, 92, 70, 66, 122, 120, 97, 97, 120, Byte.MAX_VALUE, 118, 49, 120, Byte.MAX_VALUE, 103, 112, 125, 120, 117, 49, 101, 120, 124, 120, Byte.MAX_VALUE, 118, 43, 49, 101, 69, 87, 114, 83, 85, 89, 82, 83, 68, 36, 3, Ascii.SO, Ascii.ESC, Ascii.DC2, 77, 45, Ascii.SYN, 19, Ascii.SYN, Ascii.ETB, Ascii.SI, Ascii.SYN, 88, Ascii.EM, Ascii.DC4, 17, Ascii.US, Ascii.SYN, Ascii.NAK, Ascii.GS, Ascii.SYN, Ascii.FF, 66, 88, 40, 54, 5, Ascii.SYN, Ascii.GS, 7, 0, 46, 94, 86, 102, 119, 108, 117, 113, 37, 76, 107, 99, 106, 88, Ascii.CR, 0, 98, 118, 5, 34, 47, 58, 51, 37, Ascii.VT, 124, 113, 19, 7, 116, 83, 94, 75, 66, 84, 122, 7, 70, 85, 66, 7, 73, 72, 83, 7, 84, 82, 87, 87, 72, 85, 83, 66, 67, 75, 70, 36, 59, 48, 67, 100, 105, 124, 117, 99, 77, 92, 78, 5, 49, 108, 94, 5, Ascii.EM, Ascii.DC4, Ascii.FF, 7, Ascii.DLE, 6, Ascii.CR, 94, 66, 79, 87, 92, 75, 93, 87, -72, -38};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private void A0D(String str, K7 k7, List<List<C2439pT>> list, List<Long> list2) {
        String A072 = A07(34, 9, 116);
        AbstractC07133y.A07(str.startsWith(A072));
        String[] split = str.substring(A072.length()).split(A07(32, 1, 99), k7.A01);
        int length = split.length;
        int i = k7.A01;
        String A073 = A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50);
        if (length != i) {
            AbstractC07214g.A07(A073, A07(143, 55, 98) + str);
            return;
        }
        long A04 = A04(split[k7.A02]);
        String A074 = A07(198, 25, 21);
        if (A04 == -9223372036854775807L) {
            AbstractC07214g.A07(A073, A074 + str);
            return;
        }
        long A042 = A04(split[k7.A00]);
        if (A042 == -9223372036854775807L) {
            AbstractC07214g.A07(A073, A074 + str);
            return;
        }
        KC kc = (this.A02 == null || k7.A03 == -1) ? null : this.A02.get(split[k7.A03].trim());
        String str2 = split[k7.A04];
        K9 A02 = K9.A02(str2);
        String A043 = K9.A04(str2);
        String A075 = A07(331, 2, 4);
        String A076 = A07(0, 1, 91);
        C2439pT A062 = A06(A043.replace(A075, A076).replace(A07(335, 2, 52), A076).replace(A07(333, 2, 93), A07(353, 2, 126)), kc, A02, this.A01, this.A00);
        int A03 = A03(A042, list2, list);
        for (int A032 = A03(A04, list2, list); A032 < A03; A032++) {
            list.get(A032).add(A062);
        }
    }

    static {
        A09();
        A07 = Pattern.compile(A07(1, 31, 11));
    }

    public C1R() {
        this(null);
    }

    public C1R(List<byte[]> list) {
        super(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50));
        this.A01 = -3.4028235E38f;
        this.A00 = -3.4028235E38f;
        if (list != null && !list.isEmpty()) {
            this.A04 = true;
            String A0q = C5C.A0q(list.get(0));
            String formatLine = A07(43, 7, 9);
            AbstractC07133y.A07(A0q.startsWith(formatLine));
            this.A03 = (K7) AbstractC07133y.A01(K7.A00(A0q));
            A0A(new C07364v(list.get(1)));
            return;
        }
        this.A04 = false;
        this.A03 = null;
    }

    public static float A00(int i) {
        switch (i) {
            case 0:
                return 0.05f;
            case 1:
                return 0.5f;
            case 2:
                return 0.95f;
            default:
                return -3.4028235E38f;
        }
    }

    public static int A01(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                AbstractC07214g.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(239, 19, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + i);
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                if (A06[3].length() != 26) {
                    throw new RuntimeException();
                }
                A06[6] = "Sg07jKGUv12uLKgMKKFA3fI9zPLxcTEi";
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
        }
    }

    public static int A02(int i) {
        switch (i) {
            case -1:
                return Integer.MIN_VALUE;
            case 0:
            default:
                AbstractC07214g.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(239, 19, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + i);
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                if (A06[3].length() != 26) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[5] = "bBVjASvxGIVEucqGKWBeREj1nHP5tR7K";
                strArr[4] = "afA0CT9VteApb4cGitBpBAxXonSmRtRK";
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
    
        r8.add(r3, java.lang.Long.valueOf(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        if (r3 != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r1 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004c, code lost:
    
        r9.add(r3, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        r0 = r3 - 1;
        r1 = new java.util.ArrayList(r9.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(long j, List<Long> list, List<List<C2439pT>> list2) {
        int i = 0;
        int insertionIndex = list.size();
        int i2 = insertionIndex - 1;
        while (true) {
            if (i2 < 0) {
                break;
            }
            long longValue = list.get(i2).longValue();
            int i3 = A06[7].charAt(28);
            if (i3 == 116) {
                throw new RuntimeException();
            }
            A06[7] = "L6yhcoI2CoUL0EEbj8PtMmDYbUY1DBiP";
            if (longValue == j) {
                return i2;
            }
            if (list.get(i2).longValue() < j) {
                i = i2 + 1;
                break;
            }
            i2--;
        }
    }

    public static long A04(String str) {
        Matcher matcher = A07.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) C5C.A0f(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) C5C.A0f(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) C5C.A0f(matcher.group(3))) * 1000000) + (Long.parseLong((String) C5C.A0f(matcher.group(4))) * 10000);
    }

    public static Layout.Alignment A05(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                AbstractC07214g.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(239, 19, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE) + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    public static C2439pT A06(String str, KC kc, K9 k9, float f, float f2) {
        int i;
        SpannableString spannableString = new SpannableString(str);
        C07033o A0G = new C07033o().A0G(spannableString);
        if (kc != null) {
            if (kc.A04 != null) {
                spannableString.setSpan(new ForegroundColorSpan(kc.A04.intValue()), 0, spannableString.length(), 33);
            }
            if (kc.A02 == 3 && kc.A03 != null) {
                spannableString.setSpan(new BackgroundColorSpan(kc.A03.intValue()), 0, spannableString.length(), 33);
            }
            if (kc.A00 != -3.4028235E38f) {
                if (A06[3].length() != 26) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[5] = "hamZaHHK5iJw0vPowwB4Xi3W6GQULYkl";
                strArr[4] = "AtQHcqF1nJuVU9oQ1sBsNKUnqzSBt8ub";
                if (f2 != -3.4028235E38f) {
                    A0G.A08(kc.A00 / f2, 1);
                }
            }
            if (kc.A06 && kc.A07) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (kc.A06) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (kc.A07) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (kc.A09) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (kc.A08) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i2 = k9.A00;
        if (A06[6].length() == 19) {
            throw new RuntimeException();
        }
        A06[7] = "i2mc5u7bs2HiiqvdNfcyeR2hNUTbHa8c";
        if (i2 != -1) {
            i = k9.A00;
        } else if (kc != null) {
            i = kc.A01;
        } else {
            i = -1;
        }
        C07033o cue = A0G.A0F(A05(i));
        cue.A0A(A02(i)).A09(A01(i));
        if (k9.A01 != null && f2 != -3.4028235E38f && f != -3.4028235E38f) {
            A0G.A04(k9.A01.x / f);
            A0G.A07(k9.A01.y / f2, 0);
        } else {
            A0G.A04(A00(A0G.A01()));
            A0G.A07(A00(A0G.A00()), 0);
        }
        return A0G.A0H();
    }

    public static Map<String, KC> A08(C07364v c07364v) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        K8 k8 = null;
        while (true) {
            String A0T = c07364v.A0T();
            if (A0T == null || (c07364v.A07() != 0 && c07364v.A0B() == 91)) {
                break;
            }
            if (A0T.startsWith(A07(43, 7, 9))) {
                k8 = K8.A00(A0T);
            } else if (A0T.startsWith(A07(233, 6, 115))) {
                if (k8 == null) {
                    String currentLine = A07(50, 46, 50) + A0T;
                    AbstractC07214g.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), currentLine);
                } else {
                    KC A04 = KC.A04(A0T, k8);
                    if (A04 != null) {
                        linkedHashMap.put(A04.A05, A04);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private void A0A(C07364v c07364v) {
        while (true) {
            String A0T = c07364v.A0T();
            if (A0T != null) {
                if (A07(266, 13, 1).equalsIgnoreCase(A0T)) {
                    A0B(c07364v);
                } else if (A07(Sdk.SDKError.Reason.SILENT_MODE_MONITOR_ERROR_VALUE, 12, 20).equalsIgnoreCase(A0T)) {
                    this.A02 = A08(c07364v);
                } else if (A07(279, 11, 82).equalsIgnoreCase(A0T)) {
                    AbstractC07214g.A06(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(290, 29, 35));
                } else if (A07(258, 8, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE).equalsIgnoreCase(A0T)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        if (r5.equals(A07(345, 8, 31)) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        r6 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        if (r5.equals(A07(345, 8, 42)) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a7, code lost:
    
        if (r5.equals(A07(337, 8, 113)) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0B(C07364v c07364v) {
        while (true) {
            String A0T = c07364v.A0T();
            if (A0T != null) {
                if (c07364v.A07() == 0 || c07364v.A0B() != 91) {
                    String[] split = A0T.split(A07(33, 1, 29));
                    if (split.length == 2) {
                        char c = 0;
                        String A01 = AbstractC2124k7.A01(split[0].trim());
                        String currentLine = A06[7];
                        if (currentLine.charAt(28) != 't') {
                            String[] strArr = A06;
                            strArr[5] = "TxjPtR6Me2tOCH56RvBuXVxOpTFPkhKs";
                            strArr[4] = "CGC80sv4xmOos6ad3yBESqJRjeXwJGgE";
                            switch (A01.hashCode()) {
                                case 1879649548:
                                    break;
                                case 1879649549:
                                    String currentLine2 = A06[0];
                                    if (currentLine2.charAt(2) == 'L') {
                                        A06[3] = "57knmpqjR0Ls81goizN6npBH6l";
                                        break;
                                    } else {
                                        String[] strArr2 = A06;
                                        strArr2[5] = "y7TEYh3wOWaLWgkmzZBlA5JQj6rjOZZg";
                                        strArr2[4] = "3gq1Vhf6xja9YBkNvRBFSeYMsj86kNRf";
                                        break;
                                    }
                                default:
                                    c = 65535;
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    this.A01 = Float.parseFloat(split[1].trim());
                                    break;
                                case 1:
                                    try {
                                        this.A00 = Float.parseFloat(split[1].trim());
                                        break;
                                    } catch (NumberFormatException unused) {
                                        break;
                                    }
                            }
                        } else {
                            throw new RuntimeException();
                        }
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void A0C(C07364v c07364v, List<List<C2439pT>> list, List<Long> list2) {
        K7 k7 = this.A04 ? this.A03 : null;
        while (true) {
            String A0T = c07364v.A0T();
            if (A0T != null) {
                if (A0T.startsWith(A07(43, 7, 9))) {
                    k7 = K7.A00(A0T);
                } else if (A0T.startsWith(A07(34, 9, 116))) {
                    if (k7 == null) {
                        AbstractC07214g.A07(A07(Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE, 10, 50), A07(96, 47, 114) + A0T);
                    } else {
                        A0D(A0T, k7, list, list2);
                    }
                }
            } else {
                return;
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.C8T
    public final InterfaceC1093Jj A0g(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        C07364v c07364v = new C07364v(bArr, i);
        if (!this.A04) {
            A0A(c07364v);
        }
        A0C(c07364v, arrayList, arrayList2);
        return new C2216le(arrayList, arrayList2);
    }
}
