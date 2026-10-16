package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.dV;

/* loaded from: classes3.dex */
public class aGH {
    public static String eli = "com.bytedance.openadsdk";
    public static String DbA = "content://" + eli + ".TTMultiProvider";

    static {
        eli();
    }

    public static void eli() {
        if (dV.eli() != null) {
            eli = dV.eli().getPackageName();
            DbA = "content://" + eli + ".TTMultiProvider";
        }
    }
}
