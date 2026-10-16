package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.facebook.ads.redexgen.X.Sw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class CallableC1334Sw implements Callable<Boolean> {
    public static byte[] A02;
    public final C1333Sv A00;
    public final /* synthetic */ C1335Sx A01;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 2);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-35, -31, -43, -37, -39};
    }

    public CallableC1334Sw(C1335Sx c1335Sx, C1333Sv c1333Sv) {
        this.A01 = c1335Sx;
        this.A00 = c1333Sv;
    }

    private final Boolean A00() {
        T8 t8;
        boolean z;
        C1336Sy c1336Sy;
        boolean z2;
        boolean z3;
        T8 t82;
        LR A03;
        Map map;
        if (WU.A02(this)) {
            return null;
        }
        try {
            TrafficStats.setThreadStatsTag(61453);
            LX lx = new LX(this.A00.A08, this.A00.A07, this.A00.A06, A01(0, 5, 114), this.A00.A02, this.A00.A03);
            lx.A01 = this.A00.A05;
            lx.A00 = this.A00.A04;
            t8 = this.A01.A04;
            if (T0.A06(t8)) {
                map = C1335Sx.A0F;
                map.put(this.A00.A08, lx);
            }
            z = this.A01.A08;
            boolean precacheResult = false;
            if (!z) {
                c1336Sy = this.A01.A03;
                if (c1336Sy.A0F(this.A00) != null) {
                    precacheResult = true;
                }
            } else {
                t82 = this.A01.A04;
                A03 = C1335Sx.A03(t82.A02());
                precacheResult = A03.AIe(lx, false).A01();
            }
            T3 t3 = this.A00.A01;
            if (t3 != null && t3.A02()) {
                int A00 = t3.A00();
                int A01 = t3.A01();
                if (A00 <= 0 || A01 <= 0) {
                    z2 = this.A01.A08;
                    if (z2) {
                        A04(this.A00.A08, lx);
                    } else {
                        A03(this.A00.A04, this.A00.A05);
                    }
                } else {
                    z3 = this.A01.A08;
                    if (z3) {
                        lx.A00 = A00;
                        lx.A01 = A01;
                        A04(this.A00.A08, lx);
                    } else {
                        A03(A00, A01);
                    }
                }
            }
            return Boolean.valueOf(precacheResult);
        } catch (Throwable th) {
            WU.A00(th, this);
            return null;
        }
    }

    private void A03(int i, int i2) {
        C1336Sy c1336Sy;
        T8 t8;
        Map map;
        c1336Sy = this.A01.A03;
        t8 = this.A01.A04;
        Bitmap A0G = c1336Sy.A0G(t8, this.A00.A08, i, i2, this.A00.A02);
        if (A0G == null) {
            return;
        }
        map = this.A01.A07;
        map.put(this.A00.A08, A0G);
    }

    private void A04(String str, LX lx) {
        T8 t8;
        LR A03;
        Map map;
        t8 = this.A01.A04;
        A03 = C1335Sx.A03(t8.A02());
        Bitmap A00 = A03.AIe(lx, true).A00();
        if (A00 == null) {
            return;
        }
        map = this.A01.A07;
        map.put(str, A00);
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
