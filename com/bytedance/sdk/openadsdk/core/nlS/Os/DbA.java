package com.bytedance.sdk.openadsdk.core.nlS.Os;

import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    public static void eli(ev evVar) {
        if (KM.DbA(evVar)) {
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, "playable_preload", "preload_start", (JSONObject) null);
        }
    }

    public static void eli(ev evVar, long j, long j2) {
        if (evVar != null) {
            if (KM.Os(evVar) || KM.DbA(evVar)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loadzip_success_time", j);
                    jSONObject.put("unzip_success_time", j2);
                } catch (JSONException e) {
                    Xb.eli("PlayableEvent", "onSuccess json error", e);
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, "playable_preload", "preload_success", jSONObject);
            }
        }
    }

    public static void eli(ev evVar, int i, String str) {
        if (evVar != null) {
            if (KM.Os(evVar) || KM.DbA(evVar)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                    jSONObject.put("error_reason", str);
                } catch (JSONException e) {
                    Xb.eli("PlayableEvent", "onFail json error", e);
                }
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, "playable_preload", "preload_fail", jSONObject);
            }
        }
    }
}
