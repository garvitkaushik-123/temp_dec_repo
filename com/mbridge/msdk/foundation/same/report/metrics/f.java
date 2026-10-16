package com.mbridge.msdk.foundation.same.report.metrics;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.tracker.m;
import com.mbridge.msdk.tracker.network.toolbox.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SameMetricsReport.java */
/* loaded from: classes6.dex */
public class f {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r24.i().getAdType() == 295) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce A[Catch: Exception -> 0x0864, TryCatch #2 {Exception -> 0x0864, blocks: (B:3:0x001d, B:5:0x0029, B:9:0x0030, B:11:0x003c, B:19:0x00a6, B:21:0x00ac, B:22:0x00c8, B:24:0x00ce, B:26:0x00d3, B:29:0x00f8, B:31:0x00fe, B:40:0x012d, B:42:0x0131, B:43:0x0134, B:44:0x0138, B:46:0x013e, B:49:0x0147, B:51:0x0190, B:52:0x01ef, B:54:0x01f9, B:56:0x020c, B:57:0x0215, B:58:0x0228, B:60:0x0237, B:61:0x0244, B:64:0x0250, B:66:0x0282, B:68:0x0288, B:70:0x028e, B:71:0x02af, B:72:0x02ba, B:74:0x02c4, B:76:0x02ca, B:77:0x02fd, B:79:0x0305, B:81:0x030b, B:82:0x032c, B:83:0x0337, B:85:0x033f, B:87:0x0345, B:88:0x0366, B:89:0x0371, B:91:0x0379, B:93:0x037f, B:94:0x03a0, B:95:0x03ab, B:98:0x03c0, B:100:0x03ca, B:101:0x03d0, B:102:0x03d5, B:104:0x03db, B:106:0x03e9, B:109:0x03f9, B:111:0x03ff, B:112:0x044b, B:114:0x0455, B:117:0x0461, B:119:0x0467, B:120:0x0482, B:121:0x0486, B:123:0x048c, B:124:0x04a7, B:125:0x04aa, B:127:0x04b4, B:129:0x04c3, B:130:0x04e6, B:131:0x04ef, B:134:0x04f9, B:136:0x04ff, B:137:0x0542, B:140:0x054e, B:142:0x0564, B:143:0x058c, B:145:0x0594, B:146:0x05bc, B:148:0x05c0, B:150:0x05d0, B:151:0x05d5, B:153:0x05df, B:154:0x05e8, B:156:0x05ee, B:157:0x05fb, B:159:0x0619, B:161:0x0620, B:162:0x062d, B:164:0x0637, B:165:0x0640, B:167:0x0648, B:169:0x064f, B:170:0x065c, B:172:0x0666, B:173:0x066f, B:174:0x067c, B:176:0x0684, B:183:0x0692, B:186:0x06a0, B:188:0x06c6, B:190:0x06cc, B:191:0x06d1, B:192:0x06cf, B:193:0x06d8, B:195:0x06e0, B:197:0x06e6, B:198:0x06eb, B:199:0x06e9, B:200:0x06f2, B:203:0x06fc, B:205:0x0704, B:206:0x070c, B:208:0x071a, B:210:0x0720, B:211:0x0725, B:213:0x0734, B:215:0x073a, B:216:0x073f, B:219:0x0751, B:222:0x0771, B:224:0x077a, B:225:0x0796, B:227:0x07a2, B:232:0x07b1, B:234:0x07bd, B:236:0x07c7, B:238:0x07de, B:239:0x07f1, B:241:0x07f7, B:242:0x07fc, B:243:0x07fa, B:244:0x07e8, B:245:0x07d0, B:247:0x07d6, B:249:0x0837, B:250:0x0804, B:252:0x0812, B:253:0x0825, B:255:0x082b, B:256:0x0830, B:257:0x082e, B:258:0x081c, B:260:0x0786, B:261:0x076d, B:263:0x073d, B:264:0x0723, B:266:0x05b5, B:267:0x0585, B:269:0x051a, B:270:0x051e, B:272:0x0524, B:273:0x053f, B:274:0x041c, B:275:0x0422, B:277:0x042a, B:278:0x0445, B:280:0x02ed, B:282:0x0273, B:283:0x021f, B:284:0x01d0, B:291:0x00b4, B:293:0x00ba, B:295:0x00c5, B:296:0x00bf, B:298:0x0060, B:303:0x0074, B:306:0x007d, B:308:0x0083, B:310:0x008e, B:312:0x0094, B:314:0x0088, B:315:0x009a, B:323:0x0057, B:34:0x010c, B:36:0x0127, B:13:0x0041, B:15:0x0047), top: B:2:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d3 A[Catch: Exception -> 0x0864, TRY_LEAVE, TryCatch #2 {Exception -> 0x0864, blocks: (B:3:0x001d, B:5:0x0029, B:9:0x0030, B:11:0x003c, B:19:0x00a6, B:21:0x00ac, B:22:0x00c8, B:24:0x00ce, B:26:0x00d3, B:29:0x00f8, B:31:0x00fe, B:40:0x012d, B:42:0x0131, B:43:0x0134, B:44:0x0138, B:46:0x013e, B:49:0x0147, B:51:0x0190, B:52:0x01ef, B:54:0x01f9, B:56:0x020c, B:57:0x0215, B:58:0x0228, B:60:0x0237, B:61:0x0244, B:64:0x0250, B:66:0x0282, B:68:0x0288, B:70:0x028e, B:71:0x02af, B:72:0x02ba, B:74:0x02c4, B:76:0x02ca, B:77:0x02fd, B:79:0x0305, B:81:0x030b, B:82:0x032c, B:83:0x0337, B:85:0x033f, B:87:0x0345, B:88:0x0366, B:89:0x0371, B:91:0x0379, B:93:0x037f, B:94:0x03a0, B:95:0x03ab, B:98:0x03c0, B:100:0x03ca, B:101:0x03d0, B:102:0x03d5, B:104:0x03db, B:106:0x03e9, B:109:0x03f9, B:111:0x03ff, B:112:0x044b, B:114:0x0455, B:117:0x0461, B:119:0x0467, B:120:0x0482, B:121:0x0486, B:123:0x048c, B:124:0x04a7, B:125:0x04aa, B:127:0x04b4, B:129:0x04c3, B:130:0x04e6, B:131:0x04ef, B:134:0x04f9, B:136:0x04ff, B:137:0x0542, B:140:0x054e, B:142:0x0564, B:143:0x058c, B:145:0x0594, B:146:0x05bc, B:148:0x05c0, B:150:0x05d0, B:151:0x05d5, B:153:0x05df, B:154:0x05e8, B:156:0x05ee, B:157:0x05fb, B:159:0x0619, B:161:0x0620, B:162:0x062d, B:164:0x0637, B:165:0x0640, B:167:0x0648, B:169:0x064f, B:170:0x065c, B:172:0x0666, B:173:0x066f, B:174:0x067c, B:176:0x0684, B:183:0x0692, B:186:0x06a0, B:188:0x06c6, B:190:0x06cc, B:191:0x06d1, B:192:0x06cf, B:193:0x06d8, B:195:0x06e0, B:197:0x06e6, B:198:0x06eb, B:199:0x06e9, B:200:0x06f2, B:203:0x06fc, B:205:0x0704, B:206:0x070c, B:208:0x071a, B:210:0x0720, B:211:0x0725, B:213:0x0734, B:215:0x073a, B:216:0x073f, B:219:0x0751, B:222:0x0771, B:224:0x077a, B:225:0x0796, B:227:0x07a2, B:232:0x07b1, B:234:0x07bd, B:236:0x07c7, B:238:0x07de, B:239:0x07f1, B:241:0x07f7, B:242:0x07fc, B:243:0x07fa, B:244:0x07e8, B:245:0x07d0, B:247:0x07d6, B:249:0x0837, B:250:0x0804, B:252:0x0812, B:253:0x0825, B:255:0x082b, B:256:0x0830, B:257:0x082e, B:258:0x081c, B:260:0x0786, B:261:0x076d, B:263:0x073d, B:264:0x0723, B:266:0x05b5, B:267:0x0585, B:269:0x051a, B:270:0x051e, B:272:0x0524, B:273:0x053f, B:274:0x041c, B:275:0x0422, B:277:0x042a, B:278:0x0445, B:280:0x02ed, B:282:0x0273, B:283:0x021f, B:284:0x01d0, B:291:0x00b4, B:293:0x00ba, B:295:0x00c5, B:296:0x00bf, B:298:0x0060, B:303:0x0074, B:306:0x007d, B:308:0x0083, B:310:0x008e, B:312:0x0094, B:314:0x0088, B:315:0x009a, B:323:0x0057, B:34:0x010c, B:36:0x0127, B:13:0x0041, B:15:0x0047), top: B:2:0x001d, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0869  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<String, String> c(String str, c cVar) {
        CampaignEx campaignEx;
        int i;
        CampaignEx.c cVar2;
        String str2;
        String str3;
        String str4;
        String str5 = str;
        String str6 = "rid_n";
        String str7 = CampaignEx.JSON_KEY_EC_TEMP_ID;
        e eVar = new e();
        try {
        } catch (Exception e) {
            e = e;
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return eVar.a();
        }
        if (Arrays.asList(b.g).contains(str5)) {
            return eVar.a();
        }
        if (cVar == null) {
            eVar.a("metrics_data_reason", "metrics 上报时意外为空");
            return eVar.a();
        }
        List arrayList = new ArrayList();
        try {
            if (cVar.i() != null) {
            }
        } catch (Throwable th) {
            p0.b("SameMetricsReport", th.getMessage());
        }
        if (Arrays.asList(b.f).contains(str5)) {
            try {
            } catch (Exception e2) {
                e = e2;
                if (MBridgeConstans.DEBUG) {
                }
                return eVar.a();
            }
            if (!"m_download_start".equals(str5) && !"m_download_end".equals(str5)) {
                List<CampaignEx> j = cVar.j() != null ? cVar.j() : cVar.g();
                if (j != null && j.size() > 0) {
                    arrayList.addAll(j);
                }
                if (arrayList.isEmpty()) {
                    return eVar.a();
                }
                Map<String, Map<String, String>> r = cVar.r();
                List<CampaignEx> list = arrayList;
                String str8 = cVar.o() + str5;
                if (r.containsKey(str8) && r.get(str8) != null && r.get(str8).containsKey("126_exclude")) {
                    try {
                        String str9 = r.get(str8).get("126_exclude");
                        r.get(str8).remove("126_exclude");
                        if ("1".equals(str9)) {
                            return eVar.a();
                        }
                    } catch (Exception e3) {
                        if (MBridgeConstans.DEBUG) {
                            e3.printStackTrace();
                        }
                    }
                }
                for (CampaignEx campaignEx2 : list) {
                    if (campaignEx2 != null) {
                        eVar.a(CampaignEx.KEY_SECOND_REQUEST_CALLBACK_STATE, Integer.valueOf(campaignEx2.getFilterCallBackState()));
                        eVar.a("r_index", Integer.valueOf(campaignEx2.getSecondRequestIndex()));
                        eVar.a("s_show_index", Integer.valueOf(campaignEx2.getSecondShowIndex()));
                        eVar.a(CampaignEx.KEY_SECOND_FILTER_AD_VIDEO_CALL_STATE, Integer.valueOf(campaignEx2.getFilterAdsVideoCallState()));
                        eVar.a(CampaignEx.KEY_SECOND_FILTER_AD_SHOW_CALL_STATE, Integer.valueOf(campaignEx2.getFilterAdsShowCallState()));
                        ArrayList<Integer> rsIgnoreCheckRule = campaignEx2.getRsIgnoreCheckRule();
                        if (rsIgnoreCheckRule != null) {
                            i = 1;
                            campaignEx = campaignEx2;
                            eVar.a("ignore_video", Integer.valueOf(!rsIgnoreCheckRule.contains(0) ? 1 : 0));
                            eVar.a("ignore_template", Integer.valueOf(!rsIgnoreCheckRule.contains(1) ? 1 : 0));
                            eVar.a("ignore_ec", Integer.valueOf(!rsIgnoreCheckRule.contains(2) ? 1 : 0));
                        } else {
                            campaignEx = campaignEx2;
                            i = 1;
                            eVar.a("ignore_video", 1);
                            eVar.a("ignore_template", 1);
                            eVar.a("ignore_ec", 1);
                        }
                        if (TextUtils.isEmpty(campaignEx.getNLRid())) {
                            eVar.a("lrid", campaignEx.getLocalRequestId());
                        } else {
                            eVar.a("n_lrid", campaignEx.getNLRid());
                            if (!TextUtils.isEmpty(campaignEx.getNRid())) {
                                eVar.a("n_rid", campaignEx.getNRid());
                            }
                            eVar.a("lrid", campaignEx.getLocalRequestId());
                        }
                        eVar.a("rid", campaignEx.getRequestId());
                        if (campaignEx.getMof_tplid() != 0) {
                            eVar.a("stid", Integer.valueOf(campaignEx.getMof_tplid()));
                        }
                        CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
                        if (eVar.a(CampaignEx.KEY_LOCAL_CHECK_STATE)) {
                            cVar2 = rewardTemplateMode;
                            eVar.a(CampaignEx.KEY_LOCAL_CHECK_STATE, eVar.b(CampaignEx.KEY_LOCAL_CHECK_STATE) + "," + campaignEx.getLocalCheckShow());
                        } else {
                            cVar2 = rewardTemplateMode;
                            eVar.a(CampaignEx.KEY_LOCAL_CHECK_STATE, Integer.valueOf(campaignEx.getLocalCheckShow()));
                        }
                        if (cVar2 != null && cVar2.f() != 0) {
                            if (eVar.a("vtid")) {
                                eVar.a("vtid", eVar.b("vtid") + "," + cVar2.f());
                            } else {
                                eVar.a("vtid", Integer.valueOf(cVar2.f()));
                            }
                        }
                        if (campaignEx.getCreativeId() == 0) {
                            str2 = str6;
                        } else if (eVar.a("crid")) {
                            str2 = str6;
                            eVar.a("crid", eVar.b("crid") + "," + campaignEx.getCreativeId());
                        } else {
                            str2 = str6;
                            eVar.a("crid", Long.valueOf(campaignEx.getCreativeId()));
                        }
                        if (campaignEx.getVidCrtvId() != 0) {
                            if (eVar.a("video_crid")) {
                                eVar.a("video_crid", eVar.b("video_crid") + "," + campaignEx.getVidCrtvId());
                            } else {
                                eVar.a("video_crid", Long.valueOf(campaignEx.getVidCrtvId()));
                            }
                        }
                        if (campaignEx.getEcCrtvId() != 0) {
                            if (eVar.a("endcard_crid")) {
                                eVar.a("endcard_crid", eVar.b("endcard_crid") + "," + campaignEx.getEcCrtvId());
                            } else {
                                eVar.a("endcard_crid", Long.valueOf(campaignEx.getEcCrtvId()));
                            }
                        }
                        if (campaignEx.getEcTemplateId() != 0) {
                            if (eVar.a(str7)) {
                                eVar.a(str7, eVar.b(str7) + "," + campaignEx.getEcTemplateId());
                            } else {
                                eVar.a(str7, Long.valueOf(campaignEx.getEcTemplateId()));
                            }
                        }
                        eVar.a("bid_tk", campaignEx.getBidToken());
                        if (!TextUtils.isEmpty(campaignEx.getMof_template_url())) {
                            if (u0.i(campaignEx.getMof_template_url())) {
                                eVar.a("sdyv", "1");
                            } else {
                                eVar.a("sdyv", "2");
                            }
                        }
                        if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                            str3 = str7;
                        } else if (!u0.i(campaignEx.getRewardTemplateMode().e())) {
                            str3 = str7;
                            if (eVar.a("vdyv")) {
                                eVar.a("vdyv", eVar.b("vdyv") + ",2");
                            } else {
                                eVar.a("vdyv", "2");
                            }
                        } else if (eVar.a("vdyv")) {
                            str3 = str7;
                            eVar.a("vdyv", eVar.b("vdyv") + ",1");
                        } else {
                            str3 = str7;
                            eVar.a("vdyv", "1");
                        }
                        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
                            if (u0.i(campaignEx.getendcard_url())) {
                                if (eVar.a("edyv")) {
                                    eVar.a("edyv", eVar.b("edyv") + ",1");
                                } else {
                                    eVar.a("edyv", "1");
                                }
                            } else if (eVar.a("edyv")) {
                                eVar.a("edyv", eVar.b("edyv") + ",2");
                            } else {
                                eVar.a("edyv", "2");
                            }
                        }
                        if (!TextUtils.isEmpty(campaignEx.getExt_data())) {
                            JSONObject jSONObject = new JSONObject(campaignEx.getExt_data());
                            if (eVar.a("dspid")) {
                                eVar.a("dspid", eVar.b("dspid") + "," + jSONObject.optString("par_dspid"));
                            } else {
                                eVar.a("dspid", jSONObject.optString("par_dspid"));
                            }
                        }
                        if (campaignEx.getPlayable_ads_without_video() == 2) {
                            if (eVar.a("only_ec")) {
                                eVar.a("only_ec", eVar.b("only_ec") + ",2");
                            } else {
                                eVar.a("only_ec", "2");
                            }
                        } else if (eVar.a("only_ec")) {
                            eVar.a("only_ec", eVar.b("only_ec") + ",1");
                        } else {
                            eVar.a("only_ec", "1");
                        }
                        eVar.a(CampaignEx.JSON_KEY_HB, campaignEx.isBidCampaign() ? "1" : "0");
                        eVar.a(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(campaignEx.getAdSpaceT()));
                        if (eVar.a("cid")) {
                            eVar.a("cid", eVar.b("cid") + "," + campaignEx.getId());
                        } else {
                            eVar.a("cid", campaignEx.getId());
                        }
                        String str10 = str2;
                        if (eVar.a(str10)) {
                            eVar.a(str10, eVar.b(str10) + "," + campaignEx.getRequestIdNotice());
                        } else {
                            eVar.a(str10, campaignEx.getRequestIdNotice());
                        }
                        HashMap<String, String> hashMap = com.mbridge.msdk.foundation.controller.a.r;
                        if (hashMap != null) {
                            String str11 = hashMap.get(campaignEx.getCampaignUnitId());
                            if (!TextUtils.isEmpty(str11)) {
                                eVar.a("u_stid", str11);
                            }
                        }
                        if (!TextUtils.isEmpty(campaignEx.getCampaignUnitId())) {
                            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, campaignEx.getCampaignUnitId());
                        }
                        if (campaignEx.getAdType() != 0) {
                            eVar.a("adtp", Integer.valueOf(campaignEx.getAdType()));
                        }
                        eVar.a(CampaignEx.JSON_KEY_HB, Integer.valueOf(campaignEx.isBidCampaign() ? 1 : 0));
                        eVar.a(CampaignEx.URL_KEY_EXP_IDS, campaignEx.getExpIds());
                        if ("2000047".contains(str5)) {
                            if (campaignEx.getTyped() != -1) {
                                eVar.a("type_d", Integer.valueOf(campaignEx.getTyped()));
                            }
                            if (!TextUtils.isEmpty(campaignEx.getReasond())) {
                                eVar.a("reason_d", campaignEx.getReasond());
                            }
                        }
                        if ("2000048".contains(str5)) {
                            if (campaignEx.getTyped() != -1) {
                                eVar.a("type", Integer.valueOf(campaignEx.getTyped()));
                            }
                            if (!TextUtils.isEmpty(campaignEx.getReasond())) {
                                eVar.a("reason", campaignEx.getReasond());
                            }
                            eVar.a(CampaignEx.JSON_KEY_RETARGET_TYPE, Integer.valueOf(campaignEx.getRtinsType()));
                        }
                        if (campaignEx.getAdType() != 94 && campaignEx.getAdType() != 287) {
                            str6 = str10;
                            str7 = str3;
                        }
                        if (Arrays.asList(b.j).contains(str5)) {
                            eVar.a(CampaignEx.KEY_SHOW_INDEX, Integer.valueOf(campaignEx.getShowIndex()));
                            eVar.a("trigger_show_type", Integer.valueOf(campaignEx.getShowType()));
                            if (Arrays.asList(b.l).contains(str5)) {
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isTemplateRenderSucc() ? a.e : a.f));
                            }
                            if (str5.equals("2000147")) {
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isECTemplateRenderSucc() ? a.e : a.f));
                            }
                        }
                        if (TextUtils.equals(str5, "2000130")) {
                            String e4 = campaignEx.getRewardTemplateMode() != null ? campaignEx.getRewardTemplateMode().e() : "";
                            String str12 = campaignEx.getendcard_url();
                            str4 = str10;
                            eVar.a("ec_full_screen_click", Integer.valueOf((TextUtils.isEmpty(str12) || !str12.contains("alecfc=1")) ? a.h : a.g));
                            eVar.a("temp_full_screen_click", Integer.valueOf((TextUtils.isEmpty(e4) || !e4.contains("alecfc=1")) ? a.h : a.g));
                            int i2 = campaignEx.getPlayable_ads_without_video() == 2 ? i : 0;
                            com.mbridge.msdk.videocommon.setting.c c = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), cVar.w());
                            eVar.a("video_skip_result", Integer.valueOf(c == null ? 2 : c.E()));
                            if (i2 != 0) {
                                eVar.a(CampaignEx.VIDEO_END_TYPE, 2);
                            } else {
                                eVar.a(CampaignEx.VIDEO_END_TYPE, Integer.valueOf(campaignEx.getVideo_end_type()));
                            }
                        } else {
                            str4 = str10;
                        }
                        if (Arrays.asList(b.k).contains(str5)) {
                            int clickTempSource = campaignEx.getClickTempSource();
                            if (clickTempSource == i) {
                                if (campaignEx.getRewardTemplateMode().e().contains("alecfc=1")) {
                                    eVar.a("full_screen_click", Integer.valueOf(a.g));
                                } else {
                                    eVar.a("full_screen_click", Integer.valueOf(a.h));
                                }
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isTemplateRenderSucc() ? a.e : a.f));
                            } else if (clickTempSource == 2) {
                                String str13 = campaignEx.getendcard_url();
                                if ((campaignEx.getMof_tplid() != 501 || TextUtils.isEmpty(campaignEx.getMof_template_url())) ? !TextUtils.isEmpty(str13) ? str13.contains("alecfc=1") : false : campaignEx.getMof_template_url().contains("alecfc=1")) {
                                    eVar.a("full_screen_click", Integer.valueOf(a.g));
                                } else {
                                    eVar.a("full_screen_click", Integer.valueOf(a.h));
                                }
                                eVar.a("temp_display_type", Integer.valueOf(campaignEx.isECTemplateRenderSucc() ? a.e : a.f));
                            }
                            eVar.a(CampaignEx.KEY_CLICK_TEMP_SOURCE, Integer.valueOf(campaignEx.getClickTempSource()));
                            eVar.a("trigger_click_type", Integer.valueOf(campaignEx.getClickType()));
                            eVar.a(CampaignEx.KEY_TRIGGER_CLICK_SOURCE, Integer.valueOf(campaignEx.getTriggerClickSource()));
                        }
                        str5 = str;
                        str6 = str4;
                        str7 = str3;
                    }
                }
                return eVar.a();
            }
            arrayList = a(cVar, str5);
            if (arrayList.isEmpty()) {
            }
        }
        if (cVar.i() != null) {
            arrayList.add(cVar.i());
        } else {
            List<CampaignEx> j2 = cVar.j() != null ? cVar.j() : cVar.g();
            if (j2 != null) {
                arrayList.addAll(j2);
            }
        }
        if (arrayList.isEmpty()) {
        }
    }

    private Map<String, String> d(String str, c cVar) {
        return (cVar == null || TextUtils.isEmpty(str)) ? new HashMap() : cVar.c(str);
    }

    private Map<String, String> e(String str, c cVar) {
        e eVar = new e();
        try {
            if (str.equals("2000125")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000123")));
            } else if (str.equals("2000126")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000125")));
            } else if (str.equals("2000127")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000123")));
            } else if (str.equals("2000154")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000126")));
            } else if (str.equals("2000047")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000123")));
            } else if (str.equals("2000048")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000123")));
            } else if (str.equals("2000155")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000154")));
            } else if (str.equals("2000146")) {
                eVar.a("duration", Long.valueOf(cVar.b("2000130")));
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    public void a(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        Map<String, String> e;
        HashMap hashMap = new HashMap();
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            cVar.j(str);
            Map<String, String> c = c(str, cVar);
            if (c != null) {
                hashMap.putAll(c);
            }
            Map<String, String> a2 = a(str, cVar.w(), mVar);
            if (a2 != null) {
                hashMap.putAll(a2);
            }
            if (Arrays.asList(b.d).contains(str) && (e = e(str, cVar)) != null) {
                hashMap.putAll(e);
            }
            Map<String, String> a3 = a(str, cVar);
            if (a3 != null) {
                hashMap.putAll(a3);
            }
            Map<String, String> b = b(str, cVar);
            if (b != null) {
                hashMap.putAll(b);
            }
            if (!hashMap.containsKey("lrid") || TextUtils.isEmpty(hashMap.get("lrid"))) {
                hashMap.put("lrid", cVar.o());
            }
            if (hashMap.containsKey("lrid")) {
                String str2 = hashMap.get("lrid");
                if (!TextUtils.isEmpty(str2) && str2.contains("label_second")) {
                    hashMap.put("lrid", str2.replace("label_second", ""));
                }
            }
            if (hashMap.containsKey("n_lrid")) {
                String str3 = hashMap.get("n_lrid");
                if (!TextUtils.isEmpty(str3) && str3.contains("label_second")) {
                    hashMap.put("n_lrid", str3.replace("n_lrid", ""));
                }
            }
            Map<String, String> d = d(str, cVar);
            if (d != null) {
                hashMap.putAll(d);
            }
            String str4 = "1";
            if (cVar.c() == null || !cVar.c().equals("1") || !Arrays.asList(b.b).contains(str) || cVar.a() == 296) {
                if (Arrays.asList(b.m).contains(str)) {
                    hashMap.put("use_local_dns", i.b().e() ? "1" : "0");
                    if (!i.b().d()) {
                        str4 = "0";
                    }
                    hashMap.put("local_dns_available", str4);
                }
                com.mbridge.msdk.tracker.e a4 = a(str, hashMap);
                if (mVar != null && a4 != null) {
                    mVar.d(a4);
                }
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public void b(String str, m mVar, c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        if (cVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            cVar.j(str);
            Map<String, String> a2 = a(str, cVar.w(), mVar);
            if (a2 != null) {
                hashMap.putAll(a2);
            }
            Map<String, String> a3 = a(str, cVar);
            if (a3 != null) {
                hashMap.putAll(a3);
            }
            Map<String, String> b = b(str, cVar);
            if (b != null) {
                hashMap.putAll(b);
            }
            Map<String, String> d = d(str, cVar);
            if (d != null) {
                hashMap.putAll(d);
            }
            com.mbridge.msdk.tracker.e a4 = a(str, hashMap);
            if (mVar != null && a4 != null) {
                mVar.d(a4);
            }
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, String> b(String str, c cVar) {
        return cVar != null ? cVar.a(cVar.o() + str) : new HashMap();
    }

    private com.mbridge.msdk.tracker.e a(String str, Map<String, String> map) {
        if (map == null || TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        try {
            JSONObject jSONObject = new JSONObject(map);
            Boolean a2 = com.mbridge.msdk.foundation.same.b.b().a();
            if (a2 != null) {
                jSONObject.put("r_v_r", a2.booleanValue() ? 1 : 0);
            }
            eVar.a(jSONObject);
            eVar.b(0);
            eVar.a(0);
            return eVar;
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return eVar;
        }
    }

    private Map<String, String> a(String str, String str2, m mVar) {
        e eVar = new e();
        try {
            g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d == null) {
                d = h.b().a();
            }
            if (!TextUtils.isEmpty(d.k0())) {
                eVar.a("as_rid", d.k0());
            }
            String J = d.J();
            JSONArray I = d.I();
            if (I != null) {
                int i = 0;
                while (true) {
                    if (i >= I.length()) {
                        break;
                    }
                    if (str.equals(I.getString(i))) {
                        J = "1.0";
                        break;
                    }
                    i++;
                }
            }
            if (!TextUtils.isEmpty(J)) {
                eVar.a("log_rate", J);
            } else {
                eVar.a("log_rate", -1);
            }
            if (!TextUtils.isEmpty(str2)) {
                l d2 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), str2);
                if (d2 != null && !TextUtils.isEmpty(d2.I())) {
                    eVar.a("us_rid", d2.I());
                }
                if (d2 != null && !TextUtils.isEmpty(d2.a())) {
                    eVar.a("u_stid", d2.a());
                }
                e c = d.b().c(str2);
                if (c != null) {
                    if (mVar != null && mVar.c() != null) {
                        try {
                            mVar.c().put("r_stid", c.b("r_stid"));
                            c.c("r_stid");
                        } catch (JSONException unused) {
                        }
                    }
                    eVar.a(c);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        return eVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:6:0x0007, B:8:0x0022, B:11:0x0028, B:13:0x0038, B:16:0x0056, B:18:0x005c, B:20:0x0067, B:22:0x006d, B:23:0x0061, B:24:0x0071, B:26:0x0077, B:27:0x007f, B:29:0x0085, B:31:0x0090, B:33:0x0096, B:34:0x008a, B:36:0x003f, B:38:0x0043, B:40:0x004b, B:42:0x004f), top: B:5:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:6:0x0007, B:8:0x0022, B:11:0x0028, B:13:0x0038, B:16:0x0056, B:18:0x005c, B:20:0x0067, B:22:0x006d, B:23:0x0061, B:24:0x0071, B:26:0x0077, B:27:0x007f, B:29:0x0085, B:31:0x0090, B:33:0x0096, B:34:0x008a, B:36:0x003f, B:38:0x0043, B:40:0x004b, B:42:0x004f), top: B:5:0x0007, inners: #1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x004d -> B:43:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x004f -> B:43:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<CampaignEx> a(c cVar, String str) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (cVar != null) {
            try {
                String str2 = cVar.o() + str;
                Map<String, Map<String, String>> r = cVar.r();
                if (r != null && r.containsKey(str2)) {
                    try {
                        Object obj = r.get(str2).get("resource_type");
                        if (obj instanceof String) {
                            i = Integer.parseInt((String) obj);
                        } else if (obj instanceof Integer) {
                            i = ((Integer) obj).intValue();
                        }
                    } catch (NumberFormatException e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    if (i != 1) {
                        List<CampaignEx> j = cVar.j() != null ? cVar.j() : cVar.g();
                        if (j != null && j.size() > 0) {
                            arrayList.addAll(j);
                        }
                    } else if (cVar.i() != null) {
                        arrayList.add(cVar.i());
                    } else {
                        List<CampaignEx> j2 = cVar.j() != null ? cVar.j() : cVar.g();
                        if (j2 != null && j2.size() > 0) {
                            arrayList.addAll(j2);
                        }
                    }
                }
                i = -1;
                if (i != 1) {
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public Map<String, String> a(String str, c cVar) {
        HashMap hashMap = new HashMap();
        try {
            if (Arrays.asList(b.e).contains(str)) {
                String str2 = "";
                if (cVar != null) {
                    str2 = cVar.c();
                }
                hashMap.put("auto_load", str2);
            }
            if (cVar != null) {
                Map<String, Map<String, String>> r = cVar.r();
                String str3 = cVar.o() + str;
                if (r.containsKey(str3) && r.get(str3) != null) {
                    hashMap.putAll(r.get(str3));
                }
                try {
                    Map<String, Map<String, String>> q = cVar.q();
                    String str4 = cVar.o() + "_" + cVar.l() + "_" + str;
                    if (q.containsKey(str4) && q.get(str4) != null) {
                        hashMap.putAll(q.get(str4));
                        return hashMap;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }
}
