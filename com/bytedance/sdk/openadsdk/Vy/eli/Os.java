package com.bytedance.sdk.openadsdk.Vy.eli;

import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class Os {
    public static int DbA = 6;
    public static String Os = "engaged_view";
    public static boolean eli = false;

    public static void eli(ev evVar) {
        DbA Os2 = Os(evVar);
        if (Os2 == null) {
            return;
        }
        Os2.eli();
    }

    public static void DbA(ev evVar) {
        DbA Os2 = Os(evVar);
        if (Os2 == null) {
            return;
        }
        Os2.DbA();
    }

    public static void eli(ev evVar, int i) {
        DbA Os2 = Os(evVar);
        if (Os2 == null || Os2.Os()) {
            return;
        }
        Os2.eli(i);
    }

    public static void eli(ev evVar, boolean z) {
        DbA Os2 = Os(evVar);
        if (Os2 == null || Os2.Os()) {
            return;
        }
        Os2.eli(z);
        Os2.eli(z ? 4 : 8);
    }

    private static DbA Os(ev evVar) {
        if (evVar == null || !evVar.VR()) {
            return null;
        }
        return evVar.mV();
    }
}
