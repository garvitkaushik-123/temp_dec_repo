package com.bytedance.sdk.openadsdk.QX.eli.eli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.aGH.NU;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    public static boolean eli(Context context, String str, ev evVar) {
        String eli = dZ.eli(evVar);
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, eli, 1, null);
        Intent eli2 = eli(context, str);
        if (TextUtils.isEmpty(str) || eli2 == null) {
            com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, eli, -2, evVar.Eh().aGH());
            return false;
        }
        boolean aGH = dZ.aGH(context);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        if (aGH) {
            dZ.DbA eli3 = dZ.eli(context, eli2);
            if (eli3.DbA > 0) {
                try {
                    eli(context, evVar, hashMap);
                    hashMap.put("matched_count", Integer.valueOf(eli3.DbA));
                    if (eli3.eli != null) {
                        eli2.setComponent(eli3.eli);
                    }
                } catch (Throwable th) {
                    Xb.Os("DeepLinkUtils", th.getMessage());
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("intent", eli2.toString());
                    jSONObject.put("can_query_install", 1);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, eli, -3, jSONObject);
                return false;
            }
        }
        try {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, eli, "open_url_app", hashMap);
            context.startActivity(eli2);
            NU.eli().eli(hashMap).eli(evVar, eli);
            com.bytedance.sdk.openadsdk.aGH.Os.eli("dp_start_act_success", evVar, eli, hashMap);
            return true;
        } catch (Throwable th2) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("exception", th2.getMessage());
                jSONObject2.put("intent", eli2.toString());
                jSONObject2.put("can_query_install", aGH ? 1 : 0);
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, eli, -4, jSONObject2);
            return false;
        }
    }

    private static Intent eli(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        } catch (Throwable th) {
            Xb.Os("DeepLinkUtils", th.getMessage());
            return null;
        }
    }

    private static void eli(Context context, ev evVar, Map<String, Object> map) {
        if (evVar != null && evVar.MKR() == 0) {
            map.put("auto_click", Boolean.valueOf((evVar == null || evVar.nn()) ? false : true));
        }
        map.put("can_query_install", Integer.valueOf(dZ.aGH(context) ? 1 : 0));
    }
}
