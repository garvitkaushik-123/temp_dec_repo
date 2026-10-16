package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.C1;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.Nd;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class q {
    private static final String b = "q";
    private static final String c = "getPermissions";
    private static final String d = "isPermissionGranted";
    private static final String e = "permissions";
    private static final String f = "permission";
    private static final String g = "status";
    private static final String h = "functionName";
    private static final String i = "functionParams";
    private static final String j = "success";
    private static final String k = "fail";
    private static final String l = "unhandledPermission";

    /* renamed from: a, reason: collision with root package name */
    private Context f3771a;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f3772a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }
    }

    public q(Context context) {
        this.f3771a = context;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f3772a = jSONObject.optString("functionName");
        aVar.b = jSONObject.optJSONObject("functionParams");
        aVar.c = jSONObject.optString("success");
        aVar.d = jSONObject.optString("fail");
        return aVar;
    }

    public void b(JSONObject jSONObject, a aVar, InterfaceC2992aa interfaceC2992aa) {
        Nd nd = new Nd();
        try {
            String string = jSONObject.getString(f);
            nd.b(f, string);
            if (C1.d(this.f3771a, string)) {
                nd.b("status", String.valueOf(C1.c(this.f3771a, string)));
                interfaceC2992aa.a(true, aVar.c, nd);
            } else {
                nd.b("status", l);
                interfaceC2992aa.a(false, aVar.d, nd);
            }
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            nd.b("errMsg", e2.getMessage());
            interfaceC2992aa.a(false, aVar.d, nd);
        }
    }

    void a(String str, InterfaceC2992aa interfaceC2992aa) throws Exception {
        a a2 = a(str);
        if (c.equals(a2.f3772a)) {
            a(a2.b, a2, interfaceC2992aa);
        } else if (d.equals(a2.f3772a)) {
            b(a2.b, a2, interfaceC2992aa);
        } else {
            Logger.i(b, "PermissionsJSAdapter unhandled API request " + str);
        }
    }

    public void a(JSONObject jSONObject, a aVar, InterfaceC2992aa interfaceC2992aa) {
        Nd nd = new Nd();
        try {
            nd.a(e, C1.a(this.f3771a, jSONObject.getJSONArray(e)));
            interfaceC2992aa.a(true, aVar.c, nd);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            Logger.i(b, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e2.getMessage());
            nd.b("errMsg", e2.getMessage());
            interfaceC2992aa.a(false, aVar.d, nd);
        }
    }
}
