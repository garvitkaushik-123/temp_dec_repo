package com.bytedance.sdk.openadsdk.core;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.core.du.eli.DbA;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.mediationsdk.metadata.a;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import io.ktor.http.ContentDisposition;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static boolean eli(int i) {
        return i == 2 || i == 3 || i == 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [android.util.Pair<com.bytedance.sdk.openadsdk.core.model.eli, java.util.ArrayList<java.lang.Integer>>] */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static Pair<com.bytedance.sdk.openadsdk.core.model.eli, ArrayList<Integer>> eli(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar) {
        ?? r17;
        com.bytedance.sdk.openadsdk.core.model.ev evVar;
        com.bytedance.sdk.openadsdk.core.model.ev evVar2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.model.eli eliVar = new com.bytedance.sdk.openadsdk.core.model.eli();
            eliVar.eli(jSONObject.optString("request_id"));
            eliVar.eli(jSONObject.optInt("ret"));
            eliVar.DbA(jSONObject.optInt("multi_ad_style", 0));
            eliVar.DbA(jSONObject.optString(PglCryptUtils.KEY_MESSAGE));
            String optString = jSONObject.optString("gdid_encrypted");
            eliVar.eli(com.bytedance.sdk.openadsdk.core.model.CMM.eli(jSONObject.optJSONObject("loop_config")));
            String optString2 = jSONObject.optString("auction_price");
            if (eliVar.Os() != 0) {
                return null;
            }
            eliVar.eli(com.bytedance.sdk.openadsdk.core.model.Vy.eli(jSONObject.optString("multi_ad_config")));
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                optJSONArray.length();
                int i = 0;
                ArrayList arrayList2 = eliVar.aAs() ? new ArrayList() : null;
                while (i < optJSONArray.length()) {
                    com.bytedance.sdk.openadsdk.core.model.ev eli2 = eli(optJSONArray.optJSONObject(i), adSlot, ujqVar, eliVar, i);
                    ?? r9 = arrayList2;
                    if (!eliVar.aAs()) {
                        r9 = evVar2;
                    }
                    int eli3 = eli(eli2);
                    if (eli3 != 200) {
                        if (eli2 != null) {
                            com.bytedance.sdk.openadsdk.aGH.Os.DbA(eli2, dZ.Os(eli2.bBQ()), eli3);
                        } else {
                            com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar2, "", eli3);
                        }
                        arrayList.add(Integer.valueOf(eli3));
                        if (r9 == 0 || eli2 == null) {
                            evVar = evVar2;
                        } else {
                            r17 = evVar2;
                            try {
                                r9.add(new eli(eli2.Uv(), eli3));
                                evVar = r17;
                            } catch (Throwable th) {
                                th = th;
                                com.bytedance.sdk.component.utils.Xb.Os("TTAD.AdInfoFactory", th.getMessage());
                                return r17;
                            }
                        }
                        if (eli2 != null && (eli2.mm() == 39 || eli2.mm() == 41)) {
                            eliVar.DbA(0);
                        }
                        optJSONArray.remove(i);
                        i--;
                    } else {
                        evVar = evVar2;
                        eli2.nn(optString2);
                        if (!TextUtils.isEmpty(optString)) {
                            eli2.FC(optString);
                        }
                        eliVar.eli(eli2);
                    }
                    i++;
                    evVar2 = evVar;
                    arrayList2 = r9;
                }
                r17 = evVar2;
                List<com.bytedance.sdk.openadsdk.core.model.ev> aGH = eliVar.aGH();
                eli(aGH, eliVar);
                if (aGH != null) {
                    if (eliVar.aAs() && aGH.size() == 1) {
                        eliVar.DbA(0);
                        aGH.get(0).wC(false);
                    }
                    int size = aGH.size();
                    jSONObject.put("creatives", optJSONArray);
                    for (int i2 = 0; i2 < size; i2++) {
                        com.bytedance.sdk.openadsdk.core.model.ev evVar3 = aGH.get(i2);
                        if (evVar3 != null) {
                            evVar3.nro(jSONObject.toString());
                        }
                    }
                }
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    eli((ArrayList<eli>) arrayList2);
                }
            } else {
                r17 = 0;
            }
            return new Pair<>(eliVar, arrayList);
        } catch (Throwable th2) {
            th = th2;
            r17 = evVar2;
        }
    }

    private static void eli(List<com.bytedance.sdk.openadsdk.core.model.ev> list, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.ev evVar = list.get(0);
        if (!eliVar.aAs() || evVar == null || !evVar.gnF() || dZ.GB() == 0) {
            return;
        }
        eliVar.DbA(0);
        evVar.wC(false);
    }

    public static com.bytedance.sdk.openadsdk.core.model.ev eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return eli(jSONObject, null, null, null, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x068d, code lost:
    
        if (r17.optBoolean("is_html", false) != false) goto L171;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.bytedance.sdk.openadsdk.core.model.ev eli(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.ujq ujqVar, com.bytedance.sdk.openadsdk.core.model.eli eliVar, int i) {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA;
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA2;
        com.bytedance.sdk.openadsdk.core.du.eli eliVar2;
        DbA.eli eliVar3;
        com.bytedance.sdk.openadsdk.core.du.eli eliVar4;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.ev evVar = new com.bytedance.sdk.openadsdk.core.model.ev();
        if (eliVar != null) {
            evVar.eli(eliVar);
            if (eliVar.aAs()) {
                int optInt = jSONObject.optInt("interaction_method");
                if (optInt == 30 || optInt == 39 || optInt == 40 || optInt == 41 || optInt == 43 || optInt == 44) {
                    evVar.wC(true);
                } else {
                    eliVar.DbA(0);
                    evVar.wC(false);
                }
            }
        }
        evVar.eli(i);
        eli(jSONObject, evVar);
        JSONObject optJSONObject4 = jSONObject.optJSONObject("multi_ad_scene");
        if (optJSONObject4 != null) {
            evVar.eli(com.bytedance.sdk.openadsdk.core.model.gG.eli(optJSONObject4));
        }
        if (jSONObject.has("raw_response_info")) {
            evVar.nro(jSONObject.optString("raw_response_info"));
        }
        evVar.aAs(jSONObject.optInt("proportion_watching", -1));
        evVar.NU(jSONObject.optBoolean("mate_disable_cache", false));
        evVar.ujq(jSONObject.optInt("interaction_type"));
        evVar.gG(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.ev.Os, 0));
        evVar.Ue(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.ev.DbA, 0));
        evVar.KM(jSONObject.optInt(com.bytedance.sdk.openadsdk.core.model.ev.aGH, 0));
        evVar.nGm(jSONObject.optString("target_url"));
        evVar.ev(jSONObject.optString("ad_id"));
        evVar.Vy(jSONObject.optString("app_log_url"));
        evVar.gG(jSONObject.optString("settings_url"));
        evVar.aqO(jSONObject.optString("source"));
        evVar.dV(jSONObject.optString("app_name"));
        evVar.qj(jSONObject.optInt("dislike_control", 0));
        evVar.Xb(jSONObject.optInt("play_bar_show_time", AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES));
        evVar.Ue(jSONObject.optString("gecko_id"));
        if (jSONObject.has("set_click_type")) {
            JSONObject optJSONObject5 = jSONObject.optJSONObject("set_click_type");
            evVar.DbA(optJSONObject5.optDouble("cta", 2.0d));
            evVar.eli(optJSONObject5.optDouble("other", 1.0d));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("extension");
        evVar.MGA(optJSONObject6);
        if (optJSONObject6 != null) {
            evVar.eli(new com.bytedance.sdk.openadsdk.core.model.dV(optJSONObject6));
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("icon");
        evVar.FC(jSONObject.optBoolean("screenshot", false));
        evVar.nGm(jSONObject.optInt("play_bar_style", 0));
        evVar.KM(jSONObject.optString("market_url", ""));
        evVar.aqO(jSONObject.optInt("video_adaptation", 0));
        evVar.NU(jSONObject.optInt("feed_video_opentype", 0));
        evVar.Os(jSONObject.optJSONObject("session_params"));
        JSONObject optJSONObject8 = jSONObject.optJSONObject("dynamic_configs");
        evVar.aGH(optJSONObject8);
        if (optJSONObject8 != null && (optJSONObject3 = optJSONObject8.optJSONObject("speed_config")) != null) {
            com.bytedance.sdk.openadsdk.core.model.VM vm = new com.bytedance.sdk.openadsdk.core.model.VM();
            vm.eli((float) optJSONObject3.optDouble("speed", 1.0d));
            vm.eli(optJSONObject3.optInt("type", 0));
            evVar.eli(vm);
        }
        evVar.nn(jSONObject.optString("auction_price", ""));
        evVar.dZ(jSONObject.optInt("mrc_report", 0));
        if (jSONObject.optBoolean("isMrcReportFinish", false)) {
            evVar.Spd();
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("render");
        if (optJSONObject9 != null) {
            evVar.nn(optJSONObject9.optInt("render_sequence", 0));
            evVar.Dfc(optJSONObject9.optInt("backup_render_control", 1));
            evVar.SSo(optJSONObject9.optInt("reserve_time", 100));
            evVar.Uv(optJSONObject9.optInt("render_thread", 0));
        }
        evVar.du(jSONObject.optInt("render_control", ujqVar != null ? ujqVar.FC : 1));
        if (optJSONObject7 != null) {
            com.bytedance.sdk.openadsdk.core.model.nGm ngm = new com.bytedance.sdk.openadsdk.core.model.nGm();
            ngm.eli(optJSONObject7.optString("url"));
            ngm.DbA(optJSONObject7.optInt("height"));
            ngm.eli(optJSONObject7.optInt("width"));
            evVar.eli(ngm);
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("reward_data");
        if (optJSONObject10 != null) {
            evVar.FC(optJSONObject10.optInt("reward_amount", 0));
            evVar.nlS(optJSONObject10.optString("reward_name", ""));
        }
        JSONObject optJSONObject11 = jSONObject.optJSONObject("cover_image");
        if (optJSONObject11 != null) {
            com.bytedance.sdk.openadsdk.core.model.nGm ngm2 = new com.bytedance.sdk.openadsdk.core.model.nGm();
            ngm2.eli(optJSONObject11.optString("url"));
            ngm2.DbA(optJSONObject11.optInt("height"));
            ngm2.eli(optJSONObject11.optInt("width"));
            evVar.DbA(ngm2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.bytedance.sdk.openadsdk.core.model.nGm ngm3 = new com.bytedance.sdk.openadsdk.core.model.nGm();
                JSONObject optJSONObject12 = optJSONArray.optJSONObject(i2);
                ngm3.eli(optJSONObject12.optString("url"));
                ngm3.DbA(optJSONObject12.optInt("height"));
                ngm3.eli(optJSONObject12.optInt("width"));
                ngm3.eli(optJSONObject12.optBoolean("image_preview"));
                ngm3.DbA(optJSONObject12.optString("image_key"));
                evVar.Os(ngm3);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                evVar.tpZ().add(optJSONArray2.optString(i3));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray(CampaignEx.JSON_KEY_CLICK_URL);
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                evVar.ZLD().add(optJSONArray3.optString(i4));
            }
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("play_start");
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                evVar.ID().add(optJSONArray4.optString(i5));
            }
        }
        JSONObject optJSONObject13 = jSONObject.optJSONObject("click_area");
        if (optJSONObject13 != null) {
            com.bytedance.sdk.openadsdk.core.model.du duVar = new com.bytedance.sdk.openadsdk.core.model.du();
            duVar.eli = optJSONObject13.optBoolean("click_upper_content_area", true);
            duVar.DbA = optJSONObject13.optBoolean("click_upper_non_content_area", true);
            duVar.Os = optJSONObject13.optBoolean("click_lower_content_area", true);
            duVar.aGH = optJSONObject13.optBoolean("click_lower_non_content_area", true);
            duVar.ui = optJSONObject13.optBoolean("click_button_area", true);
            duVar.MGA = optJSONObject13.optBoolean("click_video_area", true);
            evVar.eli(duVar);
        }
        JSONObject optJSONObject14 = jSONObject.optJSONObject("adslot");
        if (optJSONObject14 != null) {
            evVar.eli(DbA(optJSONObject14));
        } else {
            evVar.eli(adSlot);
        }
        if (adSlot != null) {
            Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
            if (requestExtraMap != null && requestExtraMap.containsKey("admob_watermark")) {
                evVar.aAs(String.valueOf(requestExtraMap.get("admob_watermark")));
            }
        } else {
            evVar.aAs(jSONObject.optString("identificationOverlayContent"));
        }
        evVar.QX(jSONObject.optInt("intercept_flag", 0));
        evVar.QX(jSONObject.optString("phone_num"));
        evVar.Xb(jSONObject.optString("title"));
        evVar.bf(jSONObject.optString("description"));
        evVar.CMM(jSONObject.optString("button_text"));
        evVar.dV(jSONObject.optInt("ad_logo", 1));
        evVar.ujq(jSONObject.optString("ext"));
        evVar.ev(jSONObject.optInt("cover_click_area", 0));
        evVar.VM(jSONObject.optInt("image_mode"));
        evVar.oWW(jSONObject.optInt("orientation", 1));
        evVar.eli((float) jSONObject.optDouble("aspect_ratio", 100.0d));
        evVar.ev(jSONObject.optInt("cover_click_area", 0));
        JSONObject optJSONObject15 = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        JSONObject optJSONObject16 = jSONObject.optJSONObject(CampaignEx.JSON_KEY_DEEP_LINK_URL);
        JSONObject optJSONObject17 = jSONObject.optJSONObject("oem");
        evVar.Os(jSONObject.optInt("is_web_jump_ip", 0));
        evVar.eli(com.bytedance.sdk.openadsdk.core.model.Ue.eli(optJSONObject17));
        evVar.eli(MGA(optJSONObject15));
        JSONObject optJSONObject18 = jSONObject.optJSONObject("interaction_method_params");
        evVar.eli(FC(jSONObject.optJSONObject("arbitrage_interceptor_params")));
        evVar.eli(kb(optJSONObject18));
        evVar.eli(wC(optJSONObject18));
        evVar.eli(du(optJSONObject16));
        evVar.eli(new com.bytedance.sdk.openadsdk.core.model.KM(jSONObject));
        JSONArray optJSONArray5 = jSONObject.optJSONArray("filter_words");
        if (optJSONArray5 != null) {
            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                FilterWord ui = ui(optJSONArray5.optJSONObject(i6));
                if (ui != null && ui.isValid()) {
                    evVar.eli(ui);
                }
            }
        }
        evVar.GB(jSONObject.optInt("count_down"));
        evVar.DbA(jSONObject.optLong("expiration_time"));
        evVar.Za(jSONObject.optInt("video_encode_type", 0));
        evVar.jh(0);
        JSONObject optJSONObject19 = jSONObject.optJSONObject("video");
        if (optJSONObject19 != null) {
            dbA = eli(optJSONObject19, evVar, true);
            evVar.DbA(dbA);
            evVar.ui(optJSONObject19.optInt("multi_played_percent", 50));
        } else {
            dbA = null;
        }
        JSONObject optJSONObject20 = jSONObject.optJSONObject("h265_video");
        if (optJSONObject20 != null) {
            dbA2 = eli(optJSONObject20, evVar, false);
            evVar.Os(dbA2);
        } else {
            dbA2 = null;
        }
        if (evVar.zr() == 0) {
            evVar.eli(dbA);
            evVar.Za(0);
        } else {
            if (dbA2 != null && dbA != null) {
                if (TextUtils.isEmpty(dbA2.nlS())) {
                    dbA2.aGH(dbA.nlS());
                }
                if (TextUtils.isEmpty(dbA2.NU())) {
                    dbA2.ui(dbA.NU());
                }
                if (dbA2.aGH() == -1) {
                    dbA2.aGH(dbA.aGH());
                }
            }
            if (dbA2 != null) {
                evVar.eli(dbA2);
            } else {
                evVar.eli(dbA);
            }
        }
        JSONObject optJSONObject21 = jSONObject.optJSONObject("download_conf");
        if (optJSONObject21 != null) {
            evVar.eli(aAs(optJSONObject21));
        }
        evVar.eli(nlS(jSONObject.optJSONObject("media_ext")));
        JSONObject optJSONObject22 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject22 != null) {
            ev.eli eliVar5 = new ev.eli();
            eliVar5.Os(optJSONObject22.optString("id"));
            eliVar5.aGH(optJSONObject22.optString("md5"));
            eliVar5.ui(optJSONObject22.optString("url"));
            eliVar5.MGA(optJSONObject22.optString("data"));
            eliVar5.kb(optJSONObject22.optString("diff_data"));
            String optString = optJSONObject22.optString("dynamic_creative");
            eliVar5.wC(optString);
            eliVar5.DbA(optJSONObject22.optString("version"));
            eliVar5.FC(optJSONObject22.optString("media_view"));
            try {
                ArrayList arrayList = new ArrayList();
                JSONObject jSONObject2 = new JSONObject(optString);
                JSONArray optJSONArray6 = jSONObject2.optJSONArray("tag_ids");
                if (optJSONArray6 != null) {
                    for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                        arrayList.add(Integer.valueOf(optJSONArray6.optInt(i7)));
                    }
                }
                String optString2 = jSONObject2.optString("music_url");
                eliVar5.eli(arrayList);
                eliVar5.eli(optString2);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.Xb.Os("TTAD.AdInfoFactory", e.getMessage());
            }
            eliVar5.aAs(optJSONObject22.optString("engine_version"));
            eliVar5.du(optJSONObject22.optString("ugen_url"));
            eliVar5.nlS(optJSONObject22.optString("ugen_md5"));
            eliVar5.NU(optJSONObject22.optString("ugen_data"));
            evVar.eli(eliVar5);
        }
        JSONObject optJSONObject23 = jSONObject.optJSONObject("tpl_info_v3");
        if (optJSONObject23 != null) {
            evVar.eli(com.bytedance.sdk.openadsdk.core.model.oWW.eli(optJSONObject23));
        }
        JSONObject optJSONObject24 = jSONObject.optJSONObject("dynamic_creative");
        if (optJSONObject24 != null) {
            evVar.DbA(optJSONObject24);
        }
        evVar.Dfc(jSONObject.optString("creative_extra"));
        evVar.nlS(jSONObject.optInt("if_block_lp", 0));
        evVar.bf(jSONObject.optInt("cache_sort", 1));
        evVar.CMM(jSONObject.optInt("if_sp_cache", 0));
        JSONObject optJSONObject25 = jSONObject.optJSONObject("splash_control");
        if (optJSONObject25 != null) {
            evVar.eli(aGH(optJSONObject25));
        }
        evVar.nro(jSONObject.optInt("is_package_open", 1));
        evVar.NU(jSONObject.optString("ad_info", null));
        int i8 = 2;
        evVar.Vy(jSONObject.optInt("ua_policy", 2));
        evVar.Cp(jSONObject.optInt("playable_duration_time", 20));
        evVar.cyF(jSONObject.optInt("playable_endcard_close_time", -1));
        evVar.eU(jSONObject.optInt("endcard_close_time", -1));
        evVar.kb(jSONObject.optInt("interaction_method"));
        evVar.WfR(jSONObject.optInt("lp_click_type", -1));
        evVar.aGH(jSONObject.optInt("lp_click_interval", -1));
        evVar.VM(jSONObject.optString("dsp_html"));
        evVar.MGA(jSONObject.optInt("image_stay", 0));
        int optInt2 = jSONObject.optInt("dsp_material_type", 0);
        if (optInt2 < 0 || optInt2 > 3) {
            optInt2 = 0;
        }
        if (optInt2 == 0) {
            if (jSONObject.optBoolean("is_vast", false)) {
                optInt2 = 1;
            }
        }
        i8 = optInt2;
        evVar.tGZ(i8);
        if (i8 == 1 || i8 == 3) {
            int bBQ = evVar.bBQ();
            if (bBQ < 0) {
                if (evVar.XU() != null) {
                    bBQ = evVar.XU().getDurationSlotType();
                } else {
                    bBQ = evVar.cK();
                }
            }
            String Os = dZ.Os(bBQ);
            if (jSONObject.has("vast_json")) {
                eliVar4 = com.bytedance.sdk.openadsdk.core.du.eli.eli(jSONObject.optJSONObject("vast_json"));
            } else {
                String optString3 = jSONObject.optString("dsp_vast");
                if (TextUtils.isEmpty(optString3)) {
                    eli(evVar, Os);
                    return null;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Pair<com.bytedance.sdk.openadsdk.core.du.eli, DbA.eli> eli2 = eli(optString3, evVar.WO(), bBQ);
                if (eli2 != null) {
                    com.bytedance.sdk.openadsdk.core.du.eli eliVar6 = (com.bytedance.sdk.openadsdk.core.du.eli) eli2.first;
                    eliVar3 = (DbA.eli) eli2.second;
                    eliVar2 = eliVar6;
                } else {
                    eliVar2 = null;
                    eliVar3 = null;
                }
                com.bytedance.sdk.openadsdk.core.du.Os.aGH.DbA(evVar, Os, eliVar2, elapsedRealtime, eliVar3);
                eliVar4 = eliVar2;
            }
            if (eliVar4 == null) {
                return null;
            }
            eli(eliVar4, evVar);
        }
        evVar.GB(jSONObject.optString("deep_link_appname", ""));
        evVar.ikX(jSONObject.optInt("landing_page_download_clicktype", 1));
        JSONObject optJSONObject26 = jSONObject.optJSONObject("dsp_style");
        if (optJSONObject26 != null) {
            evVar.eli(new com.bytedance.sdk.openadsdk.core.model.Dfc(optJSONObject26));
        }
        JSONObject optJSONObject27 = jSONObject.optJSONObject("dsp_adchoices");
        if (optJSONObject27 != null) {
            evVar.kb(optJSONObject27.optString("adchoices_icon", ""));
            evVar.wC(optJSONObject27.optString("adchoices_url", ""));
        }
        String optString4 = jSONObject.optString("gdid_encrypted");
        if (!TextUtils.isEmpty(optString4)) {
            evVar.FC(optString4);
        }
        evVar.ikX();
        JSONObject optJSONObject28 = jSONObject.optJSONObject("ugen");
        if (optJSONObject28 != null && (optJSONObject2 = optJSONObject28.optJSONObject("endcard")) != null) {
            evVar.eli(Os(optJSONObject2));
            JSONObject optJSONObject29 = optJSONObject2.optJSONObject("overlay");
            if (optJSONObject29 != null) {
                evVar.DbA(Os(optJSONObject29));
            }
        }
        evVar.aGH(jSONObject.optInt("preload_h5_type", 0));
        evVar.kb(jSONObject.optBoolean("hasReportShow", false));
        evVar.du(jSONObject.optString("endcard_creative", ""));
        evVar.kb(jSONObject.optJSONObject("ad_label"));
        JSONObject optJSONObject30 = jSONObject.optJSONObject("ev");
        if (optJSONObject30 != null) {
            evVar.nn(optJSONObject30.optBoolean(a.j, com.bytedance.sdk.openadsdk.Vy.eli.Os.eli));
            evVar.ow(optJSONObject30.optInt("wait_time", com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA));
            evVar.Cp(optJSONObject30.optString("label", com.bytedance.sdk.openadsdk.Vy.eli.Os.Os));
            evVar.eli(new com.bytedance.sdk.openadsdk.Vy.eli.DbA(evVar));
        }
        if (jSONObject.has("banner") && (optJSONObject = jSONObject.optJSONObject("banner")) != null) {
            evVar.eli(new PAGBannerSize(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0)));
        }
        JSONArray optJSONArray7 = jSONObject.optJSONArray("ad_tracks");
        if (optJSONArray7 != null && optJSONArray7.length() > 0) {
            com.bytedance.sdk.openadsdk.core.model.ui uiVar = new com.bytedance.sdk.openadsdk.core.model.ui(optJSONArray7);
            if (uiVar.aGH()) {
                evVar.eli(uiVar);
            }
        }
        return evVar;
    }

    private static void eli(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("iv_skip_time", -1);
            int optInt2 = jSONObject.optInt("rv_skip_time", -1);
            if (optInt != -1) {
                evVar.TfR(optInt);
            }
            if (optInt2 != -1) {
                evVar.QI(optInt2);
            }
        }
    }

    private static com.bytedance.sdk.openadsdk.core.aAs.wC.eli Os(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.aAs.wC.eli eliVar = new com.bytedance.sdk.openadsdk.core.aAs.wC.eli();
        eliVar.eli(jSONObject.optString("id"));
        eliVar.DbA(jSONObject.optString("md5"));
        eliVar.Os(jSONObject.optString("url"));
        return eliVar;
    }

    private static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("reason_code", -1);
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, -1);
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str, "load_vast_fail", jSONObject);
        } catch (Exception unused) {
        }
    }

    private static Pair<com.bytedance.sdk.openadsdk.core.du.eli, DbA.eli> eli(String str, int i, int i2) {
        int i3;
        int i4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 == 1 || i2 == 5) {
            i3 = 0;
            i4 = 0;
        } else {
            i3 = SSo.Os(dV.eli());
            i4 = SSo.ui(dV.eli());
            if (i == 2) {
                i4 = i3;
                i3 = i4;
            }
        }
        com.bytedance.sdk.openadsdk.core.du.eli.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.du.eli.eli.ui(dV.eli(), i3, i4);
        return new Pair<>(uiVar.eli(str, (File) null, new ArrayList()), uiVar.MGA);
    }

    private static void eli(com.bytedance.sdk.openadsdk.core.du.eli eliVar, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        eliVar.eli(evVar);
        if (!eli(evVar.yw())) {
            evVar.ujq(2);
        }
        evVar.du(1);
        evVar.eli(eliVar);
        if (!TextUtils.isEmpty(eliVar.aGH())) {
            evVar.Xb(eliVar.aGH());
        }
        if (!TextUtils.isEmpty(eliVar.ui())) {
            evVar.bf(eliVar.ui());
        }
        evVar.nGm(eliVar.MGA());
        evVar.eli((com.bytedance.sdk.openadsdk.core.model.MGA) null);
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
        if (nY == null) {
            nY = new com.bykv.vk.openvk.eli.eli.eli.Os.DbA();
        }
        nY.Os(eliVar.kb());
        nY.eli(eliVar.wC());
        nY.MGA((String) null);
        nY.DbA((String) null);
        nY.aGH((String) null);
        evVar.eli(nY);
        if (eliVar.DbA() != null && !TextUtils.isEmpty(eliVar.DbA().ui())) {
            com.bytedance.sdk.openadsdk.core.model.nGm ngm = new com.bytedance.sdk.openadsdk.core.model.nGm();
            ngm.eli(eliVar.DbA().ui());
            ngm.eli(eliVar.DbA().DbA());
            ngm.DbA(eliVar.DbA().Os());
            evVar.eli(ngm);
            return;
        }
        if (evVar.SjY() == null) {
            com.bytedance.sdk.openadsdk.core.model.nGm ngm2 = new com.bytedance.sdk.openadsdk.core.model.nGm();
            ngm2.eli("https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/static/images/2023620white.jpeg");
            ngm2.eli(98);
            ngm2.DbA(98);
            evVar.eli(ngm2);
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.kb aGH(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("splash_clickarea", 2);
        int optInt2 = jSONObject.optInt("splash_layout_id", 1);
        long optLong = jSONObject.optLong("load_wait_time", 0L);
        long j = optLong >= 0 ? optLong : 0L;
        int optInt3 = jSONObject.optInt("skip_time", -1);
        com.bytedance.sdk.openadsdk.core.model.kb kbVar = new com.bytedance.sdk.openadsdk.core.model.kb();
        kbVar.DbA(optInt);
        kbVar.Os(optInt2);
        kbVar.eli(j);
        kbVar.eli(optInt3);
        return kbVar;
    }

    public static AdSlot DbA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("mCodeId", "");
        int optInt = jSONObject.optInt("mImgAcceptedWidth", 0);
        int optInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
        float optDouble = (float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
        float optDouble2 = (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
        int optInt3 = jSONObject.optInt("mAdCount", 6);
        boolean optBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
        String optString2 = jSONObject.optString("mRewardName", "");
        int optInt4 = jSONObject.optInt("mRewardAmount", 0);
        String optString3 = jSONObject.optString("mMediaExtra", "");
        String optString4 = jSONObject.optString("mUserID", "");
        jSONObject.optInt("mOrientation", 2);
        int optInt5 = jSONObject.optInt("mNativeAdType", 0);
        boolean optBoolean2 = jSONObject.optBoolean("mIsAutoPlay", false);
        boolean optBoolean3 = jSONObject.optBoolean("mIsExpressAd", false);
        String optString5 = jSONObject.optString("mBidAdm", "");
        return new AdSlot.Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize(optDouble, optDouble2).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setNativeAdType(optInt5).setIsAutoPlay(optBoolean2).isExpressAd(optBoolean3).withBid(optString5).setDurationSlotType(jSONObject.optInt("mDurationSlotType", 0)).build();
    }

    private static FilterWord ui(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FilterWord ui = ui(optJSONArray.optJSONObject(i));
                    if (ui != null && ui.isValid()) {
                        filterWord.addOption(ui);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.model.MGA MGA(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.MGA mga = new com.bytedance.sdk.openadsdk.core.model.MGA();
        mga.DbA(jSONObject.optString("app_name"));
        mga.Os(jSONObject.optString("package_name"));
        mga.eli(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        mga.eli(jSONObject.optDouble(FirebaseAnalytics.Param.SCORE, -1.0d));
        mga.eli(jSONObject.optInt("comment_num", -1));
        mga.DbA(jSONObject.optInt(CampaignEx.JSON_KEY_APP_SIZE, 0));
        mga.aGH(jSONObject.optString("app_category"));
        return mga;
    }

    private static com.bytedance.sdk.openadsdk.core.model.bf kb(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.bf bfVar = new com.bytedance.sdk.openadsdk.core.model.bf();
        if (jSONObject == null) {
            bfVar.eli(10L);
            bfVar.DbA(20L);
            bfVar.Os(10L);
            bfVar.aGH(20L);
            bfVar.eli("");
            return bfVar;
        }
        bfVar.eli(jSONObject.optLong("onlylp_loading_maxtime", 10L));
        bfVar.DbA(jSONObject.optLong("straight_lp_showtime", 20L));
        bfVar.Os(jSONObject.optLong("onlyagg_loading_maxtime", 10L));
        bfVar.aGH(jSONObject.optLong("straight_agg_showtime", 20L));
        bfVar.eli(jSONObject.optString("loading_text", ""));
        return bfVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.QX wC(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.QX qx = new com.bytedance.sdk.openadsdk.core.model.QX();
        if (jSONObject == null) {
            qx.aGH(5);
            qx.ui(30);
            qx.MGA(70);
            qx.kb(1);
            qx.wC(com.bytedance.sdk.openadsdk.core.model.QX.eli);
            qx.Os(0);
            qx.DbA(0);
            qx.eli(3);
            return qx;
        }
        qx.aGH(jSONObject.optInt("ceiling_time", 5));
        qx.ui(jSONObject.optInt("ceiling_ratio", 30));
        qx.MGA(jSONObject.optInt("expand_ratio", 70));
        qx.kb(jSONObject.optInt("back_type", 1));
        qx.wC(jSONObject.optInt("boc_return_type", com.bytedance.sdk.openadsdk.core.model.QX.eli));
        qx.Os(jSONObject.optInt("pre_render_status", 0));
        qx.DbA(jSONObject.optInt("pre_render_use_gecko", 0));
        qx.eli(jSONObject.optInt("pre_render_add_type", 3));
        return qx;
    }

    private static com.bytedance.sdk.openadsdk.core.model.wC FC(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.model.wC wCVar = new com.bytedance.sdk.openadsdk.core.model.wC();
        if (jSONObject == null) {
            wCVar.Os(0);
            wCVar.aGH(0);
            wCVar.DbA(new ArrayList());
            wCVar.ui(0);
            wCVar.eli(new ArrayList());
            wCVar.DbA(0);
            wCVar.eli(0);
            return wCVar;
        }
        wCVar.Os(jSONObject.optInt("interceptor_x", 0));
        wCVar.aGH(jSONObject.optInt("interceptor_y", 0));
        JSONArray optJSONArray = jSONObject.optJSONArray("interceptor_page");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(optJSONArray.optInt(i)));
            }
        }
        wCVar.DbA(arrayList);
        wCVar.ui(jSONObject.optInt("interceptor_interval_time", 0));
        JSONArray optJSONArray2 = jSONObject.optJSONArray("url_regular");
        ArrayList arrayList2 = new ArrayList();
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                arrayList2.add(optJSONArray2.optString(i2));
            }
        }
        wCVar.eli(arrayList2);
        wCVar.DbA(jSONObject.optInt("boc_index", 0));
        wCVar.eli(jSONObject.optInt("is_act", 0));
        return wCVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.nn aAs(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.nn nnVar = new com.bytedance.sdk.openadsdk.core.model.nn();
        nnVar.eli(jSONObject.optInt("if_send_click", 0));
        return nnVar;
    }

    private static com.bytedance.sdk.openadsdk.core.model.NU du(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.model.NU nu = new com.bytedance.sdk.openadsdk.core.model.NU();
        nu.eli(jSONObject.optString("deeplink_url"));
        nu.DbA(jSONObject.optString("fallback_url"));
        nu.eli(jSONObject.optInt("fallback_type"));
        return nu;
    }

    private static com.bykv.vk.openvk.eli.eli.eli.Os.DbA eli(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ev evVar, boolean z) {
        int optInt;
        if (jSONObject == null) {
            return null;
        }
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA = new com.bykv.vk.openvk.eli.eli.eli.Os.DbA();
        dbA.DbA(jSONObject.optInt("cover_height"));
        dbA.Os(jSONObject.optInt("cover_width"));
        dbA.eli(jSONObject.optString("resolution"));
        dbA.eli(jSONObject.optLong(ContentDisposition.Parameters.Size));
        double optDouble = jSONObject.optDouble("video_duration", 0.0d);
        dbA.eli(optDouble);
        int i = 1;
        int optInt2 = jSONObject.optInt("replay_time", 1);
        if (optDouble <= 15.0d && evVar.BDs() != 1 && com.bytedance.sdk.openadsdk.core.model.ev.ui(evVar)) {
            i = optInt2;
        }
        dbA.aAs(i);
        dbA.DbA(jSONObject.optString("cover_url"));
        dbA.Os(jSONObject.optString("video_url"));
        dbA.aGH(jSONObject.optString("endcard"));
        dbA.ui(jSONObject.optString("playable_download_url"));
        dbA.MGA(jSONObject.optString("file_hash"));
        dbA.wC(jSONObject.optInt("if_playable_loading_show", 0));
        dbA.FC(jSONObject.optInt("remove_loading_page_type", 0));
        dbA.eli(jSONObject.optInt("fallback_endcard_judge", 0));
        dbA.ui(jSONObject.optInt("video_preload_size", 307200));
        dbA.MGA(jSONObject.optInt("reward_video_cached_type", 0));
        dbA.kb(jSONObject.optInt("execute_cached_type", 0));
        if (z) {
            optInt = jSONObject.optInt("endcard_render", 0);
        } else {
            optInt = jSONObject.optInt("endcard_render", -1);
        }
        dbA.aGH(optInt);
        return dbA;
    }

    private static Map<String, Object> nlS(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        if (r0 != 50) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null) {
            com.bytedance.sdk.openadsdk.aGH.Os.Os((com.bytedance.sdk.openadsdk.core.model.ev) null, "", 401);
            return 401;
        }
        String Os = dZ.Os(evVar.bBQ());
        if (TextUtils.isEmpty(evVar.umh()) || evVar.umh().length() <= 1) {
            com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, TTAdConstant.AD_ID_IS_NULL_CODE);
            return TTAdConstant.AD_ID_IS_NULL_CODE;
        }
        if (evVar.Jt()) {
            if (evVar.bBQ() < 0) {
                if (evVar.XU() != null) {
                    evVar.XU().getDurationSlotType();
                } else {
                    evVar.cK();
                }
            }
            if (evVar.nie()) {
                Os = "fullscreen_interstitial_ad";
            }
            if (TextUtils.isEmpty(evVar.cmk())) {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, Os, "load_html_fail", (JSONObject) null);
                return 401;
            }
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, Os, "load_html_success", (JSONObject) null);
        }
        if (evVar.MKR() == 0) {
            int GR = evVar.GR();
            if (GR != 2 && GR != 3 && GR != 4) {
                if (GR != 5 && GR != 15) {
                    if (GR != 16) {
                    }
                }
                int eli2 = eli(evVar.nY(), evVar.Kv());
                if (eli2 != 200) {
                    com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, eli2);
                    return eli2;
                }
            }
            int eli3 = eli(evVar.an());
            if (eli3 != 200) {
                com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, eli3);
                return eli3;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.settings.NU.nY().iuv()) {
            return Os(evVar);
        }
        return DbA(evVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        if (r3 != 8) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int DbA(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        int i;
        String Os = dZ.Os(evVar.bBQ());
        if (evVar.MKR() == 0) {
            i = eli(evVar.Eh());
            com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, i);
        } else {
            i = 200;
        }
        int yw = evVar.yw();
        if (yw != 2 && yw != 3) {
            if (yw == 4) {
                com.bytedance.sdk.openadsdk.core.model.MGA pu = evVar.pu();
                if (pu == null) {
                    com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, 407);
                    i = 407;
                } else if (TextUtils.isEmpty(pu.Os()) && TextUtils.isEmpty(pu.eli())) {
                    com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, TTAdConstant.DOWNLOAD_URL_AND_PACKAGE_NAME);
                    i = 417;
                } else if (TextUtils.isEmpty(pu.Os())) {
                    i = TTAdConstant.PACKAGE_NAME_CODE;
                    com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, TTAdConstant.PACKAGE_NAME_CODE);
                } else if (TextUtils.isEmpty(pu.eli())) {
                    i = 408;
                    com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, 408);
                }
            }
            if (i != 417 || i == 407 || i == 406) {
                return i;
            }
            if (i != 200) {
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, Os, i);
            }
            return 200;
        }
        if (aGH(evVar) && TextUtils.isEmpty(evVar.dM())) {
            com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, 406);
            i = 406;
        }
        if (i != 417) {
        }
        return i;
    }

    private static int Os(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        int i;
        String Os = dZ.Os(evVar.bBQ());
        if (evVar.MKR() == 0) {
            i = eli(evVar.Eh());
            if (i != 200) {
                com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, i);
                return i;
            }
        } else {
            i = 200;
        }
        int yw = evVar.yw();
        if (yw != 2 && yw != 3) {
            if (yw == 4) {
                int eli2 = eli(evVar.pu());
                if (eli2 != 200) {
                    com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, eli2);
                }
                return eli2;
            }
            if (yw != 8) {
                return i;
            }
        }
        if (!aGH(evVar) || !TextUtils.isEmpty(evVar.dM())) {
            return i;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.Os(evVar, Os, 406);
        return 406;
    }

    private static boolean aGH(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        return (evVar.Kv() || evVar.Jt()) ? false : true;
    }

    private static int eli(com.bytedance.sdk.openadsdk.core.model.NU nu) {
        if (nu == null) {
            return 200;
        }
        if (TextUtils.isEmpty(nu.eli())) {
            return 403;
        }
        if (TextUtils.isEmpty(nu.DbA())) {
            return 404;
        }
        return (nu.Os() == 1 || nu.Os() == 2) ? 200 : 405;
    }

    private static int eli(com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA, boolean z) {
        if (dbA == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(dbA.du())) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (z || !TextUtils.isEmpty(dbA.aAs())) {
            return 200;
        }
        return TTAdConstant.VIDEO_COVER_URL_CODE;
    }

    private static int eli(com.bytedance.sdk.openadsdk.core.model.MGA mga) {
        if (mga == null) {
            return 407;
        }
        if (TextUtils.isEmpty(mga.eli())) {
            return 408;
        }
        if (TextUtils.isEmpty(mga.Os())) {
            return TTAdConstant.PACKAGE_NAME_CODE;
        }
        return 200;
    }

    private static int eli(List<com.bytedance.sdk.openadsdk.core.model.nGm> list) {
        if (list == null) {
            return 409;
        }
        if (list.size() <= 0) {
            return 410;
        }
        for (com.bytedance.sdk.openadsdk.core.model.nGm ngm : list) {
            if (ngm == null) {
                return 411;
            }
            if (TextUtils.isEmpty(ngm.eli())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    private static void eli(final ArrayList<eli> arrayList) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("multiple_ads_parsing_error", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.DbA.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("material_error", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    eli eliVar = (eli) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cid", eliVar.eli);
                    jSONObject2.put("error_msg", eliVar.DbA);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("error_cid_list", jSONArray);
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("multiple_ads_parsing_error").DbA(jSONObject.toString());
            }
        });
    }

    private static class eli {
        public int DbA;
        public String eli;

        public eli(String str, int i) {
            this.eli = str;
            this.DbA = i;
        }
    }
}
