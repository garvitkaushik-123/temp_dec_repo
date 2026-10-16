package com.bytedance.sdk.openadsdk.aGH;

import android.app.ActivityManager;
import android.os.Build;
import com.bytedance.sdk.component.utils.Xb;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    private static Class<?> DbA = null;
    private static Method Os = null;
    private static Method aGH = null;
    private static Method eli = null;
    private static boolean ui = false;

    static {
        DbA();
    }

    private static void DbA() {
        if (ui || Build.VERSION.SDK_INT < 35) {
            return;
        }
        try {
            if (Os()) {
                eli = ActivityManager.class.getMethod("getHistoricalProcessStartReasons", Integer.TYPE);
                Class<?> cls = Class.forName("android.app.ApplicationStartInfo");
                DbA = cls;
                aGH = cls.getMethod("getReason", new Class[0]);
                if (Build.VERSION.SDK_INT >= 36) {
                    Os = DbA.getMethod("getStartComponent", new Class[0]);
                }
                ui = true;
            }
        } catch (Throwable th) {
            Xb.Os(th.getMessage(), new Object[0]);
        }
    }

    private static boolean Os() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("s_i_e", 0) == 1;
    }

    public static JSONObject eli() {
        Throwable th;
        JSONObject jSONObject;
        Method method;
        List list;
        Method method2;
        Method method3;
        if (Build.VERSION.SDK_INT < 35 || !Os()) {
            return null;
        }
        DbA();
        try {
            jSONObject = new JSONObject();
            try {
                ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService(ActivityManager.class);
                if (activityManager != null && (method = eli) != null && (list = (List) method.invoke(activityManager, 1)) != null && !list.isEmpty()) {
                    Object obj = list.get(0);
                    if (Build.VERSION.SDK_INT >= 36 && obj != null && (method3 = Os) != null) {
                        jSONObject.put("start_component", ((Integer) method3.invoke(obj, new Object[0])).intValue());
                    }
                    if (obj != null && (method2 = aGH) != null) {
                        jSONObject.put("start_reason", ((Integer) method2.invoke(obj, new Object[0])).intValue());
                    }
                }
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                Xb.Os(th.getMessage(), new Object[0]);
                return jSONObject;
            }
        } catch (Throwable th3) {
            th = th3;
            jSONObject = null;
        }
    }
}
