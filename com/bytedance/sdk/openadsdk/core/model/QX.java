package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class QX {
    public static int DbA = 2;
    public static int eli = 1;
    private int Os = 5;
    private int aGH = 30;
    private int ui = 70;
    private int MGA = 1;
    private int kb = eli;
    private int wC = 0;
    private int FC = 0;
    private int aAs = 3;

    public int eli() {
        return this.aAs;
    }

    public void eli(int i) {
        this.aAs = i;
    }

    public int DbA() {
        return this.FC;
    }

    public void DbA(int i) {
        this.FC = i;
    }

    public int Os() {
        return this.wC;
    }

    public void Os(int i) {
        this.wC = i;
    }

    public int aGH() {
        return this.Os;
    }

    public void aGH(int i) {
        this.Os = i;
    }

    public int ui() {
        return this.aGH;
    }

    public void ui(int i) {
        this.aGH = i;
    }

    public int MGA() {
        return this.ui;
    }

    public void MGA(int i) {
        this.ui = i;
    }

    public int kb() {
        return this.MGA;
    }

    public void kb(int i) {
        this.MGA = i;
    }

    public int wC() {
        return this.kb;
    }

    public void wC(int i) {
        this.kb = i;
    }

    public boolean eli(boolean z) {
        if (z) {
            int i = this.wC;
            return i == 1 || i == 3;
        }
        int i2 = this.wC;
        return i2 == 3 || i2 == 2;
    }

    public JSONObject eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ceiling_time", this.Os);
            jSONObject.put("ceiling_ratio", this.aGH);
            jSONObject.put("expand_ratio", this.ui);
            jSONObject.put("back_type", this.MGA);
            jSONObject.put("boc_return_type", this.kb);
            jSONObject.put("pre_render_status", this.wC);
            jSONObject.put("pre_render_use_gecko", this.FC);
            jSONObject.put("pre_render_add_type", this.aAs);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("InteractionParams", th.getMessage());
            return jSONObject;
        }
    }
}
