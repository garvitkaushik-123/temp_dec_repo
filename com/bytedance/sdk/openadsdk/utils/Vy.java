package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.ironsource.Z3;

/* loaded from: classes3.dex */
public class Vy {
    public static String eli(Context context) {
        int eli = com.bytedance.sdk.component.utils.ujq.eli(context, 0L);
        if (eli == 2) {
            return "2g";
        }
        if (eli == 3) {
            return Z3.f3155a;
        }
        if (eli == 4) {
            return Z3.b;
        }
        if (eli == 5) {
            return "4g";
        }
        if (eli == 6) {
            return "5g";
        }
        return "mobile";
    }
}
