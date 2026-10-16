package com.bytedance.adsdk.eli;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb implements wC {
    @Override // com.bytedance.adsdk.eli.wC
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public Boolean eli(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
