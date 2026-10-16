package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* compiled from: SDKAuthorityController.java */
/* loaded from: classes6.dex */
public class c extends b {
    private static volatile c j;

    private c() {
        h();
    }

    public static void c(boolean z) {
    }

    public static boolean l() {
        return true;
    }

    public static c m() {
        if (j == null) {
            synchronized (c.class) {
                if (j == null) {
                    j = new c();
                }
            }
        }
        return j;
    }

    @Override // com.mbridge.msdk.foundation.controller.authoritycontroller.b
    public int a(g gVar, String str) {
        if (gVar == null) {
            gVar = h.b().a();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return gVar.t0();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return gVar.s0();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return gVar.u0();
        }
        return -1;
    }

    public boolean c(String str) {
        boolean z;
        g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d == null) {
            d = h.b().a();
            z = true;
        } else {
            z = false;
        }
        int h0 = d.h0();
        boolean z2 = h0 != 0 ? h0 == 1 && a(d, str) == 1 : a(str) == 1 && a(d, str) == 1;
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z2 = a(str) == 1;
        }
        return (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) && m().e() == 2) ? (d.E0() || z || a(str) != 1) ? false : true : z2;
    }
}
