package com.bytedance.adsdk.eli;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui implements wC {
    @Override // com.bytedance.adsdk.eli.wC
    public Object eli(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String valueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(valueOf) && !TextUtils.equals(valueOf, "null")) {
                    return valueOf;
                }
            }
        }
        return null;
    }
}
