package com.bytedance.sdk.openadsdk.Xb.DbA;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private List<C0159eli> DbA;
    private List<C0159eli> Os;
    private String eli;

    public void eli(String str) {
        this.eli = str;
    }

    public void eli(List<C0159eli> list) {
        this.DbA = list;
    }

    public void DbA(List<C0159eli> list) {
        this.Os = list;
    }

    public String eli() {
        return this.eli;
    }

    public List<C0159eli> DbA() {
        return this.DbA;
    }

    public List<C0159eli> Os() {
        return this.Os;
    }

    public static eli DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            eli eliVar = new eli();
            eliVar.eli(jSONObject.optString("version"));
            JSONArray optJSONArray = jSONObject.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0159eli eli = C0159eli.eli(optJSONArray.optJSONObject(i));
                    if (eli != null) {
                        if (eli.Os == 1) {
                            arrayList.add(eli);
                        } else if (eli.Os == 2 && arrayList2.size() < 10) {
                            arrayList2.add(eli);
                        }
                    }
                }
            }
            eliVar.eli(arrayList);
            eliVar.DbA(arrayList2);
            return eliVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.Xb.DbA.eli$eli, reason: collision with other inner class name */
    public static class C0159eli {
        private String DbA;
        private int Os;
        private String eli;

        public static C0159eli eli(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0159eli c0159eli = new C0159eli();
            c0159eli.eli = jSONObject.optString("url");
            c0159eli.DbA = jSONObject.optString("md5");
            c0159eli.Os = jSONObject.optInt("type");
            return c0159eli;
        }

        public String eli() {
            return this.eli;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0159eli) {
                String str2 = this.eli;
                if (str2 != null) {
                    C0159eli c0159eli = (C0159eli) obj;
                    if (str2.equals(c0159eli.eli) && (str = this.DbA) != null && str.equals(c0159eli.DbA)) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }
    }
}
