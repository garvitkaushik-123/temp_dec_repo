package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.dto.AdCookieData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.Tx, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1361Tx {
    public static byte[] A0F;
    public static final AdPlacementType A0G;
    public static final String A0H;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public int A09;
    public int A0A;
    public AdPlacementType A0B;
    public boolean A0D;

    @Nullable
    public List<AdCookieData> A0C = null;
    public final long A0E = System.currentTimeMillis();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public C1361Tx(Map<String, String> map) {
        char c;
        this.A01 = -1;
        this.A00 = -1;
        this.A0B = A0G;
        this.A03 = 1;
        this.A0A = 0;
        this.A04 = 0;
        this.A05 = 20;
        this.A08 = 0;
        this.A09 = 1000;
        this.A06 = 10000;
        this.A07 = 200;
        this.A02 = 3600;
        this.A0D = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            switch (key.hashCode()) {
                case -1561601017:
                    if (key.equals(A01(105, 17, 37))) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -856794442:
                    if (key.equals(A01(199, 26, 14))) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case -726276175:
                    if (key.equals(A01(Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, 15, 32))) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -634541425:
                    if (key.equals(A01(9, 32, 26))) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -553208868:
                    if (key.equals(A01(0, 9, 14))) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 3575610:
                    if (key.equals(A01(Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, 4, 34))) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 700812481:
                    if (key.equals(A01(41, 26, 71))) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 858630459:
                    if (key.equals(A01(Sdk.SDKError.Reason.BIDPAYLOAD_PLACEMENT_ID_MISMATCH_ERROR_VALUE, 24, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE))) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 986744879:
                    if (key.equals(A01(ModuleDescriptor.MODULE_VERSION, 27, 79))) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1085444827:
                    if (key.equals(A01(98, 7, 46))) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1183549815:
                    if (key.equals(A01(168, 31, 41))) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case 1503616961:
                    if (key.equals(A01(67, 16, 88))) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case 2002133996:
                    if (key.equals(A01(83, 15, 52))) {
                        c = 7;
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
                    this.A0B = AdPlacementType.fromString(entry.getValue());
                    break;
                case 1:
                    this.A03 = Integer.parseInt(entry.getValue());
                    break;
                case 2:
                    this.A0A = Integer.parseInt(entry.getValue());
                    break;
                case 3:
                    this.A04 = Integer.parseInt(entry.getValue());
                    break;
                case 4:
                    this.A05 = Integer.parseInt(entry.getValue());
                    break;
                case 5:
                    this.A02 = Integer.parseInt(entry.getValue());
                    break;
                case 6:
                    this.A0D = Boolean.valueOf(entry.getValue()).booleanValue();
                    break;
                case 7:
                    this.A01 = Integer.parseInt(entry.getValue());
                    break;
                case '\b':
                    this.A00 = Integer.parseInt(entry.getValue());
                    break;
                case '\t':
                    this.A08 = Integer.parseInt(entry.getValue());
                    break;
                case '\n':
                    this.A09 = Integer.parseInt(entry.getValue());
                    break;
                case 11:
                    this.A06 = Integer.parseInt(entry.getValue());
                    break;
                case '\f':
                    try {
                        this.A07 = Integer.parseInt(entry.getValue());
                        break;
                    } catch (NumberFormatException unused) {
                        this.A07 = 200;
                        break;
                    }
            }
        }
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 46);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0F = new byte[]{67, 65, 67, 72, 69, 65, 66, 76, 69, 93, 90, 66, 85, 88, 93, 80, 85, SignedBytes.MAX_POWER_OF_TWO, 93, 91, 90, 107, 80, 65, 70, 85, SignedBytes.MAX_POWER_OF_TWO, 93, 91, 90, 107, 93, 90, 107, 71, 81, 87, 91, 90, 80, 71, 4, 0, 7, 54, Ascii.US, 0, Ascii.FF, Ascii.RS, 8, Ascii.VT, 0, 5, 0, Ascii.GS, Ascii.DLE, 54, Ascii.EM, Ascii.FF, Ascii.ESC, 10, Ascii.FF, 7, Ascii.GS, 8, Ascii.SO, Ascii.FF, 6, Ascii.SUB, Ascii.ETB, Ascii.NAK, 19, Ascii.ESC, 19, Ascii.CAN, 2, 41, Ascii.RS, 19, Ascii.US, 17, Ascii.RS, 2, 106, 118, 123, 121, Byte.MAX_VALUE, 119, Byte.MAX_VALUE, 116, 110, 69, 109, 115, 126, 110, 114, 114, 101, 102, 114, 101, 115, 104, 121, 110, 109, 121, 110, 120, 99, 84, Byte.MAX_VALUE, 99, 121, 110, 120, 99, 100, 103, 111, 124, 107, Byte.MAX_VALUE, 123, 107, 125, 122, 81, 122, 103, 99, 107, 97, 123, 122, 120, 117, 124, 105, Ascii.ETB, 8, 5, 4, Ascii.SO, 62, Ascii.NAK, 8, Ascii.FF, 4, 62, 17, Ascii.SO, Ascii.CR, Ascii.CR, 8, Ascii.SI, 6, 62, 8, Ascii.SI, Ascii.NAK, 4, 19, Ascii.ETB, 0, Ascii.CR, 113, 110, 98, 112, 102, 101, 110, 107, 110, 115, 126, 88, 100, 111, 98, 100, 108, 88, 110, 105, 110, 115, 110, 102, 107, 88, 99, 98, 107, 102, 126, 86, 73, 69, 87, 65, 66, 73, 76, 73, 84, 89, Byte.MAX_VALUE, 67, 72, 69, 67, 75, Byte.MAX_VALUE, 73, 78, 84, 69, 82, 86, 65, 76, 47, 48, 60, 46, 56, 59, 48, 53, 48, 45, 32, 6, 58, 49, 60, 58, 50, 6, 45, 48, 58, 50, 60, 43};
    }

    static {
        A02();
        A0H = C1361Tx.class.getSimpleName();
        A0G = AdPlacementType.UNKNOWN;
    }

    @Nullable
    public static C1361Tx A00(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return new C1361Tx(hashMap);
    }

    public final int A03() {
        return this.A02 * 1000;
    }

    public final int A04() {
        return this.A03;
    }

    public final int A05() {
        return this.A06;
    }

    public final int A06() {
        return this.A07;
    }

    public final int A07() {
        return this.A08;
    }

    public final int A08() {
        return this.A09;
    }

    public final int A09() {
        return this.A0A;
    }

    public final long A0A() {
        return this.A04 * 1000;
    }

    public final long A0B() {
        return this.A05 * 1000;
    }

    public final long A0C() {
        return this.A0E;
    }

    public final AdPlacementType A0D() {
        return this.A0B;
    }

    public final boolean A0E() {
        return this.A0D;
    }
}
