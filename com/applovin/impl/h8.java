package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class h8 {

    /* renamed from: a, reason: collision with root package name */
    private final String f479a;
    private final String b;
    private final List c;

    public h8(JSONObject jSONObject) {
        this.f479a = JsonUtils.getString(jSONObject, "user_type", "all");
        this.b = JsonUtils.getString(jSONObject, "device_type", "all");
        this.c = JsonUtils.getStringList(jSONObject, "segments", null);
    }

    public String a() {
        return this.f479a;
    }

    public String b() {
        return this.b;
    }

    public List c() {
        return this.c;
    }
}
