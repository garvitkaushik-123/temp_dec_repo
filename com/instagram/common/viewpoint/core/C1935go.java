package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.go, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1935go extends AbstractRunnableC1416Wc {
    public static byte[] A02;
    public final /* synthetic */ C1934gn A00;
    public final /* synthetic */ AtomicBoolean A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 78);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{Ascii.SO, 44, 46, 51, 48, -21, 49, 44, 52, 55, -7, -110, -80, -78, -73, -76, 111, -62, -60, -78, -78, -76, -62, -62, 125};
    }

    public C1935go(C1934gn c1934gn, AtomicBoolean atomicBoolean) {
        this.A00 = c1934gn;
        this.A01 = atomicBoolean;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1416Wc
    public final void A07() {
        T8 t8;
        long j;
        T8 t82;
        long j2;
        if (this.A00.A00 != null) {
            if (this.A01.get()) {
                this.A00.A02.A0I(VH.A0H);
                t82 = this.A00.A02.A04;
                C1328Sq c1328Sq = this.A00.A01;
                int i = T0.A00;
                j2 = this.A00.A02.A00;
                T0.A02(t82, c1328Sq, i, A00(11, 14, 1), j2);
                this.A00.A02.A0U();
                this.A00.A00.ADT();
                return;
            }
            this.A00.A02.A0I(VH.A0G);
            t8 = this.A00.A02.A04;
            C1328Sq c1328Sq2 = this.A00.A01;
            int i2 = T0.A04;
            j = this.A00.A02.A00;
            T0.A02(t8, c1328Sq2, i2, A00(0, 11, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), j);
            this.A00.A02.A0V();
            this.A00.A00.ADL();
        }
    }
}
