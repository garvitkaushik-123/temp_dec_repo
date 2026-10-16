package com.bytedance.sdk.openadsdk.core.aAs;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    private static String eli = "";

    public static boolean eli(int i) {
        return i == 10 || i == 9;
    }

    public static JSONObject eli(ev evVar, String str) {
        JSONObject iOb = evVar.iOb();
        try {
            iOb.put("show_dislike", evVar.iiz());
            iOb.put("language", nlS.DbA());
            if ("open_ad".equals(str)) {
                JSONObject jSONObject = new JSONObject();
                String wC = FC.DbA().wC();
                int FC = FC.DbA().FC();
                jSONObject.put("app_name", wC);
                jSONObject.put("app_icon_id", "@".concat(String.valueOf(FC)));
                iOb.put("open_app_info", jSONObject);
            }
            iOb.put(N6.F, C3040d4.d);
            JSONArray Os = Os(evVar);
            if (Os != null) {
                iOb.put("dpa_data", Os);
                return iOb;
            }
        } catch (Throwable th) {
            Xb.Os("UgenUtils", "parseUGenDataInfo exception", th.getMessage());
        }
        return iOb;
    }

    private static JSONArray Os(ev evVar) {
        try {
            ev.eli RY = evVar.RY();
            if (RY == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(RY.FC());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("original_price", Double.valueOf(jSONObject.optDouble("original_price", 0.0d)));
            jSONObject2.putOpt("price_unit", jSONObject.optString("price_unit"));
            jSONObject2.putOpt(FirebaseAnalytics.Param.DISCOUNT, Double.valueOf(jSONObject.optDouble(FirebaseAnalytics.Param.DISCOUNT, 0.0d)));
            jSONObject2.putOpt("product_name", jSONObject.optString("dpa_product_name"));
            jSONObject2.putOpt("description", jSONObject.optString("dpa_description"));
            JSONArray optJSONArray = jSONObject.optJSONArray("dpa_images");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                jSONObject2.putOpt("image", optJSONArray.get(0));
            }
            jSONObject2.putOpt("brand_name", jSONObject.optString("dpa_brand_name"));
            jSONObject2.putOpt("sale_price_i18n", Integer.valueOf(jSONObject.optInt("sale_price_i18n")));
            jSONObject2.putOpt("real_price", Double.valueOf(jSONObject.optDouble("real_price", 0.0d)));
            jSONObject2.put("button_text", evVar.GMu());
            JSONArray jSONArray = new JSONArray();
            JSONArray optJSONArray2 = jSONObject.optJSONArray("dpa_related_products");
            if (optJSONArray2 != null) {
                jSONArray.put(jSONObject2);
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                        jSONObject3.put("button_text", evVar.GMu());
                        jSONArray.put(jSONObject3);
                    } catch (Throwable unused) {
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean eli(ev evVar) {
        return evVar != null && evVar.rH() == 7;
    }

    public static String eli() {
        return eli;
    }

    public static boolean DbA(ev evVar) {
        return evVar != null && evVar.rH() == 10;
    }

    public static JSONObject eli(ev evVar, com.bytedance.sdk.openadsdk.core.aAs.kb.Os os) {
        JSONObject jSONObject;
        os.eli("ad");
        String str = "";
        eli = "";
        JSONObject jSONObject2 = null;
        try {
            ev.eli RY = evVar.RY();
            if (RY != null) {
                str = RY.Dfc();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(RY.nn()) && !TextUtils.isEmpty(RY.aGH())) {
                    str = com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli("ad", RY.aGH(), RY.nn());
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject = new JSONObject(str);
                    try {
                        try {
                            eli = "getTemplate success";
                            os.DbA("local");
                            return jSONObject;
                        } catch (JSONException unused) {
                            String concat = "parse json exception data is ".concat(String.valueOf(str));
                            eli = concat;
                            os.eli(2, concat, "local");
                            return null;
                        }
                    } catch (Throwable th) {
                        jSONObject2 = jSONObject;
                        th = th;
                        String str2 = "get template error " + th.getMessage();
                        eli = str2;
                        os.eli(2, str2, "local");
                        return jSONObject2;
                    }
                } catch (JSONException unused2) {
                    jSONObject = null;
                }
            } else {
                String str3 = "local data is null id is " + RY.aGH() + " md5 is " + RY.nn();
                eli = str3;
                os.eli(3, str3, "net");
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
