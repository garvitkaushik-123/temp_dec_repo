package com.bytedance.sdk.openadsdk.core.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    private int DbA;
    private int MGA;
    private List<Integer> Os;
    private int aGH;
    private int eli;
    private int kb;
    private List<String> ui;

    public void eli(int i) {
        this.MGA = i;
    }

    public int eli() {
        int i = this.kb;
        if (i >= 2) {
            return i;
        }
        return 0;
    }

    public void DbA(int i) {
        this.kb = i;
    }

    public List<String> DbA() {
        return this.ui;
    }

    public void eli(List<String> list) {
        this.ui = list;
    }

    public int Os() {
        return this.eli;
    }

    public void Os(int i) {
        this.eli = i;
    }

    public int aGH() {
        return this.DbA;
    }

    public void aGH(int i) {
        this.DbA = i;
    }

    public List<Integer> ui() {
        return this.Os;
    }

    public void DbA(List<Integer> list) {
        this.Os = list;
    }

    public int MGA() {
        return this.aGH;
    }

    public void ui(int i) {
        this.aGH = i;
    }

    public JSONObject kb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interceptor_x", this.eli);
            jSONObject.put("interceptor_y", this.DbA);
            if (this.Os != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this.Os.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().intValue());
                }
                jSONObject.put("interceptor_page", jSONArray);
            }
            jSONObject.put("interceptor_interval_time", this.aGH);
            if (this.ui != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it2 = this.ui.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
                jSONObject.put("url_regular", jSONArray2);
            }
            jSONObject.put("is_act", this.MGA);
            jSONObject.put("boc_index", this.kb);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os(th.getMessage(), new Object[0]);
            return jSONObject;
        }
    }
}
