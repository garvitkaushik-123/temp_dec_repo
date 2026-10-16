package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs {
    private List<String> DbA;
    private String eli;

    public aAs(String str) {
        this.eli = "";
        this.DbA = new ArrayList();
        HashMap<String, Object> hashMap = TextUtils.isEmpty(str) ? new HashMap<>() : eli(str);
        try {
            this.eli = (String) hashMap.get("auto_test_param");
            JSONArray jSONArray = new JSONArray((String) hashMap.get("auto_test_hosts"));
            this.DbA = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.DbA.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("AutoTestModel", e.getMessage());
        }
    }

    public String eli() {
        return this.eli;
    }

    public List<String> DbA() {
        return this.DbA;
    }

    private static final HashMap<String, Object> eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("name"), optJSONObject.optString("value"));
            }
            return hashMap;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }
}
