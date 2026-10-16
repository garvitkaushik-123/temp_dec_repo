package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3251pc;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.Nd;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class o {
    private static final String c = "o";
    private static final String d = "activate";
    private static final String e = "startSession";
    private static final String f = "finishSession";
    private static final String g = "impressionOccurred";
    private static final String h = "getOmidData";
    private static final String i = "omidFunction";
    private static final String j = "omidParams";
    private static final String k = "success";
    private static final String l = "fail";
    private static final String m = "%s | unsupported OMID API";

    /* renamed from: a, reason: collision with root package name */
    private final Context f3762a;
    private final C3251pc b = new C3251pc();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f3763a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }
    }

    public o(Context context) {
        this.f3762a = context;
    }

    void a(String str, InterfaceC2992aa interfaceC2992aa) throws Exception {
        char c2;
        a a2 = a(str);
        Nd nd = new Nd();
        JSONObject jSONObject = a2.b;
        if (jSONObject != null) {
            String optString = jSONObject.optString("adViewId", "");
            if (!TextUtils.isEmpty(optString)) {
                nd.b("adViewId", optString);
            }
        }
        try {
            String str2 = a2.f3763a;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (str2.equals(d)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -984459207:
                    if (str2.equals(h)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 70701699:
                    if (str2.equals(f)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1208109646:
                    if (str2.equals(g)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1850541012:
                    if (str2.equals(e)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.b.a(this.f3762a);
                nd = this.b.a();
            } else if (c2 == 1) {
                this.b.d(a2.b);
            } else if (c2 == 2) {
                this.b.b(a2.b);
            } else if (c2 == 3) {
                this.b.c(a2.b);
            } else {
                if (c2 != 4) {
                    throw new IllegalArgumentException(String.format(m, a2.f3763a));
                }
                nd = this.b.a();
            }
            interfaceC2992aa.a(true, a2.c, nd);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            nd.b("errMsg", e2.getMessage());
            Logger.i(c, "OMIDJSAdapter " + a2.f3763a + " Exception: " + e2.getMessage());
            interfaceC2992aa.a(false, a2.d, nd);
        }
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f3763a = jSONObject.optString(i);
        aVar.b = jSONObject.optJSONObject(j);
        aVar.c = jSONObject.optString("success");
        aVar.d = jSONObject.optString("fail");
        return aVar;
    }
}
