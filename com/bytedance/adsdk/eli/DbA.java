package com.bytedance.adsdk.eli;

import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA implements wC {
    @Override // com.bytedance.adsdk.eli.wC
    public Object eli(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        String valueOf = String.valueOf(objArr[0]);
        if (TextUtils.isEmpty(valueOf)) {
            return null;
        }
        return Uri.decode(valueOf);
    }
}
