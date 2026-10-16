package com.instagram.common.viewpoint.core;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.protobuf.EventTypeExtended;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public final class NR implements Serializable {
    public static byte[] A0C = null;
    public static final long serialVersionUID = 85021702336014823L;
    public NT A00;
    public long A01;
    public NU A02;
    public NY A03;
    public C1189Nc A04;
    public C1190Nd A05;
    public String A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;

    static {
        A04();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static NR A00(JSONObject jSONObject) {
        NR nr = new NR();
        JSONObject optJSONObject = jSONObject.optJSONObject(A01(374, 12, 11));
        nr.A08(new NX().A0Z(jSONObject.optString(A01(774, 5, 94))).A0Y(jSONObject.optString(A01(766, 8, 26))).A0M(jSONObject.optString(A01(136, 4, 25))).A0X(jSONObject.optString(A01(752, 14, 83))).A0V(jSONObject.optString(A01(602, 12, 101))).A0S(jSONObject.optString(A01(TTAdConstant.STYLE_SIZE_RADIO_9_16, 12, 23))).A0J(jSONObject.optString(A01(128, 8, 53))).A0O(jSONObject.optString(A01(Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE, 14, 111))).A0I(jSONObject.optString(A01(93, 16, 72))).A0K(jSONObject.optString(A01(165, 8, 28))).A0N(jSONObject.optString(A01(202, 17, 8))).A0U(A03(optJSONObject, A01(591, 11, 106), A01(76, 6, 30))).A0P(A03(optJSONObject, A01(233, 19, 44), A01(8, 9, 63))).A0W(A03(optJSONObject, A01(IronSourceError.ERROR_NT_LOAD_NO_FILL, 9, 61), A01(89, 4, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))).A0L(A03(optJSONObject, A01(173, 13, 99), A01(0, 8, 99))).A0T(A03(optJSONObject, A01(574, 17, 41), A01(82, 7, 30))).A0Q(A03(optJSONObject, A01(347, 27, 28), A01(17, 22, 67))).A0R(A03(optJSONObject, A01(548, 14, 54), A01(0, 0, 55))).A0a());
        nr.A0B(jSONObject.optString(A01(541, 7, 11)));
        nr.A09(new C1189Nc(jSONObject.optString(A01(335, 12, 29)), jSONObject.optString(A01(151, 14, 12)), jSONObject.optJSONObject(A01(140, 11, 95)), jSONObject.optString(A02(jSONObject))));
        String A01 = A01(779, 19, 64);
        NT A0K = new NT().A0L(jSONObject.optString(A01(865, 9, 113))).A0J(jSONObject.optLong(A01(841, 24, Sdk.SDKError.Reason.TPAT_ERROR_VALUE), -1L)).A0F(jSONObject.optInt(A01, -1) == -1 ? jSONObject.optInt(A01(735, 17, 21), -1) : jSONObject.optInt(A01, -1)).A0E(jSONObject.optInt(A01(634, 18, 72), Integer.MAX_VALUE)).A0D(jSONObject.optInt(A01(614, 20, 108), -1)).A0K(C1201No.A02(jSONObject));
        JSONObject optJSONObject2 = jSONObject.optJSONObject(A01(392, 5, 29));
        if (optJSONObject2 != null) {
            A0K.A0M(optJSONObject2.optString(A01(798, 3, 98))).A0I(optJSONObject2.optInt(A01(874, 5, 9))).A0H(optJSONObject2.optInt(A01(386, 6, 82)));
        }
        nr.A06(A0K);
        nr.A0F(jSONObject.optBoolean(A01(685, 21, 126)));
        nr.A0A(new C1190Nd(AbstractC1440Xd.A04(jSONObject.optJSONArray(A01(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 15, 95))), jSONObject.optLong(A01(252, 24, 57), 0L), jSONObject.optLong(A01(276, 44, 66), 0L), jSONObject.optBoolean(A01(476, 26, 75)), jSONObject.optBoolean(A01(397, 31, 46), false), jSONObject.optBoolean(A01(428, 34, 79), false)));
        nr.A0C(jSONObject.optBoolean(A01(522, 19, 75)));
        nr.A05(jSONObject.optLong(A01(109, 19, 59), 0L));
        return nr;
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{57, Ascii.ESC, Ascii.SO, Ascii.US, Ascii.GS, Ascii.NAK, 8, 3, 98, 73, 81, 72, 74, 73, 71, 66, 85, Ascii.FS, 40, 53, 55, 122, Ascii.GS, 53, 53, Base64.padSymbol, 54, 63, 122, 10, 54, 59, 35, 122, 9, 46, 53, 40, 63, 126, 67, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 94, 91, 91, Ascii.ETB, 86, 66, 67, 88, 90, 86, 67, 94, 84, 86, 91, 91, 78, Ascii.ETB, 88, 71, 82, 89, Ascii.ETB, 94, 89, Ascii.ETB, 108, 68, 82, 84, 68, 106, 68, 85, 102, 115, 110, 105, 96, 85, 98, 113, 110, 98, 112, 116, Base64.padSymbol, 7, Ascii.DC4, Ascii.VT, 48, 53, Ascii.SO, 50, 35, 52, 48, 37, 56, 39, 52, Ascii.SO, 37, 40, 33, 52, 67, 70, 125, 84, 75, 70, 71, 77, 125, 78, 77, 77, 82, 125, 86, 75, 79, 71, 81, 77, 92, 92, 115, 95, 69, 86, 73, 98, 111, 100, 121, 36, 51, 50, 50, 41, 40, Ascii.EM, 47, 37, 41, 40, 118, 116, 121, 121, 74, 97, 122, 74, 116, 118, 97, 124, 122, 123, 102, 100, 113, 96, 98, 106, 119, 124, Ascii.EM, Ascii.ESC, Ascii.SO, Ascii.US, Ascii.GS, Ascii.NAK, 8, 3, 37, Ascii.SO, Ascii.US, 2, Ascii.SO, 69, 68, 77, SignedBytes.MAX_POWER_OF_TWO, 88, 126, 66, 77, 72, 66, 74, 126, 85, 68, 89, 85, 117, 116, 98, 101, 120, Byte.MAX_VALUE, 112, 101, 120, 126, Byte.MAX_VALUE, 78, 101, 120, 101, 125, 116, Ascii.DC2, Ascii.EM, 1, Ascii.CAN, Ascii.SUB, Ascii.EM, Ascii.ETB, Ascii.DC2, 41, Ascii.NAK, Ascii.EM, 3, Ascii.CAN, 2, 81, 90, 66, 91, 89, 90, 84, 81, 106, 86, 90, SignedBytes.MAX_POWER_OF_TWO, 91, 65, 106, 65, 80, 77, 65, 69, 78, 68, Byte.MAX_VALUE, 67, 65, 82, 68, Byte.MAX_VALUE, 70, 79, 82, 67, 69, Byte.MAX_VALUE, 86, 73, 69, 87, Byte.MAX_VALUE, 84, 73, 77, 69, 62, 53, 63, 4, 56, 58, 41, 63, 4, Base64.padSymbol, 52, 41, 56, 62, 4, 45, 50, 62, 44, 4, 47, 50, 54, 62, 4, Base64.padSymbol, 52, 41, 4, 40, 62, 56, 52, 53, 63, 4, 62, 53, 63, 4, 56, 58, 41, 63, 35, 40, 34, Ascii.EM, 37, 39, 52, 34, Ascii.EM, 47, 43, 39, 33, 35, 53, 98, 102, 101, 96, 91, 103, 107, 105, 105, 101, 106, 96, 99, 119, 106, 104, 90, 98, 106, 106, 98, 105, 96, 90, 117, 105, 100, 124, 90, 118, 113, 106, 119, 96, 90, 113, 96, 125, 113, 117, 119, 124, 119, 96, 123, 113, 77, 102, 119, 106, 102, 35, 46, 34, 44, 35, 63, 109, 105, 101, 99, 97, 94, 68, 104, 82, 89, 83, 104, 84, 86, 69, 83, 104, 65, 5, 104, 69, 82, 83, 82, 68, 94, 80, 89, 104, 82, 89, 86, 85, 91, 82, 83, 63, 37, 9, 57, 53, 9, 51, 56, 50, 9, 53, 55, 36, 50, 9, 32, 100, 9, 36, 51, 50, 51, 37, 63, 49, 56, 9, 51, 56, 55, 52, 58, 51, 50, 94, 68, 104, 69, 82, SignedBytes.MAX_POWER_OF_TWO, 86, 69, 83, 82, 83, 104, 86, 83, 59, 33, Ascii.CR, 33, 55, 49, Base64.padSymbol, 60, 54, Ascii.CR, 55, 60, 54, Ascii.CR, 49, 51, 32, 54, Ascii.CR, 55, 60, 51, 48, 62, 55, 54, 107, 113, 93, 116, 107, 102, 103, 109, 93, 99, 119, 102, 107, 109, 93, 111, 119, 118, 103, 102, 59, 33, Ascii.CR, 37, 51, 38, 49, 58, Ascii.CR, 51, 60, 54, Ascii.CR, 48, 32, Base64.padSymbol, 37, 33, 55, 98, 115, 113, 121, 115, 117, 119, 95, 78, 93, 91, 65, 74, 93, 92, 71, 70, 95, 112, 78, 75, 124, 111, 122, 103, 96, 105, 81, 109, 97, 123, 96, 122, 66, 81, 68, 89, 94, 87, 111, 83, 95, 69, 94, 68, 111, 68, 85, 72, 68, 1, Ascii.DC2, 7, Ascii.SUB, Ascii.GS, Ascii.DC4, 44, 7, Ascii.SYN, Ascii.VT, 7, Ascii.SO, Ascii.GS, 8, Ascii.NAK, Ascii.DC2, Ascii.ESC, 35, 10, Ascii.GS, Ascii.DLE, 9, Ascii.EM, 6, Ascii.DLE, Ascii.SYN, Ascii.SUB, Ascii.ESC, 17, 6, 42, 19, Ascii.SUB, 7, 42, Ascii.ESC, Ascii.DLE, Ascii.CR, 1, 42, Ascii.SYN, 1, Ascii.DC4, 34, 52, 50, 62, 63, 53, 34, Ascii.SO, 55, 62, 35, Ascii.SO, 35, 52, 38, 48, 35, 53, 117, 110, 105, 113, 89, 99, 104, 98, 89, 101, 103, 116, 98, 96, 123, 124, 100, 76, 118, 107, 122, 103, 76, 103, 97, 114, 125, 96, 122, 103, 122, 124, 125, Ascii.DC4, Ascii.SI, 8, Ascii.DLE, 56, Ascii.SO, 9, 19, Ascii.NAK, 8, 56, 19, Ascii.NAK, 6, 9, Ascii.DC4, Ascii.SO, 19, Ascii.SO, 8, 9, 87, 77, 94, 65, 123, 80, 65, 92, 80, 119, 111, 109, 116, 91, 101, 106, 96, 91, 104, 107, 119, 97, 91, 118, 97, 115, 101, 118, 96, Byte.MAX_VALUE, 103, 101, 124, 124, 109, 110, 96, 105, 83, Byte.MAX_VALUE, 105, 111, 99, 98, 104, Byte.MAX_VALUE, 57, 37, 41, 35, 43, 38, Ascii.NAK, 41, 37, 36, 62, 47, 50, 62, 112, 118, 97, 119, 106, 119, 111, 102, 51, 46, 51, 43, 34, 44, 55, 42, 50, 48, 41, 41, 56, 59, 53, 60, 6, 42, 60, 58, 54, 55, Base64.padSymbol, 42, Ascii.SO, 9, Ascii.ETB, 6, Ascii.EM, Ascii.DC4, Ascii.NAK, Ascii.US, 47, 17, 5, 4, Ascii.US, 0, Ascii.FS, 17, 9, 47, Ascii.NAK, Ascii.RS, 17, Ascii.DC2, Ascii.FS, Ascii.NAK, Ascii.DC4, 4, Ascii.ESC, Ascii.SYN, Ascii.ETB, Ascii.GS, 45, Ascii.SYN, 7, 0, 19, 6, Ascii.ESC, Ascii.GS, Ascii.FS, 45, 1, Ascii.ETB, 17, Ascii.SYN, 9, 4, 5, Ascii.SI, 63, Ascii.DLE, Ascii.DC2, 5, Ascii.FF, Ascii.SI, 1, 4, 63, 19, 9, Ascii.SUB, 5, 63, 2, Ascii.EM, Ascii.DC4, 5, 19, Ascii.RS, 1, Ascii.FF, Ascii.CR, 7, 55, Ascii.GS, Ascii.SUB, 4, 103, 121, 116, 100, 120};
    }

    public static String A02(JSONObject jSONObject) {
        String A01 = A01(186, 16, 56);
        String A012 = A01(39, 37, 46);
        String optString = jSONObject.optString(A01, A012);
        if (optString.equals(A012)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(A01(374, 12, 11));
            if (optJSONObject != null) {
                A012 = optJSONObject.optString(A01, A012);
            }
            return A012;
        }
        return optString;
    }

    public static String A03(JSONObject jSONObject, String str, String str2) {
        return jSONObject != null ? jSONObject.optString(str, str2) : str2;
    }

    private final void A05(long j) {
        this.A01 = Math.max(0L, j);
    }

    private void A06(NT nt) {
        this.A00 = nt;
    }

    private final void A07(NU nu) {
        this.A02 = nu;
    }

    private final void A08(NY ny) {
        this.A03 = ny;
    }

    private final void A09(C1189Nc c1189Nc) {
        this.A04 = c1189Nc;
    }

    private final void A0A(C1190Nd c1190Nd) {
        this.A05 = c1190Nd;
    }

    private final void A0B(String str) {
        this.A06 = str;
    }

    private final void A0C(boolean z) {
        this.A08 = z;
    }

    private final void A0D(boolean z) {
        this.A09 = z;
    }

    private final void A0E(boolean z) {
        this.A0A = z;
    }

    private final void A0F(boolean z) {
        this.A0B = z;
    }

    public final long A0G() {
        return this.A01;
    }

    public final NU A0H() {
        return this.A02;
    }

    public final NY A0I() {
        return this.A03;
    }

    public final C1189Nc A0J() {
        return this.A04;
    }

    public final C1190Nd A0K() {
        return this.A05;
    }

    public final String A0L() {
        return this.A06;
    }

    public final void A0M(int i) {
        this.A00.A0D(i);
        A07(this.A00.A0Q());
    }

    public final void A0N(JSONObject jSONObject) {
        A07(this.A00.A0Q());
    }

    public final void A0O(JSONObject jSONObject) {
        this.A00.A0O(jSONObject.optBoolean(A01(EventTypeExtended.EVENT_TYPE_EXTENDED_BURL_VALUE, 22, 105)));
        this.A00.A0N(jSONObject.optBoolean(A01(502, 20, 27), true));
        A07(this.A00.A0Q());
        A0R(jSONObject.optBoolean(A01(462, 14, 46)));
        A0D(jSONObject.optBoolean(A01(652, 13, 31)));
        A0E(jSONObject.optBoolean(A01(665, 20, 10)));
    }

    public final void A0P(JSONObject jSONObject) {
        this.A00.A0N(jSONObject.optBoolean(A01(502, 20, 27), true));
        A07(this.A00.A0Q());
    }

    public final void A0Q(JSONObject jSONObject) {
        this.A00.A0G(jSONObject.optInt(A01(823, 18, 107)));
        this.A00.A0N(jSONObject.optBoolean(A01(502, 20, 27), true));
        this.A00.A0P(jSONObject.optBoolean(A01(IronSourceError.ERROR_NT_LOAD_NO_CONFIG, 20, 29), false));
        A07(this.A00.A0Q());
        A0D(jSONObject.optBoolean(A01(652, 13, 31)));
    }

    public final void A0R(boolean z) {
        this.A07 = z;
    }

    public final boolean A0S() {
        return this.A07;
    }

    public final boolean A0T() {
        return this.A08;
    }

    public final boolean A0U() {
        return this.A01 > 0;
    }

    public final boolean A0V() {
        return this.A09;
    }

    public final boolean A0W() {
        return this.A0B;
    }
}
