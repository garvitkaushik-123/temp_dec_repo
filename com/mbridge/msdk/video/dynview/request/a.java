package com.mbridge.msdk.video.dynview.request;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.j;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.Campaign;
import org.json.JSONObject;

/* compiled from: MOfferReport.java */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5050a = "com.mbridge.msdk.video.dynview.request.a";

    /* compiled from: MOfferReport.java */
    /* renamed from: com.mbridge.msdk.video.dynview.request.a$a, reason: collision with other inner class name */
    class C0407a implements j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5051a;

        C0407a(ViewGroup viewGroup) {
            this.f5051a = viewGroup;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            t0.a(campaign, this.f5051a);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            t0.a(campaign, this.f5051a);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            t0.b(campaign, this.f5051a);
        }
    }

    public static void a(CampaignEx campaignEx, Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3040d4.h.W, "2000091");
                jSONObject.put("network_type", l0.s(context));
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V)) {
                    jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                    jSONObject.put("c", com.mbridge.msdk.foundation.same.a.g);
                }
                jSONObject.put(CampaignEx.JSON_KEY_HB, 0);
                jSONObject.put("rid_n", str3);
                jSONObject.put("reason", str);
                if (campaignEx != null && campaignEx.getRewardTemplateMode() != null) {
                    jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, u0.b(campaignEx.getRewardTemplateMode().e()));
                }
                d.b().a(jSONObject);
            } catch (Throwable th) {
                p0.b(f5050a, th.getMessage());
            }
        }
    }

    public static void a(CampaignUnit campaignUnit, int i, int i2, String str) {
        int i3;
        String impressionURL;
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0 || campaignUnit.getAds().get(i) == null) {
            return;
        }
        if (i2 == 0 && campaignUnit.getAds().get(i).mMoreOfferImpShow) {
            return;
        }
        String a2 = b1.a(campaignUnit.getAds().get(i).getendcard_url(), "mof_testuid");
        if (TextUtils.isEmpty(a2)) {
            a2 = b1.a(campaignUnit.getAds().get(i).getendcard_url(), "mof_uid");
        }
        String str2 = TextUtils.isEmpty(a2) ? str : a2;
        if (i2 == 0) {
            i3 = com.mbridge.msdk.click.retry.a.m;
            impressionURL = campaignUnit.getAds().get(i).getImpressionURL();
        } else if (i2 != 1) {
            impressionURL = "";
            i3 = 0;
        } else {
            i3 = com.mbridge.msdk.click.retry.a.n;
            impressionURL = campaignUnit.getAds().get(i).getOnlyImpressionURL();
        }
        String str3 = impressionURL;
        int i4 = i3;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        com.mbridge.msdk.click.a.a(c.m().d(), campaignUnit.getAds().get(i), str2, str3, false, true, i4);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, View view) {
        if (context == null || campaignEx == null) {
            return;
        }
        a(context, campaignEx);
        com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(context, str);
        if (view instanceof ViewGroup) {
            aVar.a(new C0407a((ViewGroup) view));
        }
        aVar.a(campaignEx);
    }

    private static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().d() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().d(), false, false);
    }
}
