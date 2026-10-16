package com.bytedance.sdk.component.adexpress.eli.Os;

import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private String DbA;
    private String MGA;
    private String Os;
    private List<C0143eli> aGH;
    private String eli;
    private Map<String, eli> kb = new ConcurrentHashMap();
    private DbA ui;

    public Map<String, eli> eli() {
        return this.kb;
    }

    public String DbA() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }

    public String Os() {
        return this.DbA;
    }

    public void DbA(String str) {
        this.DbA = str;
    }

    public String aGH() {
        return this.Os;
    }

    public void Os(String str) {
        this.Os = str;
    }

    public void eli(DbA dbA) {
        this.ui = dbA;
    }

    public DbA ui() {
        return this.ui;
    }

    public List<C0143eli> MGA() {
        if (this.aGH == null) {
            this.aGH = new ArrayList();
        }
        return this.aGH;
    }

    public void eli(List<C0143eli> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.aGH = list;
    }

    public void aGH(String str) {
        this.MGA = str;
    }

    public String kb() {
        return this.MGA;
    }

    public boolean wC() {
        return (TextUtils.isEmpty(aGH()) || TextUtils.isEmpty(Os()) || TextUtils.isEmpty(DbA())) ? false : true;
    }

    public JSONObject FC() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", DbA());
            jSONObject.putOpt("version", Os());
            jSONObject.putOpt(C3040d4.h.Z, aGH());
            if (!TextUtils.isEmpty(this.MGA)) {
                jSONObject.put("template_fetch_url", this.MGA);
            }
            JSONArray jSONArray = new JSONArray();
            if (MGA() != null) {
                for (C0143eli c0143eli : MGA()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0143eli.eli());
                    jSONObject2.putOpt("md5", c0143eli.DbA());
                    jSONObject2.putOpt("level", Integer.valueOf(c0143eli.Os()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.kb.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.kb.keySet()) {
                    eli eliVar = this.kb.get(str);
                    if (eliVar != null) {
                        jSONObject3.put(str, eliVar.FC());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            DbA ui = ui();
            if (ui != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", ui.eli);
                jSONObject4.put("md5", ui.DbA);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> DbA2 = ui.DbA();
                if (DbA2 != null) {
                    for (Pair<String, String> pair : DbA2) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String aAs() {
        JSONObject FC;
        if (!wC() || (FC = FC()) == null) {
            return null;
        }
        return FC.toString();
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.eli.Os.eli$eli, reason: collision with other inner class name */
    public static class C0143eli {
        private String DbA;
        private int Os;
        private String eli;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0143eli) {
                String str2 = this.eli;
                if (str2 != null) {
                    C0143eli c0143eli = (C0143eli) obj;
                    if (str2.equals(c0143eli.eli()) && (str = this.DbA) != null && str.equals(c0143eli.DbA())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

        public String eli() {
            return this.eli;
        }

        public void eli(String str) {
            this.eli = str;
        }

        public String DbA() {
            return this.DbA;
        }

        public void DbA(String str) {
            this.DbA = str;
        }

        public int Os() {
            return this.Os;
        }

        public void eli(int i) {
            this.Os = i;
        }
    }

    public static class DbA {
        private String DbA;
        private List<Pair<String, String>> Os;
        private String eli;

        public String eli() {
            return this.eli;
        }

        public void eli(String str) {
            this.eli = str;
        }

        public void DbA(String str) {
            this.DbA = str;
        }

        public void eli(List<Pair<String, String>> list) {
            this.Os = list;
        }

        public List<Pair<String, String>> DbA() {
            return this.Os;
        }
    }

    public static eli ui(String str) {
        if (str == null) {
            return null;
        }
        try {
            return eli(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static eli eli(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        eli eliVar = new eli();
        eliVar.eli(jSONObject.optString("name"));
        eliVar.DbA(jSONObject.optString("version"));
        eliVar.Os(jSONObject.optString(C3040d4.h.Z));
        eliVar.aGH(jSONObject.optString("template_fetch_url", ""));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                C0143eli c0143eli = new C0143eli();
                c0143eli.eli(optJSONObject2.optString("url"));
                c0143eli.DbA(optJSONObject2.optString("md5"));
                c0143eli.eli(optJSONObject2.optInt("level"));
                arrayList.add(c0143eli);
            }
        }
        eliVar.eli(arrayList);
        try {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("engines");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    eli eli = eli(optJSONObject3.optJSONObject(next));
                    if (eli != null) {
                        eliVar.eli().put(next, eli);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (optJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            DbA dbA = new DbA();
            dbA.eli(optJSONObject.optString("url"));
            dbA.DbA(optJSONObject.optString("md5"));
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("map");
            if (optJSONObject4 != null) {
                Iterator<String> keys2 = optJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    arrayList2.add(new Pair<>(next2, optJSONObject4.optString(next2)));
                }
                dbA.eli(arrayList2);
            }
            eliVar.eli(dbA);
        }
        if (eliVar.wC()) {
            return eliVar;
        }
        return null;
    }
}
