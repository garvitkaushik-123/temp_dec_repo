package com.bytedance.adsdk.ugeno.Os;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Os.eli;
import com.bytedance.adsdk.ugeno.ui;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    public static String eli(String str, JSONObject jSONObject) {
        eli Os;
        eli.InterfaceC0121eli eli;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (str.startsWith("${") && str.endsWith("}") && (Os = ui.eli().Os()) != null && (eli = Os.eli(str.substring(2, str.length() - 1))) != null) {
                    return (String) eli.eli(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}
