package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommonDeviceInfo.java */
/* loaded from: classes6.dex */
public class a {
    public static JSONObject a() {
        JSONObject jSONObject;
        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
        try {
            jSONObject = j.a(d).c();
        } catch (Exception e) {
            p0.b("CommonDeviceInfo", "getCommonProperty error", e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                com.mbridge.msdk.foundation.same.a.g = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c");
            }
            if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                jSONObject.put("c", com.mbridge.msdk.foundation.same.a.g);
            }
            jSONObject.put("open", com.mbridge.msdk.foundation.same.a.S);
            String a2 = Aa.a();
            if (a2 == null) {
                a2 = "";
            }
            jSONObject.put("channel", a2);
            jSONObject.put("band_width", com.mbridge.msdk.foundation.same.net.a.b().a());
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d2 == null) {
                d2 = com.mbridge.msdk.setting.h.b().a();
            }
            JSONObject a3 = a(d2);
            if (a3 != null) {
                String jSONObject2 = a3.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    String b = j0.b(jSONObject2);
                    if (!TextUtils.isEmpty(b)) {
                        jSONObject.put("dvi", b);
                    }
                }
            }
            jSONObject.put(MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().b());
            jSONObject.put("m_sdk", "msdk");
            jSONObject.put("lqswt", String.valueOf(1));
            jSONObject.put("network_available", String.valueOf(u0.m(d)));
            String str = "UNKNOWN";
            if (d2 != null) {
                str = d2.k();
                jSONObject.put("a_stid", d2.a());
            }
            jSONObject.put("country_code", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject a(com.mbridge.msdk.setting.g gVar) {
        try {
            return j.a(com.mbridge.msdk.foundation.controller.c.m().d(), gVar);
        } catch (Exception unused) {
            return null;
        }
    }
}
