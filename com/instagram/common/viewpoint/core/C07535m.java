package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import com.google.common.base.Ascii;
import java.util.Arrays;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.5m, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C07535m extends E8 {
    public static byte[] A01;
    public final /* synthetic */ C1705d4 A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{19, 4, 4, Ascii.EM, 4};
    }

    public C07535m(C1705d4 c1705d4) {
        this.A00 = c1705d4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.UN
    /* renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final void A03(E9 e9) {
        InterfaceC1704d3 interfaceC1704d3;
        JSONObject A03;
        new Handler(Looper.getMainLooper()).post(new RunnableC1703d2(this));
        interfaceC1704d3 = this.A00.A0B;
        A03 = this.A00.A03();
        interfaceC1704d3.AGR(A00(0, 5, 126), A03);
    }
}
