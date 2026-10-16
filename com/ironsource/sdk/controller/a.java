package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3179l8;
import com.ironsource.C3260q4;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.InterfaceC3095g8;
import com.ironsource.Nd;
import com.ironsource.fg;
import com.ironsource.ug;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class a implements InterfaceC3095g8 {
    private static final String d = "loadWithUrl";
    private static final String e = "sendMessage";
    public static final String f = "removeAdView";
    public static final String g = "webviewAction";
    public static final String h = "handleGetViewVisibility";
    private static final String i = "functionName";
    private static final String j = "functionParams";
    private static final String k = "success";
    private static final String l = "fail";
    public static final String m = "errMsg";
    private static final String n = "%s | unsupported AdViews API";

    /* renamed from: a, reason: collision with root package name */
    private ug f3710a;
    private C3179l8 b = C3179l8.a();
    private Context c;

    /* renamed from: com.ironsource.sdk.controller.a$a, reason: collision with other inner class name */
    private static class C0298a {

        /* renamed from: a, reason: collision with root package name */
        String f3711a;
        JSONObject b;
        String c;
        String d;

        private C0298a() {
        }
    }

    public a(Context context) {
        this.c = context;
    }

    public void a(ug ugVar) {
        this.f3710a = ugVar;
    }

    @Override // com.ironsource.InterfaceC3095g8
    public void a(String str, JSONObject jSONObject) {
        if (this.f3710a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f3710a.a(str, jSONObject);
    }

    @Override // com.ironsource.InterfaceC3095g8
    public void a(String str, String str2, String str3) {
        a(str, fg.a(str2, str3));
    }

    void a(String str, InterfaceC2992aa interfaceC2992aa) throws Exception {
        a aVar;
        char c;
        C0298a a2 = a(str);
        Nd nd = new Nd();
        try {
            String str2 = a2.f3711a;
            switch (str2.hashCode()) {
                case -1384357108:
                    if (str2.equals(f)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 691453791:
                    if (str2.equals("sendMessage")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 842351363:
                    if (str2.equals("loadWithUrl")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1182065477:
                    if (str2.equals("handleGetViewVisibility")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1491535759:
                    if (str2.equals(g)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                aVar = this;
                try {
                    this.b.a(aVar, a2.b, this.c, a2.c, a2.d);
                    return;
                } catch (Exception e2) {
                    e = e2;
                    C3260q4.d().a(e);
                    nd.b("errMsg", e.getMessage());
                    String c2 = aVar.b.c(a2.b);
                    if (!TextUtils.isEmpty(c2)) {
                        nd.b("adViewId", c2);
                    }
                    interfaceC2992aa.a(false, a2.d, nd);
                    return;
                }
            }
            if (c == 1) {
                this.b.d(a2.b, a2.c, a2.d);
                return;
            }
            if (c == 2) {
                this.b.c(a2.b, a2.c, a2.d);
            } else if (c == 3) {
                this.b.a(a2.b, a2.c, a2.d);
            } else {
                if (c != 4) {
                    throw new IllegalArgumentException(String.format(n, a2.f3711a));
                }
                this.b.b(a2.b, a2.c, a2.d);
            }
        } catch (Exception e3) {
            e = e3;
            aVar = this;
        }
    }

    private C0298a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        C0298a c0298a = new C0298a();
        c0298a.f3711a = jSONObject.optString("functionName");
        c0298a.b = jSONObject.optJSONObject("functionParams");
        c0298a.c = jSONObject.optString("success");
        c0298a.d = jSONObject.optString("fail");
        return c0298a;
    }
}
