package com.bytedance.adsdk.ugeno.aGH;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private List<eli> DbA;
    private eli eli;

    public eli eli() {
        return this.eli;
    }

    public List<eli> DbA() {
        return this.DbA;
    }

    public static class eli {
        private String DbA;
        private Map<String, Object> MGA;
        private String Os = "global";
        private String aGH;
        private String eli;
        private Map<String, String> ui;

        public String eli() {
            return this.Os;
        }

        public void eli(String str) {
            this.Os = str;
        }

        public String DbA() {
            return this.aGH;
        }

        public void DbA(String str) {
            this.aGH = str;
        }

        public Map<String, String> Os() {
            return this.ui;
        }

        public void eli(Map<String, String> map) {
            this.ui = map;
        }

        public void Os(String str) {
            this.eli = str;
        }

        public String aGH() {
            return this.eli;
        }

        public void aGH(String str) {
            this.DbA = str;
        }

        public String ui() {
            return this.DbA;
        }

        public void DbA(Map<String, Object> map) {
            this.MGA = map;
        }

        public String toString() {
            return "Action{scheme='" + this.Os + "', name='" + this.aGH + "', params=" + this.ui + ", host='" + this.DbA + "', origin='" + this.eli + "', extra=" + this.MGA + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static MGA eli(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        MGA mga = new MGA();
        String optString = jSONObject.optString(DebugKt.DEBUG_PROPERTY_VALUE_ON);
        JSONArray optJSONArray = jSONObject.optJSONArray("handlers");
        mga.eli = nlS.eli(optString, jSONObject2);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            eli eli2 = nlS.eli(optJSONArray.optString(i), jSONObject2);
            if (eli2 != null) {
                arrayList.add(eli2);
            }
        }
        mga.DbA = arrayList;
        return mga;
    }
}
