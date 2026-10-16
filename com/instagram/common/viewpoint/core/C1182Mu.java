package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Mu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1182Mu {
    public static byte[] A00;
    public static final String A01;

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 9);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{44, Ascii.ETB, Ascii.CAN, Ascii.ESC, Ascii.NAK, Ascii.FS, 89, Ascii.CR, Ascii.SYN, 89, 9, Ascii.CAN, Ascii.VT, 10, Ascii.FS, 89, 19, 10, Ascii.SYN, Ascii.ETB, 89, Ascii.GS, Ascii.CAN, Ascii.CR, Ascii.CAN, 89, Ascii.DLE, Ascii.ETB, 89, 56, Ascii.GS, 56, Ascii.SUB, Ascii.CR, Ascii.DLE, Ascii.SYN, Ascii.ETB, 63, Ascii.CAN, Ascii.SUB, Ascii.CR, Ascii.SYN, Ascii.VT, 0, 87, 114, 119, 98, 119, 51, 50, 47, 53, 40, 57, 126, 97, 116, Byte.MAX_VALUE, 78, 125, 120, Byte.MAX_VALUE, 122, 49, 32, 51, 50, 40, 47, 38, 62, 47, Base64.padSymbol, Base64.padSymbol, 58, 38, 60, 33, 59, 41, 38, 42, 45, 54, 43, 60, 88, 95, 68, 89, 78, 116, 94, 89, 71, 116, 92, 78, 73, 116, 77, 74, 71, 71, 73, 74, 72, SignedBytes.MAX_POWER_OF_TWO, 50, 52, 51, 35, 76, 83, 94, 95, 85, 101, 79, 72, 86};
    }

    static {
        A03();
        A01 = C1182Mu.class.getSimpleName();
    }

    public static AbstractC1181Mt A00(C1929gi c1929gi, VA va, String str, Uri uri, Map<String, String> extraData, C1193Ng c1193Ng) {
        return A01(c1929gi, va, str, uri, extraData, true, false, c1193Ng);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AbstractC1181Mt A01(final C1929gi c1929gi, final VA va, final String action, final Uri uri, final Map<String, String> map, final boolean z, boolean z2, C1193Ng c1193Ng) {
        char c;
        if (uri == null || uri.getAuthority() == null) {
            return null;
        }
        String key = uri.getAuthority();
        String queryParameter = uri.getQueryParameter(A02(113, 9, 51));
        String queryParameter2 = uri.getQueryParameter(A02(45, 4, 31));
        if (queryParameter2 != null && !TextUtils.isEmpty(queryParameter2)) {
            try {
                JSONObject jSONObject = new JSONObject(queryParameter2);
                Iterator<String> dataIterator = jSONObject.keys();
                while (dataIterator.hasNext()) {
                    String next = dataIterator.next();
                    try {
                        map.put(next, jSONObject.getString(next));
                    } catch (JSONException e) {
                        e = e;
                        c1929gi.A08().ABC(A02(64, 7, 72), AbstractC1341Td.A23, new C1342Te(e));
                        Log.w(A01, A02(0, 45, 112), e);
                        final N0 A002 = N0.A00(va, ActivityUtils.A00());
                        switch (key.hashCode()) {
                            case -1458789996:
                                break;
                            case 109770977:
                                break;
                            case 1546100943:
                                break;
                        }
                        switch (c) {
                        }
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
        }
        final N0 A0022 = N0.A00(va, ActivityUtils.A00());
        switch (key.hashCode()) {
            case -1458789996:
                if (key.equals(A02(71, 11, 71))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 109770977:
                if (key.equals(A02(82, 5, 80))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1546100943:
                if (key.equals(A02(55, 9, 24))) {
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
                if (queryParameter != null) {
                    return null;
                }
                return (!z2 || TextUtils.isEmpty(uri.getQueryParameter(A02(87, 22, 34)))) ? new AnonymousClass87(c1929gi, va, action, uri, map, A0022, z, c1193Ng) : new AnonymousClass85(c1929gi, va, action, uri, map);
            case 1:
                if (A02(109, 4, 79).equals(uri.getQueryParameter(A02(49, 6, 85)))) {
                    return new AbstractC2133kH(c1929gi, va, action, uri, map, A0022, z) { // from class: com.facebook.ads.redexgen.X.83
                        public static byte[] A02;
                        public static final String A03;
                        public final Uri A00;
                        public final Map<String, String> A01;

                        public static String A00(int i, int i2, int i3) {
                            byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                            for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                                copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 108);
                            }
                            return new String(copyOfRange);
                        }

                        public static void A01() {
                            A02 = new byte[]{93, 122, 114, 119, 126, Byte.MAX_VALUE, 59, 111, 116, 59, 116, 107, 126, 117, 59, 119, 114, 117, 112, 59, 110, 105, 119, 33, 59, 67, 70, 65, 68};
                        }

                        static {
                            A01();
                            A03 = AnonymousClass83.class.getSimpleName();
                        }

                        {
                            this.A00 = uri;
                            this.A01 = map;
                        }

                        @Override // com.instagram.common.viewpoint.core.AbstractC2133kH
                        public final EnumC1178Mq A0H() {
                            EnumC1178Mq enumC1178Mq = EnumC1178Mq.A09;
                            if (((AbstractC2133kH) this).A03) {
                                enumC1178Mq = A0M();
                            }
                            A0J(this.A01, enumC1178Mq);
                            return enumC1178Mq;
                        }

                        public final EnumC1178Mq A0M() {
                            EnumC1178Mq enumC1178Mq = EnumC1178Mq.A09;
                            try {
                                X6.A0D(new X6(), ((AbstractC1181Mt) this).A01, XB.A00(this.A00.getQueryParameter(A00(25, 4, 67))), ((AbstractC1181Mt) this).A03);
                                return enumC1178Mq;
                            } catch (Exception unused) {
                                String str = A00(0, 25, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) + this.A00.toString();
                                return EnumC1178Mq.A04;
                            }
                        }
                    };
                }
                return z2 ? new AnonymousClass85(c1929gi, va, action, uri, map) : new AbstractC2133kH(c1929gi, va, action, uri, map, A0022, z) { // from class: com.facebook.ads.redexgen.X.84
                    public static byte[] A02;
                    public static String[] A03 = {"FXNBCWXiStej7hPExkUYAqHU7xYJWQz0", "1k", "9V456DvY4LqOh9I9hdT7Vdo5", "hY2FptqSd7XbZZsJCz2yOGxQcUuE9Eo6", "F2N3RsuOcTrAQaEUExDI4U65CqttWDRl", "hYiRMwjZqKFmNKhRfgQ6FfhFwFErfvFO", "BBwXtDWFWjLC6NycZYUWGAP3M0YJ", ""};
                    public static final String A04;
                    public final Uri A00;
                    public final Map<String, String> A01;

                    public static String A00(int i, int i2, int i3) {
                        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
                        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
                            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 84);
                        }
                        return new String(copyOfRange);
                    }

                    public static void A01() {
                        A02 = new byte[]{-100, -73, -65, -62, -69, -70, 118, -54, -59, 118, -59, -58, -69, -60, 118, -62, -65, -60, -63, 118, -53, -56, -62, -112, 118, -45, -48, -43, -46};
                        if (A03[3].charAt(0) == 'g') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[4] = "n2WgzR0RMCkX50JDMRkryQ8YygezODnU";
                        strArr[5] = "Oz9myBlwI7NBoyftyrFAavzWMm25M0Ie";
                    }

                    static {
                        A01();
                        A04 = AnonymousClass84.class.getSimpleName();
                    }

                    {
                        this.A00 = uri;
                        this.A01 = map;
                    }

                    @Override // com.instagram.common.viewpoint.core.AbstractC2133kH
                    public final EnumC1178Mq A0H() {
                        EnumC1178Mq enumC1178Mq = EnumC1178Mq.A09;
                        if (((AbstractC2133kH) this).A03) {
                            enumC1178Mq = A0M();
                        }
                        if (!YB.A0i(((AbstractC1181Mt) this).A01, enumC1178Mq, this.A01)) {
                            A0J(this.A01, enumC1178Mq);
                        }
                        return enumC1178Mq;
                    }

                    public final EnumC1178Mq A0M() {
                        if (A0K(this.A00)) {
                            EnumC1178Mq actionOutcome = EnumC1178Mq.A0A;
                            return actionOutcome;
                        }
                        try {
                            EnumC1178Mq actionOutcome2 = X6.A06(new X6(), ((AbstractC1181Mt) this).A01, XB.A00(this.A00.getQueryParameter(A00(25, 4, 19))), ((AbstractC1181Mt) this).A03, this.A01);
                            return actionOutcome2;
                        } catch (Exception unused) {
                            String str = A00(0, 25, 2) + this.A00.toString();
                            EnumC1178Mq actionOutcome3 = EnumC1178Mq.A04;
                            return actionOutcome3;
                        }
                    }
                };
            case 2:
                return new C2132kG(c1929gi, va, action, uri, map);
            default:
                return new C2131kE(c1929gi, va, action, uri);
        }
    }

    public static boolean A04(String str) {
        return A02(82, 5, 80).equalsIgnoreCase(str) || A02(55, 9, 24).equalsIgnoreCase(str);
    }
}
