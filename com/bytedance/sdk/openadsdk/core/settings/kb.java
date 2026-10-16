package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    public boolean MGA;
    public String Os;
    public boolean aGH;
    public boolean ui;
    public static final kb eli = new kb(null);
    public static String DbA = "";

    public kb(String str) {
        this.Os = "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/3p_monitor.9db44671.js";
        this.aGH = true;
        this.ui = true;
        this.MGA = true;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("performance_js");
            String optString = optJSONObject.optString("url", "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/3p_monitor.9db44671.js");
            if (!TextUtils.isEmpty(optString)) {
                this.Os = optString;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("execute_time");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
            this.aGH = arrayList.contains("load_finish");
            this.MGA = arrayList.contains("load_fail");
            this.ui = arrayList.contains("load");
        } catch (Exception unused) {
        }
    }
}
