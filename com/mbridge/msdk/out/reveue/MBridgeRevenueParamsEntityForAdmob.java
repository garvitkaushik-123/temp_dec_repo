package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeRevenueParamsEntityForAdmob extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForAdmob(String str, String str2) {
        super(str, str2);
        setMediationName("Admob");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setAdType(String str) {
        super.setAdType(str);
    }

    public void setAdmobResponseInfo(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            setSourceData(str, str);
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("Loaded Adapter Response");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("Credentials");
                if (optJSONObject2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    Iterator<String> keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, optJSONObject2.get(next) + "");
                    }
                    setNetworkInfo(jSONObject);
                }
                setNetworkName(optJSONObject.optString("Ad Source Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAdmobRevenueInfo(int i, long j, String str) {
        setRevenue(j + "");
        setPrecision(i + "");
        setCurrency(str);
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }
}
