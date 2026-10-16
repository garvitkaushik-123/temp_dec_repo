package com.bytedance.sdk.openadsdk.core.kb;

import com.bytedance.sdk.component.kb.DbA.aGH;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    public static void eli(String str, long j) {
        JSONObject DbA = DbA(str, j);
        aGH DbA2 = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().DbA();
        DbA2.DbA(dZ.aGH("/api/ad/union/sdk/stats/"));
        DbA2.aGH(DbA.toString());
        DbA2.eli(6);
        DbA2.eli("uploadFrequentEvent");
        DbA2.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.kb.Os.1
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                iOException.getMessage();
                if (os != null) {
                    bf.eli(os.aGH());
                }
            }
        });
    }

    private static JSONObject DbA(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
