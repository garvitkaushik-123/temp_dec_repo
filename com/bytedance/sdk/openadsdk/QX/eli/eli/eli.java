package com.bytedance.sdk.openadsdk.QX.eli.eli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.aGH.NU;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends aGH {
    public eli(Context context, String str) {
        super(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.aGH, com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public boolean eli(ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.MGA pu;
        HashMap hashMap;
        if (evVar == null || (pu = evVar.pu()) == null) {
            return false;
        }
        if (evVar.MKR() == 0) {
            hashMap = new HashMap();
            hashMap.put("dpl_probability_jump", Boolean.valueOf(this.aGH >= 11));
        } else {
            hashMap = null;
        }
        return eli(evVar, pu.Os(), eli(), this.eli, hashMap);
    }

    public static boolean eli(ev evVar, String str, Context context, String str2, Map<String, Object> map) {
        Intent eli;
        if (evVar != null && evVar.fnE() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (eli = dZ.eli(context, str)) == null) {
                return false;
            }
            eli.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                eli.addFlags(268435456);
            }
            context.startActivity(eli);
            if (map == null) {
                map = new HashMap<>();
            }
            eli(evVar, map);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void eli(ev evVar, Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (evVar != null && evVar.MKR() == 0) {
            map.put("auto_click", Boolean.valueOf((evVar == null || evVar.nn()) ? false : true));
        }
        map.put("can_query_install", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.aGH
    public boolean DbA(ev evVar) {
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, 1, null);
        if (evVar.Eh() != null) {
            HashMap hashMap = new HashMap();
            if (evVar != null && evVar.MKR() == 0) {
                hashMap.put("dpl_probability_jump", Boolean.valueOf(this.aGH >= 11));
            }
            if (eli(evVar.Eh().eli(), eli(), this.eli, evVar, hashMap)) {
                return true;
            }
            if (!this.DbA || this.Os.get()) {
                this.DbA = true;
                eli(evVar, hashMap);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.eli, "open_fallback_url", hashMap);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, -1, null);
        }
        return false;
    }

    public static boolean eli(String str, Context context, String str2, ev evVar, Map<String, Object> map) {
        Intent intent = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            try {
                intent2.setData(parse);
                if (!(context instanceof Activity)) {
                    intent2.addFlags(268435456);
                }
                if (map == null) {
                    map = new HashMap<>();
                }
                eli(evVar, map);
                map.put("url", str);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str2, "open_url_app", map);
                context.startActivity(intent2);
                NU.eli().eli(map).eli(evVar, str2);
                com.bytedance.sdk.openadsdk.aGH.Os.eli("dp_start_act_success", evVar, str2, map);
                return true;
            } catch (Throwable th2) {
                th = th2;
                intent = intent2;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("exception", th.getMessage());
                    if (intent != null) {
                        jSONObject.put("intent", intent.toString());
                    }
                    jSONObject.put("can_query_install", 0);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, str2, -4, jSONObject);
                return false;
            }
        }
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, str2, -2, null);
        return false;
    }
}
