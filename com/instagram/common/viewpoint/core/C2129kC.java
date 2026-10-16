package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.kC, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C2129kC extends AbstractRunnableC1416Wc {
    public static byte[] A02;
    public final /* synthetic */ N8 A00;
    public final /* synthetic */ JSONObject A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{117, 97, 118, 98, 102, 118, 125, 112, 106, 76, 112, 114, 99, 99, 122, 125, 116};
    }

    public C2129kC(N8 n8, JSONObject jSONObject) {
        this.A00 = n8;
        this.A01 = jSONObject;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        T8 t8;
        T8 t82;
        CountDownLatch countDownLatch;
        N7 n7;
        N7 n72;
        CountDownLatch countDownLatch2;
        try {
            countDownLatch = this.A00.A05;
            countDownLatch.await();
            n7 = this.A00.A02;
            synchronized (n7) {
                n72 = this.A00.A02;
                n72.A0B(this.A01);
                countDownLatch2 = this.A00.A06;
                countDownLatch2.countDown();
            }
        } catch (InterruptedException e) {
            t82 = this.A00.A03;
            t82.A08().ABC(A00(0, 17, 25), AbstractC1341Td.A1B, new C1342Te(e));
        } catch (JSONException e2) {
            this.A00.A0M();
            t8 = this.A00.A03;
            t8.A08().ABC(A00(0, 17, 25), AbstractC1341Td.A1A, new C1342Te(e2));
        }
    }
}
