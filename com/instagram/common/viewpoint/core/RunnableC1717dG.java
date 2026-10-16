package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.dG, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class RunnableC1717dG implements Runnable {
    public static byte[] A02;
    public final /* synthetic */ C1720dJ A00;
    public final /* synthetic */ String A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.CR, 33, 59, 34, 42, 110, 32, 33, 58, 110, 62, 47, 60, Base64.padSymbol, 43, 110, Base64.padSymbol, 43, 60, 56, 43, 60, 110, 35, 43, Base64.padSymbol, Base64.padSymbol, 47, 41, 43, 72, Byte.MAX_VALUE, Byte.MAX_VALUE, 98, Byte.MAX_VALUE, 45, 125, 108, Byte.MAX_VALUE, 126, 100, 99, 106, 45, 71, 94, 66, 67, 45, 100, 99, 45, 125, 98, 126, 121, SignedBytes.MAX_POWER_OF_TWO, 104, 126, 126, 108, 106, 104, 45, 87, 67, 66, 94, 125, 83, 79, 53, 40, 36, 34, 49, Ascii.SI, 52, 49, 36, 49, Ascii.SO, 3, 10, Ascii.US, 58, 60};
    }

    public RunnableC1717dG(C1720dJ c1720dJ, String str) {
        this.A00 = c1720dJ;
        this.A01 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1700cz c1700cz;
        String str;
        C1700cz c1700cz2;
        if (WU.A02(this)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(this.A01);
                str = this.A00.A05;
                if (str.equals(jSONObject.optString(A00(64, 7, 87)))) {
                    this.A00.A0C(EnumC1718dH.A00(jSONObject.optString(A00(81, 4, 27))), jSONObject.optString(A00(71, 10, 49), A00(85, 2, 32)));
                } else {
                    c1700cz2 = this.A00.A04;
                    c1700cz2.A04(AbstractC1341Td.A11, A00(0, 30, 47));
                }
            } catch (JSONException e) {
                c1700cz = this.A00.A04;
                c1700cz.A04(AbstractC1341Td.A15, A00(30, 34, 108) + e.getMessage());
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
