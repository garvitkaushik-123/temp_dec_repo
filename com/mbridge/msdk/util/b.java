package com.mbridge.msdk.util;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.MBConfiguration;

/* compiled from: CommonUtils.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f4978a;
    private static volatile Boolean b;

    public static boolean a() {
        if (f4978a == null) {
            try {
                Boolean valueOf = Boolean.valueOf(Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2);
                f4978a = valueOf;
                return valueOf.booleanValue();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonUtils", "isChina", e);
                }
            }
        }
        return f4978a != null && f4978a.booleanValue();
    }

    public static boolean b() {
        if (b == null) {
            try {
                Boolean valueOf = Boolean.valueOf(Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1);
                b = valueOf;
                return valueOf.booleanValue();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("CommonUtils", "isOversea", e);
                }
            }
        }
        return b != null && b.booleanValue();
    }
}
