package com.bytedance.sdk.openadsdk.core.aAs.MGA;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    public void eli(String str, ev evVar, String str2, Map<String, String> map) {
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    return;
                }
                String str3 = map.get("label");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String eu = evVar.eu();
                if ("sendLogExtra".equals(str) && !TextUtils.isEmpty(eu)) {
                    JSONObject jSONObject2 = new JSONObject(eu);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!"label".equals(entry.getKey())) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("log_extra", jSONObject2.toString());
                } else {
                    jSONObject.put("log_extra", eu);
                }
                JSONObject jSONObject3 = new JSONObject();
                if ("sendAdExtra".equals(str)) {
                    for (Map.Entry<String, String> entry2 : map.entrySet()) {
                        if (!"label".equals(entry2.getKey())) {
                            jSONObject3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject3.toString());
                jSONObject.putOpt("ua_policy", Integer.valueOf(evVar.ND()));
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, "app_union", str2, str3, Long.parseLong(evVar.umh()), 0L, jSONObject, Xb.ui(evVar));
            } catch (Throwable unused) {
            }
        }
    }
}
