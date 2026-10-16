package com.bytedance.adsdk.eli;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA implements wC {
    @Override // com.bytedance.adsdk.eli.wC
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public String eli(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(valueOf);
            String valueOf2 = String.valueOf(objArr[1]);
            if (TextUtils.isEmpty(valueOf2)) {
                return null;
            }
            Object eli = com.bytedance.adsdk.eli.DbA.eli.eli(valueOf2).eli(jSONObject2);
            if (TextUtils.isEmpty(String.valueOf(eli))) {
                if (objArr.length >= 3) {
                    return String.valueOf(objArr[2]);
                }
                return null;
            }
            return String.valueOf(eli);
        } catch (JSONException unused) {
            return null;
        }
    }
}
