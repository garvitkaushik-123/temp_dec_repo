package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.Jf;
import com.ironsource.Nd;
import com.ironsource.Xb;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class u {
    private static final String d = "u";
    private static final String e = "updateToken";
    private static final String f = "getToken";
    private static final String g = "functionName";
    private static final String h = "functionParams";
    private static final String i = "success";
    private static final String j = "fail";
    private Context b;

    /* renamed from: a, reason: collision with root package name */
    private Xb f3777a = new Xb();
    private Jf c = new Jf();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f3778a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }
    }

    public u(Context context) {
        this.b = context;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f3778a = jSONObject.optString("functionName");
        aVar.b = jSONObject.optJSONObject("functionParams");
        aVar.c = jSONObject.optString("success");
        aVar.d = jSONObject.optString("fail");
        return aVar;
    }

    void a(String str, InterfaceC2992aa interfaceC2992aa) throws Exception {
        a a2 = a(str);
        if (e.equals(a2.f3778a)) {
            a(a2.b, a2, interfaceC2992aa);
        } else if (f.equals(a2.f3778a)) {
            a(a2, interfaceC2992aa);
        } else {
            Logger.i(d, "unhandled API request " + str);
        }
    }

    public void a(JSONObject jSONObject, a aVar, InterfaceC2992aa interfaceC2992aa) {
        Nd nd = new Nd();
        try {
            this.f3777a.a(jSONObject);
            interfaceC2992aa.a(true, aVar.c, nd);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            Logger.i(d, "updateToken exception " + e2.getMessage());
            interfaceC2992aa.a(false, aVar.d, nd);
        }
    }

    private void a(a aVar, InterfaceC2992aa interfaceC2992aa) {
        try {
            JSONObject a2 = this.c.a();
            Iterator<String> keys = a2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = a2.get(next);
                if (obj instanceof String) {
                    a2.put(next, StringUtils.encodeURI((String) obj));
                }
            }
            interfaceC2992aa.a(true, aVar.c, a2);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            interfaceC2992aa.a(false, aVar.d, e2.getMessage());
        }
    }
}
