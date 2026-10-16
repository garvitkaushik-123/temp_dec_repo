package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import org.json.JSONObject;

/* compiled from: ReportControllerDiff.java */
/* loaded from: classes6.dex */
public class i {
    public static void a(Context context, int i, int i2, String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3040d4.h.W, "2000058");
            jSONObject.put("appid", com.mbridge.msdk.foundation.controller.c.m().b());
            jSONObject.put("dl_type", String.valueOf(i));
            jSONObject.put("dl_link_type", String.valueOf(i2));
            jSONObject.put("rid", str);
            jSONObject.put("rid_n", str2);
            jSONObject.put("cid", str3);
            jSONObject.put("tgt_v", l0.w(context));
            jSONObject.put("app_v_n", l0.B(context));
            jSONObject.put("app_v_c", l0.A(context));
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("ReportControllerDiff", e.getMessage());
            }
        }
    }
}
