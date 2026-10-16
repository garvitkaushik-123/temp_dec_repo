package com.instagram.common.viewpoint.core;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: assets/audience_network/classes2.dex */
public class JT implements InterfaceC1704d3 {
    public static byte[] A01;
    public static String[] A02 = {"6Ak70sx20HAu1BK2okLsJl8UIfFL7Thw", "WSdr2bwsModx8vqlXsCh2pEoV44R6fWS", "6pV", "IuCwGgbRSGcwid05Jmd", "uJw8pmawU", "I8uJtZilJAfxYDsx8vrQS9VBJj4oHqwc", "yyzynLMQXuMe1chn921CH2O0saed", "KEJISc72f74GCBhZaRDCVEoQGHcnATpn"};
    public final /* synthetic */ AnonymousClass66 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A02;
            if (strArr[7].charAt(3) == strArr[1].charAt(3)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[3] = "LF603a9wKS17yr1vDnM";
            strArr2[4] = "LZWmWJ2r4";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 113);
            i4++;
        }
    }

    public static void A01() {
        byte[] bArr = {92, SignedBytes.MAX_POWER_OF_TWO, 77, 85};
        String[] strArr = A02;
        if (strArr[7].charAt(3) == strArr[1].charAt(3)) {
            throw new RuntimeException();
        }
        A02[5] = "ka1vQ6UiXKbqG0foqwxWJkzjeHAuiIwi";
        A01 = bArr;
    }

    static {
        A01();
    }

    public JT(AnonymousClass66 anonymousClass66) {
        this.A00 = anonymousClass66;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1704d3
    public final void AGR(String str, JSONObject jSONObject) {
        C1713dC c1713dC;
        C1929gi c1929gi;
        C1929gi c1929gi2;
        if (str.equals(A00(0, 4, 93))) {
            this.A00.AKD();
            c1929gi = this.A00.A07;
            if (C1379Up.A1z(c1929gi)) {
                c1929gi2 = this.A00.A07;
                c1929gi2.A0B().ADb();
            }
        }
        c1713dC = this.A00.A0F;
        if (A02[5].charAt(30) != 'w') {
            throw new RuntimeException();
        }
        A02[5] = "i1qJJe2Rv2sTY7cj85c4P5DDFviddUwN";
        c1713dC.A0h(str, jSONObject);
    }
}
