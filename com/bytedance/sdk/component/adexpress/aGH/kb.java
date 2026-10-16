package com.bytedance.sdk.component.adexpress.aGH;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.ev;
import java.util.Locale;

/* loaded from: classes3.dex */
public class kb {
    public static int eli(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float eli(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().DbA();
        }
        return (f * aGH(context)) + 0.5f;
    }

    public static int DbA(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().DbA();
        }
        float aGH = aGH(context);
        if (aGH <= 0.0f) {
            aGH = 1.0f;
        }
        return (int) ((f / aGH) + 0.5f);
    }

    public static float Os(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().DbA();
        }
        return f * aGH(context);
    }

    private static float aGH(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int eli(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().DbA();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int DbA(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().DbA();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String Os(Context context) {
        String str;
        try {
            Locale locale = ev.DbA(context).getConfiguration().getLocales().get(0);
            str = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    str = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str = "";
        }
        return eli(str);
    }

    private static String eli(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
