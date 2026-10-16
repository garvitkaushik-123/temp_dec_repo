package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.GB;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.settings.nlS;
import com.bytedance.sdk.openadsdk.core.settings.ui;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.ujq;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pgl.ssdk.ces.out.PglSSConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs extends nlS {
    static final ArrayList<String> aGH = new ArrayList<>(Arrays.asList("ja", "en", "ko", "zh", "th", "vi", "id", "ru", "ar", "fr", DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, "it", "es", "hi", "pt", "zh-Hant", "ms", "pl", "tr"));
    public boolean Os;
    private Set<String> ui;

    public aAs(nlS.eli eliVar) {
        super("tt_sdk_settings_sr.prop", eliVar);
        this.ui = Collections.synchronizedSet(new HashSet());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.ui
    public void eli(JSONObject jSONObject) {
        int optInt;
        ui.eli eli = eli();
        JSONObject ui = NU.nY().ui();
        JSONObject optJSONObject = jSONObject.optJSONObject("digest");
        this.Os = (optJSONObject == null || ui == null || !optJSONObject.toString().equals(ui.toString())) ? false : true;
        if (optJSONObject != null) {
            eli.eli("digest", optJSONObject.toString());
        } else {
            eli.eli("digest");
        }
        eli.eli("data_time", jSONObject.optLong("data_time"));
        if (jSONObject.has("req_inter_min")) {
            long optLong = jSONObject.optLong("req_inter_min", 10L) * 60000;
            if (optLong < 0 || optLong > 86400000) {
                optLong = TTAdConstant.AD_MAX_EVENT_TIME;
            }
            eli.eli("req_inter_min", optLong);
        }
        if (jSONObject.has("lp_new_style")) {
            eli.eli("landingpage_new_style", jSONObject.optInt("lp_new_style", Integer.MAX_VALUE));
        }
        if (jSONObject.has("blank_detect_rate")) {
            int optInt2 = jSONObject.optInt("blank_detect_rate", 30);
            if (optInt2 < 0 || optInt2 > 100) {
                optInt2 = 30;
            }
            eli.eli("blank_detect_rate", optInt2);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("feq_policy");
        if (optJSONObject2 != null) {
            if (optJSONObject2.has("duration")) {
                eli.eli("duration", optJSONObject2.optLong("duration") * 1000);
            }
            if (optJSONObject2.has("max")) {
                eli.eli("max", optJSONObject2.optInt("max"));
            }
        }
        if (jSONObject.has("vbtt")) {
            eli.eli("vbtt", jSONObject.optInt("vbtt", 5));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("abtest");
        if (optJSONObject3 != null) {
            if (optJSONObject3.has("version")) {
                eli.eli("ab_test_version", optJSONObject3.optString("version"));
            }
            if (optJSONObject3.has("param")) {
                eli.eli("ab_test_param", optJSONObject3.optString("param"));
            }
        } else {
            NU.nY().kb();
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("log_rate_conf");
        if (optJSONObject4 != null && optJSONObject4.has("global_rate")) {
            eli.eli("global_rate", (float) optJSONObject4.optDouble("global_rate", 1.0d));
        }
        if (jSONObject.has("pyload_h5")) {
            eli.eli("pyload_h5", jSONObject.optString("pyload_h5"));
        }
        if (jSONObject.has("pure_pyload_h5")) {
            eli.eli("playableLoadH5Url", jSONObject.optString("pure_pyload_h5"));
        }
        if (jSONObject.has("ads_url")) {
            eli.eli("ads_url", jSONObject.optString("ads_url"));
        }
        if (jSONObject.has("settings_url")) {
            eli.eli("settings_url", jSONObject.optString("settings_url"));
        }
        if (jSONObject.has("app_log_url")) {
            eli.eli("app_log_url", jSONObject.optString("app_log_url"));
        }
        if (jSONObject.has(CampaignEx.JSON_KEY_PRIVACY_URL)) {
            eli.eli("policy_url", jSONObject.optString(CampaignEx.JSON_KEY_PRIVACY_URL));
        }
        if (jSONObject.has("consent_url")) {
            eli.eli("consent_url", jSONObject.optString("consent_url"));
        }
        if (jSONObject.has("ivrv_downward")) {
            eli.eli("ivrv_downward", jSONObject.optInt("ivrv_downward", 0));
        }
        if (jSONObject.has("dc")) {
            eli.eli("dc", jSONObject.optString("dc"));
        }
        NU.nY().eli(jSONObject, eli);
        NU.nY().DbA(jSONObject, eli);
        if (jSONObject.has("if_both_open")) {
            eli.eli("if_both_open", jSONObject.optInt("if_both_open", 0));
        }
        if (jSONObject.has("support_tnc")) {
            eli.eli("support_tnc", jSONObject.optInt("support_tnc", 1));
        }
        if (jSONObject.has("insert_js_config")) {
            eli.eli("insert_js_config", jSONObject.optString("insert_js_config", ""));
        }
        if (jSONObject.has("max_tpl_cnts")) {
            eli.eli("max_tpl_cnts", jSONObject.optInt("max_tpl_cnts", 100));
        }
        if (jSONObject.has("target_region")) {
            eli.eli("target_region", jSONObject.optString("target_region", ""));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject5 != null) {
            if (optJSONObject5.has("force_language")) {
                String optString = optJSONObject5.optString("force_language");
                if (!TextUtils.isEmpty(optString) && aGH.contains(optString)) {
                    eli.eli("force_language", optString);
                }
            }
            if (optJSONObject5.has("fetch_tpl_timeout_ctrl")) {
                eli.eli("fetch_tpl_timeout_ctrl", optJSONObject5.optInt("fetch_tpl_timeout_ctrl", 3000));
            }
            if (optJSONObject5.has("fetch_tpl_second")) {
                eli.eli("fetch_tpl_second", optJSONObject5.optInt("fetch_tpl_second", 0));
            }
            if (optJSONObject5.has("support_gzip")) {
                eli.eli("support_gzip", optJSONObject5.optBoolean("support_gzip", false));
            }
            if (optJSONObject5.has("aes_key")) {
                eli.eli("aes_key", optJSONObject5.optString("aes_key"));
            }
            if (optJSONObject5.has("support_rtl")) {
                eli.eli("support_rtl", optJSONObject5.optBoolean("support_rtl", false));
            }
            if (optJSONObject5.has("ad_revenue_enable")) {
                eli.eli("ad_revenue_enable", optJSONObject5.optBoolean("ad_revenue_enable", true));
            }
            if (optJSONObject5.has("gecko_hosts")) {
                try {
                    this.ui.clear();
                    JSONArray optJSONArray = optJSONObject5.optJSONArray("gecko_hosts");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            this.ui.add(optJSONArray.getString(i));
                        }
                    }
                    this.ui = eli(this.ui);
                    eli.eli("gecko_hosts", optJSONArray.toString());
                } catch (Throwable th) {
                    Xb.Os("GeckoLog: settings json error ".concat(String.valueOf(th)), new Object[0]);
                }
            }
        }
        if (jSONObject.has("read_video_from_cache")) {
            eli.eli("read_video_from_cache", jSONObject.optInt("read_video_from_cache", 1));
        }
        Os.eli(jSONObject.optJSONArray("ad_slot_conf_list"));
        JSONObject optJSONObject6 = jSONObject.optJSONObject("privacy");
        if (optJSONObject6 != null) {
            if (optJSONObject6.has("ad_enable")) {
                eli.eli("privacy_ad_enable", optJSONObject6.optInt("ad_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("personalized_ad")) {
                eli.eli("privacy_personalized_ad", optJSONObject6.optInt("personalized_ad", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("sladar_enable")) {
                eli.eli("privacy_sladar_enable", optJSONObject6.optInt("sladar_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("app_log_enable")) {
                eli.eli("privacy_app_log_enable", optJSONObject6.optInt("app_log_enable", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has("debug_unlock")) {
                eli.eli("privacy_debug_unlock", optJSONObject6.optInt("debug_unlock", Integer.MAX_VALUE));
            }
            if (optJSONObject6.has(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS)) {
                String optString2 = optJSONObject6.optString(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, "");
                if (!TextUtils.isEmpty(optString2)) {
                    eli.eli("privacy_fields_allowed", optString2);
                } else {
                    eli.eli("privacy_fields_allowed");
                }
            }
            if (optJSONObject6.has("app_reg")) {
                int optInt3 = optJSONObject6.optInt("app_reg", 1);
                if (optInt3 == 0 && GB.eli().aGH() == 1) {
                    cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.aAs.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Toast.makeText(dV.eli(), "Appid is not registered on pangle media platform", 1).show();
                        }
                    });
                }
                eli.eli("privacy_app_reg", optInt3 != 0);
            }
        }
        if (jSONObject.has("video_cache_config")) {
            eli.eli("video_cache_config", jSONObject.optString("video_cache_config"));
        }
        if (jSONObject.has("loaded_recall_time")) {
            int optInt4 = jSONObject.optInt("loaded_recall_time", 0);
            if (optInt4 != 0 && optInt4 != 1) {
                optInt4 = 0;
            }
            eli.eli("loadedCallbackOpportunity", optInt4);
        }
        if (jSONObject.has("splash_video_load_strategy")) {
            int optInt5 = jSONObject.optInt("splash_video_load_strategy", 0);
            if (optInt5 < 0 || optInt5 > 3) {
                optInt5 = 0;
            }
            eli.eli("splash_video_load_strategy", optInt5);
        }
        if (jSONObject.has("allow_blind_mode_request_ad")) {
            eli.eli("allow_blind_mode_request_ad", jSONObject.optBoolean("allow_blind_mode_request_ad", false));
        }
        JSONObject optJSONObject7 = jSONObject.optJSONObject("bus_con");
        if (optJSONObject7 != null) {
            if (optJSONObject7.has("bus_con_send_log_type")) {
                eli.eli("bus_con_send_log_type", optJSONObject7.optInt("bus_con_send_log_type", 1));
            }
            if (optJSONObject7.has("bus_con_sec_type")) {
                eli.eli("bus_con_sec_type", optJSONObject7.optInt("bus_con_sec_type", Integer.MAX_VALUE));
            }
            if (optJSONObject7.has("bus_con_dislike_report_raw")) {
                eli.eli("bus_con_dislike_report_raw", optJSONObject7.optBoolean("bus_con_dislike_report_raw", false));
            }
            if (optJSONObject7.has("bus_con_adshow_check_enable")) {
                eli.eli("bus_con_adshow_check_enable", optJSONObject7.optBoolean("bus_con_adshow_check_enable", true));
            }
            if (optJSONObject7.has("bus_con_tnc_interval")) {
                eli.eli("bus_con_tnc_interval", optJSONObject7.optLong("bus_con_tnc_interval", TTAdConstant.AD_MAX_EVENT_TIME));
            }
            if (optJSONObject7.has("bus_con_token_thread_count")) {
                eli.eli("bus_con_token_thread_count", optJSONObject7.optInt("bus_con_token_thread_count", 4));
            }
            if (optJSONObject7.has("bus_con_video_keep_screen_on")) {
                eli.eli("bus_con_video_keep_screen_on", optJSONObject7.optInt("bus_con_video_keep_screen_on", 1));
            }
            if (optJSONObject7.has("bus_con_auto_click_delay")) {
                eli.eli("bus_con_auto_click_delay", optJSONObject7.optInt("bus_con_auto_click_delay", 3000));
            }
            if (optJSONObject7.has("bus_con_express_host")) {
                eli.eli("bus_con_express_host", optJSONObject7.optString("bus_con_express_host", "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/"));
            }
            if (optJSONObject7.has("bus_con_check_clz")) {
                eli.eli("bus_con_check_clz", optJSONObject7.optString("bus_con_check_clz", ""));
            }
            if (optJSONObject7.has("bus_con_url_check")) {
                eli.eli("bus_con_url_check", optJSONObject7.optInt("bus_con_url_check", 1));
            }
            if (optJSONObject7.has("bus_con_behavior_count")) {
                eli.eli("bus_con_behavior_count", optJSONObject7.optInt("bus_con_behavior_count", 300));
            }
            if (optJSONObject7.has(NU.eli)) {
                eli.eli(NU.eli, optJSONObject7.optBoolean(NU.eli, false));
            }
            if (optJSONObject7.has(NU.DbA)) {
                eli.eli(NU.DbA, optJSONObject7.optInt(NU.DbA, 10000));
            }
            if (optJSONObject7.has(NU.Os)) {
                eli.eli(NU.Os, (float) optJSONObject7.optDouble(NU.Os, 1.0d));
            }
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject optJSONObject8 = jSONObject.optJSONObject("perf_con");
                if (optJSONObject8 != null) {
                    if (optJSONObject8.has("perf_con_stats_rate")) {
                        String optString3 = optJSONObject8.optString("perf_con_stats_rate");
                        if (!TextUtils.isEmpty(optString3)) {
                            eli.eli("perf_con_stats_rate", optString3);
                        }
                    }
                    if (optJSONObject8.has("perf_con_applog_send")) {
                        String optString4 = optJSONObject8.optString("perf_con_applog_send");
                        if (!TextUtils.isEmpty(optString4)) {
                            eli.eli("perf_con_applog_send", optString4);
                        }
                    }
                    if (optJSONObject8.has("perf_con_apm_native")) {
                        eli.eli("perf_con_apm_native", optJSONObject8.optInt("perf_con_apm_native"));
                    }
                    if (optJSONObject8.has("perf_con_webview_preload_cache")) {
                        eli.eli("perf_con_webview_preload_cache", optJSONObject8.optInt("perf_con_webview_preload_cache"));
                    }
                    if (optJSONObject8.has("perf_con_webview_preload_cache_v3")) {
                        eli.eli("perf_con_webview_preload_cache_v3", optJSONObject8.optInt("perf_con_webview_preload_cache_v3"));
                    }
                    if (optJSONObject8.has("perf_con_webview_cache_count")) {
                        eli.eli("perf_con_webview_cache_count", optJSONObject8.optInt("perf_con_webview_cache_count", 0));
                    }
                    if (optJSONObject8.has("perf_con_webview_cache_count_v3")) {
                        eli.eli("perf_con_webview_cache_count_v3", optJSONObject8.optInt("perf_con_webview_cache_count_v3", 0));
                    }
                    if (optJSONObject8.has("perf_con_thread_stack_size") && (optInt = optJSONObject8.optInt("perf_con_thread_stack_size")) >= -524288 && optInt <= 0) {
                        eli.eli("perf_con_thread_stack_size", optInt);
                    }
                    if (optJSONObject8.has("perf_con_use_new_thread_pool")) {
                        eli.eli("perf_con_use_new_thread_pool", optJSONObject8.optInt("perf_con_use_new_thread_pool", 0));
                    }
                    if (optJSONObject8.has("perf_con_thread_pool_config")) {
                        String optString5 = optJSONObject8.optString("perf_con_thread_pool_config");
                        if (!TextUtils.isEmpty(optString5)) {
                            eli.eli("perf_con_thread_pool_config", optString5);
                        }
                    }
                    if (optJSONObject8.has("perf_con_is_new_net_thread")) {
                        eli.eli("perf_con_is_new_net_thread", optJSONObject8.optInt("perf_con_is_new_net_thread", 0));
                    }
                    if (optJSONObject8.has("perf_con_use_prop")) {
                        ujq.eli(optJSONObject8.optInt("perf_con_use_prop", 1));
                    }
                    if (optJSONObject8.has("perf_con_adlog_expire_time")) {
                        eli.eli("perf_con_adlog_expire_time", optJSONObject8.optLong("perf_con_adlog_expire_time"));
                    }
                    if (optJSONObject8.has("perf_con_adlog_turn_off_retry_ad")) {
                        eli.eli("perf_con_adlog_turn_off_retry_ad", optJSONObject8.optLong("perf_con_adlog_turn_off_retry_ad"));
                    }
                    if (optJSONObject8.has("perf_con_adlog_turn_off_retry_stats")) {
                        eli.eli("perf_con_adlog_turn_off_retry_stats", optJSONObject8.optLong("perf_con_adlog_turn_off_retry_stats"));
                    }
                    if (optJSONObject8.has("perf_con_applog_rate")) {
                        eli.eli("perf_con_applog_rate", optJSONObject8.optString("perf_con_applog_rate"));
                    }
                    if (optJSONObject8.has("perf_con_track_url_strategy")) {
                        eli.eli("perf_con_track_url_strategy", optJSONObject8.optString("perf_con_track_url_strategy"));
                    }
                    if (optJSONObject8.has("perf_con_drawable_code")) {
                        eli.eli("perf_con_drawable_code", optJSONObject8.optInt("perf_con_drawable_code", 0));
                    }
                    if (optJSONObject8.has("perf_con_close_button_delay_check_time")) {
                        eli.eli("perf_con_close_button_delay_check_time", optJSONObject8.optInt("perf_con_close_button_delay_check_time", -1));
                    }
                    if (optJSONObject8.has("perf_con_drop2rt_skip_label_list")) {
                        eli.eli("perf_con_drop2rt_skip_label_list", optJSONObject8.optString("perf_con_drop2rt_skip_label_list"));
                    }
                    if (optJSONObject8.has("perf_con_crypt_V4_get_ad")) {
                        eli.eli("perf_con_crypt_V4_get_ad", optJSONObject8.optBoolean("perf_con_crypt_V4_get_ad", false));
                    }
                    if (optJSONObject8.has("perf_con_crypt_V4_applog")) {
                        eli.eli("perf_con_crypt_V4_applog", optJSONObject8.optBoolean("perf_con_crypt_V4_applog", false));
                    }
                    if (optJSONObject8.has("perf_con_crypt_V4")) {
                        eli.eli("perf_con_crypt_V4", optJSONObject8.optBoolean("perf_con_crypt_V4", false));
                    }
                }
            } catch (Throwable th2) {
                Xb.Os("SettingsDefaultRepository", th2.getMessage());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("app_common_config", optJSONObject5);
            jSONObject2.put("perf_con", jSONObject.optJSONObject("perf_con"));
            jSONObject2.put("bus_con", jSONObject.optJSONObject("bus_con"));
        } catch (JSONException e) {
            Xb.Os("SettingsDefaultRepository", "coreSettingJson", e.getMessage());
        }
        eli.eli("core_settings", jSONObject2.toString());
        if (jSONObject.has("dual_event_url")) {
            eli.eli("dual_event_url", jSONObject.optString("dual_event_url"));
        }
        if (jSONObject.has("token_enable")) {
            eli.eli("token_enable", jSONObject.optInt("token_enable"));
        }
        if (jSONObject.has("token_adx_ids")) {
            String optString6 = jSONObject.optString("token_adx_ids", "");
            if (!TextUtils.isEmpty(optString6)) {
                eli.eli("token_adx_ids", optString6);
            } else {
                eli.eli("token_adx_ids");
            }
        }
        eli.eli();
        NU.nY().ujq();
        aGH();
    }

    public static Set<String> eli(Set<String> set) {
        try {
            if (set == null) {
                return new HashSet();
            }
            HashSet hashSet = new HashSet();
            for (String str : set) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            return hashSet;
        } catch (Throwable unused) {
            return new HashSet();
        }
    }
}
