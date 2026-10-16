package com.bytedance.sdk.openadsdk.aGH.eli;

import android.text.TextUtils;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NU implements com.bytedance.sdk.openadsdk.Dfc.DbA {
    private final boolean DbA;
    private final com.bytedance.sdk.component.MGA.eli.MGA.aGH eli;

    public NU(boolean z, com.bytedance.sdk.component.MGA.eli.MGA.aGH agh) {
        this.eli = agh;
        this.DbA = z;
    }

    @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
    public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
        int i;
        if (this.eli == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", this.DbA);
        jSONObject.put("url", this.eli.DbA());
        int aGH = this.eli.aGH();
        if (aGH <= 0) {
            aGH = 0;
        }
        jSONObject.put("retry_times", aGH);
        jSONObject.put("ad_id", this.eli.MGA());
        jSONObject.put("track_type", this.eli.ui());
        if (!this.DbA) {
            i = 4;
        } else if (this.eli.aAs()) {
            i = 3;
        } else {
            i = this.eli.aGH() <= 0 ? 1 : 2;
        }
        jSONObject.put("upload_scene", i);
        String kb = this.eli.kb();
        if (!TextUtils.isEmpty(kb)) {
            JSONArray jSONArray = new JSONArray();
            for (String str : kb.split(",")) {
                jSONArray.put(str);
            }
            jSONObject.put(AndroidBridgeConstants.ERROR_CODE, jSONArray);
        }
        String FC = this.eli.FC();
        if (!TextUtils.isEmpty(FC)) {
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : FC.split(",")) {
                jSONArray2.put(str2);
            }
            jSONObject.put("error_msg", jSONArray2);
        }
        return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("track_link_result").DbA(jSONObject.toString());
    }
}
