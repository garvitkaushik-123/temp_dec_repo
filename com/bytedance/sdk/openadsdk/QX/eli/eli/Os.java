package com.bytedance.sdk.openadsdk.QX.eli.eli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.aGH.NU;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    public static boolean eli() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("deeplink_utils_new", 0) == 1;
    }

    public static boolean eli(Context context, String str, ev evVar, int i, Map<String, Object> map, boolean z) {
        Map<String, Object> map2 = map;
        String eli = dZ.eli(evVar);
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, eli, 1, null);
        Intent eli2 = eli(context, str, evVar);
        if (TextUtils.isEmpty(str) || eli2 == null) {
            com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, eli, -2, evVar.Eh().aGH());
            return false;
        }
        boolean aGH = dZ.aGH(context);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Map<String, Object> map3 = map2;
        if (evVar != null && evVar.MKR() == 0) {
            map3.put("auto_click", Boolean.valueOf(!evVar.nn()));
        }
        map3.put("can_query_install", Integer.valueOf(aGH ? 1 : 0));
        map3.put("url", str);
        if (aGH) {
            dZ.DbA eli3 = dZ.eli(context, eli2);
            if (eli3.DbA > 0) {
                try {
                    eli(context, evVar, map3);
                    map3.put("matched_count", Integer.valueOf(eli3.DbA));
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
        if (dV.aGH().wC()) {
            dZ.eli(evVar, eli);
        }
        try {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, eli, "open_url_app", map3);
            context.startActivity(eli2);
            NU.eli().eli(map3).eli(evVar, eli);
            com.bytedance.sdk.openadsdk.aGH.Os.eli("dp_start_act_success", evVar, eli, map3);
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
            if (aGH && !dV.aGH().wC()) {
                Cp.eli(context, evVar.dM(), evVar, i, eli, z);
            }
            return false;
        }
    }

    private static Intent eli(Context context, String str, ev evVar) {
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (evVar != null && evVar.Mn() != null && !TextUtils.isEmpty(evVar.Mn().aGH())) {
                intent.setPackage(evVar.Mn().aGH());
            }
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
            map.put("auto_click", Boolean.valueOf(!evVar.nn()));
        }
        map.put("can_query_install", Integer.valueOf(dZ.aGH(context) ? 1 : 0));
    }
}
