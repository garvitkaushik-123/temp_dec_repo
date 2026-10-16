package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Ng, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1193Ng implements Serializable {
    public static byte[] A05 = null;
    public static final long serialVersionUID = 238472947123L;
    public int A00;
    public String A01;
    public String A02;
    public String A03;
    public boolean A04;

    static {
        A05();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C1193Ng A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(A04(0, 6, 78));
        String optString2 = jSONObject.optString(A04(36, 8, 81));
        String optString3 = jSONObject.optString(A04(24, 12, 84));
        int optInt = jSONObject.optInt(A04(44, 14, 5), -1);
        boolean optBoolean = jSONObject.optBoolean(A04(6, 18, 35), false);
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3) || optInt == -1) {
            return null;
        }
        return new C1193Ng(optString, optString2, optString3, optInt, optBoolean);
    }

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) + RangingPosition.RSSI_MIN);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{46, Base64.padSymbol, Base64.padSymbol, 44, 54, 49, 8, 3, Ascii.SO, Ascii.SO, 4, 3, 5, Ascii.CR, 1, Ascii.VT, Ascii.DLE, Ascii.NAK, Ascii.SYN, 3, 9, Ascii.DC4, 3, Ascii.SI, 67, 52, 54, 62, 52, 58, 56, 50, 65, 52, SignedBytes.MAX_POWER_OF_TWO, 56, 66, 53, 54, 53, 66, 66, 53, 66, -10, -23, -12, -13, -10, -8, -19, -14, -21, -29, -15, -13, -24, -23};
    }

    public C1193Ng(String str, String str2, String str3, int i, boolean z) {
        this.A01 = str;
        this.A03 = str2;
        this.A02 = str3;
        this.A00 = i;
        this.A04 = z;
    }

    private final String A01() {
        return this.A01;
    }

    private final String A02() {
        return this.A02;
    }

    private final String A03() {
        return this.A03;
    }

    public static void A06(C1193Ng c1193Ng, C1929gi c1929gi) {
        if (c1193Ng != null && c1193Ng.A09()) {
            new W6(c1929gi).A04(true, c1193Ng.A01(), c1193Ng.A03(), c1193Ng.A02(), System.currentTimeMillis(), c1193Ng.A08());
        }
    }

    public static void A07(C1193Ng c1193Ng, C1929gi c1929gi) {
        if (c1193Ng != null && c1193Ng.A0A()) {
            new W6(c1929gi).A04(false, c1193Ng.A01(), c1193Ng.A03(), c1193Ng.A02(), System.currentTimeMillis(), c1193Ng.A08());
        }
    }

    private final boolean A08() {
        return this.A04;
    }

    private final boolean A09() {
        return (this.A00 & 2) != 0;
    }

    private final boolean A0A() {
        return (this.A00 & 1) != 0;
    }
}
