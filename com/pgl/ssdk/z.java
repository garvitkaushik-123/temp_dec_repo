package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static Context f6419a;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.b(z.b());
            com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.BIDPAYLOAD_TEMPLATE_TYPE_MISMATCH_ERROR_VALUE, z.b(), null);
        }
    }

    @DungeonFlag
    private static String a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", 3);
            jSONObject.put("exception", th.toString());
            jSONObject.put("stacktrace", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable unused) {
            return "eyJzdGF0dXMiOjN9";
        }
    }

    public static Context b() {
        return f6419a;
    }

    public static void c(Context context) {
        f6419a = context;
    }

    @DungeonFlag
    public static String b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", 0);
            jSONObject.put("envcode", ((Long) com.pgl.ssdk.ces.a.meta(154, context, null)).longValue());
            jSONObject.put("bootcount", w.a(context));
            jSONObject.put("usb_debug", w.d(context));
            JSONArray[] c = w.c(context);
            if (c != null) {
                jSONObject.put("sdata", c[0]);
                jSONObject.put("sdmta", c[1]);
                jSONObject.put("curtime", System.currentTimeMillis() / 1000);
            }
            jSONObject.put("camera_count", x.a());
            jSONObject.put("sim", x.c(context));
            jSONObject.put("virtual_display", a0.a(context));
            jSONObject.put("acbs", u.b(context));
            jSONObject.put("bl_unlock", w.b(context));
            y.a(jSONObject);
            String e = v.e();
            jSONObject.put("romtype", w.c());
            jSONObject.put("root", w.e());
            if (!TextUtils.isEmpty(e)) {
                jSONObject.put("sign", e);
            }
            return (String) com.pgl.ssdk.ces.a.meta(227, context, jSONObject.toString());
        } catch (Throwable th) {
            return a(th);
        }
    }

    public static String c() {
        String b = b(b());
        a();
        return b;
    }

    public static long a(Context context) {
        try {
            return ((Long) com.pgl.ssdk.ces.a.meta(154, context, null)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @DungeonFlag
    public static void a() {
        r0.b(new a());
    }
}
