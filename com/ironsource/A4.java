package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class A4 {
    private static final String c = "A4";
    private static final String d = "setSharedSignal";
    private static final String e = "getSharedSignal";
    private static final String f = "functionName";
    private static final String g = "functionParams";
    private static final String h = "success";
    private static final String i = "fail";

    /* renamed from: a, reason: collision with root package name */
    private final Context f2786a;
    C3412z4 b;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f2787a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.f2787a = jSONObject.optString("functionName");
            aVar.b = jSONObject.optJSONObject("functionParams");
            aVar.c = jSONObject.optString("success");
            aVar.d = jSONObject.optString("fail");
            return aVar;
        }
    }

    public A4(Context context, C3412z4 c3412z4) {
        this.f2786a = context;
        this.b = c3412z4;
    }

    private a a(String str) throws JSONException {
        return a.a(new JSONObject(str));
    }

    private void b(Context context, a aVar, InterfaceC2992aa interfaceC2992aa) {
        Nd nd = new Nd();
        JSONObject jSONObject = aVar.b;
        this.b.a(context, EnumC3395y4.a(jSONObject.optString("source")), jSONObject.optString(C3040d4.h.W), jSONObject.optString("data"));
        interfaceC2992aa.a(true, aVar.c, nd);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a A[Catch: Exception -> 0x0050, TRY_LEAVE, TryCatch #0 {Exception -> 0x0050, blocks: (B:3:0x0006, B:11:0x0031, B:14:0x0037, B:15:0x0049, B:16:0x004a, B:18:0x0018, B:21:0x0022), top: B:2:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(String str, InterfaceC2992aa interfaceC2992aa) throws Exception {
        char c2;
        a a2 = a(str);
        try {
            String str2 = a2.f2787a;
            int hashCode = str2.hashCode();
            if (hashCode != 576059875) {
                if (hashCode == 1486812399 && str2.equals(d)) {
                    c2 = 0;
                    if (c2 != 0) {
                        b(this.f2786a, a2, interfaceC2992aa);
                        return;
                    } else {
                        if (c2 == 1) {
                            a(this.f2786a, a2, interfaceC2992aa);
                            return;
                        }
                        throw new UnsupportedOperationException("unsupported API: " + str);
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
            } else {
                if (str2.equals(e)) {
                    c2 = 1;
                    if (c2 != 0) {
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
            }
        } catch (Exception e2) {
            a(a2, interfaceC2992aa, e2);
        }
    }

    private void a(Context context, a aVar, InterfaceC2992aa interfaceC2992aa) {
        Nd nd = new Nd();
        JSONObject jSONObject = aVar.b;
        nd.b("data", this.b.a(context, EnumC3395y4.a(jSONObject.optString("source")), jSONObject.optString(C3040d4.h.W)));
        interfaceC2992aa.a(true, aVar.c, nd);
    }

    private void a(a aVar, InterfaceC2992aa interfaceC2992aa, Exception exc) {
        C3260q4.d().a(exc);
        String message = exc.getMessage();
        Logger.i(c, aVar.f2787a + " exception " + message);
        Nd nd = new Nd();
        if (TextUtils.isEmpty(message)) {
            message = "Unknown error";
        }
        nd.b("error", message);
        interfaceC2992aa.a(false, aVar.d, nd);
    }
}
