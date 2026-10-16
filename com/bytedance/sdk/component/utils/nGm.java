package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.Z3;

/* loaded from: classes3.dex */
public class nGm {
    public static boolean eli(Context context) {
        return Os(context) != 0;
    }

    public static int DbA(Context context) {
        int Os = Os(context);
        if (Os == 1) {
            return 0;
        }
        if (Os == 4) {
            return 1;
        }
        if (Os == 5) {
            return 4;
        }
        if (Os != 6) {
            return Os;
        }
        return 6;
    }

    public static int Os(Context context) {
        return ujq.eli(context, 60000L);
    }

    public static boolean aGH(Context context) {
        return Os(context) == 4;
    }

    public static boolean ui(Context context) {
        return Os(context) == 5;
    }

    public static boolean MGA(Context context) {
        return Os(context) == 6;
    }

    public static String kb(Context context) {
        int Os = Os(context);
        if (Os == 2) {
            return "2g";
        }
        if (Os == 3) {
            return Z3.f3155a;
        }
        if (Os == 4) {
            return Z3.b;
        }
        if (Os == 5) {
            return "4g";
        }
        if (Os == 6) {
            return "5g";
        }
        return "mobile";
    }

    public static boolean eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }

    public static boolean wC(Context context) {
        if (context == null) {
            return false;
        }
        int Os = Os(context);
        return Os == 2 || Os == 3 || Os == 4 || Os == 5 || Os == 6;
    }
}
