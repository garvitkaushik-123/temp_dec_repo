package com.mbridge.msdk.foundation.same.net.wrapper;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import org.json.JSONObject;

/* compiled from: CommonRequestParamsForAddDiff.java */
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String f4305a = "";
    private static String b = "";

    public static void a(e eVar) {
    }

    public static void a(e eVar, Context context) {
    }

    public static void a(e eVar, Context context, boolean z, com.mbridge.msdk.setting.g gVar) {
        if (eVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put("dmt", l0.v() + "");
                jSONObject.put("dmf", l0.h());
                jSONObject.put("adid_limit", com.mbridge.msdk.foundation.tools.f.a() + "");
                jSONObject.put("adid_limit_dev", com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? "1" : "0");
            }
            if (gVar.s0() == 1 && !TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.f.e()) && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("az_aid_info", com.mbridge.msdk.foundation.tools.f.e());
            }
            if (TextUtils.isEmpty(jSONObject.toString())) {
                return;
            }
            if (!jSONObject.equals(b)) {
                f4305a = j0.b(jSONObject.toString());
            }
            if (TextUtils.isEmpty(f4305a)) {
                return;
            }
            eVar.a("dvi", f4305a);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("CommonRequestParamsForAddDiff", e.getMessage());
            }
        }
    }

    public static void b(e eVar) {
    }

    public static void c(e eVar) {
    }
}
