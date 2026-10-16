package com.bytedance.sdk.component.eli;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Dfc {
    private final Map<String, Object> eli = new ConcurrentHashMap();

    public static Dfc eli() {
        return new Dfc();
    }

    private Dfc() {
    }

    public Dfc eli(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.eli.put(str, obj);
        }
        return this;
    }

    public String DbA() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.eli.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
