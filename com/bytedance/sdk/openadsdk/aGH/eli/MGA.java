package com.bytedance.sdk.openadsdk.aGH.eli;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    public static AtomicInteger eli = new AtomicInteger(0);
    public static AtomicInteger DbA = new AtomicInteger(0);
    public static AtomicInteger Os = new AtomicInteger(0);
    public static AtomicInteger aGH = new AtomicInteger(0);
    public static AtomicInteger ui = new AtomicInteger(0);
    public static AtomicInteger MGA = new AtomicInteger(0);
    public static AtomicInteger kb = new AtomicInteger(0);
    public static AtomicInteger wC = new AtomicInteger(0);
    public static AtomicInteger FC = new AtomicInteger(0);

    public static void eli() {
        try {
            long eli2 = com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_get_ad", "get_ad_event_time_key", 0L);
            if (eli2 > 0 && System.currentTimeMillis() - eli2 >= 86400000) {
                DbA();
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
                return;
            }
            if (eli2 <= 0 || eli2 > System.currentTimeMillis()) {
                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_get_ad", "get_ad_event_time_key", Long.valueOf(System.currentTimeMillis()));
            }
            JSONObject jSONObject = new JSONObject(com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            int optInt = jSONObject.optInt("load_get_ad_version", 0);
            if (optInt >= 5702 && (optInt < 5800 || optInt >= 5802)) {
                eli.addAndGet(jSONObject.optInt("load_times"));
                DbA.addAndGet(jSONObject.optInt("load_success"));
                Os.addAndGet(jSONObject.optInt("load_fail"));
                aGH.addAndGet(jSONObject.optInt("load_success_and_parse_success"));
                ui.addAndGet(jSONObject.optInt("load_success_and_parse_fail"));
                MGA.addAndGet(jSONObject.optInt("load_success_and_no_ad"));
                kb.addAndGet(jSONObject.optInt("load_fail_by_no_net"));
                wC.addAndGet(jSONObject.optInt("load_fail_by_io"));
                FC.addAndGet(jSONObject.optInt("load_fail_in_background"));
                return;
            }
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void DbA() {
        try {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli("pangle_sdk_get_ad_track", com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("tt_sdk_event_get_ad", "get_ad_event_key", ""));
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_get_ad");
        } catch (Throwable unused) {
        }
    }

    public static void Os() {
        try {
            com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("tt_sdk_event_get_ad", "get_ad_event_key", aGH().toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject aGH() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("load_times", eli.get());
            jSONObject.put("load_success", DbA.get());
            jSONObject.put("load_fail", Os.get());
            jSONObject.put("load_fail_in_background", FC.get());
            jSONObject.put("load_success_and_parse_success", aGH.get());
            jSONObject.put("load_success_and_parse_fail", ui.get());
            jSONObject.put("load_success_and_no_ad", MGA.get());
            jSONObject.put("load_fail_by_no_net", kb.get());
            jSONObject.put("load_fail_by_io", wC.get());
            jSONObject.put("load_get_ad_version", BuildConfig.VERSION_CODE);
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void eli(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli("pangle_sdk_client_load_error", jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void ui() {
        try {
            if (DeviceUtils.DbA()) {
                return;
            }
            FC.incrementAndGet();
        } catch (Throwable unused) {
        }
    }
}
