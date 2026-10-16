package com.bytedance.sdk.openadsdk.core.wC;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.moloco.sdk.internal.services.init.i;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du {
    public static void eli(String str, int i, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.core.wC.eli(i);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_source", str);
            ev.eli RY = evVar.RY();
            if (RY != null) {
                jSONObject.put("tpl_id", RY.aGH());
                if ("Web".equals(str)) {
                    if (RY.nlS()) {
                        jSONObject.put("engine_version", "v3");
                    } else {
                        jSONObject.put("engine_version", i.f5703a);
                    }
                }
            } else if (evVar.hg() != null) {
                jSONObject.put("tpl_id", evVar.hg().eli());
                if ("Web".equals(str)) {
                    jSONObject.put("engine_version", "v3");
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.Dfc.Os.eli().eli(com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli(eli(str3)).Os(str4).ui(evVar != null ? evVar.fO() : "").DbA(i).DbA(jSONObject.toString()).MGA(str2));
    }

    private static int eli(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }
}
