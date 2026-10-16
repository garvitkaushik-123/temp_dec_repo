package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.Wh, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1421Wh {
    public static String[] A01 = {"0TBfSTrFZZIPTbjcv3YvZ5KQe5wh6M4Z", "Y", "skEIHJjGP8F0E9LHs3c03M6jOmkdnZrb", "lNiM6G1VkMzjPhI0VWbHd", "xoZoqEy9j11lJxTnOEXOmkmQN9dBXrj3", "0lNV7cA9G3CxYQK", "ZSiJ5Be21P36sCEypxWEkyax05PjjigP", "3dFveWP5h629GmfNhsyVO5v38YfKmNKK"};
    public static final ThreadLocal<C1421Wh> A02 = new ThreadLocal<>();
    public final WQ A00 = new WQ();

    public static WQ A00() {
        return A02().A00;
    }

    public static WQ A01(C1420Wg c1420Wg) {
        WQ currentStackTraces = new WQ(A00());
        currentStackTraces.add(c1420Wg);
        return currentStackTraces;
    }

    public static C1421Wh A02() {
        C1421Wh c1421Wh = A02.get();
        if (c1421Wh == null) {
            C1421Wh c1421Wh2 = new C1421Wh();
            A02.set(c1421Wh2);
            return c1421Wh2;
        }
        return c1421Wh;
    }

    public static void A03(AbstractRunnableC1416Wc abstractRunnableC1416Wc) {
        WQ A06 = abstractRunnableC1416Wc.A06();
        if (A06 != null) {
            WQ createRunnableAsyncStackTrace = A02().A00;
            createRunnableAsyncStackTrace.addAll(A06);
        }
    }

    public static void A04(AbstractRunnableC1416Wc abstractRunnableC1416Wc) {
        WQ A06 = abstractRunnableC1416Wc.A06();
        if (A06 != null) {
            WQ wq = A02().A00;
            String[] strArr = A01;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[0] = "6tfOksRsBjIBNQljvPHCCYkD1Hr87lb7";
            wq.removeAll(A06);
        }
    }
}
