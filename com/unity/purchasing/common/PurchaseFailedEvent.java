package com.unity.purchasing.common;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class PurchaseFailedEvent {
    public static String jsonEncodePurchaseFailure(String str, PurchaseFailureReason purchaseFailureReason, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(InAppPurchaseMetaData.KEY_PRODUCT_ID, str);
            jSONObject.put("reason", purchaseFailureReason);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str2);
            return jSONObject.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
