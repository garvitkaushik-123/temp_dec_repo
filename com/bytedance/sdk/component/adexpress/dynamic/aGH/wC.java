package com.bytedance.sdk.component.adexpress.dynamic.aGH;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    private float DbA;
    private ui FC;
    private float MGA;
    private String NU;
    private float Os;
    private List<wC> aAs;
    private float aGH;
    private wC du;
    private String eli;
    private float kb;
    private List<List<wC>> nlS;
    private boolean nn;
    private float ui;
    private float wC;
    private Map<String, String> Dfc = new HashMap();
    private Map<Integer, String> aqO = new HashMap();

    public String eli() {
        return this.NU;
    }

    public void eli(String str) {
        this.NU = str;
    }

    public Map<Integer, String> DbA() {
        return this.aqO;
    }

    public void eli(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    this.aqO.put(Integer.valueOf(optJSONObject.optInt("id")), optJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String Os() {
        return this.eli;
    }

    public void DbA(String str) {
        this.eli = str;
    }

    public float aGH() {
        return this.aGH;
    }

    public void eli(float f) {
        this.aGH = f;
    }

    public float ui() {
        return this.ui;
    }

    public void DbA(float f) {
        this.ui = f;
    }

    public float MGA() {
        return this.DbA;
    }

    public void Os(float f) {
        this.DbA = f;
    }

    public float kb() {
        return this.Os;
    }

    public void aGH(float f) {
        this.Os = f;
    }

    public float wC() {
        return this.MGA;
    }

    public void ui(float f) {
        this.MGA = f;
    }

    public float FC() {
        return this.kb;
    }

    public void MGA(float f) {
        this.kb = f;
    }

    public void kb(float f) {
        this.wC = f;
    }

    public ui aAs() {
        return this.FC;
    }

    public void eli(ui uiVar) {
        this.FC = uiVar;
    }

    public List<wC> du() {
        return this.aAs;
    }

    public void eli(List<wC> list) {
        this.aAs = list;
    }

    public void eli(wC wCVar) {
        this.du = wCVar;
    }

    public wC nlS() {
        return this.du;
    }

    public int NU() {
        MGA ui = this.FC.ui();
        return ui.WfR() + ui.ow();
    }

    public int nn() {
        MGA ui = this.FC.ui();
        return ui.ikX() + ui.tGZ();
    }

    public float Dfc() {
        MGA ui = this.FC.ui();
        return NU() + ui.Dfc() + ui.aqO() + (ui.nlS() * 2.0f);
    }

    public float aqO() {
        MGA ui = this.FC.ui();
        return nn() + ui.dV() + ui.nn() + (ui.nlS() * 2.0f);
    }

    public void DbA(List<List<wC>> list) {
        this.nlS = list;
    }

    public List<List<wC>> dV() {
        return this.nlS;
    }

    public boolean nGm() {
        List<wC> list = this.aAs;
        return list == null || list.size() <= 0;
    }

    public boolean QX() {
        return this.nn;
    }

    public void eli(boolean z) {
        this.nn = z;
    }

    public Map<String, String> Xb() {
        return this.Dfc;
    }

    public void eli(String str, String str2) {
        this.Dfc.put(str, str2);
    }

    public void bf() {
        List<List<wC>> list = this.nlS;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<wC> list2 : this.nlS) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.nlS = arrayList;
    }

    public boolean CMM() {
        return TextUtils.equals(this.FC.ui().KM(), "flex");
    }

    public String ev() {
        return this.FC.ui().ev();
    }

    public void Os(String str) {
        this.FC.ui().MGA(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.eli + "', x=" + this.DbA + ", y=" + this.Os + ", width=" + this.MGA + ", height=" + this.kb + ", remainWidth=" + this.wC + ", rootBrick=" + this.FC + ", childrenBrickUnits=" + this.aAs + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean Vy() {
        return this.FC.ui().rn() < 0 || this.FC.ui().Gjg() < 0 || this.FC.ui().Ca() < 0 || this.FC.ui().yKf() < 0;
    }

    public String eli(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.FC.DbA());
        sb.append(":");
        sb.append(this.eli);
        if (this.FC.ui() != null) {
            sb.append(":");
            sb.append(this.FC.ui().kEI());
        }
        sb.append(":");
        sb.append(i);
        return sb.toString();
    }
}
