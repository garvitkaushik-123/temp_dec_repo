package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.C3334ub;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.Nd;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class i {
    private static final String c = "i";
    private static final String d = "getDeviceData";
    private static final String e = "deviceDataFunction";
    private static final String f = "deviceDataParams";
    private static final String g = "success";
    private static final String h = "fail";

    /* renamed from: a, reason: collision with root package name */
    private Context f3745a;
    private final InterfaceC3381x7 b = C3334ub.U().i();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        String f3746a;
        JSONObject b;
        String c;
        String d;

        private a() {
        }
    }

    public i(Context context) {
        this.f3745a = context;
    }

    void a(String str, InterfaceC2992aa interfaceC2992aa) throws Exception {
        a a2 = a(str);
        if (d.equals(a2.f3746a)) {
            interfaceC2992aa.a(true, a2.c, a());
        } else {
            Logger.i(c, "unhandled API request " + str);
        }
    }

    private Nd a() {
        Nd nd = new Nd();
        nd.b(SDKUtils.encodeString(C3040d4.i.i0), SDKUtils.encodeString(String.valueOf(this.b.j())));
        nd.b(SDKUtils.encodeString(C3040d4.i.j0), SDKUtils.encodeString(String.valueOf(this.b.q(this.f3745a))));
        nd.b(SDKUtils.encodeString(C3040d4.i.k0), SDKUtils.encodeString(String.valueOf(this.b.C(this.f3745a))));
        nd.b(SDKUtils.encodeString(C3040d4.i.l0), SDKUtils.encodeString(String.valueOf(this.b.D(this.f3745a))));
        nd.b(SDKUtils.encodeString(C3040d4.i.m0), SDKUtils.encodeString(String.valueOf(this.b.e(this.f3745a))));
        nd.b(SDKUtils.encodeString(C3040d4.i.n0), SDKUtils.encodeString(String.valueOf(this.b.h(this.f3745a))));
        return nd;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f3746a = jSONObject.optString(e);
        aVar.b = jSONObject.optJSONObject(f);
        aVar.c = jSONObject.optString("success");
        aVar.d = jSONObject.optString("fail");
        return aVar;
    }
}
