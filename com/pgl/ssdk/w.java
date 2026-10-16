package com.pgl.ssdk;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes6.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static String f6412a;
    private static long[][] b;
    private static String c;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(w.c)) {
                String unused = w.c = w.d();
                x0.b(z.b(), "romtype", w.c);
            }
        }
    }

    public static JSONArray[] c(Context context) {
        if (b == null) {
            b = (long[][]) com.pgl.ssdk.ces.a.meta(157, context, null);
        }
        long[][] jArr = b;
        if (jArr == null || jArr.length != 2) {
            b = null;
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long[][] jArr2 = b;
        long[] jArr3 = jArr2[0];
        long[] jArr4 = jArr2[1];
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jArr3.length; i++) {
            try {
                jSONArray.put(i, currentTimeMillis - jArr3[i]);
                jSONArray2.put(i, currentTimeMillis - jArr4[i]);
            } catch (JSONException unused) {
            }
        }
        return new JSONArray[]{jSONArray, jSONArray2};
    }

    public static boolean d(Context context) {
        Object meta = com.pgl.ssdk.ces.a.meta(155, context, null);
        if (meta instanceof Boolean) {
            return ((Boolean) meta).booleanValue();
        }
        return false;
    }

    public static int e() {
        return ((Integer) com.pgl.ssdk.ces.a.meta(162, null, null)).intValue();
    }

    public static boolean b(Context context) {
        Object meta = com.pgl.ssdk.ces.a.meta(156, context, null);
        if (meta instanceof Boolean) {
            return ((Boolean) meta).booleanValue();
        }
        return false;
    }

    public static String a(Context context) {
        String str = f6412a;
        if (str != null) {
            return str;
        }
        String string = Settings.Global.getString(context.getContentResolver(), "boot_count");
        f6412a = string;
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d() {
        return (b("com.samsung.android.knox.SemPersonaManager") || b("com.samsung.android.knoxguard.KnoxGuardManager")) ? Constants.REFERRER_API_SAMSUNG : (b("androidhnext.Manifest") || b("androidhnext.R")) ? "honor" : (b("androidhwext.Manifest") || b("androidhwext.R")) ? "huawei" : (b("oppo.Manifest") || b("oppo.R") || b("oplus.Manifest") || b("oplus.R") || b("com.oneplus.Manifest") || b("com.oneplus.R")) ? "oppo" : (b("vivo.Manifest") || b("vivo.R")) ? Constants.REFERRER_API_VIVO : (b("miui.Manifest") || b("miui.R") || b("miui.os.Build")) ? Constants.REFERRER_API_XIAOMI : (b("lineageos.platform.Manifest") || b("lineageos.platform.R")) ? "lineage" : c("/system/framework/com.motorola.motosignature.jar") ? "moto" : (c("/system/framework/transsion-framework.jar") || c("/system/framework/transsion-services.jar")) ? "transsion" : "other";
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String a2 = x0.a(z.b(), "romtype", (String) null);
        c = a2;
        if (!TextUtils.isEmpty(a2)) {
            return c;
        }
        r0.b(new a());
        return "";
    }
}
