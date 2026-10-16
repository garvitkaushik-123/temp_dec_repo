package com.bytedance.adsdk.ugeno.core;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastTagName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    private JSONObject DbA;
    private float FC;
    private JSONObject MGA;
    private String Os;
    private JSONObject aGH;
    private JSONObject eli;
    private boolean kb;
    private String ui;
    private float wC;

    public kb(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public kb(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.eli = jSONObject.optJSONObject("body");
            } else {
                this.eli = jSONObject.optJSONObject("main_template");
            }
            this.DbA = jSONObject.optJSONObject("sub_templates");
            if (jSONObject.has(Constants.REFERRER_API_META)) {
                optJSONObject = jSONObject.optJSONObject(Constants.REFERRER_API_META);
            } else {
                optJSONObject = jSONObject.optJSONObject("template_info");
            }
            if (optJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.kb = true;
                    String optString = optJSONObject.optString("version");
                    this.Os = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.Os = "3.0";
                    }
                } else {
                    this.Os = optJSONObject.optString(BidTokenRepositoryKt.SDK_VERSION);
                }
                if (optJSONObject.has("adType")) {
                    this.ui = optJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.Os = "3.0";
                this.kb = true;
            }
            this.aGH = jSONObject2;
            this.MGA = jSONObject3;
        }
    }

    public eli eli() {
        return ui();
    }

    public void eli(float f, float f2) {
        this.wC = f;
        this.FC = f2;
    }

    private eli ui() {
        if (!aGH()) {
            return eli(this.eli, (eli) null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("flexDirection", "row");
            jSONObject.put("justifyContent", "flex_start");
            jSONObject.put("alignItems", "flex_start");
            jSONObject.put("clickable", false);
            jSONObject.put("width", "match_parent");
            jSONObject.put("height", "wrap_content");
            float f = this.wC;
            if (f > 0.0f) {
                jSONObject.put("width", f);
            }
            float f2 = this.FC;
            if (f2 > 0.0f) {
                jSONObject.put("height", f2);
            }
            String optString = this.aGH.optString("xSize");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.optInt("width") > 0) {
                    jSONObject.put("width", jSONObject2.optInt("width"));
                }
                if (jSONObject2.optInt("height") > 0) {
                    jSONObject.put("height", jSONObject2.optInt("height"));
                }
            }
        } catch (JSONException unused) {
        }
        eli eliVar = new eli();
        eliVar.DbA = "View";
        eliVar.eli = "virtualNode";
        eliVar.Os = jSONObject;
        eliVar.MGA = null;
        eliVar.kb = this.Os;
        eliVar.wC = this.ui;
        eliVar.eli(eli(this.eli, eliVar));
        return eliVar;
    }

    public String DbA() {
        return this.Os;
    }

    public List<eli> Os() {
        if (this.DbA == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.DbA.keys();
        while (keys.hasNext()) {
            eli eli2 = eli(this.DbA.optJSONObject(keys.next()), (eli) null);
            if (eli2 != null) {
                arrayList.add(eli2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private eli eli(JSONObject jSONObject, eli eliVar) {
        String optString;
        String optString2;
        eli eli2;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("type")) {
            optString = jSONObject.optString("type");
        } else {
            optString = jSONObject.optString("name");
        }
        String optString3 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        eli eliVar2 = new eli();
        eliVar2.eli = optString3;
        if (!this.kb || !TextUtils.equals(VastTagName.VIDEO, optString)) {
            eliVar2.DbA = optString;
        } else {
            eliVar2.DbA = optString + "V3";
        }
        eliVar2.Os = jSONObject2;
        eliVar2.MGA = eliVar;
        eliVar2.kb = this.Os;
        eliVar2.wC = this.ui;
        if (jSONObject2.has("i18n")) {
            eliVar2.aGH = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(optString, "CustomComponent")) {
            eli(jSONObject, eliVar2.Os);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int i = 0;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (jSONObject.has("type")) {
                    optString2 = jSONObject.optString("type");
                } else {
                    optString2 = jSONObject.optString("name");
                }
                String eli3 = com.bytedance.adsdk.ugeno.Os.DbA.eli(optJSONObject.optString("id"), this.aGH);
                if (TextUtils.equals(optString2, "Template")) {
                    JSONObject jSONObject3 = this.DbA;
                    if (jSONObject3 != null) {
                        optJSONObject = jSONObject3.optJSONObject(eli3);
                    } else {
                        eli2 = null;
                        if (eli2 != null) {
                            eli2.DbA(DbA(eli2));
                            eli2.eli(eli(eli2));
                        }
                        if (!Os(eli2)) {
                            i++;
                            eliVar2.DbA(eli2);
                        } else if (eli2 != null) {
                            eliVar2.eli(i2 - i, eli2);
                        }
                    }
                }
                eli2 = eli(optJSONObject, eliVar2);
                if (eli2 != null) {
                }
                if (!Os(eli2)) {
                }
            }
        }
        return eliVar2;
    }

    public boolean eli(eli eliVar) {
        JSONObject aGH;
        if (eliVar == null || (aGH = eliVar.aGH()) == null) {
            return false;
        }
        return TextUtils.equals(aGH.optString("width"), "match_parent");
    }

    public boolean DbA(eli eliVar) {
        JSONObject aGH;
        if (eliVar == null || (aGH = eliVar.aGH()) == null) {
            return false;
        }
        return TextUtils.equals(aGH.optString("height"), "match_parent");
    }

    public boolean Os(eli eliVar) {
        JSONObject aGH;
        if (eliVar == null || (aGH = eliVar.aGH()) == null) {
            return false;
        }
        return TextUtils.equals(aGH.optString(C3040d4.h.L), "absolute");
    }

    public boolean aGH() {
        return this.kb;
    }

    private void eli(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.MGA == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = this.MGA.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(optString);
            JSONObject optJSONObject = jSONObject2.optJSONObject("targetProps");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = optJSONObject.opt(next);
                    if (TextUtils.equals(next, "events") && jSONObject3.has("events")) {
                        if (opt instanceof JSONArray) {
                            com.bytedance.adsdk.ugeno.kb.DbA.eli(jSONObject3.optJSONArray("events"), (JSONArray) opt);
                        }
                    } else {
                        jSONObject3.put(next, opt);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", optJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean aGH(eli eliVar) {
        return (eliVar == null || eliVar.Os == null) ? false : true;
    }

    public static class eli {
        private String DbA;
        private boolean FC;
        private eli MGA;
        private JSONObject Os;
        private boolean aAs;
        private JSONObject aGH;
        private String eli;
        private String kb;
        private LinkedList<eli> ui;
        private String wC;

        public String eli() {
            return this.eli;
        }

        public String DbA() {
            return this.kb;
        }

        public String Os() {
            return this.DbA;
        }

        public void eli(String str) {
            this.DbA = str;
        }

        public void eli(boolean z) {
            this.FC = z;
        }

        public void DbA(boolean z) {
            this.aAs = z;
        }

        public JSONObject aGH() {
            return this.Os;
        }

        public List<eli> ui() {
            return this.ui;
        }

        public void eli(eli eliVar) {
            if (this.ui == null) {
                this.ui = new LinkedList<>();
            }
            this.ui.add(eliVar);
        }

        public void DbA(eli eliVar) {
            if (this.ui == null) {
                this.ui = new LinkedList<>();
            }
            this.ui.addLast(eliVar);
        }

        public void eli(int i, eli eliVar) {
            if (this.ui == null) {
                this.ui = new LinkedList<>();
            }
            this.ui.add(i, eliVar);
        }

        public JSONObject MGA() {
            return this.aGH;
        }

        public String toString() {
            return "UGNode{id='" + this.eli + "', name='" + this.DbA + "'}";
        }
    }
}
