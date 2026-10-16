package com.mbridge.msdk.splash.common;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseDeviceInfo.java */
/* loaded from: classes6.dex */
public class a {
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public String c = "android";

    /* renamed from: a, reason: collision with root package name */
    public String f4716a = l0.t();
    public String b = l0.q();
    public String d = f.d();

    public a(Context context) {
        int s = l0.s(context);
        this.e = String.valueOf(s);
        this.f = l0.a(context, s);
        this.g = l0.l(context);
        this.h = com.mbridge.msdk.foundation.controller.c.m().c();
        this.i = com.mbridge.msdk.foundation.controller.c.m().b();
        this.j = String.valueOf(u0.g(context));
        this.k = String.valueOf(u0.f(context));
        this.m = String.valueOf(u0.d(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.l = C3040d4.h.C;
        } else {
            this.l = C3040d4.h.D;
        }
        this.n = l0.u();
        this.o = f.e();
        this.p = f.a();
        this.q = com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(C3040d4.h.G, this.f4716a);
                jSONObject.put("system_version", this.b);
                jSONObject.put("network_type", this.e);
                jSONObject.put("network_type_str", this.f);
                jSONObject.put("device_ua", this.g);
                jSONObject.put("has_wx", l0.D(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("integrated_wx", l0.D());
                jSONObject.put("mnc", l0.r(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("mcc", l0.q(com.mbridge.msdk.foundation.controller.c.m().d()));
                jSONObject.put("adid_limit", this.p);
                jSONObject.put("adid_limit_dev", this.q);
            }
            jSONObject.put("plantform", this.c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.d);
                jSONObject.put("az_aid_info", this.o);
            }
            jSONObject.put("appkey", this.h);
            jSONObject.put("appId", this.i);
            jSONObject.put("screen_width", this.j);
            jSONObject.put("screen_height", this.k);
            jSONObject.put("orientation", this.l);
            jSONObject.put("scale", this.m);
            if (l0.y() != 0) {
                jSONObject.put("tun", l0.y());
            }
            jSONObject.put(InneractiveMediationDefs.GENDER_FEMALE, this.n);
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
                return jSONObject;
            }
        } catch (JSONException e) {
            p0.b("BaseDeviceInfo", e.getMessage());
        }
        return jSONObject;
    }
}
