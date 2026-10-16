package com.bytedance.sdk.openadsdk.core.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui {
    private aGH DbA;
    private ArrayList<eli> eli;

    public ui(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            eli eliVar = new eli(jSONArray.optJSONObject(i));
            if (this.eli == null) {
                this.eli = new ArrayList<>();
            }
            this.eli.add(eliVar);
        }
    }

    public static boolean eli(ev evVar) {
        if (evVar == null || evVar.gG()) {
            return false;
        }
        int cK = evVar.cK();
        int GR = evVar.GR();
        return (cK == 3 || cK == 7 || cK == 8) && (GR == 5 || GR == 15 || GR == 50);
    }

    public ArrayList<eli> eli() {
        return this.eli;
    }

    public JSONArray DbA() {
        JSONArray jSONArray = new JSONArray();
        ArrayList<eli> arrayList = this.eli;
        if (arrayList != null) {
            try {
                Iterator<eli> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().ui());
                }
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    public aGH Os() {
        if (this.DbA == null) {
            this.DbA = new aGH();
            ArrayList<eli> arrayList = this.eli;
            if (arrayList != null) {
                Iterator<eli> it = arrayList.iterator();
                while (it.hasNext()) {
                    eli next = it.next();
                    com.bytedance.sdk.openadsdk.core.du.aGH eli2 = next.eli();
                    Set<com.bytedance.sdk.openadsdk.core.du.aAs> DbA = next.DbA();
                    if (eli2 != null) {
                        this.DbA.eli().eli(eli2);
                    }
                    if (DbA != null) {
                        this.DbA.DbA().addAll(DbA);
                    }
                }
            }
        }
        return this.DbA;
    }

    public boolean aGH() {
        ArrayList<eli> arrayList = this.eli;
        return (arrayList == null || arrayList.isEmpty()) ? false : true;
    }

    public static class eli {
        private final String DbA;
        private com.bytedance.sdk.openadsdk.core.du.aGH Os;
        private Set<com.bytedance.sdk.openadsdk.core.du.aAs> aGH;
        private final String eli;

        public eli(JSONObject jSONObject) {
            this.eli = jSONObject.optString("vast_url");
            this.DbA = jSONObject.optString("vast_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("videoTrackers");
            if (optJSONObject != null) {
                com.bytedance.sdk.openadsdk.core.du.aGH agh = new com.bytedance.sdk.openadsdk.core.du.aGH();
                this.Os = agh;
                agh.eli(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("viewabilityVendor");
            if (optJSONArray != null) {
                this.aGH = com.bytedance.sdk.openadsdk.core.du.aAs.eli(optJSONArray);
            }
        }

        public com.bytedance.sdk.openadsdk.core.du.aGH eli() {
            return this.Os;
        }

        public void eli(com.bytedance.sdk.openadsdk.core.du.aGH agh) {
            this.Os = agh;
        }

        public Set<com.bytedance.sdk.openadsdk.core.du.aAs> DbA() {
            return this.aGH;
        }

        public void eli(Set<com.bytedance.sdk.openadsdk.core.du.aAs> set) {
            this.aGH = set;
        }

        public String Os() {
            return this.eli;
        }

        public String aGH() {
            return this.DbA;
        }

        public JSONObject ui() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("vast_url", this.eli);
            jSONObject.put("vast_content", this.DbA);
            com.bytedance.sdk.openadsdk.core.du.aGH agh = this.Os;
            if (agh != null) {
                jSONObject.put("videoTrackers", agh.eli());
            }
            if (this.aGH != null) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.du.aAs aas : this.aGH) {
                    if (aas != null) {
                        jSONArray.put(aas.aGH());
                    }
                }
                jSONObject.put("viewabilityVendor", jSONArray);
            }
            return jSONObject;
        }
    }
}
