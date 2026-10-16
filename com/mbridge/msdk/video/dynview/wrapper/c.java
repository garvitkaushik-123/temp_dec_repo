package com.mbridge.msdk.video.dynview.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.y;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ViewOptionWrapper.java */
/* loaded from: classes6.dex */
public class c {
    public com.mbridge.msdk.video.dynview.c a(Context context, List<CampaignEx> list) {
        String str;
        int i;
        int i2;
        int i3;
        if (list == null) {
            return null;
        }
        try {
            float g = u0.g(com.mbridge.msdk.foundation.controller.c.m().d());
            float f = u0.f(com.mbridge.msdk.foundation.controller.c.m().d());
            List<String> arrayList = new ArrayList<>();
            if (list.size() <= 0 || list.get(0) == null) {
                str = "";
                i = 1;
                i2 = 0;
                i3 = 0;
            } else {
                i = com.mbridge.msdk.video.dynview.util.a.a(list.get(0));
                i2 = list.get(0).getMof_tplid();
                str = list.get(0).getMof_template_url();
                i3 = list.get(0).getDynamicTempCode();
            }
            if (i2 != 0 && !TextUtils.isEmpty(str)) {
                arrayList = n0.a(y.a(0, i2 + "", str), "template_" + i2 + "_" + i);
            }
            String str2 = "mbridge_same_choice_one_layout_portrait";
            if (i != 1) {
                if (i == 2) {
                    str2 = "mbridge_same_choice_one_layout_landscape";
                } else if (com.mbridge.msdk.video.dynview.util.a.a(context)) {
                    str2 = "mbridge_same_choice_one_layout_landscape";
                    i = 2;
                } else {
                    i = 1;
                }
            }
            return com.mbridge.msdk.video.dynview.c.a().a(context).c(str2).b(1).b(f).a(g).a(list).orientation(i).fileDirs(arrayList).d(i3).a(i2).build();
        } catch (Exception e) {
            p0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[Catch: Exception -> 0x00f2, TryCatch #0 {Exception -> 0x00f2, blocks: (B:6:0x0008, B:9:0x001a, B:10:0x002d, B:17:0x003f, B:18:0x004f, B:20:0x0055, B:21:0x007c, B:23:0x0098, B:24:0x009c), top: B:5:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[Catch: Exception -> 0x00f2, TryCatch #0 {Exception -> 0x00f2, blocks: (B:6:0x0008, B:9:0x001a, B:10:0x002d, B:17:0x003f, B:18:0x004f, B:20:0x0055, B:21:0x007c, B:23:0x0098, B:24:0x009c), top: B:5:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.mbridge.msdk.video.dynview.c b(View view, CampaignEx campaignEx) {
        String str;
        int i;
        String str2;
        if (campaignEx == null) {
            return null;
        }
        try {
            List<String> arrayList = new ArrayList<>();
            String campaignUnitId = campaignEx.getCampaignUnitId();
            if (campaignEx.getRewardTemplateMode() != null) {
                i = campaignEx.getRewardTemplateMode().f();
                str = campaignEx.getRewardTemplateMode().e();
            } else {
                str = "";
                i = 0;
            }
            int a2 = u0.a(str, "ia_tp", -5);
            if (i != 0 && i != 102 && i != 202) {
                str2 = "mbridge_reward_layer_floor_" + i;
                if (!TextUtils.isEmpty(str)) {
                    arrayList = n0.a(y.a(1, i + "", str), "template_" + i);
                }
                boolean a3 = com.mbridge.msdk.video.dynview.util.a.a(str);
                String a4 = com.mbridge.msdk.video.dynview.util.a.a(str, "whs_chn");
                com.mbridge.msdk.videocommon.setting.c a5 = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), campaignUnitId, false);
                int D = a5 != null ? a5.D() : 0;
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(campaignEx);
                return com.mbridge.msdk.video.dynview.c.a().c(str2).b(2).a(arrayList2).a(view.getContext()).a(view).c(D).f(a2).orientation(l0.F(view.getContext())).a(i).a(a3).b(a4).fileDirs(arrayList).d(campaignEx.getDynamicTempCode()).build();
            }
            str2 = "mbridge_reward_layer_floor";
            if (!TextUtils.isEmpty(str)) {
            }
            boolean a32 = com.mbridge.msdk.video.dynview.util.a.a(str);
            String a42 = com.mbridge.msdk.video.dynview.util.a.a(str, "whs_chn");
            com.mbridge.msdk.videocommon.setting.c a52 = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), campaignUnitId, false);
            if (a52 != null) {
            }
            ArrayList arrayList22 = new ArrayList();
            arrayList22.add(campaignEx);
            return com.mbridge.msdk.video.dynview.c.a().c(str2).b(2).a(arrayList22).a(view.getContext()).a(view).c(D).f(a2).orientation(l0.F(view.getContext())).a(i).a(a32).b(a42).fileDirs(arrayList).d(campaignEx.getDynamicTempCode()).build();
        } catch (Exception e) {
            p0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public com.mbridge.msdk.video.dynview.c b(Context context, List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    float g = u0.g(com.mbridge.msdk.foundation.controller.c.m().d());
                    float f = u0.f(com.mbridge.msdk.foundation.controller.c.m().d());
                    List<String> arrayList = new ArrayList<>();
                    int dynamicTempCode = list.get(0).getDynamicTempCode();
                    int mof_tplid = list.get(0).getMof_tplid();
                    String mof_template_url = list.get(0).getMof_template_url();
                    int F = l0.F(context);
                    if (mof_tplid != 0 && !TextUtils.isEmpty(mof_template_url)) {
                        arrayList = n0.a(y.a(0, mof_tplid + "", mof_template_url), "template_" + mof_tplid + "_" + F);
                    }
                    return com.mbridge.msdk.video.dynview.c.a().c(F == 1 ? "mbridge_order_layout_list_portrait" : "mbridge_order_layout_list_landscape").b(5).a(context).b(f).a(g).a(list).orientation(F).fileDirs(arrayList).d(dynamicTempCode).a(mof_tplid).build();
                }
            } catch (Exception e) {
                p0.b("ViewOptionWrapper", e.getMessage());
            }
        }
        return null;
    }

    public com.mbridge.msdk.video.dynview.c a(View view, CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.setting.c a2 = com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), campaignEx.getCampaignUnitId(), false);
            int D = a2 != null ? a2.D() : 0;
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            return com.mbridge.msdk.video.dynview.c.a().c("mbridge_reward_layer_floor_bottom").b(3).a(arrayList).a(view.getContext()).a(view).c(D).orientation(l0.F(view.getContext())).build();
        } catch (Exception e) {
            p0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }

    public com.mbridge.msdk.video.dynview.c a(Context context, CampaignEx campaignEx, int i, String str) {
        String str2;
        String str3;
        if (campaignEx == null) {
            return null;
        }
        try {
            long ecTemplateId = campaignEx.getEcTemplateId();
            int F = l0.F(context);
            int a2 = u0.a(campaignEx.getendcard_url(), "n_logo", 1);
            if (ecTemplateId == 1302) {
                str2 = (F == 1 ? new StringBuilder().append("mbridge_reward_end_card_layout_portrait_") : new StringBuilder().append("mbridge_reward_end_card_layout_landscape_")).append(ecTemplateId).toString();
                str3 = "template_" + str + F + "_" + ecTemplateId;
            } else {
                str2 = F == 1 ? "mbridge_reward_end_card_layout_portrait" : "mbridge_reward_end_card_layout_landscape";
                str3 = "template_" + str + F;
            }
            List<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                arrayList = n0.a(y.a(2, i + "", campaignEx.getendcard_url()), str3);
            }
            return com.mbridge.msdk.video.dynview.c.a().c(str2).b(4).a(context).orientation(l0.F(context)).fileDirs(arrayList).d(campaignEx.getDynamicTempCode()).a(i).a(str).e(a2).build();
        } catch (Exception e) {
            p0.b("ViewOptionWrapper", e.getMessage());
            return null;
        }
    }
}
