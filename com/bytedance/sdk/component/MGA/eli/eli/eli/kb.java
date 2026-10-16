package com.bytedance.sdk.component.MGA.eli.eli.eli;

import com.bytedance.sdk.component.MGA.eli.wC;

/* loaded from: classes3.dex */
public class kb {
    public static String eli = "com.bytedance.openadsdk";
    public static String DbA = "content://" + eli + ".TTMultiProvider";

    static {
        eli();
    }

    public static void eli() {
        if (wC.kb().MGA() != null) {
            eli = wC.kb().MGA().getPackageName();
            DbA = "content://" + eli + ".TTMultiProvider";
        }
    }
}
