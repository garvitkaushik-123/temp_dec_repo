package com.bytedance.sdk.openadsdk.dV;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.nn;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class ui implements aGH {
    private int DbA;
    private int MGA;
    private aGH Os;
    private int aGH;
    long eli = System.currentTimeMillis();
    private int ui;

    public ui(aGH agh, int i, int i2, int i3) {
        this.DbA = Integer.MIN_VALUE;
        this.Os = agh;
        this.aGH = i;
        this.ui = i2;
        this.MGA = i3;
        Context eli = eli.eli();
        if (eli != null) {
            this.DbA = nGm.Os(eli);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.dV.aGH
    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
        JSONObject jSONObject;
        com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel = this.Os.generatorModel();
        generatorModel.eli(BuildConfig.VERSION_NAME);
        generatorModel.eli(this.aGH);
        generatorModel.DbA(this.ui);
        generatorModel.Os(this.MGA);
        generatorModel.DbA(this.eli);
        generatorModel.MGA(FC.DbA().kb());
        generatorModel.aGH(nn.aGH());
        String Os = generatorModel.Os();
        String NU = generatorModel.NU();
        if (this.DbA != Integer.MIN_VALUE && ("get_ad".equals(Os) || "dislike".equals(Os) || "stats".equals(Os))) {
            try {
                if (TextUtils.isEmpty(NU)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(NU);
                }
                jSONObject.put("nt", this.DbA);
                generatorModel.kb(jSONObject.toString());
            } catch (JSONException unused) {
            }
        }
        return generatorModel;
    }
}
