package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.ironsource.C2995ad;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f8 {

    /* renamed from: a, reason: collision with root package name */
    private final r2 f459a;
    private final x3 b;
    private final List c;

    public f8(JSONObject jSONObject, MaxAdFormat maxAdFormat, b3 b3Var, com.applovin.impl.sdk.k kVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "bidder_placement", (JSONObject) null);
        if (jSONObject2 != null) {
            this.b = new x3(jSONObject2, kVar);
        } else {
            this.b = null;
        }
        this.f459a = new r2(JsonUtils.getString(jSONObject, "name", ""), JsonUtils.getString(jSONObject, "display_name", ""), jSONObject2 != null, b3Var);
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, C2995ad.c, new JSONArray());
        this.c = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject3 != null) {
                this.c.add(new x3(jSONObject3, kVar));
            }
        }
    }

    public x3 a() {
        return this.b;
    }

    public r2 b() {
        return this.f459a;
    }

    public List c() {
        return this.c;
    }

    public boolean d() {
        return this.b != null;
    }
}
