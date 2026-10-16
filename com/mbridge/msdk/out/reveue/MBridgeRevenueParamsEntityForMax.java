package com.mbridge.msdk.out.reveue;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MBridgeRevenueParamsEntityForMax extends MBridgeRevenueParamsEntity {
    public MBridgeRevenueParamsEntityForMax(String str, String str2) {
        super(str, str2);
        setMediationName("Max");
    }

    @Override // com.mbridge.msdk.out.reveue.MBridgeRevenueParamsEntity
    public void setDspInfo(String str, String str2) {
        super.setDspInfo(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008e, code lost:
    
        setBidType(java.lang.Boolean.valueOf(r3.optBoolean("isBidding", false)));
        r0 = r3.optJSONArray("credentials");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a1, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a7, code lost:
    
        if (r0.length() <= 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a9, code lost:
    
        r0 = r0.optJSONObject(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00af, code lost:
    
        r1 = new org.json.JSONObject();
        r2 = r0.keys();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bc, code lost:
    
        if (r2.hasNext() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00be, code lost:
    
        r3 = r2.next();
        r1.put(r3, r0.get(r3) + "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00dd, code lost:
    
        setNetworkInfo(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setMaxAdInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str.replace("MediatedAd", "").replace(C3040d4.i.b, ":").replace(" ", ""));
                setAdType(jSONObject.optString("format"));
                setMediationUnitId(jSONObject.optString("adUnitId"));
                setNetworkName(jSONObject.optString("networkName"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONArray optJSONArray = new JSONObject(str2.replace("MaxAdWaterfallInfo", "").replace("MaxResponseInfo", "").replace("MaxMediatedNetworkInfo", "").replace("Bundle", "").replace(C3040d4.i.b, ":").replace(" ", "")).optJSONArray("networkResponses");
                if (optJSONArray != null) {
                    int i = 0;
                    while (true) {
                        if (i >= optJSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2.optString("adLoadState", "").equals("AD_LOADED")) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        setSourceData(str, str2);
    }

    public void setMaxRevenueInfo(String str, Double d) {
        setRevenue(d + "");
        setPrecision(str + "");
    }
}
