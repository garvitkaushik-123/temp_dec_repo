package com.ironsource;

import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.u8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3331u8 implements F7 {
    @Override // com.ironsource.F7
    public String a(Map<String, Object> map) {
        try {
            return String.format("%s=%s", "data", Base64.encodeToString(new JSONObject().put(D5.Q, D5.R).put("data", new JSONObject(map)).toString().getBytes(), 2));
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }
}
