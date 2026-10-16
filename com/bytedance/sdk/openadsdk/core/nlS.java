package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private static String DbA;
    private static String Os;
    private static boolean aGH;
    private static String eli;

    private static Context aGH(Context context) {
        return context == null ? dV.eli() : context;
    }

    public static String eli(Context context) {
        if (!TextUtils.isEmpty(eli)) {
            return eli;
        }
        MGA(context);
        return eli;
    }

    public static String DbA(Context context) {
        if (DbA == null && !aGH) {
            synchronized (nlS.class) {
                if (!aGH) {
                    ui(context);
                }
            }
        }
        return DbA;
    }

    public static String Os(Context context) {
        if (TextUtils.isEmpty(Os) && !aGH) {
            synchronized (nlS.class) {
                if (!aGH) {
                    ui(context);
                }
            }
        }
        return Os;
    }

    public static void eli(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(eli)) {
                eli = str;
            }
            eli();
        }
        if (TextUtils.isEmpty(eli)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.FC.Os.DbA(eli);
        du.eli(eli);
    }

    private static void ui(Context context) {
        if (aGH || aGH(context) == null) {
            return;
        }
        DbA = String.valueOf(Build.TIME);
        Os = Os.eli().DbA("uuid", (String) null);
        aGH = true;
    }

    private static void MGA(Context context) {
        if (aGH(context) == null) {
            return;
        }
        String DbA2 = Os.eli().DbA("abcd", (String) null);
        if (TextUtils.isEmpty(DbA2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(DbA2);
            int optInt = jSONObject.optInt("cypher", -1);
            String optString = jSONObject.optString(PglCryptUtils.KEY_MESSAGE);
            if (optInt == 3) {
                String Os2 = com.bytedance.sdk.component.utils.eli.Os(optString);
                if (TextUtils.isEmpty(Os2)) {
                    return;
                }
                eli = new JSONObject(Os2).optString("abcd");
                eli();
            }
        } catch (Throwable unused) {
        }
    }

    public static void eli() {
        if (TextUtils.isEmpty(eli)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.cyF.DbA(new com.bytedance.sdk.component.wC.wC("update_did") { // from class: com.bytedance.sdk.openadsdk.core.nlS.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", SystemClock.elapsedRealtime());
                    jSONObject.put("abcd", nlS.eli);
                    Os.eli().eli("abcd", com.bytedance.sdk.component.utils.eli.eli(jSONObject).toString());
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static String DbA() {
        try {
            Locale locale = LocaleList.getDefault().get(0);
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String locale2 = locale.toString();
            if (locale.toString().length() >= 5) {
                locale2 = locale2.substring(0, 5);
            }
            if (Locale.SIMPLIFIED_CHINESE.toString().equals(locale2)) {
                return "zh";
            }
            return "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }
}
