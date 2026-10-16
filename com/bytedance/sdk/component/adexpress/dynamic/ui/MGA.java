package com.bytedance.sdk.component.adexpress.dynamic.ui;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.dynamic.ui.ui;
import com.ironsource.C3040d4;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private static HashMap<String, String> kb;
    private JSONObject DbA;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.aGH MGA;
    private com.bytedance.sdk.component.adexpress.dynamic.aGH.Os Os;
    private eli aGH;
    private JSONObject eli;
    private Os ui;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        kb = hashMap;
        hashMap.put("subtitle", "description");
        kb.put("source", "source|app.app_name");
        kb.put("screenshot", "dynamic_creative.screenshot");
    }

    public MGA(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.eli = jSONObject;
        this.DbA = jSONObject2;
        this.Os = new com.bytedance.sdk.component.adexpress.dynamic.aGH.Os(jSONObject2);
        this.aGH = eli.eli(jSONObject3);
        this.MGA = com.bytedance.sdk.component.adexpress.dynamic.aGH.aGH.eli(jSONObject4);
    }

    public com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli(double d, int i, double d2, String str, NU nu) {
        JSONObject jSONObject;
        this.Os.eli();
        try {
            jSONObject = new JSONObject(this.MGA.DbA);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli2 = eli(aGH.eli(this.eli, jSONObject), (com.bytedance.sdk.component.adexpress.dynamic.aGH.wC) null);
        eli(eli2);
        ui uiVar = new ui(d, i, d2, str, nu);
        ui.eli eliVar = new ui.eli();
        eliVar.eli = this.aGH.eli;
        eliVar.DbA = this.aGH.DbA;
        eliVar.Os = 0.0f;
        uiVar.eli(eliVar);
        uiVar.eli(eli2, 0.0f, 0.0f);
        uiVar.eli();
        if (uiVar.eli.aGH == 65536.0f) {
            return null;
        }
        return uiVar.eli.MGA;
    }

    private void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        int eli2;
        if (wCVar == null) {
            return;
        }
        if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() != null) {
            eli2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().Dfc();
        } else {
            eli2 = com.bytedance.sdk.component.adexpress.aGH.kb.eli(com.bytedance.sdk.component.adexpress.aGH.eli());
        }
        float min = this.aGH.Os ? this.aGH.eli : Math.min(this.aGH.eli, com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), eli2));
        if (this.aGH.DbA == 0.0f) {
            wCVar.ui(min);
            wCVar.aAs().ui().aAs("auto");
            wCVar.MGA(0.0f);
        } else {
            wCVar.ui(min);
            wCVar.MGA(this.aGH.Os ? this.aGH.DbA : Math.min(this.aGH.DbA, com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli(), com.bytedance.sdk.component.adexpress.aGH.kb.DbA(com.bytedance.sdk.component.adexpress.aGH.eli()))));
            wCVar.aAs().ui().aAs("fixed");
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli(JSONObject jSONObject, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        int length;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        if (TextUtils.equals(optString, "custom-component-vessel")) {
            int optInt = jSONObject.optInt("componentId");
            if (this.MGA != null) {
                Os os = new Os();
                this.ui = os;
                JSONObject eli2 = os.eli(this.MGA.eli, optInt, jSONObject);
                if (eli2 != null) {
                    jSONObject = eli2;
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli3 = eli(jSONObject);
        eli3.eli(wCVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null) {
            eli3.eli((List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC>) null);
            return eli3;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
            if (optJSONArray2 != null) {
                ArrayList arrayList3 = new ArrayList();
                if (TextUtils.equals(optString, "tag-group")) {
                    length = eli3.aAs().ui().GMY();
                } else {
                    length = optJSONArray2.length();
                }
                for (int i2 = 0; i2 < length; i2++) {
                    com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli4 = eli(optJSONArray2.optJSONObject(i2), eli3);
                    if (com.bytedance.sdk.component.adexpress.aGH.DbA() && "skip-with-time".equals(eli3.aAs().DbA()) && !C3040d4.h.T.equals(eli3.ev()) && !TextUtils.isEmpty(eli3.ev())) {
                        eli4.Os(eli3.ev());
                    }
                    arrayList.add(eli4);
                    arrayList3.add(eli4);
                }
                arrayList2.add(arrayList3);
            }
        }
        if (arrayList.size() > 0) {
            eli3.eli(arrayList);
        }
        if (arrayList2.size() > 0) {
            eli3.DbA(arrayList2);
        }
        return eli3;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.aGH.wC eli(JSONObject jSONObject) {
        String eli2;
        JSONObject jSONObject2;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("id");
        JSONObject optJSONObject = jSONObject.optJSONObject("values");
        FC.eli(optString, optJSONObject);
        JSONObject eli3 = FC.eli(optString, FC.eli(jSONObject.optJSONArray("sceneValues")), optJSONObject);
        com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar = new com.bytedance.sdk.component.adexpress.dynamic.aGH.wC();
        if (TextUtils.isEmpty(optString2)) {
            wCVar.DbA(String.valueOf(wCVar.hashCode()));
        } else {
            wCVar.DbA(optString2);
        }
        if (optJSONObject != null) {
            DbA(wCVar);
            wCVar.Os((float) optJSONObject.optDouble(VastAttributes.HORIZONTAL_POSITION));
            wCVar.aGH((float) optJSONObject.optDouble(VastAttributes.VERTICAL_POSITION));
            wCVar.ui((float) optJSONObject.optDouble("width"));
            wCVar.MGA((float) optJSONObject.optDouble("height"));
            wCVar.kb(optJSONObject.optInt("remainWidth"));
            com.bytedance.sdk.component.adexpress.dynamic.aGH.ui uiVar = new com.bytedance.sdk.component.adexpress.dynamic.aGH.ui();
            uiVar.eli(optString);
            uiVar.DbA(optJSONObject.optString("data"));
            uiVar.Os(optJSONObject.optString("dataExtraInfo"));
            com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA eli4 = com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA.eli(optJSONObject);
            uiVar.eli(eli4);
            com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA eli5 = com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA.eli(eli3);
            if (eli5 == null) {
                uiVar.DbA(eli4);
            } else {
                uiVar.DbA(eli5);
            }
            eli(eli4);
            eli(eli5);
            if (TextUtils.equals(optString, "video-image-budget") && (jSONObject2 = this.DbA) != null) {
                eli(uiVar, jSONObject2.optInt("image_mode"));
            }
            String DbA = uiVar.DbA();
            com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = uiVar.ui();
            if (kb.containsKey(DbA) && !ui.mm()) {
                ui.Xb(kb.get(DbA));
            }
            if (ui.mm()) {
                eli2 = uiVar.Os();
            } else {
                eli2 = eli(uiVar.Os());
            }
            if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
                if (TextUtils.equals(DbA, "star") || TextUtils.equals(DbA, "text_star")) {
                    eli2 = eli("dynamic_creative.score_exact_i18n|");
                }
                if (TextUtils.equals(DbA, "score-count") || TextUtils.equals(DbA, "score-count-type-1") || TextUtils.equals(DbA, "score-count-type-2")) {
                    eli2 = eli("dynamic_creative.comment_num_i18n|");
                }
                if ("root".equals(DbA) && eli4.CH()) {
                    eli2 = eli("image.0.url");
                }
            }
            if (!TextUtils.isEmpty(eli()) && (TextUtils.equals("logo-union", optString) || TextUtils.equals("logo", optString))) {
                uiVar.DbA(eli2 + "adx:" + eli());
            } else {
                uiVar.DbA(eli2);
            }
            wCVar.eli(uiVar);
        }
        return wCVar;
    }

    private void DbA(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.Os os;
        Object eli2;
        Object eli3;
        Object eli4;
        Object eli5;
        if (wCVar == null || (os = this.Os) == null || (eli2 = os.eli("image.0.url")) == null) {
            return;
        }
        String valueOf = String.valueOf(eli2);
        if (TextUtils.isEmpty(valueOf) || (eli3 = this.Os.eli("title")) == null) {
            return;
        }
        String valueOf2 = String.valueOf(eli3);
        if (TextUtils.isEmpty(valueOf2) || (eli4 = this.Os.eli("description")) == null) {
            return;
        }
        String valueOf3 = String.valueOf(eli4);
        if (TextUtils.isEmpty(valueOf3) || (eli5 = this.Os.eli("icon")) == null) {
            return;
        }
        String valueOf4 = String.valueOf(eli5);
        if (TextUtils.isEmpty(valueOf4)) {
            return;
        }
        Object eli6 = this.Os.eli("app.app_name");
        Object eli7 = this.Os.eli("source");
        if (eli6 == null && eli7 == null) {
            return;
        }
        if (eli6 == null) {
            eli6 = eli7;
        }
        String valueOf5 = String.valueOf(eli6);
        if (TextUtils.isEmpty(valueOf5)) {
            return;
        }
        wCVar.eli(UnifiedMediationParams.KEY_IMAGE_URL, valueOf);
        wCVar.eli("title", valueOf2);
        wCVar.eli("description", valueOf3);
        wCVar.eli("icon", valueOf4);
        wCVar.eli("app_name", valueOf5);
        wCVar.eli(true);
    }

    private void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.ui uiVar, int i) {
        int lastIndexOf;
        if (i == 5 || i == 15 || i == 50 || i == 154) {
            uiVar.eli("video");
            String eli2 = FC.eli("video");
            uiVar.ui().Xb(eli2);
            String eli3 = FC.eli("video", "clickArea");
            if (!TextUtils.isEmpty(eli3)) {
                uiVar.ui().Dfc(eli3);
                uiVar.kb().Dfc(eli3);
            }
            uiVar.kb().Xb(eli2);
            uiVar.DbA(eli2);
            uiVar.ui().lYL();
            return;
        }
        uiVar.eli("image");
        String eli4 = FC.eli("image");
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui = uiVar.ui();
        ui.Xb(eli4);
        uiVar.kb().Xb(eli4);
        String eli5 = FC.eli("image", "clickArea");
        if (!TextUtils.isEmpty(eli5)) {
            ui.Dfc(eli5);
            uiVar.kb().Dfc(eli5);
        }
        JSONObject dM = ui.dM();
        if (dM != null) {
            ui.ev(dM.optString("imageLottieTosPath"));
            ui.nlS(dM.optBoolean("animationsLoop"));
            ui.ujq(dM.optInt("lottieAppNameMaxLength"));
            ui.KM(dM.optInt("lottieAdDescMaxLength"));
            ui.Ue(dM.optInt("lottieAdTitleMaxLength"));
        }
        uiVar.DbA(eli4);
        if (eli4 != null && (lastIndexOf = eli4.lastIndexOf(".")) > 0) {
            String substring = eli4.substring(0, lastIndexOf);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", eli(substring + ".width"));
                jSONObject.put("height", eli(substring + ".height"));
            } catch (JSONException unused) {
            }
            uiVar.Os(jSONObject.toString());
        }
        ui.tpZ();
    }

    private String eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (String str2 : str.split("\\|")) {
            if (this.Os.DbA(str2)) {
                String valueOf = String.valueOf(this.Os.eli(str2));
                if (!TextUtils.isEmpty(valueOf)) {
                    return valueOf;
                }
            }
        }
        return "";
    }

    private String eli() {
        Object eli2;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.Os os = this.Os;
        return (os == null || (eli2 = os.eli("adx_name")) == null) ? "" : String.valueOf(eli2);
    }

    private void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA mga) {
        if (mga == null) {
            return;
        }
        String VM = mga.VM();
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            String Os = com.bytedance.sdk.component.adexpress.aGH.kb.Os(com.bytedance.sdk.component.adexpress.aGH.eli());
            if ("zh".equals(Os)) {
                Os = "cn";
            }
            if (!TextUtils.isEmpty(Os) && mga.MGA() != null) {
                String optString = mga.MGA().optString(Os);
                if (!TextUtils.isEmpty(optString)) {
                    VM = optString;
                }
            }
        }
        if (TextUtils.isEmpty(VM)) {
            return;
        }
        int indexOf = VM.indexOf("{{");
        int indexOf2 = VM.indexOf("}}");
        if (indexOf < 0 || indexOf2 < 0 || indexOf2 < indexOf) {
            mga.nlS(VM);
            return;
        }
        String eli2 = eli(VM.substring(indexOf + 2, indexOf2));
        StringBuilder sb = new StringBuilder(VM.substring(0, indexOf));
        if (!TextUtils.isEmpty(eli2)) {
            sb.append(eli2);
        }
        sb.append(VM.substring(indexOf2 + 2));
        mga.nlS(sb.toString());
    }

    static class eli {
        float DbA;
        boolean Os;
        float eli;

        public static eli eli(JSONObject jSONObject) {
            eli eliVar = new eli();
            if (jSONObject != null) {
                eliVar.eli = (float) jSONObject.optDouble("width");
                eliVar.DbA = (float) jSONObject.optDouble("height");
                eliVar.Os = jSONObject.optBoolean("isLandscape");
            }
            return eliVar;
        }
    }
}
