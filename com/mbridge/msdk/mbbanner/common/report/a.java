package com.mbridge.msdk.mbbanner.common.report;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.setting.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BannerReport.java */
/* loaded from: classes6.dex */
public class a {
    public static void a(CampaignEx campaignEx, String str, String str2) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                new h(c.m().d()).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, str2, campaignEx.isBidCampaign());
            } catch (Exception e) {
                p0.b("BannerReport", e.getMessage());
            }
        }
    }

    public static String b(String str) {
        String md5 = SameMD5.getMD5(u0.d());
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length < 3) {
                    return "";
                }
                String str2 = split[2];
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
            return md5;
        } catch (Exception e) {
            p0.b("BannerReport", e.getMessage());
            return "";
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                String b = com.mbridge.msdk.mbsignalcommon.mraid.c.b(campaignEx.getId());
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                new h(c.m().d()).b(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, b, campaignEx.isBidCampaign());
                com.mbridge.msdk.mbsignalcommon.mraid.c.a(campaignEx.getId());
            } catch (Throwable th) {
                p0.b("BannerReport", th.getMessage());
            }
        }
    }

    public static void a(String str, CampaignEx campaignEx, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (campaignEx.isBidCampaign()) {
                jSONObject.put(CampaignEx.JSON_KEY_HB, 1);
            }
            jSONObject.put(C3040d4.h.W, "2000070");
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, str2);
            jSONObject.put("network_type", String.valueOf(l0.s(c.m().d())));
            d.b().a(jSONObject);
        } catch (Exception e) {
            p0.b("BannerReport", e.getMessage());
        }
    }

    public static void a(String str, CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3040d4.h.W, "2000067");
                jSONObject.put("rid", campaignEx.getRequestId());
                jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
                jSONObject.put("cid", campaignEx.getId());
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
                jSONObject.put(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? 1 : 0);
                HashMap<String, String> hashMap = com.mbridge.msdk.foundation.controller.a.r;
                if (hashMap != null) {
                    String str2 = hashMap.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("u_stid", str2);
                    }
                }
                d.b().a(jSONObject);
            } catch (Throwable th) {
                p0.b("BannerReport", th.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().d() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().d(), false, false);
    }

    public static void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            d.b().a(str, cVar, campaignEx, context, aVar);
        } catch (Exception e) {
            p0.b("BannerReport", e.getMessage());
        }
    }

    public static com.mbridge.msdk.foundation.same.report.metrics.c a(String str, String str2) {
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        try {
            LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.metrics.c> c = d.b().c();
            if (c != null && !c.isEmpty()) {
                Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c>> it = c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c> next = it.next();
                    if (next != null && next.getValue().z()) {
                        it.remove();
                    }
                }
            }
            cVar = d.b().b(str2);
            if (cVar == null) {
                com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
                try {
                    d.b().c().put(str2, cVar2);
                    cVar2.d(true);
                    cVar = cVar2;
                } catch (Exception e) {
                    e = e;
                    cVar = cVar2;
                    p0.b("BannerReport", e.getMessage());
                    return cVar;
                }
            }
            cVar.a(296);
            cVar.i(str2);
            cVar.n(str);
            return cVar;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar, e eVar) {
        try {
            a(cVar, eVar);
            if (eVar != null) {
                cVar.a(str, eVar);
            }
            d.b().b(str, cVar, null);
        } catch (Exception e) {
            p0.b("BannerReport", e.getMessage());
        }
    }

    private static void a(com.mbridge.msdk.foundation.same.report.metrics.c cVar, e eVar) {
        List<CampaignEx> j;
        try {
            String w = cVar.w();
            if (TextUtils.isEmpty(w) && (j = cVar.j()) != null && !j.isEmpty() && j.get(0) != null) {
                w = j.get(0).getCampaignUnitId();
                cVar.a(j.get(0).getAdType());
                cVar.n(w);
            }
            l d = com.mbridge.msdk.setting.h.b().d(c.m().b(), w);
            if (d != null) {
                if (eVar == null) {
                    eVar = new e();
                }
                eVar.a("us_rid", d.I());
                HashMap<String, String> hashMap = com.mbridge.msdk.foundation.controller.a.r;
                if (hashMap != null) {
                    String str = hashMap.get(w);
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    eVar.a("u_stid", str);
                    return;
                }
                eVar.a("u_stid", d.a());
            }
        } catch (Exception e) {
            p0.b("BannerReport", e.getMessage());
        }
    }

    public static void a(String str) {
        LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.metrics.c> c;
        try {
            if (TextUtils.isEmpty(str) || (c = d.b().c()) == null || c.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c>> it = c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, com.mbridge.msdk.foundation.same.report.metrics.c> next = it.next();
                if (next != null) {
                    com.mbridge.msdk.foundation.same.report.metrics.c value = next.getValue();
                    if (value.z()) {
                        it.remove();
                    }
                    if (value.w().equals(str)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            p0.b("BannerReport", th.getMessage());
        }
    }
}
