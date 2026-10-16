package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes3.dex */
public final class ev {
    private static String DbA = null;
    private static boolean MGA = false;
    private static Resources Os = null;
    private static String aGH = null;
    private static Context eli = null;
    private static boolean ui = false;

    public static void eli(Context context) {
        eli = context;
    }

    public static void eli(String str) {
        aGH = str;
    }

    private static String aGH(Context context) {
        if (aGH == null) {
            aGH = context.getPackageName();
        }
        return aGH;
    }

    private static int eli(Context context, String str, String str2) {
        int identifier = DbA(context).getIdentifier(str, str2, aGH(context));
        if (identifier != 0) {
            return identifier;
        }
        if (!ui) {
            Os(context);
            return DbA(context).getIdentifier(str, str2, aGH(context));
        }
        return context.getResources().getIdentifier(str, str2, aGH(context));
    }

    public static String eli(Context context, String str) {
        return DbA(context).getString(DbA(context, str));
    }

    public static int DbA(Context context, String str) {
        return eli(context, str, "string");
    }

    public static Drawable Os(Context context, String str) {
        try {
            return DbA(context).getDrawable(aGH(context, str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int aGH(Context context, String str) {
        try {
            return eli(context, str, "drawable");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int ui(Context context, String str) {
        return eli(context, str, "id");
    }

    public static int MGA(Context context, String str) {
        return eli(context, str, "style");
    }

    public static int kb(Context context, String str) {
        return DbA(context).getColor(wC(context, str));
    }

    public static int wC(Context context, String str) {
        return eli(context, str, "color");
    }

    public static int FC(Context context, String str) {
        return eli(context, str, "anim");
    }

    public static Resources DbA(Context context) {
        Resources resources = Os;
        if (resources == null) {
            resources = null;
        }
        Context context2 = eli;
        if (context2 != null) {
            resources = context2.getResources();
        }
        return resources == null ? context.getResources() : resources;
    }

    public static synchronized void Os(Context context) {
        synchronized (ev.class) {
            try {
                if (TextUtils.isEmpty(DbA)) {
                    return;
                }
                ui = true;
            } catch (Throwable th) {
                Log.e("ResourceHelp", "makePluginResources failed", th);
            }
        }
    }
}
