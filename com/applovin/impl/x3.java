package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class x3 {

    /* renamed from: a, reason: collision with root package name */
    private final String f782a;
    private final String b;

    public x3(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        this.f782a = JsonUtils.getString(jSONObject, "id", "");
        this.b = JsonUtils.getString(jSONObject, "price", null);
    }

    public String a() {
        return this.f782a;
    }

    public String b() {
        return this.b;
    }
}
