package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/kotlin/compilerplugins/dataclassgenerate/annotation/Mode;", "", "(Ljava/lang/String;I)V", "KEEP", "OMIT", "fbandroid.java.com.facebook.kotlin.compilerplugins.dataclassgenerate.annotation.dataclassgenerate-annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.iK, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public enum EnumC2025iK {
    A03,
    A04;

    public static byte[] A00;
    public static final /* synthetic */ InterfaceC0859Ac A01;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 68);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-84, -90, -90, -79, -64, -66, -70, -59};
    }

    static {
        A01();
        A01 = AbstractC2506qd.A01(A02);
    }
}
