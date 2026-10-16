package com.bytedance.sdk.openadsdk.core.aAs.MGA;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nGm;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui {
    private final String eli = "UGenV3OpenLinks";
    private final String DbA = "landingStyle";
    private final String Os = "url";
    private final String aGH = "fallbackUrl";

    public void eli(Context context, boolean z, ev evVar, String str, Map<String, String> map, com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            if (eli(Integer.parseInt(map.get("landingStyle")), map.get("url"), map.get("fallbackUrl"))) {
                nGm.eli(context, z, eli(map), evVar, str, dZ.eli(str), null, uiVar);
            }
        } catch (Throwable th) {
            Xb.Os("UGenV3OpenLinks", th.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0008, code lost:
    
        if (r4 != 3) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean eli(int i, String str, String str2) {
        if (i != 1) {
            if (i == 2) {
                if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || !com.bytedance.sdk.component.utils.nGm.eli(str2)) {
                    return false;
                }
            }
        }
        return com.bytedance.sdk.component.utils.nGm.eli(str);
    }

    private JSONObject eli(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
