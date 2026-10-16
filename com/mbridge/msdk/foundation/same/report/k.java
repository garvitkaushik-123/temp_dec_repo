package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.l0;
import org.json.JSONObject;

/* compiled from: ReportUtilDiff.java */
/* loaded from: classes6.dex */
public class k {
    public static JSONObject a(Context context, com.mbridge.msdk.setting.g gVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            String p = l0.p();
            if (!TextUtils.isEmpty(p)) {
                jSONObject.put("manufacturer", p);
            }
            int m = l0.m();
            if (m != -1) {
                jSONObject.put("sdkint", m);
            }
            String x = l0.x(context);
            if (!TextUtils.isEmpty(x)) {
                jSONObject.put("is24H", x);
            }
            String x2 = l0.x();
            if (!TextUtils.isEmpty(x2)) {
                jSONObject.put("totalram", x2);
            }
            String y = l0.y(context);
            if (!TextUtils.isEmpty(y)) {
                jSONObject.put("totalmemory", y);
            }
            jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
            jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? "1" : "0");
        }
        if (gVar.s0() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.f.e()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.f.e());
        }
        return jSONObject;
    }

    public static void a(com.mbridge.msdk.foundation.same.net.wrapper.e eVar, Context context) {
    }
}
