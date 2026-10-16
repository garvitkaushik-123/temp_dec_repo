package com.bytedance.sdk.openadsdk.Dfc.eli;

import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui {
    public static void eli(final String str, final String str2, final int i, final String str3) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli(str, false, 10, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.Dfc.eli.ui.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                jSONObject.put("error_msg", str3);
                return aGH.DbA().eli(str).DbA(jSONObject.toString());
            }
        });
    }
}
