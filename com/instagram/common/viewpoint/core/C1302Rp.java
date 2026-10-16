package com.instagram.common.viewpoint.core;

import android.app.Activity;
import android.content.Context;

/* renamed from: com.facebook.ads.redexgen.X.Rp, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C1302Rp {
    public static String[] A00 = {"9O", "28H1kjICyCSP", "QKFmg3qmSW84YfLR5DXewrEtWZ47Hzy", "P", "Em", "YyES7HR0UsWs", "rGxFrAuyTsOha0QpVFZkpdTTHXBTZM0k", "CeAnScf1I32vhT13KQ6XZJy"};

    public static InterfaceC1155Lt A00(Context context, TA ta) {
        return A01(context, ta, null);
    }

    public static InterfaceC1155Lt A01(Context context, TA ta, String str) {
        C1925ge sdkContext = A09(context);
        InterfaceC1159Lx A8C = ta.A8C(sdkContext);
        if (A8C != null) {
            return str != null ? A8C.ACN(str) : A8C.ACM();
        }
        return new C2149kX();
    }

    public static C1929gi A02(Activity activity) {
        return new C1929gi(activity, (TA) A0A(), A00(activity, A0A()));
    }

    public static C1929gi A03(Context context) {
        return new C1929gi(context, A0A(), new C2149kX());
    }

    public static C1929gi A04(Context context) {
        if (C1379Up.A0w(context)) {
            return new C1929gi(context, A0A(), A00(context, A0A()));
        }
        C1929gi A03 = A03(context);
        if (A00[2].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "B";
        strArr[7] = "J1bgC2YpAkuTguvKBul5HQJ";
        return A03;
    }

    public static C1929gi A05(Context context, String str) {
        InterfaceC1155Lt A01 = A01(context, A0A(), str);
        A01.AJT(1000);
        return new C1929gi(context, A0A(), A01);
    }

    public static C1929gi A06(Context context, String str) {
        return new C1929gi(context, A0A(), A01(context, A0A(), str));
    }

    public static C1929gi A07(Context context, String str) {
        return new C1929gi(context, A0A(), A01(context, A0A(), str));
    }

    public static AnonymousClass76 A08(Context context) {
        return new AnonymousClass76(context, A0A(), A0A().A8C(A09(context)));
    }

    public static C1925ge A09(Context context) {
        return new C1925ge(context, A0A());
    }

    public static synchronized ZR A0A() {
        ZR A02;
        synchronized (C1302Rp.class) {
            A02 = ZR.A02();
        }
        return A02;
    }
}
