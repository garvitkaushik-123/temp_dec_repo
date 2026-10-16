package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.ironsource.C3133ic;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeRevenueParamsEntityForTradPlus extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForTradPlus(String str, String str2) {
        super(str, str2);
        setMediationName("TradPlus");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }

    public void setTradPlusAdInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String replace = str.replace("\"", "\\\"").replace("----------------------\n", "{\"").replaceAll("(?<!\"):(?!\")", "\":\"").replace("\n", "\",\"");
                JSONObject jSONObject = new JSONObject(replace.endsWith("\"") ? (replace + "}").replace(",\"}", "}") : replace + "\"}");
                setAdType(jSONObject.optInt("placementAdType") + "");
                setMediationUnitId(jSONObject.optString("tpAdUnitId"));
                setNetworkName(jSONObject.optString(C3133ic.f3361a));
                setBidType(Boolean.valueOf(jSONObject.optBoolean("isBiddingNetwork", false)));
                setRevenue(jSONObject.optString("ecpm", ""));
                setPrecision(jSONObject.optString("ecpmPrecision", ""));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("instanceName", jSONObject.optString(C3133ic.f3361a, ""));
                jSONObject2.put("instanceId", jSONObject.optString("adSourceId", ""));
                setNetworkInfo(jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setSourceData(str, str);
    }
}
