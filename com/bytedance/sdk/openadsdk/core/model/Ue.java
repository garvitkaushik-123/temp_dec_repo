package com.bytedance.sdk.openadsdk.core.model;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Ue {
    private String DbA;
    private String FC;
    private String MGA;
    private int Os;
    private String aAs;
    private int aGH;
    private int du;
    private String eli;
    private String kb;
    private String ui;
    private int wC;

    public String eli() {
        return this.kb;
    }

    public void eli(String str) {
        this.kb = str;
    }

    public void eli(int i) {
        this.du = i;
    }

    public int DbA() {
        return this.wC;
    }

    public void DbA(int i) {
        this.wC = i;
    }

    public String Os() {
        return this.FC;
    }

    public void DbA(String str) {
        this.FC = str;
    }

    public void Os(String str) {
        this.aAs = str;
    }

    public String aGH() {
        return this.ui;
    }

    public void aGH(String str) {
        this.ui = str;
    }

    public String ui() {
        return this.MGA;
    }

    public void ui(String str) {
        this.MGA = str;
    }

    public void MGA(String str) {
        this.eli = str;
    }

    public void kb(String str) {
        this.DbA = str;
    }

    public void Os(int i) {
        this.Os = i;
    }

    public int MGA() {
        return this.aGH;
    }

    public void aGH(int i) {
        this.aGH = i;
    }

    public boolean kb() {
        return this.aGH == 1;
    }

    public boolean wC() {
        return this.du == 1;
    }

    public static Ue eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Ue ue = new Ue();
        try {
            ue.MGA(jSONObject.optString("market_dpl", ""));
            ue.kb(jSONObject.optString("market_dpl_auto", ""));
            ue.Os(jSONObject.optInt("exec_type", 0));
            ue.aGH(jSONObject.optInt("oem_vendor_type", 0));
            ue.aGH(jSONObject.optString("market_pkg", ""));
            ue.ui(jSONObject.optString("regex", ""));
            ue.DbA(jSONObject.optInt("overlay", 1));
            ue.DbA(jSONObject.optString("caller_id", ""));
            ue.Os(jSONObject.optString("ext_map", null));
            ue.eli(jSONObject.optInt("gp_card", 0));
            ue.eli(jSONObject.optString("app_pkg", ""));
            return ue;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("OemModel", th.getMessage());
            return ue;
        }
    }

    public String FC() {
        if (this.Os == 2) {
            return this.DbA;
        }
        return this.eli;
    }

    public JSONObject aAs() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.eli)) {
                jSONObject.put("market_dpl", this.eli);
            }
            if (!TextUtils.isEmpty(this.DbA)) {
                jSONObject.put("market_dpl_auto", this.DbA);
            }
            if (!TextUtils.isEmpty(this.ui)) {
                jSONObject.put("market_pkg", this.ui);
            }
            if (!TextUtils.isEmpty(this.kb)) {
                jSONObject.put("app_pkg", this.kb);
            }
            if (!TextUtils.isEmpty(this.MGA)) {
                jSONObject.put("regex", this.MGA);
            }
            jSONObject.put("exec_type", this.Os);
            jSONObject.put("oem_vendor_type", this.aGH);
            jSONObject.put("overlay", this.wC);
            jSONObject.put("gp_card", this.du);
            if (!TextUtils.isEmpty(this.FC)) {
                jSONObject.put("caller_id", this.FC);
            }
            if (!TextUtils.isEmpty(this.aAs)) {
                jSONObject.put("ext_map", this.aAs);
            }
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("OemModel", th.getMessage());
            return null;
        }
    }

    public void eli(Intent intent) {
        if (TextUtils.isEmpty(this.aAs)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.aAs);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    intent.putExtra(next, (String) obj);
                } else if (obj instanceof Integer) {
                    intent.putExtra(next, (Integer) obj);
                } else if (obj instanceof Boolean) {
                    intent.putExtra(next, (Boolean) obj);
                } else if (obj instanceof Long) {
                    intent.putExtra(next, (Long) obj);
                } else if (obj instanceof Double) {
                    intent.putExtra(next, (Double) obj);
                } else if (obj instanceof Float) {
                    intent.putExtra(next, (Float) obj);
                } else {
                    new Object[]{"Unsupported type ", next, obj};
                }
            }
        } catch (Throwable th) {
            new Object[]{th};
        }
    }
}
