package com.instagram.common.viewpoint.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.dD, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1714dD {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C1713dC>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C1713dC>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C1713dC A01(C1929gi c1929gi, AbstractC2094jd abstractC2094jd, int i, InterfaceC1711dA interfaceC1711dA) {
        C1713dC c1713dC = new C1713dC(c1929gi, abstractC2094jd, c1929gi.A02().A0A(), i);
        c1713dC.A0b(interfaceC1711dA);
        c1713dC.A0X();
        A01.put(abstractC2094jd.A1D(), new WeakReference<>(c1713dC));
        return c1713dC;
    }

    public static C1713dC A02(String str) {
        WeakReference<C1713dC> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC2094jd abstractC2094jd, C1713dC c1713dC) {
        A01.put(abstractC2094jd.A1D(), new WeakReference<>(c1713dC));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}
