package com.bytedance.sdk.openadsdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH {
    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str, "convert_track", jSONObject);
    }
}
