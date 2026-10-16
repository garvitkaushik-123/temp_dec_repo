package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class v0 extends u0 {
    public v0(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        super(jSONObject, kVar);
    }

    public List d() {
        w0 a2;
        JSONArray jSONArray = JsonUtils.getJSONArray(this.b, "transitions", null);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject != null && (a2 = w0.a(jSONObject, this.f744a)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    public String e() {
        return b(PglCryptUtils.KEY_MESSAGE);
    }

    public String f() {
        return b("title");
    }

    @Override // com.applovin.impl.u0
    public String toString() {
        return "ConsentFlowState{id=" + b() + ", type=" + c() + ", title=" + f() + ", message=" + e() + ", actions=" + d() + "}";
    }
}
