package com.instagram.common.viewpoint.core;

import android.net.Uri;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* renamed from: com.facebook.ads.redexgen.X.kE, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2131kE extends AbstractC1181Mt {
    public static byte[] A01;
    public static final String A02;
    public final Uri A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Ascii.DLE, 43, 51, 54, 47, 46, -22, 62, 57, -22, 57, 58, 47, 56, -22, 54, 51, 56, 53, -22, 63, 60, 54, 4, -22};
    }

    static {
        A01();
        A02 = C2131kE.class.getSimpleName();
    }

    public C2131kE(C1929gi c1929gi, VA va, String str, Uri uri) {
        super(c1929gi, va, str);
        this.A00 = uri;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1181Mt
    public final EnumC1178Mq A0G(String str) {
        try {
            X6.A0E(new X6(), this.A01, this.A00, this.A03);
        } catch (Exception unused) {
            String str2 = A00(0, 25, 104) + this.A00.toString();
        }
        return EnumC1178Mq.A09;
    }
}
