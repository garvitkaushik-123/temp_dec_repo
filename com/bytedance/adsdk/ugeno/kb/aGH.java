package com.bytedance.adsdk.ugeno.kb;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: classes3.dex */
public final class aGH {
    private static Resources DbA;
    private static Context Os;
    private static String eli;

    public static void eli(String str) {
        eli = str;
    }

    private static String eli(Context context) {
        if (eli == null) {
            eli = context.getPackageName();
        }
        return eli;
    }

    private static int eli(Context context, String str, String str2) {
        if (DbA == null) {
            DbA = context.getResources();
        }
        return DbA.getIdentifier(str, str2, eli(context));
    }

    public static int eli(Context context, String str) {
        return eli(context, str, "raw");
    }

    public static int DbA(Context context, String str) {
        return eli(context, str, "drawable");
    }
}
