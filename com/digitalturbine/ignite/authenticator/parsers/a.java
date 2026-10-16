package com.digitalturbine.ignite.authenticator.parsers;

import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class a {
    public static com.digitalturbine.ignite.authenticator.entities.a a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        String str = "";
        boolean z = false;
        try {
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                String optString = optJSONObject.optString("igniteVersion", "");
                try {
                    if (optJSONObject.has(AdaptiveRenderingConfig.NATIVE_FEATURES_KEY) && (optJSONArray = optJSONObject.optJSONArray(AdaptiveRenderingConfig.NATIVE_FEATURES_KEY)) != null) {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(length);
                            if (optJSONObject2.has("type") && "GET_PROPERTY".equalsIgnoreCase(optJSONObject2.optString("type", ""))) {
                                str = optString;
                                z = true;
                                break;
                            }
                        }
                    }
                    str = optString;
                } catch (Exception e) {
                    e = e;
                    str = optString;
                    com.digitalturbine.ignite.authenticator.logger.a.b("IgniteVersionParser: exception on parse: %s", e.getMessage());
                    return new com.digitalturbine.ignite.authenticator.entities.a(z, str);
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return new com.digitalturbine.ignite.authenticator.entities.a(z, str);
    }
}
