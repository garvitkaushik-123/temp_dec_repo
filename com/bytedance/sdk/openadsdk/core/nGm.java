package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nGm {
    public static void eli(Context context, boolean z, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, int i, WebView webView, com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        int optInt = jSONObject.optInt("landingStyle");
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("fallback_url");
        String optString3 = jSONObject.optString("title", "");
        boolean z2 = false;
        boolean z3 = jSONObject.optInt("only_loading", 0) == 1;
        try {
            jSONObject.put("is_activity", z);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, 1, jSONObject);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        if (optInt == 0) {
            if (webView != null) {
                webView.loadUrl(optString);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, 2, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, -1, (JSONObject) null);
            }
        } else if (optInt == 1 || optInt == 8) {
            com.bytedance.sdk.openadsdk.Dfc.eli.DbA dbA = new com.bytedance.sdk.openadsdk.Dfc.eli.DbA();
            dbA.eli(DbA.eli.DbA);
            dbA.eli(evVar);
            dbA.DbA(str);
            dbA.eli(-1);
            dbA.eli(false);
            dbA.DbA(evVar.yw());
            com.bytedance.sdk.openadsdk.aGH.Os.eli(dbA);
            com.bytedance.sdk.openadsdk.utils.CMM.eli(context, optString, evVar, DbA.eli.DbA);
        } else {
            if (optInt != 2) {
                if (optInt == 3) {
                    QX qx = new QX(evVar);
                    qx.eli(optString3);
                    qx.eli(z3);
                    Cp.eli(context, optString, evVar, i, str, false, qx);
                }
                if (uiVar == null && z2) {
                    uiVar.eli();
                    return;
                }
            }
            if (!com.bytedance.sdk.openadsdk.utils.CMM.DbA(context, optString, evVar, str)) {
                com.bytedance.sdk.openadsdk.Dfc.eli.DbA dbA2 = new com.bytedance.sdk.openadsdk.Dfc.eli.DbA();
                dbA2.eli(DbA.eli.DbA);
                dbA2.eli(evVar);
                dbA2.DbA(str);
                dbA2.eli(-1);
                dbA2.eli(false);
                dbA2.DbA(evVar.yw());
                com.bytedance.sdk.openadsdk.aGH.Os.eli(dbA2);
                HashMap hashMap = new HashMap();
                hashMap.put("deeplink_url", optString);
                hashMap.put("fallback_url", optString2);
                hashMap.put("jsb_deeplink", 1);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, "open_fallback_url", hashMap);
                com.bytedance.sdk.openadsdk.utils.CMM.eli(context, optString2, evVar, DbA.eli.DbA);
            }
        }
        z2 = true;
        if (uiVar == null) {
        }
    }
}
