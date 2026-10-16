package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Vu, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1408Vu {
    public static byte[] A04;
    public static String[] A05 = {"ZYrzMRmVY0fKuwQx318rNacSlgEREo8W", "DFlEfnYj9N0tv35MBsRVrv0NQ03vrQp9", "7c1jEy6Yvwz0PD0sTLnvRvzL7JrMoPnP", "hf", "LVfRkpSB2W01n6UoKBvMpgi93s4V", "wjSsCSJEOA2zcxlJjQpf4WZQJP", "cgSUujLLCITlA6k0bkAALzG3bpp7bkqz", "L2ObalbYjPtjYVm4HCkeGK0BV8R2iNFP"};
    public final EnumC1407Vt A00;
    public final Long A01;
    public final String A02;
    public final String A03;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public C1408Vu(T8 t8, String str, String str2, EnumC1404Vq enumC1404Vq) throws C1402Vn {
        String A01 = A01(270, 21, 91);
        String A012 = A01(291, 11, 58);
        String A013 = A01(247, 14, 109);
        String A014 = A01(Sdk.SDKError.Reason.AD_HTML_FAILED_TO_LOAD_VALUE, 4, 38);
        String A015 = A01(Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE, 8, 37);
        if (TextUtils.isEmpty(str)) {
            this.A00 = EnumC1407Vt.A04;
            this.A01 = null;
            this.A03 = null;
            this.A02 = null;
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            switch (EnumC1407Vt.valueOf(jSONObject.getString(A014).toUpperCase()).ordinal()) {
                case 0:
                    this.A00 = EnumC1407Vt.A03;
                    this.A01 = Long.valueOf(jSONObject.getString(A01(241, 6, 127)));
                    if (jSONObject.has(A013)) {
                        this.A02 = jSONObject.getString(A013);
                    } else {
                        this.A02 = null;
                    }
                    this.A03 = jSONObject.getString(A01(261, 9, 88));
                    if (!jSONObject.getString(A012).equals(t8.A05().A9T()) && !ProcessUtils.isRemoteRenderingProcess() && AbstractC1382Us.A03(jSONObject) != Boolean.TRUE) {
                        throw new C1402Vn(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(0, 54, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), this.A01, jSONObject.getString(A012), t8.A05().A9T()));
                    }
                    if (!jSONObject.getString(A01).equals(str2)) {
                        throw new C1402Vn(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(54, 50, 11), this.A01, jSONObject.getString(A01), str2));
                    }
                    HashSet hashSet = new HashSet(Arrays.asList(Integer.valueOf(EnumC1404Vq.A0H.A04()), Integer.valueOf(EnumC1404Vq.A0K.A04()), Integer.valueOf(EnumC1404Vq.A0I.A04()), Integer.valueOf(EnumC1404Vq.A0J.A04())));
                    if (jSONObject.getInt(A015) != enumC1404Vq.A04()) {
                        if (!hashSet.contains(Integer.valueOf(jSONObject.getInt(A015))) || !hashSet.contains(Integer.valueOf(enumC1404Vq.A04()))) {
                            throw new C1402Vn(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(104, 48, 28), this.A01, Integer.valueOf(jSONObject.getInt(A015)), enumC1404Vq));
                        }
                        return;
                    }
                    return;
                default:
                    throw new C1402Vn(AdErrorType.BID_PAYLOAD_ERROR, A01(210, 28, 68) + jSONObject.getString(A014));
            }
        } catch (JSONException e) {
            t8.A08().ABC(A01(238, 3, 5), AbstractC1341Td.A0P, new C1342Te(e));
            throw new C1402Vn(AdErrorType.BID_PAYLOAD_ERROR, A01(152, 18, 88), e);
        }
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{34, 9, 4, SignedBytes.MAX_POWER_OF_TWO, 69, 4, SignedBytes.MAX_POWER_OF_TWO, 6, Ascii.SI, Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 51, 36, 43, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 5, Ascii.DC2, 19, 9, Ascii.SI, Ascii.SO, SignedBytes.MAX_POWER_OF_TWO, 69, 19, SignedBytes.MAX_POWER_OF_TWO, 2, 5, 9, Ascii.SO, 7, SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, 19, 5, 4, SignedBytes.MAX_POWER_OF_TWO, Ascii.SI, Ascii.SO, SignedBytes.MAX_POWER_OF_TWO, 51, 36, 43, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 5, Ascii.DC2, 19, 9, Ascii.SI, Ascii.SO, SignedBytes.MAX_POWER_OF_TWO, 69, 19, 83, 120, 117, 49, 52, 117, 49, 119, 126, 99, 49, 97, 125, 112, 114, 116, 124, 116, Byte.MAX_VALUE, 101, 49, 52, 98, 49, 115, 116, 120, Byte.MAX_VALUE, 118, 49, 100, 98, 116, 117, 49, 126, Byte.MAX_VALUE, 49, 97, 125, 112, 114, 116, 124, 116, Byte.MAX_VALUE, 101, 49, 52, 98, 68, 111, 98, 38, 35, 98, 38, 96, 105, 116, 38, 114, 99, 107, 118, 106, 103, 114, 99, 38, 35, 117, 38, 100, 99, 111, 104, 97, 38, 115, 117, 99, 98, 38, 105, 104, 38, 114, 99, 107, 118, 106, 103, 114, 99, 38, 35, 117, Ascii.VT, 44, 52, 35, 46, 43, 38, 98, 0, 43, 38, Ascii.DC2, 35, 59, 46, 45, 35, 38, 71, 118, 126, 99, Byte.MAX_VALUE, 114, 103, 118, 51, 54, 96, 51, 122, 96, 51, 125, 124, 103, 51, 101, 114, Byte.MAX_VALUE, 122, 119, 51, 113, 114, 125, 125, 118, 97, 51, 103, 118, 126, 99, Byte.MAX_VALUE, 114, 103, 118, Ascii.VT, 48, 45, 43, 46, 46, 49, 44, 42, 59, 58, 126, Ascii.FS, 55, 58, Ascii.SO, 63, 39, 50, 49, 63, 58, 126, 42, 39, 46, 59, 126, 126, 111, 118, 7, Ascii.FF, 1, 58, Ascii.FF, 1, Ascii.NAK, Ascii.RS, 19, 40, 3, Ascii.RS, Ascii.SUB, Ascii.DC2, 40, 3, Ascii.CAN, Ascii.FS, Ascii.DC2, Ascii.EM, 38, 39, 52, 43, 33, 39, Ascii.GS, 43, 38, 51, 36, 50, 46, 45, 55, 36, 37, Ascii.RS, 49, 45, 32, 34, 36, 44, 36, 47, 53, Ascii.RS, 40, 37, 83, 68, 75, Byte.MAX_VALUE, 86, 69, 82, 83, 73, 79, 78, 75, 90, 82, 79, 83, 94, 75, 90, 72, 69, 76, 89};
    }

    static {
        A02();
    }

    public C1408Vu() {
        this.A00 = EnumC1407Vt.A04;
        this.A01 = null;
        this.A03 = null;
        this.A02 = null;
    }

    public static EnumC1404Vq A00(String str) throws C1402Vn {
        try {
            return EnumC1404Vq.A00(new JSONObject(str).getInt(A01(Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE, 8, 37)));
        } catch (JSONException e) {
            throw new C1402Vn(AdErrorType.BID_PAYLOAD_ERROR, A01(152, 18, 88), e);
        }
    }

    public static void A03(EnumC1404Vq enumC1404Vq) throws C1402Vn {
        if (!EnumC1404Vq.A0G.equals(enumC1404Vq) && !EnumC1404Vq.A0E.equals(enumC1404Vq) && !EnumC1404Vq.A0F.equals(enumC1404Vq)) {
            boolean equals = EnumC1404Vq.A0D.equals(enumC1404Vq);
            if (A05[1].charAt(20) == 'm') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "X5uVqi4FyBeSosvF2q5aVclYJStrMHB5";
            strArr[2] = "BOgVvqLcU58P5XEa1Smg5LyKHeBKxxT8";
            if (equals) {
            } else {
                throw new C1402Vn(AdErrorType.BID_IMPRESSION_MISMATCH, String.format(Locale.US, A01(170, 40, 9), Integer.valueOf(enumC1404Vq.A04())));
            }
        }
    }

    public final String A04() {
        if (this.A01 == null) {
            return null;
        }
        Long l = this.A01;
        if (A05[4].length() == 4) {
            throw new RuntimeException();
        }
        A05[7] = "9BRFtSg6abebTfCvkl6x8CVGG9ZYJ4hw";
        return l.toString();
    }

    public final String A05() {
        return this.A02;
    }

    public final boolean A06() {
        return this.A00 != EnumC1407Vt.A04;
    }
}
