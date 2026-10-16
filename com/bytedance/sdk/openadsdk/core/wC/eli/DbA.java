package com.bytedance.sdk.openadsdk.core.wC.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.aAs.kb.Os;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.QX;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.core.model.oWW;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.core.qj;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.ironsource.N6;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static String DbA = "";
    public static String eli = "https://pag_open_icon_id/appicon.png";

    public static boolean Os() {
        return true;
    }

    public static String eli() {
        return DbA;
    }

    public static JSONObject eli(float f, float f2, boolean z, ev evVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(N6.H, "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", f);
            jSONObject2.put("height", f2);
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", eli(false, evVar));
            jSONObject.put("template_Plugin", DbA(evVar.RY()));
            jSONObject.put("diff_template_Plugin", eli(evVar.RY()));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject eli(ev evVar) {
        JSONObject jSONObject = null;
        if (evVar == null) {
            return null;
        }
        try {
            jSONObject = eli(evVar, false);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = new JSONObject();
            qj.DbA(jSONObject2);
            jSONObject2.put(N6.H, "android");
            jSONObject.put("xAppInfo", jSONObject2);
            JSONObject DbA2 = qj.DbA(evVar);
            DbA2.put("language", nlS.DbA());
            jSONObject.put("xSetting", DbA2);
            return jSONObject;
        } catch (Throwable th) {
            new Object[]{"getDataInOtherScene", th.getMessage()};
            return jSONObject;
        }
    }

    private static JSONObject eli(ev evVar, boolean z) {
        JSONObject optJSONObject;
        JSONObject jSONObject = null;
        if (evVar != null) {
            try {
                String eD = evVar.eD();
                if (eD != null) {
                    JSONObject jSONObject2 = new JSONObject(eD);
                    JSONArray optJSONArray = jSONObject2.optJSONArray("creatives");
                    if (z) {
                        JSONObject jSONObject3 = (optJSONArray == null || optJSONArray.length() <= evVar.DbA() || (optJSONObject = optJSONArray.optJSONObject(evVar.DbA())) == null) ? null : new JSONObject(optJSONObject.toString());
                        if (jSONObject3 == null) {
                            return null;
                        }
                        jSONObject = jSONObject3;
                    } else {
                        jSONObject = new JSONObject();
                    }
                    int mm = evVar.mm();
                    if (mm != 43 && mm != 44 && mm != 41) {
                        if (z && optJSONArray.length() > 0) {
                            optJSONArray.remove(0);
                        }
                        jSONObject.put("xRestCreatives", optJSONArray);
                    }
                    jSONObject2.remove("creatives");
                    jSONObject.put("xRestResponse", jSONObject2);
                }
            } catch (Throwable th) {
                Xb.eli("TemplateUtils", "filterTemplateInfo", th);
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public static JSONObject eli(float f, float f2, boolean z, ev evVar, String str, Os os) {
        DbA = "";
        JSONObject jSONObject = null;
        if (evVar == null) {
            return null;
        }
        try {
            JSONObject eli2 = eli(evVar, true);
            if (eli2 == null) {
                return null;
            }
            try {
                eli(eli2, evVar, str);
                JSONObject DbA2 = qj.DbA(evVar);
                DbA2.put("language", nlS.DbA());
                eli2.put("xSetting", DbA2);
                eli2.put("xAdInfo", eli(str, Os(evVar), evVar));
                JSONObject jSONObject2 = new JSONObject();
                qj.DbA(jSONObject2);
                jSONObject2.put(N6.H, "android");
                eli2.put("xAppInfo", jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("width", f);
                jSONObject3.put("height", f2);
                if (z) {
                    jSONObject3.put("isLandscape", true);
                }
                eli2.put("xSize", jSONObject3);
                if (os != null) {
                    os.eli("adv3");
                }
                oWW hg = evVar.hg();
                if (hg != null) {
                    String aGH = hg.aGH();
                    if (!TextUtils.isEmpty(aGH)) {
                        eli2.put("xTemplate", new JSONObject(aGH));
                        DbA = "getTemplate success by local data";
                        if (os != null) {
                            os.DbA("local");
                            return eli2;
                        }
                    } else {
                        String eli3 = com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli().eli("adv3", hg.eli(), hg.DbA());
                        if (!TextUtils.isEmpty(eli3)) {
                            eli2.put("xTemplate", new JSONObject(eli3));
                            DbA = "getTemplate success by db data";
                            if (os != null) {
                                os.DbA("local");
                                return eli2;
                            }
                        } else {
                            String str2 = "local db data is null id is " + hg.eli() + " md5 is " + hg.DbA();
                            DbA = str2;
                            if (os != null) {
                                os.eli(3, str2, "net");
                            }
                        }
                    }
                }
                return eli2;
            } catch (Exception e) {
                e = e;
                jSONObject = eli2;
                String str3 = "load template exception " + e.getMessage();
                DbA = str3;
                if (os != null) {
                    os.eli(3, str3, "net");
                }
                return jSONObject;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static JSONObject DbA() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("language", nlS.DbA());
            jSONObject.put("xSetting", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            qj.DbA(jSONObject3);
            jSONObject3.put(N6.H, "android");
            jSONObject.put("xAppInfo", jSONObject3);
            return jSONObject;
        } catch (Exception e) {
            Xb.Os("TemplateUtils", e.getMessage());
            return jSONObject;
        }
    }

    private static void eli(JSONObject jSONObject, ev evVar, String str) {
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY;
        if (evVar == null || jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("h265_video")) {
                jSONObject.remove("h265_video");
            }
            if (!jSONObject.has("video") || (nY = evVar.nY()) == null) {
                return;
            }
            JSONObject nGm = nY.nGm();
            if (nGm != null) {
                if ("open_ad".equals(str)) {
                    nGm.put("video_duration", dV.aGH().CMM(String.valueOf(evVar.RTg())));
                } else {
                    nGm.put("video_duration", nY.MGA() * nY.CMM());
                }
            }
            jSONObject.put("video", nGm);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static JSONObject eli(String str, JSONObject jSONObject, ev evVar) {
        if (evVar != null) {
            try {
                if ("open_ad".equals(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("app_name", FC.DbA().wC());
                    int FC = FC.DbA().FC();
                    if (FC != 0) {
                        int rH = evVar.rH();
                        if (9 == rH) {
                            jSONObject2.put("app_icon", eli);
                        } else if (10 == rH) {
                            jSONObject2.put("app_icon", "@".concat(String.valueOf(FC)));
                        }
                    }
                    jSONObject.put("open_app_info", jSONObject2);
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject eli(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject == null) {
                return jSONObject3;
            }
            try {
                JSONArray optJSONArray = jSONObject2.optJSONArray(UserMetadata.KEYDATA_FILENAME);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (jSONObject.has(optString)) {
                            jSONObject3.put(optString, jSONObject.opt(optString));
                        }
                    }
                    jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                    jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                    jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                    jSONObject3.put("xSize", jSONObject.opt("xSize"));
                    jSONObject3.put("dynamic_configs", jSONObject.opt("dynamic_configs"));
                    jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                    jSONObject3.put("xRestCreatives", jSONObject.opt("xRestCreatives"));
                    jSONObject3.put("xRestResponse", jSONObject.opt("xRestResponse"));
                    return jSONObject3;
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static JSONObject Os(ev evVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            qj.eli(jSONObject, evVar);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String eli(ev.eli eliVar) {
        if (eliVar != null) {
            return eliVar.wC();
        }
        return "";
    }

    private static String DbA(ev.eli eliVar) {
        com.bytedance.sdk.component.adexpress.eli.Os.DbA Os;
        if (eliVar != null) {
            String kb = eliVar.kb();
            return (!TextUtils.isEmpty(kb) || (Os = com.bytedance.sdk.component.adexpress.eli.DbA.DbA.Os(eliVar.aGH())) == null) ? kb : Os.ui();
        }
        return "";
    }

    public static JSONObject eli(boolean z, ev evVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", evVar.GMu());
            if (evVar.SjY() != null) {
                if (evVar.SjY() != null && !TextUtils.isEmpty(evVar.SjY().eli())) {
                    jSONObject.put("icon", evVar.SjY().eli());
                } else {
                    jSONObject.put("icon", "");
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (evVar.an() != null) {
                for (int i = 0; i < evVar.an().size(); i++) {
                    nGm ngm = evVar.an().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("height", ngm.Os());
                    jSONObject2.put("width", ngm.DbA());
                    jSONObject2.put("url", ngm.eli());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", evVar.GR());
            jSONObject.put("interaction_type", evVar.yw());
            jSONObject.put("interaction_method", evVar.oc());
            jSONObject.put("is_compliance_template", Os());
            jSONObject.put("title", evVar.Pf());
            jSONObject.put("description", evVar.bU());
            jSONObject.put("source", evVar.kEI());
            JSONObject jSONObject3 = new JSONObject();
            QX bf = evVar.bf();
            if (bf == null) {
                bf = new QX();
            }
            jSONObject3.put("ceiling_time", bf.aGH());
            jSONObject3.put("ceiling_ratio", bf.ui());
            jSONObject3.put("expand_ratio", bf.MGA());
            jSONObject.put("interaction_params", jSONObject3);
            if (evVar.pu() != null) {
                jSONObject.put("comment_num", evVar.pu().ui());
                jSONObject.put(FirebaseAnalytics.Param.SCORE, evVar.pu().aGH());
                jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, evVar.pu().MGA());
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, evVar.pu().wC());
            }
            com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
            if (nY != null) {
                JSONObject nGm = nY.nGm();
                nGm.put("video_duration", nY.MGA() * nY.CMM());
                jSONObject.put("video", nGm);
            }
            if (evVar.RY() != null) {
                jSONObject.put("dynamic_creative", evVar.RY().FC());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String eli(ev evVar, String str) {
        List<nGm> an;
        if (evVar != null && (an = evVar.an()) != null && an.size() > 0) {
            for (nGm ngm : an) {
                if (ngm != null && TextUtils.equals(str, ngm.eli())) {
                    return ngm.kb();
                }
            }
        }
        return null;
    }

    public static Map<String, String> DbA(ev evVar) {
        HashMap hashMap = null;
        if (evVar == null) {
            return null;
        }
        List<nGm> an = evVar.an();
        if (an != null && an.size() > 0) {
            hashMap = new HashMap();
            for (nGm ngm : an) {
                if (ngm != null) {
                    hashMap.put(ngm.eli(), ngm.kb());
                }
            }
            nGm SjY = evVar.SjY();
            if (SjY != null) {
                hashMap.put(SjY.eli(), SjY.kb());
            }
        }
        return hashMap;
    }
}
