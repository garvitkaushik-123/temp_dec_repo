package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.C3260q4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
final class g {
    private static final String c = "com.ironsource.sdk.controller.g";
    private static final String d = "functionName";
    private static final String e = "params";
    private static final String f = "hash";

    /* renamed from: a, reason: collision with root package name */
    private final b f3741a;
    private final s b;

    g(b bVar, s sVar) {
        this.f3741a = bVar;
        this.b = sVar;
    }

    private void a(Exception exc) {
        if (!(exc instanceof NoSuchMethodException)) {
            a(exc.getLocalizedMessage());
        } else {
            IronLog.INTERNAL.error(exc.toString());
            Logger.i(c, "messageHandler failed with exception " + exc.getMessage());
        }
    }

    private void b(String str, String str2, String str3) {
        this.f3741a.a(a(str, str2, str3));
    }

    @JavascriptInterface
    public void messageHandler(String str, String str2, String str3) {
        try {
            Logger.i(c, "messageHandler(" + str + " " + str3 + ")");
            if (this.b.a(str, str2, str3)) {
                a(str, str2);
            } else {
                b(str, str2, str3);
            }
        } catch (Exception e2) {
            a(e2);
        }
    }

    private void a(String str, String str2) throws Exception {
        this.f3741a.a(str, str2);
    }

    private void a(String str) {
        this.f3741a.b(str);
    }

    private String a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", SDKUtils.encodeString(str));
            jSONObject.put("params", SDKUtils.encodeString(str2));
            jSONObject.put(f, SDKUtils.encodeString(str3));
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
        return jSONObject.toString();
    }
}
