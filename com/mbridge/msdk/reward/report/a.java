package com.mbridge.msdk.reward.report;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import java.util.List;
import org.json.JSONObject;

/* compiled from: RewardReport.java */
/* loaded from: classes6.dex */
public class a {
    public static void a(Context context, String str) {
        if (context != null) {
            try {
                n a2 = n.a(g.a(context));
                if (TextUtils.isEmpty(str) || a2 == null || a2.a() <= 0) {
                    return;
                }
                List<com.mbridge.msdk.foundation.entity.n> a3 = a2.a("m_download_end");
                List<com.mbridge.msdk.foundation.entity.n> a4 = a2.a("2000021");
                List<com.mbridge.msdk.foundation.entity.n> a5 = a2.a("2000039");
                List<com.mbridge.msdk.foundation.entity.n> a6 = a2.a("m_download_end");
                List<com.mbridge.msdk.foundation.entity.n> a7 = a2.a("m_download_end");
                List<com.mbridge.msdk.foundation.entity.n> a8 = a2.a("2000044");
                o.e(a4);
                o.a(a3);
                o.c(a5);
                o.b(a6);
                o.f(a7);
                o.d(a8);
            } catch (Exception e) {
                p0.b("RewardReport", e.getMessage());
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str) {
        int a2;
        if (context == null || campaignEx == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C3040d4.h.W, "2000048");
            jSONObject.put("st", System.currentTimeMillis());
            jSONObject.put("cid", campaignEx.getId());
            jSONObject.put("network_type", l0.s(context));
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            if (u0.c(campaignEx)) {
                jSONObject.put(CampaignEx.JSON_KEY_RETARGET_TYPE, campaignEx.getRtinsType());
            }
            jSONObject.put(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? 1 : 0);
            jSONObject.put("rid", campaignEx.getRequestId());
            jSONObject.put("rid_n", campaignEx.getRequestIdNotice());
            jSONObject.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, campaignEx.getAdSpaceT());
            if (campaignEx.getRewardTemplateMode() != null && (a2 = d.a(campaignEx, campaignEx.getRewardTemplateMode().e())) != -1) {
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, a2);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
        } catch (Throwable th) {
            p0.b("RewardReport", th.getMessage());
        }
    }
}
