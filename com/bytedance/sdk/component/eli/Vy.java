package com.bytedance.sdk.component.eli;

import android.text.TextUtils;

/* loaded from: classes3.dex */
class Vy {
    private static boolean eli;

    static String eli(Throwable th) {
        return "{\"code\":" + (th instanceof nGm ? ((nGm) th).eli : 0) + "}";
    }

    static String eli(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        if (!eli) {
            str2 = "";
        } else {
            str2 = str.substring(1, str.length() - 1);
        }
        String concat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (!str2.isEmpty()) {
            return concat + "," + str2 + "}";
        }
        return concat + "}";
    }

    static String eli() {
        return "";
    }

    static void eli(boolean z) {
        eli = z;
    }
}
