package com.bytedance.sdk.openadsdk.core.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA {
    private int kb;
    private String eli = "";
    private String DbA = "";
    private String Os = "";
    private String aGH = "";
    private double ui = -1.0d;
    private int MGA = -1;

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

    public String Os() {
        return this.Os;
    }

    public void Os(String str) {
        this.Os = str;
    }

    public double aGH() {
        return this.ui;
    }

    public void eli(double d) {
        if (d < 1.0d || d > 5.0d) {
            this.ui = -1.0d;
        } else {
            this.ui = d;
        }
    }

    public int ui() {
        return this.MGA;
    }

    public void eli(int i) {
        if (i <= 0) {
            this.MGA = -1;
        } else {
            this.MGA = i;
        }
    }

    public int MGA() {
        return this.kb;
    }

    public void DbA(int i) {
        this.kb = i;
    }

    public String kb() {
        return this.aGH;
    }

    public void aGH(String str) {
        this.aGH = str;
    }

    public JSONObject wC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", DbA());
            jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, MGA());
            jSONObject.put("comment_num", ui());
            jSONObject.put(DownloadModel.DOWNLOAD_URL, eli());
            jSONObject.put("package_name", Os());
            jSONObject.put(FirebaseAnalytics.Param.SCORE, aGH());
            jSONObject.put("app_category", kb());
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os(e.toString(), new Object[0]);
            return jSONObject;
        }
    }
}
