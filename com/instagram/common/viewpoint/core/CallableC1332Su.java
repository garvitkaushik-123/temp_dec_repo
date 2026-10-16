package com.instagram.common.viewpoint.core;

import android.net.TrafficStats;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.Su, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class CallableC1332Su implements Callable<Boolean> {
    public static byte[] A02;
    public final C1331St A00;
    public final /* synthetic */ C1335Sx A01;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 41);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-34, -46, -29, -36, -26, -31, -25, -38, -43, -42, -32};
    }

    public CallableC1332Su(C1335Sx c1335Sx, C1331St c1331St) {
        this.A01 = c1335Sx;
        this.A00 = c1331St;
    }

    private final Boolean A00() {
        String A01;
        T8 t8;
        T8 t82;
        LR A03;
        Map map;
        if (WU.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            if (this.A00.A04) {
                A01 = A01(0, 6, 72);
            } else {
                A01 = A01(6, 5, 72);
            }
            String str = this.A00.A08;
            String creativeType = this.A00.A07;
            LX lx = new LX(str, creativeType, this.A00.A06, A01, this.A00.A02, this.A00.A05);
            lx.A04 = this.A00.A03;
            lx.A02 = this.A00.A01;
            lx.A05 = this.A00.A04;
            t8 = this.A01.A04;
            if (T0.A06(t8)) {
                map = C1335Sx.A0F;
                map.put(this.A00.A08, lx);
            }
            t82 = this.A01.A04;
            A03 = C1335Sx.A03(t82.A02());
            return Boolean.valueOf(A03.AIg(lx) != null);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
        if (WU.A02(this)) {
            return null;
        }
        try {
            return A00();
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }
}
